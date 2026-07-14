package pantz.enhanced_nature.core.data.server.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.tags.ENBiomeTags;

import java.util.concurrent.CompletableFuture;

public class ENBiomeTagsProvider extends BiomeTagsProvider {
    public ENBiomeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, EnhancedNature.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ENBiomeTags.HAS_SAND).add(Biomes.BEACH).addTag(Tags.Biomes.IS_DESERT);
    }
}
