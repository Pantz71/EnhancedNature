package pantz.enhanced_nature.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import pantz.enhanced_nature.core.EnhancedNature;

public class ENSoundEvents {
    public static final SoundSubRegistryHelper SOUND_EVENTS = EnhancedNature.REGISTRY_HELPER.getSoundSubHelper();

    public static final DeferredHolder<SoundEvent, SoundEvent> PEAT_DRIES = SOUND_EVENTS.createSoundEvent("block.peat.dries");
}
