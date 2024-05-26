package net.sean.emporium.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WORM = new FoodComponent.Builder().hunger(2).saturationModifier(.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 120), .80f).build();
}
