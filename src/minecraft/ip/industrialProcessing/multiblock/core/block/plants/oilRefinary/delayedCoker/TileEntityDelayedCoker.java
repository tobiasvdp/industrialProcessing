package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.delayedCoker;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;

public class TileEntityDelayedCoker extends TEmultiblockCoreTankWorkerPowered  {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesDelayedCoker recipes = new RecipesDelayedCoker();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockDelayedCoker.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TileEntityDelayedCoker(){
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
