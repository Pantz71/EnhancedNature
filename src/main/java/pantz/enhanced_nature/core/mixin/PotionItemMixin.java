package pantz.enhanced_nature.core.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pantz.enhanced_nature.core.other.tags.ENBlockTags;
import pantz.enhanced_nature.core.registry.ENBlocks;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void peatConversion(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        PotionContents contents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        BlockState state = level.getBlockState(pos);

        if (context.getClickedFace() != Direction.DOWN && state.is(ENBlockTags.CONVERTABLE_TO_PEAT) && contents.is(Potions.WATER)) {
            level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (player != null) {
                player.setItemInHand(context.getHand(), ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            }

            if (!level.isClientSide()) {
                ServerLevel serverlevel = (ServerLevel)level;

                for (int i = 0; i < 5; i++) {
                    serverlevel.sendParticles(ParticleTypes.SPLASH, (double)pos.getX() + level.random.nextDouble(), pos.getY() + 1, (double)pos.getZ() + level.random.nextDouble(), 1, 0.0F, 0.0F, 0.0F, 1.0F);
                }
            }

            level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            level.setBlockAndUpdate(pos, ENBlocks.PEAT.get().defaultBlockState());
            cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide()));
        }

    }
}
