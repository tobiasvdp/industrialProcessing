package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.animation.conveyors.IConveyor;
import ip.industrialProcessing.machines.animation.conveyors.IConveyorStack;
import ip.industrialProcessing.machines.animation.conveyors.TileConveyorSyncHandler;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorTransportBase extends TileEntityConveyorConnectionsBase implements IConveyor {

    private Random rnd = new Random();
    protected ArrayList<MovingItemStack> itemStacks = new ArrayList<MovingItemStack>();
    protected float speed = 1f; // default speed 1
    private int clusterTicks = 0;
    private int maxClusterTicks = 10;

    protected boolean[] canReverse = new boolean[6];
    private float dummyProgress;
    protected float syncedSpeed;

    public TileEntityConveyorTransportBase() {
	Arrays.fill(canReverse, false);

	canReverse[LocalDirection.UP.ordinal()] = true;
	canReverse[LocalDirection.DOWN.ordinal()] = true;
    }

    public float getSpeed() {
	return speed;
    }

    public void setSpeed(float speed) {
	this.speed = speed;
    }

    public Iterator<MovingItemStack> iterateStacks() {
	return this.itemStacks.iterator();
    }

    @Override
    public boolean canUpdate() {
	return true;
    }

    @Override
    public void updateEntity() {
	float DT = 1 / 20f;
	super.updateEntity();
	if (!this.worldObj.isRemote) {
	    if (!this.itemStacks.isEmpty()) {

		if (clusterTicks++ < maxClusterTicks) {
		    clusterItems();
		    clusterTicks = 0;
		}

		for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
		    MovingItemStack stack = this.itemStacks.get(i);
		    stack.progress += speed * DT;

		    if (stack.progress >= 1) {
			if (outputStack(stack)) {
			    this.itemStacks.remove(i);
			    syncConveyor();
			}
		    } else if (stack.progress > 0.5f && !stack.routed) {
			rerouteStack(stack);
			if (stack.destination == LocalDirection.UNKNOWN) {
			    outputToAir(stack, ForgeDirection.UP);
			    this.itemStacks.remove(i);
			} else
			    stack.routed = true;
		    }
		}
	    }
	} else {
	    for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
		MovingItemStack stack = this.itemStacks.get(i);
		stack.progress += speed * DT;
		if (stack.progress >= 1)
		    this.itemStacks.remove(i);
	    }
	    this.dummyProgress += speed * DT;
	    if (this.dummyProgress > 1)
		dummyProgress--;

	}
    }

    public void clusterItems() {

	for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
	    MovingItemStack stackA = this.itemStacks.get(i);
	    if (stackA.stack == null) {
		this.itemStacks.remove(i);
		continue;
	    }
	    if (stackA.stack.isStackable()) {
		int available = stackA.stack.getMaxStackSize() - stackA.stack.stackSize;
		if (available > 0) {
		    for (int j = this.itemStacks.size() - 1; j > i; j--) {
			MovingItemStack stackB = this.itemStacks.get(j);
			if (stackB.progress > 0.5 == stackA.progress > 0.5) {
			    if ((stackB.progress > 0.5 && stackB.destination == stackA.destination) || (stackB.progress <= 0.5 && stackB.source == stackA.source)) {
				if (stackB.stack == null) {
				    this.itemStacks.remove(j);
				    syncConveyor();
				    continue;
				}
				if (stackA.stack.isItemEqual(stackB.stack)) {
				    available = Math.min(available, stackB.stack.stackSize);
				    stackA.stack.stackSize += available;
				    stackB.stack.stackSize -= available;
				    if (stackB.stack.stackSize <= 0) {
					this.itemStacks.remove(j);
					syncConveyor();
				    }
				}
			    }
			}
		    }
		}
	    }
	}
    }

    protected void syncConveyor() {
	this.syncedSpeed = this.speed;
	TileConveyorSyncHandler.sendConveyorData(this, this);
    }

    private boolean outputStack(MovingItemStack stack) {
	LocalDirection outputLocal = stack.destination;

	if (isOutput(outputLocal)) {
	    ForgeDirection direction = DirectionUtils.getWorldDirection(outputLocal, this.forwardDirection);
	    TransportConnectionState state = this.states[direction.ordinal()];
	    if (state.isConnected()) {
		SlopeState slope = getSlope(outputLocal);
		TileEntity neighbor = ConveyorEnvironment.getNeighbor(this, direction, slope);
		if (neighbor instanceof TileEntityConveyorTransportBase) {
		    return outputToConveyor(stack, (TileEntityConveyorTransportBase) neighbor, direction.getOpposite());
		} else {
		    ItemStack rest = outputToTileEntity(stack, neighbor, direction);
		    if (rest != null && rest.stackSize > 0) {
			if (canReverse[outputLocal.ordinal()]) {
			    stack.stack = rest;
			    // return to routing
			    stack.source = stack.destination;
			    stack.progress = 0;
			    stack.routed = false;
			    return false;
			} else {
			    outputToAir(stack, direction);
			    return true;
			}
		    } else
			return true;
		}
	    } else {
		outputToAir(stack, direction);
		return true;
	    }
	}
	return false;
    }

    private void outputToAir(MovingItemStack stack, ForgeDirection direction) {

	float dx = direction.offsetX;
	float dy = direction.offsetY;
	float dz = direction.offsetZ;

	float rx = (this.rnd.nextFloat() * 2 - 1) / 2f + dx / 5f;
	float ry = (this.rnd.nextFloat() * 2 - 1) / 2f + dy / 5f;
	float rz = (this.rnd.nextFloat() * 2 - 1) / 2f + dz / 5f;

	ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + dy * 0.5f, this.zCoord + 0.5f + dz * 0.5f, (dx + rx) / 10, (dy + ry) / 10, (dz + rz) / 10);
    }

    public MovingItemStack addItemStack(ItemStack stack, ForgeDirection source) {
	MovingItemStack movingStack = new MovingItemStack();
	movingStack.stack = stack;
	if (source == null) {
	    movingStack.progress = 0.5f;
	    movingStack.source = null;
	    movingStack.destination = findOutput(stack, LocalDirection.UNKNOWN);
	} else {
	    movingStack.progress = 0;
	    LocalDirection localSource = DirectionUtils.getLocalDirection(source, this.forwardDirection);
	    movingStack.source = localSource;
	    movingStack.destination = findOutput(stack, localSource);
	}
	int index = this.itemStacks.size();
	this.itemStacks.add(movingStack);
	syncConveyor();
	return movingStack;
    }

    private boolean outputToConveyor(MovingItemStack stack, TileEntityConveyorTransportBase neighbor, ForgeDirection inputSide) {
	if (neighbor.getConnectionMode(inputSide).canConnect(ConnectionMode.OUTPUT)) {
	    neighbor.addItemStack(stack.stack, inputSide);
	    return true;
	}
	// return to routing
	stack.source = stack.destination;
	stack.progress = 0;
	stack.routed = false;
	return false;
    }

    protected abstract ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction);

    protected void rerouteStack(MovingItemStack stack) {
	LocalDirection out = findOutput(stack.stack, stack.source);
	if (out != stack.destination) {
	    stack.destination = out;
	    syncConveyor();
	}
	stack.routed = true;
    }

    protected LocalDirection findOutput(ItemStack stack, LocalDirection source) {
	for (int i = 0; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);

	    ConnectionMode mode = this.getConnectionMode(direction);
	    if (mode.isOutput(true) || mode.isInventoryOutput())
		return DirectionUtils.getLocalDirection(direction, this.forwardDirection);
	}
	return LocalDirection.BACK;
    }

    private boolean isOutput(LocalDirection local) {

	ForgeDirection direction = DirectionUtils.getWorldDirection(local, this.forwardDirection);
	return isOutput(direction);
    }

    protected boolean isOutput(ForgeDirection direction) {
	ConnectionMode mode = this.getConnectionMode(direction);
	return mode.isOutput(false) || mode.isInventoryOutput();
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
	super.writeToNBT(nbt);
	nbt.setInteger("Forward", this.forwardDirection.ordinal());

	nbt.setInteger("StackCount", this.itemStacks.size());
	NBTTagList nbttaglist = new NBTTagList();
	for (int i = 0; i < this.itemStacks.size(); ++i) {
	    MovingItemStack machineStack = this.itemStacks.get(i);
	    if (machineStack.stack != null) {
		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		nbttagcompound1.setByte("Slot", (byte) i);
		nbttagcompound1.setInteger("Dest", machineStack.destination.ordinal());
		if (machineStack.source != null)
		    nbttagcompound1.setInteger("Src", machineStack.source.ordinal());
		nbttagcompound1.setFloat("Progress", machineStack.progress);
		machineStack.stack.writeToNBT(nbttagcompound1);
		nbttaglist.appendTag(nbttagcompound1);
	    }
	}
	nbt.setTag("Stacks", nbttaglist);
	nbt.setFloat("Speed", this.speed);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
	super.readFromNBT(nbt);
	SlopeState[] states = SlopeState.values();
	this.itemStacks.clear();
	if(nbt.hasKey("Speed"))
	    this.speed = nbt.getFloat("Speed");
	LocalDirection[] directions = LocalDirection.values();
	NBTTagList nbttaglist = nbt.getTagList("Stacks");
	int stackCount = nbt.getInteger("StackCount");
	for (int i = 0; i < nbttaglist.tagCount(); ++i) {
	    NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
	    byte b0 = nbttagcompound1.getByte("Slot");

	    if (b0 >= 0 && b0 < stackCount) {
		MovingItemStack machineStack = new MovingItemStack();
		machineStack.stack = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		machineStack.destination = directions[nbttagcompound1.getInteger("Dest")];
		machineStack.source = directions[nbttagcompound1.getInteger("Src")];
		machineStack.progress = nbttagcompound1.getFloat("Progress");
		this.itemStacks.add(machineStack);
	    }
	}
    }

    public void breakBlock() {
	for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
	    outputToAir(this.itemStacks.get(i), ForgeDirection.UP);
	    this.itemStacks.remove(i);
	}
    }

    @Override
    public IConveyorStack getStack(int index) {
	return this.itemStacks.get(index);
    }

    @Override
    public int getStackCount() {
	return this.itemStacks.size();
    }

    @Override
    public void clearStacks() {
	this.itemStacks.clear();
    }

    @Override
    public void addStack(ItemStack stack, LocalDirection destination, LocalDirection source, float progress) {
	MovingItemStack movingStack = new MovingItemStack();
	movingStack.stack = stack;
	movingStack.destination = destination;
	movingStack.source = source;
	movingStack.progress = progress;
	movingStack.routed = false;
	this.itemStacks.add(movingStack);
    }

    public float getDummyProgress() {
	return dummyProgress;
    }
}
