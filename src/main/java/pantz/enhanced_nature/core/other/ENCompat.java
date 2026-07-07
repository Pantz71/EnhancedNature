package pantz.enhanced_nature.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENCompat {
    public static void register() {
        registerFlammables();
    }

    private static void registerFlammables() {
        DataUtil.registerFlammable(PALM_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(PALM_LOG.get(), 5, 5);
        DataUtil.registerFlammable(PALM_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(STRIPPED_PALM_LOG.get(), 5, 5);
        DataUtil.registerFlammable(STRIPPED_PALM_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(PALM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(PALM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(PALM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(PALM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(PALM_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(PALM_BOOKSHELF.get(), 30, 20);
        DataUtil.registerFlammable(PALM_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(PALM_LEAF_PILE.get(), 30, 60);
        DataUtil.registerFlammable(PALM_BOARDS.get(), 5, 20);
    }
}
