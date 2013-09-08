package ip.industrialProcessing.config;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.buildingBlock.BLblockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;

public interface ISetupBlocks {
    public static final Block blockCopperOre = (new BlockOre(ConfigBlocks.BlockCopperOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockCopperOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockCopperOre").setCreativeTab(IndustrialProcessing.tabOres);;
    public static final Block blockTinOre = (new BlockOre(ConfigBlocks.BlockTinOreID())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockTinOre").func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "blockTinOre").setCreativeTab(IndustrialProcessing.tabOres);;
    
	public final static BLblockBase blockIronFlat = new BLblockBase(ConfigBlocks.getInstance().blockIronFlat(), "ip.block.ironflat",5.0f, Material.iron, Block.soundMetalFootstep);
}
