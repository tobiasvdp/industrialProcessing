package ip.industrialProcessing.multiblock.dummy.block.ironBowl;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockIronBowl extends BlockMultiblockDummy{

    Icon[] icons = new Icon[3];
	public BlockIronBowl() {
		super(ConfigMachineBlocks.getBlockIronBowlID(), "BlockIronBowl", ISetupCreativeTabs.tabMultiblocks);
		this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.4f, 0.8f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityIronBowl();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererIronBowlId();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Wood");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Canvas");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
    }

}