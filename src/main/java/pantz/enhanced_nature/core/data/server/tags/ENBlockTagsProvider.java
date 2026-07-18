package pantz.enhanced_nature.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static pantz.enhanced_nature.core.other.tags.ENBlockTags.PALM_LOGS;
import static pantz.enhanced_nature.core.registry.ENBlocks.*;


public class ENBlockTagsProvider extends BlockTagsProvider {
    public ENBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EnhancedNature.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SNOW_BRICKS.get(), SNOW_BRICK_STAIRS.get(), SNOW_BRICK_SLAB.get(),
                PACKED_ICE_BRICKS.get(), PACKED_ICE_BRICK_STAIRS.get(), PACKED_ICE_BRICK_SLAB.get(), CHISELED_PACKED_ICE_BRICKS.get(),
                BLUE_ICE_BRICKS.get(), BLUE_ICE_BRICK_STAIRS.get(), BLUE_ICE_BRICK_SLAB.get(), CHISELED_BLUE_ICE_BRICKS.get(),
                ICE_LANTERN.get(),
                LIMESTONE.get(), LIMESTONE_STAIRS.get(), LIMESTONE_SLAB.get(), LIMESTONE_PILLAR.get(),
                POLISHED_LIMESTONE.get(), POLISHED_LIMESTONE_STAIRS.get(), POLISHED_LIMESTONE_SLAB.get(), CHISELED_POLISHED_LIMESTONE.get(),
                LIMESTONE_BRICKS.get(), LIMESTONE_BRICK_STAIRS.get(), LIMESTONE_BRICK_SLAB.get(),
                LIMESTONE_TILES.get(), LIMESTONE_TILE_STAIRS.get(), LIMESTONE_TILE_SLAB.get(),
                BLUE_GRANITE.get(), BLUE_GRANITE_STAIRS.get(), BLUE_GRANITE_SLAB.get(), BLUE_GRANITE_PILLAR.get(),
                POLISHED_BLUE_GRANITE.get(), POLISHED_BLUE_GRANITE_STAIRS.get(), POLISHED_BLUE_GRANITE_SLAB.get(), CHISELED_POLISHED_BLUE_GRANITE.get(),
                BLUE_GRANITE_BRICKS.get(), BLUE_GRANITE_BRICK_STAIRS.get(), BLUE_GRANITE_BRICK_SLAB.get(),
                BLUE_GRANITE_TILES.get(), BLUE_GRANITE_TILE_STAIRS.get(), BLUE_GRANITE_TILE_SLAB.get(),
                PERMAFROST.get(), PERMAFROST_STAIRS.get(), PERMAFROST_SLAB.get(), PERMAFROST_PILLAR.get(),
                PERMAFROST_BRICKS.get(), PERMAFROST_BRICK_STAIRS.get(), PERMAFROST_BRICK_SLAB.get(), CHISELED_PERMAFROST_BRICKS.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(PALM_LEAVES.get(), PALM_LEAF_PILE.get());

        this.tag(BlockTags.STAIRS).add(SNOW_BRICK_STAIRS.get(), PACKED_ICE_BRICK_STAIRS.get(), BLUE_ICE_BRICK_STAIRS.get(),
                LIMESTONE_STAIRS.get(), POLISHED_LIMESTONE_STAIRS.get(), LIMESTONE_BRICK_STAIRS.get(), LIMESTONE_TILE_STAIRS.get(),
                BLUE_GRANITE_STAIRS.get(), POLISHED_BLUE_GRANITE_STAIRS.get(), BLUE_GRANITE_BRICK_STAIRS.get(), BLUE_GRANITE_TILE_STAIRS.get(),
                PERMAFROST_STAIRS.get(), PERMAFROST_BRICK_STAIRS.get());

        this.tag(BlockTags.SLABS).add(SNOW_BRICK_SLAB.get(), PACKED_ICE_BRICK_SLAB.get(), BLUE_ICE_BRICK_SLAB.get(),
                LIMESTONE_SLAB.get(), POLISHED_LIMESTONE_SLAB.get(), LIMESTONE_BRICK_SLAB.get(), LIMESTONE_TILE_SLAB.get(),
                BLUE_GRANITE_SLAB.get(), POLISHED_BLUE_GRANITE_SLAB.get(), BLUE_GRANITE_BRICK_SLAB.get(), BLUE_GRANITE_TILE_SLAB.get(),
                PERMAFROST_SLAB.get(), PERMAFROST_BRICK_SLAB.get());

        this.tag(BlockTags.WALLS).add(SNOW_BRICK_WALL.get(), PACKED_ICE_BRICK_WALL.get(), BLUE_ICE_BRICK_WALL.get(),
                LIMESTONE_WALL.get(), POLISHED_LIMESTONE_WALL.get(), LIMESTONE_BRICK_WALL.get(), LIMESTONE_TILE_WALL.get(),
                BLUE_GRANITE_WALL.get(), POLISHED_BLUE_GRANITE_WALL.get(), BLUE_GRANITE_BRICK_WALL.get(), BLUE_GRANITE_TILE_WALL.get(),
                PERMAFROST_WALL.get(), PERMAFROST_BRICK_WALL.get());

        this.tag(BlockTags.DOORS).add(PACKED_ICE_DOOR.get(), BLUE_ICE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(PACKED_ICE_TRAPDOOR.get(), BLUE_ICE_TRAPDOOR.get());

        this.tag(BlockTags.FLOWER_POTS).add(POTTED_PALM_SAPLING.get());
        this.tag(BlockTags.SAPLINGS).add(PALM_SAPLING.get());

        this.tag(BlockTags.LEAVES).add(PALM_LEAVES.get());

        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(PALM_LOG.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(PALM_LOGS);

        this.tag(PALM_LOGS).add(PALM_LOG.get(), PALM_WOOD.get(), STRIPPED_PALM_LOG.get(), STRIPPED_PALM_WOOD.get());

        this.tag(BlockTags.PLANKS).add(PALM_PLANKS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(PALM_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(PALM_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(PALM_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(PALM_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(PALM_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(PALM_STAIRS.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(PALM_TRAPDOOR.get());
        this.tag(BlockTags.FENCE_GATES).add(PALM_FENCE_GATE.get());

        this.tag(BlockTags.STANDING_SIGNS).add(PALM_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_SIGNS).add(PALM_SIGNS.getSecond().get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(PALM_HANGING_SIGNS.getFirst().get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(PALM_HANGING_SIGNS.getSecond().get());

        this.tag(BlockTags.GUARDED_BY_PIGLINS).add(PALM_CHEST.get(), TRAPPED_PALM_CHEST.get());

        this.tag(BlueprintBlockTags.WOODEN_CHESTS).add(PALM_CHEST.get());
        this.tag(BlueprintBlockTags.WOODEN_TRAPPED_CHESTS).add(TRAPPED_PALM_CHEST.get());
        this.tag(BlueprintBlockTags.WOODEN_LADDERS).add(PALM_LADDER.get());
        this.tag(BlueprintBlockTags.WOODEN_BEEHIVES).add(PALM_BEEHIVE.get());
        this.tag(BlueprintBlockTags.WOODEN_BOOKSHELVES).add(PALM_BOOKSHELF.get());
        this.tag(BlueprintBlockTags.WOODEN_CHISELED_BOOKSHELVES).add(CHISELED_PALM_BOOKSHELF.get());
        this.tag(BlueprintBlockTags.WOODEN_BOARDS).add(PALM_BOARDS.get());
        this.tag(BlueprintBlockTags.LEAF_PILES).add(PALM_LEAF_PILE.get());

        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(PALM_FENCE_GATE.get());
        this.tag(Tags.Blocks.STRIPPED_LOGS).add(STRIPPED_PALM_LOG.get());
        this.tag(Tags.Blocks.STRIPPED_WOODS).add(STRIPPED_PALM_WOOD.get());
    }
}
