package ip.industrialProcessing.machines.animation.tanks;

import net.minecraftforge.fluids.IFluidTank;

public interface ITankSyncable {
	TankHandler getTankHandler();
	 IFluidTank getTankInSlot(int slot);
	 int getTankCount();
}
