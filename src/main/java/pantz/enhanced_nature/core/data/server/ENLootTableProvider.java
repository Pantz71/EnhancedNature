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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
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
                    LIMESTONE, LIMESTONE_STAIRS, LIMESTONE_WALL, LIMESTONE_PILLAR,
                    POLISHED_LIMESTONE, POLISHED_LIMESTONE_STAIRS, POLISHED_LIMESTONE_WALL, CHISELED_POLISHED_LIMESTONE,
                    LIMESTONE_BRICKS, LIMESTONE_BRICK_STAIRS, LIMESTONE_BRICK_WALL,
                    LIMESTONE_TILES, LIMESTONE_TILE_STAIRS, LIMESTONE_TILE_WALL
            }) {
                this.dropSelf(block.get());
            }

            // slab
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    SNOW_BRICK_SLAB, PACKED_ICE_BRICK_SLAB, BLUE_ICE_BRICK_SLAB,
                    LIMESTONE_SLAB, POLISHED_LIMESTONE_SLAB, LIMESTONE_BRICK_SLAB, LIMESTONE_TILE_SLAB
            }) {
                this.add(block.get(), this::createSlabItemTable);
            }

            // DOOR
            for (DeferredBlock<?> block : new DeferredBlock[]{
                    PACKED_ICE_DOOR, BLUE_ICE_DOOR
            }) {
                this.add(block.get(), this::createDoorTable);
            }
        }

        @Override
        public Iterable<Block> getKnownBlocks() {
            return BuiltInRegistries.BLOCK.stream().filter(block -> EnhancedNature.MOD_ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
        }
    }
}
