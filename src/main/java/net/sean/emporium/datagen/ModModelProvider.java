package net.sean.emporium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.sean.emporium.item.ModItems;

import static net.sean.emporium.AnimalEmporiumDataGenerator.item;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
       //blockStateModelGenerator.
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.WORM, Models.GENERATED);
        itemModelGenerator.register(ModItems.WORM_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLOP_BUCKET, Models.GENERATED);
    }
}
