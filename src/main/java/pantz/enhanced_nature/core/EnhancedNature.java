package pantz.enhanced_nature.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import pantz.enhanced_nature.core.data.client.ENBlockStateProvider;
import pantz.enhanced_nature.core.data.client.ENItemModelProvider;
import pantz.enhanced_nature.core.data.server.ENDataRemolderProvider;
import pantz.enhanced_nature.core.data.server.ENDatapackBuiltinEntriesProvider;
import pantz.enhanced_nature.core.data.server.ENLootTableProvider;
import pantz.enhanced_nature.core.data.server.ENRecipeProvider;
import pantz.enhanced_nature.core.data.server.tags.ENBlockTagsProvider;
import pantz.enhanced_nature.core.data.server.tags.ENItemTagsProvider;
import pantz.enhanced_nature.core.other.ENClientCompat;
import pantz.enhanced_nature.core.registry.ENBlocks;
import pantz.enhanced_nature.core.registry.ENItems;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(EnhancedNature.MOD_ID)
public class EnhancedNature {
	public static final String MOD_ID = "enhanced_nature";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

	public EnhancedNature(IEventBus bus, ModContainer container) {
		ENBlocks.BLOCKS.register(bus);
		ENItems.ITEMS.register(bus);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

        container.registerConfig(Type.COMMON, ENConfig.Common.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {

		});
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ENClientCompat::registerClientCompat);
	}

	private void dataSetup(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        boolean client = event.includeClient();
        gen.addProvider(client, new ENBlockStateProvider(output, helper));
        gen.addProvider(client, new ENItemModelProvider(output, helper));
        //gen.addProvider(client, new ENSpriteSourceProvider(output, provider, helper));

        boolean server = event.includeServer();
        ENDatapackBuiltinEntriesProvider datapackEntries = new ENDatapackBuiltinEntriesProvider(output, provider);
        gen.addProvider(server, datapackEntries);
        provider = datapackEntries.getRegistryProvider();

        gen.addProvider(server, new ENRecipeProvider(output, provider));
        gen.addProvider(server, new ENLootTableProvider(output, provider));

        BlockTagsProvider blockTags = new ENBlockTagsProvider(output, provider, helper);

        gen.addProvider(server, blockTags);
        gen.addProvider(server, new ENItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
        //gen.addProvider(server, new ENEntityTypeTagsProvider(output, provider, helper));
        //gen.addProvider(server, new ENBiomeTagsProvider(output, provider, helper));
        //gen.addProvider(server, new ENTrimMaterialTagsProvider(output, provider, helper));

        //gen.addProvider(server, ENAdvancementProvider.create(output, provider, helper));

        gen.addProvider(server, new ENDataRemolderProvider(output, provider));
	}
}