package mod.industrialProcessing.plants.transport.items.ConveyorBeltPowerInput;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.client.rendering.tileEntity.IAnimationProgress;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationMode;
import mod.industrialProcessing.client.rendering.tileEntity.animation.TileAnimationSyncHandler;
import mod.industrialProcessing.power.utils.IMechanicalMotion;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import mod.industrialProcessing.utils.rotation.DirectionUtils;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityConveyorBeltPowerInput extends TileEntityBlockContainerIP implements IAnimationProgress, IMechanicalMotion {

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
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		if (te instanceof TileEntityConveyorConnectionsBase) {
			return ((TileEntityConveyorConnectionsBase) te).getLineID();
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
