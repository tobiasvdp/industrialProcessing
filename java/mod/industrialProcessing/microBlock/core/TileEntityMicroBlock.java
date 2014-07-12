package ip.industrialProcessing.microBlock.core;

import ip.industrialProcessing.items.ItemMicroBlock;
import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.MicroBlockType;

import java.util.Arrays;

import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMicroBlock extends TileEntity implements IMicroBlock, IPosition {
	protected int[] sidesMicroblock = new int[6];
	protected int[] sidesMicroblockItemID = new int[6];
	protected MicroBlockType type = MicroBlockType.wire;
	protected boolean hasCore = false;
	protected boolean overrideSolidSide;
	protected int tileEntityLevel = -1;

	public TileEntityMicroBlock() {
		Arrays.fill(sidesMicroblock, -1);
		Arrays.fill(sidesMicroblockItemID, -1);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		sidesMicroblock = par1nbtTagCompound.getIntArray("sidesMicro");
		sidesMicroblockItemID = par1nbtTagCompound.getIntArray("sidesMicroID");
		type = MicroBlockType.values()[par1nbtTagCompound.getInteger("MicroBlockType")];
		tileEntityLevel = par1nbtTagCompound.getInteger("tileEntityLevel");
		if (sidesMicroblock.length == 0) {
			sidesMicroblock = new int[6];
			Arrays.fill(sidesMicroblock, -1);
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setIntArray("sidesMicro", sidesMicroblock);
		par1nbtTagCompound.setIntArray("sidesMicroID", sidesMicroblockItemID);
		par1nbtTagCompound.setInteger("MicroBlockType", type.ordinal());
		par1nbtTagCompound.setInteger("tileEntityLevel",tileEntityLevel);
	}

	@Override
	public boolean isSideFree(ForgeDirection dir) {
		return isSideFree(dir.ordinal());
	}

	@Override
	public boolean isSideFree(int dir) {
		return sidesMicroblock[dir] == -1;
	}

	@Override
	public void setSide(ForgeDirection dir, ItemMicroBlock itemMicroBlock, EntityPlayer player) {
		if (itemMicroBlock.isValidID(itemMicroBlock.itemID) && itemMicroBlock.isValidPlacingSide(dir, worldObj, xCoord, yCoord, zCoord, itemMicroBlock) && isValidSide(dir) && !(itemMicroBlock.type == MicroBlockType.device && type == MicroBlockType.device)) {
			if (player != null) {
				if (player.getCurrentEquippedItem() != null && !player.capabilities.isCreativeMode) {
					if (player.getCurrentEquippedItem().itemID == itemMicroBlock.itemID) {
						player.getCurrentEquippedItem().splitStack(1);
					}
				}
			}
			boolean firstSide = countSetSides() == 0;
			sidesMicroblock[dir.ordinal()] = itemMicroBlock.microblock;
			sidesMicroblockItemID[dir.ordinal()] = itemMicroBlock.itemID;
			if (itemMicroBlock.type == MicroBlockType.device){
				type = MicroBlockType.device;
				switchTileEntities();
			}else{
				if(firstSide){
					switchTileEntities();
				}
			}
			System.out.println("set " + dir + " to " + itemMicroBlock.microblock);
			onSetSide(dir, itemMicroBlock.microblock);
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		} else {
			if (countSetSides() == 0) {
				worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
			}
		}
	}

	private void switchTileEntities() {
		int level = -1;
		for(int i = 0;i<6;i++){
			if(sidesMicroblockItemID[i] != -1){
				Item item = Item.itemsList[sidesMicroblockItemID[i]];
				if(item instanceof ItemMicroBlock){
					level = Math.max(level, ((ItemMicroBlock)item).level);
				}
			}
		}
		if(level > this.tileEntityLevel){
			TileEntity te = null;
			int i = 0;
			while(te == null){
				if(sidesMicroblockItemID[i] != -1){
					Item item = Item.itemsList[sidesMicroblockItemID[i]];
					if(item instanceof ItemMicroBlock){
						if(((ItemMicroBlock)item).level == level){
							NBTTagCompound nbtTag = new NBTTagCompound();
							this.writeToNBT(nbtTag);
							nbtTag.setString("id", ((ItemMicroBlock)item).getTileEntityName());
							te = TileEntity.createAndLoadEntity(nbtTag);
							worldObj.setBlockTileEntity(xCoord, yCoord, zCoord, te);
							((TileEntityMicroBlock)te).notifyOnCreation();
						}
					}
				}
				i++;
			}
		}
	}

	protected void notifyOnCreation() {
		refresh();
	}

	public void onSetSide(ForgeDirection dir, int itemID) {

	}

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		if (player == null || !player.capabilities.isCreativeMode)
			doDispense(this.worldObj, new ItemStack(sidesMicroblockItemID[dir.ordinal()], 1, 0), 1, EnumFacing.values()[dir.getOpposite().ordinal()], this);
		sidesMicroblock[dir.ordinal()] = -1;
		sidesMicroblockItemID[dir.ordinal()] = -1;
		System.out.println("unset " + dir);
		if (sidesMicroblock[dir.ordinal()] == -1) {
			onUnsetSide(dir);
		}
		if(countDevices() ==0){
			type = MicroBlockType.wire;
			switchTileEntities();
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		if (!hasCore && countSetSides() == 0) {
			worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
		}
	}

	public void onUnsetSide(ForgeDirection dir) {

	}

	private int countDevices() {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			int id = sidesMicroblockItemID[i];
			if (id != -1) {
				if (Item.itemsList[id] != null && Item.itemsList[id] instanceof ItemMicroBlock) {
					if (((ItemMicroBlock) Item.itemsList[id]).type == MicroBlockType.device)
						count++;
				}
			}
		}
		return count;
	}

	public static void doDispense(World par0World, ItemStack par1ItemStack, int par2, EnumFacing par3EnumFacing, IPosition par4IPosition) {
		double d0 = par4IPosition.getX();
		double d1 = par4IPosition.getY();
		double d2 = par4IPosition.getZ();
		EntityItem entityitem = new EntityItem(par0World, d0, d1 - 0.3D, d2, par1ItemStack);
		double d3 = par0World.rand.nextDouble() * 0.1D + 0.2D;
		entityitem.motionX = par3EnumFacing.getFrontOffsetX() * d3;
		entityitem.motionY = 0.20000000298023224D;
		entityitem.motionZ = par3EnumFacing.getFrontOffsetZ() * d3;
		entityitem.motionX += par0World.rand.nextGaussian() * 0.007499999832361937D * par2;
		entityitem.motionY += par0World.rand.nextGaussian() * 0.007499999832361937D * par2;
		entityitem.motionZ += par0World.rand.nextGaussian() * 0.007499999832361937D * par2;
		par0World.spawnEntityInWorld(entityitem);
	}

	@Override
	public int countSetSides() {
		int count = 0;
		for (int i = 0; i < sidesMicroblock.length; i++) {
			if (sidesMicroblock[i] != -1) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int[] getSides() {
		return sidesMicroblock;
	}

	@Override
	public void refresh() {
		for (int i = 0; i < sidesMicroblock.length; i++) {
			ForgeDirection dir = ForgeDirection.values()[i];
			if (!isValidSide(dir)) {
				unsetSide(dir, null);
			}
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	private boolean isValidSide(ForgeDirection dir) {
		if (!isSideFree(dir)) {
			if (worldObj.isBlockSolidOnSide(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ, dir.getOpposite()) || overrideSolidSide) {
				return true;
			}
			return false;
		}
		return true;
	}

	@Override
	public double getX() {
		return xCoord + 0.5;
	}

	@Override
	public double getY() {
		return yCoord + 0.5;
	}

	@Override
	public double getZ() {
		return zCoord + 0.5;
	}

	protected void notifyBlockChange() {
		if (!this.worldObj.isRemote) {
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

			StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
			StackTraceElement e = stacktrace[2];// maybe this number needs to be
			// corrected
			String methodName = e.getMethodName();
			String className = e.getClassName();
		}

	}
}
