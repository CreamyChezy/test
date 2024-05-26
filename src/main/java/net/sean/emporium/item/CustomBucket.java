package net.sean.emporium.item;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.sean.emporium.AnimalEmporium;

public class CustomBucket extends BucketItem {
    private final int fluidColor;

    public CustomBucket(Item.Settings settings, int fluidColor) {
        super(AnimalEmporium.STILL_SLOP, settings);
        this.fluidColor = fluidColor;
    }

    public int getColor(int tintIndex) {
        return tintIndex == 1 ? fluidColor: -1;
    }
}