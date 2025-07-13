package net.sean.emporium.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.sean.emporium.entity.custom.OpossumEntity;

public class OpossumModel<T extends OpossumEntity> extends SinglePartEntityModel<T> {
    private final ModelPart opossum;
    private final ModelPart head;

    public OpossumModel(ModelPart root) {
       this.opossum = root.getChild("opossum");
       this.head = opossum.getChild("body").getChild("torso").getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -5.0F, -3.0F, 8.0F, 5.0F, 5.0F, new Dilation(0.0F))
                .uv(21, 2).cuboid(3.0F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(3.0F, 0.0F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

        ModelPartData backlegleft = body.addChild("backlegleft", ModelPartBuilder.create().uv(6, 18).cuboid(-7.0F, -3.0F, -4.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(6, 21).cuboid(-7.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 3.0F, 1.0F));

        ModelPartData backlegright = body.addChild("backlegright", ModelPartBuilder.create().uv(0, 3).cuboid(-7.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(17, 16).cuboid(-7.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 3.0F, 1.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 10).cuboid(-4.0F, -4.0F, -2.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(12, 19).cuboid(-3.0F, -5.0F, -3.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(-3.0F, -5.0F, 0.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(19, 10).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(8.0F, 22.0F, 0.0F));

        ModelPartData muzzelr_r1 = head.addChild("muzzelr_r1", ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, 0.0F, 0.0F, 0.3054F, 0.0F));

        ModelPartData muzzlel_r1 = head.addChild("muzzlel_r1", ModelPartBuilder.create().uv(11, 15).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, -1.0F, 0.0F, -0.3054F, 0.0F));

        ModelPartData muzzleup_r1 = head.addChild("muzzleup_r1", ModelPartBuilder.create().uv(12, 12).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

        ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create().uv(16, 19).cuboid(0.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(21, 0).cuboid(1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(9, 10).cuboid(-3.0F, -2.0F, -1.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(19, 14).cuboid(-4.0F, -3.0F, -1.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 23.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(OpossumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        opossum.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return opossum;
    }
}