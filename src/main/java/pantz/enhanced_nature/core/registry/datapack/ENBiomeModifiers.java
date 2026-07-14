package pantz.enhanced_nature.core.registry.datapack;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers.*;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;
import pantz.enhanced_nature.core.EnhancedNature;
import pantz.enhanced_nature.core.other.tags.ENBiomeTags;
import pantz.enhanced_nature.core.registry.ENFeatures.ENPlacedFeatures;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ENBiomeModifiers {
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        addFeature(context, "palm_tree", ENBiomeTags.HAS_SAND, Decoration.VEGETAL_DECORATION, ENPlacedFeatures.PALM);
        removeFeature(context, "remove_jungle_trees", Biomes.JUNGLE, Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_JUNGLE);
        addFeature(context, "add_jungle_trees", Biomes.JUNGLE, Decoration.VEGETAL_DECORATION, ENPlacedFeatures.TREES_JUNGLE);
        removeFeature(context, "remove_sparse_jungle_trees", Biomes.SPARSE_JUNGLE, Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_SPARSE_JUNGLE);
        addFeature(context, "add_sparse_jungle_trees", Biomes.SPARSE_JUNGLE, Decoration.VEGETAL_DECORATION, ENPlacedFeatures.TREES_SPARSE_JUNGLE);
    }

    @SafeVarargs
    private static void removeFeature(BootstrapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "remove_feature/" + name, () -> new RemoveFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), Set.of(step)));
    }

    @SafeVarargs
    private static void addFeature(BootstrapContext<BiomeModifier> context, String name, TagKey<Biome> biomes, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(context.lookup(Registries.BIOME).getOrThrow(biomes), featureSet(context, features), step));
    }

    @SafeVarargs
    private static void addFeature(BootstrapContext<BiomeModifier> context, String name, ResourceKey<Biome> biome, Decoration step, ResourceKey<PlacedFeature>... features) {
        register(context, "add_feature/" + name, () -> new AddFeaturesBiomeModifier(HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(biome)), featureSet(context, features), step));
    }

    private static void register(BootstrapContext<BiomeModifier> context, String name, Supplier<? extends BiomeModifier> modifier) {
        context.register(ResourceKey.create(Keys.BIOME_MODIFIERS, EnhancedNature.location(name)), modifier.get());
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(BootstrapContext<?> context, ResourceKey<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(placedFeatureKey -> context.lookup(Registries.PLACED_FEATURE).getOrThrow(placedFeatureKey)).collect(Collectors.toList()));
    }
}
