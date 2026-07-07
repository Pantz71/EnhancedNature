package pantz.enhanced_nature.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import pantz.enhanced_nature.core.EnhancedNature;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import pantz.enhanced_nature.core.other.ENBlockFamilies;

import java.util.Arrays;

import static pantz.enhanced_nature.core.registry.ENBlocks.*;

public class ENBlockStateProvider extends BlueprintBlockStateProvider {
    private static final DeferredBlock<Block>[] DOUBLE_SLABS = new DeferredBlock[]{
            POLISHED_LIMESTONE_SLAB,
            POLISHED_BLUE_GRANITE_SLAB
    };
    public ENBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, EnhancedNature.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockFamily(ENBlockFamilies.SNOW_BRICKS_FAMILY);

        blockFamilyWithChiseled(ENBlockFamilies.PACKED_ICE_BRICKS_FAMILY);
        doorBlocks(PACKED_ICE_DOOR.get(), PACKED_ICE_TRAPDOOR.get());

        blockFamilyWithChiseled(ENBlockFamilies.BLUE_ICE_BRICKS_FAMILY);
        doorBlocks(BLUE_ICE_DOOR.get(), BLUE_ICE_TRAPDOOR.get());

        blockFamily(ENBlockFamilies.LIMESTONE_FAMILY);
        logBlock(LIMESTONE_PILLAR);
        blockFamilyWithChiseledAndDoubleSlab(ENBlockFamilies.POLISHED_LIMESTONE_FAMILY);
        blockFamily(ENBlockFamilies.LIMESTONE_BRICKS_FAMILY);
        blockFamily(ENBlockFamilies.LIMESTONE_TILES_FAMILY);

        blockFamily(ENBlockFamilies.BLUE_GRANITE_FAMILY);
        logBlock(BLUE_GRANITE_PILLAR);
        blockFamilyWithChiseledAndDoubleSlab(ENBlockFamilies.POLISHED_BLUE_GRANITE_FAMILY);
        blockFamily(ENBlockFamilies.BLUE_GRANITE_BRICKS_FAMILY);
        blockFamily(ENBlockFamilies.BLUE_GRANITE_TILES_FAMILY);

        this.blockFamily(ENBlockFamilies.PALM_PLANKS_FAMILY);
        this.logBlocks(PALM_LOG, PALM_WOOD);
        this.logBlocks(STRIPPED_PALM_LOG, STRIPPED_PALM_WOOD);
        this.hangingSignBlocks(STRIPPED_PALM_LOG, PALM_HANGING_SIGNS);
        this.leavesBlocks(PALM_LEAVES, PALM_LEAF_PILE);
        this.crossBlockWithPot(PALM_SAPLING, POTTED_PALM_SAPLING);
        this.woodworksBlocks(PALM_PLANKS, PALM_BOARDS, PALM_LADDER, PALM_BOOKSHELF, PALM_BEEHIVE, PALM_CHEST, TRAPPED_PALM_CHEST);
        this.chiseledBookshelfBlock(CHISELED_PALM_BOOKSHELF, ALTERNATE_BOOKSHELF_POSITIONS);


    }

    public void blockFamilyWithChiseled(BlockFamily family) {
        this.blockFamily(family);
        this.block(family.get(Variant.CHISELED));
    }

    public void blockFamilyWithChiseledAndDoubleSlab(BlockFamily family) {
        baseBlockVariants(family.getBaseBlock(), family.getVariants().get(Variant.STAIRS), family.getVariants().get(Variant.SLAB), family.getVariants().get(Variant.WALL));
        this.block(family.get(Variant.CHISELED));
    }

    public void baseBlockVariants(Block block, Block stairs, Block slab, Block wall) {
        this.block(block);
        this.stairsBlock(block, stairs);
        this.slabBlock(block, slab);
        this.wallBlock(block, wall);
    }

    @Override
    public void slabBlock(Block block, Block slab) {
        if (slab instanceof SlabBlock slabBlock && Arrays.stream(DOUBLE_SLABS).map(DeferredBlock::get).toList().contains(slabBlock)) {
            ResourceLocation side = blockTexture(slab);
            ResourceLocation full = blockTexture(block);
            this.slabBlock(slabBlock, models().slab(name(slab), side, full, full), models().slabTop(name(slab) + "_top", side, full, full), models().cubeColumn(name(slab) + "_double", side, full));
            this.blockItem(slab);
        } else {
            super.slabBlock(block, slab);
        }
    }
}
