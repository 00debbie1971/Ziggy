package com.debbiesl.ziggymod.item;

import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ziggyMod.MOD_ID);

    
    public static final RegistryObject<CreativeModeTab> ZIGGY_TAB = CREATIVE_MODE_TABS.register("ziggy_tab", 
        () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.ziggy_tab"))
        .icon(ModItems.TREE_BARK.get()::getDefaultInstance)
        .displayItems((displayParams, pOutput) -> {

            // sample items and blocks
            pOutput.accept(ModItems.SAPPHIRE.get());
            pOutput.accept(ModItems.RAW_SAPPHIRE.get());
            pOutput.accept(ModItems.METAL_DETECTOR.get());
            pOutput.accept(ModItems.STRAWBERRY.get());
            pOutput.accept(ModItems.PINE_CONE.get());
            pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
            pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
            pOutput.accept(ModBlocks.SOUND_BLOCK.get());

            // sample ore blocks
            pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
            pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

            // my mod items and blocks
            pOutput.accept(ModItems.TREE_BARK.get());
            pOutput.accept(ModItems.TREE_BARK_BOWL.get());
            pOutput.accept(ModItems.ACORN.get());
            pOutput.accept(ModItems.ACORN_STEW.get());
            pOutput.accept(ModItems.GOLDEN_ACORN_STEW.get());
            pOutput.accept(ModBlocks.MULCH_CARPET.get());
            pOutput.accept(ModBlocks.PINE_CONE_PLANK.get());
            pOutput.accept(ModBlocks.TREE_BARK_PLANK.get());
            pOutput.accept(ModBlocks.PINE_CONE_STAIRS.get());
            pOutput.accept(ModBlocks.TREE_BARK_STAIRS.get()); 
            pOutput.accept(ModBlocks.PINE_CONE_SLAB.get());
            pOutput.accept(ModBlocks.TREE_BARK_SLAB.get());   
            pOutput.accept(ModBlocks.PINE_CONE_BUTTON.get());
            pOutput.accept(ModBlocks.TREE_BARK_BUTTON.get());
            pOutput.accept(ModBlocks.PINE_CONE_PRESSURE_PLATE.get());
            pOutput.accept(ModBlocks.TREE_BARK_PRESSURE_PLATE.get());
            pOutput.accept(ModBlocks.PINE_CONE_FENCE.get());
            pOutput.accept(ModBlocks.TREE_BARK_FENCE.get());
            pOutput.accept(ModBlocks.PINE_CONE_FENCE_GATE.get());
            pOutput.accept(ModBlocks.TREE_BARK_FENCE_GATE.get());
            pOutput.accept(ModBlocks.PINE_CONE_WALLS.get());
            pOutput.accept(ModBlocks.TREE_BARK_WALLS.get());
            pOutput.accept(ModBlocks.PINE_CONE_DOOR.get());
            pOutput.accept(ModBlocks.TREE_BARK_DOOR.get());
            pOutput.accept(ModBlocks.PINE_CONE_TRAPDOOR.get());
            pOutput.accept(ModBlocks.TREE_BARK_TRAPDOOR.get());
            
            //my mod tools
            pOutput.accept(ModItems.WOODEN_SCYTHE.get());
            pOutput.accept(ModItems.STONE_SCYTHE.get());
            pOutput.accept(ModItems.IRON_SCYTHE.get());
            pOutput.accept(ModItems.DIAMOND_SCYTHE.get());
            pOutput.accept(ModItems.NETHERITE_SCYTHE.get());
            pOutput.accept(ModItems.LEATHER_TOOL_BELT.get());
        })
      .build());

    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);
    }
}
