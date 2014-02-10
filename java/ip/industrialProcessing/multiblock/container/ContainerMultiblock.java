package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public abstract class ContainerMultiblock extends VerifyingContainer {

	private TileEntityMultiblockCore core;

	public ContainerMultiblock(InventoryPlayer inventory, TileEntityMultiblockCore core) {
		this.core = core;
		for (int j = 0; j < handlers.size(); j++) {
			IHandlerContainer handler = handlers.get(j);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return core.canInteractWith(entityplayer);
	}

	private ArrayList<IHandlerContainer> handlers = new ArrayList<IHandlerContainer>();

	private int handlerOffset = 0;
	protected void addHandler(IHandlerContainer handler) {
		handlers.add(handler);
		handler.setIndexOffset(handlerOffset);
		handlerOffset += handler.getValueCount();
	}

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			for (int j = 0; j < handlers.size(); j++) {
				IHandlerContainer handler = handlers.get(j);
				for (int k = 0; k < handler.getValueCount(); k++) {
					if (handler.getValue(k) != handler.getPrevValue(k)) {
						icrafting.sendProgressBarUpdate(this, k + handler.getIndexOffset(), handler.getValue(k));
					}
				}
				if (i == this.crafters.size() - 1)
					handler.newToOldValues();
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int par1, int par2) {
	    System.out.println("syncing " + par1 + " " + par2);
		super.updateProgressBar(par1, par2);
		IHandlerContainer handler = null;

		int i = 0;
		boolean found = false;
		while (!found) {
			handler = handlers.get(i);
			if (par1 >= handler.getIndexOffset() && par1 < (handler.getIndexOffset() + handler.getValueCount())) {
				found = true;
			}
			i++;
		}

		int index = par1 - handler.getIndexOffset();
		handler.put(index, par2);
	}

	public void BindSlots(Slot[] slots, InventoryPlayer inventory, ContainerMultiblock me) {
		for (int i = 0; i < slots.length; i++) {
			me.addSlotToContainer(slots[i]);
		}
		BindPlayerInventory(inventory, me, 0,0,0);
	}
	public void BindSlots(Slot[] slots, InventoryPlayer inventory, ContainerMultiblock me,int offsetx,int offsety) {
		for (int i = 0; i < slots.length; i++) {
			me.addSlotToContainer(slots[i]);
		}
		BindPlayerInventory(inventory, me, 0,offsetx,offsety);
	}
	protected void BindPlayerInventory(InventoryPlayer inventoryPlayer, ContainerMultiblock container, int offset,int offsetx,int offsety) {

		for (int i = 0; i < 9; i++) {
			container.addSlotToContainer(new Slot(inventoryPlayer, i + offset, offsetx + 8 + i * 18, offsety + 142));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				int o = j + i * 9 + 9 + offset;
				container.addSlotToContainer(new Slot(inventoryPlayer, o, offsetx + 8 + j * 18, offsety + 84 + i * 18));
			}
		}
	}
}
