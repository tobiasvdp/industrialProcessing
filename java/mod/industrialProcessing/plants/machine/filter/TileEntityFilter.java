package mod.industrialProcessing.plants.machine.filter;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWorkPower;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class TileEntityFilter extends TileEntityMachineInvWorkPower {

	public static RecipesFilter recipes = new RecipesFilter();

	public TileEntityFilter() {
		super(recipes, LocalDirection.RIGHT, 10000, 100);
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.LEFT, false, true);
		this.addStack(null, LocalDirection.DOWN, false, true);
		setupPowerSlot();
		animated = true;
	}
}
