package com.debbiesl.ziggymod.datagen;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;
import org.jetbrains.annotations.Nullable;
import com.debbiesl.ziggymod.ziggyMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagGenerators extends ItemTagsProvider {

    public ModItemTagGenerators(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ziggyMod.MOD_ID, existingFileHelper);
        
    }

    @Override
    protected void addTags(@Nonnull HolderLookup.Provider pProvider) {
       
    } 
}
