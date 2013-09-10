package ip.industrialProcessing.multiblock.core.block.rollingPress;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.utils.MultiblockActionType;

public class TEmultiblockRollingPress extends TEmultiblockCoreInv {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static RecipesMachine recipes = new RecipesCrusher();
	static{
		//set layout
		structure = new StructureMultiblock();
		
		LayoutMultiblock layout = new LayoutMultiblock(2, 3, 0, 3, 2, 0);

		
		int index = 22;
		for(int i = 0; i>= -3;i--){
		for(int j = -2;j<= 3;j++){
			layout.setBlockID(j, 0, i,index, 1,0, IndustrialProcessing.BLmultiblockFrame.blockID);
		}}
		
		layout.setBlockID(-2, 1, -2,1, 0,0, IndustrialProcessing.BLmultiblockInvInput.blockID);
		layout.setBlockID(-2, 1, -1,2, 0,0, IndustrialProcessing.BLmultiblockInvInput.blockID);
		layout.setBlockID(3, 1, -2,3, 0,0, IndustrialProcessing.BLmultiblockInvOutput.blockID);
		layout.setBlockID(3, 1, -1,4, 0,0, IndustrialProcessing.BLmultiblockInvOutput.blockID);
		
		layout.setBlockID(0, 1, 0,5, 1,0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(1, 1, 0,6, 1,0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(0, 1, -3,7, 0,1, IndustrialProcessing.BLmultiblockWheelConnector.blockID);
		layout.setBlockID(1, 1, -3,8, 0,1, IndustrialProcessing.BLmultiblockWheelConnector.blockID);
		layout.setBlockID(0, 2, 0,9, 1,0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(1, 2, 0,10, 1,0, IndustrialProcessing.BLmultiblockFrame.blockID);
		layout.setBlockID(0, 2, -3,11, 0,0, IndustrialProcessing.BLmultiblockWheelConnector.blockID);
		layout.setBlockID(1, 2, -3,12, 0,0, IndustrialProcessing.BLmultiblockWheelConnector.blockID);
		
		layout.setBlockID(0, 1, -1,13, 0,1, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(1, 1, -1,14, 0,1, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(0, 1, -2,15, 0,1, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(1, 1, -2,16, 0,1, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(0, 2, -1,17, 0,0, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(1, 2, -1,18, 0,0, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(0, 2, -2,19, 0,0, IndustrialProcessing.BLmultiblockWheel.blockID);
		layout.setBlockID(1, 2, -2,20, 0,0, IndustrialProcessing.BLmultiblockWheel.blockID);
		
		layout.setCoreID(0,1,0, IndustrialProcessing.BLmultiblockRollingPress.blockID);
		
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
	public TEmultiblockRollingPress() {
		super(structure, tierRequirments, recipes);
		
		//animation
		this.animation = new AnimationHandler[1];
		this.animation[0] = new AnimationHandler(AnimationMode.WRAP, 360f, true);
		animation[0].setSpeed(20);
		
		this.isAnimationEnabled = new boolean[1];
		this.isAnimationEnabled[0] = true;
	}

}
