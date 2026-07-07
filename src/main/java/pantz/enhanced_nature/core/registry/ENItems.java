package pantz.enhanced_nature.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.item.BlueprintBoatItem;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.ENConstants;
import pantz.enhanced_nature.integration.boatload.ENBoatTypes;

import java.util.function.Predicate;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

public class ENItems {
	public static final ItemSubRegistryHelper ITEMS = EnhancedNature.REGISTRY_HELPER.getItemSubHelper();


    public static final Pair<DeferredItem<BlueprintBoatItem>, DeferredItem<BlueprintBoatItem>> PALM_BOAT = ITEMS.createBoatAndChestBoatItem("palm", ENBlocks.PALM_PLANKS);
    public static final DeferredItem<Item> PALM_FURNACE_BOAT = ITEMS.createItem("palm_furnace_boat", ModList.get().isLoaded("boatload") ? ENBoatTypes.PALM_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LARGE_PALM_BOAT = ITEMS.createItem("large_palm_boat", ModList.get().isLoaded("boatload") ? ENBoatTypes.LARGE_PALM_BOAT : () -> new Item(new Item.Properties()));

    public static void setupTabs() {
        CreativeModeTabContentsPopulator.mod(EnhancedNature.MOD_ID)
                .tab(TOOLS_AND_UTILITIES)
                .addItemsBefore(of(Items.BAMBOO_RAFT), PALM_BOAT.getFirst(), PALM_BOAT.getSecond())
                .addItemsBefore(modLoaded(Items.BAMBOO_RAFT, ENConstants.BOATLOAD), PALM_FURNACE_BOAT, LARGE_PALM_BOAT)
        ;

    }

    public static Predicate<ItemStack> modLoaded(ItemLike item, String... modids) {
        return stack -> of(item).test(stack) && BlockSubRegistryHelper.areModsLoaded(modids);
    }
}
