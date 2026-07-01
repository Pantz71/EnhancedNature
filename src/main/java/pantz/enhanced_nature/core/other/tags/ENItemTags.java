package pantz.enhanced_nature.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import pantz.enhanced_nature.core.EnhancedNature;

public class ENItemTags {

    private static TagKey<Item> blockTag(String name) {
        return TagUtil.itemTag(EnhancedNature.MOD_ID, name);
    }
}
