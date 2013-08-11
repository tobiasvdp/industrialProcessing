package ip.industrialProcessing.machines.filter;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.packetHandlers.TileSyncHandler;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeWorker;
import ip.industrialProcessing.utils.inventories.IItemStacksInventory;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import ip.industrialProcessing.utils.working.IWorkHandler;
import ip.industrialProcessing.utils.working.ServerWorker;

public class TileEntityFilter extends TileEntityPoweredWorkerMachine {

    public static RecipesFilter recipes = new RecipesFilter();

    public TileEntityFilter() {
	super(LocalDirection.LEFT, 10000);
	this.addStack(null, LocalDirection.UP, true, false);
	this.addStack(null, LocalDirection.LEFT, false, true);
	this.addStack(null, LocalDirection.DOWN, false, true);
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return recipes.isValidInput(slot, itemID);
    }

    @Override
    public Iterator<Recipe> iterateRecipes() {
	return recipes.iterator();
    }
}
