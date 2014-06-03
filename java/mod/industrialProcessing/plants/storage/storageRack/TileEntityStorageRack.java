package ip.industrialProcessing.machines.plants.storage.storageRack;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.machines.plants.storage.storageBox.BlockStorageBox;
import net.minecraft.item.ItemStack;

public class TileEntityStorageRack extends TileEntityMachine implements IAnimationProgress, IAnimationSyncable{

	private AnimationHandler animation;

	public TileEntityStorageRack() {
		this.animation = new AnimationHandler(AnimationMode.CLAMP, 1f, true);
		this.animation.setSpeed(0);
		this.animation.setIncrementing(false);
		
		LocalDirection[] noDirection = new LocalDirection[0];
		addStack(null, noDirection, true, false);//0
		addStack(null, noDirection, true, false);//1
		addStack(null, noDirection, true, false);//2
		addStack(null, noDirection, true, false);//3
		addStack(null, noDirection, true, false);//4
		addStack(null, noDirection, true, false);//5

		// box1
		addStack(null, noDirection, true, false);//6
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);

		// box2
		addStack(null, noDirection, true, false);//15
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);

		// box3
		addStack(null, noDirection, true, false);//24
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);

		// box4
		addStack(null, noDirection, true, false);//
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);

		// box5
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);

		// box6
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
		addStack(null, noDirection, true, false);
	}

	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			int count = 0;
			for(int i =0;i<6;i++){
				if (getStackInSlot(i) != null)
					count++;
			}
			this.animation.setSpeed(this.animation.getSpeed()+0.01f);
			this.animation.setAnimationProgress(count, 1);
			TileAnimationSyncHandler.sendAnimationData(this, this.animation);
			this.animation.update();
			if((this.animation.getSpeed())>0.05f)
				this.animation.setSpeed(0);
		}else{
			this.animation.update(); 
		}
		super.updateEntity();
	}
	
	@Override
	protected boolean isValidInput(int slot, int itemID) {
		if (slot < 6)
			return itemID == ISetupMachineBlocks.blockStorageBox.blockID;
		return ((itemID != ISetupMachineBlocks.blockStorageBox.blockID)&&(getStackInSlot((slot - 6)/9) != null));
	}

	public ItemStack popBox() {
		for (int i = 0; i < 6; i++) {
			ItemStack stack = decrStackSize(i, 1);
			onInventoryChanged();
			if(stack != null){
				return stack;
			}
		}
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (i > 6) {
			return super.decrStackSize(i, j);
		}
		
		if (getStackInSlot(i) != null) {
			ItemStack stack = getStackInSlot(i).copy();
			for (int k = 0; k < 9; k++) {
				ItemStack stackInSlot = getStackInSlot(6 + i * 9 + k);
				if (stackInSlot != null) {
					BlockStorageBox.putStackInBox(stackInSlot.copy(), stack, k);
					setInventorySlotContents(6 + i * 9 + k, null);
				}
			}
			setInventorySlotContents(i, null);
			onInventoryChanged();
			return stack;
		}
		return null;
	}

	public boolean pushBox(ItemStack itemStack) {

		if (itemStack == null)
			return false;
		if (itemStack.stackSize != 1)
			return false;
		for (int i = 0; i < 6; i++) {
			if (isValidInput(i, itemStack.itemID)) {
				ItemStack slot = getStackInSlot(i);
				if (slot == null) {
					this.setInventorySlotContents(i, itemStack);
					onInventoryChanged();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack stack) {
		if(slotIndex < 6 || stack != null || (slotIndex >= 6 && getStackInSlot((slotIndex - 6)/9) != null))
			super.setInventorySlotContents(slotIndex, stack);
		onInventoryChanged();
		if (slotIndex < 6 && stack != null) {
			for (int i = 0; i < 9; i++) {
				ItemStack stackFromBox = BlockStorageBox.getStackFromBox(stack, i, 64);
				if (stackFromBox != null) {
					this.setInventorySlotContents(6 + 9 * slotIndex + i, stackFromBox);
				}
			}
		}
		onInventoryChanged();
	}

	@Override
	public AnimationHandler getAnimationHandler(int index) {
		return this.animation;
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		return this.animation.getAnimationProgress(scale);
	}

}
