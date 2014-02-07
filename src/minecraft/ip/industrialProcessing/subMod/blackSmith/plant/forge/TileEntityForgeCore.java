package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherCore;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.subMod.blackSmith.config.ISetupBlackSmith;
import ip.industrialProcessing.subMod.blackSmith.plant.waterBasin.RecipesWaterBasin;

public class TileEntityForgeCore extends TileEntityMultiblockSwitcherCore {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	private TankHandler tankHandler;
	public static RecipesMultiblock recipes = new RecipesForge();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 0, 1, 2, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupBlackSmith.blockForge.blockID);

		layout.setBlockID(-1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 0, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 1, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 1, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(0, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		
		layout.setBlockID(0, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(-1, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);
		layout.setBlockID(1, 2, 0, i++, 0, 0, ISetupBlackSmith.blockForge.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityForgeCore() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		return false;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}
}
