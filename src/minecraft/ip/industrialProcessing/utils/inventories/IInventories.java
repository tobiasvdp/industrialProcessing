package ip.industrialProcessing.utils.inventories;

import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockItemStack;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public interface IInventories extends ISidedInventory {

	public int[] getAccessibleSlotsFromSide(int ID, int side);

	public boolean canInsertItem(int i, ItemStack itemstack, int ID, int side);

	public boolean canExtractItem(int i, ItemStack itemstack, int ID, int side);

	public void writeInventory(NBTTagCompound nbt);

	public void readInventory(NBTTagCompound nbt);
}
