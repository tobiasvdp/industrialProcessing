package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.TileEntityWaterBasinDummy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockForge  extends BlockMultiblockSwitcher {
	Icon[] icons = new Icon[1];

	public BlockForge() {
		super(ConfigBlackSmith.getBlockForgeID(), "BlockForge", IPBlackSmith.tabBlackSmith);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityForgeDummy();
	}

	@Override
	public int getRenderType() {
		return ConfigBlackSmith.getRendererForgeId();
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
