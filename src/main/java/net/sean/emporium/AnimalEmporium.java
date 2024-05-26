package net.sean.emporium;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sean.emporium.fluid.SlopFluid;
import net.sean.emporium.item.CustomBucket;
import net.sean.emporium.item.ModFoodComponents;
import net.sean.emporium.item.ModItems;
import net.sean.emporium.potion.ModPotions;
import net.sean.emporium.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalEmporium implements ModInitializer {

	public static final String MOD_ID = "emporium";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static FlowableFluid STILL_SLOP;
	public static FlowableFluid FLOWING_SLOP;
	public static Block SLOP;

	@Override
	public void onInitialize() {

		STILL_SLOP = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "slop"), new SlopFluid.Still());
		FLOWING_SLOP = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "flowing_slop"), new SlopFluid.Flowing());
		SLOP = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "slop"), new FluidBlock(STILL_SLOP, FabricBlockSettings.copy(Blocks.WATER)));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "slop_bucket"), ModItems.SLOP_BUCKET);

		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
		ModPotions.registerPotions();
		ModPotions.registerPotionsRecipes();
	}
}