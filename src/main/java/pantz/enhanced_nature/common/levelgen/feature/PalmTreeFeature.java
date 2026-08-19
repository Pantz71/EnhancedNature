package pantz.enhanced_nature.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.common.levelgen.feature.BlueprintTreeFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import pantz.enhanced_nature.core.registry.ENBlocks;

import java.util.ArrayList;
import java.util.List;

public class PalmTreeFeature extends BlueprintTreeFeature {
    public PalmTreeFeature(Codec<TreeConfiguration> config) {
        super(false, config);
    }

    @Override
    public BlockState getSapling() {
        return ENBlocks.PALM_SAPLING.get().defaultBlockState();
    }

    @Override
    public void doPlace(FeaturePlaceContext<TreeConfiguration> context, TreeInfo info) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        TreeConfiguration config = context.config();

        boolean shouldLean = random.nextFloat() < 0.90F;
        Direction leanDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        boolean diagonal = random.nextBoolean();
        Direction secondaryLeanDirection = diagonal ? (random.nextBoolean() ? leanDirection.getClockWise() : leanDirection.getCounterClockWise()) : null;
        int remainingHeight = config.trunkPlacer.getTreeHeight(random);

        List<Integer> segments = shouldLean ? buildTrunk(remainingHeight, random) : List.of(remainingHeight);
        BlockPos.MutableBlockPos trunkPos = origin.mutable();
        for (int i = 0; i < segments.size(); i++) {
            placeLogs(info, trunkPos, segments.get(i));
            if (shouldLean && i < segments.size() - 1) {
                leanOffset(trunkPos, leanDirection, secondaryLeanDirection);
            }
        }
        generatePalmFoliage(info, random, trunkPos.immutable());
    }

    private List<Integer> buildTrunk(int remaining, RandomSource random) {
        List<Integer> segments = new ArrayList<>();
        int currentSegment = Math.max(2, remaining / 2);

        while (remaining > 0) {
            if (remaining <= 3) {
                segments.add(remaining);
                break;
            }

            int segment = Math.min(currentSegment, remaining);
            if (remaining - segment == 1) segment--;

            segments.add(segment);
            remaining -= segment;
            currentSegment = Math.max(2, currentSegment - (random.nextBoolean() ? 1 : 2));
        }
        return segments;
    }

    private void placeLogs(TreeInfo info, BlockPos.MutableBlockPos pos, int height) {
        for (int h = 0; h < height; h++) {
            info.addLog(pos);
            pos.move(Direction.UP);
        }
    }

    private void leanOffset(BlockPos.MutableBlockPos pos, Direction primary, Direction secondary) {
        pos.move(primary);
        if (secondary != null) {
            pos.move(secondary);
        }
    }

    private void generatePalmFoliage(TreeInfo info, RandomSource random, BlockPos center) {
        BlockPos base = center.below();

        info.addFoliage(center);
        BlockPos.betweenClosedStream(center.offset(-1, 0, -1), center.offset(1, 0, 1)).forEach(info::addFoliage);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            generateCardinalFrond(info, random, base, direction);
            generateDiagonalFrond(info, random, base, direction, direction.getClockWise());
        }
    }

    private void generateCardinalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction direction) {
        Direction left = direction.getCounterClockWise();
        Direction right = direction.getClockWise();

        BlockPos pos1 = base.relative(direction);
        BlockPos pos2 = pos1.relative(direction);
        BlockPos pos3 = pos2.relative(direction);
        BlockPos pos4 = pos3.below();

        addFoliage(info, pos1, pos2, pos2.relative(left), pos2.relative(right), pos3, pos4, pos4.relative(direction));
        addFoliage(info, random, pos4.relative(left), pos4.relative(right), pos4.relative(direction).below());
    }

    private void generateDiagonalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction dir1, Direction dir2) {
        BlockPos pos1 = base.relative(dir1).relative(dir2);
        BlockPos pos2 = pos1.relative(dir1).relative(dir2);
        BlockPos below = pos2.below();

        addFoliage(info, pos1, pos2, pos2.relative(dir1.getOpposite()), pos2.relative(dir2.getOpposite()), below);
        addFoliage(info, random, below.below());
    }

    private void addFoliage(TreeInfo info, BlockPos... pos) {
        for (BlockPos pos1 : pos) {
            info.addFoliage(pos1);
        }
    }

    private void addFoliage(TreeInfo info, RandomSource random, BlockPos... pos) {
        for (BlockPos pos1 : pos) {
            if (random.nextBoolean()) {
                info.addFoliage(pos1);
            }
        }
    }
}