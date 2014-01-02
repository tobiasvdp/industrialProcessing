package ip.industrialProcessing.multiblock.dummy.block.containerWall;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.dummy.BLmultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.bellows.TileEntityBellows;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockContainerWall extends BLmultiblockDummy{

    Icon[] icons = new Icon[1];
	public BlockContainerWall() {
		super(ConfigMachineBlocks.getBlockContainerWallID(), "BlockContainerWall", IndustrialProcessing.tabMultiblocks);
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
        icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "red");
    }

}
