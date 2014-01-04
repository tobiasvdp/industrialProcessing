package ip.industrialProcessing.subMod.logic.transport.wired.cable;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.subMod.logic.client.ModelLogic;
import ip.industrialProcessing.subMod.logic.utils.UTBuffer;

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
		textureWidth = 32;
		textureHeight = 32;
		
		float offsetX = -1.0f;
		float offsetY = -8.0f;
		float offsetZ = -8.0f;
		int x = 2;
		int y = 1;
		int z = 16;
		Base0 = new ModelRenderer(this, 0, 0);
		Base0.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base0.setRotationPoint(0F, 16F, 0F);
		Base0.setTextureSize(64, 64);
		Base0.mirror = true;
		setRotation(Base0, 0F, 0F, 0F);
		
		offsetX = -1.0f;
		offsetY = 7.0f;
		offsetZ = -1.0f;
		x = 2;
		y = 1;
		z = 2;
		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base1.setRotationPoint(0F, 16F, 0F);
		Base1.setTextureSize(64, 64);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		
		offsetX = -1.0f;
		offsetY = -1.0f;
		offsetZ = -8.0f;
		x = 2;
		y = 2;
		z = 1;
		Base2 = new ModelRenderer(this, 0, 0);
		Base2.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base2.setRotationPoint(0F, 16F, 0F);
		Base2.setTextureSize(64, 64);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		
		offsetX = -1.0f;
		offsetY = -1.0f;
		offsetZ = 7.0f;
		x = 2;
		y = 2;
		z = 1;
		Base3 = new ModelRenderer(this, 0, 0);
		Base3.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base3.setRotationPoint(0F, 16F, 0F);
		Base3.setTextureSize(64, 64);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		
		offsetX = 7.0f;
		offsetY = -1.0f;
		offsetZ = -1.0f;
		x = 1;
		y = 2;
		z = 2;
		Base4 = new ModelRenderer(this, 0, 0);
		Base4.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base4.setRotationPoint(0F, 16F, 0F);
		Base4.setTextureSize(64, 64);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		
		offsetX = -8.0f;
		offsetY = -1.0f;
		offsetZ = -1.0f;
		x = 1;
		y = 2;
		z = 2;
		Base5 = new ModelRenderer(this, 0, 0);
		Base5.addBox(offsetX, offsetY, offsetZ, x, y, z);
		Base5.setRotationPoint(0F, 16F, 0F);
		Base5.setTextureSize(64, 64);
		Base5.mirror = true;
		setRotation(Base5, 0F, 0F, 0F);
		

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(-1F, 7F, -8F, 2, 1, 16);
		Base.setRotationPoint(0F, 16F, 0F);
		Base.setTextureSize(64, 64);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		
		connection14 = new ModelRenderer(this, 0, 0);
		connection14.addBox(1.0f, 7.0f, -1.0f, 7, 1, 2);
		connection14.setRotationPoint(0F, 16F, 0F);
		connection14.setTextureSize(64, 64);
		connection14.mirror = true;
		setRotation(connection14, 0F, 0F, 0F);
		
		connection15 = new ModelRenderer(this, 0, 0);
		connection15.addBox(-8.0f, 7.0f, -1.0f, 7, 1, 2);
		connection15.setRotationPoint(0F, 16F, 0F);
		connection15.setTextureSize(64, 64);
		connection15.mirror = true;
		setRotation(connection15, 0F, 0F, 0F);
		
		connection13 = new ModelRenderer(this, 0, 0);
		connection13.addBox(-1.0f, 7.0f, 1.0f, 2, 1, 7);
		connection13.setRotationPoint(0F, 16F, 0F);
		connection13.setTextureSize(64, 64);
		connection13.mirror = true;
		setRotation(connection13, 0F, 0F, 0F);
		
		connection12 = new ModelRenderer(this, 0, 0);
		connection12.addBox(-1.0f, 7.0f, -8.0f, 2, 1, 7);
		connection12.setRotationPoint(0F, 16F, 0F);
		connection12.setTextureSize(64, 64);
		connection12.mirror = true;
		setRotation(connection12, 0F, 0F, 0F);
		
		connection21 = new ModelRenderer(this, 0, 0);
		connection21.addBox(-1.0f, -8.0f, -8.0f, 2, 7, 1);
		connection21.setRotationPoint(0F, 16F, 0F);
		connection21.setTextureSize(64, 64);
		connection21.mirror = true;
		setRotation(connection21, 0F, 0F, 0F);
		
		connection20 = new ModelRenderer(this, 0, 0);
		connection20.addBox(-1.0f, 1.0f, -8.0f, 2, 7, 1);
		connection20.setRotationPoint(0F, 16F, 0F);
		connection20.setTextureSize(64, 64);
		connection20.mirror = true;
		setRotation(connection20, 0F, 0F, 0F);
		
		connection25 = new ModelRenderer(this, 0, 0);
		connection25.addBox(-8.0f, -1.0f, -8.0f, 7, 2, 1);
		connection25.setRotationPoint(0F, 16F, 0F);
		connection25.setTextureSize(64, 64);
		connection25.mirror = true;
		setRotation(connection25, 0F, 0F, 0F);
		
		connection24 = new ModelRenderer(this, 0, 0);
		connection24.addBox(1.0f, -1.0f, -8.0f, 7, 2, 1);
		connection24.setRotationPoint(0F, 16F, 0F);
		connection24.setTextureSize(64, 64);
		connection24.mirror = true;
		setRotation(connection24, 0F, 0F, 0F);
		
		connection31 = new ModelRenderer(this, 0, 0);
		connection31.addBox(-1.0f, -8.0f, 7.0f, 2, 7, 1);
		connection31.setRotationPoint(0F, 16F, 0F);
		connection31.setTextureSize(64, 64);
		connection31.mirror = true;
		setRotation(connection31, 0F, 0F, 0F);
		
		connection30 = new ModelRenderer(this, 0, 0);
		connection30.addBox(-1.0f, 1.0f, 7.0f, 2, 7, 1);
		connection30.setRotationPoint(0F, 16F, 0F);
		connection30.setTextureSize(64, 64);
		connection30.mirror = true;
		setRotation(connection30, 0F, 0F, 0F);
		
		connection35 = new ModelRenderer(this, 0, 0);
		connection35.addBox(-8.0f, -1.0f, 7.0f, 7, 2, 1);
		connection35.setRotationPoint(0F, 16F, 0F);
		connection35.setTextureSize(64, 64);
		connection35.mirror = true;
		setRotation(connection35, 0F, 0F, 0F);
		
		connection34 = new ModelRenderer(this, 0, 0);
		connection34.addBox(1.0f, -1.0f, 7.0f, 7, 2, 1);
		connection34.setRotationPoint(0F, 16F, 0F);
		connection34.setTextureSize(64, 64);
		connection34.mirror = true;
		setRotation(connection34, 0F, 0F, 0F);
		
		connection41 = new ModelRenderer(this, 0, 0);
		connection41.addBox(7.0f, -8.0f, -1.0f, 1, 7, 2);
		connection41.setRotationPoint(0F, 16F, 0F);
		connection41.setTextureSize(64, 64);
		connection41.mirror = true;
		setRotation(connection41, 0F, 0F, 0F);
		
		connection40 = new ModelRenderer(this, 0, 0);
		connection40.addBox(7.0f, 1.0f, -1.0f, 1, 7, 2);
		connection40.setRotationPoint(0F, 16F, 0F);
		connection40.setTextureSize(64, 64);
		connection40.mirror = true;
		setRotation(connection40, 0F, 0F, 0F);
		
		connection43 = new ModelRenderer(this, 0, 0);
		connection43.addBox(7.0f, -1.0f, 1.0f, 1, 2, 7);
		connection43.setRotationPoint(0F, 16F, 0F);
		connection43.setTextureSize(64, 64);
		connection43.mirror = true;
		setRotation(connection43, 0F, 0F, 0F);
		
		connection42 = new ModelRenderer(this, 0, 0);
		connection42.addBox(7.0f, -1.0f, -8.0f, 1, 2, 7);
		connection42.setRotationPoint(0F, 16F, 0F);
		connection42.setTextureSize(64, 64);
		connection42.mirror = true;
		setRotation(connection42, 0F, 0F, 0F);
		
		connection51 = new ModelRenderer(this, 0, 0);
		connection51.addBox(-8.0f, -8.0f, -1.0f, 1, 7, 2);
		connection51.setRotationPoint(0F, 16F, 0F);
		connection51.setTextureSize(64, 64);
		connection51.mirror = true;
		setRotation(connection51, 0F, 0F, 0F);
		
		connection50 = new ModelRenderer(this, 0, 0);
		connection50.addBox(-8.0f, 1.0f, -1.0f, 1, 7, 2);
		connection50.setRotationPoint(0F, 16F, 0F);
		connection50.setTextureSize(64, 64);
		connection50.mirror = true;
		setRotation(connection50, 0F, 0F, 0F);
		
		connection53 = new ModelRenderer(this, 0, 0);
		connection53.addBox(-8.0f, -1.0f, 1.0f, 1, 2, 7);
		connection53.setRotationPoint(0F, 16F, 0F);
		connection53.setTextureSize(64, 64);
		connection53.mirror = true;
		setRotation(connection53, 0F, 0F, 0F);
		
		connection52 = new ModelRenderer(this, 0, 0);
		connection52.addBox(-8.0f, -1.0f, -8.0f, 1, 2, 7);
		connection52.setRotationPoint(0F, 16F, 0F);
		connection52.setTextureSize(64, 64);
		connection52.mirror = true;
		setRotation(connection52, 0F, 0F, 0F);
	}

	@Override
	public void renderModel(float f, boolean[] side, boolean[][] connectedSides, boolean[][] notificationLights, UTBuffer[] levels) {
		for (int i = 0; i < side.length; i++) {
			GL11.glPushMatrix();
			if (side[i] == true) {
				switch (i) {
				case 0:
					Base0.render(f);
					break;
				case 1:
					if ((connectedSides[4] != null && connectedSides[4][1]) || side[4]) {
						connection14.render(f);
					}
					if ((connectedSides[5] != null && connectedSides[5][1]) || side[5]) {

						connection15.render(f);
					}
					if ((connectedSides[3] != null && connectedSides[3][1]) || side[3]) {

						connection13.render(f);
					}
					if ((connectedSides[2] != null && connectedSides[2][1]) || side[2]) {

						connection12.render(f);
					}
					Base1.render(f);
					break;
				case 5:
					if ((connectedSides[1] != null && connectedSides[1][5]) || side[0]) {

						connection51.render(f);
					}
					if ((connectedSides[0] != null && connectedSides[0][5])  || side[1]) {

						connection50.render(f);
					}
					if ((connectedSides[3] != null && connectedSides[3][5])  || side[3]) {

						connection53.render(f);
					}
					if ((connectedSides[2] != null && connectedSides[2][5])  || side[2]) {
						connection52.render(f);
					}
					Base5.render(f);
					break;
				case 4:
					if ((connectedSides[1] != null && connectedSides[1][4])  || side[0]) {

						connection41.render(f);
					}
					if ((connectedSides[0] != null && connectedSides[0][4])  || side[1]) {

						connection40.render(f);
					}
					if ((connectedSides[3] != null && connectedSides[3][4])  || side[3]) {

						connection43.render(f);
					}
					if ((connectedSides[2] != null && connectedSides[2][4])  || side[2]) {

						connection42.render(f);
					}
					Base4.render(f);
					break;
				case 2:
					if ((connectedSides[1] != null && connectedSides[1][2])  || side[0]) {

						connection21.render(f);
					}
					if ((connectedSides[0] != null && connectedSides[0][2])  || side[1]) {

						connection20.render(f);
					}
					if ((connectedSides[5] != null && connectedSides[5][2])  || side[5]) {

						connection25.render(f);
					}
					if ((connectedSides[4] != null && connectedSides[4][2])  || side[4]) {

						connection24.render(f);
					}
					Base2.render(f);
					break;
				case 3:
					if ((connectedSides[1] != null && connectedSides[1][3])  || side[0]) {

						connection31.render(f);
					}
					if ((connectedSides[0] != null && connectedSides[0][3])  || side[1]) {

						connection30.render(f);
					}
					if ((connectedSides[5] != null && connectedSides[5][3])  || side[5]) {

						connection35.render(f);
					}
					if ((connectedSides[4] != null && connectedSides[4][3])  || side[4]) {

						connection34.render(f);
					}
					Base3.render(f);
					break;
				}
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		Base.render(f);

	}

}
