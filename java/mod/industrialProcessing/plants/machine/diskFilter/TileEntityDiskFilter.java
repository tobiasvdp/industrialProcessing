package mod.industrialProcessing.plants.machine.diskFilter;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTankWorkPower;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityDiskFilter extends TileEntityMachineTankWorkPower {

	public static RecipesDiskFilter recipes = new RecipesDiskFilter();

	public TileEntityDiskFilter() {
		super(recipes, LocalDirection.RIGHT, 10000, 100);
		addStack(null, LocalDirection.LEFT, false, true); // Mixing ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full Input
		addStack(null, nodirections, false, true); // Liquid Input Empty Output
		addStack(null, nodirections, true, false); // Liquid Input Full Input
		addStack(null, nodirections, false, true); // Liquid Input Empty Output
		addStack(null, nodirections, true, false); // Liquid Output Empty Input
		addStack(null, nodirections, false, true); // Liquid Output Full Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false, 1, 2);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, new LocalDirection[] { LocalDirection.BACK, LocalDirection.FRONT }, true, false, 3, 4);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true, 5, 6);
	}

}
