package com.debbiesl.ziggymod.block.custom;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {

    public SoundBlock(Properties pProperties) {

        super(pProperties);        
    }

     
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, 
        InteractionHand pHand, BlockHitResult pHit) {

            pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_DIDGERIDOO.get(), SoundSource.BLOCKS,
                1f, 1f);
            return InteractionResult.SUCCESS;
        }
    
    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nonnull TooltipContext pContext, @Nonnull List<Component> pTooltip,
        @Nonnull TooltipFlag pTooltipFlag) {
        
        pTooltip.add(Component.literal("Makes sweet sounds when right-clicked."));    
        super.appendHoverText(pStack, pContext, pTooltip, pTooltipFlag);
    }
}
