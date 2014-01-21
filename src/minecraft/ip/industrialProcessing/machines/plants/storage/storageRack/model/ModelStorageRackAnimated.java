package ip.industrialProcessing.machines.plants.storage.storageRack.model;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.machines.diskFilter.model.Cylinder;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelStorageRackAnimated extends ModelAnimatedMachine {
	// fields

	Box001 box1 = new Box001();
	Box002 box2 = new Box002();
	Box003 box3 = new Box003();
	Box004 box4 = new Box004();
	Box005 box5 = new Box005();
	Box006 box6 = new Box006();

	public ModelStorageRackAnimated() {
	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progressAr) {
		float progress = 0;
		if (progressAr != null && progressAr.length > 0)
			progress = progressAr[0];

		Vector3f position = new Vector3f(0, 0, 0);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 1, 0);
		Icon icon = new Icon() {

			@Override
			public int getOriginY() {
				return 0;
			}

			@Override
			public int getOriginX() {
				return 0;
			}

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
				return 1;
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
		};

		int count = Math.round(progressAr[0]);
		

		switch (count){
		case 6:
			box1.renderMesh(icon);
		case 5:
			box2.renderMesh(icon);
		case 4:
			box3.renderMesh(icon);
		case 3:
			box4.renderMesh(icon);
		case 2:
			box5.renderMesh(icon);
		case 1:
			box6.renderMesh(icon);
		case 0:
		}
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(tileEntity, f, null);
	}

}
