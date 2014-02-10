package ip.industrialProcessing.machines.containers;

import ip.industrialProcessing.utils.containers.IContainerAdd;
import ip.industrialProcessing.utils.containers.IContainerTransfer;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMachine<T extends TileEntity & IMachineContainerEntity> extends VerifyingContainer implements IContainerAdd, IContainerTransfer {

    private int progressBarHandlerCount;
    private int progressBarCount;
    private ArrayList<ProgressBarHandlerInfo> handlers = new ArrayList<ProgressBarHandlerInfo>();
    private T tileEntity;

    public ContainerMachine(InventoryPlayer inventoryPlayer, T tileEntity) {
	this.tileEntity = tileEntity;
    }

    protected ProgressBarHandlerInfo addProgressBar(IProgressBarHandler handler) {
	int handlerIndex = progressBarHandlerCount;
	int progressBarsStartIndex = progressBarCount;

	progressBarHandlerCount++;
	progressBarCount += handler.getValueCount();

	ProgressBarHandlerInfo info = new ProgressBarHandlerInfo(handler, handlerIndex, progressBarsStartIndex);
	handlers.add(info);
	return info;
    }

    @Override
    public void detectAndSendChanges() {
	super.detectAndSendChanges();

	for (int i = 0; i < this.crafters.size(); ++i) {
	    ICrafting icrafting = (ICrafting) this.crafters.get(i);
	    for (int j = 0; j < handlers.size(); j++) {
		ProgressBarHandlerInfo handlerInfo = handlers.get(j);
		IProgressBarHandler handler = handlerInfo.getHandler();
		int[] valueStore = handlerInfo.getValueStorage();
		for (int k = 0; k < handler.getValueCount(); k++) {
		    int index = k + handlerInfo.getProgressBarsStartIndex();
		    int value = handler.getValue(k);
		    if (value != valueStore[k]) {
			icrafting.sendProgressBarUpdate(this, index, value);
		    }
		}
	    }
	}

	for (int j = 0; j < handlers.size(); j++) {
	    ProgressBarHandlerInfo handlerInfo = handlers.get(j);
	    IProgressBarHandler handler = handlerInfo.getHandler();
	    int[] valueStore = handlerInfo.getValueStorage();
	    for (int k = 0; k < handler.getValueCount(); k++) {
		int index = k + handlerInfo.getProgressBarsStartIndex();
		int value = handler.getValue(k);
		valueStore[k] = value;
	    }
	}
    }

    // TODO: optimize this, the loop needs to be reduced
    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
	super.updateProgressBar(par1, par2);

	for (int j = 0; j < handlers.size(); j++) {
	    ProgressBarHandlerInfo handlerInfo = handlers.get(j);
	    IProgressBarHandler handler = handlerInfo.getHandler();
	    int[] valueStore = handlerInfo.getValueStorage();
	    for (int k = 0; k < handler.getValueCount(); k++) {
		int index = k + handlerInfo.getProgressBarsStartIndex();
		if (index == par1) {
		    valueStore[k] = par2;
		    break;
		}
	    }
	}
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
	return tileEntity.isUseableByPlayer(entityplayer);
    }

    @Override
    protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
	int index = slot.getSlotIndex();
	return this.tileEntity.canInsertItem(index, stack, stack.stackSize); 
    }

    @Override
    public void containerAddSlot(Slot slot) {
	this.addSlotToContainer(slot);
    }

    @Override
    public boolean containerMergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
	return this.mergeItemStack(par1ItemStack, par2, par3, par4);
    }

    @Override
    public Slot containerGetSlot(int slot) {
	return getSlot(slot);
    }

}
