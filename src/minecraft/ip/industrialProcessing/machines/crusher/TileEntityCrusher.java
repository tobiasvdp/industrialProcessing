package ip.industrialProcessing.machines.crusher;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.TileEntityPoweredWorkerMachine;
import ip.industrialProcessing.machines.TileEntityWorkerMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.recipeRegistry.RecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidStack;

public class TileEntityCrusher extends TileEntityPoweredWorkerMachine {

	public static RecipesMachine recipes = new RecipesMachine(RecipeRegistry.getRecipesForMachine(IndustrialProcessing.blockCrusher));

	public TileEntityCrusher() {
		super(LocalDirection.LEFT, 10000, 100); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
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
