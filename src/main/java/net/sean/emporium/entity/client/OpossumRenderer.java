package net.sean.emporium.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.sean.emporium.AnimalEmporium;
import net.sean.emporium.entity.custom.OpossumEntity;

public class OpossumRenderer extends MobEntityRenderer<OpossumEntity, OpossumModel<OpossumEntity>> {

    private static final Identifier TEXTURE = new Identifier(AnimalEmporium.MOD_ID, "textures/entity/opossum.png");

    public OpossumRenderer(EntityRendererFactory.Context context) {
        super(context, new OpossumModel<>(context.getPart(ModModelLayers.OPOSSUM)), 0.425f);
    }

    @Override
    public Identifier getTexture(OpossumEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(OpossumEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {


        matrixStack.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(90));

        if(mobEntity.isBaby()) {
            matrixStack.scale(0.8f,0.8f,0.8f);
        }
        else{
            matrixStack.scale(1.5f,1.5f,1.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
