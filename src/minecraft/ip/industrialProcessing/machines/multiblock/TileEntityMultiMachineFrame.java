package ip.industrialProcessing.machines.multiblock;

import org.lwjgl.Sys;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;

public abstract class TileEntityMultiMachineFrame extends TileEntity implements
		IMultiblockTileEntityFrame {

	public TileEntityMultiMachineFrame() {
		this.state = MachineFrameState.DISCONNECTED;
	}

	private int coreX;
	private int coreY;
	private int coreZ;
	private boolean hasCore;
	private MachineFrameState state;

	@Override
	public int getCoreX() {
		return this.coreX;
	}

	@Override
	public int getCoreY() {
		return this.coreY;
	}

	@Override
	public int getCoreZ() {
		return this.coreZ;
	}

	@Override
	public boolean hasCore() {
		return this.hasCore;
	}

	private void setCore(int x, int y, int z) {
		this.coreX = x;
		this.coreY = y;
		this.coreZ = z;
		this.hasCore = true;
	}

	@Override
	public void writeToNBT(net.minecraft.nbt.NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("hasCore", this.hasCore);
		if (this.hasCore) {
			par1NBTTagCompound.setInteger("cx", coreX);
			par1NBTTagCompound.setInteger("cy", coreY);
			par1NBTTagCompound.setInteger("cz", coreZ);
		}
	};

	@Override
	public void readFromNBT(net.minecraft.nbt.NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.hasCore = par1NBTTagCompound.getBoolean("hasCore");
		if (this.hasCore) {
			this.coreX = par1NBTTagCompound.getInteger("cx");
			this.coreY = par1NBTTagCompound.getInteger("cy");
			this.coreZ = par1NBTTagCompound.getInteger("cz");
		}
	};

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
	public void setCore(IMultiblockTileEntityCore core) {
		System.out.println("Set core @ " + this.xCoord + ", " + this.yCoord
				+ ", " + this.zCoord + " for frame @ " + core.getCoreX() + ", "
				+ core.getCoreY() + ", " + core.getCoreZ());
		this.setCore(core.getCoreX(), core.getCoreY(), core.getCoreZ());

		setBlockConnected(core.isStructureComplete());
	}

	private void setBlockConnected(boolean structureComplete) {
		MachineFrameState newState = structureComplete ? MachineFrameState.COMPLETED
				: MachineFrameState.CONNECTED;
		if (newState != this.state) {
			this.state = newState;
			updateState(newState);
		}
	}

	@Override
	public void setState(MachineFrameState state) {
		if (this.state != state) {
			this.state = state;
			updateState(state);
		}
	}

	@Override
	public MachineFrameState getState() {
		return this.state;
	}

	private void setBlockDisconnected() {
		if (this.state != MachineFrameState.DISCONNECTED) {
			this.state = MachineFrameState.DISCONNECTED;
			updateState(state);
		}
	}

	protected void updateState(MachineFrameState state) {
		System.out.println("Set state of frame @ " + xCoord + ", " + yCoord
				+ ", " + zCoord + " to " + state + "=>" + this.state);
		if (this.worldObj != null)
			this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord,
					state.ordinal(), 3);
	}

	@Override
	public void setWorldObj(World par1World) {
		super.setWorldObj(par1World);
	}
}
