package com.debbiesl.ziggymod.item.custom;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ScytheItem extends TieredItem {

   
    
    public ScytheItem(Tier pTier, Item.Properties pProperties) {
        super(pTier, pProperties);
        
    }

    @Override
    public boolean mineBlock(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull BlockState state, 
        @Nonnull BlockPos pos, @Nonnull LivingEntity entity) {

        if (!level.isClientSide && (state.getBlock() instanceof LeavesBlock 
            || state.getBlock() instanceof TallGrassBlock
            || state.getBlock() instanceof FlowerBlock 
            || state.getBlock() instanceof TallFlowerBlock
            || state.getBlock() instanceof CropBlock
            || state.getBlock() instanceof DoublePlantBlock)) {

            //define the range of blocks to break
            int range = 4;
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for (int x = -range; x <= range; x++) {

                for (int y = -range; y <= range; y++) {

                    for (int z = -range; z <= range; z++) {

                        mutablePos.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                        BlockState targetState = level.getBlockState(mutablePos);
                        
                        if ((targetState.getBlock() instanceof LeavesBlock && 
                            !targetState.getValue(LeavesBlock.PERSISTENT))
                            || targetState.getBlock() instanceof TallGrassBlock
                            || targetState.getBlock() instanceof FlowerBlock 
                            || targetState.getBlock() instanceof TallFlowerBlock
                            || targetState.getBlock() instanceof CropBlock
                            ||targetState.getBlock() instanceof DoublePlantBlock) {
                            
                            //checks to see if the item is broken
                            if (stack.getDamageValue() >= stack.getMaxDamage()) {

                                entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                                return false; //stop breaking if the tool is broken
                            }

                            //destroy the block
                            level.destroyBlock(mutablePos, true);

                            //damage the item
                            stack.setDamageValue(stack.getDamageValue() + 1);
                            if (stack.getDamageValue() >= stack.getMaxDamage()) {

                                entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                                stack.shrink(1);
                            }
                        }
                    }
                }
            }
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }
}
