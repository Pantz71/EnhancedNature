package pantz.enhanced_nature.core.data.server;

import net.minecraft.core.registries.Registries;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import pantz.enhanced_nature.core.registry.ENFeatures.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ENDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {
    public ENDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(EnhancedNature.MOD_ID));
    }

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ENConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ENPlacedFeatures::bootstrap)
            ;
}
