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

        boolean isDiagonalXZ = random.nextBoolean();
        Direction secondaryLeanDirection = random.nextBoolean() ? leanDirection.getClockWise() : leanDirection.getCounterClockWise();

        List<Integer> segments = new ArrayList<>();
        int remainingHeight = config.trunkPlacer.getTreeHeight(random);

        if (shouldLean) {
            int currentSegmentHeight = Math.max(2, remainingHeight / 2);

            while (remainingHeight > 0) {
                if (remainingHeight <= 3) {
                    segments.add(remainingHeight);
                    break;
                }

                int segment = Math.min(currentSegmentHeight, remainingHeight);

                if (remainingHeight - segment == 1) {
                    segment--;
                }

                segments.add(segment);
                remainingHeight -= segment;

                currentSegmentHeight -= (random.nextBoolean() ? 1 : 2);
                if (currentSegmentHeight < 2) {
                    currentSegmentHeight = 2;
                }
            }
        } else {
            segments.add(remainingHeight);
        }

        BlockPos.MutableBlockPos currentTrunkPos = origin.mutable();
        for (int i = 0; i < segments.size(); i++) {
            int segmentHeight = segments.get(i);

            for (int height = 0; height < segmentHeight; height++) {
                info.addLog(currentTrunkPos);
                currentTrunkPos.move(Direction.UP);
            }

            if (shouldLean && i < segments.size() - 1) {
                currentTrunkPos.move(leanDirection);
                if (isDiagonalXZ) {
                    currentTrunkPos.move(secondaryLeanDirection);
                }
            }
        }

        BlockPos canopyCenter = currentTrunkPos.immutable();
        generatePalmFoliage(info, random, canopyCenter);
    }

    private void generatePalmFoliage(TreeInfo info, RandomSource random, BlockPos center) {
        BlockPos base = center.below();

        info.addFoliage(center);
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                info.addFoliage(center.offset(x, 0, z));
            }
        }

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            generateCardinalFrond(info, random, base, direction);
            generateDiagonalFrond(info, random, base, direction, direction.getClockWise());
        }
    }

    private void generateCardinalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction direction) {
        Direction left = direction.getCounterClockWise();
        Direction right = direction.getClockWise();

        BlockPos pos1 = base.relative(direction);
        info.addFoliage(pos1);

        BlockPos pos2 = pos1.relative(direction);
        info.addFoliage(pos2);

        info.addFoliage(pos2.relative(left));
        info.addFoliage(pos2.relative(right));

        BlockPos pos3 = pos2.relative(direction);
        info.addFoliage(pos3);

        BlockPos pos4 = pos3.below();
        info.addFoliage(pos4);
        if (random.nextBoolean()) {
            info.addFoliage(pos4.relative(left));
        }
        if (random.nextBoolean()) {
            info.addFoliage(pos4.relative(right));
        }

        BlockPos pos5 = pos4.relative(direction);
        info.addFoliage(pos5);

        if (random.nextBoolean()) {
            BlockPos pos6 = pos5.below();
            info.addFoliage(pos6);
        }
    }

    private void generateDiagonalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction dir1, Direction dir2) {
        BlockPos pos1 = base.relative(dir1).relative(dir2);
        info.addFoliage(pos1);

        BlockPos pos2 = pos1.relative(dir1).relative(dir2);
        info.addFoliage(pos2);

        info.addFoliage(pos2.relative(dir1.getOpposite()));
        info.addFoliage(pos2.relative(dir2.getOpposite()));

        BlockPos pos3 = pos2.below();
        info.addFoliage(pos3);

        if (random.nextBoolean()) {
            BlockPos pos4 = pos3.below();
            info.addFoliage(pos4);
        }
    }
}