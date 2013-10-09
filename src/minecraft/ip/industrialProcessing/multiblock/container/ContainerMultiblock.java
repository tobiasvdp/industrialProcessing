package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.api.handlers.IHandler;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.gui.CTmultiblock;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public abstract class ContainerMultiblock extends VerifyingContainer {

    private TEmultiblockCore core;

    public ContainerMultiblock(InventoryPlayer inventory,TEmultiblockCore core) {
	this.core = core;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
	return core.canInteractWith(entityplayer);
    }

    private ArrayList<IHandler> handlers = new ArrayList<IHandler>();

    private int handlerOffset = 0;

    protected void addHandler(IHandler handler) {
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
		IHandler handler = handlers.get(j);
		for (int k = 0; k < handler.getValueCount(); k++) {
		    if (handler.getValue(k) != handler.getPrevValue(k)) {
			icrafting.sendProgressBarUpdate(this, k + handler.getIndexOffset(), handler.getValue(k));
		    }
		}
		if(i == this.crafters.size() -1)
		    handler.newToOldValues();
	    }
	}
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
	super.updateProgressBar(par1, par2);
	IHandler handler = null;

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
	BindPlayerInventory(inventory, me, 0);
    }

    protected void BindPlayerInventory(InventoryPlayer inventoryPlayer, ContainerMultiblock container, int offset) {

	for (int i = 0; i < 9; i++) {
	    container.addSlotToContainer(new Slot(inventoryPlayer, i + offset, 8 + i * 18, 142));
	}
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 9; j++) {
		int o = j + i * 9 + 9 + offset;
		container.addSlotToContainer(new Slot(inventoryPlayer, o, 8 + j * 18, 84 + i * 18));
	    }
	}
    }

}
