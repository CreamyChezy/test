package net.sean.emporium.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sean.emporium.AnimalEmporium;

public class ModFluids {

    public static FlowableFluid STILL_SLOP = Registry.register(Registries.FLUID, new Identifier(AnimalEmporium.MOD_ID, "slop"), new SlopFluid.Still());
    public static FlowableFluid FLOWING_SLOP = Registry.register(Registries.FLUID, new Identifier(AnimalEmporium.MOD_ID, "flowing_slop"), new SlopFluid.Flowing());
    public static Block SLOP = Registry.register(Registries.BLOCK, new Identifier(AnimalEmporium.MOD_ID, "slop"), new FluidBlock(STILL_SLOP, FabricBlockSettings.copy(Blocks.WATER)));

        public static void registerModFluids() {
            AnimalEmporium.LOGGER.info("Registering fluids for " + AnimalEmporium.MOD_ID);
        }
    }
