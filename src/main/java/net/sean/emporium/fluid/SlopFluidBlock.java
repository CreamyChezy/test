package net.sean.emporium.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;

public class SlopFluidBlock extends FluidBlock {
    public SlopFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);

        if(entity instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) entity;

            if (isEntityInFluid(livingEntity, world, pos)){
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 0, false, true));
            }
        }
    }

    private boolean isEntityInFluid(LivingEntity entity, World world, BlockPos pos){
        VoxelShape blockShape = VoxelShapes.cuboid(
                pos.getX(), pos.getY(), pos.getZ(),
                pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0
        );
        return blockShape.getBoundingBox().intersects(entity.getBoundingBox());
    }
}
