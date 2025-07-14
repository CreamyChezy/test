package net.sean.emporium.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<PetBowlBlockEntity> PET_BOWL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(AnimalEmporium.MOD_ID, "pet_bowl_be"),
                    FabricBlockEntityTypeBuilder.create(PetBowlBlockEntity::new, ModBlocks.PET_BOWL).build());

    public static void registerModBE() {
        AnimalEmporium.LOGGER.info("Registering Block Entities for " + AnimalEmporium.MOD_ID);
    }
}
