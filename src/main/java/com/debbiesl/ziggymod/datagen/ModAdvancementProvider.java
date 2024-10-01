package com.debbiesl.ziggymod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<Provider> registries,
            ExistingFileHelper existingFileHelper, List<AdvancementGenerator> subProviders) {
        
        super(output, registries, existingFileHelper, subProviders);    
    }

    

    /*@Override
    protected void registerAdvancements(Consumer<AdvancementHolder> consumer, Provider registries) {
       
        AdvancementHolder root = Advancement.Builder.advancement()
            .display(Items.ACORN, Component.literal("Your Nuts!"), Component.literal("Obtain and eat an acorn."),
                new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"), 
                AdvancementType.TASK, true, true, false)
            .addCriterion("eat_acorn", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
            .save(consumer, "ziggymod:your_nuts");
    }*/
}
