package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.machines.MachineItemStack;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorBelt extends TileEntityTransport implements IRotateableEntity {

	private ForgeDirection forwardDirection = ForgeDirection.NORTH;
	private ArrayList<MovingItemStack> itemStacks = new ArrayList<MovingItemStack>();
	private int pullTicks = 0;

	@Override
	protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {
		if (entity instanceof TileEntityConveyorBelt) {
			TileEntityConveyorBelt other = (TileEntityConveyorBelt) entity;
			if (other.forwardDirection == direction)
				return TransportConnectionState.TRANSPORT;
		}

		if (entity instanceof ISidedInventory) {
			ISidedInventory inventory = (ISidedInventory) entity;
			int[] slots = inventory.getAccessibleSlotsFromSide(direction.getOpposite().ordinal());
			if (slots != null && slots.length > 0) {
				if (direction == this.forwardDirection.getOpposite())
					// this conveyor is connected to an input
					return TransportConnectionState.INPUT;
				else if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN)
					return TransportConnectionState.DUAL;
				else
					// this conveyor belt is connected to an output
					return TransportConnectionState.OUTPUT;
			}
		} else if (entity instanceof IInventory) {
			if (direction == this.forwardDirection.getOpposite())
				// this conveyor is connected to an input
				return TransportConnectionState.INPUT;
			else if (direction == ForgeDirection.UP || direction == ForgeDirection.DOWN)
				return TransportConnectionState.DUAL;
			else
				// this conveyor belt is connected to an output
				return TransportConnectionState.OUTPUT;
		}
		return TransportConnectionState.NONE;
	}

	@Override
	public boolean canUpdate() {
		return true;
	}

	private boolean canInsert(MovingItemStack stack, ForgeDirection direction, IInventory destinationInventory) {
		if (stack.destination == LocalDirection.BACK && stack.source != LocalDirection.DOWN) {
			if (destinationInventory instanceof ISidedInventory) {
				if (canInsert((ISidedInventory) destinationInventory, stack.stack, direction.getOpposite()))
					return true;
			} else if (canInsert(destinationInventory, stack.stack))
				return true;
		}
		return false;
	}

	private boolean isOutput(int index) {
		TransportConnectionState state = this.states[index];
		return state == TransportConnectionState.OUTPUT || state == TransportConnectionState.DUAL;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!this.worldObj.isRemote) {
			if (!this.itemStacks.isEmpty()) {
				float speed = 1; // one unit per second
				float DT = 1 / 20f;

				boolean upOutput = isOutput(ForgeDirection.UP.ordinal());
				boolean downOutput = isOutput(ForgeDirection.DOWN.ordinal());

				IInventory downInventory = getInventory(ForgeDirection.DOWN);
				IInventory upInventory = getInventory(ForgeDirection.UP);

				for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
					MovingItemStack stack = this.itemStacks.get(i);
					stack.progress += speed * DT;

					if (stack.progress >= 1) {
						if (outputStack(stack))
							this.itemStacks.remove(i);
					}

					if (downOutput || upOutput) {
						if (stack.destination == LocalDirection.BACK) {
							if (stack.progress > 0.5f - 4 * speed * DT && stack.progress < 0.5 + 4 * speed * DT) {
								if (canInsert(stack, ForgeDirection.DOWN, downInventory)) {
									stack.destination = LocalDirection.DOWN;
								} else {
									if (canInsert(stack, ForgeDirection.UP, upInventory)) {
										stack.destination = LocalDirection.UP;
									}
								}
							}
						}
					}
					
				}
			}

			if (pullTicks++ > 20) {
				takeFromInput(1);
			}
		}

		notifyBlockChange();
	}

	private void takeFromInput(int maxStackSize) {
		for (int i = 0; i < states.length; i++) {
			if (states[i] == TransportConnectionState.OUTPUT || states[i] == TransportConnectionState.DUAL) {
				ForgeDirection direction = ForgeDirection.getOrientation(i);
				// not the conveyor output side? then it's a conveyor input!
				if (direction != this.forwardDirection.getOpposite()) {
					ItemStack stack = pullStack(direction);
					if (stack != null)
						addItemStack(stack, direction);
				}
			}
		}
		pullTicks = 0;
	}

	private ItemStack pullStack(ForgeDirection direction) {
		IInventory inventory = getInventory(direction);
		ForgeDirection opposite = direction.getOpposite();
		if (inventory != null) {
			if (inventory instanceof ISidedInventory) {
				ISidedInventory sidedInventory = (ISidedInventory) inventory;
				int[] slots = sidedInventory.getAccessibleSlotsFromSide(opposite.ordinal());
				for (int j = slots.length - 1; j >= 0; j--) {
					ItemStack stack = sidedInventory.getStackInSlot(slots[j]);
					sidedInventory.canExtractItem(slots[j], stack, opposite.ordinal());
					ItemStack item = sidedInventory.decrStackSize(slots[j], 1);
					if (item != null) {
						return item;
					}
				}
			} else {
				for (int j = inventory.getSizeInventory() - 1; j >= 0; j--) {
					ItemStack item = inventory.decrStackSize(j, 1);
					if (item != null) {
						return item;
					}
				}
			}
		}
		return null;
	}

	private boolean canInsert(ISidedInventory downSidedInventory, ItemStack stack, ForgeDirection side) {
		return ItemTransfers.canInsert(stack, downSidedInventory, side);
	}

	private boolean canInsert(IInventory downSidedInventory, ItemStack stack) {
		return ItemTransfers.canInsert(stack, downSidedInventory);
	}

	private ISidedInventory getSidedInventory(ForgeDirection down) {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + down.offsetX, yCoord + down.offsetY, zCoord + down.offsetZ);
		if (entity instanceof ISidedInventory)
			return (ISidedInventory) entity;
		return null;
	}

	private IInventory getInventory(ForgeDirection down) {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + down.offsetX, yCoord + down.offsetY, zCoord + down.offsetZ);
		if (entity instanceof IInventory)
			return (IInventory) entity;
		return null;
	}

	private void networkStack(MovingItemStack stack, StackEvent event, int index) {
	}

	private boolean outputStack(MovingItemStack stack) {
		Random rnd = new Random();
		ForgeDirection direction = DirectionUtils.getWorldDirection(stack.destination, this.forwardDirection);
		TileEntityConveyorBelt conveyor = getConveyor(direction);
		if (conveyor != null) {
			System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to conveyor");
			conveyor.addItemStack(stack.stack, direction.getOpposite());
			return true;
		} else {
			ISidedInventory sidedInventory = getSidedInventory(direction);
			if (sidedInventory != null) {
				System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to sided inventory " + sidedInventory);
				ItemStack rest = ItemTransfers.transfer(stack.stack, sidedInventory, direction.getOpposite());
				if (rest == null || rest.stackSize <= 0)
					return true;

				if (stack.destination != LocalDirection.BACK) {
					stack.stack = rest;
					stack.source = stack.destination;
					stack.destination = LocalDirection.FRONT; // bounce back
				} else {
					System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to air");
					float dx = direction.offsetX + (float) rnd.nextGaussian();
					float dy = direction.offsetY + 5;
					float dz = direction.offsetZ + (float) rnd.nextGaussian();
					ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, dx / 10, dy / 10, dz / 10);
					return true;
				}
				return false;
			} else {
				IInventory inventory = getInventory(direction);
				if (inventory != null) {
					System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to inventory" + inventory);
					ItemStack rest = ItemTransfers.transfer(stack.stack, inventory);
					if (rest == null || rest.stackSize <= 0)
						return true;
					stack.stack = rest;
					if (stack.destination != LocalDirection.BACK) { // send to
																	// output!
						stack.source = stack.destination;
						stack.destination = LocalDirection.BACK; // bounce back

						stack.progress = 0;
						return false;
					} else {
						System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to air");
						float dx = direction.offsetX + (float) rnd.nextGaussian();
						float dy = direction.offsetY + 5;
						float dz = direction.offsetZ + (float) rnd.nextGaussian();
						ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, dx / 10, dy / 10, dz / 10);
						return true;
					}
				} else {
					System.out.println("Transfering " + stack.stack.stackSize + " " + stack.stack.getDisplayName() + " to air");
					float dx = direction.offsetX;
					float dy = direction.offsetY;
					float dz = direction.offsetZ;
					ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, dx / 10, dy / 10, dz / 10);
					return true;
				}
			}
		}
	}
	
	public Iterator<MovingItemStack> iterateStacks()
	{
		return this.itemStacks.iterator();
	}

	private TileEntityConveyorBelt getConveyor(ForgeDirection direction) {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
		if (entity instanceof TileEntityConveyorBelt)
			return (TileEntityConveyorBelt) entity;
		return null;
	}

	public void addItemStack(ItemStack stack, ForgeDirection source) {
		if(source == null) source = ForgeDirection.UNKNOWN;
		MovingItemStack movingStack = new MovingItemStack();
		movingStack.stack = stack;
		if (source == null) {
			movingStack.progress = 0.5f;
		} else {
			movingStack.progress = 0;
			LocalDirection localSource = DirectionUtils.getLocalDirection(source, this.forwardDirection);
			movingStack.source = localSource;
		}
		movingStack.destination = LocalDirection.BACK;
		int index = this.itemStacks.size();
		this.itemStacks.add(movingStack);
		networkStack(movingStack, StackEvent.ADD, index);

	}

	@Override
	public ForgeDirection getForwardDirection() {
		return this.forwardDirection;
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		this.forwardDirection = forward;

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
		this.forwardDirection = ForgeDirection.getOrientation(nbt.getInteger("Forward"));
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

	public void addCollisionBoxes(List par6List, AxisAlignedBB par5AxisAlignedBB) {

		for (int i = 2; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.VALID_DIRECTIONS[i];

			if (states[i] != TransportConnectionState.NONE || i == this.forwardDirection.ordinal()) {

				double minX = -4d + Math.min(0, direction.offsetX) * 4;
				double maxX = 4d + Math.max(0, direction.offsetX) * 4;

				double minZ = -4d + Math.min(0, -direction.offsetZ) * 4;
				double maxZ = 4d + Math.max(0, -direction.offsetZ) * 4;

				double minY = -8;
				double maxY = -7;

				AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX / 16d + 0.5f, yCoord + minY / 16d + 0.5f, zCoord + minZ / 16d + 0.5f, xCoord + maxX / 16d + 0.5f, yCoord + maxY / 16d + 0.5f, zCoord + maxZ / 16d + 0.5f);
				if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
					par6List.add(axisalignedbb1);
				}

				if (states[i] != TransportConnectionState.NONE && states[i] != TransportConnectionState.TRANSPORT) {
					minY += 1;
					maxY += 8;
					axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX / 16d + 0.5f, yCoord + minY / 16d + 0.5f, zCoord + minZ / 16d + 0.5f, xCoord + maxX / 16d + 0.5f, yCoord + maxY / 16d + 0.5f, zCoord + maxZ / 16d + 0.5f);
					if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
						par6List.add(axisalignedbb1);
					}
				}
			}
		}

		TransportConnectionState up = states[ForgeDirection.UP.ordinal()];
		if (up != TransportConnectionState.NONE && up != TransportConnectionState.TRANSPORT) {
			double minX = -4d;
			double maxX = 4d;

			double minZ = -4d;
			double maxZ = 4d;

			double minY = -8;
			double maxY = 8;

			AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX / 16d + 0.5f, yCoord + minY / 16d + 0.5f, zCoord + minZ / 16d + 0.5f, xCoord + maxX / 16d + 0.5f, yCoord + maxY / 16d + 0.5f, zCoord + maxZ / 16d + 0.5f);
			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
		}

		TransportConnectionState down = states[ForgeDirection.DOWN.ordinal()];
		if (down != TransportConnectionState.NONE && down != TransportConnectionState.TRANSPORT) {
			double minX = -4d;
			double maxX = 4d;

			double minZ = -4d;
			double maxZ = 4d;

			double minY = -8;
			double maxY = 1;

			AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX / 16d + 0.5f, yCoord + minY / 16d + 0.5f, zCoord + minZ / 16d + 0.5f, xCoord + maxX / 16d + 0.5f, yCoord + maxY / 16d + 0.5f, zCoord + maxZ / 16d + 0.5f);
			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
		}
	}
}
