package ip.industrialProcessing.multiblock.core.block.blastFurnace;

import net.minecraft.item.ItemStack;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;

public class TEmultiblockBlastFurnace extends TEmultiblockCoreInv {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMachine recipes = new RecipesMultiblockBlastFurnace();
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 1, 0);
		
		int i = 0;
		layout.setCoreID(i++,0,0, IndustrialProcessing.BLmultiblockBlastFurnace.blockID);
		layout.setBlockID(0, 1, 0, i++, 0, 0, IndustrialProcessing.BLmultiblockBlastFurnaceTower.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);
		
		
		//set tiers
		tierRequirments = new TierCollection(1);
		
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);

	}
	public TEmultiblockBlastFurnace() {
		super(structure, tierRequirments,recipes);
	}
	@Override
	public int[] getAccessibleSlotsFromSide(int ID, int side) {
	    // TODO Auto-generated method stub
	    return null;
	}
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int ID, int side) {
	    // TODO Auto-generated method stub
	    return false;
	}
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int ID, int side) {
	    // TODO Auto-generated method stub
	    return false;
	}
	@Override
	protected boolean isValidInput(int slot, int itemID) {
	    // TODO Auto-generated method stub
	    return false;
	}
}
