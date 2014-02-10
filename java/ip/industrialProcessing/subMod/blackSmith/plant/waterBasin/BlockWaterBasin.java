package ip.industrialProcessing.subMod.blackSmith.plant.waterBasin;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import ip.industrialProcessing.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;

import javax.swing.Icon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWaterBasin extends BlockMultiblockSwitcher {
	Icon[] icons = new Icon[1];

	public BlockWaterBasin() {
		super(ConfigBlackSmith.getBlockWaterBasinID(), "BlockWaterBasin", IPBlackSmith.tabBlackSmith);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWaterBasinDummy();
	}

	@Override
	public int getRenderType() {
		return ConfigBlackSmith.getRendererWaterBasinId();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "Cobble");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getBlockTileEntity(x, y, z);
		if (switcher.isCore()) {
			TileEntityWaterBasinCore te = (TileEntityWaterBasinCore) world.getBlockTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		} else {
			TileEntityWaterBasinDummy te = (TileEntityWaterBasinDummy) world.getBlockTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}
}
