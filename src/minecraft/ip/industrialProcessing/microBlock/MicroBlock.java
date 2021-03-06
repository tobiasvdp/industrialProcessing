package ip.industrialProcessing.microBlock;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import ip.industrialProcessing.utils.registry.MicroBlockIconRegistry;

public class MicroBlock extends BlockMicroBlock{
	private Icon[] icons = new Icon[1];

	public MicroBlock() {
		super(ConfigBlocks.getBlockMicroBlockID(), Material.iron, 50.0f, Block.soundStoneFootstep, "MicroBlock");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new MicroBlockTileEntity();
	}

	@Override
	public MicroBlockType getMicroBlockType() {
		return MicroBlockType.wire;
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererMicroBlock();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons  [par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		MicroBlockIconRegistry.registerIcons(par1IconRegister);
	}
}
