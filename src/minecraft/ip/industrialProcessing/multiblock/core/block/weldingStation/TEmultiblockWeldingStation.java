package ip.industrialProcessing.multiblock.core.block.weldingStation;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.machines.mixer.RecipesMixer;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.TierRequirement;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;
import ip.industrialProcessing.multiblock.utils.TEmultiblockItemStackType;
import ip.industrialProcessing.multiblock.utils.blockSide;

public class TEmultiblockWeldingStation extends TEmultiblockCoreInv{
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static RecipesMachine recipes = new RecipesCrusher();
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(2, 0, 0, 0, 1, 0);
		
		int i = 0;
		layout.setCoreID(i++,0,1, IndustrialProcessing.BLmultiblockWeldingStation.blockID);
		
		layout.setBlockID(-1, 0, 0,i++, 0,0, IndustrialProcessing.BLmultiblockWeldingTableExt.blockID);
		layout.setBlockID(-2, 0, 0,i++, 0,0, IndustrialProcessing.BLmultiblockInvInput.blockID,0);
		layout.setBlockID(-2, 1, 0,i++, 0,1, IndustrialProcessing.BLmultiblockScreen.blockID,0);
		layout.setBlockID(0, 1, 0,i++, 0,0, IndustrialProcessing.BLmultiblockScreen.blockID);
		layout.setBlockID(-1, 1, 0,i++, 0,1, IndustrialProcessing.BLmultiblockScreen.blockID);
		
		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);
		
		
		//set tiers
		tierRequirments = new TierCollection(3);
		
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
		
		tier = new Tier();
		tier.setBlockPresent(2);
		tier.setAction(MultiblockActionType.modelConnection, 1, 1);
		tierRequirments.addTier(tier, Tiers.Tier1);
		
		tier = new Tier();
		tier.setBlockPresent(2);
		tier.setBlockPresent(3);
		tier.setAction(MultiblockActionType.modelConnection, 1, 1);
		tier.setAction(MultiblockActionType.modelConnection, 5, 2);
		tierRequirments.addTier(tier, Tiers.Tier2);

	}
	public TEmultiblockWeldingStation() {
		super(structure, tierRequirments,recipes);
		
		//add slots and set default IO for multiblocks
		addItemSlot(TEmultiblockItemStackType.input).addIdSide(0, blockSide.right).addIdSide(2, blockSide.front);
		addItemSlot(TEmultiblockItemStackType.output).addIdSide(0,blockSide.right);
		
		
	}

}
