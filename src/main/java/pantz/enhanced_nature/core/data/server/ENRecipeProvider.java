package pantz.enhanced_nature.core.data.server;

import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

import java.util.concurrent.CompletableFuture;

public class ENRecipeProvider extends BlueprintRecipeProvider {
    public ENRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(EnhancedNature.MOD_ID, output, provider);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_recipeOutput, HolderLookup.Provider holderLookup) {

    }
}
