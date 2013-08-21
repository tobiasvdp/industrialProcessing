package ip.industrialProcessing.multiblock.block.frame;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ModelMultiblock;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelMultiblockFrame extends ModelMultiblock {

	net.minecraft.entity.Entity entity;

	ModelRenderer base;
	ModelRenderer Front;
	ModelRenderer Back;
	ModelRenderer Top;
	ModelRenderer Bottom;
	ModelRenderer Left;
	ModelRenderer Right;
	ModelRenderer FrontLeft;
	ModelRenderer BackLeft;
	ModelRenderer FrontRight;
	ModelRenderer BackRight;
	ModelRenderer FrontTop;
	ModelRenderer FrontBottom;
	ModelRenderer BackTop;
	ModelRenderer BackBottom;
	ModelRenderer LeftTop;
	ModelRenderer LeftBottom;
	ModelRenderer RightTop;
	ModelRenderer RightBottom;
	ModelRenderer FrontTopRight;
	ModelRenderer FrontTopLeft;
	ModelRenderer FrontBottomRight;
	ModelRenderer FrontBottomLeft;
	ModelRenderer BackTopLeft;
	ModelRenderer BackTopRight;
	ModelRenderer BackBottomLeft;
	ModelRenderer BackBottomRight;

	public ModelMultiblockFrame() {
		textureWidth = 64;
		textureHeight = 64;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 14, 14, 14);
		base.setRotationPoint(-7F, 9F, -7F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		Front = new ModelRenderer(this, 0, 0);
		Front.addBox(0F, 0F, 0F, 14, 14, 1);
		Front.setRotationPoint(-7F, 9F, -8F);
		Front.setTextureSize(64, 64);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 0, 0);
		Back.addBox(0F, 0F, 0F, 14, 14, 1);
		Back.setRotationPoint(-7F, 9F, 7F);
		Back.setTextureSize(64, 64);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		Top = new ModelRenderer(this, 0, 0);
		Top.addBox(0F, 0F, 0F, 14, 1, 14);
		Top.setRotationPoint(-7F, 8F, -7F);
		Top.setTextureSize(64, 64);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		Bottom = new ModelRenderer(this, 0, 0);
		Bottom.addBox(0F, 0F, 0F, 14, 1, 14);
		Bottom.setRotationPoint(-7F, 23F, -7F);
		Bottom.setTextureSize(64, 64);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		Left = new ModelRenderer(this, 0, 0);
		Left.addBox(0F, 0F, 0F, 1, 14, 14);
		Left.setRotationPoint(7F, 9F, -7F);
		Left.setTextureSize(64, 64);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 0, 0);
		Right.addBox(0F, 0F, 0F, 1, 14, 14);
		Right.setRotationPoint(-8F, 9F, -7F);
		Right.setTextureSize(64, 64);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
		FrontLeft = new ModelRenderer(this, 0, 0);
		FrontLeft.addBox(0F, 0F, 0F, 1, 14, 1);
		FrontLeft.setRotationPoint(7F, 9F, -8F);
		FrontLeft.setTextureSize(64, 64);
		FrontLeft.mirror = true;
		setRotation(FrontLeft, 0F, 0F, 0F);
		BackLeft = new ModelRenderer(this, 0, 0);
		BackLeft.addBox(0F, 0F, 0F, 1, 14, 1);
		BackLeft.setRotationPoint(7F, 9F, 7F);
		BackLeft.setTextureSize(64, 64);
		BackLeft.mirror = true;
		setRotation(BackLeft, 0F, 0F, 0F);
		FrontRight = new ModelRenderer(this, 0, 0);
		FrontRight.addBox(0F, 0F, 0F, 1, 14, 1);
		FrontRight.setRotationPoint(-8F, 9F, -8F);
		FrontRight.setTextureSize(64, 64);
		FrontRight.mirror = true;
		setRotation(FrontRight, 0F, 0F, 0F);
		BackRight = new ModelRenderer(this, 0, 0);
		BackRight.addBox(0F, 0F, 0F, 1, 14, 1);
		BackRight.setRotationPoint(-8F, 9F, 7F);
		BackRight.setTextureSize(64, 64);
		BackRight.mirror = true;
		setRotation(BackRight, 0F, 0F, 0F);
		FrontTop = new ModelRenderer(this, 0, 0);
		FrontTop.addBox(0F, 0F, 0F, 14, 1, 1);
		FrontTop.setRotationPoint(-7F, 8F, -8F);
		FrontTop.setTextureSize(64, 64);
		FrontTop.mirror = true;
		setRotation(FrontTop, 0F, 0F, 0F);
		FrontBottom = new ModelRenderer(this, 0, 0);
		FrontBottom.addBox(0F, 0F, 0F, 14, 1, 1);
		FrontBottom.setRotationPoint(-7F, 23F, -8F);
		FrontBottom.setTextureSize(64, 64);
		FrontBottom.mirror = true;
		setRotation(FrontBottom, 0F, 0F, 0F);
		BackTop = new ModelRenderer(this, 0, 0);
		BackTop.addBox(0F, 0F, 0F, 14, 1, 1);
		BackTop.setRotationPoint(-7F, 8F, 7F);
		BackTop.setTextureSize(64, 64);
		BackTop.mirror = true;
		setRotation(BackTop, 0F, 0F, 0F);
		BackBottom = new ModelRenderer(this, 0, 0);
		BackBottom.addBox(0F, 0F, 0F, 14, 1, 1);
		BackBottom.setRotationPoint(-7F, 23F, 7F);
		BackBottom.setTextureSize(64, 64);
		BackBottom.mirror = true;
		setRotation(BackBottom, 0F, 0F, 0F);
		LeftTop = new ModelRenderer(this, 0, 0);
		LeftTop.addBox(0F, 0F, 0F, 1, 1, 14);
		LeftTop.setRotationPoint(7F, 8F, -7F);
		LeftTop.setTextureSize(64, 64);
		LeftTop.mirror = true;
		setRotation(LeftTop, 0F, 0F, 0F);
		LeftBottom = new ModelRenderer(this, 0, 0);
		LeftBottom.addBox(0F, 0F, 0F, 1, 1, 14);
		LeftBottom.setRotationPoint(7F, 23F, -7F);
		LeftBottom.setTextureSize(64, 64);
		LeftBottom.mirror = true;
		setRotation(LeftBottom, 0F, 0F, 0F);
		RightTop = new ModelRenderer(this, 0, 0);
		RightTop.addBox(0F, 0F, 0F, 1, 1, 14);
		RightTop.setRotationPoint(-8F, 8F, -7F);
		RightTop.setTextureSize(64, 64);
		RightTop.mirror = true;
		setRotation(RightTop, 0F, 0F, 0F);
		RightBottom = new ModelRenderer(this, 0, 0);
		RightBottom.addBox(0F, 0F, 0F, 1, 1, 14);
		RightBottom.setRotationPoint(-8F, 23F, -7F);
		RightBottom.setTextureSize(64, 64);
		RightBottom.mirror = true;
		setRotation(RightBottom, 0F, 0F, 0F);
		FrontTopRight = new ModelRenderer(this, 0, 0);
		FrontTopRight.addBox(0F, 0F, 0F, 1, 1, 1);
		FrontTopRight.setRotationPoint(-8F, 8F, -8F);
		FrontTopRight.setTextureSize(64, 64);
		FrontTopRight.mirror = true;
		setRotation(FrontTopRight, 0F, 0F, 0F);
		FrontTopLeft = new ModelRenderer(this, 0, 0);
		FrontTopLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		FrontTopLeft.setRotationPoint(7F, 8F, -8F);
		FrontTopLeft.setTextureSize(64, 64);
		FrontTopLeft.mirror = true;
		setRotation(FrontTopLeft, 0F, 0F, 0F);
		FrontBottomRight = new ModelRenderer(this, 0, 0);
		FrontBottomRight.addBox(0F, 0F, 0F, 1, 1, 1);
		FrontBottomRight.setRotationPoint(-8F, 23F, -8F);
		FrontBottomRight.setTextureSize(64, 64);
		FrontBottomRight.mirror = true;
		setRotation(FrontBottomRight, 0F, 0F, 0F);
		FrontBottomLeft = new ModelRenderer(this, 0, 0);
		FrontBottomLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		FrontBottomLeft.setRotationPoint(7F, 23F, -8F);
		FrontBottomLeft.setTextureSize(64, 64);
		FrontBottomLeft.mirror = true;
		setRotation(FrontBottomLeft, 0F, 0F, 0F);
		BackTopLeft = new ModelRenderer(this, 0, 0);
		BackTopLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		BackTopLeft.setRotationPoint(7F, 8F, 7F);
		BackTopLeft.setTextureSize(64, 64);
		BackTopLeft.mirror = true;
		setRotation(BackTopLeft, 0F, 0F, 0F);
		BackTopRight = new ModelRenderer(this, 0, 0);
		BackTopRight.addBox(0F, 0F, 0F, 1, 1, 1);
		BackTopRight.setRotationPoint(-8F, 8F, 7F);
		BackTopRight.setTextureSize(64, 64);
		BackTopRight.mirror = true;
		setRotation(BackTopRight, 0F, 0F, 0F);
		BackBottomLeft = new ModelRenderer(this, 0, 0);
		BackBottomLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		BackBottomLeft.setRotationPoint(7F, 23F, 7F);
		BackBottomLeft.setTextureSize(64, 64);
		BackBottomLeft.mirror = true;
		setRotation(BackBottomLeft, 0F, 0F, 0F);
		BackBottomRight = new ModelRenderer(this, 0, 0);
		BackBottomRight.addBox(0F, 0F, 0F, 1, 1, 1);
		BackBottomRight.setRotationPoint(-8F, 23F, 7F);
		BackBottomRight.setTextureSize(64, 64);
		BackBottomRight.mirror = true;
		setRotation(BackBottomRight, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		base.render(f5);
		Front.render(f5);
		Back.render(f5);
		Top.render(f5);
		Bottom.render(f5);
		Left.render(f5);
		Right.render(f5);
		FrontLeft.render(f5);
		BackLeft.render(f5);
		FrontRight.render(f5);
		BackRight.render(f5);
		FrontTop.render(f5);
		FrontBottom.render(f5);
		BackTop.render(f5);
		BackBottom.render(f5);
		LeftTop.render(f5);
		LeftBottom.render(f5);
		RightTop.render(f5);
		RightBottom.render(f5);
		FrontTopRight.render(f5);
		FrontTopLeft.render(f5);
		FrontBottomRight.render(f5);
		FrontBottomLeft.render(f5);
		BackTopLeft.render(f5);
		BackTopRight.render(f5);
		BackBottomLeft.render(f5);
		BackBottomRight.render(f5);

		this.entity = entity;
	}
	@Override
	public void render(float f5) {
		base.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModelSides(float f5, boolean sides[]) {
		/*GL11.glPushMatrix();
		GL11.glEnable(3042 );
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_DST_ALPHA);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);*/
		
		base.render(f5);
		Bottom.render(f5);
		
		//GL11.glDisable(3042 );
		//GL11.glPopMatrix();

		if (sides[2])
			Front.render(f5);
		if (sides[3])
			Back.render(f5);
		if (sides[1])
			Top.render(f5);
		if (sides[4])
			Left.render(f5);
		if (sides[5])
			Right.render(f5);
		if (sides[2]&&sides[4])
		 FrontLeft.render(f5);
		if (sides[3]&&sides[4])
		 BackLeft.render(f5);
		if (sides[2]&&sides[5])
		 FrontRight.render(f5);
		if (sides[3]&&sides[5])
		 BackRight.render(f5);
		if (sides[2]&&sides[1])
		 FrontTop.render(f5);
		if (sides[2]&&sides[0])
		 FrontBottom.render(f5);
		if (sides[3]&&sides[1])
		 BackTop.render(f5);
		if (sides[3]&&sides[0])
		 BackBottom.render(f5);
		if (sides[4]&&sides[1])
		 LeftTop.render(f5);
		if (sides[4]&&sides[0])
		 LeftBottom.render(f5);
		if (sides[5]&&sides[1])
		 RightTop.render(f5);
		if (sides[5]&&sides[0])
		 RightBottom.render(f5);
		if (sides[2]&&sides[1]&&sides[5])
		 FrontTopRight.render(f5);
		if (sides[2]&&sides[1]&&sides[4])
		 FrontTopLeft.render(f5);
		if (sides[2]&&sides[0]&&sides[5])
		 FrontBottomRight.render(f5);
		if (sides[2]&&sides[0]&&sides[4])
		 FrontBottomLeft.render(f5);
		if (sides[3]&&sides[1]&&sides[4])
		 BackTopLeft.render(f5);
		if (sides[3]&&sides[1]&&sides[5])
		 BackTopRight.render(f5);
		if (sides[3]&&sides[0]&&sides[4])
		 BackBottomLeft.render(f5);
		if (sides[3]&&sides[0]&&sides[5])
		 BackBottomRight.render(f5);
	}
}
