package mod.industrialProcessing.transport.items.conveyorBelt.tileEntity;

import java.util.List;

import mod.industrialProcessing.blockContainer.transport.TransportConnectionState;
import mod.industrialProcessing.transport.items.conveyorBelt.util.MovingItemStack;
import mod.industrialProcessing.transport.items.conveyorBelt.util.SlopeState;
import mod.industrialProcessing.utils.inventory.ItemTransfers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileEntityConveyorInteractionBase extends TileEntityConveyorTransportBase {

    @Override
    public void setBounds() {
	float xMin = -4 / 16f;
	float yMin = -16 / 16f;
	float zMin = -4 / 16f;
	float xMax = 4 / 16f;
	float yMax = -7 / 16f;
	float zMax = 4 / 16f;

	for (int i = 2; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[i];
	    if (state.isConnected()) {
		float dx = direction.offsetX / 2f;
		float dz = direction.offsetZ / 2f;

		SlopeState slope = getSlope(direction);

		float dy = -0.5f + (slope == SlopeState.NONE ? 0 : (slope.ordinal() - 1) / 2f);

		xMin = Math.min(xMin, dx);
		yMin = Math.min(yMin, dy);
		zMin = Math.min(zMin, dz);

		xMax = Math.max(xMax, dx);
		yMax = Math.max(yMax, dy);
		zMax = Math.max(zMax, dz);

	    }
	}

	this.getBlockType().setBlockBounds(xMin + 0.5f, yMin + 1f, zMin + 0.5f, xMax + 0.5f, yMax + 1f, zMax + 0.5f);
	// this.getBlockType().setBlockBounds(0, 0, 0, 1, 1, 1);
    }

    public void addCollisionBoxes(List par6List, AxisAlignedBB par5AxisAlignedBB) {

	double r = 4 / 16d;

	addCollisionBox(par6List, par5AxisAlignedBB, 0.5 - r, 1 - 8 / 16d, 0.5 - r, 0.5 + r, 1 - 7 / 16d, 0.5 + r);
	for (int i = 2; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    TransportConnectionState state = this.states[i];
	    if (state.isConnected()) {
		SlopeState slope = getSlope(direction);
		double a = 4 / 16f;
		double b = 8 / 16f;

		double c = 0.5f;

		double d = 7 / 16f;

		ForgeDirection angular = direction.getRotation(ForgeDirection.UP);

		double x1 = angular.offsetX * a + direction.offsetX * a;
		double x2 = angular.offsetX * b + direction.offsetX * a;

		double z1 = angular.offsetZ * a + direction.offsetZ * a;
		double z2 = angular.offsetZ * b + direction.offsetZ * a;

		double xMin = c + Math.min(x1, x2);
		double xMax = c + Math.max(x1, x2);
		double zMin = c + Math.min(z1, z2);
		double zMax = c + Math.max(z1, z2);

		double oY = slope == SlopeState.NONE ? 0 : 0.5f * (slope.ordinal() - 1);
		double yMin = c - b + Math.min(0, oY);
		double yMax = c - d + Math.max(0, oY);
		addCollisionBox(par6List, par5AxisAlignedBB, xMin, yMin + 0.5f, zMin, xMax, yMax + 0.5f, zMax);
	    }
	}
    }

    protected void addCollisionBox(List par6List, AxisAlignedBB par5AxisAlignedBB, double xMin, double yMin, double zMin, double xMax, double yMax, double zMax) {
	AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(xCoord + xMin, yCoord + yMin, zCoord + zMin, xCoord + xMax, yCoord + yMax, zCoord + zMax);
	if (bb.intersectsWith(par5AxisAlignedBB)) {
	    par6List.add(bb);
	}
    }

    public void moveEntity(EntityLivingBase par5Entity) {

	if (par5Entity instanceof EntityPlayerMP) {
	    EntityPlayer player = (EntityPlayer) par5Entity;
	    for (int i = this.itemStacks.size() - 1; i >= 0; i--) {
		MovingItemStack stack = this.itemStacks.get(i);
		ItemStack rest = ItemTransfers.transfer(stack.stack, player.inventory);
		if (rest != null && rest.stackSize > 0) {
		    if (rest.stackSize != stack.stack.stackSize)
			syncConveyor();
		    stack.stack = rest;
		} else {
		    this.itemStacks.remove(i);
		    syncConveyor();
		}
	    }
	}

	if (par5Entity.posY - par5Entity.yOffset < this.yCoord + 0.5f)
	    return;

	double dx = (par5Entity.posX - this.xCoord - 0.5f);
	double dy = (par5Entity.posY - this.yCoord - 1.0f + par5Entity.height);
	double dz = (par5Entity.posZ - this.zCoord - 0.5f);

	ForgeDirection output = ForgeDirection.UP;
	for (int i = 2; i < 6; i++) {
	    ForgeDirection direction = ForgeDirection.getOrientation(i);
	    if (isOutput(direction)) {
		output = direction;
		break;
	    }
	}

	SlopeState slope = getSlope(output);
	if (slope == SlopeState.NONE)
	    slope = SlopeState.FLAT;

	double tx = output.offsetX;
	double ty = output.offsetY + slope.ordinal() - 1;
	double tz = output.offsetZ;

	double vx = (tx - dx) / 3;
	double vy = (ty - dy) / 3;
	double vz = (tz - dz) / 3;

	double dvx = vx - par5Entity.motionX;
	double dvy = vy - par5Entity.motionZ;
	double dvz = vz - par5Entity.motionZ;

	par5Entity.addVelocity(dvx / 6 * this.speed, dvy / 4, dvz / 6 * this.speed);
    }
}
