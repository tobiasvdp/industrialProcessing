package ip.industrialProcessing.power.meters;

import org.bouncycastle.asn1.x509.Targets;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.IAnimationSyncable;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.IPowerAcceptor;
import ip.industrialProcessing.power.TileEntityPowerGenerator;
import ip.industrialProcessing.power.utils.PowerAcceptorConnection;
import ip.industrialProcessing.power.utils.PowerDistributor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityAmpMeter extends TileEntityPowerGenerator implements IPowerAcceptor, IAnimationProgress, IAnimationSyncable {

	LocalDirection inputSide = LocalDirection.BACK;
	LocalDirection outputSide = LocalDirection.UP;

	private PowerDistributor distributor;
	private boolean unVerified = true;
	private float voltage = 0;
	private float resistance = Float.POSITIVE_INFINITY;
	private float coulombs = 0;
	private float outputCharge;
	private AnimationHandler animationHandler;

	public TileEntityAmpMeter() {
		super(1000);
		unVerified = true;
		this.distributor = new PowerDistributor();
		this.animationHandler = new AnimationHandler(AnimationMode.CLAMP, 1, true);
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (unVerified)
			checkOutput();

		if (!this.worldObj.isRemote) {
			float targetAngle = this.outputCharge * 20 / 50;
			// 0.25 sec to go from current angle to target angle?
			this.animationHandler.moveToProgress(targetAngle, 0.25f); 
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
		}

		// TODO: see if this can be done serverside only without problems with
		// other power devices.

		if (voltage > 0) // distribute last pass
			this.distributor.distributePower(voltage, coulombs, this.worldObj);
		this.coulombs = this.outputCharge = 0;
		// fetch resistance for next pass
		this.resistance = this.distributor.getResistance(this.voltage, this.worldObj);

		this.animationHandler.update();
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		LocalDirection output = DirectionUtils.getLocalDirection(opposite, getForwardDirection());
		return output == outputSide;
	}

	@Override
	public float getVoltage() {
		return this.voltage;
	}

	@Override
	public float getAnimationProgress(float scale, int index) {
		return this.animationHandler.getAnimationProgress(scale);
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getResistance(ForgeDirection side, float voltage) {
		return this.resistance;
	}

	@Override
	public void applyPower(ForgeDirection side, float coulombs, float voltage) {
		this.voltage = voltage;
		this.coulombs += coulombs;
	}

	@Override
	public boolean canAcceptPower(ForgeDirection side) {
		LocalDirection input = DirectionUtils.getLocalDirection(side, getForwardDirection());
		return input == inputSide;
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public void checkConnections() {
		unVerified = true;
	}

	private void checkOutput() {
		ForgeDirection output = DirectionUtils.getWorldDirection(outputSide, getForwardDirection());
		IPowerAcceptor acceptor = getAcceptor(output);
		if (acceptor == null || !acceptor.canAcceptPower(output.getOpposite()))
			this.distributor.setOutputs();
		PowerAcceptorConnection connection = new PowerAcceptorConnection(xCoord + output.offsetX, yCoord + output.offsetY, zCoord + output.offsetZ, output.getOpposite());
		this.distributor.setOutputs(connection);
		unVerified = false;
	}

	private IPowerAcceptor getAcceptor(ForgeDirection output) {
		TileEntity entity = this.worldObj.getBlockTileEntity(xCoord + output.offsetX, yCoord + output.offsetY, zCoord + output.offsetZ);
		if (entity instanceof IPowerAcceptor)
			return (IPowerAcceptor) entity;
		return null;
	}

	@Override
	public float getCharge(float amount) {
		float delta = Math.min(this.coulombs, amount);
		this.coulombs -= delta;
		this.outputCharge += delta;
		return delta;
	}

	@Override
	public AnimationHandler getAnimationHandler() {
		return this.animationHandler;
	}
}
