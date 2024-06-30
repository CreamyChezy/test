package net.sean.emporium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.sean.emporium.item.ModItems;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
       // SLOP BUCKET SHAPELESS
       ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLOP_BUCKET, 1)
                .input(Items.WATER_BUCKET)
                .input(Items.MUD)
                .criterion(hasItem(Items.WATER_BUCKET),conditionsFromItem(Items.WATER_BUCKET))
                .criterion(hasItem(Items.MUD),conditionsFromItem(Items.MUD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SLOP_BUCKET) + "shapeless"));
       // WORM STICK SHAPELESS
       ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WORM_STICK, 1)
                .input(Items.FISHING_ROD)
                .input(ModItems.WORM)
                .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                .criterion(hasItem(ModItems.WORM), conditionsFromItem(ModItems.WORM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WORM_STICK) + "shapeless"));
       // GOLDEN WORM SHAPED
       ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GOLDEN_WORM, 1)
               .pattern("nnn").pattern("nwn").pattern("nnn")
               .input('n', Items.GOLD_NUGGET)
               .input('w', ModItems.WORM)
               .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
               .criterion(hasItem(ModItems.WORM), conditionsFromItem(ModItems.WORM))
               .offerTo(exporter, new Identifier(getRecipeName(ModItems.GOLDEN_WORM) + "shaped"));
    }
}
