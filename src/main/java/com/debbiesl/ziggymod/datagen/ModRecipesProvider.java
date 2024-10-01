package com.debbiesl.ziggymod.datagen;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;
import com.debbiesl.ziggymod.ziggyMod;
import com.debbiesl.ziggymod.block.ModBlocks;
import com.debbiesl.ziggymod.item.ModItems;
import java.util.List;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
        ModBlocks.SAPPHIRE_ORE.get(), 
        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), 
        ModBlocks.NETHER_SAPPHIRE_ORE.get(), 
        ModBlocks.END_STONE_SAPPHIRE_ORE.get()
        );

    public ModRecipesProvider(PackOutput pOutput, CompletableFuture<Provider> pRegistries) {
        
        super(pOutput, pRegistries);        
    }

    

    public ModRecipesProvider(PackOutput packOutput) {
        super(packOutput, null);
    }



    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> 
        pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, 
        int pCookingTime, String pGroup) {

        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
        RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
        RecipeOutput pRecipeOutput,
        RecipeSerializer<T> pSerializer,
        AbstractCookingRecipe.Factory<T> pRecipeFactory,
        List<ItemLike> pIngredients,
        RecipeCategory pCategory,
        ItemLike pResult,
        float pExperience,
        int pCookingTime,
        String pGroup,
        String pSuffix) {

            for (ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, 
                    pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, ziggyMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_"
                        + getItemName(itemlike));
            }
    }

    @Override
    protected void buildRecipes(@Nonnull RecipeOutput pRecipeOutput) {
        
        // tutorial smelting recipes
        oreSmelting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(),
            0.25f, 200, "sapphire");
        oreBlasting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 
            0.25f, 100, "sapphire");

        // tutorial shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.SAPPHIRE.get())
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(pRecipeOutput);

        // my shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_TRAPDOOR.get(), 2)
            .pattern("BB")
            .pattern("BB")
            .define('B', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_TRAPDOOR.get(), 2)
            .pattern("BB")
            .pattern("BB")
            .define('B', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_DOOR.get(), 3)
            .pattern("BB")
            .pattern("BB")
            .pattern("BB")
            .define('B', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_DOOR.get(), 3)
            .pattern("BB")
            .pattern("BB")
            .pattern("BB")
            .define('B', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_WALLS.get(), 6)
            .pattern("BBB")
            .pattern("BBB")
            .define('B', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_WALLS.get(), 6)
            .pattern("BBB")
            .pattern("BBB")
            .define('B', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_FENCE_GATE.get())
            .pattern("PSP")
            .pattern("PSP")
            .define('S', Items.STICK)
            .define('P', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_FENCE_GATE.get())
            .pattern("PSP")
            .pattern("PSP")
            .define('S', Items.STICK)
            .define('P', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_FENCE.get(), 3)
            .pattern("SPS")
            .pattern("SPS")
            .define('S', Items.STICK)
            .define('P', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_FENCE.get(), 3)
            .pattern("SPS")
            .pattern("SPS")
            .define('S', Items.STICK)
            .define('P', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_PRESSURE_PLATE.get(), 6)
            .pattern("PP")
            .define('P', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_PRESSURE_PLATE.get(), 6)
            .pattern("TT")
            .define('T', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_SLAB.get(), 6)
            .pattern("TTT")
            .define('T', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_SLAB.get(), 6)
            .pattern("PPP")
            .define('P', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_STAIRS.get(), 4)
            .pattern("T  ")
            .pattern("TT ")
            .pattern("TTT")
            .define('T', ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_STAIRS.get(), 4)
            .pattern("P  ")
            .pattern("PP ")
            .pattern("PPP")
            .define('P', ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TREE_BARK_PLANK.get())
            .pattern("TT")
            .pattern("TT")
            .define('T', ModItems.TREE_BARK.get())
            .unlockedBy(getHasName(ModItems.TREE_BARK.get()), has(ModItems.TREE_BARK.get()))
            .save(pRecipeOutput);  
            
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PINE_CONE_PLANK.get())
            .pattern("PP")
            .pattern("PP")
            .define('P', ModItems.PINE_CONE.get())
            .unlockedBy(getHasName(ModItems.PINE_CONE.get()), has(ModItems.PINE_CONE.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TREE_BARK_BOWL.get(), 4)
            .pattern("T T")
            .pattern(" T ")
            .define('T', ModItems.TREE_BARK.get())
            .unlockedBy(getHasName(ModItems.TREE_BARK.get()), has(ModItems.TREE_BARK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MULCH_CARPET.get())
            .pattern("TTT")
            .define('T', ModItems.TREE_BARK.get())
            .unlockedBy(getHasName(ModItems.TREE_BARK.get()), has(ModItems.TREE_BARK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ACORN_STEW.get())
            .pattern(" F ")
            .pattern("AAA")
            .pattern(" B ")
            .define('A', ModItems.ACORN.get())
            .define('B', ModItems.TREE_BARK_BOWL.get())
            .define('F', Items.DANDELION)
            .unlockedBy(getHasName(ModItems.ACORN.get()), has(ModItems.ACORN.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLDEN_ACORN_STEW.get())
            .pattern("NNN")
            .pattern("NSN")
            .pattern("NNN")
            .define('S', ModItems.ACORN_STEW.get())
            .define('N', Items.GOLD_NUGGET)
            .unlockedBy(getHasName(ModItems.ACORN_STEW.get()), has(ModItems.ACORN_STEW.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEATHER_TOOL_BELT.get())
            .pattern(" S ")
            .pattern("L L")
            .pattern(" L ")
            .define('L', Items.LEATHER)
            .define('S', Items.STRING)
            .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
            .save(pRecipeOutput);

        //my mod scythe recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOODEN_SCYTHE.get())
            .pattern("  W")
            .pattern(" S ")
            .pattern("S  ")
            .define('S', Items.STICK)
            .define('W', Items.OAK_PLANKS)
            .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS))
            .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_SCYTHE.get())
            .pattern("  C")
            .pattern(" S ")
            .pattern("S  ")
            .define('S', Items.STICK)
            .define('C', Items.COBBLESTONE)
            .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
            .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_SCYTHE.get())
            .pattern("  I")
            .pattern(" S ")
            .pattern("S  ")
            .define('S', Items.STICK)
            .define('I', Items.IRON_INGOT)
            .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
            .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_SCYTHE.get())
            .pattern("  D")
            .pattern(" S ")
            .pattern("S  ")
            .define('S', Items.STICK)
            .define('D', Items.DIAMOND)
            .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
            .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NETHERITE_SCYTHE.get())
            .pattern("  N")
            .pattern(" S ")
            .pattern("S  ")
            .define('S', Items.STICK)
            .define('N', Items.NETHERITE_INGOT)
            .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
            .save(pRecipeOutput);

        // tutorial shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .save(pRecipeOutput);

        // my mod shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINE_CONE_BUTTON.get(), 1)
            .requires(ModBlocks.PINE_CONE_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.PINE_CONE_PLANK.get()), has(ModBlocks.PINE_CONE_PLANK.get()))
            .save(pRecipeOutput);   
            
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.TREE_BARK_BUTTON.get(), 1)
            .requires(ModBlocks.TREE_BARK_PLANK.get())
            .unlockedBy(getHasName(ModBlocks.TREE_BARK_PLANK.get()), has(ModBlocks.TREE_BARK_PLANK.get()))
            .save(pRecipeOutput);
    }    
}
