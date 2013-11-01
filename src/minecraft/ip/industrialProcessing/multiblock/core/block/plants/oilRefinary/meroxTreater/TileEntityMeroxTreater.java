package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.meroxTreater;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;

public class TileEntityMeroxTreater extends TEmultiblockCoreTankWorkerPowered  {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesMeroxTreater recipes = new RecipesMeroxTreater();
	
	public TileEntityMeroxTreater(){
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
