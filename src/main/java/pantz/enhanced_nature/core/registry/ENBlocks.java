package pantz.enhanced_nature.core.registry;

import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.ENProperties;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

public class ENBlocks {
	public static final BlockSubRegistryHelper BLOCKS = EnhancedNature.REGISTRY_HELPER.getBlockSubHelper();

    public static final DeferredBlock<Block> SNOW_BRICKS = BLOCKS.createBlock("snow_bricks", () -> new Block(ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_STAIRS = BLOCKS.createBlock("snow_brick_stairs", () -> new StairBlock(SNOW_BRICKS.get().defaultBlockState(), ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_SLAB = BLOCKS.createBlock("snow_brick_slab", () -> new SlabBlock(ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_WALL = BLOCKS.createBlock("snow_brick_wall", () -> new WallBlock(ENProperties.SNOW_BRICKS));

    public static final DeferredBlock<Block> PACKED_ICE_BRICKS = BLOCKS.createBlock("packed_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_STAIRS = BLOCKS.createBlock("packed_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_SLAB = BLOCKS.createBlock("packed_ice_brick_slab", () -> new SlabBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_WALL = BLOCKS.createBlock("packed_ice_brick_wall", () -> new WallBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> CHISELED_PACKED_ICE_BRICKS = BLOCKS.createBlock("chiseled_packed_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> PACKED_ICE_DOOR = BLOCKS.createBlock("packed_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_TRAPDOOR = BLOCKS.createBlock("packed_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = BLOCKS.createBlock("blue_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_STAIRS = BLOCKS.createBlock("blue_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_SLAB = BLOCKS.createBlock("blue_ice_brick_slab", () -> new SlabBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_WALL = BLOCKS.createBlock("blue_ice_brick_wall", () -> new WallBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> CHISELED_BLUE_ICE_BRICKS = BLOCKS.createBlock("chiseled_blue_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> BLUE_ICE_DOOR = BLOCKS.createBlock("blue_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_TRAPDOOR = BLOCKS.createBlock("blue_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> LIMESTONE = BLOCKS.createBlock("limestone", () -> new Block(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_STAIRS = BLOCKS.createBlock("limestone_stairs", () -> new StairBlock(LIMESTONE.get().defaultBlockState(), ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_SLAB = BLOCKS.createBlock("limestone_slab", () -> new SlabBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_WALL = BLOCKS.createBlock("limestone_wall", () -> new WallBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_PILLAR = BLOCKS.createBlock("limestone_pillar", () -> new RotatedPillarBlock(ENProperties.LIMESTONE));

    public static final DeferredBlock<Block> POLISHED_LIMESTONE = BLOCKS.createBlock("polished_limestone", () -> new Block(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_STAIRS = BLOCKS.createBlock("polished_limestone_stairs", () -> new StairBlock(POLISHED_LIMESTONE.get().defaultBlockState(), ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_SLAB = BLOCKS.createBlock("polished_limestone_slab", () -> new SlabBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> POLISHED_LIMESTONE_WALL = BLOCKS.createBlock("polished_limestone_wall", () -> new WallBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> CHISELED_POLISHED_LIMESTONE = BLOCKS.createBlock("chiseled_polished_limestone", () -> new Block(ENProperties.LIMESTONE));

    public static final DeferredBlock<Block> LIMESTONE_BRICKS = BLOCKS.createBlock("limestone_bricks", () -> new Block(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_BRICK_STAIRS = BLOCKS.createBlock("limestone_brick_stairs", () -> new StairBlock(LIMESTONE_BRICKS.get().defaultBlockState(), ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_BRICK_SLAB = BLOCKS.createBlock("limestone_brick_slab", () -> new SlabBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_BRICK_WALL = BLOCKS.createBlock("limestone_brick_wall", () -> new WallBlock(ENProperties.LIMESTONE));

    public static final DeferredBlock<Block> LIMESTONE_TILES = BLOCKS.createBlock("limestone_tiles", () -> new Block(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_TILE_STAIRS = BLOCKS.createBlock("limestone_tile_stairs", () -> new StairBlock(LIMESTONE_TILES.get().defaultBlockState(), ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_TILE_SLAB = BLOCKS.createBlock("limestone_tile_slab", () -> new SlabBlock(ENProperties.LIMESTONE));
    public static final DeferredBlock<Block> LIMESTONE_TILE_WALL = BLOCKS.createBlock("limestone_tile_wall", () -> new WallBlock(ENProperties.LIMESTONE));

    public static void setupTabs() {
		CreativeModeTabContentsPopulator.mod(EnhancedNature.MOD_ID)
                .tab(BUILDING_BLOCKS)
                .addItemsBefore(of(Blocks.NETHERRACK), SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL, () -> Blocks.PACKED_ICE, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, CHISELED_PACKED_ICE_BRICKS, PACKED_ICE_DOOR, PACKED_ICE_TRAPDOOR,
                        () -> Blocks.BLUE_ICE, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, CHISELED_BLUE_ICE_BRICKS, BLUE_ICE_DOOR, BLUE_ICE_TRAPDOOR)
                .addItemsBefore(of(Blocks.CALCITE), LIMESTONE, LIMESTONE_STAIRS, LIMESTONE_SLAB, LIMESTONE_WALL, POLISHED_LIMESTONE, POLISHED_LIMESTONE_STAIRS, POLISHED_LIMESTONE_SLAB)
                .addItemsBefore(modLoaded(Blocks.CALCITE), POLISHED_LIMESTONE_WALL, CHISELED_POLISHED_LIMESTONE, LIMESTONE_BRICKS, LIMESTONE_BRICK_STAIRS, LIMESTONE_BRICK_SLAB, LIMESTONE_BRICK_WALL, LIMESTONE_PILLAR, LIMESTONE_TILES, LIMESTONE_TILE_STAIRS, LIMESTONE_TILE_SLAB, LIMESTONE_TILE_WALL)

                .tab(NATURAL_BLOCKS)
                .addItemsBefore(of(Blocks.CALCITE), LIMESTONE)
        ;

    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }
}
