package com.debbiesl.ziggymod.util;

public class SeasonManager {

    private static final int DAYS_PER_SEASON = 30;
    private static final int TICKS_PER_DAY = 24000;
    
    public enum Season {

        SPRING, SUMMER, FALL, WINTER;
    }

    // Method to get the current season
    public static Season getCurrentSeason(long worldTime) {

        int days = (int) (worldTime / TICKS_PER_DAY);
        int seasonIndex = (days / DAYS_PER_SEASON) % Season.values().length;
        return Season.values()[seasonIndex];
    }
}
