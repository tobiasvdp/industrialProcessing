package ip.industrialProcessing.machines.crusher;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.recipes.Recipe;
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

public class TileEntityCrusher extends TileEntityMachine implements IPowerAcceptor {

    private static final int MAX_STORED_POWER = 1000;
    private int storedPower = 0;

    public static RecipesCrusher recipes = new RecipesCrusher();
    private int speed;
    public EntityPlayer placedBy;
    private LocalDirection powerInputDirection;

    public TileEntityCrusher() {
	this.addStack(null, LocalDirection.UP, true, false);
	this.addStack(null, LocalDirection.DOWN, false, true);
	this.speed = 10;
	this.powerInputDirection = LocalDirection.LEFT;
    }

    @Override
    public void updateEntity() {
	// TODO: this still consumes power if there is no work!
	int maxConsume = Math.min(storedPower, 10);
	maxConsume = work(maxConsume/5) * 5; 
	this.storedPower -= maxConsume;  
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
    public int acceptPower(int maxAmount, ForgeDirection side) {
	LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	if (direction == powerInputDirection) {
	    int maxRequest = (MAX_STORED_POWER - storedPower);
	    maxRequest = Math.min(maxAmount, maxRequest);
	    this.storedPower += maxRequest; 
	    return maxRequest;
	}
	return 0;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection direction = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return direction == powerInputDirection;
    }

}
