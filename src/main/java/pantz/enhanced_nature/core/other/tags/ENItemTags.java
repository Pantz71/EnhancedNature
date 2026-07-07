package pantz.enhanced_nature.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import pantz.enhanced_nature.core.EnhancedNature;

public class ENItemTags {

    public static final TagKey<Item> PALM_LOGS = itemTag("palm_logs");


    private static TagKey<Item> itemTag(String name) {
        return TagUtil.itemTag(EnhancedNature.MOD_ID, name);
    }
}
