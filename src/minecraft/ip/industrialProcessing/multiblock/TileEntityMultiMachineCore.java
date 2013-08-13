package ip.industrialProcessing.multiblock;

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
			if (description.isPresent(this.worldObj, this.xCoord, this.yCoord,
					this.zCoord)) {
				IMultiblockTileEntityFrame frame = MultiblockUtils.getFrameAt(this.worldObj, this.xCoord+description.getX(), this.yCoord+description.getY(), this.zCoord+description.getZ());
				if(frame == null) {complete = false; break;}
				else
				{
					if(!MultiblockUtils.isFrameForCore(frame, this, this.worldObj)) // this block is claimed by another core!
					{
						complete = false;
						break;
					}						
				}
			}else{
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
		setState(MachineFrameState.CONNECTED);
	}

	protected void onStructureCompleted() {
		System.out.println("Multistructure completed around core @ " + xCoord
				+ ", " + yCoord + ", " + zCoord);
		setState(MachineFrameState.COMPLETED);
	}
	private void setState(MachineFrameState state) {

		MultiBlockStructureBlockDescription[] descriptions = this.structure
				.getDescriptions();
		for (MultiBlockStructureBlockDescription description : descriptions) {
			IMultiblockTileEntityFrame frame = MultiblockUtils.getFrameAt(this.worldObj, xCoord+description.getX(), yCoord+description.getY(), zCoord+description.getZ());
			if(frame != null)
			{
				frame.setState(state);
			}
		}
	}


	@Override
	public void breakEntireStructure() {
		/*
		MultiBlockStructureBlockDescription[] descriptions = this.structure
				.getDescriptions();
		for (MultiBlockStructureBlockDescription description : descriptions) {
			description.breakBlock(worldObj, xCoord, yCoord, zCoord);
		}
		this.isStructureComplete = false;
		onStructureBroken();
		*/
		setState(MachineFrameState.DISCONNECTED);
	}

	@Override
	public boolean isPartOfStructure(int x, int y, int z, int blockId) {
		IMultiblockTileEntityFrame frame = MultiblockUtils.getFrameAt(this.worldObj, x, y, z);
		if(frame != null && (frame.hasCore() && !MultiblockUtils.isFramePointingToCore(frame, this))) 
			return false;// frame belongs to another core!
		
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
