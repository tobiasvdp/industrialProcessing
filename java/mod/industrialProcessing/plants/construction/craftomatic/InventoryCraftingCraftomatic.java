package mod.industrialProcessing.plants.construction.craftomatic;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class InventoryCraftingCraftomatic extends InventoryCrafting {

	private TileEntityCraftomatic craftomat;
	private boolean followConfig;

	public InventoryCraftingCraftomatic(TileEntityCraftomatic craftomat, boolean followConfig) {
		super(null, 3, 3);
		this.craftomat = craftomat;
		this.followConfig = followConfig;
	}

	@Override
	public ItemStack getStackInSlot(int par1) {

		ItemStack config = craftomat.getStackInSlot(par1);
		if (followConfig)
			return config;

		if (config == null)
			return null;
		int index = getIndexForSlot(par1);
		ItemStack stack = craftomat.getStackInSlot(index);

		if (stack == null)
			return null;
		// System.out.println("get stack in slot " + par1 + "=>" + index + " = " + stack);
		if (config.isItemEqual(stack))
			return stack;
		return null;
	}

	private int getIndexForSlot(int par1) {
		for (int i = 0; i < 3; i++) {
			int slotIndex = par1 * 3 + 9 + i;
			ItemStack slot = craftomat.getStackInSlot(par1 * 3 + 9 + i);
			if (slot != null && slot.stackSize > 0)
				return slotIndex;
		}
		return par1 * 3 + 9;
	}

	@Override
	public ItemStack decrStackSize(int slot, int decrAmount) {

		
		System.out.println("-----------------------------------decrStackSize " + slot + " " + decrAmount + " " + followConfig);
		if (followConfig)
			return null;

		int stackIndex = this.getIndexForSlot(slot);

		return craftomat.decrStackSize(stackIndex, decrAmount);
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		System.out.println("SetInventory");
		if (!followConfig) {
			int index = this.getIndexForSlot(par1);
			craftomat.setInventorySlotContents(index, par2ItemStack);
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return craftomat.getInventoryStackLimit();
	}

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		System.out.println("isvalid?");
		int index = this.getIndexForSlot(par1);
		return craftomat.isItemValidForSlot(index, par2ItemStack);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		return null;
	}
}
