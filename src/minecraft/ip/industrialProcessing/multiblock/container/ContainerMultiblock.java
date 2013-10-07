package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ip.industrialProcessing.api.handlers.IHandler;
import ip.industrialProcessing.machines.containers.IProgressBarHandler;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.utils.containers.VerifyingContainer;

public abstract class ContainerMultiblock extends VerifyingContainer{

	private TEmultiblockCore core;

	public ContainerMultiblock(TEmultiblockCore core){
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
				int[] valueStore = handler.getValueStorage();
				for (int k = 0; k < handler.getValueCount(); k++) {
					int index = k;
					int value = handler.getValue(k);
					if (value != valueStore[k]) {
						icrafting.sendProgressBarUpdate(this, index, value);
					}
				}
			}
		}

		for (int j = 0; j < handlers.size(); j++) {
			IHandler handler = handlers.get(j);
			int[] valueStore = handler.getValueStorage();
			for (int k = 0; k < handler.getValueCount(); k++) {
				int index = k;
				int value = handler.getValue(k);
				valueStore[k] = value;
			}
		}
	}

}
