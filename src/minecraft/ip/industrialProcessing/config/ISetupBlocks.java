package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;

public interface ISetupBlocks {
	public static final Block blockCopperOre = (new BlockOre(ConfigBlocks.BlockCopperOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockCopperOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockCopperOre").setCreativeTab(IndustrialProcessing.tabOreProcessing);;
    public static final Block blockTinOre = (new BlockOre(ConfigBlocks.BlockTinOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockTinOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockTinOre").setCreativeTab(IndustrialProcessing.tabOreProcessing);;
}
