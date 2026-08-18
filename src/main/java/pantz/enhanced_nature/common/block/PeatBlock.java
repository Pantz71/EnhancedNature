package pantz.enhanced_nature.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.state.BlockState;
import pantz.enhanced_nature.core.registry.ENBlocks;
import pantz.enhanced_nature.core.registry.ENSoundEvents;

public class PeatBlock extends MudBlock {
    public PeatBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        if (level.dimensionType().ultraWarm()) {
            level.setBlockAndUpdate(pos, ENBlocks.DRIED_PEAT.get().defaultBlockState());
            level.levelEvent(2009, pos, 0);
            level.playSound(null, pos, ENSoundEvents.PEAT_DRIES.get(), SoundSource.BLOCKS);
        }
    }
}
