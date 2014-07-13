package mod.industrialProcessing.plants.construction.craftomatic;

import java.util.List;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInvPower;
import mod.industrialProcessing.utils.DummyPlayer;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.worker.IWorkHandler;
import mod.industrialProcessing.work.worker.IWorker;
import mod.industrialProcessing.work.worker.IWorkingEntity;
import mod.industrialProcessing.work.worker.ServerWorker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;

public class TileEntityCraftomatic extends TileEntityMachineInvPower implements IWorkingEntity, IWorkHandler {

	private ServerWorker worker;
	private int maxWorkSpeed = 100;
	private float powerPerWork = 10;
	private IRecipe recipe;
	private ItemStack[] recipeItems;
	private boolean inventoryChanged;
	private int outputSlot;
	private InventoryCrafting dummyInventoryRead;
	private InventoryCraftingCraftomatic dummyInventoryWrite;
	private IInventory craftResult;
	private SlotCrafting craftSlot;

	public TileEntityCraftomatic() {
		super(LocalDirection.BACK, 1000);

		for (int i = 0; i < 9; i++) {
			// config stacks
			addStack(null, (LocalDirection) null, false, false);
		}
		for (int i = 0; i < 3 * 9; i++) {
			// input stacks
			addStack(null, LocalDirection.UP, true, false);
		}
		this.outputSlot = addStack(null, LocalDirection.LEFT, false, true);
		addStack(null, (LocalDirection) null, false, false);

		setupPowerSlot();

		this.worker = new ServerWorker(this, 100);

		this.dummyInventoryRead = new InventoryCraftingCraftomatic(this, true);
		this.dummyInventoryWrite = new InventoryCraftingCraftomatic(this, false);

		this.craftResult = new InventoryCraftResult();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {

		System.out.println("item " + itemstack + " in slot " + slot + " " + this.batterySlot);
		if (itemstack == null)
			return true;

		if (slot < 9) // anything goes in here: recipe
			return true;

		if (slot < 9 + 3 * 9) {
			// check if it matches recipe
		}

		return super.isItemValidForSlot(slot, itemstack);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();

		int maxWorkSpeed = this.maxWorkSpeed;

		float powerRequired = this.powerPerWork * maxWorkSpeed;
		if (powerRequired > 0) {
			float f = this.storage.getStoredPower() / powerRequired;
			f = 1 - 1 / (f / 2 + 1);
			maxWorkSpeed = (int) (this.maxWorkSpeed * f);
		}

		this.worker.doWork(maxWorkSpeed);
	}

	@Override
	public IWorker getWorker() {
		return worker;
	}

	@Override
	public boolean hasWorkToDo() {
		return this.recipe != null;
	}

	@Override
	public boolean canWorkProgress() {
		boolean resources = hasResources();
		boolean space = hasSpace();
		// System.out.println("resources " + resources + " && " + space);
		return resources && space;
	}

	public boolean hasSpace() {
		return getStackInSlot(outputSlot) == null;
	}

	private boolean hasResources() {
		boolean result = this.recipe.matches(this.dummyInventoryWrite, this.worldObj);
		return result;
	}

	@Override
	public void workDone() {

		if (!this.worldObj.isRemote) {
			ItemStack stack = this.recipe.getCraftingResult(this.dummyInventoryWrite);

			if (stack == null)
				return;

			stack = stack.copy();

			EntityPlayer player = DummyPlayer.getDummy((WorldServer) this.worldObj);

			if (craftSlot == null)
				craftSlot = new SlotCrafting(player, this.dummyInventoryWrite, this, this.outputSlot, 0, 0);

			craftSlot.onPickupFromSlot(player, stack);

			this.setInventorySlotContents(outputSlot, stack);

		}
	}

	@Override
	public void prepareWork() {
		if (inventoryChanged) {
			inventoryChanged = false;
			this.recipe = getRecipe();
		}
	}

	private IRecipe getRecipe() {
		List recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++) {
			IRecipe vanillaRecipe = (IRecipe) recipes.get(i);
			if (vanillaRecipe.matches(this.dummyInventoryRead, this.worldObj)) {
				System.out.println("output " + vanillaRecipe.getRecipeOutput());
				return vanillaRecipe;
			}
		}
		return null;
	}

	@Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		this.inventoryChanged = true;
		recipeItems = new ItemStack[9];
		for (int i = 0; i < recipeItems.length; i++) {
			recipeItems[i] = getStackInSlot(i);
		}
	}

	@Override
	public void workCancelled() {
		System.out.println("Cancel");
	}

	@Override
	public void workProgressed(int amount) {
		this.storage.drainPower(amount * powerPerWork, true);
	}

	@Override
	public void beginWork() {
		System.out.println("Begin!");
	}

	@Override
	public TileEntity getTileEntity() {
		return this;
	}
}
