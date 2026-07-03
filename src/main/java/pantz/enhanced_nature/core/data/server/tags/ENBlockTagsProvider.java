package pantz.enhanced_nature.core.data.server.tags;

import net.minecraft.tags.BlockTags;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;


public class ENBlockTagsProvider extends BlockTagsProvider {
    public ENBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EnhancedNature.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(SNOW_BRICKS.get(), SNOW_BRICK_STAIRS.get(), SNOW_BRICK_SLAB.get(),
                PACKED_ICE_BRICKS.get(), PACKED_ICE_BRICK_STAIRS.get(), PACKED_ICE_BRICK_SLAB.get(), CHISELED_PACKED_ICE_BRICKS.get(),
                BLUE_ICE_BRICKS.get(), BLUE_ICE_BRICK_STAIRS.get(), BLUE_ICE_BRICK_SLAB.get(), CHISELED_BLUE_ICE_BRICKS.get()
        );
        this.tag(BlockTags.STAIRS).add(SNOW_BRICK_STAIRS.get(), PACKED_ICE_BRICK_STAIRS.get(), BLUE_ICE_BRICK_STAIRS.get());
        this.tag(BlockTags.SLABS).add(SNOW_BRICK_SLAB.get(), PACKED_ICE_BRICK_SLAB.get(), BLUE_ICE_BRICK_SLAB.get());
        this.tag(BlockTags.WALLS).add(SNOW_BRICK_WALL.get(), PACKED_ICE_BRICK_WALL.get(), BLUE_ICE_BRICK_WALL.get());
        this.tag(BlockTags.DOORS).add(PACKED_ICE_DOOR.get(), BLUE_ICE_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(PACKED_ICE_TRAPDOOR.get(), BLUE_ICE_TRAPDOOR.get());
    }
}
