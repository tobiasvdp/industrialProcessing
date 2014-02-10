package ip.industrialProcessing.multiblock.coreAndDummy;

import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTank;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.extend.TileEntityMultiblockDummyInvAndTank;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMultiblockSwitcherDummy extends TileEntityMultiblockDummyInvAndTank implements ITileEntityMultiblockSwitcher {

	private boolean isCore = false;

	@Override
	public TileEntityMultiblockCoreTank getCore() {
		if (super.getCore() instanceof TileEntityMultiblockSwitcherCore)
			return super.getCore();
		return null;
	}

	public void switchToCore() {
		System.out.println("switching to Core");
		if (requirementToBecomeCore()) {
			NBTTagCompound nbtTag = new NBTTagCompound();
			this.writeToNBT(nbtTag);
			nbtTag.setString("id", unlocalizedCoreName());
			nbtTag.setBoolean("isCore", true);
			nbtTag.removeTag("Core");
			NBTTagList tag = nbtTag.getTagList("Data");
			nbtTag.removeTag("Data");
			nbtTag.setTag("Core", tag);
			TileEntity te = TileEntity.createAndLoadEntity(nbtTag);
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
			((TileEntityMultiblockSwitcherCore) te).notifyOnCreation();
		}
	}

	@Override
	protected void notifyNeighboursOfCoreSet() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TileEntityMultiblockDummy) {
				TileEntityMultiblockDummy te = (TileEntityMultiblockDummy) neighbour;
				if (te.getCore() == null)
					te.searchForCore();
			}
			if(neighbour instanceof TileEntityMultiblockSwitcherCore && getCore() != neighbour){
				if(getCore().countDummies() >=  ((TileEntityMultiblockSwitcherCore)neighbour).countDummies()){
					ArrayList<TileEntityMultiblockDummy> dummies = ((TileEntityMultiblockSwitcherCore)neighbour).getDummies();
					for(int i = 0;i<dummies.size();i++){
						dummies.get(i).delCore();
					}
					int id = worldObj.getBlockId(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
					
					worldObj.setBlock(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ, id);
					((TileEntityMultiblockSwitcherDummy)worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ)).resolveSwitcher();
					
					for(int i = 0;i<dummies.size();i++){
						dummies.get(i).searchForCore();
					}
				}else{
					ArrayList<TileEntityMultiblockDummy> dummies = getCore().getDummies();
					for(int i = 0;i<dummies.size();i++){
						dummies.get(i).delCore();
					}
					int coreX =getCore().xCoord;
					int coreY =getCore().yCoord;
					int coreZ =getCore().zCoord;
					int id = worldObj.getBlockId(coreX, coreY, coreZ);
					
					worldObj.setBlock(coreX, coreY, coreZ, id);
					((TileEntityMultiblockSwitcherDummy)worldObj.getBlockTileEntity(coreX, coreY, coreZ)).resolveSwitcher();
					
					for(int i = 0;i<dummies.size();i++){
						dummies.get(i).searchForCore();
					}
				}
			}
		}
	}

	public abstract boolean requirementToBecomeCore();

	public abstract String unlocalizedCoreName();

	@Override
	public boolean isCore() {
		return isCore;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		isCore = nbt.getBoolean("isCore");
		if (isCore && worldObj.isRemote) {
			System.out.println("need to switch to core");
			TileEntity te = TileEntity.createAndLoadEntity(nbt);
			worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
			((TileEntityMultiblockSwitcherCore) te).notifyOnCreation();
		} else {
			super.readFromNBT(nbt);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("isCore", isCore);
		super.writeToNBT(nbt);
	}
	
	public void resolveSwitcher(){
		if (searchForCore()) {
			getCore().onLayoutChange();
		} else {
			switchToCore();
		}
	}

}
