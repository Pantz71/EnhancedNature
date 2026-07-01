package pantz.enhanced_nature.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import pantz.enhanced_nature.core.EnhancedNature;

public class ENBlockTags {

    private static TagKey<Block> blockTag(String name) {
        return TagUtil.blockTag(EnhancedNature.MOD_ID, name);
    }
}
