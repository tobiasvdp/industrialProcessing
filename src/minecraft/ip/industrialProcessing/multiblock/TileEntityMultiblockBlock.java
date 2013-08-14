package ip.industrialProcessing.multiblock;

import ip.industrialProcessing.multiblock.utils.MultiblockState;

import org.lwjgl.Sys;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMultiblockBlock extends TileEntity implements ITileEntityMultiblockBlock {

	public TileEntityMultiblockBlock() {
		init = true;
		if (state == null)
			state = MultiblockState.DISCONNECTED;
	}

	private int count = 0;
	private int xCore;
	private int yCore;
	private int zCore;
	private boolean hasCore;
	private boolean init;
	protected MultiblockState state;

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

	private void setCore(int x, int y, int z) {
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
		if (this.hasCore) {
			par1NBTTagCompound.setInteger("cx", xCore);
			par1NBTTagCompound.setInteger("cy", yCore);
			par1NBTTagCompound.setInteger("cz", zCore);
			par1NBTTagCompound.setInteger("State", this.state.ordinal());
		}
	};

	@Override
	public void readFromNBT(net.minecraft.nbt.NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.hasCore = par1NBTTagCompound.getBoolean("hasCore");
		this.init = par1NBTTagCompound.getBoolean("init");
		if (this.hasCore) {
			this.xCore = par1NBTTagCompound.getInteger("cx");
			this.yCore = par1NBTTagCompound.getInteger("cy");
			this.zCore = par1NBTTagCompound.getInteger("cz");
			this.state = MultiblockState.fromInt(par1NBTTagCompound.getInteger("State"));
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
			ITileEntityMultiblockBlock block = (ITileEntityMultiblockBlock) worldObj.getBlockTileEntity(xCoord, yCoord, zCoord);
			if (block != null) {
				ITileEntityMultiblockCore core = block.getCore(worldObj);
				if (core != null) {
					if (block.getState() != core.getState()) {
						block.setState(core.getState());
						worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
					}
				} else {
					for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
						TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
						if (!block.hasCore()) {
							if (neighbour instanceof ITileEntityMultiblockBlock) {
								if (((ITileEntityMultiblockBlock) neighbour).hasCore()) {
									if (((ITileEntityMultiblockBlock) neighbour).getCore(worldObj) != null) {
										ITileEntityMultiblockCore neighbourCore = ((ITileEntityMultiblockBlock) neighbour).getCore(worldObj);
										if (neighbourCore.isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord))) {
											block.setCore(((ITileEntityMultiblockCore) neighbourCore));
											((ITileEntityMultiblockCore) neighbourCore).checkStructure();
											if (block.getState() != neighbourCore.getState()) {
												block.setState(((ITileEntityMultiblockCore) neighbourCore).getState());
												worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
												worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
											}
										}
									}
								}
							}

							else if (neighbour instanceof ITileEntityMultiblockCore) {
								if (((ITileEntityMultiblockCore) neighbour).isPartOfStructure(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord))) {
									block.setCore(((ITileEntityMultiblockCore) neighbour));
									((ITileEntityMultiblockCore) neighbour).checkStructure();
									if (block.getState() != ((ITileEntityMultiblockCore) neighbour).getState()) {
										block.setState(((ITileEntityMultiblockCore) neighbour).getState());
										worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
										worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, worldObj.getBlockId(xCoord, yCoord, zCoord));
									}
								}
							}
						}
					}
				}
			}
			init = false;
		}

	}

	@Override
	public void removeCore() {
		this.hasCore = false;
		setBlockDisconnected();
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
		} else {
			this.hasCore = false;
		}
	}

	private void setBlockConnected(boolean structureComplete) {
		MultiblockState newState = structureComplete ? MultiblockState.COMPLETED : MultiblockState.CONNECTED;
		if (newState != this.state) {
			this.state = newState;
			updateState(newState);
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

	private void setBlockDisconnected() {
		if (this.state != MultiblockState.DISCONNECTED) {
			this.state = MultiblockState.DISCONNECTED;
			updateState(state);
		}
	}

	protected void updateState(MultiblockState state) {
		if (this.worldObj != null)
			this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, state.ordinal(), 3);
	}

	@Override
	public void setWorldObj(World par1World) {
		super.setWorldObj(par1World);
	}

	public ITileEntityMultiblockCore getCore(World world) {
		if (hasCore)
			return (ITileEntityMultiblockCore) world.getBlockTileEntity(xCore, yCore, zCore);
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
}
