package com.debbiesl.ziggymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import com.debbiesl.ziggymod.datagen.loot.ModBlockLootTables;

public class ModLootTableProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> 
        lookupProvider) {

        return new LootTableProvider(output, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(
                () -> new ModBlockLootTables(Set.of(), FeatureFlags.REGISTRY.allFlags()),
                LootContextParamSets.BLOCK)
        ), lookupProvider);
    }
}
