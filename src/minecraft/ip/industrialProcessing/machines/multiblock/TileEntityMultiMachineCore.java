package ip.industrialProcessing.machines.multiblock;

import java.util.Iterator;

import org.lwjgl.Sys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.Recipe;

public class TileEntityMultiMachineCore extends TileEntity implements
		IMultiblockTileEntityCore {

	private MultiBlockStructure structure;
	private boolean isStructureComplete;

	public TileEntityMultiMachineCore(MultiBlockStructure structure) {
		this.structure = structure;
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		// TODO Auto-generated method stub
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setBoolean("Completed", this.isStructureComplete);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		// TODO Auto-generated method stub
		super.readFromNBT(par1nbtTagCompound);
		this.isStructureComplete = par1nbtTagCompound.getBoolean("Completed");
	}

	@Override
	public boolean isStructureComplete() {
		return this.isStructureComplete;
	}

	@Override
	public void checkStructure() {

		boolean complete = true;
		MultiBlockStructureBlockDescription[] descriptions = this.structure
				.getDescriptions();
		for (MultiBlockStructureBlockDescription description : descriptions) {
			if (!description.isPresent(this.worldObj, this.xCoord, this.yCoord,
					this.zCoord)) {
				complete = false;
				break;
			}
		}
		if (complete && !isStructureComplete) {
			onStructureCompleted();
		} else if (!complete && isStructureComplete) {
			onStructureBroken();
		}
		this.isStructureComplete = complete;
	}

	protected void onStructureBroken() {
		System.out.println("Multistructure broken around core @ " + xCoord
				+ ", " + yCoord + ", " + zCoord);
	}

	protected void onStructureCompleted() {
		System.out.println("Multistructure completed around core @ " + xCoord
				+ ", " + yCoord + ", " + zCoord);
	}

	@Override
	public void breakEntireStructure() {
		MultiBlockStructureBlockDescription[] descriptions = this.structure
				.getDescriptions();
		for (MultiBlockStructureBlockDescription description : descriptions) {
			description.breakBlock(worldObj, xCoord, yCoord, zCoord);
		}
		this.isStructureComplete = false;
		onStructureBroken();
	}

	@Override
	public boolean isPartOfStructure(int x, int y, int z, int blockId) {
		MultiBlockStructureBlockDescription[] descriptions = this.structure
				.getDescriptions();
		for (MultiBlockStructureBlockDescription description : descriptions) {
			if (description.isPart(x, y, z, xCoord, yCoord, zCoord, blockId))
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

}
