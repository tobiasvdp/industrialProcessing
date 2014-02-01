package ip.industrialProcessing.machines.mixer;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityMixer extends TileEntityPoweredFluidWorkerMachine implements ITankSyncable {

	public static RecipesMixer recipes = new RecipesMixer();

	private TankHandler tankHandler;

	public TileEntityMixer() {
		super(LocalDirection.LEFT, 10000, true);
		addStack(null, LocalDirection.UP, true, false); // Mixing ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full
		// Input
		addStack(null, nodirections, false, true); // Liquid Input Empty
		// Output
		addStack(null, nodirections, true, false); // Liquid Output Empty
		// Input
		addStack(null, nodirections, false, true); // Liquid Output Full
		// Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);

		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public void updateEntity() {
		addBucketToTank(1, 2, 0);
		getBucketFromTank(3, 4, 1);
		if (this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
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
	public Iterator<IMachineRecipe> iterateRecipes() {
		return recipes.getRecipes();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) // 0 is the recipe slot, others are buckets for liquid
			// containers
			return recipes.isValidInput(slot, itemID);

		if (slot == 3) // fluid output container input slot, only empty
			// container
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));

		if (slot == 1) { // fluid input container input slot, only filled
			// containers with correct fluid
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID);
		}
		return false;
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId);
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

}
