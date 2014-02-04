package ip.industrialProcessing.multiblock.dummy.block.weldingTableExt;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BlockMultiblockWeldingTable extends BlockMultiblockDummy{

	private Icon[] icons = new Icon[4];

	public BlockMultiblockWeldingTable() {
		super(ConfigMachineBlocks.getBLmultiblockWeldingStationExt(), "MultiblockScreenExt", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockWeldingTableExt();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockWeldingTable();
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons [par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
        icons [1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Stone");
        icons [2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
        icons [3] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Chest");
    }

}
