package ip.industrialProcessing.multiblock.extended.inventory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldServerMulti;
import ip.industrialProcessing.multiblock.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.block.inventory.TileEntityMultiblockInvInput;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import ip.industrialProcessing.multiblock.utils.inventory.IMultiblockInventoryBlock;
import ip.industrialProcessing.multiblock.utils.layout.MultiblockLayout;

public abstract class TileEntityMultiblockBlockInv extends TileEntityMultiblockBlock implements IMultiblockInventoryBlock {
	public int inventoryID = 1;

	public static void handleNewInventoryID(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		;
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		int newID;
		int x;
		int y;
		int z;

		try {
			newID = inputStream.readInt();
			x = inputStream.readInt();
			y = inputStream.readInt();
			z = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		EntityPlayerMP playerMP = (EntityPlayerMP) player;
		TileEntity te = playerMP.worldObj.getBlockTileEntity(x, y, z);
		if (te instanceof TileEntityMultiblockBlockInv)
			((TileEntityMultiblockBlockInv)(te)).inventoryID = newID;
	}

	public TileEntityMultiblockBlockInv() {
		super();
	}

	public int getInventorySlot() {
		return getCore().getSlotforID(inventoryID);
	}

	@Override
	public TileEntityMultiblockCoreInv getCore() {
		return (TileEntityMultiblockCoreInv) worldObj.getBlockTileEntity(xCore, yCore, zCore);
	}

	@Override
	public int getSizeInventory() {
		if (hasCore)
			return getCore().getSizeInventory();
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if (hasCore)
			return getCore().getStackInSlot(i);
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (hasCore)
			return getCore().decrStackSize(i, j);
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		if (hasCore)
			getCore().setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		if (hasCore)
			return getCore().getInventoryStackLimit();
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		if (hasCore)
			return getCore().getAccessibleSlotsForID(this.inventoryID);
		return null;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {

		if (hasCore)
			return getCore().isItemValidForSlot(i, itemstack);
		return false;

	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	public int prevValidID() {
		return getCore().prevValidID(inventoryID);
	}

	public int nextValidID() {
		return getCore().nextValidID(inventoryID);
	}
	public int firstValidID(){
		return getCore().firstValidID(this instanceof TileEntityMultiblockInvInput);
	}
	@Override
	public void setCore(ITileEntityMultiblockCore core) {
		if (core != null) {
			this.setCore(core.getCoreX(), core.getCoreY(), core.getCoreZ());
			state = MultiblockState.CONNECTED;
			inventoryID = firstValidID();
		} else {
			state = MultiblockState.DISCONNECTED;
			this.hasCore = false;
		}
	}
}
