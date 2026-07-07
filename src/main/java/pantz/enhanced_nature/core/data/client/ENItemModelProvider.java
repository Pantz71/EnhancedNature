package pantz.enhanced_nature.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import pantz.enhanced_nature.core.registry.ENBlocks;

import static pantz.enhanced_nature.core.registry.ENItems.*;

public class ENItemModelProvider extends BlueprintItemModelProvider {
    public ENItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, EnhancedNature.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        this.generatedItem(
                PALM_BOAT.getFirst(), PALM_BOAT.getSecond(), PALM_FURNACE_BOAT, LARGE_PALM_BOAT,
                ENBlocks.ICE_LANTERN
        );
    }
}
