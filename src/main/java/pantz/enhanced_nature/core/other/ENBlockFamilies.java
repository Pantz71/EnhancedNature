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

    public static final BlockFamily BLUE_GRANITE_FAMILY = new BlockFamily.Builder(BLUE_GRANITE.get()).stairs(BLUE_GRANITE_STAIRS.get()).slab(BLUE_GRANITE_SLAB.get()).wall(BLUE_GRANITE_WALL.get()).getFamily();
    public static final BlockFamily POLISHED_BLUE_GRANITE_FAMILY = new BlockFamily.Builder(POLISHED_BLUE_GRANITE.get()).stairs(POLISHED_BLUE_GRANITE_STAIRS.get()).slab(POLISHED_BLUE_GRANITE_SLAB.get()).wall(POLISHED_BLUE_GRANITE_WALL.get()).chiseled(CHISELED_POLISHED_BLUE_GRANITE.get()).getFamily();
    public static final BlockFamily BLUE_GRANITE_BRICKS_FAMILY = new BlockFamily.Builder(BLUE_GRANITE_BRICKS.get()).stairs(BLUE_GRANITE_BRICK_STAIRS.get()).slab(BLUE_GRANITE_BRICK_SLAB.get()).wall(BLUE_GRANITE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily BLUE_GRANITE_TILES_FAMILY = new BlockFamily.Builder(BLUE_GRANITE_TILES.get()).stairs(BLUE_GRANITE_TILE_STAIRS.get()).slab(BLUE_GRANITE_TILE_SLAB.get()).wall(BLUE_GRANITE_TILE_WALL.get()).getFamily();

    public static final BlockFamily PALM_PLANKS_FAMILY = new BlockFamily.Builder(PALM_PLANKS.get()).button(PALM_BUTTON.get()).fence(PALM_FENCE.get()).fenceGate(PALM_FENCE_GATE.get()).pressurePlate(PALM_PRESSURE_PLATE.get()).sign(PALM_SIGNS.getFirst().get(), PALM_SIGNS.getSecond().get()).slab(PALM_SLAB.get()).stairs(PALM_STAIRS.get()).door(PALM_DOOR.get()).trapdoor(PALM_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();


}
