package com.debbiesl.ziggymod.item;

import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.item.custom.AcornStewItem;
import com.debbiesl.ziggymod.item.custom.FuelItem;
import com.debbiesl.ziggymod.item.custom.MetalDetectorItem;
import com.debbiesl.ziggymod.item.custom.ModFoods;
import com.debbiesl.ziggymod.item.custom.ScytheItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> Items = 
        DeferredRegister.create(ForgeRegistries.ITEMS, ziggyMod.MOD_ID);

    // example items
    public static final RegistryObject<Item> SAPPHIRE = 
        Items.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = 
        Items.register("raw_sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = 
        Items.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties())); 
    
    // example food item
    public static final RegistryObject<Item> STRAWBERRY = 
        Items.register("strawberry", () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));   

    //example fuel item
    public static final RegistryObject<Item> PINE_CONE = 
        Items.register("pine_cone", () -> new FuelItem(new Item.Properties(), 400));

    // my fuel items
    public static final RegistryObject<Item> TREE_BARK =
        Items.register("tree_bark", () -> new FuelItem(new Item.Properties(), 200));

    // my mod items
    public static final RegistryObject<Item> TREE_BARK_BOWL =
        Items.register("tree_bark_bowl", () -> new Item(new Item.Properties()));
    
    // my mod food
    public static final RegistryObject<Item> ACORN = 
        Items.register("acorn", () -> new Item(new Item.Properties().food(ModFoods.ACORN)));
    public static final RegistryObject<Item> ACORN_STEW = 
        Items.register("acorn_stew", () -> new AcornStewItem(new Item.Properties()
        .food(ModFoods.ACORN_STEW).stacksTo(4)));    
    public static final RegistryObject<Item> GOLDEN_ACORN_STEW = 
        Items.register("golden_acorn_stew", () -> new AcornStewItem(new Item.Properties()
        .food(ModFoods.GOLDEN_ACORN_STEW).stacksTo(4)));
    
    //my mod tools
    public static final RegistryObject<Item> WOODEN_SCYTHE = 
        Items.register("wooden_scythe", () -> new ScytheItem(Tiers.WOOD, new Item.Properties()
        .stacksTo(1).durability(59)));
    public static final RegistryObject<Item> STONE_SCYTHE = 
        Items.register("stone_scythe", () -> new ScytheItem(Tiers.STONE, new Item.Properties()
        .stacksTo(1).durability(131)));
    public static final RegistryObject<Item> IRON_SCYTHE = 
        Items.register("iron_scythe", () -> new ScytheItem(Tiers.IRON, new Item.Properties()
        .stacksTo(1).durability(250)));
    public static final RegistryObject<Item> DIAMOND_SCYTHE = 
        Items.register("diamond_scythe", () -> new ScytheItem(Tiers.DIAMOND, new Item.Properties()
        .stacksTo(1).durability(1561)));
    public static final RegistryObject<Item> NETHERITE_SCYTHE = 
        Items.register("netherite_scythe", () -> new ScytheItem(Tiers.NETHERITE, new Item.Properties()
        .stacksTo(1).durability(2031)));

    public static final RegistryObject<Item> LEATHER_TOOL_BELT =
        Items.register("leather_tool_belt", () -> new Item(new Item.Properties()));

    // register    
    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }
}
