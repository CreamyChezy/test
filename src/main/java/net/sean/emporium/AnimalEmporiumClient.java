package net.sean.emporium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import net.sean.emporium.entity.ModEntities;
import net.sean.emporium.entity.client.ModModelLayers;
import net.sean.emporium.entity.client.OpossumModel;
import net.sean.emporium.entity.client.OpossumRenderer;
import net.sean.emporium.fluid.ModFluids;
import net.sean.emporium.item.ModItems;

@Environment(EnvType.CLIENT)
public class AnimalEmporiumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_SLOP, ModFluids.FLOWING_SLOP, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x612B20
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getSolid(), ModFluids.STILL_SLOP, ModFluids.FLOWING_SLOP);

        EntityRendererRegistry.register(ModEntities.OPOSSUM, OpossumRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.OPOSSUM, OpossumModel::getTexturedModelData);
    }
}