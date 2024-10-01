package com.debbiesl.ziggymod.util;

import com.debbiesl.ziggymod.ziggyMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    
    public static class Blocks {
        
        //debugging to check for duplication
        public static final TagKey<Block> LOGS = tag("logs");
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables"); 
        public static TagKey<Block> tag(String name) {
        
            return BlockTags.create(new ResourceLocation(ziggyMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static TagKey<Item> tag(String name) {
        
            return ItemTags.create(new ResourceLocation(ziggyMod.MOD_ID, name));
           }
    }
}
