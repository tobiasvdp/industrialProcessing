package mod.industrialProcessing.plants.crafting.assembler;

import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidStack;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.plants.middleAge.tripHammer.RecipesTripHammer;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;

public class TileEntityAssembler extends TileEntityMultiblockCoreTankWorkerPowered{

	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	public static RecipesMultiblock recipes = new RecipesTripHammer();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 2, 0, 3, 1, 1);

		int i = 0;
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockAssembler);

		layout.setBlockIDwithGroup(0, -1, 0, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(-1, -1, 0, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+1, -1, 0, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+2, -1, 0, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		
		layout.setBlockIDwithGroup(0, -1, -1, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(-1, -1, -1, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+1, -1, -1, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+2, -1, -1, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		
		layout.setBlockIDwithGroup(0, -1, -2, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(-1, -1, -2, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+1, -1, -2, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+2, -1, -2, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		
		layout.setBlockIDwithGroup(0, -1, -3, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(-1, -1, -3, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+1, -1, -3, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		layout.setBlockIDwithGroup(+2, -1, -3, i++, 0, 0, 1, IndustrialProcessing.blockMachineFrame,IndustrialProcessing.blockIOPort);
		
		layout.setBlockIDwithGroup(1, 0, 0, i++, 0, 0, 1, IndustrialProcessing.blockConveyorBelt);
		layout.setBlockIDwithGroup(1, 0, -1, i++, 0, 0, 1, IndustrialProcessing.blockConveyorBelt);
		layout.setBlockIDwithGroup(1, 0, -2, i++, 0, 0, 1, IndustrialProcessing.blockConveyorBelt);
		layout.setBlockIDwithGroup(2, 0, -3, i++, 0, 0, 1, IndustrialProcessing.blockConveyorBelt);
		
		
		

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}
	
	public TileEntityAssembler() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
	}

}
