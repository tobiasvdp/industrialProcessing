package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.MultiblockItemStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMultiblockBlock extends TileEntity implements ITileEntityMultiblockBlock {

	public TileEntityMultiblockBlock() {
		init = true;
		if (state == null)
			state = MultiblockState.DISCONNECTED;
	}

	private int count = 0;
	protected int xCore;
	protected int yCore;
	protected int zCore;
	protected boolean hasCore;
	protected boolean init;
	protected MultiblockState state;
	public boolean[] connectedSides = new boolean[6];
	public int modelID;

	public boolean[] getConnectedSides() {
		return this.connectedSides;
	}

	@Override
	public int getCoreX() {
		return this.xCore;
	}

	@Override
	public int getCoreY() {
		return this.yCore;
	}

	@Override
	public int getCoreZ() {
		return this.zCore;
	}

	@Override
	public boolean hasCore() {
		return this.hasCore;
	}

	protected void setCore(int x, int y, int z) {
		this.xCore = x;
		this.yCore = y;
		this.zCore = z;
		this.hasCore = true;
	}

	@Override
	public void writeToNBT(net.minecraft.nbt.NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("hasCore", this.hasCore);
		par1NBTTagCompound.setBoolean("init", this.init);
		par1NBTTagCompound.setInteger("modelID", this.modelID);
		if (this.hasCore) {
			par1NBTTagCompound.setInteger("cx", xCore);
			par1NBTTagCompound.setInteger("cy", yCore);
			par1NBTTagCompound.setInteger("cz", zCore);
			par1NBTTagCompound.setInteger("State", this.state.ordinal());
		}
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < 6; ++i) {
			NBTTagCompound nbttagcompound = new NBTTagCompound();
			nbttagcompound.setBoolean("Side" + i, connectedSides[i]);
			nbttaglist.appendTag(nbttagcompound);
		}
		par1NBTTagCompound.setTag("Sides", nbttaglist);

	};

	@Override
	public void readFromNBT(net.minecraft.nbt.NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.hasCore = par1NBTTagCompound.getBoolean("hasCore");
		this.init = par1NBTTagCompound.getBoolean("init");
		this.modelID = par1NBTTagCompound.getInteger("modelID");
		if (this.hasCore) {
			this.xCore = par1NBTTagCompound.getInteger("cx");
			this.yCore = par1NBTTagCompound.getInteger("cy");
			this.zCore = par1NBTTagCompound.getInteger("cz");
			this.state = MultiblockState.fromInt(par1NBTTagCompound.getInteger("State"));
		}
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Sides");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			connectedSides[i] = nbttagcompound1.getBoolean("Side" + i);
		}
	};

	@Override
	public void updateEntity() {
		if (count == 20) {
			count = 0;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		count++;
		if (init) {
			if (!hasCore) {
				setCore(searchForCore());
				if (hasCore()) {
					getCore().checkStructure();
					checkModelID();
					onStateChanged();
				}

			}
			checkConnectedSides();
			init = false;
		}

	}

	@Override
	public int getFrameX() {
		return this.xCoord;
	}

	@Override
	public int getFrameY() {
		return this.yCoord;
	}

	@Override
	public int getFrameZ() {
		return this.zCoord;
	}

	@Override
	public void setCore(ITileEntityMultiblockCore core) {
		if (core != null) {
			this.setCore(core.getCoreX(), core.getCoreY(), core.getCoreZ());
			state = MultiblockState.CONNECTED;
		} else {
			state = MultiblockState.DISCONNECTED;
			this.hasCore = false;
		}
	}

	@Override
	public void setState(MultiblockState state) {
		this.state = state;
	}

	@Override
	public MultiblockState getState() {
		return this.state;
	}

	@Override
	public void setWorldObj(World par1World) {
		super.setWorldObj(par1World);
	}

	@Override
	public ITileEntityMultiblockCore getCore() {
		if (hasCore)
			return (ITileEntityMultiblockCore) worldObj.getBlockTileEntity(xCore, yCore, zCore);
		else {
			setCore(null);
		}
		return null;
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		NBTTagCompound tag = pkt.customParam1;
		this.readFromNBT(tag);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, tag);
	}

	@Override
	public void destroyBlock() {
		if (state == MultiblockState.COMPLETED) {
			if (getCore() != null) {
				getCore().breakMultiblock();
			}
		}
	}

	@Override
	public void neighbourChanged() {
		MultiblockState prevState = state;
		switch (state) {
		case COMPLETED: {
			if (getCore() != null) {
				if (getCore().isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord)))
					state = getCore().getState();
				else
					setCore(null);
			} else {
				setCore(null);
				worldObj.destroyBlock(xCoord, yCoord, zCoord, true);
			}
			break;
		}
		case CONNECTED: {
			if (getCore() != null) {
				if (getCore().isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord)))
					state = getCore().getState();
				else
					setCore(null);
			} else {
				setCore(null);
				worldObj.destroyBlock(xCoord, yCoord, zCoord, true);
			}
			break;
		}
		default: {
			hasCore = false;
			setCore(searchForCore());
			if (hasCore())
				getCore().checkStructure();
		}
		}
		if (prevState != state)
			onStateChanged();
	}

	public void checkConnectedSides() {
		int i = 0;
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {

			TileEntity te = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (te != null) {
				if (te instanceof TileEntityMultiblockBlock || te instanceof TileEntityMultiblockCore) {
					connectedSides[i] = true;
				} else {
					connectedSides[i] = false;
				}
			} else {
				connectedSides[i] = false;
			}
			i++;
		}
		if (worldObj.getBlockId(xCoord, yCoord - 1, zCoord) == 0)
			connectedSides[0] = false;
		else
			connectedSides[0] = true;

		transformConnectionsToSides();

	}

	private void transformConnectionsToSides() {
		boolean temp;
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		switch (meta) {
		case 1:
			temp = connectedSides[2];
			connectedSides[2] = connectedSides[5];
			connectedSides[4] = temp;
			temp = connectedSides[3];
			connectedSides[3] = connectedSides[4];
			connectedSides[5] = temp;
			break;
		case 2: {
			temp = connectedSides[2];
			connectedSides[2] = connectedSides[3];
			connectedSides[3] = temp;
			temp = connectedSides[4];
			connectedSides[4] = connectedSides[5];
			connectedSides[5] = temp;
			break;
		}
		case 3:
			temp = connectedSides[2];
			connectedSides[2] = connectedSides[4];
			connectedSides[5] = temp;
			temp = connectedSides[3];
			connectedSides[3] = connectedSides[5];
			connectedSides[4] = temp;
			break;
		default:
		}

	}

	public void checkModelID() {
		if (getCore() != null)
			modelID = getCore().checkModelID(xCoord, yCoord, zCoord);
		else
			modelID = 0;
	}

	@Override
	public ITileEntityMultiblockCore searchForCore() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof ITileEntityMultiblockBlock) {
				ITileEntityMultiblockBlock tileEntityBlock = (ITileEntityMultiblockBlock) neighbour;
				if (tileEntityBlock.hasCore()) {
					if (tileEntityBlock.getCore() != null) {
						if (tileEntityBlock.getCore().isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord)))
							return tileEntityBlock.getCore();
					}
				}
			} else if (neighbour instanceof ITileEntityMultiblockCore) {
				ITileEntityMultiblockCore tileEntityCore = (ITileEntityMultiblockCore) neighbour;
				if (tileEntityCore.isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord)))
					return tileEntityCore;
			}
		}
		return null;
	}

	@Override
	public void onStateChanged() {
		worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
	}
}