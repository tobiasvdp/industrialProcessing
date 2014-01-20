package ip.industrialProcessing.multiblock.dummy.block.controlBox;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.utils.IReceiver;
import ip.industrialProcessing.utils.IRemote;

public class TileEntityControlBox extends TileEntityMultiblockDummy implements IReceiver{
	public TileEntityControlBox() {
		super();
	}
	
	TileEntity te;
	int[] teCoord;

	@Override
	public boolean receiveTileEntity(IRemote remote,ItemStack itemStack) {
		teCoord=remote.getTileEntity(this, itemStack);
		te = null;
		return true;
	}
	
	public TileEntity getTileEntity(){
		if(te == null && teCoord != null){
			te=worldObj.getBlockTileEntity(teCoord[0], teCoord[1], teCoord[2]);
		}
		return te;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		te = null;
		teCoord = nbt.getIntArray("storedTE");
		super.readFromNBT(nbt);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setIntArray("", teCoord);
		super.writeToNBT(nbt);
	}

}
