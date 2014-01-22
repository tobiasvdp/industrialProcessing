package ip.industrialProcessing.transport.items.ConveyorBeltPowerInput;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.machines.animation.AnimationMode;
import ip.industrialProcessing.machines.animation.TileAnimationSyncHandler;
import ip.industrialProcessing.power.plants.IMechanicalMotion;
import ip.industrialProcessing.transport.items.ConveyorLine;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.registry.HandlerRegistry;

public class TileEntityConveyorBeltPowerInput extends TileEntityMachine implements IAnimationProgress, IMechanicalMotion {

	private AnimationHandler animationHandler;
	LocalDirection inputSide = LocalDirection.FRONT;
	boolean isLoaded = false;
	public int conveyorLine = -1;

	public TileEntityConveyorBeltPowerInput() {
		this.animationHandler = new AnimationHandler(AnimationMode.WRAP, 1f, true);
	}

	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			animationHandler.setSpeed((float) (animationHandler.getSpeed() * 0.9));
			this.animationHandler.update();
			TileAnimationSyncHandler.sendAnimationData(this, this.animationHandler);
			if (!isLoaded) {
				register();
				isLoaded = true;
			}
		}
		super.updateEntity();
	}

	@Override
	public float setSpeed(ForgeDirection side, float speed) {
		ForgeDirection direction = DirectionUtils.getWorldDirection(this.inputSide, this.getForwardDirection());
		if (side == direction) {
			this.animationHandler.setSpeed(speed);
			if (conveyorLine != -1) {
				return HandlerRegistry.getResistanceForConveyorLine(conveyorLine);
			}
		}
		return 0;
	}

	@Override
	public int getAnimationCount() {
		return 1;
	}

	@Override
	public float getAnimationProgress(float scale, int animationIndex) {
		return this.animationHandler.getAnimationProgress(scale);
	}

	@Override
	protected boolean isValidInput(int slot, int itemID) {
		return false;
	}

	public boolean hasLine() {
		return conveyorLine != -1;
	}

	public void unregister() {
		HandlerRegistry.removeFromConveyorLine(this.conveyorLine, this);
		this.conveyorLine = -1;
	}

	public void register() {
		int id = getConveyorLineID();
		if (id != -1)
			if (HandlerRegistry.addToConveyorLine(id, this)) {
				this.conveyorLine = id;
			}
	}

	private int getConveyorLineID() {
		TileEntity te = worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord);
		if (te instanceof TileEntityConveyorConnectionsBase) {
			return ((TileEntityConveyorConnectionsBase) te).getConveyorLineID();
		}
		return -1;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

	public float getSpeed() {
		return animationHandler.getSpeed();
	}

	public void conveyorLineSet(int iD) {
		if(iD != conveyorLine){
			unregister();
			register();
		}
	}
}
