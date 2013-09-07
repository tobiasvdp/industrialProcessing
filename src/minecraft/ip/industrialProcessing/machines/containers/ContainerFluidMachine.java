package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.machines.TileEntityFluidMachine;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidTankInfo;

public class ContainerFluidMachine extends ContainerMachine {

	private TileEntityFluidMachine tileEntityFluidMachine;


	public ContainerFluidMachine(InventoryPlayer inventoryPlayer,
			TileEntityFluidMachine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.tileEntityFluidMachine = tileEntity;
	}

	private ArrayList<ProgressBarHandlerInfo> tankHandlers = new ArrayList<ProgressBarHandlerInfo>();
	protected void addTankToContainer(int tankSlot)
	{
		FluidTankInfo info = this.tileEntityFluidMachine.getTankInfoForSlot(tankSlot);
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
