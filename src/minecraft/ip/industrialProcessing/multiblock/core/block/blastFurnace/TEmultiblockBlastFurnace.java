package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupFluids;
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

public class TEmultiblockBlastFurnace extends TileEntityMultiblockCoreTankWorkerPowered {
    static StructureMultiblock structure;
    static TierCollection tierRequirments;
    public static RecipesMultiblock recipes = new RecipesMultiblockBlastFurnace();
    static {
	// set layout
	structure = new StructureMultiblock();

	LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 1, 0);

	int i = 0;
	layout.setCoreID(i++, 0, 0, ISetupMachineBlocks.BLmultiblockBlastFurnace.blockID);
	layout.setBlockIDwithGroup(0, 1, 0, i++, 0, 0, 1, ISetupMachineBlocks.BLmultiblockBlastFurnaceTower.blockID);

	structure.addLayout(layout, FacingDirection.North);
	structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
	structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
	structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

	// set tiers
	tierRequirments = new TierCollection(1);

	Tier tier = new Tier();
	tierRequirments.addTier(tier, Tiers.Tier0);

    }

    public TEmultiblockBlastFurnace() {
	super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);
	LocalDirection[] nodirections = new LocalDirection[0];

	setInventoryGroupArray(2);
	this.addStack(null, 1, LocalDirection.UP, true, false);
	this.addStack(null, 1, LocalDirection.UP, true, false);

	this.addTank(10000, 0, new ForgeDirection[] { ForgeDirection.UNKNOWN }, true, false);
	this.addTank(10000, 0, new ForgeDirection[] { ForgeDirection.DOWN }, false, true);
	this.addTank(10000, 0, new ForgeDirection[] { ForgeDirection.NORTH }, false, true);
	this.addTank(10000, 1, new ForgeDirection[] { ForgeDirection.SOUTH }, false, true);

    }

    @Override
    public void updateEntity() {
	this.fill(0, ForgeDirection.UNKNOWN, new FluidStack(ISetupFluids.itemFluidAir, 5), true);
	super.updateEntity();
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return recipes.isValidInput(slot, itemID, getTier());
    }

    @Override
    protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
	if (getTankInSlot(slot).getMultiblockID() == groupid) {
	    return recipes.isValidFluidInput(slot, fluidId, getTier());
	} else {
	    return false;
	}
    }
}
