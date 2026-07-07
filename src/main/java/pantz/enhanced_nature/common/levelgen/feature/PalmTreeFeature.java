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
        super(config);
    }

    @Override
    public BlockState getSapling() {
        return ENBlocks.PALM_SAPLING.get().defaultBlockState();
    }

    @Override
    public void doPlace(FeaturePlaceContext<TreeConfiguration> context, TreeInfo info) {
        RandomSource random = context.random();
        BlockPos origin = context.origin();

        boolean isDiagonal = random.nextFloat() < 0.90F;
        Direction leanDirection = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        List<Integer> segments = new ArrayList<>();
        if (isDiagonal) {
            int currentSegmentHeight = random.nextInt(3) + 5;
            while (currentSegmentHeight >= 2) {
                segments.add(currentSegmentHeight);
                currentSegmentHeight -= (random.nextBoolean() ? 1 : 2);
            }
        } else {
            segments.add(random.nextInt(4) + 10);
        }

        BlockPos.MutableBlockPos currentTrunkPos = origin.mutable();
        for (int i = 0; i < segments.size(); i++) {
            int segmentHeight = segments.get(i);

            for (int h = 0; h < segmentHeight; h++) {
                info.addLog(currentTrunkPos);
                currentTrunkPos.move(Direction.UP);
            }

            if (isDiagonal && i < segments.size() - 1) {
                currentTrunkPos.move(leanDirection);
            }
        }

        BlockPos canopyCenter = currentTrunkPos.immutable();
        generatePalmFoliage(info, random, canopyCenter);
    }

    private void generatePalmFoliage(TreeInfo info, RandomSource random, BlockPos center) {
        // Base anchors directly to the top log of the trunk
        BlockPos base = center.below();

        // 1. Top Crown Cross (center.above())
        info.addFoliage(base.above());
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            info.addFoliage(base.above().relative(dir));
        }

        // 2. 8-Directional Cascading Fronds
        for (Direction dir : Direction.Plane.HORIZONTAL) {
            generateCardinalFrond(info, random, base, dir);
            generateDiagonalFrond(info, random, base, dir, dir.getClockWise());
        }
    }

    private void generateCardinalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction dir) {
        Direction left = dir.getCounterClockWise();
        Direction right = dir.getClockWise();

        // Step 1: Out 1
        BlockPos p1 = base.relative(dir);
        info.addFoliage(p1);

        // Step 2: Out 2 (Add side fluff for a bushy midpoint)
        BlockPos p2 = p1.relative(dir);
        info.addFoliage(p2);
        info.addFoliage(p2.relative(left));
        info.addFoliage(p2.relative(right));

        // Step 3: Out 3, Down 1 (The graceful curve down)
        // FIXED: Placed a bridge block extending outward to connect faces
        BlockPos p3Bridge = p2.relative(dir);
        info.addFoliage(p3Bridge);

        BlockPos p3 = p3Bridge.below(); // Drops down face-connected
        info.addFoliage(p3);
        info.addFoliage(p3.relative(left));
        info.addFoliage(p3.relative(right));

        // Step 4: Out 4, Down 2 (Randomized drooping tip)
        if (random.nextFloat() < 0.75F) {
            // FIXED: Placed a bridge block dropping straight down first
            BlockPos p4Bridge = p3.below();
            info.addFoliage(p4Bridge);

            BlockPos p4 = p4Bridge.relative(dir); // Extends out face-connected
            info.addFoliage(p4);
        }
    }

    private void generateDiagonalFrond(TreeInfo info, RandomSource random, BlockPos base, Direction dir1, Direction dir2) {
        // Step 1: Out 1, Side 1
        BlockPos p1 = base.relative(dir1).relative(dir2);
        info.addFoliage(p1);

        // Step 2: Out 2, Side 2
        BlockPos p2 = p1.relative(dir1).relative(dir2);
        info.addFoliage(p2);

        // Fill out the inner corners of the diagonal so it doesn't look like a thin line
        info.addFoliage(p2.relative(dir1.getOpposite()));
        info.addFoliage(p2.relative(dir2.getOpposite()));

        // Step 3: Droop down 1 block
        BlockPos p3 = p2.below();
        info.addFoliage(p3);

        // Step 4: Deep droop down 2 blocks (Manhattan distance = 6, perfectly safe)
        if (random.nextBoolean()) {
            BlockPos p4 = p3.below();
            info.addFoliage(p4);
        }
    }
}