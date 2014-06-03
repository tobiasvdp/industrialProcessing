package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

import javax.swing.Icon;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
