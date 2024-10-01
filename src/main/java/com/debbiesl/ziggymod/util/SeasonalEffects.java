package com.debbiesl.ziggymod.util;

import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SeasonalEffects {
    
    @SubscribeEvent
    public void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            long worldTime = event.level.getDayTime();
            SeasonManager.Season currentSeason = SeasonManager.getCurrentSeason(worldTime);

            // Apply seasonal effects based on the current season
            applySeasonalEffects(event.level, currentSeason);
        }
    }

    public static void applySeasonalEffects(Level level, SeasonManager.Season season) {
        switch (season) {
            case SPRING:
                // Apply spring effects
                                
                break;
            case SUMMER:
                // Apply summer effects
                break;
            case FALL:
                // Apply autumn effects
                break;
            case WINTER:
                // Apply winter effects
                break;
        }
    }

    /*public void applySpringEffects(ServerLevel level) {
        for (BlockPos pos : level.getAllLoadedPositions()) {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof CropBlock) {
                // Increase growth rate logic
                CropBlock crop = (CropBlock) state.getBlock();
                crop.randomTick(state, level, pos, level.random);
        }
        }
    }*/

    /*public void applyWinterEffects(Level level) {
        for (BlockPos pos : level.getAllLoadedPositions()) {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof CropBlock) {
                // Decrease growth rate logic
                if (level.random.nextFloat() < 0.5) { // 50% chance to skip growth tick
                    continue;
                }
                CropBlock crop = (CropBlock) state.getBlock();
                crop.randomTick(state, level, pos, level.random);
            }
        }
    }*/
    
}
