package ip.industrialProcessing.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeInputSlot extends RecipeSlot {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	public int amount;
	public RecipeInputSlot(int index,int itemId, RecipeSlotType type,int amount){
		super(index,itemId,type);
		this.amount = amount;
	}
	public RecipeInputSlot(int index,int itemId,int metadata, RecipeSlotType type,int amount){
		super(index,itemId,metadata,type);
		this.amount = amount;
	}
	public RecipeInputSlot(int index,ItemStack stack){
		super();
		this.index = index;
		this.itemId = stack.itemID;
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
		this.itemId = stack.fluidID;
		this.type = RecipeSlotType.TANK;
		this.amount = stack.amount;
	}
}
