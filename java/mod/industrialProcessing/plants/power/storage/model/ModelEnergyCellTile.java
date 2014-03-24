package mod.industrialProcessing.plants.power.storage.model;

import javax.swing.Icon;

import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;

public class ModelEnergyCellTile extends ModelAnimatedMachine {

	// fields

	private Battery battery;
	private BatteryBoxProgress progressA;
	private BatteryBoxProgress progressB;

	public ModelEnergyCellTile() {
		textureWidth = 64;
		textureHeight = 32;

		this.battery = new Battery();
		this.progressA = new BatteryBoxProgress();
		this.progressB = new BatteryBoxProgress();
	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {

		IIcon batteryIcon = getIcon(0);
		IIcon progressIconA = getIcon(1);
		IIcon progressIconB = getIcon(2);

		int count = 9;
		if (progressAr != null && progressAr.length > 1) {
			count = Math.round(progressAr[1] * 9);
		}

		float size = 3 / 16f;
		for (int i = 0; i < count; i++) {
			int x = i / 3 - 1;
			int z = i % 3 - 1;
			GL11.glPushMatrix();
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glTranslatef(x * size, -1, z * size);
			this.battery.renderMesh(batteryIcon);
			GL11.glPopMatrix();
		}

		float progress = (float) Math.sin(System.nanoTime() / 100000f) / 2 + 0.5f;
		if (progressAr != null && progressAr.length > 0) {
			progress = 1 - progressAr[0];
		}
		GL11.glPushMatrix();

		GL11.glTranslatef(0, 1, 0);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, ((progress * 2 - 1) * 2 / 16f), 0);
		GL11.glScalef(1, progress, 1);
		this.progressB.renderMesh(progressIconA);
		GL11.glPopMatrix();

		GL11.glTranslatef(0, progress * (6 / 16f), 0);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, (((1 - progress) * 2 - 1) * 2 / 16f), 0);
		GL11.glScalef(1, 1 - progress, 1);
		this.progressA.renderMesh(progressIconB);
		GL11.glPopMatrix();

		GL11.glPopMatrix();

	}

	private IIcon getIcon(int i) {
		switch (i) {
		case 0:
			return new IIcon() {

				@Override
				public float getMinV() {
					return 0;
				}

				@Override
				public float getMinU() {
					return 0;
				}

				@Override
				public float getMaxV() {
					return 1;
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
					return (float) d0 / 2;
				}

				@Override
				public String getIconName() {
					return null;
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
		case 1:
			return new IIcon() {

				@Override
				public float getMinV() {
					return 0;
				}

				@Override
				public float getMinU() {
					return 0.5f;
				}

				@Override
				public float getMaxV() {
					return 1;
				}

				@Override
				public float getMaxU() {
					return 0.75f;
				}

				@Override
				public float getInterpolatedV(double d0) {
					return (float) d0;
				}

				@Override
				public float getInterpolatedU(double d0) {
					return (float) d0 / 4 + 0.5f;
				}

				@Override
				public String getIconName() {
					return null;
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
		case 2:
		default:
			return new IIcon() {

				@Override
				public float getMinV() {
					return 0;
				}

				@Override
				public float getMinU() {
					return 0.75f;
				}

				@Override
				public float getMaxV() {
					return 1;
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
					return (float) d0 / 4 + 0.75f;
				}

				@Override
				public String getIconName() {
					return null;
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

		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(null, f, new float[] { 1f });
	}

}
