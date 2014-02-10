package ip.industrialProcessing.multiblock.dummy.block.containerWall;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockContainerWall extends BlockMultiblockDummy{

    Icon[] icons = new Icon[1];
	public BlockContainerWall() {
		super(ConfigMachineBlocks.getBlockContainerWallID(), "BlockContainerWall", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityContainerWall();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererContainerWall();
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
