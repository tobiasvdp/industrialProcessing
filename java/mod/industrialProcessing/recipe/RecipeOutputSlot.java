package mod.industrialProcessing.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class RecipeOutputSlot extends RecipeSlot {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
	public int maxAmount = 1;
	public int minAmount = 1;
	public int damage = 0;
	public double distributionCenter = 0.5;	
	
	public RecipeOutputSlot(int index,Item item, RecipeSlotType type,int minAmount,int maxAmount,double distributionCenter){
		super(index,item,type);
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.distributionCenter = distributionCenter;
	}
	
    public RecipeOutputSlot(int index,Item item, int damage, RecipeSlotType type,int minAmount,int maxAmount,double distributionCenter){
        super(index,item,type);
        this.damage = damage;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.distributionCenter = distributionCenter;
    }
	public RecipeOutputSlot(int index,ItemStack stack){
		super();
		this.index = index;
		this.item = stack.getItem();
		if(stack.isItemStackDamageable() && stack.getItemDamage()!= WILDCARD_VALUE){
			this.hasMetadata = true;
			this.metadata = stack.getItemDamage();
		}
		this.type = RecipeSlotType.INVENTORY;	
		this.maxAmount = stack.stackSize;
		this.minAmount = stack.stackSize;
		this.distributionCenter = 0;
	}
	public RecipeOutputSlot(int index,FluidStack stack){
		super();
		this.index = index;
		this.fluid = stack.getFluid();
		this.type = RecipeSlotType.TANK;
		this.maxAmount = stack.amount;
		this.minAmount = stack.amount;
		this.distributionCenter = 0;
	}
	public RecipeOutputSlot(int index,ItemStack stack,int min,int max){
		super();
		this.index = index;
		this.item = stack.getItem();
		if(stack.isItemStackDamageable() && stack.getItemDamage()!= WILDCARD_VALUE){
			this.hasMetadata = true;
			this.metadata = stack.getItemDamage();
		}
		this.type = RecipeSlotType.INVENTORY;	
		this.maxAmount = min;
		this.minAmount = max;
		this.distributionCenter = 0.5;
	}
	public RecipeOutputSlot(int index,FluidStack stack,int min,int max){
		super();
		this.index = index;
		this.fluid = stack.getFluid();
		this.type = RecipeSlotType.TANK;
		this.maxAmount = min;
		this.minAmount = max;
		this.distributionCenter = 0.5;
	}
}
