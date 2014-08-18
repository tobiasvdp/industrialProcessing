package mod.industrialProcessing.blockContainer.microblock.core;

import java.util.Arrays;

import mod.industrialProcessing.blockContainer.microblock.IMicroBlock;
import mod.industrialProcessing.blockContainer.microblock.MicroBlockType;
import mod.industrialProcessing.items.ItemMicroBlock;
import net.minecraft.block.Block;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityMicroBlock extends TileEntity implements IMicroBlock, IPosition {
	protected int[] sidesMicroblock = new int[6];
	protected int[] sidesMicroblockItemID = new int[6];
	protected boolean hasCore = false;
	protected boolean overrideSolidSide;
	protected int tileEntityLevel = 0;
	boolean refresh = false;

	public TileEntityMicroBlock() {
		Arrays.fill(sidesMicroblock, -1);
		Arrays.fill(sidesMicroblockItemID, -1);
	}
	
	@Override
	public void updateEntity() {
		if(refresh){
			refresh = false;
			notifyOnCreation();
		}
		super.updateEntity();
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);

		tileEntityLevel = par1nbtTagCompound.getInteger("tileEntityLevel");
		sidesMicroblock = par1nbtTagCompound.getIntArray("sidesMicro");
		sidesMicroblockItemID = par1nbtTagCompound.getIntArray("sidesMicroID");
		if (sidesMicroblock.length == 0) {
			sidesMicroblock = new int[6];
			Arrays.fill(sidesMicroblock, -1);
		}
		if (sidesMicroblockItemID.length == 0) {
			sidesMicroblockItemID = new int[6];
			Arrays.fill(sidesMicroblockItemID, -1);
		}

		NBTTagCompound thisNBT = new NBTTagCompound();
		this.writeToNBT(thisNBT);
		if (!thisNBT.getString("id").equals(par1nbtTagCompound.getString("id"))) {
			thisNBT.setString("id", par1nbtTagCompound.getString("id"));
			TileEntity te = TileEntity.createAndLoadEntity(thisNBT);
			worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			TileEntity newTe = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			((TileEntityMicroBlock) te).refresh = true;
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("tileEntityLevel", tileEntityLevel);
		par1nbtTagCompound.setIntArray("sidesMicro", sidesMicroblock);
		par1nbtTagCompound.setIntArray("sidesMicroID", sidesMicroblockItemID);
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
		if (itemMicroBlock.isValidPlacingSide(dir, worldObj, xCoord, yCoord, zCoord, itemMicroBlock) && isValidSide(dir) && isCompatible(itemMicroBlock)) {
			if (player != null) {
				if (player.getCurrentEquippedItem() != null && !player.capabilities.isCreativeMode) {
					if (player.getCurrentEquippedItem().equals(itemMicroBlock)) {
						player.getCurrentEquippedItem().splitStack(1);
					}
				}
			}
			boolean firstSide = countSetSides() == 0;
			sidesMicroblock[dir.ordinal()] = itemMicroBlock.microblock;
			sidesMicroblockItemID[dir.ordinal()] = Item.getIdFromItem(itemMicroBlock);
			if (firstSide) {
				switchTileEntities();
			}
			System.out.println("set " + dir + " to " + itemMicroBlock.microblock);
			onSetSide(dir, itemMicroBlock.microblock);
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		} else {
			if (countSetSides() == 0) {
				worldObj.func_147480_a(xCoord, yCoord, zCoord, false);
			}
		}
	}

	private boolean isCompatible(ItemMicroBlock itemMicroBlock) {
		if (countSetSides() == 0) {
			return true;
		} else {

			for (int i = 0; i < 6; i++) {
				if (sidesMicroblockItemID[i] != -1) {
					Item item = Item.getItemById(sidesMicroblockItemID[i]);
					if (item != null && item instanceof ItemMicroBlock) {
						if (((ItemMicroBlock) item).isCompatible(itemMicroBlock)) {
							return true;
						} else {
							return false;
						}

					}
				}
			}
		}
		return true;
	}

	private void switchTileEntities() {
		int level = -1;
		for (int i = 0; i < 6; i++) {
			if (sidesMicroblockItemID[i] != -1) {
				Item item = Item.getItemById(sidesMicroblockItemID[i]);
				if (item instanceof ItemMicroBlock) {
					level = Math.max(level, ((ItemMicroBlock) item).level);
				}
			}
		}
		if (level > this.tileEntityLevel) {
			TileEntity te = null;
			int i = 0;
			while (te == null) {
				if (sidesMicroblockItemID[i] != -1) {
					Item item = Item.getItemById(sidesMicroblockItemID[i]);
					if (item instanceof ItemMicroBlock) {
						if (((ItemMicroBlock) item).level == level) {
							NBTTagCompound nbtTag = new NBTTagCompound();
							this.writeToNBT(nbtTag);
							nbtTag.setString("id", ((ItemMicroBlock) item).getTileEntityName());
							te = TileEntity.createAndLoadEntity(nbtTag);
							worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
							TileEntity newTe = worldObj.getTileEntity(xCoord, yCoord, zCoord);
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
		this.worldObj.notifyBlockChange(xCoord, yCoord, zCoord, this.getBlockType());
	}

	@Override
	public boolean unsetSide(ForgeDirection dir, EntityPlayer player) {
		if (player == null || !player.capabilities.isCreativeMode)
			doDispense(this.worldObj, new ItemStack(Item.getItemById(sidesMicroblockItemID[dir.ordinal()]), 1, 0), 1, EnumFacing.values()[dir.getOpposite().ordinal()], this);
		sidesMicroblock[dir.ordinal()] = -1;
		sidesMicroblockItemID[dir.ordinal()] = -1;
		System.out.println("unset " + dir);
		if (sidesMicroblock[dir.ordinal()] == -1) {
			onUnsetSide(dir);
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		if (!hasCore && countSetSides() == 0) {
			worldObj.func_147480_a(xCoord, yCoord, zCoord, false);
			return true;
		}
		return false;
	}

	public void onUnsetSide(ForgeDirection dir) {

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
			Block block = worldObj.getBlock(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (block.isSideSolid(worldObj, xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ, dir.getOpposite()) || overrideSolidSide) {
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

	public abstract MicroBlockType getType();

	@Override
	public ItemMicroBlock getItemOnSide(ForgeDirection dir) {
		if (sidesMicroblockItemID[dir.ordinal()] >= 0) {
			Item item = Item.getItemById(sidesMicroblockItemID[dir.ordinal()]);
			return (ItemMicroBlock) item;
		}
		return null;
	}
}
