package ip.industrialProcessing.power.plants;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.machines.containers.ContainerFluidMachine;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.utils.containers.ContainerUtils;

public class ContainerTurbine extends ContainerFluidMachine {

	private ProgressBarHandlerInfo rpmInfo;
	private TileEntityTurbine turbine;

	public ContainerTurbine(InventoryPlayer inventoryPlayer, TileEntityTurbine tileEntity) {
		super(inventoryPlayer, tileEntity); 
		this.turbine = tileEntity;
		addTankToContainer(0);
		addTankToContainer(1);
		this.rpmInfo = addProgressBar(new IProgressBarHandler() {
			
			@Override
			public int getValueCount() {
				return 1;
			}
			
			@Override
			public int getValue(int i) {
				if(i == 0)
					return turbine.getRPM();
				return 0;
			}
		});
		


		addSlotToContainer(new SlotBase(tileEntity, 0, 152, 19));
		addSlotToContainer(new SlotBase(tileEntity, 1, 152, 69-16));
		
		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}

	public int getRpm() { 
		return this.rpmInfo.getValueStorage()[0];
	}

}
