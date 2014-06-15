package mod.industrialProcessing.plants.blackSmith.grindingStone;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvWork;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class TileEntityGrindingStone extends TileEntityMachineInvWork {
    public static RecipesGrindingStone recipes = new RecipesGrindingStone();

    public TileEntityGrindingStone() {
	super(recipes);
	LocalDirection[] nodirections = new LocalDirection[0];

	this.addStack(null, nodirections, true, false);
	this.addStack(null, nodirections, false, true);
    }

}
