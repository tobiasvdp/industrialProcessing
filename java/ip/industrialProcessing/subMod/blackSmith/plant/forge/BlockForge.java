package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import ip.industrialProcessing.api.config.INamepace;
import ip.industrialProcessing.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import ip.industrialProcessing.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import ip.industrialProcessing.subMod.blackSmith.IPBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.config.ConfigBlackSmith;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockForge  extends BlockMultiblockSwitcher {
	Icon[] icons = new Icon[1];

	public BlockForge() {
		super(ConfigBlackSmith.getBlockForgeID(), "BlockForge", IPBlackSmith.tabBlackSmith);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
		setTickRandomly(true);
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
		icons[0] = par1IconRegister.registerIcon(INamepace.TEXTURE_NAME_PREFIX + "blockCobbleLimestone");
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) par1World.getBlockTileEntity(par2, par3, par4);
		if(switcher.isCore()){
			((TileEntityForgeCore) switcher).burn();
		}
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getBlockTileEntity(x, y, z);
		if(switcher.isCore()){
			((TileEntityForgeCore) switcher).canBurnBlock();
		}
		super.onNeighborBlockChange(world, x, y, z, par5);
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		return 10;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getBlockTileEntity(x, y, z);
		if (switcher.isCore()) {
			TileEntityForgeCore te = (TileEntityForgeCore) world.getBlockTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		} else {
			TileEntityForgeDummy te = (TileEntityForgeDummy) world.getBlockTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}
	
}
