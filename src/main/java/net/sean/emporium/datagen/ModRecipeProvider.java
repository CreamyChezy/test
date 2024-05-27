package net.sean.emporium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.sean.emporium.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SLOP_BUCKET, 1)
                .input(Items.WATER_BUCKET)
                .input(Items.MUD)
                .criterion(hasItem(Items.WATER_BUCKET),conditionsFromItem(Items.WATER_BUCKET))
                .criterion(hasItem(Items.MUD),conditionsFromItem(Items.MUD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SLOP_BUCKET) + "shapeless"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WORM_STICK, 1)
                .input(Items.FISHING_ROD)
                .input(ModItems.WORM)
                .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                .criterion(hasItem(ModItems.WORM), conditionsFromItem(ModItems.WORM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WORM_STICK) + "shapeless"));
    }
}
