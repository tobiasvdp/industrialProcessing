package ip.industrialProcessing.utils.inventories;

import ip.industrialProcessing.machines.IMachineSlots;
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

public interface IInventories extends ISidedInventory, IMachineSlots {

}
