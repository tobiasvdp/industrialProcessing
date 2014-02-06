package ip.industrialProcessing.subMod.blackSmith.plant.tripHammer;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.bloomery.TileEntityBloomery;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockTripHammer extends BlockMultiblockCore {

	private Icon[] icons = new Icon[1];

	public BlockTripHammer() {
		super(ConfigBlackSmith.getBlockTripHammerID(), "BlockTripHammer", IPBlackSmith.tabBlackSmith);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityTripHammer te = new TileEntityTripHammer();
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigBlackSmith.getRendererTripHammerId();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Planks2");
	}

}
