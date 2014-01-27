package ip.industrialProcessing.subMod.logic.transport.wired.cable;

import ip.industrialProcessing.subMod.logic.client.ModelLogic;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class MDlogicCable extends ModelLogic {

	ModelRenderer Base;
	ModelRenderer Base0;
	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Base4;
	ModelRenderer Base5;

	ModelRenderer connection04;
	ModelRenderer connection05;
	ModelRenderer connection03;
	ModelRenderer connection02;

	ModelRenderer connection14;
	ModelRenderer connection15;
	ModelRenderer connection13;
	ModelRenderer connection12;

	ModelRenderer connection21;
	ModelRenderer connection20;
	ModelRenderer connection25;
	ModelRenderer connection24;

	ModelRenderer connection31;
	ModelRenderer connection30;
	ModelRenderer connection35;
	ModelRenderer connection34;

	ModelRenderer connection41;
	ModelRenderer connection40;
	ModelRenderer connection43;
	ModelRenderer connection42;

	ModelRenderer connection51;
	ModelRenderer connection50;
	ModelRenderer connection53;
	ModelRenderer connection52;

	public MDlogicCable() {
		this.textureWidth = 32;
		this.textureHeight = 32;

		float offsetX = -1.0f;
		float offsetY = -8.0f;
		float offsetZ = -8.0f;
		int x = 2;
		int y = 1;
		int z = 16;
		this.Base0 = new ModelRenderer(this, 0, 0);
		this.Base0.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base0.setRotationPoint(0F, 16F, 0F);
		this.Base0.setTextureSize(64, 64);
		this.Base0.mirror = true;
		this.setRotation(this.Base0, 0F, 0F, 0F);

		offsetX = -1.0f;
		offsetY = 7.0f;
		offsetZ = -1.0f;
		x = 2;
		y = 1;
		z = 2;
		this.Base1 = new ModelRenderer(this, 0, 0);
		this.Base1.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base1.setRotationPoint(0F, 16F, 0F);
		this.Base1.setTextureSize(64, 64);
		this.Base1.mirror = true;
		this.setRotation(this.Base1, 0F, 0F, 0F);

		offsetX = -1.0f;
		offsetY = -1.0f;
		offsetZ = -8.0f;
		x = 2;
		y = 2;
		z = 1;
		this.Base2 = new ModelRenderer(this, 0, 0);
		this.Base2.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base2.setRotationPoint(0F, 16F, 0F);
		this.Base2.setTextureSize(64, 64);
		this.Base2.mirror = true;
		this.setRotation(this.Base2, 0F, 0F, 0F);

		offsetX = -1.0f;
		offsetY = -1.0f;
		offsetZ = 7.0f;
		x = 2;
		y = 2;
		z = 1;
		this.Base3 = new ModelRenderer(this, 0, 0);
		this.Base3.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base3.setRotationPoint(0F, 16F, 0F);
		this.Base3.setTextureSize(64, 64);
		this.Base3.mirror = true;
		this.setRotation(this.Base3, 0F, 0F, 0F);

		offsetX = 7.0f;
		offsetY = -1.0f;
		offsetZ = -1.0f;
		x = 1;
		y = 2;
		z = 2;
		this.Base4 = new ModelRenderer(this, 0, 0);
		this.Base4.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base4.setRotationPoint(0F, 16F, 0F);
		this.Base4.setTextureSize(64, 64);
		this.Base4.mirror = true;
		this.setRotation(this.Base4, 0F, 0F, 0F);

		offsetX = -8.0f;
		offsetY = -1.0f;
		offsetZ = -1.0f;
		x = 1;
		y = 2;
		z = 2;
		this.Base5 = new ModelRenderer(this, 0, 0);
		this.Base5.addBox(offsetX, offsetY, offsetZ, x, y, z);
		this.Base5.setRotationPoint(0F, 16F, 0F);
		this.Base5.setTextureSize(64, 64);
		this.Base5.mirror = true;
		this.setRotation(this.Base5, 0F, 0F, 0F);

		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(-1F, 7F, -8F, 2, 1, 16);
		this.Base.setRotationPoint(0F, 16F, 0F);
		this.Base.setTextureSize(64, 64);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0F, 0F, 0F);

		this.connection14 = new ModelRenderer(this, 0, 0);
		this.connection14.addBox(1.0f, 7.0f, -1.0f, 7, 1, 2);
		this.connection14.setRotationPoint(0F, 16F, 0F);
		this.connection14.setTextureSize(64, 64);
		this.connection14.mirror = true;
		this.setRotation(this.connection14, 0F, 0F, 0F);

		this.connection15 = new ModelRenderer(this, 0, 0);
		this.connection15.addBox(-8.0f, 7.0f, -1.0f, 7, 1, 2);
		this.connection15.setRotationPoint(0F, 16F, 0F);
		this.connection15.setTextureSize(64, 64);
		this.connection15.mirror = true;
		this.setRotation(this.connection15, 0F, 0F, 0F);

		this.connection13 = new ModelRenderer(this, 0, 0);
		this.connection13.addBox(-1.0f, 7.0f, 1.0f, 2, 1, 7);
		this.connection13.setRotationPoint(0F, 16F, 0F);
		this.connection13.setTextureSize(64, 64);
		this.connection13.mirror = true;
		this.setRotation(this.connection13, 0F, 0F, 0F);

		this.connection12 = new ModelRenderer(this, 0, 0);
		this.connection12.addBox(-1.0f, 7.0f, -8.0f, 2, 1, 7);
		this.connection12.setRotationPoint(0F, 16F, 0F);
		this.connection12.setTextureSize(64, 64);
		this.connection12.mirror = true;
		this.setRotation(this.connection12, 0F, 0F, 0F);

		this.connection21 = new ModelRenderer(this, 0, 0);
		this.connection21.addBox(-1.0f, -8.0f, -8.0f, 2, 7, 1);
		this.connection21.setRotationPoint(0F, 16F, 0F);
		this.connection21.setTextureSize(64, 64);
		this.connection21.mirror = true;
		this.setRotation(this.connection21, 0F, 0F, 0F);

		this.connection20 = new ModelRenderer(this, 0, 0);
		this.connection20.addBox(-1.0f, 1.0f, -8.0f, 2, 7, 1);
		this.connection20.setRotationPoint(0F, 16F, 0F);
		this.connection20.setTextureSize(64, 64);
		this.connection20.mirror = true;
		this.setRotation(this.connection20, 0F, 0F, 0F);

		this.connection25 = new ModelRenderer(this, 0, 0);
		this.connection25.addBox(-8.0f, -1.0f, -8.0f, 7, 2, 1);
		this.connection25.setRotationPoint(0F, 16F, 0F);
		this.connection25.setTextureSize(64, 64);
		this.connection25.mirror = true;
		this.setRotation(this.connection25, 0F, 0F, 0F);

		this.connection24 = new ModelRenderer(this, 0, 0);
		this.connection24.addBox(1.0f, -1.0f, -8.0f, 7, 2, 1);
		this.connection24.setRotationPoint(0F, 16F, 0F);
		this.connection24.setTextureSize(64, 64);
		this.connection24.mirror = true;
		this.setRotation(this.connection24, 0F, 0F, 0F);

		this.connection31 = new ModelRenderer(this, 0, 0);
		this.connection31.addBox(-1.0f, -8.0f, 7.0f, 2, 7, 1);
		this.connection31.setRotationPoint(0F, 16F, 0F);
		this.connection31.setTextureSize(64, 64);
		this.connection31.mirror = true;
		this.setRotation(this.connection31, 0F, 0F, 0F);

		this.connection30 = new ModelRenderer(this, 0, 0);
		this.connection30.addBox(-1.0f, 1.0f, 7.0f, 2, 7, 1);
		this.connection30.setRotationPoint(0F, 16F, 0F);
		this.connection30.setTextureSize(64, 64);
		this.connection30.mirror = true;
		this.setRotation(this.connection30, 0F, 0F, 0F);

		this.connection35 = new ModelRenderer(this, 0, 0);
		this.connection35.addBox(-8.0f, -1.0f, 7.0f, 7, 2, 1);
		this.connection35.setRotationPoint(0F, 16F, 0F);
		this.connection35.setTextureSize(64, 64);
		this.connection35.mirror = true;
		this.setRotation(this.connection35, 0F, 0F, 0F);

		this.connection34 = new ModelRenderer(this, 0, 0);
		this.connection34.addBox(1.0f, -1.0f, 7.0f, 7, 2, 1);
		this.connection34.setRotationPoint(0F, 16F, 0F);
		this.connection34.setTextureSize(64, 64);
		this.connection34.mirror = true;
		this.setRotation(this.connection34, 0F, 0F, 0F);

		this.connection41 = new ModelRenderer(this, 0, 0);
		this.connection41.addBox(7.0f, -8.0f, -1.0f, 1, 7, 2);
		this.connection41.setRotationPoint(0F, 16F, 0F);
		this.connection41.setTextureSize(64, 64);
		this.connection41.mirror = true;
		this.setRotation(this.connection41, 0F, 0F, 0F);

		this.connection40 = new ModelRenderer(this, 0, 0);
		this.connection40.addBox(7.0f, 1.0f, -1.0f, 1, 7, 2);
		this.connection40.setRotationPoint(0F, 16F, 0F);
		this.connection40.setTextureSize(64, 64);
		this.connection40.mirror = true;
		this.setRotation(this.connection40, 0F, 0F, 0F);

		this.connection43 = new ModelRenderer(this, 0, 0);
		this.connection43.addBox(7.0f, -1.0f, 1.0f, 1, 2, 7);
		this.connection43.setRotationPoint(0F, 16F, 0F);
		this.connection43.setTextureSize(64, 64);
		this.connection43.mirror = true;
		this.setRotation(this.connection43, 0F, 0F, 0F);

		this.connection42 = new ModelRenderer(this, 0, 0);
		this.connection42.addBox(7.0f, -1.0f, -8.0f, 1, 2, 7);
		this.connection42.setRotationPoint(0F, 16F, 0F);
		this.connection42.setTextureSize(64, 64);
		this.connection42.mirror = true;
		this.setRotation(this.connection42, 0F, 0F, 0F);

		this.connection51 = new ModelRenderer(this, 0, 0);
		this.connection51.addBox(-8.0f, -8.0f, -1.0f, 1, 7, 2);
		this.connection51.setRotationPoint(0F, 16F, 0F);
		this.connection51.setTextureSize(64, 64);
		this.connection51.mirror = true;
		this.setRotation(this.connection51, 0F, 0F, 0F);

		this.connection50 = new ModelRenderer(this, 0, 0);
		this.connection50.addBox(-8.0f, 1.0f, -1.0f, 1, 7, 2);
		this.connection50.setRotationPoint(0F, 16F, 0F);
		this.connection50.setTextureSize(64, 64);
		this.connection50.mirror = true;
		this.setRotation(this.connection50, 0F, 0F, 0F);

		this.connection53 = new ModelRenderer(this, 0, 0);
		this.connection53.addBox(-8.0f, -1.0f, 1.0f, 1, 2, 7);
		this.connection53.setRotationPoint(0F, 16F, 0F);
		this.connection53.setTextureSize(64, 64);
		this.connection53.mirror = true;
		this.setRotation(this.connection53, 0F, 0F, 0F);

		this.connection52 = new ModelRenderer(this, 0, 0);
		this.connection52.addBox(-8.0f, -1.0f, -8.0f, 1, 2, 7);
		this.connection52.setRotationPoint(0F, 16F, 0F);
		this.connection52.setTextureSize(64, 64);
		this.connection52.mirror = true;
		this.setRotation(this.connection52, 0F, 0F, 0F);
	}

	@Override
	public void renderModel(float f, boolean[] side, boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels) {
		for (int i = 0; i < side.length; i++) {
			GL11.glPushMatrix();
			if (side[i] == true) {
				switch (i) {
				case 0:
					this.Base0.render(f);
					break;
				case 1:
					if (connectedSides[4] != null && connectedSides[4][1] || side[4]) {
						this.connection14.render(f);
					}
					if (connectedSides[5] != null && connectedSides[5][1] || side[5]) {

						this.connection15.render(f);
					}
					if (connectedSides[3] != null && connectedSides[3][1] || side[3]) {

						this.connection13.render(f);
					}
					if (connectedSides[2] != null && connectedSides[2][1] || side[2]) {

						this.connection12.render(f);
					}
					this.Base1.render(f);
					break;
				case 5:
					if (connectedSides[1] != null && connectedSides[1][5] || side[0]) {

						this.connection51.render(f);
					}
					if (connectedSides[0] != null && connectedSides[0][5] || side[1]) {

						this.connection50.render(f);
					}
					if (connectedSides[3] != null && connectedSides[3][5] || side[3]) {

						this.connection53.render(f);
					}
					if (connectedSides[2] != null && connectedSides[2][5] || side[2]) {
						this.connection52.render(f);
					}
					this.Base5.render(f);
					break;
				case 4:
					if (connectedSides[1] != null && connectedSides[1][4] || side[0]) {

						this.connection41.render(f);
					}
					if (connectedSides[0] != null && connectedSides[0][4] || side[1]) {

						this.connection40.render(f);
					}
					if (connectedSides[3] != null && connectedSides[3][4] || side[3]) {

						this.connection43.render(f);
					}
					if (connectedSides[2] != null && connectedSides[2][4] || side[2]) {

						this.connection42.render(f);
					}
					this.Base4.render(f);
					break;
				case 2:
					if (connectedSides[1] != null && connectedSides[1][2] || side[0]) {

						this.connection21.render(f);
					}
					if (connectedSides[0] != null && connectedSides[0][2] || side[1]) {

						this.connection20.render(f);
					}
					if (connectedSides[5] != null && connectedSides[5][2] || side[5]) {

						this.connection25.render(f);
					}
					if (connectedSides[4] != null && connectedSides[4][2] || side[4]) {

						this.connection24.render(f);
					}
					this.Base2.render(f);
					break;
				case 3:
					if (connectedSides[1] != null && connectedSides[1][3] || side[0]) {

						this.connection31.render(f);
					}
					if (connectedSides[0] != null && connectedSides[0][3] || side[1]) {

						this.connection30.render(f);
					}
					if (connectedSides[5] != null && connectedSides[5][3] || side[5]) {

						this.connection35.render(f);
					}
					if (connectedSides[4] != null && connectedSides[4][3] || side[4]) {

						this.connection34.render(f);
					}
					this.Base3.render(f);
					break;
				}
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		this.Base.render(f);

	}

}
