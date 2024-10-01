package com.debbiesl.ziggymod.datagen;

import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        
        super(output, ziggyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        carpetWithItem(ModBlocks.MULCH_CARPET);

        blockWithItem(ModBlocks.PINE_CONE_PLANK);
        blockWithItem(ModBlocks.TREE_BARK_PLANK);
        
        stairsBlock(((StairBlock) ModBlocks.PINE_CONE_STAIRS.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        stairsBlock(((StairBlock) ModBlocks.TREE_BARK_STAIRS.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        slabBlock(((SlabBlock) ModBlocks.PINE_CONE_SLAB.get()),
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()),
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        slabBlock(((SlabBlock) ModBlocks.TREE_BARK_SLAB.get()),
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()),
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        buttonBlock(((ButtonBlock)ModBlocks.PINE_CONE_BUTTON.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.TREE_BARK_BUTTON.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        pressurePlateBlock(((PressurePlateBlock)ModBlocks.PINE_CONE_PRESSURE_PLATE.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        pressurePlateBlock(((PressurePlateBlock)ModBlocks.TREE_BARK_PRESSURE_PLATE.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        fenceBlock(((FenceBlock)ModBlocks.PINE_CONE_FENCE.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        fenceBlock(((FenceBlock)ModBlocks.TREE_BARK_FENCE.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        fenceGateBlock(((FenceGateBlock)ModBlocks.PINE_CONE_FENCE_GATE.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        fenceGateBlock(((FenceGateBlock)ModBlocks.TREE_BARK_FENCE_GATE.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        wallBlock(((WallBlock) ModBlocks.PINE_CONE_WALLS.get()), 
            blockTexture(ModBlocks.PINE_CONE_PLANK.get()));
        wallBlock(((WallBlock) ModBlocks.TREE_BARK_WALLS.get()), 
            blockTexture(ModBlocks.TREE_BARK_PLANK.get()));

        doorBlockWithRenderType(((DoorBlock)ModBlocks.PINE_CONE_DOOR.get()), 
            modLoc("block/pine_cone_door_bottom"), 
            modLoc("block/pine_cone_door_top"),
            "cutout");
        doorBlockWithRenderType(((DoorBlock)ModBlocks.TREE_BARK_DOOR.get()), 
            modLoc("block/tree_bark_door_bottom"), 
            modLoc("block/tree_bark_door_top"),
            "cutout");

        trapdoorBlockWithRenderType(((TrapDoorBlock)ModBlocks.PINE_CONE_TRAPDOOR.get()), 
            modLoc("block/pine_cone_trapdoor"), 
            true, "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock)ModBlocks.TREE_BARK_TRAPDOOR.get()), 
            modLoc("block/tree_bark_trapdoor"), 
            true, "cutout");
    }
    
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void carpetWithItem(RegistryObject<Block> blockRegistryObject) {

        simpleBlockWithItem(blockRegistryObject.get(), 
            models().withExistingParent(blockRegistryObject.getId().getPath(), "block/carpet")
            .texture("wool", modLoc("block/" + blockRegistryObject.getId().getPath())));
    }
}
