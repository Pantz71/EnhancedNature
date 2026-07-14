package pantz.enhanced_nature.core.registry;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration.TreeConfigurationBuilder;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import pantz.enhanced_nature.common.levelgen.feature.PalmTreeFeature;
import pantz.enhanced_nature.core.EnhancedNature;

import java.util.List;

public class ENFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, EnhancedNature.MOD_ID);

    public static final DeferredHolder<Feature<?>, Feature<TreeConfiguration>> PALM_TREE = FEATURES.register("palm_tree", () -> new PalmTreeFeature(TreeConfiguration.CODEC));

    public static class ENConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> PALM = createKey("palm");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_JUNGLE = createKey("trees_jungle");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SPARSE_JUNGLE = createKey("trees_sparse_jungle");

        public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
            HolderGetter<PlacedFeature> placedFeature = context.lookup(Registries.PLACED_FEATURE);

            register(context, PALM, ENFeatures.PALM_TREE.get(), createPalm().build());
            register(context, TREES_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(TreePlacements.JUNGLE_BUSH), 0.5f), new WeightedPlacedFeature(placedFeature.getOrThrow(TreePlacements.MEGA_JUNGLE_TREE_CHECKED), 0.33333334F), new WeightedPlacedFeature(placedFeature.getOrThrow(ENPlacedFeatures.PALM_CHECKED), 0.2f)), placedFeature.getOrThrow(TreePlacements.JUNGLE_TREE_CHECKED)));
            register(context, TREES_SPARSE_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(TreePlacements.JUNGLE_BUSH), 0.5f), new WeightedPlacedFeature(placedFeature.getOrThrow(ENPlacedFeatures.PALM_CHECKED), 0.2f)), placedFeature.getOrThrow(TreePlacements.JUNGLE_TREE_CHECKED)));
        }

        public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, EnhancedNature.location(name));
        }

        public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
            context.register(key, new ConfiguredFeature<>(feature, config));
        }

        private static TreeConfigurationBuilder createPalm() {
            return createCustomTree(ENBlocks.PALM_LOG.get(), new StraightTrunkPlacer(8, 2, 0), ENBlocks.PALM_LEAVES.get());
        }

        private static TreeConfigurationBuilder createCustomTree(BlockStateProvider logProvider, TrunkPlacer trunkPlacer, BlockStateProvider leavesProvider) {
            return new TreeConfigurationBuilder(logProvider, trunkPlacer, leavesProvider, new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0)).ignoreVines();
        }

        private static TreeConfigurationBuilder createCustomTree(Block log, TrunkPlacer trunkPlacer, Block leaves) {
            return createCustomTree(BlockStateProvider.simple(log), trunkPlacer, BlockStateProvider.simple(leaves));
        }

        private static TreeConfigurationBuilder createCustomTree(BlockStateProvider logProvider, BlockStateProvider leavesProvider) {
            return createCustomTree(logProvider, new StraightTrunkPlacer(0, 0, 0), leavesProvider);
        }
    }

    public static class ENPlacedFeatures {

        public static final ResourceKey<PlacedFeature> PALM_CHECKED = createKey("palm_checked");
        public static final ResourceKey<PlacedFeature> PALM = createKey("palm");
        public static final ResourceKey<PlacedFeature> TREES_JUNGLE = createKey("trees_jungle");
        public static final ResourceKey<PlacedFeature> TREES_SPARSE_JUNGLE = createKey("trees_sparse_jungle");

        public static void bootstrap(BootstrapContext<PlacedFeature> context) {
            register(context, PALM_CHECKED, ENConfiguredFeatures.PALM, PlacementUtils.filteredByBlockSurvival(ENBlocks.PALM_SAPLING.get()));
            register(context, PALM, ENConfiguredFeatures.PALM, VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.5f, 3), ENBlocks.PALM_SAPLING.get()));
            register(context, TREES_JUNGLE, ENConfiguredFeatures.TREES_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(50, 0.1f, 1)));
            register(context, TREES_SPARSE_JUNGLE, ENConfiguredFeatures.TREES_SPARSE_JUNGLE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1)));
        }

        public static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, EnhancedNature.location(name));
        }

        public static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(feature), modifiers));
        }

        public static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, ResourceKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
            register(context, key, feature, List.of(modifiers));
        }

    }
}
