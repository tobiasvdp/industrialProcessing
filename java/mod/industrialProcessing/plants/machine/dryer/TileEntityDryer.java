package mod.industrialProcessing.plants.machine.dryer;

import java.util.Iterator;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTankWorkPower;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityDryer extends TileEntityMachineTankWorkPower {

	public static RecipesDryer recipes = new RecipesDryer();
	
	public TileEntityDryer() {
		super(recipes,LocalDirection.RIGHT, 10000,100);
		addStack(null, new LocalDirection[] { LocalDirection.FRONT, LocalDirection.BACK }, false, true); // Mixing
																											// ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full Input
		addStack(null, nodirections, false, true); // Liquid Input Empty Output
		addStack(null, nodirections, true, false); // Liquid Output Empty Input
		addStack(null, nodirections, false, true); // Liquid Output Full Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		
		setupPowerSlot();
		animated = true;
	}


}
