package pantz.enhanced_nature.core.other;

import net.minecraft.world.level.block.grower.TreeGrower;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.registry.ENFeatures.ENConfiguredFeatures;

import java.util.Optional;

public class ENTreeGrower {
    public static final TreeGrower PALM = new TreeGrower(EnhancedNature.MOD_ID + ":palm", Optional.empty(), Optional.of(ENConfiguredFeatures.PALM), Optional.empty());
}
