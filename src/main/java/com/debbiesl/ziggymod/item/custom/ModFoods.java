package com.debbiesl.ziggymod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    //example mod food
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
        .nutrition(2)
        .fast()
        .saturationModifier(0.2f)
        .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f)
        .build(); 
    
    // my mod food
    public static final FoodProperties ACORN = new FoodProperties.Builder()
        .nutrition(2)
        .alwaysEdible()
        .fast()
        .saturationModifier(0.3f)
        .build(); 
    public static final FoodProperties ACORN_STEW = new FoodProperties.Builder()
        .nutrition(4)
        .saturationModifier(0.6f)
        .build();     
    public static final FoodProperties GOLDEN_ACORN_STEW = new FoodProperties.Builder()
        .nutrition(8)
        .saturationModifier(1.2f)
        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400), 1.0f)
        .effect(new MobEffectInstance(MobEffects.REGENERATION, 200), 1.0f)
        .build();     
}
