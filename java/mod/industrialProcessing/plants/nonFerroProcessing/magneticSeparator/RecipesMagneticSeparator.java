package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeInputSlot;
import ip.industrialProcessing.recipes.RecipeOutputSlot;
import ip.industrialProcessing.recipes.RecipeSlotType;

public class RecipesMagneticSeparator extends RecipesMachine {
	public RecipesMagneticSeparator()
	{
		addDefaultRecipes();
	}

	private void addDefaultRecipes() {
		//Copper minererals seperation
		Recipe CopperSeperation = new Recipe();
		CopperSeperation.inputs = new RecipeInputInventorySlot[]{
				new RecipeInputInventorySlot(0, ISetupItems.itemCopperMineral.itemID, RecipeSlotType.INVENTORY, 1)
		};
		
		CopperSeperation.outputs = new RecipeOutputInventorySlot[]{
				new RecipeOutputInventorySlot(1, ISetupItems.itemCopperPurified.itemID, RecipeSlotType.INVENTORY, 1, 1, 0),
				new RecipeOutputInventorySlot(2, ISetupItems.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0),
				new RecipeOutputInventorySlot(3, ISetupItems.itemZincDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0),
				new RecipeOutputInventorySlot(4, ISetupItems.itemSilicium.itemID, RecipeSlotType.INVENTORY, 0, 1, 0)
		};
		CopperSeperation.workRequired = 30;		
		addRecipe(CopperSeperation);
		
		//Tin minererals seperation
		Recipe TinSeperation = new Recipe();
		TinSeperation.inputs = new RecipeInputInventorySlot[]{
				new RecipeInputInventorySlot(0, ISetupItems.itemTinOxideDust.itemID, RecipeSlotType.INVENTORY, 1)
		};
		
		TinSeperation.outputs = new RecipeOutputInventorySlot[]{
				new RecipeOutputInventorySlot(1, ISetupItems.itemCopperPurified.itemID, RecipeSlotType.INVENTORY, 1, 1, 0),
				new RecipeOutputInventorySlot(2, ISetupItems.itemIronOxideDust.itemID, RecipeSlotType.INVENTORY, 0, 1, 0),
		};
		TinSeperation.workRequired = 30;		
		addRecipe(TinSeperation);
	}
}
