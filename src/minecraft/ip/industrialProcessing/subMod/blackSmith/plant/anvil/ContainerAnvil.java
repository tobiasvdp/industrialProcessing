package ip.industrialProcessing.subMod.blackSmith.plant.anvil;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ISetupFluids;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.utils.inventories.AnvilCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerAnvil extends Container {
    /** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    public static AnvilCraftingManager recipes;
    public static final int WILDCARD_VALUE = Short.MAX_VALUE;

    static {
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupMachineBlocks.BLmultiblockScreen), "xxx", "x x", " y ", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemKnife), "   ", " y ", "x z", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(ISetupItems.itemIronBlade), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemBlowingTorch), "   ", " y ", "x z", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.flintAndSteel), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemSolderingIron), "  y", " w ", "x z", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Item.ingotIron), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE), 'w', new ItemStack(ISetupFluids.bucketFluidLatex));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemIronTips, 12), "xzx", " x ", "x x", 'x', new ItemStack(Item.ingotIron), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemIronPlate, 4), "xx ", "xx ", "  z", 'x', new ItemStack(Item.ingotIron), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemCopperPlate, 4), "xx ", "xx ", "  z", 'x', new ItemStack(ISetupItems.itemCopperIngot), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemIronBar, 8), "  x", " x ", "x z", 'x', new ItemStack(Item.ingotIron), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemCopperBar, 8), "  x", " x ", "x z", 'x', new ItemStack(ISetupItems.itemCopperIngot), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemIronBowl, 3), " z ", "x x", " x ", 'x', new ItemStack(Item.ingotIron), 'z', new ItemStack(ISetupItems.itemHammer, 1, WILDCARD_VALUE));
	AnvilCraftingManager.getInstance().addRecipe(new ItemStack(ISetupItems.itemHammer), "   ", " y ", "x  ", 'x', new ItemStack(ISetupItems.itemThickStick), 'y', new ItemStack(Item.ingotIron));
    }

    public static AnvilCraftingManager getCraftingManager() {
	return AnvilCraftingManager.getInstance();
    }

    public ContainerAnvil(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5) {
	this.worldObj = par2World;
	this.posX = par3;
	this.posY = par4;
	this.posZ = par5;
	this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
	int l;
	int i1;

	for (l = 0; l < 3; ++l) {
	    for (i1 = 0; i1 < 3; ++i1) {
		this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
	    }
	}

	for (l = 0; l < 3; ++l) {
	    for (i1 = 0; i1 < 9; ++i1) {
		this.addSlotToContainer(new Slot(par1InventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
	    }
	}

	for (l = 0; l < 9; ++l) {
	    this.addSlotToContainer(new Slot(par1InventoryPlayer, l, 8 + l * 18, 142));
	}

	this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory par1IInventory) {
	this.craftResult.setInventorySlotContents(0, AnvilCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer par1EntityPlayer) {
	super.onContainerClosed(par1EntityPlayer);

	if (!this.worldObj.isRemote) {
	    for (int i = 0; i < 9; ++i) {
		ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

		if (itemstack != null) {
		    par1EntityPlayer.dropPlayerItem(itemstack);
		}
	    }
	}
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
	return this.worldObj.getBlockId(this.posX, this.posY, this.posZ) != ISetupMachineBlocks.blockAnvil.blockID ? false : par1EntityPlayer.getDistanceSq(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D) <= 64.0D;
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or
     * you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
	ItemStack itemstack = null;
	Slot slot = (Slot) this.inventorySlots.get(par2);

	if (slot != null && slot.getHasStack()) {
	    ItemStack itemstack1 = slot.getStack();
	    itemstack = itemstack1.copy();

	    if (par2 == 0) {
		if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
		    return null;
		}

		slot.onSlotChange(itemstack1, itemstack);
	    } else if (par2 >= 10 && par2 < 37) {
		if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
		    return null;
		}
	    } else if (par2 >= 37 && par2 < 46) {
		if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
		    return null;
		}
	    } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
		return null;
	    }

	    if (itemstack1.stackSize == 0) {
		slot.putStack((ItemStack) null);
	    } else {
		slot.onSlotChanged();
	    }

	    if (itemstack1.stackSize == itemstack.stackSize) {
		return null;
	    }

	    slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	}

	return itemstack;
    }

    @Override
    public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot) {
	return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
    }

}
