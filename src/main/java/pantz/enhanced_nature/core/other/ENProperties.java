package pantz.enhanced_nature.core.other;

import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class ENProperties {
    public static final BlockSetType ICE = BlockSetType.register(new BlockSetType(EnhancedNature.MOD_ID + ":ice", false, false, false, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.GLASS, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));

    public static final BlockBehaviour.Properties SNOW_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 5.0f).sound(SoundType.SNOW);
    public static final BlockBehaviour.Properties ICE_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.ICE).instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.GLASS);

}
