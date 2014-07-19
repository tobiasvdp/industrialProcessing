package mod.industrialProcessing.plants.machine.classifier;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTankWorkPower;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class TileEntityClassifier extends TileEntityMachineTankWorkPower {

	public static RecipesClassifier recipes = new RecipesClassifier();

	public TileEntityClassifier() {
		super(recipes, LocalDirection.RIGHT, 10000, 100);
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

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, true, false, 2, 3);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true, 4, 5);

		setupPowerSlot();
		
		setupTankSync(0);

		animated = true;
	}
}
