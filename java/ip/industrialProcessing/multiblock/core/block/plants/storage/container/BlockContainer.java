package ip.industrialProcessing.multiblock.core.block.plants.storage.container;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;

public class BlockContainer extends BlockMultiblockCore{
	private Icon[] icons = new Icon[1];

	public BlockContainer() {
		super(ConfigMachineBlocks.getBlockContainerID(), "BlockContainer", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityContainer te = new TileEntityContainer();
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererContainer();
	}
	
	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "red");
	}
}
