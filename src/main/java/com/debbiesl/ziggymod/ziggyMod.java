package com.debbiesl.ziggymod;

import com.debbiesl.ziggymod.block.ModBlocks;
import com.debbiesl.ziggymod.item.ModCreativeModTabs;
import com.debbiesl.ziggymod.item.ModItems;
import com.debbiesl.ziggymod.util.SeasonManager;
import com.debbiesl.ziggymod.util.SeasonManager.Season;
import com.debbiesl.ziggymod.util.SeasonalEffects;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ziggyMod.MOD_ID)
public class ziggyMod {
    
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ziggymod";

    // Directly reference a s1j24 logger
    private static final org.slf4j.Logger LOGGER = LogUtils.getLogger();

    // part of adding a new custom trigger
    //public static final ResourceLocation COLLECT_ITEM = new ResourceLocation("ziggymod", "collect_item");

    // Constructor
    public ziggyMod() {
        // Initialization code can go here
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);       
    }      

    private void commonSetup(final FMLCommonSetupEvent event) {

    // some common setup code
    }

    // adds the custom trigger
    //public static void registerTriggers() {
    //    CriteriaTriggers.register(new CustomTrigger(COLLECT_ITEM));
    //}

    // add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
            
        }
    }

    // 
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("Hello from Server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.LevelTickEvent event) {

        if (event.phase == TickEvent.Phase.END) {

            long worldTime = event.level.getDayTime();
            Season currentSeason = SeasonManager.getCurrentSeason(worldTime);

            // apply seasonal effects based on the current season
            SeasonalEffects.applySeasonalEffects(event.level, currentSeason);
        }
    }
}



