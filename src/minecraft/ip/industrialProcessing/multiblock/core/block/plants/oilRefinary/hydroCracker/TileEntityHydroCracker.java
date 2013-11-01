package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroCracker;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;

public class TileEntityHydroCracker extends TEmultiblockCoreTankWorkerPowered  {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesHydroCracker recipes = new RecipesHydroCracker();
	
	public TileEntityHydroCracker(){
		super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);
		LocalDirection[] nodirections = new LocalDirection[0];
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		// TODO Auto-generated method stub
		return false;
	}
}
