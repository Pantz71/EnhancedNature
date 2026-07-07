package pantz.enhanced_nature.core.data.server;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENDataMapsProvider extends DataMapProvider {
    public ENDataMapsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(PALM_LEAVES.getId(), new Compostable(0.30f), false)
                .add(PALM_SAPLING.getId(), new Compostable(0.30f), false)
        ;

    }
}
