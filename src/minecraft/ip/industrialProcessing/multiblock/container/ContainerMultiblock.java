package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.api.handlers.IHandler;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public abstract class ContainerMultiblock extends VerifyingContainer {

    private TEmultiblockCore core;

    public ContainerMultiblock(TEmultiblockCore core) {
	this.core = core;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
	return core.canInteractWith(entityplayer);
    }

    private ArrayList<IHandler> handlers = new ArrayList<IHandler>();

    private int handlerCount;

    protected void addHandler(IHandler handler) {
	handlers.add(handler);
	handlerCount++;
    }

    @Override
    public void detectAndSendChanges() {
	super.detectAndSendChanges();

	for (int i = 0; i < this.crafters.size(); ++i) {
	    ICrafting icrafting = (ICrafting) this.crafters.get(i);
	    for (int j = 0; j < handlers.size(); j++) {
		IHandler handler = handlers.get(j);
		for (int k = 0; k < handler.getValueCount(); k++) {
		    int index = k;
		    int value = handler.getValue(k);
		    if (handler.hasChanged(k)) {
			System.out.println("send update");
			icrafting.sendProgressBarUpdate(this, index + handler.getIndexOffset(), value);
		    }
		}
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
	while(!found){
	    handler = handlers.get(i);
	    if(par1 >= handler.getIndexOffset() && par1 < (handler.getIndexOffset()+handler.getValueCount())){
		found = true;
	    }
	    i++;
	}
	
	int index = par1 - handler.getIndexOffset();
	System.out.println("put update");
	handler.put(index,par2);
    }

}
