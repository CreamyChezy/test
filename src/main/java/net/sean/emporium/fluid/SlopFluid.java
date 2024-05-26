package net.sean.emporium.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.item.ModItems;

public abstract class SlopFluid extends FluidTemplate {
    @Override
    public Fluid getStill() {
        return AnimalEmporium.STILL_SLOP;
    }

    @Override
    public Fluid getFlowing() {
        return AnimalEmporium.FLOWING_SLOP;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.SLOP_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return AnimalEmporium.SLOP.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends SlopFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends SlopFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
