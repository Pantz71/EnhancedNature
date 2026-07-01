package pantz.enhanced_nature.core.registry;

import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.ENProperties;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;

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
    public static final DeferredBlock<Block> CHISELED_PACKED_ICE_BRICKS = BLOCKS.createBlock("packed_ice_brick_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> PACKED_ICE_DOOR = BLOCKS.createBlock("packed_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_TRAPDOOR = BLOCKS.createBlock("packed_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = BLOCKS.createBlock("blue_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_STAIRS = BLOCKS.createBlock("blue_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_SLAB = BLOCKS.createBlock("blue_ice_brick_slab", () -> new SlabBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_WALL = BLOCKS.createBlock("blue_ice_brick_wall", () -> new WallBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> CHISELED_BLUE_ICE_BRICKS = BLOCKS.createBlock("blue_ice_brick_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> BLUE_ICE_DOOR = BLOCKS.createBlock("blue_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_TRAPDOOR = BLOCKS.createBlock("blue_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));

    public static void setupTabs() {
		CreativeModeTabContentsPopulator.mod(EnhancedNature.MOD_ID);
	}
}
