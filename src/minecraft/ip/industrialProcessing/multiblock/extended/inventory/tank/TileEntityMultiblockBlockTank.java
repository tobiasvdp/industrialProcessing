package ip.industrialProcessing.multiblock.extended.inventory.tank;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockBlockInv;
import ip.industrialProcessing.multiblock.extended.inventory.TileEntityMultiblockCoreInv;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public abstract class TileEntityMultiblockBlockTank extends TileEntityMultiblockBlockInv implements IFluidHandler {
	
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}
	
	@Override
	public TileEntityMultiblockCoreTank getCore() {
		return (TileEntityMultiblockCoreTank) worldObj.getBlockTileEntity(xCore, yCore, zCore);
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return getCore().fill(inventoryID, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		return getCore().drain(inventoryID, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return getCore().drain(inventoryID, maxDrain, doDrain);
	}
	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return getCore().getTankInfo(from);
	}
	@Override
	public int firstValidID(){
		return -1;
	}
	@Override
	public int prevValidID() {
		return getCore().prevValidTankID(inventoryID);
	}
	@Override
	public int nextValidID() {
		return getCore().nextValidTankID(inventoryID);
	}
}
