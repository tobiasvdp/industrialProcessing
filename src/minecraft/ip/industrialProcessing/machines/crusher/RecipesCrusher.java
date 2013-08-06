package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesCrusher extends RecipesMachine {
	public RecipesCrusher()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		//copper ore to Crushed copper chunks
		Recipe copperCrushing = new Recipe();
		copperCrushing.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, IndustrialProcessing.blockCopperOre.blockID, RecipeSlotType.INVENTORY, 1)
		};
		
		copperCrushing.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0)
		};
		copperCrushing.workRequired = 30;
		addRecipe(copperCrushing);
		
		//Large copper to Crushed copper chunks
		Recipe copperCrushing2 = new Recipe();
		copperCrushing2.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, IndustrialProcessing.itemCopperLargeChunks.itemID, RecipeSlotType.INVENTORY, 1)
		};
		
		copperCrushing2.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemCopperCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0)
		};
		copperCrushing2.workRequired = 30;		
		addRecipe(copperCrushing2);
		
		//Tin ore to Crushed Tin chunks
		Recipe TinCrushing = new Recipe();
		TinCrushing.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, IndustrialProcessing.blockTinOre.blockID, RecipeSlotType.INVENTORY, 1)
		};
		
		TinCrushing.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0)
		};
		TinCrushing.workRequired = 30;		
		addRecipe(TinCrushing);
		
		//Large Tin to Crushed Tin chunks
		Recipe TinCrushing2 = new Recipe();
		TinCrushing2.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, IndustrialProcessing.itemTinLargeChunks.itemID, RecipeSlotType.INVENTORY, 1)
		};
		
		TinCrushing2.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemTinCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0)
		};
		TinCrushing2.workRequired = 30;		
		addRecipe(TinCrushing2);
		
		//Iron ore to Crushed Iron chunks
		Recipe IronCrushing = new Recipe();
		IronCrushing.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, Block.oreIron.blockID, RecipeSlotType.INVENTORY, 1)
		};
		
		IronCrushing.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 3, 0)
		};
		IronCrushing.workRequired = 30;		
		addRecipe(IronCrushing);
		
		//Large Iron to Crushed Iron chunks
		Recipe IronCrushing2 = new Recipe();
		IronCrushing2.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, IndustrialProcessing.itemIronLargeChunks.itemID, RecipeSlotType.INVENTORY, 1)
		};
		
		IronCrushing2.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, IndustrialProcessing.itemIronCrushedChunks.itemID, RecipeSlotType.INVENTORY, 1, 1, 0)
		};
		IronCrushing2.workRequired = 30;		
		addRecipe(IronCrushing2);
		
	}
}
