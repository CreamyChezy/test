package net.sean.emporium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.sean.emporium.item.CustomBucket;
import net.sean.emporium.item.ModItems;

@Environment(EnvType.CLIENT)
public class AnimalEmporiumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(AnimalEmporium.STILL_SLOP, AnimalEmporium.FLOWING_SLOP, new SimpleFluidRenderHandler(
                new Identifier("minecraft:block/water_still"),
                new Identifier("minecraft:block/water_flow"),
                0x4DC248
        ));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), AnimalEmporium.STILL_SLOP, AnimalEmporium.FLOWING_SLOP);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((CustomBucket) stack.getItem()).getColor(tintIndex),
                ModItems.SLOP_BUCKET);
    }
}