package com.debbiesl.ziggymod.datagen;

import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.ModBlocks;
import com.debbiesl.ziggymod.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {

        super(output, ziggyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        
        //tutorial items
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RAW_SAPPHIRE);
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.STRAWBERRY);

        //my mod items
        simpleItem(ModItems.TREE_BARK_BOWL);
        simpleItem(ModItems.ACORN_STEW);
        simpleItem(ModItems.ACORN);
        simpleItem(ModItems.GOLDEN_ACORN_STEW);
        simpleItem(ModItems.PINE_CONE);
        simpleItem(ModItems.TREE_BARK);

        simpleItem(ModItems.WOODEN_SCYTHE);
        simpleItem(ModItems.STONE_SCYTHE);
        simpleItem(ModItems.IRON_SCYTHE);
        simpleItem(ModItems.DIAMOND_SCYTHE);
        simpleItem(ModItems.NETHERITE_SCYTHE);

        simpleItem(ModItems.LEATHER_TOOL_BELT);

        evenSimplerBlockItem(ModBlocks.PINE_CONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.TREE_BARK_STAIRS);
        evenSimplerBlockItem(ModBlocks.PINE_CONE_SLAB);
        evenSimplerBlockItem(ModBlocks.TREE_BARK_SLAB);
        evenSimplerBlockItem(ModBlocks.PINE_CONE_BUTTON);
        buttonItem(ModBlocks.PINE_CONE_BUTTON, ModBlocks.PINE_CONE_PLANK);
        buttonItem(ModBlocks.TREE_BARK_BUTTON, ModBlocks.TREE_BARK_PLANK);
        evenSimplerBlockItem(ModBlocks.PINE_CONE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.TREE_BARK_PRESSURE_PLATE);
        fenceItem(ModBlocks.PINE_CONE_FENCE, ModBlocks.PINE_CONE_PLANK);
        fenceItem(ModBlocks.TREE_BARK_FENCE, ModBlocks.TREE_BARK_PLANK);
        evenSimplerBlockItem(ModBlocks.PINE_CONE_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.TREE_BARK_FENCE_GATE);
        wallItem(ModBlocks.PINE_CONE_WALLS, ModBlocks.PINE_CONE_PLANK);
        wallItem(ModBlocks.TREE_BARK_WALLS, ModBlocks.TREE_BARK_PLANK);
        simpleBlockItem(ModBlocks.PINE_CONE_DOOR);
        simpleBlockItem(ModBlocks.TREE_BARK_DOOR);
        trapdoorItem(ModBlocks.PINE_CONE_TRAPDOOR);
        trapdoorItem(ModBlocks.TREE_BARK_TRAPDOOR);
    }

    public void trapdoorItem(RegistryObject<Block> block) {

        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), 
            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {

        return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ziggyMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {

        return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(ziggyMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    
    private ItemModelBuilder evenSimplerBlockItem(RegistryObject<Block> block) {

        return withExistingParent(block.getId().getPath(), 
        modLoc("block/" + block.getId().getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {

        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),  
            mcLoc("block/button_inventory")).texture("texture", 
            new ResourceLocation(ziggyMod.MOD_ID, "block/" + 
            ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {

        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),  
            mcLoc("block/fence_inventory")).texture("texture", 
            new ResourceLocation(ziggyMod.MOD_ID, "block/" + 
            ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {

        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),  
            mcLoc("block/wall_inventory")).texture("wall", 
            new ResourceLocation(ziggyMod.MOD_ID, "block/" + 
            ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
