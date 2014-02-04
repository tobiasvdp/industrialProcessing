package ip.industrialProcessing.multiblock.dummy.block.destilationTray;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockDestilationTray  extends BlockMultiblockDummy{

    Icon[] icons = new Icon[3];
	public BlockDestilationTray() {
		super(ConfigMachineBlocks.getBlockDestilationTrayID(), "BlockDestilationTray", ISetupCreativeTabs.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityDestilationTray();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererDestilationTray();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankSide");
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "tankFeatures");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "burnerGrill");
    }
}
