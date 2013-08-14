package ip.industrialProcessing.multiblock;

import java.util.Iterator;

import org.lwjgl.Sys;

import net.minecraft.nbt.NBTTagCompound;
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
	private MultiblockState state;

	public TileEntityMultiblockCore(MultiblockLayout structure) {
		this.state = MultiblockState.CONNECTED;
		this.layout = structure;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setBoolean("isFormed", this.isMultiblock);
		par1nbtTagCompound.setInteger("State", this.state.ordinal());
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		this.isMultiblock = par1nbtTagCompound.getBoolean("isFormed");
		this.state = MultiblockState.fromInt(par1nbtTagCompound.getInteger("State"));
	}

	@Override
	public boolean isMultiblock() {
		return this.isMultiblock;
	}

	@Override
	public boolean checkStructure() {
		MultiblockState state = MultiblockState.COMPLETED;
		if (layout.checkLayout(worldObj, xCoord, yCoord, zCoord)) {
			System.out.println("Struct compelete");
			state = MultiblockState.COMPLETED;
			isMultiblock = true;
		} else {
			state = MultiblockState.CONNECTED;
			System.out.println("Struct broken");
			isMultiblock = false;
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
		return layout.hasDiscriptionBlockId(x, y, z, blockId,true);
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

}
