package ip.industrialProcessing.machines.filter;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.inventories.IItemStacksInventory;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.Worker;

public class TileEntityFilter extends TileEntityMachine {

	public static RecipesFilter recipes = new RecipesFilter();

	private RecipeWorker recipeWorker;

	public TileEntityFilter() {
		this.recipeWorker = new RecipeWorker(this);
		super.setWorker(this.recipeWorker);

		this.addStack(null, ForgeDirection.UP, true, false);
		this.addStack(null,
				new ForgeDirection[] { ForgeDirection.SOUTH,
						ForgeDirection.NORTH, ForgeDirection.EAST,
						ForgeDirection.WEST }, false, true);
		this.addStack(null, ForgeDirection.DOWN, false, true);
	}
	
	@Override
	public void updateEntity() {
		work();
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER) {
			int x[] = syncWorker();
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
		        	outputStream.writeInt(this.xCoord);
		        	outputStream.writeInt(this.yCoord);
		        	outputStream.writeInt(this.zCoord);
			        outputStream.writeInt(x[0]);
			        outputStream.writeInt(x[1]);
			} catch (Exception ex) {
			        ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "IPTileSync";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			
			PacketDispatcher.sendPacketToAllPlayers(packet);
		}else{

		}
	}

	@Override
	public void workCancelled(boolean remote) {
		// TODO: stop sound
	}
	@Override
	public void beginWork(boolean remote) {
		// TODO: start sound
	}

	@Override
	public void workDone(boolean remote) {
		// TODO: stop sound
	}

	@Override
	public boolean hasWork() {
		return true;
	}

	@Override
	public boolean canWork() {
		return true;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return recipes.isValidInput(slot, itemID);
	}

	@Override
	public Iterator<Recipe> iterateRecipes() {
		return recipes.iterator();
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
    }

	public float getTiltZ() {
		int i = recipeWorker.getProgress() % 6;
		 i = i - 3;
		return i;
	}
	public float getTiltX() {
		int i = recipeWorker.getProgress() % 3;
		 i = i - 1;
		 i = -i;
		return i;
	}


}
