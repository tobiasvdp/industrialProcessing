package ip.industrialProcessing.multiblock.dummy.block.screen;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;

public class BlockScreen extends BlockMultiblockDummy{

	private Icon[] icons = new Icon[1];

	public BlockScreen() {
		super(ConfigMachineBlocks.getBLmultiblockScreen(), "MultiblockScreen", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLmultiblockScreen();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityScreen();
	}
	
    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons [0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "iron_block");
    }
}
