package ip.industrialProcessing.power.plants;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.TileEntityFluidMachine;
import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerBoiler extends ContainerFluidMachine {

	private ProgressBarHandlerInfo tempInfo;
	private TileEntityBoiler boiler;

	public ContainerBoiler(InventoryPlayer inventoryPlayer, TileEntityBoiler tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.boiler = tileEntity;
		addTankToContainer(0);
		addTankToContainer(1);
		this.tempInfo = addProgressBar(new IProgressBarHandler() {
			
			@Override
			public int getValueCount() {
				return 1;
			}
			
			@Override
			public int getValue(int i) {
				if(i == 0)
					return boiler.getTemperature();
				return 0;
			}
		});
		


		addSlotToContainer(new SlotBase(tileEntity, 0, 8, 19));
		addSlotToContainer(new SlotBase(tileEntity, 1, 8, 69-16));
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	public int getTemperature() { 
		return this.tempInfo.getValueStorage()[0];
	}

}
