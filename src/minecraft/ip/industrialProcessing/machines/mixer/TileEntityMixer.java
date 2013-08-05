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
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class TileEntityMixer extends TileEntityFluidMachine {

	private static RecipesMixer recipes = new RecipesMixer();

	public TileEntityMixer() {

		System.out.println("Setting up Mixer");

		addStack(null, ForgeDirection.UP, true, false); // Mixing ingredient

		ForgeDirection[] nodirections = new ForgeDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full
													// Input
		addStack(null, nodirections, false, true); // Liquid Input Empty
													// Output
		addStack(null, nodirections, true, false); // Liquid Output Empty
													// Input
		addStack(null, nodirections, false, true); // Liquid Output Full
													// Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10,
				new ForgeDirection[] { ForgeDirection.NORTH,
						ForgeDirection.SOUTH, ForgeDirection.WEST,
						ForgeDirection.EAST }, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, ForgeDirection.DOWN, false, true);
	}

	@Override
	public void updateEntity() {
		addBucketToTank(1,2,0);
		getBucketFromTank(3,4,1);
		/*
		ItemStack waterStacks = getStackInSlot(1);
		ItemStack bucketOutputStack = getStackInSlot(2);
		if (waterStacks != null
				&& waterStacks.itemID == Item.bucketWater.itemID
				&& waterStacks.stackSize > 0) {
			if (bucketOutputStack == null) {

				MachineFluidTank tank = this.getFluidTankForSlot(0);

				if (this.tankHasRoomFor(0, FluidRegistry.WATER.getID(), 1000)) {
					this.decrStackSize(1, 1); // take water out
					Fluid fluid = FluidRegistry.WATER;
					if (this.removeFromSlot(1, Item.bucketWater.itemID, 1)) {
						tank.fill(new FluidStack(fluid, 1000), true);
						this.setInventorySlotContents(2, new ItemStack(
								Item.bucketEmpty, 1));
					}
				}
			}
		}*/
		super.updateEntity();
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
	protected boolean isTankValidForLiquid(int slot, int fluidId) {
		if (slot == 0)
			return fluidId == FluidRegistry.WATER.getID();
		return false;
	}

}
