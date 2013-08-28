package ip.industrialProcessing.multiblock.dummy.block.screen;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockScreen extends ModelingMultiblock {

	ModelRenderer BackBar;
	ModelRenderer RightBB;
	ModelRenderer LeftBB;
	ModelRenderer LeftB;
	ModelRenderer RightB;
	ModelRenderer Right;
	ModelRenderer RightBar;
	ModelRenderer LeftBar;
	ModelRenderer Left;
	ModelRenderer BackRight;
	ModelRenderer BackLeft;
	ModelRenderer Back;
	private Entity entity;

	public MDmultiblockScreen() {
		textureWidth = 64;
		textureHeight = 64;

		BackBar = new ModelRenderer(this, 0, 23);
		BackBar.addBox(-8F, 8F, 6F, 16, 1, 1);
		BackBar.setRotationPoint(0F, 15F, 0F);
		BackBar.setTextureSize(64, 64);
		BackBar.mirror = true;
		setRotation(BackBar, 0F, 0F, 0F);
		RightBB = new ModelRenderer(this, 0, 15);
		RightBB.addBox(-7F, 2F, 6F, 1, 7, 1);
		RightBB.setRotationPoint(0F, 15F, 0F);
		RightBB.setTextureSize(64, 64);
		RightBB.mirror = true;
		setRotation(RightBB, 0F, 0F, 0F);
		LeftBB = new ModelRenderer(this, 0, 15);
		LeftBB.addBox(6F, 2F, 6F, 1, 7, 1);
		LeftBB.setRotationPoint(0F, 15F, 0F);
		LeftBB.setTextureSize(64, 64);
		LeftBB.mirror = true;
		setRotation(LeftBB, 0F, 0F, 0F);
		LeftB = new ModelRenderer(this, 4, 16);
		LeftB.addBox(7F, 3F, 5F, 1, 6, 1);
		LeftB.setRotationPoint(0F, 15F, 0F);
		LeftB.setTextureSize(64, 64);
		LeftB.mirror = true;
		setRotation(LeftB, 0F, 0F, 0F);
		RightB = new ModelRenderer(this, 4, 16);
		RightB.addBox(-8F, 3F, 5F, 1, 6, 1);
		RightB.setRotationPoint(0F, 15F, 0F);
		RightB.setTextureSize(64, 64);
		RightB.mirror = true;
		setRotation(RightB, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 28, 22);
		Right.addBox(-8F, 4F, -7F, 1, 5, 12);
		Right.setRotationPoint(0F, 15F, 0F);
		Right.setTextureSize(64, 64);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
		RightBar = new ModelRenderer(this, 0, 25);
		RightBar.addBox(-7F, 8F, -7F, 1, 1, 13);
		RightBar.setRotationPoint(0F, 15F, 0F);
		RightBar.setTextureSize(64, 64);
		RightBar.mirror = true;
		setRotation(RightBar, 0F, 0F, 0F);
		LeftBar = new ModelRenderer(this, 0, 25);
		LeftBar.addBox(6F, 8F, -7F, 1, 1, 13);
		LeftBar.setRotationPoint(0F, 15F, 0F);
		LeftBar.setTextureSize(64, 64);
		LeftBar.mirror = true;
		setRotation(LeftBar, 0F, 0F, 0F);
		Left = new ModelRenderer(this, 28, 22);
		Left.addBox(7F, 4F, -7F, 1, 5, 12);
		Left.setRotationPoint(0F, 15F, 0F);
		Left.setTextureSize(64, 64);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		BackRight = new ModelRenderer(this, 0, 25);
		BackRight.addBox(-8F, 1F, 7F, 2, 8, 1);
		BackRight.setRotationPoint(0F, 15F, 0F);
		BackRight.setTextureSize(64, 64);
		BackRight.mirror = true;
		setRotation(BackRight, 0F, 0F, 0F);
		BackLeft = new ModelRenderer(this, 0, 25);
		BackLeft.addBox(6F, 1F, 7F, 2, 8, 1);
		BackLeft.setRotationPoint(0F, 15F, 0F);
		BackLeft.setTextureSize(64, 64);
		BackLeft.mirror = true;
		setRotation(BackLeft, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 0, 0);
		Back.addBox(-6F, 1F, 7F, 12, 8, 1);
		Back.setRotationPoint(0F, 15F, 0F);
		Back.setTextureSize(64, 64);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		BackBar.render(f5);
		RightBB.render(f5);
		LeftBB.render(f5);
		LeftB.render(f5);
		RightB.render(f5);
		Right.render(f5);
		RightBar.render(f5);
		LeftBar.render(f5);
		Left.render(f5);
		BackRight.render(f5);
		BackLeft.render(f5);
		Back.render(f5);

		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(float f5, int connection) {
		switch(connection){
		case 0:{
			BackBar.render(f5);
			LeftBB.render(f5);
			LeftB.render(f5);
			LeftBar.render(f5);
			Left.render(f5);
			Back.render(f5);
			BackRight.render(f5);
			break;
		}
		case 1:{
			BackBar.render(f5);
			RightBB.render(f5);
			RightB.render(f5);
			Right.render(f5);
			RightBar.render(f5);
			Back.render(f5);
			BackLeft.render(f5);
			break;
		}
		case 2:{
			BackBar.render(f5);
			Back.render(f5);
			BackLeft.render(f5);
			BackRight.render(f5);
			break;
		}
		}
	}

	@Override
	public void renderModel(float f5) {
		BackBar.render(f5);
		RightBB.render(f5);
		LeftBB.render(f5);
		LeftB.render(f5);
		RightB.render(f5);
		Right.render(f5);
		RightBar.render(f5);
		LeftBar.render(f5);
		Left.render(f5);
		Back.render(f5);
	}

}
