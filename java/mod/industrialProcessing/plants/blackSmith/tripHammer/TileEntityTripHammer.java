package mod.industrialProcessing.plants.blackSmith.tripHammer;

import cpw.mods.fml.common.registry.GameRegistry;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreInv;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.utils.DropBlock;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityTripHammer extends TileEntityMultiblockCoreInv{
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesTripHammer();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 3, 1, 1, 1);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockTripHammer);

		layout.setBlockID(1, 0, 0, i++, 0, 0, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(-1, 0, 0, i++, 0, 4, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(1, 1, 0, i++, 0, 1, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(-1, 1, 0, i++, 0, 5, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(1, 0, -1, i++, 0, 2, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(-1, 0, -1, i++, 0, 6, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(1, 1, -1, i++, 0, 3, IndustrialProcessing.blockWoodenWheel);
		layout.setBlockID(-1, 1, -1, i++, 0, 7, IndustrialProcessing.blockWoodenWheel);
		
		layout.setBlockID(0, 1, 0, i++, 0, 0, IndustrialProcessing.blockWoodenBar);
		layout.setBlockID(0, 1, 1, i++, 0, 1, IndustrialProcessing.blockWoodenBar);
		layout.setBlockID(0, 1, 2, i++, 0, 2, IndustrialProcessing.blockWoodenBar);
		layout.setBlockID(0, 1, 3, i++, 0, 0, IndustrialProcessing.blockWoodenHammer);
		layout.setBlockID(0, 0, 3, i++, 0, 0, Blocks.log);
		layout.setBlockID(1, -1, 2, i++, 0, 0, Blocks.water);
		layout.setBlockID(-1, -1, 2, i++, 0, 0, Blocks.water);
		layout.setBlockID(1, -1, 1, i++, 0, 0, Blocks.water);
		layout.setBlockID(-1, -1, 1, i++, 0, 0, Blocks.water);
		layout.setBlockID(1, -1, 0, i++, 0, 0, Blocks.water);
		layout.setBlockID(-1, -1, 0, i++, 0, 0, Blocks.water);
		layout.setBlockID(1, -1, -1, i++, 0, 0, Blocks.water);
		layout.setBlockID(-1, -1, -1, i++, 0, 0, Blocks.water);
		

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	public TileEntityTripHammer() {
		super(structure, tierRequirments, recipes);
		setInventoryGroupArray(1);
		addStack(null,0, LocalDirection.DOWN, true, false);
		addStack(null,0, LocalDirection.DOWN, false, true);
		checkLayoutInTime = true;
	}	
	
	
	int rotation = 3;
	boolean inverse = false;

	@Override
	public void updateEntity() {
		if (inverse) {
			rotation--;
			rotation--;
			rotation--;
			rotation--;
		} else {
			rotation++;
		}
		if (rotation == 25)
			inverse = true;
		if (rotation <= 3)
			inverse = false;
		
		
		if(rotation <= 3 && getStackInSlot(0) != null && (getStackInSlot(1) == null||getStackInSlot(1).stackSize ==0) ){
			decrStackSize(0, 1);
			addToSlot(1, IndustrialProcessing.itemPliersHeatedIron, 1, 0);
		}
		

		super.updateEntity();
	}

	public float getRotation() {
		return -rotation;
	}

	@Override
	protected boolean isValidInput(int slot, Item itemID) {
		return (slot == 0 && itemID.equals(IndustrialProcessing.itemPliersBloomIron)) ;
	}
	
	public void handleRightClick(EntityPlayer player) {
		if (getState() == MultiblockState.COMPLETED && player.getCurrentEquippedItem() != null) {
			if (isValidInput(0, player.getCurrentEquippedItem().getItem() )&& getStackInSlot(0) == null && getStackInSlot(1) == null) {
				if (addToSlot(0, player.getCurrentEquippedItem().getItem(), 1, 0)) {
					player.setCurrentItemOrArmor(0, new ItemStack(IndustrialProcessing.itemPliers));
				}
			}
			if (player.getCurrentEquippedItem().getItem().equals(IndustrialProcessing.itemPliers)) {
				if (getStackInSlot(1) != null && getStackInSlot(1).stackSize > 0) {
					ItemStack givenStack = decrStackSize(1, 1);
					player.setCurrentItemOrArmor(0, givenStack);
				}
			}
		}
	}
	
}
