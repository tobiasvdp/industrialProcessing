package ip.industrialProcessing.transport.items.conveyorBelt;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorInteractionBase extends TileEntityConveyorTransportBase {

	public void addCollisionBoxes(List par6List, AxisAlignedBB par5AxisAlignedBB) {

	}

	public void moveEntity(EntityLivingBase par5Entity) {
		double dx = this.xCoord - par5Entity.posX;
		double dy = this.yCoord - par5Entity.posY;
		double dz = this.zCoord - par5Entity.posZ;

		double bestMatch = 0;
		ForgeDirection bestQuadrant = ForgeDirection.UNKNOWN;
		for (int i = 2; i < 6; i++) {
			ForgeDirection direction = ForgeDirection.getOrientation(i);
			double match = (direction.offsetX * dx) + (direction.offsetZ * dz);
			if (match > bestMatch) {
				bestQuadrant = direction;
				bestMatch = match;
			}
		}
		if (bestQuadrant != ForgeDirection.UNKNOWN) {

			ConnectionMode mode = getConnectionMode(bestQuadrant);

			double tx = 0;
			double tz;
			if (mode == ConnectionMode.OUTPUT) {
				tx = 0.5 + bestQuadrant.offsetX;
				tz = 0.5 + bestQuadrant.offsetZ;
			} else if (mode == ConnectionMode.INPUT) {
				tx = 0.5;
				tz = 0.5;
			} else
				return;

			double vx = (tx - dx);
			double vz = (tz - dz);

			double len = Math.sqrt(vx * vx + vz * vz);

			vx /= len * this.speed;
			vz /= len * this.speed;

			double dvx = vx - par5Entity.motionX;
			double dvz = vz - par5Entity.motionZ;

			par5Entity.addVelocity(dvx, 0, dvz);

		}
	}
}
