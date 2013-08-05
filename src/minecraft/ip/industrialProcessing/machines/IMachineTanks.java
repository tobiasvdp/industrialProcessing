package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public interface IMachineTanks {

	boolean tankContains(int slot, int itemId, int amount);

	boolean tankHasRoomFor(int slot, FluidStack stack);
	boolean tankHasRoomFor(int slot, int itemId, int amount);
	
	boolean addToTank(int index, int itemId, int amount);

	boolean removeFromTank(int index, int itemId, int amount);
}
