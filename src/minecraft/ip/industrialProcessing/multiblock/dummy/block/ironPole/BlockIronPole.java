package ip.industrialProcessing.multiblock.dummy.block.ironPole;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.dummy.BlockMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.bellows.TileEntityBellows;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockIronPole  extends BlockMultiblockDummy{

    Icon[] icons = new Icon[3];
	public BlockIronPole() {
		super(ConfigMachineBlocks.getBlockIronPoleID(), "BlockIronPole", ISetupCreativeTabs.tabMultiblocks);
		this.setBlockBounds(0.25f, 0.0f, 0.25f, 0.75f, 1.0f, 0.75f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityIronPole();
	}
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererIronPole();
	}

    @Override
    public Icon getIcon(int par1, int par2) {
        par1 %= icons.length;        
        return icons[par1];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Iron");
        icons[1] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "iron_block");
        icons[2] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "powerOutlet");
    }

}
