package pantz.enhanced_nature.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.BlueprintBeehiveBlock;
import com.teamabnormals.blueprint.common.block.LeafPileBlock;
import com.teamabnormals.blueprint.common.block.LogBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintCeilingHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallHangingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import pantz.enhanced_nature.common.block.ChiseledPalmBookShelfBlock;
import pantz.enhanced_nature.common.block.IceLanternBlock;
import pantz.enhanced_nature.common.block.PalmSaplingBlock;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.ENConstants;
import pantz.enhanced_nature.core.other.ENProperties;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.registries.DeferredBlock;
import pantz.enhanced_nature.core.other.ENTreeGrower;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

public class ENBlocks {
	public static final BlockSubRegistryHelper BLOCKS = EnhancedNature.REGISTRY_HELPER.getBlockSubHelper();

    // Snow Bricks
    public static final DeferredBlock<Block> SNOW_BRICKS = BLOCKS.createBlock("snow_bricks", () -> new Block(ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_STAIRS = BLOCKS.createBlock("snow_brick_stairs", () -> new StairBlock(SNOW_BRICKS.get().defaultBlockState(), ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_SLAB = BLOCKS.createBlock("snow_brick_slab", () -> new SlabBlock(ENProperties.SNOW_BRICKS));
    public static final DeferredBlock<Block> SNOW_BRICK_WALL = BLOCKS.createBlock("snow_brick_wall", () -> new WallBlock(ENProperties.SNOW_BRICKS));

    // Packed Ice Bricks
    public static final DeferredBlock<Block> PACKED_ICE_BRICKS = BLOCKS.createBlock("packed_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_STAIRS = BLOCKS.createBlock("packed_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_SLAB = BLOCKS.createBlock("packed_ice_brick_slab", () -> new SlabBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_BRICK_WALL = BLOCKS.createBlock("packed_ice_brick_wall", () -> new WallBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> CHISELED_PACKED_ICE_BRICKS = BLOCKS.createBlock("chiseled_packed_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> PACKED_ICE_DOOR = BLOCKS.createBlock("packed_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> PACKED_ICE_TRAPDOOR = BLOCKS.createBlock("packed_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_BRICKS));

    // Blue Ice Bricks
    public static final DeferredBlock<Block> BLUE_ICE_BRICKS = BLOCKS.createBlock("blue_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_STAIRS = BLOCKS.createBlock("blue_ice_brick_stairs", () -> new StairBlock(PACKED_ICE_BRICKS.get().defaultBlockState(), ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_SLAB = BLOCKS.createBlock("blue_ice_brick_slab", () -> new SlabBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> BLUE_ICE_BRICK_WALL = BLOCKS.createBlock("blue_ice_brick_wall", () -> new WallBlock(ENProperties.ICE_BRICKS));
    public static final DeferredBlock<Block> CHISELED_BLUE_ICE_BRICKS = BLOCKS.createBlock("chiseled_blue_ice_bricks", () -> new Block(ENProperties.ICE_BRICKS));

    public static final DeferredBlock<Block> BLUE_ICE_DOOR = BLOCKS.createBlock("blue_ice_door", () -> new DoorBlock(ENProperties.ICE, ENProperties.ICE_DOOR));
    public static final DeferredBlock<Block> BLUE_ICE_TRAPDOOR = BLOCKS.createBlock("blue_ice_trapdoor", () -> new TrapDoorBlock(ENProperties.ICE, ENProperties.ICE_TRAPDOOR));

    public static final DeferredBlock<Block> ICE_LANTERN = BLOCKS.createBlock("ice_lantern", () -> new IceLanternBlock(ENProperties.ICE_LANTERN));

    // Limestone
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

    // Blue Granite
    public static final DeferredBlock<Block> BLUE_GRANITE = BLOCKS.createBlock("blue_granite", () -> new Block(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_STAIRS = BLOCKS.createBlock("blue_granite_stairs", () -> new StairBlock(BLUE_GRANITE.get().defaultBlockState(), ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_SLAB = BLOCKS.createBlock("blue_granite_slab", () -> new SlabBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_WALL = BLOCKS.createBlock("blue_granite_wall", () -> new WallBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_PILLAR = BLOCKS.createBlock("blue_granite_pillar", () -> new RotatedPillarBlock(ENProperties.BLUE_GRANITE));

    public static final DeferredBlock<Block> POLISHED_BLUE_GRANITE = BLOCKS.createBlock("polished_blue_granite", () -> new Block(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> POLISHED_BLUE_GRANITE_STAIRS = BLOCKS.createBlock("polished_blue_granite_stairs", () -> new StairBlock(POLISHED_BLUE_GRANITE.get().defaultBlockState(), ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> POLISHED_BLUE_GRANITE_SLAB = BLOCKS.createBlock("polished_blue_granite_slab", () -> new SlabBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> POLISHED_BLUE_GRANITE_WALL = BLOCKS.createBlock("polished_blue_granite_wall", () -> new WallBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> CHISELED_POLISHED_BLUE_GRANITE = BLOCKS.createBlock("chiseled_polished_blue_granite", () -> new Block(ENProperties.BLUE_GRANITE));

    public static final DeferredBlock<Block> BLUE_GRANITE_BRICKS = BLOCKS.createBlock("blue_granite_bricks", () -> new Block(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_BRICK_STAIRS = BLOCKS.createBlock("blue_granite_brick_stairs", () -> new StairBlock(BLUE_GRANITE_BRICKS.get().defaultBlockState(), ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_BRICK_SLAB = BLOCKS.createBlock("blue_granite_brick_slab", () -> new SlabBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_BRICK_WALL = BLOCKS.createBlock("blue_granite_brick_wall", () -> new WallBlock(ENProperties.BLUE_GRANITE));

    public static final DeferredBlock<Block> BLUE_GRANITE_TILES = BLOCKS.createBlock("blue_granite_tiles", () -> new Block(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_TILE_STAIRS = BLOCKS.createBlock("blue_granite_tile_stairs", () -> new StairBlock(BLUE_GRANITE_TILES.get().defaultBlockState(), ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_TILE_SLAB = BLOCKS.createBlock("blue_granite_tile_slab", () -> new SlabBlock(ENProperties.BLUE_GRANITE));
    public static final DeferredBlock<Block> BLUE_GRANITE_TILE_WALL = BLOCKS.createBlock("blue_granite_tile_wall", () -> new WallBlock(ENProperties.BLUE_GRANITE));

    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = BLOCKS.createBlock("stripped_palm_log", () -> new RotatedPillarBlock(ENProperties.PALM.log()));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = BLOCKS.createBlock("stripped_palm_wood", () -> new RotatedPillarBlock(ENProperties.PALM.log()));
    public static final DeferredBlock<Block> PALM_LOG = BLOCKS.createBlock("palm_log", () -> new LogBlock(STRIPPED_PALM_LOG, ENProperties.PALM.log()));
    public static final DeferredBlock<Block> PALM_WOOD = BLOCKS.createBlock("palm_wood", () -> new LogBlock(STRIPPED_PALM_WOOD, ENProperties.PALM.log()));
    public static final DeferredBlock<Block> PALM_LEAVES = BLOCKS.createBlock("palm_leaves", () -> new LeavesBlock(ENProperties.PALM.leaves()));
    public static final DeferredBlock<Block> PALM_SAPLING = BLOCKS.createBlock("palm_sapling", () -> new PalmSaplingBlock(ENTreeGrower.PALM, ENProperties.PALM.sapling()));
    public static final DeferredBlock<Block> POTTED_PALM_SAPLING = BLOCKS.createBlockNoItem("potted_palm_sapling", () -> new FlowerPotBlock(PALM_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final DeferredBlock<Block> PALM_PLANKS = BLOCKS.createBlock("palm_planks", () -> new Block(ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_STAIRS = BLOCKS.createBlock("palm_stairs", () -> new StairBlock(PALM_PLANKS.get().defaultBlockState(), ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_SLAB = BLOCKS.createBlock("palm_slab", () -> new SlabBlock(ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_PRESSURE_PLATE = BLOCKS.createBlock("palm_pressure_plate", () -> new PressurePlateBlock(ENProperties.PALM_BLOCK_SET, ENProperties.PALM.pressurePlate()));
    public static final DeferredBlock<Block> PALM_BUTTON = BLOCKS.createBlock("palm_button", () -> new ButtonBlock(ENProperties.PALM_BLOCK_SET, 30, ENProperties.PALM.button()));
    public static final DeferredBlock<Block> PALM_FENCE = BLOCKS.createBlock("palm_fence", () -> new FenceBlock(ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_FENCE_GATE = BLOCKS.createBlock("palm_fence_gate", () -> new FenceGateBlock(ENProperties.PALM_WOOD_TYPE, ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_DOOR = BLOCKS.createBlock("palm_door", () -> new DoorBlock(ENProperties.PALM_BLOCK_SET, ENProperties.PALM.door()));
    public static final DeferredBlock<Block> PALM_TRAPDOOR = BLOCKS.createBlock("palm_trapdoor", () -> new TrapDoorBlock(ENProperties.PALM_BLOCK_SET, ENProperties.PALM.trapdoor()));
    public static final Pair<DeferredBlock<BlueprintStandingSignBlock>, DeferredBlock<BlueprintWallSignBlock>> PALM_SIGNS = BLOCKS.createSignBlock("palm", ENProperties.PALM_WOOD_TYPE, ENProperties.PALM.sign());
    public static final Pair<DeferredBlock<BlueprintCeilingHangingSignBlock>, DeferredBlock<BlueprintWallHangingSignBlock>> PALM_HANGING_SIGNS = BLOCKS.createHangingSignBlock("palm", ENProperties.PALM_WOOD_TYPE, ENProperties.PALM.hangingSign());

    public static final DeferredBlock<Block> PALM_BOARDS = BLOCKS.createBlock("palm_boards", () -> new RotatedPillarBlock(ENProperties.PALM.planks()));
    public static final DeferredBlock<Block> PALM_BOOKSHELF = BLOCKS.createBlock("palm_bookshelf", () -> new Block(ENProperties.PALM.bookshelf()));
    public static final DeferredBlock<Block> CHISELED_PALM_BOOKSHELF = BLOCKS.createBlock("chiseled_palm_bookshelf", () -> new ChiseledPalmBookShelfBlock(ENProperties.PALM.chiseledBookshelf()));
    public static final DeferredBlock<Block> PALM_LADDER = BLOCKS.createBlock("palm_ladder", () -> new LadderBlock(ENProperties.PALM.ladder()));
    public static final DeferredBlock<Block> PALM_BEEHIVE = BLOCKS.createBlock("palm_beehive", () -> new BlueprintBeehiveBlock(ENProperties.PALM.beehive()));
    public static final DeferredBlock<Block> PALM_LEAF_PILE = BLOCKS.createBlock("palm_leaf_pile", () -> new LeafPileBlock(ENProperties.PALM.leafPile()));
    public static final DeferredBlock<BlueprintChestBlock> PALM_CHEST = BLOCKS.createChestBlock("palm", ENProperties.PALM.chest());
    public static final DeferredBlock<BlueprintTrappedChestBlock> TRAPPED_PALM_CHEST = BLOCKS.createTrappedChestBlock("palm", ENProperties.PALM.chest());

    public static void setupTabs() {
		CreativeModeTabContentsPopulator.mod(EnhancedNature.MOD_ID)
                .tab(BUILDING_BLOCKS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), PALM_LOG, PALM_WOOD, STRIPPED_PALM_LOG, STRIPPED_PALM_WOOD, PALM_PLANKS)
                .addItemsBefore(modLoaded(Blocks.BAMBOO_BLOCK, ENConstants.WOODWORKS), PALM_BOARDS)
                .addItemsBefore(of(Blocks.BAMBOO_BLOCK), PALM_STAIRS, PALM_SLAB, PALM_FENCE, PALM_FENCE_GATE, PALM_DOOR, PALM_TRAPDOOR, PALM_PRESSURE_PLATE, PALM_BUTTON)
                .addItemsBefore(of(Blocks.NETHERRACK), SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_SLAB, SNOW_BRICK_WALL, () -> Blocks.PACKED_ICE, PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_SLAB, PACKED_ICE_BRICK_WALL, CHISELED_PACKED_ICE_BRICKS, PACKED_ICE_DOOR, PACKED_ICE_TRAPDOOR,
                        () -> Blocks.BLUE_ICE, BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_SLAB, BLUE_ICE_BRICK_WALL, CHISELED_BLUE_ICE_BRICKS, BLUE_ICE_DOOR, BLUE_ICE_TRAPDOOR)
                .addItemsBefore(of(Blocks.CALCITE), LIMESTONE, LIMESTONE_STAIRS, LIMESTONE_SLAB, LIMESTONE_WALL, POLISHED_LIMESTONE, POLISHED_LIMESTONE_STAIRS, POLISHED_LIMESTONE_SLAB)
                .addItemsBefore(modLoaded(Blocks.CALCITE), POLISHED_LIMESTONE_WALL, CHISELED_POLISHED_LIMESTONE, LIMESTONE_BRICKS, LIMESTONE_BRICK_STAIRS, LIMESTONE_BRICK_SLAB, LIMESTONE_BRICK_WALL, LIMESTONE_PILLAR, LIMESTONE_TILES, LIMESTONE_TILE_STAIRS, LIMESTONE_TILE_SLAB, LIMESTONE_TILE_WALL)
                .addItemsBefore(of(Blocks.DIORITE), BLUE_GRANITE, BLUE_GRANITE_STAIRS, BLUE_GRANITE_SLAB, BLUE_GRANITE_WALL, POLISHED_BLUE_GRANITE, POLISHED_BLUE_GRANITE_STAIRS, POLISHED_BLUE_GRANITE_SLAB)
                .addItemsBefore(modLoaded(Blocks.DIORITE), POLISHED_BLUE_GRANITE_WALL, CHISELED_POLISHED_BLUE_GRANITE, BLUE_GRANITE_BRICKS, BLUE_GRANITE_BRICK_STAIRS, BLUE_GRANITE_BRICK_SLAB, BLUE_GRANITE_BRICK_WALL, BLUE_GRANITE_PILLAR, BLUE_GRANITE_TILES, BLUE_GRANITE_TILE_STAIRS, BLUE_GRANITE_TILE_SLAB, BLUE_GRANITE_TILE_WALL)

                .tab(NATURAL_BLOCKS)
                .addItemsBefore(of(Blocks.CALCITE), LIMESTONE)
                .addItemsBefore(of(Blocks.DIORITE), BLUE_GRANITE)
                .addItemsBefore(of(Blocks.MUSHROOM_STEM), PALM_LOG)
                .addItemsBefore(of(Blocks.AZALEA_LEAVES), PALM_LEAVES)
                .addItemsBefore(modLoaded(Blocks.AZALEA_LEAVES, ENConstants.WOODWORKS), PALM_LEAF_PILE)
                .addItemsBefore(of(Blocks.AZALEA), PALM_SAPLING)

                .tab(FUNCTIONAL_BLOCKS)
                .addItemsBefore(of(Blocks.BAMBOO_SIGN), PALM_SIGNS.getFirst(), PALM_HANGING_SIGNS.getFirst())
                .addItemsBefore(of(Blocks.CHAIN), ICE_LANTERN)
        ;

        CreativeModeTabContentsPopulator.mod(ENConstants.WOODWORKS + "_" + EnhancedNature.MOD_ID)
                .tab(FUNCTIONAL_BLOCKS)
                .addItemsBefore(ofID(ENConstants.BAMBOO_LADDER), PALM_LADDER)
                .addItemsBefore(ofID(ENConstants.BAMBOO_BEEHIVE), PALM_BEEHIVE)
                .addItemsBefore(ofID(ENConstants.BAMBOO_BOOKSHELF), PALM_BOOKSHELF, CHISELED_PALM_BOOKSHELF)
                .addItemsBefore(ofID(ENConstants.BAMBOO_CLOSET), PALM_CHEST)
                .tab(REDSTONE_BLOCKS)
                .addItemsBefore(ofID(ENConstants.TRAPPED_BAMBOO_CLOSET), TRAPPED_PALM_CHEST)
        ;

    }
    public static Predicate<ItemStack> ofID(ResourceLocation location, String... modids) {
        return stack -> (BlockSubRegistryHelper.areModsLoaded(modids) && of(BuiltInRegistries.ITEM.get(location)).test(stack));
    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }
}
