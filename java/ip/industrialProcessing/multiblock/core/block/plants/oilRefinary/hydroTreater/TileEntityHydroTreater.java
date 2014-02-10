package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.hydroTreater;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityHydroTreater extends TileEntityMultiblockCoreTankWorkerPowered  {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesMultiblock recipes = new RecipesHydroTreater();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupMachineBlocks.blockHydroTreater.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TileEntityHydroTreater(){
		super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);
		LocalDirection[] nodirections = new LocalDirection[0];
		
		addTank(10000, 0, new ForgeDirection[] { ForgeDirection.UP }, true, false);
		addTank(10000, 0, new ForgeDirection[] { ForgeDirection.DOWN }, false, true);
		addTank(10000, 0, new ForgeDirection[] { ForgeDirection.NORTH }, true, false);
		addTank(10000, 0, new ForgeDirection[] { ForgeDirection.WEST }, false, true);
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return recipes.isValidFluidInput(slot, fluidId,getTier());
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}
}
