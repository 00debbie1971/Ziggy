package com.debbiesl.ziggymod.datagen;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.Nullable;
import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.ModBlocks;
import com.debbiesl.ziggymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagGenerator extends BlockTagsProvider{

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider, 
            @Nullable ExistingFileHelper existingFileHelper) {

        super(output, lookupProvider, ziggyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
            .add(ModBlocks.SAPPHIRE_ORE.get())
            .addTag(Tags.Blocks.ORES);
        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.SOUND_BLOCK.get()
            );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
            .add(ModBlocks.PINE_CONE_PLANK.get(),
                ModBlocks.TREE_BARK_PLANK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.NETHER_SAPPHIRE_ORE.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.SAPPHIRE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get()
            );
        
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
            .add(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.FENCES)
            .add(ModBlocks.PINE_CONE_FENCE.get(),
            ModBlocks.TREE_BARK_FENCE.get()); 
               
        this.tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.PINE_CONE_FENCE_GATE.get(),
            ModBlocks.TREE_BARK_FENCE_GATE.get());

        this.tag(BlockTags.WALLS)
            .add(ModBlocks.PINE_CONE_WALLS.get(),
            ModBlocks.TREE_BARK_WALLS.get());
    };
}
