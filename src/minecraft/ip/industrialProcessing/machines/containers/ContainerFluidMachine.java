package ip.industrialProcessing.machines.containers;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;

public class ContainerFluidMachine<T extends TileEntity & IMachineContainerEntity & IFluidMachineContainerEntity> extends ContainerMachine<T> {

	private T tileEntityFluidMachine;


	public ContainerFluidMachine(InventoryPlayer inventoryPlayer,
			T tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityFluidMachine = tileEntity;
	}

	private ArrayList<ProgressBarHandlerInfo> tankHandlers = new ArrayList<ProgressBarHandlerInfo>();
	protected void addTankToContainer(int tankSlot)
	{ 
		ProgressBarTankHandler handler = new ProgressBarTankHandler(this.tileEntityFluidMachine, tankSlot);
		ProgressBarHandlerInfo handlerInfo = this.addProgressBar(handler);
		this.tankHandlers.add(handlerInfo);
	}
	
	public ProgressInfoTank getProgressInfoTank(int containerTankSlot)
	{
		ProgressBarHandlerInfo handlerInfo = this.tankHandlers.get(containerTankSlot);
		return ProgressBarTankHandler.getInfo(handlerInfo);
	}
	 
}
