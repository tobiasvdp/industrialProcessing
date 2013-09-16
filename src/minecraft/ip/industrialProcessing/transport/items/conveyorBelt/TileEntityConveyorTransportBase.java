package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
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

public abstract class TileEntityConveyorTransportBase extends TileEntityConveyorConnectionsBase {

	private Random rnd = new Random();
	private ArrayList<MovingItemStack> itemStacks = new ArrayList<MovingItemStack>();
	protected float speed = 1f;

	private boolean[] canReverse = new boolean[6];

	public TileEntityConveyorTransportBase() {
		Arrays.fill(canReverse, false);

		canReverse[LocalDirection.UP.ordinal()] = true;
		canReverse[LocalDirection.DOWN.ordinal()] = true;
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
		super.updateEntity();
		if (!this.worldObj.isRemote) {
			if (!this.itemStacks.isEmpty()) {
				float DT = 1 / 20f;

				for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
					MovingItemStack stack = this.itemStacks.get(i);
					stack.progress += speed * DT;

					if (stack.progress >= 1) {
						if (outputStack(stack))
							this.itemStacks.remove(i);
					} else if (stack.progress > 0.5f && !stack.routed) {
						rerouteStack(stack);
						stack.routed = true;
					}
				}
			}
		}
		notifyBlockChange();
	}

	private boolean outputStack(MovingItemStack stack) {
		LocalDirection outputLocal = stack.destination;
		if (isOutput(outputLocal)) {
			ForgeDirection direction = DirectionUtils.getWorldDirection(outputLocal, this.forwardDirection);
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
		}
		return false;
	}

	private void outputToAir(MovingItemStack stack, ForgeDirection direction) {
		float rx = (this.rnd.nextFloat() * 2 - 1) / 2f;
		float ry = (this.rnd.nextFloat() * 2 - 1) / 2f;
		float rz = (this.rnd.nextFloat() * 2 - 1) / 2f;

		float dx = direction.offsetX;
		float dy = direction.offsetY;
		float dz = direction.offsetZ;
		ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, (dx + rx) / 10, (dy + ry) / 10, (dz + rz) / 10);
	}

	public void addItemStack(ItemStack stack, ForgeDirection source) {
		MovingItemStack movingStack = new MovingItemStack();
		movingStack.stack = stack;
		if (source == null) {
			movingStack.progress = 0.5f;
			movingStack.source = null;
		} else {
			movingStack.progress = 0;
			LocalDirection localSource = DirectionUtils.getLocalDirection(source, this.forwardDirection);
			movingStack.source = localSource;
		}
		movingStack.destination = LocalDirection.BACK;
		int index = this.itemStacks.size();
		this.itemStacks.add(movingStack);

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
		ConnectionMode connection = getConnectionMode(stack.destination);
		if (!isOutput(stack.destination)) {
			stack.destination = findOutput(stack.stack);
		}
		stack.routed = true;
	}

	protected LocalDirection findOutput(ItemStack stack) {
		for (int i = 0; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			if (isOutput(direction))
				return DirectionUtils.getLocalDirection(direction, this.forwardDirection);
		}
		return LocalDirection.UP;
	}

	private boolean isOutput(LocalDirection local) {
		ConnectionMode mode = this.getConnectionMode(local);

		if (mode == ConnectionMode.OUTPUT || mode == ConnectionMode.DUAL) {
			ForgeDirection direction = DirectionUtils.getWorldDirection(local, this.forwardDirection);
			TransportConnectionState state = this.states[direction.ordinal()];
			if (state != TransportConnectionState.NONE)
				return true;
		}
		return false;
	}

	protected boolean isOutput(ForgeDirection direction) {
		ConnectionMode mode = this.getConnectionMode(direction);
		if (mode == ConnectionMode.OUTPUT || mode == ConnectionMode.DUAL) {
			TransportConnectionState state = this.states[direction.ordinal()];
			if (state != TransportConnectionState.NONE)
				return true;
		}
		return false;
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
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		SlopeState[] states = SlopeState.values();
		this.itemStacks.clear();
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

}
