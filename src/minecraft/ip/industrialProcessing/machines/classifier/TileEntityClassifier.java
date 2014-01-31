package ip.industrialProcessing.machines.classifier;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.recipes.Recipe;

import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityClassifier extends TileEntityPoweredFluidWorkerMachine implements ITankSyncable {

	private TankHandler tankHandler;

	public TileEntityClassifier() {
		super(LocalDirection.LEFT, 10000, true);
		addStack(null, LocalDirection.UP, true, false); // Input Solid
		// ingredient
		addStack(null, new LocalDirection[] { LocalDirection.FRONT, LocalDirection.BACK }, false, true); // Output
																											// Solid
		// ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full Input
		addStack(null, nodirections, false, true); // Liquid Input Empty Output
		addStack(null, nodirections, true, false); // Liquid Output Empty Input
		addStack(null, nodirections, false, true); // Liquid Output Full Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.RIGHT, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);

		this.tankHandler = new TankHandler(this, new int[] { 0 }); 
		
	}
	
	@Override
	public void updateEntity() { 
		super.updateEntity();
		addBucketToTank(2, 3, 0);
		getBucketFromTank(4, 5, 1);
		if(this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
	}

	public static RecipesClassifier recipes = new RecipesClassifier();

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) 
			return recipes.isValidInput(slot, itemID);
		if (slot == 4)
			return FluidContainerRegistry.isEmptyContainer(new ItemStack(itemID, 1, 0));
		if (slot == 2) { 
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
