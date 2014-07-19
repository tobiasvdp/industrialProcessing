package mod.industrialProcessing.plants.machine.hydroCyclone;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTankWorkPower;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityHydroCyclone extends TileEntityMachineTankWorkPower {

	public TileEntityHydroCyclone() {
		super(recipes, LocalDirection.RIGHT, 10000, 100);
		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		// 0: Liquid Input Full Input
		addStack(null, nodirections, true, false);
		// 1: Liquid Input Empty Output
		addStack(null, nodirections, false, true);
		// 2: Paste Output Empty Input
		addStack(null, nodirections, true, false);
		// 3: Paste Output Full Output
		addStack(null, nodirections, false, true);
		// 4 : Dirty Water Output Empty Input
		addStack(null, nodirections, true, false);
		// 5: Dirty Water Output Full Output
		addStack(null, nodirections, false, true);
		LocalDirection[] allSides = new LocalDirection[] { LocalDirection.LEFT, LocalDirection.RIGHT, LocalDirection.FRONT, LocalDirection.BACK };

		// 0: input tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.UP, true, false);
		// 1: paste output tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true);
		// 2: dirty water output tank
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, false, true);

		animated = false;
	}

	public static RecipesHydroCyclone recipes = new RecipesHydroCyclone();

}
