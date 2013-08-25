package ip.industrialProcessing.multiblock;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.layout.BlockForward;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;

public class TileEntityMultiblockCore extends TileEntity implements ITileEntityMultiblockCore {

	protected MultiblockLayout layout;
	public EntityLivingBase creator;
	private boolean isMultiblock;
	protected MultiblockState state;
	private BlockForward angle = BlockForward.INVALID;
	private boolean locked;
	private boolean init;
	private boolean[] connectedSides = new boolean[6];
	public int modelID;
	private int count = 0;

	public TileEntityMultiblockCore(MultiblockLayout structure) {
		this.layout = structure;
		this.state = MultiblockState.CONNECTED;
		init = true;
	}

	@Override
	public void updateEntity() {
		if (count == 20) {
			count = 0;
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		count++;
		if (init){
			checkModelID();
			checkConnectedSides();
			init = false;
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setBoolean("isFormed", this.isMultiblock);
		par1nbtTagCompound.setBoolean("init", this.init);
		par1nbtTagCompound.setBoolean("Locked", this.locked);
		par1nbtTagCompound.setInteger("State", this.state.ordinal());
		par1nbtTagCompound.setInteger("Angle", this.angle.ordinal());
		par1nbtTagCompound.setInteger("ModelId", this.modelID);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < 6; ++i) {
			NBTTagCompound nbttagcompound = new NBTTagCompound();
			nbttagcompound.setBoolean("Side" + i, connectedSides[i]);
			nbttaglist.appendTag(nbttagcompound);
		}
		par1nbtTagCompound.setTag("Sides", nbttaglist);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.isMultiblock = par1nbtTagCompound.getBoolean("isFormed");
		this.init = par1nbtTagCompound.getBoolean("init");
		this.locked = par1nbtTagCompound.getBoolean("Locked");
		this.state = MultiblockState.fromInt(par1nbtTagCompound.getInteger("State"));
		this.angle = BlockForward.values()[par1nbtTagCompound.getInteger("Angle")];
		this.modelID = par1nbtTagCompound.getInteger("ModelId");
		NBTTagList nbttaglist = par1nbtTagCompound.getTagList("Sides");
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			connectedSides[i] = nbttagcompound1.getBoolean("Side" + i);
		}
	}

	@Override
	public boolean isMultiblock() {
		return this.isMultiblock;
	}

	@Override
	public boolean checkStructure() {
		MultiblockState state = MultiblockState.DISCONNECTED;
		BlockForward newAngle = layout.getLayoutForward(worldObj, xCoord, yCoord, zCoord, angle);
		if (newAngle != BlockForward.INVALID) {
			state = MultiblockState.COMPLETED;
			isMultiblock = true;
			locked = true;
			angle = newAngle;
			System.out.println("Multiblock made");
			if(creator != null)
			triggerAchievement();
		} else {
			state = MultiblockState.CONNECTED;
			isMultiblock = false;
			locked = false;
		}
		if (this.state != state) {
			this.state = state;
			onStateChanged();
			return false;
		} else {
			return true;
		}
	}

	protected void triggerAchievement() {

	}

	@Override
	public MultiblockState getState() {
		return state;
	}

	@Override
	public void breakEntireStructure() {
		state = MultiblockState.DISCONNECTED;
		onStateChanged();
	}

	@Override
	public boolean isPartOfStructure(int x, int y, int z, int blockId) {
		x = x - xCoord;
		y = y - yCoord;
		z = z - zCoord;
		BlockForward forward = layout.hasDiscriptionBlockId(x, y, z, blockId, locked, angle);
		if (forward != BlockForward.INVALID) {
			if (!locked)
				this.angle = forward;
			return true;
		}
		return false;
	}

	@Override
	public int getCoreX() {
		return this.xCoord;
	}

	@Override
	public int getCoreY() {
		return this.yCoord;
	}

	@Override
	public int getCoreZ() {
		return this.zCoord;
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
	public void breakMultiblock() {
		this.state = MultiblockState.CONNECTED;
		locked = false;
		onStateChanged();
		checkStructure();
	}

	public void onStateChanged() {
		worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
	}

	@Override
	public int checkModelID(int xCoord, int yCoord, int zCoord) {
		return layout.getModelID(xCoord - this.xCoord, yCoord - this.yCoord, zCoord - this.zCoord, angle);
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
		modelID = checkModelID(0, 0, 0);
	}

	public boolean[] getConnectedSides() {
		return connectedSides;
	}
	public ForgeDirection getForwardDirection() {
		int meta = this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		return BlockMachine.getForwardFromMetadata(meta);
	}
	public ItemStack[][][] getItemStackLayout(){
		return layout.getItemStackLayout(worldObj, xCoord, yCoord, zCoord, angle);
	}
}
