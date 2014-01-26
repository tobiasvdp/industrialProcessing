package ip.industrialProcessing.gui.container;

import ip.industrialProcessing.api.tanks.ITank;
import ip.industrialProcessing.gui.GuiLayout;
import ip.industrialProcessing.gui.IGuiLayout;
import ip.industrialProcessing.gui.IGuiLayoutMultiblock;
import ip.industrialProcessing.gui.IGuiLayoutTriggerAcceptor;
import ip.industrialProcessing.gui.components.GuiLayoutPanelType;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerButton;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerDataView;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerHeat;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerLifeSpan;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerPower;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerSimpleHeat;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerTank;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerWorker;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerContainer;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.utils.IBreakable;
import ip.industrialProcessing.utils.handler.heat.IHeatStorage;
import ip.industrialProcessing.utils.handler.heat.IHeated;
import ip.industrialProcessing.utils.working.IWorkingEntity;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerIP extends Container {

	protected TileEntity te;
	protected GuiLayout layout;
	protected InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	protected IInventory craftResult = new InventoryCraftResult();

	public ContainerIP(EntityPlayer player, TileEntity te) {
		InventoryPlayer inventoryPlayer = player.inventory;
		this.te = te;
		if (te.getBlockType() instanceof IGuiLayout)
			layout = ((IGuiLayout) te.getBlockType()).getGuiLayout();
		
		if (te.getBlockType() instanceof IGuiLayoutMultiblock){
			layout = ((IGuiLayoutMultiblock) te.getBlockType()).getGuiLayout(((TileEntityMultiblockCore)te).getTier());
		}
		
		if (this.layout != null) {

			// bind te slots
			if (te instanceof IInventory) {
				Iterator<Slot> slotIterator = layout.getSlotsMachine(((IInventory) te));
				while (slotIterator.hasNext()) {
					addSlotToContainer(slotIterator.next());
				}
			}
			// bind all handlers
			layout.addSyncingHandlersToContainer(this, te);
			// bind player's inventory
			bindPlayerInventory(layout, inventoryPlayer,player);
		}
	}

	private void bindPlayerInventory(GuiLayout layout, InventoryPlayer inventoryPlayer,Entity player) {
		Iterator<Slot> slotIterator = layout.getSlotsInventory(inventoryPlayer,player);
		while (slotIterator.hasNext()) {
			addSlotToContainer(slotIterator.next());
		}

		this.addSlotToContainer(new SlotCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 204, 175));
		int i;
		int j;

		for (i = 0; i < 2; ++i) {
			for (j = 0; j < 2; ++j) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 195 + j * 18, 117 + i * 18));
			}
		}

	}

	protected boolean canPutItemStackInSlot(ItemStack stack, Slot slot) {
		if (te instanceof ISidedInventory) {
			int index = slot.getSlotIndex();
			return ((ISidedInventory) te).canInsertItem(index, stack, stack.stackSize);
		}
		return false;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		ItemStack originalStack = null;
		Slot slot = (Slot) inventorySlots.get(slotIndex);
		int numSlots = inventorySlots.size();
		if (slot != null && slot.getHasStack()) {
			ItemStack stackInSlot = slot.getStack();
			originalStack = stackInSlot.copy();
			if (slotIndex >= numSlots - 9 * 4 && tryShiftItem(stackInSlot, numSlots)) {
				// NOOP
			} else if (slotIndex >= numSlots - 9 * 4 && slotIndex < numSlots - 9) {
				if (!shiftItemStack(stackInSlot, numSlots - 9, numSlots)) {
					return null;
				}
			} else if (slotIndex >= numSlots - 9 && slotIndex < numSlots) {
				if (!shiftItemStack(stackInSlot, numSlots - 9 * 4, numSlots - 9)) {
					return null;
				}
			} else if (!shiftItemStack(stackInSlot, numSlots - 9 * 4, numSlots)) {
				return null;
			}
			slot.onSlotChange(stackInSlot, originalStack);
			if (stackInSlot.stackSize <= 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			if (stackInSlot.stackSize == originalStack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(player, stackInSlot);
		}
		return originalStack;
	}

	private boolean tryShiftItem(ItemStack stackToShift, int numSlots) {
		for (int machineIndex = 0; machineIndex < numSlots - 9 * 4; machineIndex++) {
			Slot slot = (Slot) inventorySlots.get(machineIndex);
			if (!slot.isItemValid(stackToShift)) {
				continue;
			}
			if (shiftItemStack(stackToShift, machineIndex, machineIndex + 1)) {
				return true;
			}
		}
		return false;
	}

	protected boolean shiftItemStack(ItemStack stackToShift, int start, int end) {
		boolean changed = false;
		if (stackToShift.isStackable()) {
			for (int slotIndex = start; stackToShift.stackSize > 0 && slotIndex < end; slotIndex++) {
				Slot slot = (Slot) inventorySlots.get(slotIndex);
				ItemStack stackInSlot = slot.getStack();
				if (stackInSlot != null && canStacksMerge(stackInSlot, stackToShift)) {
					if (slot.inventory.isItemValidForSlot(slotIndex, stackToShift)) {
						int resultingStackSize = stackInSlot.stackSize + stackToShift.stackSize;
						int max = Math.min(stackToShift.getMaxStackSize(), slot.getSlotStackLimit());
						if (resultingStackSize <= max) {
							stackToShift.stackSize = 0;
							stackInSlot.stackSize = resultingStackSize;
							slot.onSlotChanged();
							changed = true;
						} else if (stackInSlot.stackSize < max) {
							stackToShift.stackSize -= max - stackInSlot.stackSize;
							stackInSlot.stackSize = max;
							slot.onSlotChanged();
							changed = true;
						}
					}
				}
			}
		}
		if (stackToShift.stackSize > 0) {
			for (int slotIndex = start; stackToShift.stackSize > 0 && slotIndex < end; slotIndex++) {
				Slot slot = (Slot) inventorySlots.get(slotIndex);
				ItemStack stackInSlot = slot.getStack();
				if (stackInSlot == null) {
					if (slot.inventory.isItemValidForSlot(slotIndex, stackToShift)) {
						int max = Math.min(stackToShift.getMaxStackSize(), slot.getSlotStackLimit());
						stackInSlot = stackToShift.copy();
						stackInSlot.stackSize = Math.min(stackToShift.stackSize, max);
						stackToShift.stackSize -= stackInSlot.stackSize;
						slot.putStack(stackInSlot);
						slot.onSlotChanged();
						changed = true;
					}
				}
			}
		}
		return changed;
	}

	private boolean canStacksMerge(ItemStack stackInSlot, ItemStack stackToShift) {
		if (stackInSlot == null || stackToShift == null)
			return false;
		if (!stackInSlot.isItemEqual(stackToShift))
			return false;
		if (!ItemStack.areItemStackTagsEqual(stackInSlot, stackToShift))
			return false;
		return true;
	}

	public int getSizeInventory() {
		// TODO
		return 0;
	}

	@Override
	protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4) {
		{
			boolean flag1 = false;
			int k = par2;

			if (par4) {
				k = par3 - 1;
			}

			Slot slot;
			ItemStack itemstack1;

			if (par1ItemStack.isStackable()) {
				while (par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2)) {
					slot = (Slot) this.inventorySlots.get(k);
					itemstack1 = slot.getStack();

					if (itemstack1 != null && itemstack1.itemID == par1ItemStack.itemID && (!par1ItemStack.getHasSubtypes() || par1ItemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1)) {
						int l = itemstack1.stackSize + par1ItemStack.stackSize;

						if (l <= par1ItemStack.getMaxStackSize()) {
							par1ItemStack.stackSize = 0;
							itemstack1.stackSize = l;
							slot.onSlotChanged();
							flag1 = true;
						} else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize()) {
							par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;
							itemstack1.stackSize = par1ItemStack.getMaxStackSize();
							slot.onSlotChanged();
							flag1 = true;
						}
					}

					if (par4) {
						--k;
					} else {
						++k;
					}
				}
			}

			if (par1ItemStack.stackSize > 0) {
				if (par4) {
					k = par3 - 1;
				} else {
					k = par2;
				}

				while (!par4 && k < par3 || par4 && k >= par2) {
					slot = (Slot) this.inventorySlots.get(k);
					itemstack1 = slot.getStack();

					if (itemstack1 == null) {
						slot.putStack(par1ItemStack.copy());
						slot.onSlotChanged();
						par1ItemStack.stackSize = 0;
						flag1 = true;
						break;
					}

					if (par4) {
						--k;
					} else {
						++k;
					}
				}
			}

			return flag1;
		}
	}

	public void addHandlerToContainer(GuiLayoutPanelType type, int index) {
		switch (type) {
		case power:
			if (te instanceof IPoweredMachine)
				addHandler(new HandlerPower(((IPoweredMachine) te).getMainPowerStorage()));
			break;
		case tankOutput:
		case tankInput:
		case simpleTankInput:
		case simpleTankOutput:
			if (te instanceof ITank)
				addHandler(new HandlerTank(((ITank) te).getTank(index)));
			break;
		case worker:
			if (te instanceof IWorkingEntity)
				addHandler(new HandlerWorker(((IWorkingEntity) te).getWorker()));
			break;
		case heat:
			if (te instanceof IHeatStorage)
				addHandler(new HandlerHeat(((IHeatStorage) te)));
			break;
		case simpleHeat:
			if (te instanceof IHeated)
				addHandler(new HandlerSimpleHeat(((IHeated) te)));
			break;
		case lifespan:
			if (te instanceof IBreakable)
				addHandler(new HandlerLifeSpan(((IBreakable) te)));
			break;
		case singlebutton:
			if (te instanceof IGuiLayoutTriggerAcceptor)
				addHandler(new HandlerButton((IGuiLayoutTriggerAcceptor) te, index));
			break;
		case dataview:
			if (te instanceof IGuiLayoutTriggerAcceptor)
				addHandler(new HandlerDataView((IGuiLayoutTriggerAcceptor) te, index));
			break;
		default:
			break;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		if (te instanceof IInventory)
			return ((IInventory) te).isUseableByPlayer(entityplayer);
		return true;
	}

	private ArrayList<IHandlerContainer> handlers = new ArrayList<IHandlerContainer>();

	private int handlerOffset = 0;

	private void addHandler(IHandlerContainer handler) {
		handlers.add(handler);
		handler.setIndexOffset(handlerOffset);
		handlerOffset += handler.getValueCount();
	}

	public ArrayList<IHandlerContainer> getHandlers(GuiLayoutPanelType... types) {
		ArrayList<IHandlerContainer> list = new ArrayList<IHandlerContainer>();
		Iterator<IHandlerContainer> it = handlers.iterator();
		while (it.hasNext()) {
			IHandlerContainer handler = it.next();
			for (GuiLayoutPanelType type : types)
				if (handler.getPanelType() == type)
					list.add(handler);
		}
		return list;
	}

	public ArrayList<IHandlerContainer> getHandlers() {
		return handlers;
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

	@Override
	public void onCraftMatrixChanged(IInventory par1IInventory) {
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.te.worldObj));
	}

}
