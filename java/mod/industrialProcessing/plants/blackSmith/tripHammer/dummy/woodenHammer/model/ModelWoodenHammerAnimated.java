package mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer.model;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import mod.industrialProcessing.plants.blackSmith.tripHammer.TileEntityTripHammer;
import mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenBar.TileEntityWoodenBar;
import mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer.TileEntityWoodenHammer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class ModelWoodenHammerAnimated extends ModelAnimatedMachine {

	Hammer bar = new Hammer();
	BloomIron iron = new BloomIron();
	HotIron finishedIron = new HotIron();

	IIcon icon = new IIcon() {

		@Override
		public float getMinV() {
			return 0.0f;
		}

		@Override
		public float getMinU() {
			return 0.0f;
		}

		@Override
		public float getMaxV() {
			return 1f;
		}

		@Override
		public float getMaxU() {
			return 0.5f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	};

	IIcon iconBloom = new IIcon() {

		@Override
		public float getMinV() {
			return 0.0f;
		}

		@Override
		public float getMinU() {
			return 0.5f;
		}

		@Override
		public float getMaxV() {
			return 1f;
		}

		@Override
		public float getMaxU() {
			return 1f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	};

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f, float[] progress) {
		GL11.glPushMatrix();
		int renderConnection = ((TileEntityMultiblockDummy) tileEntity).getModelConnection();
		ForgeDirection dir = ((TileEntityMultiblockDummy) tileEntity).getForwardDirection();
		int turnFactor = -1;
		if (dir == ForgeDirection.WEST || dir == ForgeDirection.EAST) {
			turnFactor = 1;
		} else {
			GL11.glRotatef(180, 1, 0, 0);
		}

		GL11.glTranslatef(0.0f, 0.0f, 3.0f);

		GL11.glRotatef(((TileEntityWoodenHammer) tileEntity).getRotation() * turnFactor, 1.0f, 0, 0);

		GL11.glTranslatef(0.0f, 0.0f, -3.0f);

		if (dir == ForgeDirection.WEST || dir == ForgeDirection.EAST) {
			GL11.glTranslatef(0f, 0.95f, 0f);

		} else {
			GL11.glTranslatef(0f, -0.95f, 0f);
			GL11.glRotatef(180, 0, 0, 1);
		}
		GL11.glRotatef(180, 1, 0, 0);

		if (((TileEntityMultiblockDummy) tileEntity).getState() == MultiblockState.COMPLETED) {

			bar.renderMesh(icon);

		}

		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glTranslatef(0, -1, 0);
		if (((TileEntityWoodenHammer) tileEntity).getCore() != null && ((TileEntityWoodenHammer) tileEntity).getStackInSlot(0) != null) {
			iron.renderMesh(iconBloom);
		}

		if (((TileEntityWoodenHammer) tileEntity).getCore() != null && ((TileEntityWoodenHammer) tileEntity).getStackInSlot(1) != null) {
			finishedIron.renderMesh(iconBloom);
			if (Math.abs(((TileEntityTripHammer) ((TileEntityWoodenHammer) tileEntity).getCore()).getRotation()) <= 3) {
				tileEntity.getWorldObj().spawnParticle("smoke", tileEntity.xCoord + 0.5D, tileEntity.yCoord, tileEntity.zCoord + 0.5D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("smoke", tileEntity.xCoord + 0.4D, tileEntity.yCoord - 0.1, tileEntity.zCoord + 0.4D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("smoke", tileEntity.xCoord + 0.6D, tileEntity.yCoord - 0.1, tileEntity.zCoord + 0.4D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("smoke", tileEntity.xCoord + 0.4D, tileEntity.yCoord + 0.1, tileEntity.zCoord + 0.6D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("smoke", tileEntity.xCoord + 0.6D, tileEntity.yCoord + 0.1, tileEntity.zCoord + 0.6D, 0.0D, 0.0D, 0.0D);

				tileEntity.getWorldObj().spawnParticle("flame", tileEntity.xCoord + 0.5D, tileEntity.yCoord, tileEntity.zCoord + 0.5D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("flame", tileEntity.xCoord + 0.4D, tileEntity.yCoord - 0.1, tileEntity.zCoord + 0.4D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("flame", tileEntity.xCoord + 0.6D, tileEntity.yCoord - 0.1, tileEntity.zCoord + 0.4D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("flame", tileEntity.xCoord + 0.4D, tileEntity.yCoord + 0.1, tileEntity.zCoord + 0.6D, 0.0D, 0.0D, 0.0D);
				tileEntity.getWorldObj().spawnParticle("flame", tileEntity.xCoord + 0.6D, tileEntity.yCoord + 0.1, tileEntity.zCoord + 0.6D, 0.0D, 0.0D, 0.0D);
			}
		}

		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		// TODO Auto-generated method stub

	}

}
