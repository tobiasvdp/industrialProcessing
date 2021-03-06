package ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.containerWall.TileEntityContainerWall;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockGarageDoorFrame  extends BlockMultiblockDummy{

    Icon[] icons = new Icon[1];
	public BlockGarageDoorFrame() {
		super(ConfigMachineBlocks.getBlockGarageDoorFrameID(), "BlockGarageDoorFrame", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityGarageDoorFrame();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererGarageDoorFrame();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockGarageFrame");
    }

}
