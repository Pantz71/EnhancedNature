package pantz.enhanced_nature.core.data.server.tags;

import com.teamabnormals.blueprint.core.data.server.tags.BlueprintItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.Tags;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import pantz.enhanced_nature.core.other.tags.ENBlockTags;

import java.util.concurrent.CompletableFuture;

import static pantz.enhanced_nature.core.other.tags.ENItemTags.PALM_LOGS;

public class ENItemTagsProvider extends BlueprintItemTagsProvider {


    public ENItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> lookup, ExistingFileHelper helper) {
        super(EnhancedNature.MOD_ID, output, provider, lookup, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.copy(BlockTags.DOORS, ItemTags.DOORS);
        this.copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);

        this.copy(ENBlockTags.PALM_LOGS, PALM_LOGS);
        this.copyWoodenTags();
        this.copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
        this.copy(Tags.Blocks.STRIPPED_LOGS, Tags.Items.STRIPPED_LOGS);
        this.copy(Tags.Blocks.STRIPPED_WOODS, Tags.Items.STRIPPED_WOODS);
    }
}
