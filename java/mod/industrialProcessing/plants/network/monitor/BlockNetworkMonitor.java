package mod.industrialProcessing.plants.network.monitor;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.GuiBuilderScreen;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class BlockNetworkMonitor extends BlockContainerIPRendered implements IGuiBlock {

	public static IGuiBuilder guiBuilder = new GuiBuilderScreen("Network monitor");

	public BlockNetworkMonitor() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
		TileEntityNetworkMonitor te = (TileEntityNetworkMonitor) p_149695_1_.getTileEntity(p_149695_2_, p_149695_3_, p_149695_4_);
		if (!te.isInLine()) {
			te.registerToLine();
		}
	}

	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		super.onNeighborChange(world, x, y, z, tileX, tileY, tileZ);
		TileEntityNetworkMonitor te = (TileEntityNetworkMonitor) world.getTileEntity(x, y, z);
		if (!te.isInLine()) {
			te.registerToLine();
		}
	}

	@Override
	public void onBlockPreDestroy(World p_149725_1_, int p_149725_2_, int p_149725_3_, int p_149725_4_, int p_149725_5_) {
		TileEntityNetworkMonitor te = (TileEntityNetworkMonitor) p_149725_1_.getTileEntity(p_149725_2_, p_149725_3_, p_149725_4_);
		if (!te.isInLine()) {
			te.unregisterFromLine();
		}
		super.onBlockPreDestroy(p_149725_1_, p_149725_2_, p_149725_3_, p_149725_4_, p_149725_5_);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		TileEntityNetworkMonitor te = (TileEntityNetworkMonitor) world.getTileEntity(x, y, z);
		if (!te.isInLine()) {
			te.registerToLine();
		}
		System.out.println(te.getLineId());
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		IRotateableEntity te = (IRotateableEntity) world.getTileEntity(x, y, z);
		if (te.getExternalDirection(LocalDirection.BACK) == side.getOpposite())
			return true;
		return false;
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}
}
