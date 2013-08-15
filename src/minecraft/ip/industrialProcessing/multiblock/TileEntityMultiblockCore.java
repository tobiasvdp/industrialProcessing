package ip.industrialProcessing.multiblock;

import java.util.Iterator;

import org.lwjgl.Sys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockLayout;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.MultiblockUtils;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiblockCore extends TileEntity implements ITileEntityMultiblockCore {

	private MultiblockLayout layout;
	private boolean isMultiblock;
	protected MultiblockState state;
	private int angle;
	private boolean init;

	public TileEntityMultiblockCore(MultiblockLayout structure) {
		this.layout = structure;
		this.state = MultiblockState.CONNECTED;
		init = true;
	}

	@Override
	public void updateEntity() {

		if (init) {
			layout.setAngle(this.angle);
		}
		init = false;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setBoolean("isFormed", this.isMultiblock);
		par1nbtTagCompound.setBoolean("init", this.init);
		par1nbtTagCompound.setInteger("State", this.state.ordinal());
		par1nbtTagCompound.setInteger("Angle", this.angle);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.isMultiblock = par1nbtTagCompound.getBoolean("isFormed");
		this.init = par1nbtTagCompound.getBoolean("init");
		this.state = MultiblockState.fromInt(par1nbtTagCompound.getInteger("State"));
		this.angle = par1nbtTagCompound.getInteger("Angle");
	}

	@Override
	public boolean isMultiblock() {
		return this.isMultiblock;
	}

	@Override
	public boolean checkStructure() {
		MultiblockState state = MultiblockState.COMPLETED;
		if (layout.checkLayout(worldObj, xCoord, yCoord, zCoord)) {
			state = MultiblockState.COMPLETED;
			isMultiblock = true;
			layout.locked = true;
		} else {
			state = MultiblockState.CONNECTED;
			isMultiblock = false;
			layout.locked = false;
		}

		if (this.state != state) {
			this.state = state;
			return false;
		} else {
			return true;
		}
	}

	private void setState(MultiblockState state) {
		this.state = state;
	}

	public MultiblockState getState() {
		return state;
	}

	@Override
	public void breakEntireStructure() {
		setState(MultiblockState.DISCONNECTED);
	}

	@Override
	public boolean isPartOfStructure(int x, int y, int z, int blockId) {
		x = x - xCoord;
		y = y - yCoord;
		z = z - zCoord;
		return layout.hasDiscriptionBlockId(x, y, z, blockId, true);
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
		checkStructure();
	}
}
