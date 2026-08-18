package pantz.enhanced_nature.core.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import pantz.enhanced_nature.core.other.tags.ENBlockTags;

public class ENDispenserBehaviors {
    public static DispenseItemBehavior CONVERT_PEAT = new DefaultDispenseItemBehavior() {
        private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

        @Override
        protected ItemStack execute(BlockSource source, ItemStack stack) {
            PotionContents potioncontents = stack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
            if (!potioncontents.is(Potions.WATER)) {
                return this.defaultDispenseItemBehavior.dispense(source, stack);
            } else {
                ServerLevel serverlevel = source.level();
                BlockPos pos = source.pos();
                BlockPos relative = source.pos().relative(source.state().getValue(DispenserBlock.FACING));
                if (!serverlevel.getBlockState(relative).is(ENBlockTags.CONVERTABLE_TO_PEAT)) {
                    return this.defaultDispenseItemBehavior.dispense(source, stack);
                } else {
                    if (!serverlevel.isClientSide) {
                        for(int i = 0; i < 5; ++i) {
                            serverlevel.sendParticles(ParticleTypes.SPLASH, (double)pos.getX() + serverlevel.random.nextDouble(), pos.getY() + 1, (double)pos.getZ() + serverlevel.random.nextDouble(), 1, 0.0F, 0.0F, 0.0F, 1.0F);
                        }
                    }

                    serverlevel.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    serverlevel.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                    serverlevel.setBlockAndUpdate(relative, ENBlocks.PEAT.get().defaultBlockState());
                    return this.consumeWithRemainder(source, stack, new ItemStack(Items.GLASS_BOTTLE));
                }
            }
        }
    };
}
