package pantz.enhanced_nature.core.other;

import net.minecraft.data.BlockFamily;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENBlockFamilies {
    public static final BlockFamily SNOW_BRICKS_FAMILY = new BlockFamily.Builder(SNOW_BRICKS.get()).stairs(SNOW_BRICK_STAIRS.get()).slab(SNOW_BRICK_SLAB.get()).wall(SNOW_BRICK_WALL.get()).getFamily();
    public static final BlockFamily PACKED_ICE_BRICKS_FAMILY = new BlockFamily.Builder(PACKED_ICE_BRICKS.get()).stairs(PACKED_ICE_BRICK_STAIRS.get()).slab(PACKED_ICE_BRICK_SLAB.get()).wall(PACKED_ICE_BRICK_WALL.get()).chiseled(CHISELED_PACKED_ICE_BRICKS.get()).getFamily();
    public static final BlockFamily BLUE_ICE_BRICKS_FAMILY = new BlockFamily.Builder(BLUE_ICE_BRICKS.get()).stairs(BLUE_ICE_BRICK_STAIRS.get()).slab(BLUE_ICE_BRICK_SLAB.get()).wall(BLUE_ICE_BRICK_WALL.get()).chiseled(CHISELED_BLUE_ICE_BRICKS.get()).getFamily();
}
