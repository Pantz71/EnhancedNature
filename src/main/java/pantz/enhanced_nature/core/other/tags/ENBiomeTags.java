package pantz.enhanced_nature.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import pantz.enhanced_nature.core.EnhancedNature;

public class ENBiomeTags {

    public static final TagKey<Biome> HAS_SAND = biomeTag("has_sand");

    private static TagKey<Biome> biomeTag(String name) {
        return TagUtil.biomeTag(EnhancedNature.MOD_ID, name);
    }
}
