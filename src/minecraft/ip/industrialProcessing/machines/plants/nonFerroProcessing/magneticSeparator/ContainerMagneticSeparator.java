package ip.industrialProcessing.machines.plants.nonFerroProcessing.magneticSeparator;

import ip.industrialProcessing.machines.TileEntityPoweredFluidWorkerMachine;
import ip.industrialProcessing.machines.containers.ContainerPoweredFluidWorkerMachine;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerMagneticSeparator extends ContainerPoweredFluidWorkerMachine {

	private TileEntityPoweredFluidWorkerMachine tileEntity;
	private SlotBase inputSlot;
	private SlotOutput[] outputSlot;

	public ContainerMagneticSeparator(InventoryPlayer inventoryPlayer, TileEntityPoweredFluidWorkerMachine tileEntity) {
		super(inventoryPlayer, tileEntity);
		this.tileEntity = tileEntity;

		inputSlot = new SlotBase(tileEntity, 0, 44, 35);
		outputSlot =  new SlotOutput[4];
		outputSlot[0] = new SlotOutput(tileEntity, 1, 116, 5);
		outputSlot[1] = new SlotOutput(tileEntity, 2, 116, 25);
		outputSlot[2] = new SlotOutput(tileEntity, 3, 116, 45);
		outputSlot[3] = new SlotOutput(tileEntity, 4, 116, 65);
		
		addSlotToContainer(inputSlot);
		addSlotToContainer(outputSlot[0]);
		addSlotToContainer(outputSlot[1]);
		addSlotToContainer(outputSlot[2]);
		addSlotToContainer(outputSlot[3]);

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
        
        addWorkerToContainer(tileEntity.getWorker());
        addPowerToContainer(tileEntity.getMainPowerStorage());
	}

	@Override
	public int getSizeInventory() {
		return 5;
	}

}
