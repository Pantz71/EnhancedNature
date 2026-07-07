package pantz.enhanced_nature.common.block;

import com.teamabnormals.blueprint.common.block.BlueprintChiseledBookShelfBlock;
import net.minecraft.world.phys.Vec2;

import java.util.OptionalInt;

public class ChiseledPalmBookShelfBlock extends BlueprintChiseledBookShelfBlock {
    public ChiseledPalmBookShelfBlock(Properties properties) {
        super(properties);
    }

    @Override
    public OptionalInt getHitSlot(Vec2 vec2) {
        int row;
        float y = vec2.y;
        if (y >= 2.0F / 3.0F) {
            row = 0;
        } else if (y >= 1.0F / 3.0F) {
            row = 1;
        } else {
            row = 2;
        }

        int column;
        float x = vec2.x;
        if (x < 0.5F) {
            column = 0;
        } else {
            column = 1;
        }

        return OptionalInt.of(row * 2 + column);
    }
}
