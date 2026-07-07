package pantz.enhanced_nature.core.other;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.registry.ENBlocks;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

@EventBusSubscriber(modid = EnhancedNature.MOD_ID, value = Dist.CLIENT)
public class ENClientCompat {
    public static void registerClientCompat() {
        ENBlocks.setupTabs();
        registerRenderLayers();
    }

    @SuppressWarnings("deprecation")
    private static void registerRenderLayers() {
        for (DeferredBlock<?> block : new DeferredBlock[]{
            ICE_LANTERN, PALM_DOOR, PALM_TRAPDOOR, PALM_LADDER, PALM_LEAVES, PALM_LEAF_PILE, PALM_SAPLING, POTTED_PALM_SAPLING
        }) {
            ItemBlockRenderTypes.setRenderLayer(block.get(), RenderType.cutout());
        }
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, level, pos, index) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : FoliageColor.get(0.5D, 1.0D),
                PALM_LEAVES.get(), PALM_LEAF_PILE.get());
    }

    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
        event.register((item, index) -> 7313728, PALM_LEAVES.get(), PALM_LEAF_PILE.get());
    }
}
