package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidMachine;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class ContainerFluidMachine extends ContainerMachine {

	private TileEntityFluidMachine tileEntityFluidMachine;


	public ContainerFluidMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidMachine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityFluidMachine = tileEntity;
	}

	public void addTank(int slot)
	{
		FluidTankInfo info = this.tileEntityFluidMachine.getTankInfoForSlot(slot);
		ProgresBarTankHandler handler = new ProgresBarTankHandler(info);
		this.addProgressBar(handler);
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting par1iCrafting) { 
		super.addCraftingToCrafters(par1iCrafting); 
	}
}
