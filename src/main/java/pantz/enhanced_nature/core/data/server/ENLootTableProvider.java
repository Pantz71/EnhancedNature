package pantz.enhanced_nature.core.data.server;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredBlock;
import pantz.enhanced_nature.core.EnhancedNature;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENLootTableProvider extends LootTableProvider {
    public ENLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, BuiltInLootTables.all(), ImmutableList.of(
                new SubProviderEntry(ENBlockLoot::new, LootContextParamSets.BLOCK)
        ), registries);
    }

    @Override
    protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector) {
    }

    private static class ENBlockLoot extends BlockLootSubProvider {
        private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

        protected ENBlockLoot(HolderLookup.Provider registries) {
            super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), registries);
        }

        @Override
        protected void generate() {
            // dropSelf
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    SNOW_BRICKS, SNOW_BRICK_STAIRS, SNOW_BRICK_WALL,
                    PACKED_ICE_BRICKS, PACKED_ICE_BRICK_STAIRS, PACKED_ICE_BRICK_WALL, CHISELED_PACKED_ICE_BRICKS, PACKED_ICE_TRAPDOOR,
                    BLUE_ICE_BRICKS, BLUE_ICE_BRICK_STAIRS, BLUE_ICE_BRICK_WALL, CHISELED_BLUE_ICE_BRICKS, BLUE_ICE_TRAPDOOR,
                    ICE_LANTERN,
                    LIMESTONE, LIMESTONE_STAIRS, LIMESTONE_WALL, LIMESTONE_PILLAR,
                    POLISHED_LIMESTONE, POLISHED_LIMESTONE_STAIRS, POLISHED_LIMESTONE_WALL, CHISELED_POLISHED_LIMESTONE,
                    LIMESTONE_BRICKS, LIMESTONE_BRICK_STAIRS, LIMESTONE_BRICK_WALL,
                    LIMESTONE_TILES, LIMESTONE_TILE_STAIRS, LIMESTONE_TILE_WALL,
                    BLUE_GRANITE, BLUE_GRANITE_STAIRS, BLUE_GRANITE_WALL, BLUE_GRANITE_PILLAR,
                    POLISHED_BLUE_GRANITE, POLISHED_BLUE_GRANITE_STAIRS, POLISHED_BLUE_GRANITE_WALL, CHISELED_POLISHED_BLUE_GRANITE,
                    BLUE_GRANITE_BRICKS, BLUE_GRANITE_BRICK_STAIRS, BLUE_GRANITE_BRICK_WALL,
                    BLUE_GRANITE_TILES, BLUE_GRANITE_TILE_STAIRS, BLUE_GRANITE_TILE_WALL,

                    PALM_PLANKS, PALM_LOG, PALM_WOOD, STRIPPED_PALM_LOG, STRIPPED_PALM_WOOD,
                    PALM_SIGNS.getFirst(), PALM_HANGING_SIGNS.getFirst(), PALM_PRESSURE_PLATE,
                    PALM_TRAPDOOR, PALM_BUTTON, PALM_STAIRS, PALM_FENCE, PALM_FENCE_GATE,
                    PALM_BOARDS, PALM_SAPLING, PALM_LADDER
            }) {
                this.dropSelf(block.get());
            }

            // slab
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    SNOW_BRICK_SLAB, PACKED_ICE_BRICK_SLAB, BLUE_ICE_BRICK_SLAB,
                    LIMESTONE_SLAB, POLISHED_LIMESTONE_SLAB, LIMESTONE_BRICK_SLAB, LIMESTONE_TILE_SLAB,
                    BLUE_GRANITE_SLAB, POLISHED_BLUE_GRANITE_SLAB, BLUE_GRANITE_BRICK_SLAB, BLUE_GRANITE_TILE_SLAB,
                    PALM_SLAB
            }) {
                this.add(block.get(), this::createSlabItemTable);
            }

            // door
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    PACKED_ICE_DOOR, BLUE_ICE_DOOR,
                    PALM_DOOR
            }) {
                this.add(block.get(), this::createDoorTable);
            }

            // nameable block entity
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    PALM_CHEST, TRAPPED_PALM_CHEST
            }) {
                this.add(block.get(), this::createNameableBlockEntityTable);
            }

            this.add(PALM_LEAF_PILE.get(), this::createLeafPileDrops);
            this.dropPottedContents(POTTED_PALM_SAPLING.get());
            this.add(PALM_BEEHIVE.get(), this::createBeeHiveDrop);
            this.dropWhenSilkTouch(CHISELED_PALM_BOOKSHELF.get());

            this.add(PALM_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BOOK, ConstantValue.exactly(3.0F)));
            this.add(PALM_LEAVES.get(), (block) -> createLeavesDrops(block, PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        }

        protected LootTable.Builder createLeafPileDrops(Block block) {
            return createMultifaceBlockDrops(block, HAS_SHEARS);
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.stream().filter(block -> EnhancedNature.MOD_ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
        }
    }
}
