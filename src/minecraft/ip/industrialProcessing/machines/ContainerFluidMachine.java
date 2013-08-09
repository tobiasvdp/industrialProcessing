package ip.industrialProcessing.machines;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;

public class ContainerFluidMachine extends ContainerMachine {

	private TileEntityFluidMachine tileEntityFluidMachine;


	public ContainerFluidMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidMachine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityFluidMachine = tileEntity;
	}

	
	@Override
	public void addCraftingToCrafters(ICrafting par1iCrafting) { 
		super.addCraftingToCrafters(par1iCrafting); 
	}
}
