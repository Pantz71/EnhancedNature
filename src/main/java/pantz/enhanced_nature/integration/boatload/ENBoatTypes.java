package pantz.enhanced_nature.integration.boatload;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import net.minecraft.world.item.Item;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.registry.ENBlocks;
import pantz.enhanced_nature.core.registry.ENItems;

import java.util.function.Supplier;

public class ENBoatTypes {
    public static final BoatloadBoatType PALM = BoatloadBoatType.register(BoatloadBoatType.create(
        EnhancedNature.location("palm"),
        () -> ENBlocks.PALM_PLANKS.get().asItem(),
        () -> ENItems.PALM_BOAT.getFirst().get(),
        () -> ENItems.PALM_BOAT.getSecond().get(),
        () -> ENItems.PALM_FURNACE_BOAT.get(),
        () -> ENItems.LARGE_PALM_BOAT.get()
    ));

    public static final Supplier<Item> PALM_FURNACE_BOAT = () -> new FurnaceBoatItem(PALM);
    public static final Supplier<Item> LARGE_PALM_BOAT = () -> new LargeBoatItem(PALM);
}