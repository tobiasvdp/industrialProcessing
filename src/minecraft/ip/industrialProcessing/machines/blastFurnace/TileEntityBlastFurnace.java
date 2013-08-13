package ip.industrialProcessing.machines.blastFurnace;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityBlastFurnace extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesBlastFurnace recipes = new RecipesBlastFurnace();
	private boolean init = true;

	public TileEntityBlastFurnace() {
		super(LocalDirection.LEFT, 10000, 20);
	}

	@Override
	public void updateEntity() {
		if (init) {
			if (!isDummyBlock(worldObj, xCoord, yCoord, zCoord)) {
				LocalDirection[] nodirections = new LocalDirection[0];

				this.addStack(null, LocalDirection.UP, true, false);
				this.addStack(null, nodirections, true, false);
				this.addStack(null, nodirections, true, false);

				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);
				addStack(null, nodirections, true, false);
				addStack(null, nodirections, false, true);

				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.RIGHT, false, true);
				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, LocalDirection.DOWN, false, true);
				addTank(FluidContainerRegistry.BUCKET_VOLUME * 50, nodirections, false, true);
			} else {

			}
			init = false;
		}
		if (!isDummyBlock) {
			getBucketFromTank(3, 4, 0);
			getBucketFromTank(5, 6, 1);
			super.updateEntity();
		}
	};

	@Override
	public boolean hasWork() {
		return true;
	}

	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		if (slot == 1)
			return recipes.isValidInput(slot, itemID);
		if (slot == 2)
			return recipes.isValidInput(slot, itemID);

		if (slot == 3 || slot == 5) // fluid output container input
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
		return false;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

	public boolean isDummyBlock(World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y - 1, z);
		if (entity != null && entity instanceof TileEntityBlastFurnace && !((TileEntityBlastFurnace) entity).isDummyBlock(world, x, y - 1, z)) {
			isDummyBlock = true;
			return true;
		}
		return false;
	}
	public boolean hasDummyBlock(World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y + 1, z);
		if (entity != null && entity instanceof TileEntityBlastFurnace && ((TileEntityBlastFurnace) entity).isDummyBlock(world, x, y + 1, z)) {
			return true;
		}
		return false;
	}

}
