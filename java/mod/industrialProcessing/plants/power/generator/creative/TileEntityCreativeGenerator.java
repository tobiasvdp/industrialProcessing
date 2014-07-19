package mod.industrialProcessing.plants.power.generator.creative;

import mod.industrialProcessing.blockContainer.machine.power.generator.TileEntityPowerGenerator;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityCreativeGenerator extends TileEntityPowerGenerator implements IStateConfig {

	LocalDirection outputSide = LocalDirection.BACK;
	private AnimationHandler animationHandler;
	private int voltage;

	public TileEntityCreativeGenerator() {
		this.animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);
	}

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			this.animationHandler.update();
			this.animationHandler.setSpeed(this.voltage);
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}
		super.updateEntity();
	}

	@Override
	public float getVoltage() {
		return this.voltage;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Voltage", voltage);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		if (nbt.hasKey("Voltage"))
			this.voltage = nbt.getInteger("Voltage");
		else
			this.voltage = 100;
		super.readFromNBT(nbt);
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		LocalDirection power = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
		return power == outputSide;
	}

	@Override
	protected boolean isValidInput(int slot, Item itemID) {
		return false;
	}

	@Override
	public int getStateValue(int index) {
		if (index == 0)
			return this.voltage;
		return 0;
	}

	@Override
	public void setStateValue(int index, int value) {
		if (index == 0)
			this.voltage = value;

	}

	@Override
	public int getMaxStateValue(int index) {
		if (index == 0)
			return 1000;
		return 0;
	}

	@Override
	public int getMinStateValue(int index) {
		return 0;
	}

}
