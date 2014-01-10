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
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.crafting.CraftingManager;

public class ContainerCrusher extends ContainerPoweredWorkerMachine {

	protected Slot[] slots;
	protected TileEntityCrusher tileEntityCrusher;
	protected GuiLayout layout;
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
    public IInventory craftResult = new InventoryCraftResult();

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
			
			Iterator<Slot> slotIterator = layout.getSlotsMachine(tileEntityCrusher);
			while(slotIterator.hasNext()){
					addSlotToContainer(slotIterator.next());
			}
			layout.addComponentsToContainer(this,tileEntityCrusher);

			bindPlayerInventory(layout,inventoryPlayer);
		}
	}

	private void bindPlayerInventory(GuiLayout layout, InventoryPlayer inventoryPlayer) {
		Iterator<Slot> slotIterator = layout.getSlotsInventory(inventoryPlayer);
		while(slotIterator.hasNext()){
				addSlotToContainer(slotIterator.next());
		}
		
		this.addSlotToContainer(new SlotCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 204, 173));
        int i;
        int j;

        for (i = 0; i < 2; ++i)
        {
            for (j = 0; j < 2; ++j)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 195 + j * 18, 119 + i * 18));
            }
        }

	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}
	
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.tileEntityCrusher.worldObj));
    }
}
