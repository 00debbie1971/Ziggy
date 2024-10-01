package com.debbiesl.ziggymod.block;

import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.custom.MulchCarpetBlock;
import com.debbiesl.ziggymod.block.custom.SoundBlock;
import com.debbiesl.ziggymod.item.ModItems;
import com.google.common.base.Supplier;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ziggyMod.MOD_ID);

    // sample block
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
        () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));    

    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore", 
        () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore", 
        () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)
                .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore", 
        () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                .strength(1f).requiresCorrectToolForDrops()));    
    public static final RegistryObject<Block> END_STONE_SAPPHIRE_ORE = registerBlock("end_stone_sapphire_ore", 
        () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                .strength(5f).requiresCorrectToolForDrops()));                    
    
    // my mod blocks
    public static final RegistryObject<Block> MULCH_CARPET = registerBlock("mulch_carpet", 
        () -> new MulchCarpetBlock(Block.Properties.ofFullCopy(Blocks.MOSS_CARPET)
            .noOcclusion()            
            .instabreak()
            .sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PINE_CONE_PLANK = registerBlock("pine_cone_plank",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD).sound(SoundType.WOOD)));   
    public static final RegistryObject<Block> TREE_BARK_PLANK = registerBlock("tree_bark_plank",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD).sound(SoundType.WOOD)));   
        
    public static final RegistryObject<Block> PINE_CONE_STAIRS = registerBlock("pine_cone_stairs", 
        () -> new StairBlock(ModBlocks.PINE_CONE_PLANK.get().defaultBlockState(), 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TREE_BARK_STAIRS = registerBlock("tree_bark_stairs",
        () -> new StairBlock(ModBlocks.TREE_BARK_PLANK.get().defaultBlockState(), 
        BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINE_CONE_SLAB = registerBlock("pine_cone_slab", 
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
        .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TREE_BARK_SLAB = registerBlock("tree_bark_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
        .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINE_CONE_BUTTON = registerBlock("pine_cone_button",
        () -> new ButtonBlock(BlockSetType.OAK, 15, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> TREE_BARK_BUTTON = registerBlock("tree_bark_button",
        () -> new ButtonBlock(BlockSetType.OAK, 15, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PINE_CONE_PRESSURE_PLATE = 
        registerBlock("pine_cone_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD)));   
    public static final RegistryObject<Block> TREE_BARK_PRESSURE_PLATE = 
        registerBlock("tree_bark_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINE_CONE_FENCE = 
        registerBlock("pine_cone_fence",
        () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));   
    public static final RegistryObject<Block> TREE_BARK_FENCE = 
        registerBlock("tree_bark_fence",
        () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PINE_CONE_FENCE_GATE = 
        registerBlock("pine_cone_fence_gate",
        () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
        .sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));   
    public static final RegistryObject<Block> TREE_BARK_FENCE_GATE = 
        registerBlock("tree_bark_fence_gate",
        () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
        .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PINE_CONE_WALLS = 
        registerBlock("pine_cone_walls",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));   
    public static final RegistryObject<Block> TREE_BARK_WALLS = 
        registerBlock("tree_bark_walls",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PINE_CONE_DOOR = registerBlock("pine_cone_door",
        () -> new DoorBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion()));   
    public static final RegistryObject<Block> TREE_BARK_DOOR = registerBlock("tree_bark_door",
        () -> new DoorBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<Block> PINE_CONE_TRAPDOOR = 
        registerBlock("pine_cone_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion()));   
    public static final RegistryObject<Block> TREE_BARK_TRAPDOOR = 
        registerBlock("tree_bark_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.OAK, 
        BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).sound(SoundType.WOOD).noOcclusion()));

    // registers the blocks
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> 
        registerBlockItem(String name, RegistryObject<T> block) {

        return ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));        
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
    
}
