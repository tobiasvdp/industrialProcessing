package ip.industrialProcessing.machines.mixer;

import ip.industrialProcessing.machines.MachineFluidTank;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class TileEntityMixer extends TileEntityFluidMachine {

	private static RecipesMixer recipes = new RecipesMixer();

	public TileEntityMixer() {
		addStack(null, ForgeDirection.UP, true, false); // Mixing ingredient

		// buckets!
		addStack(null, ForgeDirection.UP, true, false); // Liquid Input Full
														// Input
		addStack(null, ForgeDirection.DOWN, false, true); // Liquid Input Empty
															// Output
		addStack(null, ForgeDirection.UP, true, false); // Liquid Output Empty
														// Input
		addStack(null, ForgeDirection.DOWN, false, true); // Liquid Output Full
															// Output

		addTank(new FluidTank(10000), new ForgeDirection[] {
				ForgeDirection.NORTH, ForgeDirection.SOUTH,
				ForgeDirection.WEST, ForgeDirection.EAST }, true, false);
		addTank(new FluidTank(10000), ForgeDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		ItemStack waterStacks = getStackInSlot(1);
		ItemStack bucketOutputStack = getStackInSlot(2);
		if (waterStacks != null
				&& waterStacks.itemID == Item.bucketWater.itemID
				&& waterStacks.stackSize > 0) {
			if (bucketOutputStack == null) {

				MachineFluidTank tank = this.getFluidTankForSlot(0);
				if (tank != null
						&& tank.tank.getFluidAmount() < tank.tank.getCapacity()) {
					this.decrStackSize(1, 1); // take water out
					Fluid fluid = FluidRegistry.getFluid("Water");
					tank.tank.fill(new FluidStack(fluid, 1000), true);
					this.setInventorySlotContents(2, new ItemStack(
							Item.bucketEmpty, 1));
				}
			}
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
	public void workDone(boolean remote) {
	}

	@Override
	public void beginWork(boolean remote) {
	}

	@Override
	public void workCancelled(boolean remote) {
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) // 0 is the recipe slot, others are buckets for liquid
						// containers
			return recipes.isValidInput(slot, itemID);

		if (slot == 3)
			return itemID == Item.bucketEmpty.itemID;
		if (slot == 1)
			return itemID == Item.bucketWater.itemID;
		return false;
	}

	@Override
	protected boolean isTankValidForLiquid(int index, int fluidId) {
		if (index == 0)
			return fluidId == FluidRegistry.getFluidID("Water");
		return false;
	}

}
