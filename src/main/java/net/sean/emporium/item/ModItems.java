package net.sean.emporium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.entity.ModEntities;
import net.sean.emporium.fluid.ModFluids;

public class ModItems {

    public static final Item WORM = registerItem("worm", new Item(new FabricItemSettings().food(ModFoodComponents.WORM)));
    public static final Item WORM_STICK = registerItem("worm_stick", new Item(new FabricItemSettings().maxCount(1).maxDamage(75)));
    public static final Item SLOP_BUCKET = registerItem("slop_bucket", new BucketItem(ModFluids.STILL_SLOP, new FabricItemSettings()));
    public static final Item OPOSSUM_SPAWN_EGG = registerItem("opossum_spawn_egg",
            new SpawnEggItem(ModEntities.OPOSSUM, 0x504C4C, 0xEA92AC, new FabricItemSettings()));

    private static void addItemsToFoodTab(FabricItemGroupEntries entries){
        entries.add(WORM);
    }
    private static void addItemsToToolsTab(FabricItemGroupEntries entries){
        entries.add(WORM_STICK);
        entries.add(SLOP_BUCKET);
    }
    private static void addItemsToSpawnEggsTab(FabricItemGroupEntries entries){
        entries.add(OPOSSUM_SPAWN_EGG);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AnimalEmporium.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AnimalEmporium.LOGGER.info("Registering Mod Items for " + AnimalEmporium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItems::addItemsToSpawnEggsTab);

    }
}
