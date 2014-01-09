package ip.industrialProcessing.machines.crusher;

import java.util.ArrayList;
import java.util.Iterator;

import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.container.slot.layout.SlotLayout;
import ip.industrialProcessing.machines.containers.ContainerPoweredWorkerMachine;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.slots.SlotBase;
import ip.industrialProcessing.slots.SlotOutput;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.registry.RecipeRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerCrusher extends ContainerPoweredWorkerMachine {

	protected Slot[] slots;
	protected TileEntityCrusher tileEntityCrusher;
	protected GuiLayout layout;

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntityCrusher.isUseableByPlayer(entityplayer);
	}

	public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
		super(inventoryPlayer, tileEntityCrusher);
		if (tileEntityCrusher.getBlockType() instanceof IGuiLayout)
			layout = ((IGuiLayout) tileEntityCrusher.getBlockType()).getGuiLayout();
		this.tileEntityCrusher = tileEntityCrusher;

		if (this.layout != null) {
			Iterator<Slot> slotIterator = layout.getSlots(tileEntityCrusher);
			while(slotIterator.hasNext()){
					addSlotToContainer(slotIterator.next());
			}
			
		} else {
			slots = new Slot[2];
			slots[0] = new SlotBase(tileEntityCrusher, 0, 44, 33);
			slots[1] = new SlotOutput(tileEntityCrusher, 1, 104, 33);

			addSlotToContainer(slots[0]);
			addSlotToContainer(slots[1]);

		}

		ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);

		addWorkerToContainer(tileEntityCrusher.getWorker());
		addPowerToContainer(tileEntityCrusher.getMainPowerStorage());
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}
