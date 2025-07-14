package net.sean.emporium.client.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.block.entity.PetBowlBlockEntity;

public class CustomBlockEntityRenderer implements BlockEntityRenderer<PetBowlBlockEntity> {
    private static final Identifier TEXTURE = new Identifier(AnimalEmporium.MOD_ID, "textures/block/pet_bowl.png");

    @Override
    public void render(PetBowlBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

    }
}
