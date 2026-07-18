package pantz.enhanced_nature.core.other;

import com.teamabnormals.blueprint.core.api.WoodTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil.WoodSetProperties;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

public class ENProperties {
    public static final BlockSetType ICE = BlockSetType.register(new BlockSetType(EnhancedNature.MOD_ID + ":ice", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.GLASS, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF, SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));

    public static final BlockSetType PALM_BLOCK_SET = BlockSetType.register(new BlockSetType(EnhancedNature.MOD_ID + ":palm"));

    public static final WoodType PALM_WOOD_TYPE = WoodTypeRegistryHelper.registerWoodType(new WoodType(EnhancedNature.MOD_ID + ":palm", PALM_BLOCK_SET));

    public static final BlockBehaviour.Properties SNOW_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 5.0f).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties ICE_BRICKS = BlockBehaviour.Properties.of().mapColor(MapColor.ICE).instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.GLASS);
    public static final BlockBehaviour.Properties LIMESTONE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties BLUE_GRANITE = BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.STONE);
    public static final BlockBehaviour.Properties ICE_DOOR = BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.ICE).strength(3.0f, 5.0f);
    public static final BlockBehaviour.Properties ICE_TRAPDOOR = BlockBehaviour.Properties.of().sound(SoundType.GLASS).mapColor(MapColor.ICE).strength(3.0f, 5.0f);
    public static final BlockBehaviour.Properties ICE_LANTERN = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel(level -> 12).strength(3.0f).mapColor(MapColor.ICE);
    public static final BlockBehaviour.Properties PERMAFROST = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE).instrument(NoteBlockInstrument.CHIME).strength(1.5f, 6.0f).mapColor(MapColor.ICE);

    public static final WoodSetProperties PALM = WoodSetProperties.builder(MapColor.TERRACOTTA_YELLOW).leavesSound(SoundType.GRASS).build();

}
