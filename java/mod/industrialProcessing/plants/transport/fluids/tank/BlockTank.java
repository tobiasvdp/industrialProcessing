package mod.industrialProcessing.plants.transport.fluids.tank;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.fluids.FluidTransfers;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidTankInfo;

public class BlockTank extends BlockContainerIPRendered implements IGuiBlock, IDescriptionBlock {

	public static final String UNLOCALIZED_NAME = "IP.Machine.Tank";
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault(UNLOCALIZED_NAME).addInputTank(0);

	public BlockTank() {
		super(1.0f, 1.0f, Material.iron, Block.soundTypeMetal, "tankSide", "tankFeatures");
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TileEntityTank tank = (TileEntityTank) par1World.getTileEntity(par2, par3, par4);
		tank.searchForNeighbors();
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {

		TileEntity entity = world.getTileEntity(x, y, z);
		if (entity instanceof TileEntityTank) {
			TileEntityTank tank = (TileEntityTank) entity;

			FluidTankInfo[] subTanks = tank.getTanks();
			FluidTankInfo mainTank = subTanks[0];
			if (mainTank.fluid != null)
				return mainTank.fluid.getFluid().getLuminosity();
			return super.getLightValue(world, x, y, z);
		}
		return super.getLightValue(world, x, y, z);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {

		if (!super.onBlockActivated(world, x, y, z, player, metadata, what, these, are)) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te instanceof TileEntityTank) {
				TileEntityTank tank = (TileEntityTank) te;
				if (FluidTransfers.handleRightClick(player, tank, what, these, are))
					return true;
				tank.showDebug(player);
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "A block that can contain fluids for storage.";
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}
}
