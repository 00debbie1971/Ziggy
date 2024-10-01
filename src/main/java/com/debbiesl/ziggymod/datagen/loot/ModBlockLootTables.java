package com.debbiesl.ziggymod.datagen.loot;

import java.util.Set;
import com.debbiesl.ziggymod.block.ModBlocks;
import com.debbiesl.ziggymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // tutorial drop self loot table
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        // my mod drop self loot table
        this.dropSelf(ModBlocks.MULCH_CARPET.get());
        this.dropSelf(ModBlocks.TREE_BARK_PLANK.get());
        this.dropSelf(ModBlocks.TREE_BARK_STAIRS.get());
        this.add(ModBlocks.TREE_BARK_SLAB.get(),
            block -> createSlabItemTable(ModBlocks.TREE_BARK_SLAB.get()));
        this.dropSelf(ModBlocks.TREE_BARK_BUTTON.get());
        this.dropSelf(ModBlocks.TREE_BARK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.TREE_BARK_FENCE.get());
        this.dropSelf(ModBlocks.TREE_BARK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.TREE_BARK_WALLS.get());
        this.add(ModBlocks.TREE_BARK_DOOR.get(),
            block -> createDoorTable(ModBlocks.TREE_BARK_DOOR.get()));
        this.dropSelf(ModBlocks.TREE_BARK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PINE_CONE_PLANK.get());
        this.dropSelf(ModBlocks.PINE_CONE_STAIRS.get());
        this.add(ModBlocks.PINE_CONE_SLAB.get(),
            block -> createSlabItemTable(ModBlocks.PINE_CONE_SLAB.get()));
        this.dropSelf(ModBlocks.PINE_CONE_BUTTON.get());
        this.dropSelf(ModBlocks.PINE_CONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PINE_CONE_FENCE.get());
        this.dropSelf(ModBlocks.PINE_CONE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PINE_CONE_WALLS.get());
        this.add(ModBlocks.PINE_CONE_DOOR.get(),
            block -> createDoorTable(ModBlocks.PINE_CONE_DOOR.get()));
        this.dropSelf(ModBlocks.PINE_CONE_TRAPDOOR.get());

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
        
        // my mod Blocks
            
    }
    
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {

        return createSilkTouchDispatchTable(pBlock,
        this.applyExplosionDecay(pBlock,
            LootItem.lootTableItem(item) 
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
