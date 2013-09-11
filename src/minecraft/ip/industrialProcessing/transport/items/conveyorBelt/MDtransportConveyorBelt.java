package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class MDtransportConveyorBelt extends ModelConnected {
	// fields
	ModelRenderer Front;
	ModelRenderer Back;
	ModelRenderer Left;
	ModelRenderer Right;
	ModelRenderer FrontBack;
	ModelRenderer LeftRight;
	ModelRenderer RightFront1;
	ModelRenderer RightFront2;
	ModelRenderer RightFront3;
	ModelRenderer RightFront4;
	ModelRenderer RightFront5;
	ModelRenderer RightBack1;
	ModelRenderer RightBack2;
	ModelRenderer RightBack3;
	ModelRenderer RightBack4;
	ModelRenderer RightBack5;
	ModelRenderer LeftBack1;
	ModelRenderer LeftBack2;
	ModelRenderer LeftBack3;
	ModelRenderer LeftBack4;
	ModelRenderer LeftBack5;
	ModelRenderer FrontLeft1;
	ModelRenderer FrontLeft2;
	ModelRenderer FrontLeft3;
	ModelRenderer FrontLeft4;
	ModelRenderer FrontLeft5;

	private Entity entity;

	public MDtransportConveyorBelt() {
		textureWidth = 64;
		textureHeight = 64;

		Front = new ModelRenderer(this, 0, 0);
		Front.addBox(-2F, 7F, -8F, 4, 1, 4);
		Front.setRotationPoint(0F, 16F, 0F);
		Front.setTextureSize(64, 32);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 0, 0);
		Back.addBox(-2F, 7F, 4F, 4, 1, 4);
		Back.setRotationPoint(0F, 16F, 0F);
		Back.setTextureSize(64, 32);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		Left = new ModelRenderer(this, 0, 0);
		Left.addBox(4F, 7F, -2F, 4, 1, 4);
		Left.setRotationPoint(0F, 16F, 0F);
		Left.setTextureSize(64, 32);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 0, 0);
		Right.addBox(-8F, 7F, -2F, 4, 1, 4);
		Right.setRotationPoint(0F, 16F, 0F);
		Right.setTextureSize(64, 32);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
		FrontBack = new ModelRenderer(this, 0, 0);
		FrontBack.addBox(-2F, 7F, -4F, 4, 1, 8);
		FrontBack.setRotationPoint(0F, 16F, 0F);
		FrontBack.setTextureSize(64, 32);
		FrontBack.mirror = true;
		setRotation(FrontBack, 0F, 0F, 0F);
		LeftRight = new ModelRenderer(this, 0, 0);
		LeftRight.addBox(-4F, 7F, -2F, 8, 1, 4);
		LeftRight.setRotationPoint(0F, 16F, 0F);
		LeftRight.setTextureSize(64, 32);
		LeftRight.mirror = true;
		setRotation(LeftRight, 0F, 0F, 0F);
		RightFront1 = new ModelRenderer(this, 0, 0);
		RightFront1.addBox(-1F, -1F, 1F, 2, 1, 4);
		RightFront1.setRotationPoint(-3F, 24F, -3F);
		RightFront1.setTextureSize(64, 32);
		RightFront1.mirror = true;
		setRotation(RightFront1, 0F, 0F, 0F);
		RightFront2 = new ModelRenderer(this, 0, 0);
		RightFront2.addBox(-1F, -1F, 1F, 2, 1, 4);
		RightFront2.setRotationPoint(-3F, 24F, -3F);
		RightFront2.setTextureSize(64, 32);
		RightFront2.mirror = true;
		setRotation(RightFront2, 0F, 1.570796F, 0F);
		RightFront3 = new ModelRenderer(this, 0, 0);
		RightFront3.addBox(-1F, -1F, 1F, 2, 1, 4);
		RightFront3.setRotationPoint(-3F, 24F, -3F);
		RightFront3.setTextureSize(64, 32);
		RightFront3.mirror = true;
		setRotation(RightFront3, 0F, 0.3926991F, 0F);
		RightFront4 = new ModelRenderer(this, 0, 0);
		RightFront4.addBox(-1F, -1F, 1F, 2, 1, 4);
		RightFront4.setRotationPoint(-3F, 24F, -3F);
		RightFront4.setTextureSize(64, 32);
		RightFront4.mirror = true;
		setRotation(RightFront4, 0F, 0.7853982F, 0F);
		RightFront5 = new ModelRenderer(this, 0, 0);
		RightFront5.addBox(-1F, -1F, 1F, 2, 1, 4);
		RightFront5.setRotationPoint(-3F, 24F, -3F);
		RightFront5.setTextureSize(64, 32);
		RightFront5.mirror = true;
		setRotation(RightFront5, 0F, 1.178097F, 0F);
		RightBack1 = new ModelRenderer(this, 0, 0);
		RightBack1.addBox(-1F, -1F, -5F, 2, 1, 4);
		RightBack1.setRotationPoint(-3F, 24F, 3F);
		RightBack1.setTextureSize(64, 32);
		RightBack1.mirror = true;
		setRotation(RightBack1, 0F, 0F, 0F);
		RightBack2 = new ModelRenderer(this, 0, 0);
		RightBack2.addBox(-1F, -1F, -5F, 2, 1, 4);
		RightBack2.setRotationPoint(-3F, 24F, 3F);
		RightBack2.setTextureSize(64, 32);
		RightBack2.mirror = true;
		setRotation(RightBack2, 0F, -1.570796F, 0F);
		RightBack3 = new ModelRenderer(this, 0, 0);
		RightBack3.addBox(-1F, -1F, -5F, 2, 1, 4);
		RightBack3.setRotationPoint(-3F, 24F, 3F);
		RightBack3.setTextureSize(64, 32);
		RightBack3.mirror = true;
		setRotation(RightBack3, 0F, -0.3926991F, 0F);
		RightBack4 = new ModelRenderer(this, 0, 0);
		RightBack4.addBox(-1F, -1F, -5F, 2, 1, 4);
		RightBack4.setRotationPoint(-3F, 24F, 3F);
		RightBack4.setTextureSize(64, 32);
		RightBack4.mirror = true;
		setRotation(RightBack4, 0F, -0.7853982F, 0F);
		RightBack5 = new ModelRenderer(this, 0, 0);
		RightBack5.addBox(-1F, -1F, -5F, 2, 1, 4);
		RightBack5.setRotationPoint(-3F, 24F, 3F);
		RightBack5.setTextureSize(64, 32);
		RightBack5.mirror = true;
		setRotation(RightBack5, 0F, -1.178097F, 0F);
		LeftBack1 = new ModelRenderer(this, 0, 0);
		LeftBack1.addBox(-1F, -1F, -5F, 2, 1, 4);
		LeftBack1.setRotationPoint(3F, 24F, 3F);
		LeftBack1.setTextureSize(64, 32);
		LeftBack1.mirror = true;
		setRotation(LeftBack1, 0F, 0F, 0F);
		LeftBack2 = new ModelRenderer(this, 0, 0);
		LeftBack2.addBox(-1F, -1F, -5F, 2, 1, 4);
		LeftBack2.setRotationPoint(3F, 24F, 3F);
		LeftBack2.setTextureSize(64, 32);
		LeftBack2.mirror = true;
		setRotation(LeftBack2, 0F, 1.570796F, 0F);
		LeftBack3 = new ModelRenderer(this, 0, 0);
		LeftBack3.addBox(-1F, -1F, -5F, 2, 1, 4);
		LeftBack3.setRotationPoint(3F, 24F, 3F);
		LeftBack3.setTextureSize(64, 32);
		LeftBack3.mirror = true;
		setRotation(LeftBack3, 0F, 0.3926991F, 0F);
		LeftBack4 = new ModelRenderer(this, 0, 0);
		LeftBack4.addBox(-1F, -1F, -5F, 2, 1, 4);
		LeftBack4.setRotationPoint(3F, 24F, 3F);
		LeftBack4.setTextureSize(64, 32);
		LeftBack4.mirror = true;
		setRotation(LeftBack4, 0F, 0.7853982F, 0F);
		LeftBack5 = new ModelRenderer(this, 0, 0);
		LeftBack5.addBox(-1F, -1F, -5F, 2, 1, 4);
		LeftBack5.setRotationPoint(3F, 24F, 3F);
		LeftBack5.setTextureSize(64, 32);
		LeftBack5.mirror = true;
		setRotation(LeftBack5, 0F, 1.178097F, 0F);
		FrontLeft1 = new ModelRenderer(this, 0, 0);
		FrontLeft1.addBox(-1F, -1F, 1F, 2, 1, 4);
		FrontLeft1.setRotationPoint(3F, 24F, -3F);
		FrontLeft1.setTextureSize(64, 32);
		FrontLeft1.mirror = true;
		setRotation(FrontLeft1, 0F, 0F, 0F);
		FrontLeft2 = new ModelRenderer(this, 0, 0);
		FrontLeft2.addBox(-1F, -1F, 1F, 2, 1, 4);
		FrontLeft2.setRotationPoint(3F, 24F, -3F);
		FrontLeft2.setTextureSize(64, 32);
		FrontLeft2.mirror = true;
		setRotation(FrontLeft2, 0F, -1.570796F, 0F);
		FrontLeft3 = new ModelRenderer(this, 0, 0);
		FrontLeft3.addBox(-1F, -1F, 1F, 2, 1, 4);
		FrontLeft3.setRotationPoint(3F, 24F, -3F);
		FrontLeft3.setTextureSize(64, 32);
		FrontLeft3.mirror = true;
		setRotation(FrontLeft3, 0F, -0.3926991F, 0F);
		FrontLeft4 = new ModelRenderer(this, 0, 0);
		FrontLeft4.addBox(-1F, -1F, 1F, 2, 1, 4);
		FrontLeft4.setRotationPoint(3F, 24F, -3F);
		FrontLeft4.setTextureSize(64, 32);
		FrontLeft4.mirror = true;
		setRotation(FrontLeft4, 0F, -0.7853982F, 0F);
		FrontLeft5 = new ModelRenderer(this, 0, 0);
		FrontLeft5.addBox(-1F, -1F, 1F, 2, 1, 4);
		FrontLeft5.setRotationPoint(3F, 24F, -3F);
		FrontLeft5.setTextureSize(64, 32);
		FrontLeft5.mirror = true;
		setRotation(FrontLeft5, 0F, -1.178097F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Front.render(f5);
		Back.render(f5);
		Left.render(f5);
		Right.render(f5);
		FrontBack.render(f5);
		LeftRight.render(f5);
		RightFront1.render(f5);
		RightFront2.render(f5);
		RightFront3.render(f5);
		RightFront4.render(f5);
		RightFront5.render(f5);
		RightBack1.render(f5);
		RightBack2.render(f5);
		RightBack3.render(f5);
		RightBack4.render(f5);
		RightBack5.render(f5);
		LeftBack1.render(f5);
		LeftBack2.render(f5);
		LeftBack3.render(f5);
		LeftBack4.render(f5);
		LeftBack5.render(f5);
		FrontLeft1.render(f5);
		FrontLeft2.render(f5);
		FrontLeft3.render(f5);
		FrontLeft4.render(f5);
		FrontLeft5.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModelConnected(TileEntity tl, float f5, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {
		if (south == ConnectionState.CONNECTED) {
			Back.render(f5);
		}
		if (north == ConnectionState.CONNECTED) {
			Front.render(f5);
		}
		if (west == ConnectionState.CONNECTED) {
			Left.render(f5);
		}
		if (east == ConnectionState.CONNECTED) {
			Right.render(f5);
		}
		if (north == ConnectionState.CONNECTED && south == ConnectionState.CONNECTED) {
			FrontBack.render(f5);
		}
		if (east == ConnectionState.CONNECTED && west == ConnectionState.CONNECTED) {
			LeftRight.render(f5);
		}
		if (east == ConnectionState.CONNECTED && north == ConnectionState.CONNECTED) {
			RightFront1.render(f5);
			RightFront2.render(f5);
			RightFront3.render(f5);
			RightFront4.render(f5);
			RightFront5.render(f5);
		}
		if (east == ConnectionState.CONNECTED && south == ConnectionState.CONNECTED) {
			RightBack1.render(f5);
			RightBack2.render(f5);
			RightBack3.render(f5);
			RightBack4.render(f5);
			RightBack5.render(f5);
		}
		if (west == ConnectionState.CONNECTED && south == ConnectionState.CONNECTED) {
			LeftBack1.render(f5);
			LeftBack2.render(f5);
			LeftBack3.render(f5);
			LeftBack4.render(f5);
			LeftBack5.render(f5);
		}
		if (west == ConnectionState.CONNECTED && north == ConnectionState.CONNECTED) {
			FrontLeft1.render(f5);
			FrontLeft2.render(f5);
			FrontLeft3.render(f5);
			FrontLeft4.render(f5);
			FrontLeft5.render(f5);
		}
		if (east == ConnectionState.DISCONNECTED && north == ConnectionState.DISCONNECTED && south == ConnectionState.DISCONNECTED && west == ConnectionState.DISCONNECTED) {
			Back.render(f5);
			Front.render(f5);
			FrontBack.render(f5);
		}
	}

	@Override
	public void renderModel(float f5) {
		Front.render(f5);
		Left.render(f5);
		FrontLeft1.render(f5);
		FrontLeft2.render(f5);
		FrontLeft3.render(f5);
		FrontLeft4.render(f5);
		FrontLeft5.render(f5);
	}

}
