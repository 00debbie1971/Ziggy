package com.debbiesl.ziggymod.item.custom;

import java.util.List;
import javax.annotation.Nonnull;
import com.debbiesl.ziggymod.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Properties properties) {

        super(properties.durability(250));
    }
    
    public InteractionResult useOnInteractionResult(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide() && pContext != null) {

            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {

                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){

                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock && player != null) {

                player.sendSystemMessage(Component.literal("No valuables found."));
                player.playSound(SoundEvents.BAMBOO_BREAK, 1.0F, 1.0F);
            }            
        }

        //damage the item
        //stack.setDamageValue(stack.getDamageValue() + 1);
        //if (stack.getDamageValue() >= stack.getMaxDamage()) {

        //    entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        //    stack.shrink(1);
        //}
                            
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nonnull TooltipContext pContext, 
        @Nonnull List<Component> pTooltipComponents, @Nonnull TooltipFlag pTooltipFlag) {
        
        pTooltipComponents.add(Component.translatable("tooltip.ziggymod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    private boolean isValuableBlock(BlockState state) {
        
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " + 
            "(" + blockPos.getX() + "  " + blockPos.getY() + "  " + blockPos.getZ() + ")"));
    }

}
