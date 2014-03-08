package mod.industrialProcessing.blockContainer.machine.crusher;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWork;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class TileEntityCrusher extends TileEntityMachineInvWork {
	public TileEntityCrusher() {
		//super(LocalDirection.LEFT, 10000, 100, true); // does 100 work per tick, lasts
		super(new RecipesCrusher());										// 100 ticks
		
		this.addStack(null, LocalDirection.BACK, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
		//setupPowerSlot();
	}
}
