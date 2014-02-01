package ip.industrialProcessing.microBlock;

import ip.industrialProcessing.utils.packets.PacketIP005DestroyBlock;

import java.util.Arrays;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.block.Block;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityMicroBlock extends TileEntity implements IMicroBlock, IPosition {
	protected int[] sidesMicroblock = new int[6];
	protected boolean hasCore = false;
	protected boolean overrideSolidSide;

	public TileEntityMicroBlock() {
		Arrays.fill(sidesMicroblock, -1);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.customParam1);
		this.worldObj.markBlockForRenderUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		sidesMicroblock = par1nbtTagCompound.getIntArray("sidesMicro");
		if(sidesMicroblock.length == 0){
			sidesMicroblock = new int[6];
			Arrays.fill(sidesMicroblock, -1);
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound) {
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setIntArray("sidesMicro", sidesMicroblock);
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
	public void setSide(ForgeDirection dir, int itemID, EntityPlayer player) {
		if (isValidID(itemID) && isValidPlacingSide(dir,itemID)) {
			if (player != null) {
				if (player.getCurrentEquippedItem() != null && !player.capabilities.isCreativeMode) {
					if (player.getCurrentEquippedItem().itemID == itemID) {
						if (countSetSides() != 0)
							player.getCurrentEquippedItem().splitStack(1);
					}
				}
			}
			sidesMicroblock[dir.ordinal()] = itemID;
			System.out.println("set " + dir + " to "+itemID);
			if (!isValidSide(dir)) {
				unsetSide(dir, null);
			}
			if(sidesMicroblock[dir.ordinal()] == itemID){
				onSetSide(dir, itemID);
			}
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		} else {
			if (countSetSides() == 0) {
				if (player == null || !player.capabilities.isCreativeMode){
					doDispense(this.worldObj, new ItemStack(itemID, 1, 0), 1, EnumFacing.values()[dir.getOpposite().ordinal()], this);
					worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
				}
			}
		}
	}

	public void onSetSide(ForgeDirection dir, int itemID) {
		
	}

	public abstract boolean isValidPlacingSide(ForgeDirection dir, int itemID);

	public abstract boolean isValidID(int itemID);

	@Override
	public void unsetSide(ForgeDirection dir, EntityPlayer player) {
		if (player == null || !player.capabilities.isCreativeMode)
			doDispense(this.worldObj, new ItemStack(sidesMicroblock[dir.ordinal()], 1, 0), 1, EnumFacing.values()[dir.getOpposite().ordinal()], this);
		sidesMicroblock[dir.ordinal()] = -1;
		System.out.println("unset " + dir);
		if(sidesMicroblock[dir.ordinal()] == -1){
			onUnsetSide(dir);
		}
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		if (!hasCore && countSetSides() == 0) {
			worldObj.destroyBlock(xCoord, yCoord, zCoord, false);
		}
	}
	
	public void onUnsetSide(ForgeDirection dir) {
		
	}

	public static void doDispense(World par0World, ItemStack par1ItemStack, int par2, EnumFacing par3EnumFacing, IPosition par4IPosition) {
		double d0 = par4IPosition.getX();
		double d1 = par4IPosition.getY();
		double d2 = par4IPosition.getZ();
		EntityItem entityitem = new EntityItem(par0World, d0, d1 - 0.3D, d2, par1ItemStack);
		double d3 = par0World.rand.nextDouble() * 0.1D + 0.2D;
		entityitem.motionX = (double) par3EnumFacing.getFrontOffsetX() * d3;
		entityitem.motionY = 0.20000000298023224D;
		entityitem.motionZ = (double) par3EnumFacing.getFrontOffsetZ() * d3;
		entityitem.motionX += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
		entityitem.motionY += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
		entityitem.motionZ += par0World.rand.nextGaussian() * 0.007499999832361937D * (double) par2;
		par0World.spawnEntityInWorld(entityitem);
	}

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
