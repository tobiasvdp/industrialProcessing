package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.machines.ContainerMachine;
import ip.industrialProcessing.utils.containers.ContainerUtils;
import ip.industrialProcessing.utils.containers.IContainerAdd;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrusher extends ContainerMachine {

	protected Slot[] slots;
	
	protected TileEntityCrusher tileEntityCrusher;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tileEntityCrusher.isUseableByPlayer(entityplayer);
	}
	
	public ContainerCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher tileEntityCrusher) {
		super(inventoryPlayer, tileEntityCrusher);
		this.tileEntityCrusher = tileEntityCrusher;
		
		slots = new Slot[2];		
		slots[0] = new Slot(tileEntityCrusher, 0, 44, 33);
		slots[1] = new Slot(tileEntityCrusher, 1, 104, 33);
		
        addSlotToContainer(slots[0]);
        addSlotToContainer(slots[1]);	
        
        ContainerUtils.BindPlayerInventory(inventoryPlayer, this, 0);
	}
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
}
