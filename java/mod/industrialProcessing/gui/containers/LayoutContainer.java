package mod.industrialProcessing.gui.containers;

import java.util.ArrayList;

import mod.industrialProcessing.gui.containers.handlers.IContainerHandler;
import mod.industrialProcessing.utils.containers.IContainerAdd;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LayoutContainer extends ShiftContainer implements IContainerAdd {

    private ArrayList<IContainerHandler> handlers = new ArrayList<IContainerHandler>();
    private ArrayList<Integer> handlerLookup = new ArrayList<Integer>();
    private ArrayList<Integer> handlerStartIndex = new ArrayList<Integer>();
    private int indexes = 0;

    public LayoutContainer() {
    }

    public int addHandler(IContainerHandler handler) {
        int index = handlers.size();
        handlers.add(handler);
        for (int i = 0; i < handler.getValueCount(); i++) {
            handlerLookup.add(index);
        }
        handlerStartIndex.add(indexes);
        indexes += handler.getValueCount();
        return index;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }

    @Override
    public void containerAddSlot(Slot slot) {
        this.addSlotToContainer(slot);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerHandler handler : this.handlers) {
            handler.readFromEntity();
        }
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting iCrafing = (ICrafting) this.crafters.get(i);
            sendHandlers(iCrafing);
        }
    }

    private void sendHandlers(ICrafting iCrafing) {
        int index = 0;
        for (IContainerHandler handler : this.handlers) {
            int values = handler.getValueCount();
            for (int i = 0; i < values; i++) {
                int k = index + i;
                if (handler.hasChanged(i)) {
                    iCrafing.sendProgressBarUpdate(this, k, handler.getValue(i));
                }
            }
            index += values;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int par1, int par2) {
        int handlerIndx = handlerLookup.get(par1);
        IContainerHandler handler = handlers.get(handlerIndx);
        int startIndex = handlerStartIndex.get(handlerIndx);
        handler.setValue(par1 - startIndex, par2);
    }

    @Override
    protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
        IInventory inventory = slot.inventory;
        if (inventory != null) {
            int index = slot.getSlotIndex();
            return inventory.isItemValidForSlot(index, stack);
        }
        return false;
    }

    public IContainerHandler getHandler(int handlerIndex) {
        return this.handlers.get(handlerIndex);
    }
}
