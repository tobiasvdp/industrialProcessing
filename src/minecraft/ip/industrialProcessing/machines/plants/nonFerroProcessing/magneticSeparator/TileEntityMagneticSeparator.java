package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import java.util.Iterator;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.machines.plants.metalProcessing.extruder.RecipesExtruder;
import ip.industrialProcessing.recipes.Recipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityMagneticSeparator extends TileEntityPoweredFluidWorkerMachine {

	public static RecipesMagneticSeparator recipes = new RecipesMagneticSeparator();

	public TileEntityMagneticSeparator() {
		super(LocalDirection.LEFT, 10000);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addStack(null, LocalDirection.UP, true, false);
		
		addStack(null, LocalDirection.DOWN, false, true);
		addStack(null, LocalDirection.RIGHT, false, true);
		addStack(null, LocalDirection.BACK, false, true);
		addStack(null, LocalDirection.FRONT, false, true);
	}

	@Override
	public void updateEntity() {
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
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0)
			return recipes.isValidInput(slot, itemID);
		return false;
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
	}

	@Override
	protected boolean isTankValidForFluid(int slot, int fluidId) {
	    return recipes.isValidFluidInput(0, fluidId);
	}


}
