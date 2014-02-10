package ip.industrialProcessing.subMod.blackSmith.plant.waterBasin;

import javax.naming.ldap.HasControls;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import ip.industrialProcessing.machines.animation.tanks.TileTankSyncHandler;
import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class TileEntityWaterBasinDummy extends TileEntityMultiblockSwitcherDummy implements ITankSyncable {
	private TankHandler tankHandler;

	@Override
	public boolean requirementToBecomeCore() {
		return true;
	}

	@Override
	public String unlocalizedCoreName() {
		return "IP.MBC.WaterB";
	}

	public TileEntityWaterBasinDummy() {
		if (getCore() != null)
			this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public TankHandler getTankHandler() {
		return tankHandler;
	}

	@Override
	public IFluidTank getTankInSlot(int slot) {
		if (getCore() != null) {
			return getCore().getTankInSlot(slot);
		}
		return null;
	}

	@Override
	public int getTankCount() {
		return 1;
	}

	@Override
	public void updateEntity() {
		if (getCore() != null && tankHandler == null)
			this.tankHandler = new TankHandler(this, new int[] { 0 });
		if (!worldObj.isRemote && this.tankHandler != null && this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
		super.updateEntity();
	}

	public void handleRightClick(EntityPlayer player) {
		if (getCore() != null) {
			((TileEntityWaterBasinCore) getCore()).handleRightClick(player);
		}
	}

	public void spawnSmoke() {
		for (double j = 0; j < 1; j += 0.1) {
			for (double i = 0; i < 1; i += 0.1) {
				worldObj.spawnParticle("smoke", xCoord + i, yCoord + 1, zCoord + j, 0.0D, 0.0D, 0.0D);
			}
		}
	}
}
