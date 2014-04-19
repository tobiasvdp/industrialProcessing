package mod.industrialProcessing.client.rendering.tileEntity.animation.tanks;

import net.minecraftforge.fluids.IFluidTank;

public interface ITankSyncable {
	TankHandler getTankHandler();
	 IFluidTank getTankInSlot(int slot);
	 int getTankCount();
}
