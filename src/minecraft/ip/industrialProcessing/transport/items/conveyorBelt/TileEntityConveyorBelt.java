package ip.industrialProcessing.transport.items.conveyorBelt;

import ic2.api.Direction;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IRotateableEntity;
import ip.industrialProcessing.transport.TileEntityTransport;
import ip.industrialProcessing.transport.TransportConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.util.ConveyorEnvironment;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.ItemTransfers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.lwjgl.Sys;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyorBelt extends TileEntityConveyorInteractionBase {

	public TileEntityConveyorBelt()
	{
		setConnectionMode(LocalDirection.BACK, ConnectionMode.OUTPUT);
		setConnectionMode(LocalDirection.UP, ConnectionMode.INPUT);
	}

	@Override
	protected ItemStack outputToTileEntity(MovingItemStack stack, TileEntity neighbor, ForgeDirection direction) {
		// can't output to tile entities!
		return stack.stack;
	}
}
