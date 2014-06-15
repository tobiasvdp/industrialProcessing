package mod.industrialProcessing.blockContainer.multiblock.coreAndDummy;

import java.util.ArrayList;

import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.dummy.extend.TileEntityMultiblockDummyInvAndTank;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import mod.industrialProcessing.utils.registry.BlockSwitcherRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMultiblockSwitcherDummy extends TileEntityMultiblockDummyInvAndTank implements ITileEntityMultiblockSwitcher {

	private boolean isCore = false;
	boolean visitedForTranslate = false;

	@Override
	public TileEntityMultiblockSwitcherCore getCore() {
		if (super.getCore() instanceof TileEntityMultiblockSwitcherCore)
			return (TileEntityMultiblockSwitcherCore) super.getCore();
		return null;
	}

	public void switchToCore() {
		if (requirementToBecomeCore()) {

			NBTTagCompound nbtTag = new NBTTagCompound();
			this.writeToNBT(nbtTag);
			String myUnlocalizedName = nbtTag.getString("id");
			nbtTag.setString("id", unlocalizedCoreName().substring(5));
			nbtTag.setBoolean("isCore", true);
			nbtTag.removeTag("Core");
			NBTTagList tag = nbtTag.getTagList("Data", 10);
			nbtTag.removeTag("Data");
			nbtTag.setTag("Core", tag);
			TileEntity te = TileEntity.createAndLoadEntity(nbtTag);
			worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			/*if(worldObj.isRemote){
				Minecraft.getMinecraft().renderGlobal.tileEntities.remove(this);
				Minecraft.getMinecraft().renderGlobal.tileEntities.add(te);
			}*/
			((TileEntityMultiblockSwitcherCore) te).notifyOnCreation(myUnlocalizedName);
		}
	}

	public abstract boolean requirementToBecomeCore();

	public String unlocalizedCoreName() {
		return BlockSwitcherRegistry.getCoreName(this.getBlockType().getUnlocalizedName());
	}

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
			worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
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

	public void resolveSwitcher() {
		MultiblockMass mass = new MultiblockMass(this);
		if (this.getBlockType() != null && this.getBlockType() instanceof IDescriptionMultiblock)
			mass.fitMultiblock(((IDescriptionMultiblock)this.getBlockType()).getStructure());
	}

	public void notifyOnCreation() {

	}

}
