package ip.industrialProcessing.logic.transport.wired.cable;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import ip.industrialProcessing.client.render.ModelLogic;

public class MDlogicCable extends ModelLogic {

	ModelRenderer Base;

	public MDlogicCable() {
		textureWidth = 32;
		textureHeight = 32;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(-1F, 7F, -8F, 2, 1, 16);
		Base.setRotationPoint(0F, 16F, 0F);
		Base.setTextureSize(64, 64);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
	}

	@Override
	public void renderModel(float f, boolean[] side, boolean[][] connectedSides, boolean[][] notificationLights) {
		for (int i = 0; i < side.length; i++) {
			GL11.glPushMatrix();
			float offsetX = 0;
			float offsetY = 0;
			float offsetZ = 0;
			int x = 0;
			int y = 0;
			int z = 0;
			if (side[i] == true) {
				switch (i) {
				case 0:
					offsetX = -1.0f;
					offsetY = -8.0f;
					offsetZ = -8.0f;
					x = 2;
					y = 1;
					z = 16;
					break;
				case 1:
					if (connectedSides[2] != null || side[3]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(1.0f, 7.0f, -1.0f, 7, 1, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[3] != null || side[2]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-8.0f, 7.0f, -1.0f, 7, 1, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[4] != null || side[5]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-1.0f, 7.0f, 1.0f, 2, 1, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[5] != null || side[4]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-1.0f, 7.0f, -8.0f, 2, 1, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					offsetX = -1.0f;
					offsetY = 7.0f;
					offsetZ = -1.0f;
					x = 2;
					y = 1;
					z = 2;
					break;
				case 2:
					if (connectedSides[1] != null || side[0]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-8.0f, -8.0f, -1.0f, 1, 7, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[0] != null || side[1]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-8.0f, 1.0f, -1.0f, 1, 7, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[5] != null || side[4]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-8.0f, -1.0f, 1.0f, 1, 2, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[4] != null || side[5]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(-8.0f, -1.0f, -8.0f, 1, 2, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					offsetX = -8.0f;
					offsetY = -1.0f;
					offsetZ = -1.0f;
					x = 1;
					y = 2;
					z = 2;
					break;
				case 3:
					if (connectedSides[0] != null || side[0]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(7.0f, -8.0f, -1.0f, 1, 7, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[1] != null || side[1]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(7.0f, 1.0f, -1.0f, 1, 7, 2);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[4] != null || side[5]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(7.0f, -1.0f, 1.0f, 1, 2, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					if (connectedSides[5] != null || side[4]) {
						ModelRenderer connection = new ModelRenderer(this, 0, 0);
						connection.addBox(7.0f, -1.0f, -8.0f, 1, 2, 7);
						connection.setRotationPoint(0F, 16F, 0F);
						connection.setTextureSize(64, 64);
						connection.mirror = true;
						setRotation(connection, 0F, 0F, 0F);
						connection.render(f);
					}
					offsetX = 7.0f;
					offsetY = -1.0f;
					offsetZ = -1.0f;
					x = 1;
					y = 2;
					z = 2;
					break;
				case 4:
					offsetX = -1.0f;
					offsetY = -1.0f;
					offsetZ = -8.0f;
					x = 2;
					y = 2;
					z = 1;
					break;
				case 5:
					offsetX = -1.0f;
					offsetY = -1.0f;
					offsetZ = 7.0f;
					x = 2;
					y = 2;
					z = 1;
					break;
				}
				ModelRenderer Base1 = new ModelRenderer(this, 0, 0);
				Base1.addBox(offsetX, offsetY, offsetZ, x, y, z);
				Base1.setRotationPoint(0F, 16F, 0F);
				Base1.setTextureSize(64, 64);
				Base1.mirror = true;
				setRotation(Base1, 0F, 0F, 0F);
				Base1.render(f);
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderModel(float f) {
		Base.render(f);

	}

}
