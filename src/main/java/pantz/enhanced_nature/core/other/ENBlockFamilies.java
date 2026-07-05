package pantz.enhanced_nature.core.other;

import net.minecraft.data.BlockFamily;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENBlockFamilies {
    public static final BlockFamily SNOW_BRICKS_FAMILY = new BlockFamily.Builder(SNOW_BRICKS.get()).stairs(SNOW_BRICK_STAIRS.get()).slab(SNOW_BRICK_SLAB.get()).wall(SNOW_BRICK_WALL.get()).getFamily();
    public static final BlockFamily PACKED_ICE_BRICKS_FAMILY = new BlockFamily.Builder(PACKED_ICE_BRICKS.get()).stairs(PACKED_ICE_BRICK_STAIRS.get()).slab(PACKED_ICE_BRICK_SLAB.get()).wall(PACKED_ICE_BRICK_WALL.get()).chiseled(CHISELED_PACKED_ICE_BRICKS.get()).getFamily();
    public static final BlockFamily BLUE_ICE_BRICKS_FAMILY = new BlockFamily.Builder(BLUE_ICE_BRICKS.get()).stairs(BLUE_ICE_BRICK_STAIRS.get()).slab(BLUE_ICE_BRICK_SLAB.get()).wall(BLUE_ICE_BRICK_WALL.get()).chiseled(CHISELED_BLUE_ICE_BRICKS.get()).getFamily();
    public static final BlockFamily LIMESTONE_FAMILY = new BlockFamily.Builder(LIMESTONE.get()).stairs(LIMESTONE_STAIRS.get()).slab(LIMESTONE_SLAB.get()).wall(LIMESTONE_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_LIMESTONE_FAMILY = new BlockFamily.Builder(POLISHED_LIMESTONE.get()).stairs(POLISHED_LIMESTONE_STAIRS.get()).slab(POLISHED_LIMESTONE_SLAB.get()).wall(POLISHED_LIMESTONE_WALL.get()).chiseled(CHISELED_POLISHED_LIMESTONE.get()).getFamily();
    public static final BlockFamily LIMESTONE_BRICKS_FAMILY = new BlockFamily.Builder(LIMESTONE_BRICKS.get()).stairs(LIMESTONE_BRICK_STAIRS.get()).slab(LIMESTONE_BRICK_SLAB.get()).wall(LIMESTONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily LIMESTONE_TILES_FAMILY = new BlockFamily.Builder(LIMESTONE_TILES.get()).stairs(LIMESTONE_TILE_STAIRS.get()).slab(LIMESTONE_TILE_SLAB.get()).wall(LIMESTONE_TILE_WALL.get()).getFamily();


}
