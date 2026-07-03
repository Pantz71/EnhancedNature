package pantz.enhanced_nature.core.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.level.block.Blocks;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import pantz.enhanced_nature.core.other.ENBlockFamilies;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.RecipeCategory.*;
import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENRecipeProvider extends BlueprintRecipeProvider {
    public ENRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(EnhancedNature.MOD_ID, output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output, HolderLookup.Provider holderLookup) {
        generateRecipes(output, ENBlockFamilies.SNOW_BRICKS_FAMILY);
        ShapedRecipeBuilder.shaped(BUILDING_BLOCKS, SNOW_BRICKS.get()).define('B', Blocks.STONE_BRICKS).define('S', Blocks.SNOW_BLOCK).pattern("BS").pattern("SB").unlockedBy(getHasName(Blocks.SNOW_BLOCK), has(Blocks.SNOW_BLOCK)).save(output);
        generateRecipes(output, ENBlockFamilies.PACKED_ICE_BRICKS_FAMILY);
        polished(output, BUILDING_BLOCKS, PACKED_ICE_BRICKS.get(), Blocks.PACKED_ICE);
        generateRecipes(output, ENBlockFamilies.BLUE_ICE_BRICKS_FAMILY);
        polished(output, BUILDING_BLOCKS, BLUE_ICE_BRICKS.get(), Blocks.BLUE_ICE);

    }
}
