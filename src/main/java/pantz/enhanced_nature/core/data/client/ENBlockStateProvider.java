package pantz.enhanced_nature.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import pantz.enhanced_nature.core.other.ENBlockFamilies;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENBlockStateProvider extends BlueprintBlockStateProvider {
    public ENBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, EnhancedNature.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockFamily(ENBlockFamilies.SNOW_BRICKS_FAMILY);

        blockFamily(ENBlockFamilies.PACKED_ICE_BRICKS_FAMILY);
        block(CHISELED_PACKED_ICE_BRICKS);
        doorBlocks(PACKED_ICE_DOOR.get(), PACKED_ICE_TRAPDOOR.get());

        blockFamily(ENBlockFamilies.BLUE_ICE_BRICKS_FAMILY);
        block(CHISELED_BLUE_ICE_BRICKS);
        doorBlocks(BLUE_ICE_DOOR.get(), BLUE_ICE_TRAPDOOR.get());

        blockFamily(ENBlockFamilies.LIMESTONE_FAMILY);
        logBlock(LIMESTONE_PILLAR);
        blockFamily(ENBlockFamilies.POLISHED_LIMESTONE_FAMILY);
        block(CHISELED_POLISHED_LIMESTONE);
        blockFamily(ENBlockFamilies.LIMESTONE_BRICKS_FAMILY);
        blockFamily(ENBlockFamilies.LIMESTONE_TILES_FAMILY);

    }
}
