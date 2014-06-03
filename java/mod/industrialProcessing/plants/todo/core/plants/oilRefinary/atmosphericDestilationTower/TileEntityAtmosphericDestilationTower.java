package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.atmosphericDestilationTower;

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
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityAtmosphericDestilationTower extends TileEntityMultiblockCoreTankWorkerPowered {
	private static StructureMultiblock structure;
	private static TierCollection tierRequirments;
	private static RecipesMultiblock recipes = new RecipesAtmosphericDestilationTower();

	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 3, 0);
		int tankPlating = ISetupMachineBlocks.blockTankPlating.blockID;

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupMachineBlocks.blockAtmosphericDestilationTower.blockID);

		layout.setBlockIDwithGroup(0, 1, 0, i++, 0, 0,2, ISetupMachineBlocks.blockDestilationTray.blockID);
		layout.setBlockIDwithGroup(0, 2, 0, i++, 0, 0,3, ISetupMachineBlocks.blockDestilationTray.blockID);
		layout.setBlockIDwithGroup(0, 3, 0, i++, 0, 0,4, ISetupMachineBlocks.blockDestilationTray.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityAtmosphericDestilationTower() {
		super(structure, tierRequirments, recipes, LocalDirection.LEFT, 10000, 100);

		LocalDirection[] nodirections = new LocalDirection[0];

		this.addStack(null, nodirections, true, false);
		this.addStack(null, nodirections, false, true);
		this.addTank(10000, 0, new ForgeDirection[] { ForgeDirection.EAST }, true, false);
		this.addTank(5000, 0, new ForgeDirection[] { ForgeDirection.WEST }, false, true);
		this.addTank(10000, 2, new ForgeDirection[] { ForgeDirection.EAST }, false, true);
		this.addTank(10000, 2, new ForgeDirection[] { ForgeDirection.WEST }, false, true);
		this.addTank(10000, 3, new ForgeDirection[] { ForgeDirection.EAST }, false, true);
		this.addTank(10000, 3, new ForgeDirection[] { ForgeDirection.WEST }, false, true);
		this.addTank(10000, 4, new ForgeDirection[] { ForgeDirection.EAST }, false, true);
		this.addTank(5000, 4, new ForgeDirection[] { ForgeDirection.WEST }, false, true);
	}

	@Override
	public void updateEntity() {
		addBucketToTank(0, 1, 0);
		super.updateEntity();
	};

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot == 0) { // fluid input container input slot, only filled
			// containers with correct fluid
			FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(new ItemStack(itemID, 1, 0));
			if (fluid == null)
				return false;
			return recipes.isValidFluidInput(0, fluid.fluidID,getTier());
		}
		return false;
	}

	@Override
	protected boolean isTankValidForFluid(int groupid, int slot, int fluidId) {
		if(groupid == -1)
			return recipes.isValidFluidInput(slot, fluidId,getTier());
		else{
			if(getTankInSlot(slot).getMultiblockID() == groupid){
				return recipes.isValidFluidInput(slot, fluidId,getTier());
			}else{
				return false;
			}
		}
	}

}
