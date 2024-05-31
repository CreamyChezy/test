// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

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
		this.head = opossum.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-2.0F, -6.0F, -9.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -5.0F, -11.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 24.0F, 8.0F));

		ModelPartData snout4_r1 = head.addChild("snout4_r1", ModelPartBuilder.create().uv(12, 11).cuboid(-9.0F, -5.55F, -1.6F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.0F, -8.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData snout3_r1 = head.addChild("snout3_r1", ModelPartBuilder.create().uv(9, 16).cuboid(-7.7F, -5.0F, -5.2F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.0F, -8.0F, 0.0F, 0.3054F, 0.0F));

		ModelPartData snout2_r1 = head.addChild("snout2_r1", ModelPartBuilder.create().uv(0, 17).cuboid(-9.5F, -5.0F, -0.15F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, 0.0F, -8.0F, 0.0F, -0.3054F, 0.0F));

		ModelPartData br = modelPartData.addChild("br", ModelPartBuilder.create().uv(17, 4).cuboid(-8.0F, -3.0F, 7.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 13).cuboid(-7.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bl = modelPartData.addChild("bl", ModelPartBuilder.create().uv(14, 16).cuboid(-11.0F, -3.0F, 7.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(17, 19).cuboid(-11.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create().uv(9, 11).cuboid(-9.0F, -5.0F, 9.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(-9.0F, -4.0F, 10.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(17, 0).cuboid(-9.0F, -3.0F, 11.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-11.0F, -7.0F, 2.0F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F))
		.uv(8, 21).cuboid(-11.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(20, 15).cuboid(-8.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(17, 11).cuboid(-11.0F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 17).cuboid(-7.0F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(OpossumEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		opossum.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return opossum;
	}
}