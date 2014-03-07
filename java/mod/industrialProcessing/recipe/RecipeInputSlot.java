package mod.industrialProcessing.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeInputSlot extends RecipeSlot {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	public int amount;
	public RecipeInputSlot(int index,Item item, RecipeSlotType type,int amount){
		super(index,item,type);
		this.amount = amount;
	}
	public RecipeInputSlot(int index,Item item,int metadata, RecipeSlotType type,int amount){
		super(index,item,metadata,type);
		this.amount = amount;
	}
	public RecipeInputSlot(int index,ItemStack stack){
		super();
		this.index = index;
		this.item = stack.getItem();
		if(stack.getItemDamage() != 0 && stack.getItemDamage()!= WILDCARD_VALUE){
			this.hasMetadata = true;
			this.metadata = stack.getItemDamage();
		}
		if(stack.isItemStackDamageable() && stack.getItemDamage()== WILDCARD_VALUE){
			this.type = RecipeSlotType.DAMAGEDITEM;
		}else{
			this.type = RecipeSlotType.INVENTORY;
		}		
		this.amount = stack.stackSize;
	}
	public RecipeInputSlot(int index,FluidStack stack){
		super();
		this.index = index;
		this.fluid = stack.getFluid();
		this.type = RecipeSlotType.TANK;
		this.amount = stack.amount;
	}
}
