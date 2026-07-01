package pantz.enhanced_nature.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ENItemModelProvider extends BlueprintItemModelProvider {
    public ENItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, EnhancedNature.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {

    }
}
