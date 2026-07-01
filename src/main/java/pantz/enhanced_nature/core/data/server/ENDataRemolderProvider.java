package pantz.enhanced_nature.core.data.server;

import com.teamabnormals.blueprint.common.remolder.data.RemolderProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import pantz.enhanced_nature.core.EnhancedNature;

import java.util.concurrent.CompletableFuture;

public class ENDataRemolderProvider extends RemolderProvider {
    public ENDataRemolderProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(EnhancedNature.MOD_ID, PackOutput.Target.DATA_PACK, packOutput, lookupProvider);
    }

    @Override
    protected void registerEntries(HolderLookup.Provider provider) {

    }
}
