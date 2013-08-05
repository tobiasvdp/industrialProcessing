package ip.industrialProcessing.machines.crusher;

import net.minecraft.block.Block;
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
				new RecipeInputSlot(0, ConfigBlocks.BlockCopperOreID(), RecipeSlotType.INVENTORY, 1)
		};
		
		copperCrushing.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, ConfigItems.ItemCopperCrushedChunksID(), RecipeSlotType.INVENTORY, 1, 3, 0)
		};
		copperCrushing.powerRequired = 30;		
		addRecipe(copperCrushing);
		
		//Large copper to Crushed copper chunks
		Recipe copperCrushing2 = new Recipe();
		copperCrushing2.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, ConfigItems.ItemCopperLargeChunksID(), RecipeSlotType.INVENTORY, 1)
		};
		
		copperCrushing2.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, ConfigItems.ItemCopperCrushedChunksID(), RecipeSlotType.INVENTORY, 1, 3, -0.5)
		};
		copperCrushing2.powerRequired = 30;		
		addRecipe(copperCrushing2);
		
		//Tin ore to Crushed Tin chunks
		Recipe TinCrushing = new Recipe();
		TinCrushing.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, ConfigBlocks.BlockTinOreID(), RecipeSlotType.INVENTORY, 1)
		};
		
		TinCrushing.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, ConfigItems.ItemTinCrushedChunksID(), RecipeSlotType.INVENTORY, 1, 3, 0)
		};
		TinCrushing.powerRequired = 30;		
		addRecipe(TinCrushing);
		
		//Large Tin to Crushed Tin chunks
		Recipe TinCrushing2 = new Recipe();
		TinCrushing2.inputs = new RecipeInputSlot[]{
				new RecipeInputSlot(0, ConfigItems.ItemTinLargeChunksID(), RecipeSlotType.INVENTORY, 1)
		};
		
		TinCrushing2.outputs = new RecipeOutputSlot[]{
				new RecipeOutputSlot(1, ConfigItems.ItemTinCrushedChunksID(), RecipeSlotType.INVENTORY, 1, 3, -0.5)
		};
		TinCrushing2.powerRequired = 30;		
		addRecipe(TinCrushing2);
		
	}
}
