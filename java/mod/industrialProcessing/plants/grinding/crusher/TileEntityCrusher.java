package mod.industrialProcessing.plants.grinding.crusher;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWork;
import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWorkPower;
import mod.industrialProcessing.gui.guide.pages.machines.MachineRecipesTab;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMachine;

public class TileEntityCrusher extends TileEntityMachineInvWorkPower {
	
	public static RecipesMachine recipes =  new RecipesCrusher();
	
	public TileEntityCrusher() {
		super(recipes,LocalDirection.RIGHT, 10000, 100);										
		
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
		setupPowerSlot();
	}
}
