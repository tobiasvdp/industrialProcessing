package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.lwjgl.Sys;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorBelt extends TileEntityTransport implements IRotateableEntity {

	public float minXBounds = 1;
	public float minYBounds = 1;
	public float minZBounds = 1;

	public float maxXBounds = -1;
	public float maxYBounds = -1;
	public float maxZBounds = -1;

	private ForgeDirection forwardDirection = ForgeDirection.NORTH;
	private ArrayList<MovingItemStack> itemStacks = new ArrayList<MovingItemStack>();
	private int pullTicks = 0;
	float speed = 1; // one unit per second

	int frontMask = 2;
	int backMask = 2;
	private SlopeState frontSlope = SlopeState.FLAT;
	private SlopeState backSlope = SlopeState.FLAT;

	public SlopeState getFrontSlope() {
		return frontSlope;
	}

	public SlopeState getBackSlope() {
		return backSlope;
	}

	public void toggleSlope() {

		SlopeState oldFront = this.frontSlope;
		SlopeState oldBack = this.backSlope;
		if (frontMask == 0 || backMask == 0)
			return; // something wrong
		int front;
		int back;
		SlopeState[] values = SlopeState.values();
		int totalOrdinal = frontSlope.ordinal() + backSlope.ordinal() * 3;

		do {
			totalOrdinal++;
			totalOrdinal %= 9;
			front = totalOrdinal % 3;
			back = totalOrdinal / 3;

			frontSlope = values[front];
			backSlope = values[back];
		} while (!isInMask(frontSlope, frontMask) || !isInMask(backSlope, backMask));

		if (oldFront != frontSlope) {
			TileEntityConveyorBelt forward = getConveyor(this.forwardDirection.getOpposite(), this.frontSlope);
			if (forward != null) {
				if (forward.backSlope == SlopeState.FLAT) {
					if (frontSlope == SlopeState.UP)
						forward.backSlope = SlopeState.DOWN;
					else if (frontSlope == SlopeState.DOWN)
						forward.backSlope = SlopeState.UP;
				}
				forward.searchForConnections();
			}
		}
		if (oldBack != backSlope) {
			TileEntityConveyorBelt backward = getConveyor(this.forwardDirection, this.backSlope);
			if (backward != null) {
				if (backward.backSlope == SlopeState.FLAT) {
					if (frontSlope == SlopeState.UP)
						backward.backSlope = SlopeState.DOWN;
					else if (frontSlope == SlopeState.DOWN)
						backward.backSlope = SlopeState.UP;
				}
				backward.searchForConnections();
			}
		}
		this.searchForConnections();
	}

	@Override
	protected void beginConnectionUpdate() {
		boolean canGoDown = this.isAir(ForgeDirection.DOWN);
		backMask = checkMask(this.forwardDirection, canGoDown, false);
		frontMask = checkMask(this.forwardDirection.getOpposite(), canGoDown, true);
		System.out.println("TileEntityConveyorBelt.beginConnectionUpdate()" + frontMask + " " + backMask);
		if (!isInMask(frontSlope, frontMask)) {
			this.frontSlope = getSlopeFromMask(frontMask);
		}
		if (!isInMask(backSlope, backMask)) {
			this.backSlope = getSlopeFromMask(backMask);
		}
	}

	private SlopeState getSlopeFromMask(int mask) {
		if (isInMask(SlopeState.UP, mask))
			return SlopeState.UP;
		if (isInMask(SlopeState.DOWN, mask))
			return SlopeState.DOWN;

		return SlopeState.FLAT;
	}

	private boolean isInMask(SlopeState slope, int mask) {

		int maskBit = 1 << slope.ordinal();

		return (maskBit & mask) == maskBit;
	}

	private int checkMask(ForgeDirection dir, boolean canGoDown, boolean checkOpposite) {
		int mask = 1 << SlopeState.FLAT.ordinal();
		if (isAir(dir))
			mask += checkMask(dir, SlopeState.UP, checkOpposite);
		if (canGoDown)
			mask += checkMask(dir, SlopeState.DOWN, checkOpposite);

		return mask;
	}

	private int checkMask(ForgeDirection dir, SlopeState slope, boolean checkOpposite) {
		TileEntity top = getTileEntity(dir, slope);
		if (top instanceof TileEntityConveyorBelt) {
			TileEntityConveyorBelt belt = (TileEntityConveyorBelt) top;
			if ((belt.forwardDirection == dir && !checkOpposite) || (checkOpposite && belt.forwardDirection.getOpposite() == dir))
				return 1 << slope.ordinal();
		}
		return 0;
	}

	private boolean isAir(ForgeDirection dir, SlopeState slope) {
		int x = xCoord + dir.offsetX;
		int y = yCoord + dir.offsetY + slope.ordinal() - 1;
		int z = zCoord + dir.offsetZ;
		boolean air = this.worldObj.isAirBlock(x, y, z);
		if (!air) {
			return this.worldObj.getBlockTileEntity(x, y, z) instanceof TileEntityConveyorBelt;
		}
		return air;
	}

	private boolean isAir(ForgeDirection dir) {
		int x = xCoord + dir.offsetX;
		int y = yCoord + dir.offsetY;
		int z = zCoord + dir.offsetZ;

		boolean air = this.worldObj.isAirBlock(x, y, z);
		if (!air) {
			return this.worldObj.getBlockTileEntity(x, y, z) instanceof TileEntityConveyorBelt;
		}
		return air;
	}

	private TileEntity getTileEntity(ForgeDirection dir, SlopeState slope) {
		int x = xCoord + dir.offsetX;
		int y = yCoord + dir.offsetY + slope.ordinal() - 1;
		int z = zCoord + dir.offsetZ;
		return this.worldObj.getBlockTileEntity(x, y, z);
	}

	@Override
	protected TileEntity getNeighbor(ForgeDirection direction) {

		LocalDirection local = DirectionUtils.getLocalDirection(direction, this.forwardDirection);

		boolean sloped = (frontSlope != SlopeState.FLAT || backSlope != SlopeState.FLAT);

		if (sloped && (local != LocalDirection.FRONT && local != LocalDirection.BACK))
			return null; // no neighbors at the sides!

		int yOffset = 0;
		if (local == LocalDirection.BACK)
			yOffset = this.frontSlope.ordinal() - 1;
		else if (local == LocalDirection.FRONT)
			yOffset = this.backSlope.ordinal() - 1;

		TileEntity ent = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY + yOffset, zCoord + direction.offsetZ);

		return ent;

	}

	protected SlopeState getConnectionLevel(ForgeDirection side) {
		if (side == this.forwardDirection) {
			return this.frontSlope;
		} else if (side == this.forwardDirection.getOpposite()) {
			return this.backSlope;
		} else if (this.backSlope == SlopeState.FLAT && this.frontSlope == SlopeState.FLAT)
			return SlopeState.FLAT;
		else
			return SlopeState.NONE;
	}

	@Override
	protected TransportConnectionState getState(TileEntity entity, ForgeDirection direction) {

		if (entity instanceof TileEntityConveyorBelt) {
			TileEntityConveyorBelt belt = (TileEntityConveyorBelt) entity;

			SlopeState a = belt.getConnectionLevel(direction);
			if (a != SlopeState.NONE && a == this.getConnectionLevel(direction.getOpposite()).getOpposite()) {

				if(direction == forwardDirection.getOpposite() || direction == belt.forwardDirection)
				return TransportConnectionState.TRANSPORT;

			}
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
		if (stack.destination == LocalDirection.BACK) {
			TileEntityConveyorBelt conveyor = getConveyor(direction, this.frontSlope);
			if (conveyor != null && conveyor.states[direction.getOpposite().ordinal()] == TransportConnectionState.TRANSPORT) {
				System.out.println("TileEntityConveyorBelt.outputStack()");
				conveyor.addItemStack(stack.stack, direction.getOpposite());
				return true;
			}
		}

		ISidedInventory sidedInventory = getSidedInventory(direction);
		if (sidedInventory != null) {
			ItemStack rest = ItemTransfers.transfer(stack.stack, sidedInventory, direction.getOpposite());
			if (rest == null || rest.stackSize <= 0)
				return true;

			if (stack.destination != LocalDirection.BACK) {
				stack.stack = rest;
				stack.source = stack.destination;
				stack.destination = LocalDirection.FRONT; // bounce back
			} else {
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
					float dx = direction.offsetX + (float) rnd.nextGaussian();
					float dy = direction.offsetY + 5;
					float dz = direction.offsetZ + (float) rnd.nextGaussian();
					ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, dx / 10, dy / 10, dz / 10);
					return true;
				}
			} else {
				float dx = direction.offsetX;
				float dy = direction.offsetY;
				float dz = direction.offsetZ;
				ItemTransfers.launch(stack.stack, this.worldObj, this.xCoord + 0.5f + dx * 0.5f, this.yCoord + 0.2f, this.zCoord + 0.5f + dz * 0.5f, dx / 10, dy / 10, dz / 10);
				return true;
			}
		}

	}

	public Iterator<MovingItemStack> iterateStacks() {
		return this.itemStacks.iterator();
	}

	private TileEntityConveyorBelt getConveyor(ForgeDirection direction, SlopeState slope) {
		int slopeOffsetY = slope.ordinal() - 1;
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY + slopeOffsetY, zCoord + direction.offsetZ);
		if (entity instanceof TileEntityConveyorBelt)
			return (TileEntityConveyorBelt) entity;
		return null;
	}

	public void addItemStack(ItemStack stack, ForgeDirection source) {
		System.out.println("TileEntityConveyorBelt.addItemStack()" + source);
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
		nbt.setInteger("FrontSlope", this.frontSlope.ordinal());
		nbt.setInteger("BackSlope", this.backSlope.ordinal());

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
		this.forwardDirection = ForgeDirection.getOrientation(nbt.getInteger("Forward"));
		SlopeState[] states = SlopeState.values();
		this.frontSlope = states[nbt.getInteger("FrontSlope")];
		this.backSlope = states[nbt.getInteger("BackSlope")];
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

				float minX = (-4f + Math.min(0, direction.offsetX) * 4) / 16f;
				float maxX = (4f + Math.max(0, direction.offsetX) * 4) / 16f;

				float minZ = (-4f + Math.min(0, -direction.offsetZ) * 4) / 16f;
				float maxZ = (4f + Math.max(0, -direction.offsetZ) * 4) / 16f;

				float minY = -8f / 16f;
				float maxY = -7f / 16f;

				AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX + 0.5f, yCoord + minY + 0.5f, zCoord + minZ + 0.5f, xCoord + maxX + 0.5f, yCoord + maxY + 0.5f, zCoord + maxZ + 0.5f);
				if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
					par6List.add(axisalignedbb1);
				}

				if (states[i] != TransportConnectionState.NONE && states[i] != TransportConnectionState.TRANSPORT) {
					minY += 1;
					maxY += 8;
					axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX + 0.5f, yCoord + minY + 0.5f, zCoord + minZ + 0.5f, xCoord + maxX + 0.5f, yCoord + maxY + 0.5f, zCoord + maxZ + 0.5f);
					if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
						par6List.add(axisalignedbb1);
					}
				}
			}

		}

		TransportConnectionState up = states[ForgeDirection.UP.ordinal()];
		if (up != TransportConnectionState.NONE && up != TransportConnectionState.TRANSPORT) {
			float minX = -4f / 16f;
			float maxX = 4f / 16f;

			float minZ = -4f / 16f;
			float maxZ = 4f / 16f;

			float minY = -8f / 16f;
			float maxY = 8f / 16f;

			AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX + 0.5f, yCoord + minY + 0.5f, zCoord + minZ + 0.5f, xCoord + maxX + 0.5f, yCoord + maxY + 0.5f, zCoord + maxZ + 0.5f);
			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
		}

		TransportConnectionState down = states[ForgeDirection.DOWN.ordinal()];
		if (down != TransportConnectionState.NONE && down != TransportConnectionState.TRANSPORT) {
			float minX = -4f / 16f;
			float maxX = 4f / 16f;

			float minZ = -4f / 16f;
			float maxZ = 4f / 16f;

			float minY = -8f / 16f;
			float maxY = 1f / 16f;

			AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(xCoord + minX + 0.5f, yCoord + minY + 0.5f, zCoord + minZ + 0.5f, xCoord + maxX + 0.5f, yCoord + maxY + 0.5f, zCoord + maxZ + 0.5f);
			if (axisalignedbb1 != null && par5AxisAlignedBB.intersectsWith(axisalignedbb1)) {
				par6List.add(axisalignedbb1);
			}
		}

	}

	public void moveEntity(EntityLivingBase par5Entity) {

		double x = (-this.forwardDirection.offsetX * speed / 5 - par5Entity.motionX) / 5;
		double y = (-this.forwardDirection.offsetY * speed / 5 - par5Entity.motionY) / 5;
		double z = (-this.forwardDirection.offsetZ * speed / 5 - par5Entity.motionZ) / 5;

		par5Entity.addVelocity(x, y, z);

		if (par5Entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;

			IInventory inventory = player.inventory;
			if (player != null) {
				for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
					MovingItemStack stack = this.itemStacks.get(i);
					ItemStack rest = ItemTransfers.transfer(stack.stack, inventory);
					if (rest != null && rest.stackSize > 0)
						stack.stack = rest;
					else
						this.itemStacks.remove(i);
				}
			}
		}
	}

	public void setBounds() {
		float minX = -4f / 16f;
		float minY = -8f / 16f;
		float minZ = -4f / 16f;

		float maxX = 4f / 16f;
		float maxY = -7f / 16f;
		float maxZ = 4f / 16f;

		for (int i = 0; i < states.length; i++) {

			ForgeDirection dir = ForgeDirection.getOrientation(i);
			if (states[i] != TransportConnectionState.NONE) {

				float dx = dir.offsetX / 4f;
				float dy = dir.offsetY / 4f;
				float dz = dir.offsetZ / 4f;
				minX += Math.min(0, dx);
				minY += Math.min(0, dy);
				minZ += Math.min(0, dz);
				maxX += Math.max(0, dx);
				maxY += Math.max(0, dy);
				maxZ += Math.max(0, dz);
				if (states[i] != TransportConnectionState.TRANSPORT) {
					maxY += 10 / 16f;
				}
			} else if (dir == this.forwardDirection.getOpposite() && this.backSlope == SlopeState.FLAT) {
				float dx = dir.offsetX / 4f;
				float dy = dir.offsetY / 4f;
				float dz = dir.offsetZ / 4f;
				minX += Math.min(0, dx);
				minY += Math.min(0, dy);
				minZ += Math.min(0, dz);
				maxX += Math.max(0, dx);
				maxY += Math.max(0, dy);
				maxZ += Math.max(0, dz);
			}
		}

		if (this.frontSlope == SlopeState.DOWN || this.backSlope == SlopeState.DOWN)
			minY = Math.min(minY, -1f);

		if (this.frontSlope == SlopeState.UP || this.backSlope == SlopeState.UP)
			maxY = Math.max(maxY, 0);

		this.getBlockType().setBlockBounds(minX + 0.5f, minY + 0.5f, minZ + 0.5f, maxX + 0.5f, maxY + 0.5f, maxZ + 0.5f);
	}
}
