package pantz.enhanced_nature.core.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.jetbrains.annotations.Nullable;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import pantz.enhanced_nature.core.other.ENBlockFamilies;
import pantz.enhanced_nature.core.other.ENConstant;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeCategory.*;
import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENRecipeProvider extends BlueprintRecipeProvider {
    private static final ModLoadedCondition CAVERNS_AND_CHASMS = new ModLoadedCondition(ENConstant.CAVERNS_AND_CHASMS);

    public ENRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(EnhancedNature.MOD_ID, output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output, HolderLookup.Provider holderLookup) {
        generateRecipes(output, ENBlockFamilies.SNOW_BRICKS_FAMILY);
        generateRecipes(output, ENBlockFamilies.PACKED_ICE_BRICKS_FAMILY);
        generateRecipes(output, ENBlockFamilies.BLUE_ICE_BRICKS_FAMILY);

        polished(output, BUILDING_BLOCKS, PACKED_ICE_BRICKS.get(), Blocks.PACKED_ICE);
        polished(output, BUILDING_BLOCKS, BLUE_ICE_BRICKS.get(), Blocks.BLUE_ICE);
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, SNOW_BRICKS.get(), 8)
                .define('S', Blocks.SNOW_BLOCK).define('#', Blocks.STONE_BRICKS)
                .pattern("###").pattern("#S#").pattern("###")
                .unlockedBy(getHasName(Blocks.SNOW_BLOCK), has(Blocks.SNOW_BLOCK))
                .save(output);

        doorBuilder(PACKED_ICE_DOOR.get(), Ingredient.of(Blocks.PACKED_ICE)).unlockedBy(getHasName(Blocks.PACKED_ICE), has(Blocks.PACKED_ICE)).save(output);
        trapdoorBuilder(PACKED_ICE_TRAPDOOR.get(), Ingredient.of(Blocks.PACKED_ICE)).unlockedBy(getHasName(Blocks.PACKED_ICE), has(Blocks.PACKED_ICE)).save(output);

        doorBuilder(BLUE_ICE_DOOR.get(), Ingredient.of(Blocks.BLUE_ICE)).unlockedBy(getHasName(Blocks.BLUE_ICE), has(Blocks.BLUE_ICE)).save(output);
        trapdoorBuilder(BLUE_ICE_TRAPDOOR.get(), Ingredient.of(Blocks.BLUE_ICE)).unlockedBy(getHasName(Blocks.BLUE_ICE), has(Blocks.BLUE_ICE)).save(output);

        stonecutterRecipes(output, ENBlockFamilies.SNOW_BRICKS_FAMILY, SNOW_BRICKS.get());
        stonecutterRecipes(output, ENBlockFamilies.PACKED_ICE_BRICKS_FAMILY, Blocks.PACKED_ICE, PACKED_ICE_BRICKS.get());
        stonecutterRecipes(output, ENBlockFamilies.BLUE_ICE_BRICKS_FAMILY, Blocks.BLUE_ICE, BLUE_ICE_BRICKS.get());

        generateRecipes(output, ENBlockFamilies.LIMESTONE_FAMILY);
        generateRecipes(output, ENBlockFamilies.POLISHED_LIMESTONE_FAMILY, null, null, null, CAVERNS_AND_CHASMS);
        generateRecipes(output, ENBlockFamilies.LIMESTONE_BRICKS_FAMILY, CAVERNS_AND_CHASMS);
        generateRecipes(output, ENBlockFamilies.LIMESTONE_TILES_FAMILY, CAVERNS_AND_CHASMS);

        polished(output, BUILDING_BLOCKS, POLISHED_LIMESTONE.get(), LIMESTONE.get());
        polished(output, BUILDING_BLOCKS, LIMESTONE_BRICKS.get(), POLISHED_LIMESTONE.get());
        conditionalRecipe(output, polishedBuilder(LIMESTONE_TILES.get(), LIMESTONE_BRICKS.get()), CAVERNS_AND_CHASMS);

        stonecutterRecipes(output, ENBlockFamilies.LIMESTONE_FAMILY, LIMESTONE.get());
        stonecutterRecipes(output, ENBlockFamilies.POLISHED_LIMESTONE_FAMILY, LIMESTONE.get(), POLISHED_LIMESTONE.get());
        conditionalStonecutterRecipes(output, ENBlockFamilies.LIMESTONE_BRICKS_FAMILY, CAVERNS_AND_CHASMS, LIMESTONE.get(), POLISHED_LIMESTONE.get(), LIMESTONE_BRICKS.get());
        conditionalStonecutterRecipes(output, ENBlockFamilies.LIMESTONE_TILES_FAMILY, CAVERNS_AND_CHASMS, LIMESTONE.get(), POLISHED_LIMESTONE.get(), LIMESTONE_BRICKS.get(), LIMESTONE_TILES.get());

    }

    protected void generateRecipes(RecipeOutput output, BlockFamily family, ICondition... conditions) {
        ItemLike baseBlock = family.getBaseBlock().asItem();
        if (family.getVariants().containsKey(BlockFamily.Variant.STAIRS)) {
            conditionalRecipe(output, stairsBuilder(family.getVariants().get(BlockFamily.Variant.STAIRS), baseBlock), conditions);
        }

        if (family.getVariants().containsKey(BlockFamily.Variant.SLAB)) {
            conditionalRecipe(output, slabBuilder(family.getVariants().get(BlockFamily.Variant.SLAB), baseBlock), conditions);
        }

        if (family.getVariants().containsKey(BlockFamily.Variant.WALL)) {
            conditionalRecipe(output, wallBuilder(family.getVariants().get(BlockFamily.Variant.WALL), baseBlock), conditions);
        }

        if (family.getVariants().containsKey(BlockFamily.Variant.CHISELED) && family.getVariants().containsKey(BlockFamily.Variant.SLAB)) {
            conditionalRecipe(output, chiseledBuilder(family.getVariants().get(BlockFamily.Variant.CHISELED), baseBlock), conditions);
        }
    }

    protected void generateRecipes(RecipeOutput output, BlockFamily family, @Nullable ICondition condition1, @Nullable ICondition condition2, @Nullable ICondition condition3, @Nullable ICondition condition4) {
        ItemLike baseBlock = family.getBaseBlock().asItem();
        Map<Variant, Block> variants = family.getVariants();

        if (variants.containsKey(Variant.STAIRS)) {
            saveRecipeWithCondition(output, stairsBuilder(variants.get(Variant.STAIRS), baseBlock), condition1);
        }

        if (variants.containsKey(Variant.SLAB)) {
            saveRecipeWithCondition(output, slabBuilder(variants.get(Variant.SLAB), baseBlock), condition2);
        }

        if (variants.containsKey(Variant.WALL)) {
            saveRecipeWithCondition(output, wallBuilder(variants.get(Variant.WALL), baseBlock), condition3);
        }

        if (variants.containsKey(Variant.CHISELED) && variants.containsKey(Variant.SLAB)) {
            saveRecipeWithCondition(output, chiseledBuilder(variants.get(Variant.CHISELED), baseBlock), condition4);
        }
    }

    protected void stonecutterRecipes(RecipeOutput output, BlockFamily family, ItemLike... inputs) {
        for (ItemLike input : inputs) {
            if (family.getBaseBlock().asItem() != input.asItem()) {
                stonecutterRecipe(output, BUILDING_BLOCKS, family.getBaseBlock(), input);
            }

            if (family.getVariants().containsKey(Variant.STAIRS)) {
                stonecutterRecipe(output, BUILDING_BLOCKS, family.get(Variant.STAIRS), input);
            }

            if (family.getVariants().containsKey(Variant.SLAB)) {
                stonecutterRecipe(output, BUILDING_BLOCKS, family.get(Variant.SLAB), input, 2);
            }

            if (family.getVariants().containsKey(Variant.WALL)) {
                stonecutterRecipe(output, DECORATIONS, family.get(Variant.WALL), input);
            }

            if (family.getVariants().containsKey(Variant.CHISELED)) {
                stonecutterRecipe(output, BUILDING_BLOCKS, family.get(Variant.CHISELED), input);
            }
        }
    }

    protected void conditionalStonecutterRecipes(RecipeOutput output, BlockFamily family, ICondition condition, ItemLike... inputs) {
        for (ItemLike input : inputs) {
            if (family.getBaseBlock().asItem() != input.asItem()) {
                conditionalRecipe(output, stonecutterRecipe(BUILDING_BLOCKS, family.getBaseBlock(), input), ResourceLocation.parse(this.getModConversionRecipeName(family.getBaseBlock(), input) + "_stonecutting"), condition);
            }

            if (family.getVariants().containsKey(Variant.STAIRS)) {
                conditionalRecipe(output, stonecutterRecipe(BUILDING_BLOCKS, family.get(Variant.STAIRS), input), ResourceLocation.parse(this.getModConversionRecipeName(family.get(Variant.STAIRS), input) + "_stonecutting"), condition);
            }

            if (family.getVariants().containsKey(Variant.SLAB)) {
                conditionalRecipe(output, stonecutterRecipe(BUILDING_BLOCKS, family.get(Variant.SLAB), input, 2), ResourceLocation.parse(this.getModConversionRecipeName(family.get(Variant.SLAB), input) + "_stonecutting"), condition);
            }

            if (family.getVariants().containsKey(Variant.WALL)) {
                conditionalRecipe(output, stonecutterRecipe(DECORATIONS, family.get(Variant.WALL), input), ResourceLocation.parse(this.getModConversionRecipeName(family.get(Variant.WALL), input) + "_stonecutting"), condition);
            }

            if (family.getVariants().containsKey(Variant.CHISELED)) {
                conditionalRecipe(output, stonecutterRecipe(DECORATIONS, family.get(Variant.CHISELED), input), ResourceLocation.parse(this.getModConversionRecipeName(family.get(Variant.CHISELED), input) + "_stonecutting"), condition);
            }
        }
    }

    protected void saveRecipeWithCondition(RecipeOutput output, RecipeBuilder builder, @Nullable ICondition condition) {
        if (condition == null) {
            builder.save(output);
        } else {
            conditionalRecipe(output, builder, condition);
        }
    }

    protected static RecipeBuilder stonecutterRecipe(RecipeCategory category, ItemLike output, ItemLike input, int count) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, count).unlockedBy(getHasName(input), has(input));
    }

    protected static RecipeBuilder stonecutterRecipe(RecipeCategory category, ItemLike output, ItemLike input) {
        return SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, 1).unlockedBy(getHasName(input), has(input));
    }

    protected static RecipeBuilder stairsBuilder(ItemLike stairs, ItemLike material) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4).define('#', material).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(material), has(material));
    }

    protected static RecipeBuilder slabBuilder(ItemLike slab, ItemLike material) {
        return ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, slab, 6).define('#', material).pattern("###").unlockedBy(getHasName(material), has(material));
    }

    protected static RecipeBuilder wallBuilder(ItemLike wall, ItemLike material) {
        return ShapedRecipeBuilder.shaped(DECORATIONS, wall, 6).define('#', material).pattern("###").pattern("###").unlockedBy(getHasName(material), has(material));
    }

    protected static RecipeBuilder chiseledBuilder(ItemLike chiseledResult, ItemLike material) {
        return ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, chiseledResult).define('#', material).pattern("#").pattern("#").unlockedBy(getHasName(material), has(material));
    }

    protected static RecipeBuilder polishedBuilder(ItemLike result, ItemLike material) {
        return ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, result, 4).define('S', material).pattern("SS").pattern("SS").unlockedBy(getHasName(material), has(material));
    }
}
