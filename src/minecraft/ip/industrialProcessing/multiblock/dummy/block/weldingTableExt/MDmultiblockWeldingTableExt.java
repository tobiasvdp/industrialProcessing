package ip.industrialProcessing.multiblock.dummy.block.weldingTableExt;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockWeldingTableExt extends ModelingMultiblock{

	// fields
	ModelRenderer Top;
	ModelRenderer Desk;
	ModelRenderer Back;
	ModelRenderer FootRight;
	ModelRenderer ConnectedPanelLeft;
	ModelRenderer Door;
	ModelRenderer HandleLeft;
	ModelRenderer FootLeft;
	ModelRenderer ConnectedPanelRight;
	ModelRenderer HandleRight;
	private Entity entity;

	public MDmultiblockWeldingTableExt() {
		textureWidth = 64;
		textureHeight = 128;

		Top = new ModelRenderer(this, 0, 0);
		Top.addBox(-8F, 0F, -8F, 16, 1, 16);
		Top.setRotationPoint(0F, 8F, 0F);
		Top.setTextureSize(64, 32);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		Desk = new ModelRenderer(this, 0, 33);
		Desk.addBox(-7.5F, 0F, -7.5F, 15, 13, 15);
		Desk.setRotationPoint(0F, 8.5F, 0F);
		Desk.setTextureSize(64, 32);
		Desk.mirror = true;
		setRotation(Desk, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 0, 17);
		Back.addBox(-8F, 1F, 7F, 16, 15, 1);
		Back.setRotationPoint(0F, 8F, 0F);
		Back.setTextureSize(64, 32);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		FootRight = new ModelRenderer(this, 0, 61);
		FootRight.addBox(-8F, 15F, -8F, 1, 1, 15);
		FootRight.setRotationPoint(0F, 8F, 0F);
		FootRight.setTextureSize(64, 32);
		FootRight.mirror = true;
		setRotation(FootRight, 0F, 0F, 0F);
		ConnectedPanelLeft = new ModelRenderer(this, 32, 61);
		ConnectedPanelLeft.addBox(7F, 0F, -7.5F, 1, 13, 15);
		ConnectedPanelLeft.setRotationPoint(0F, 8.5F, 0.1F);
		ConnectedPanelLeft.setTextureSize(64, 32);
		ConnectedPanelLeft.mirror = true;
		setRotation(ConnectedPanelLeft, 0F, 0F, 0F);
		Door = new ModelRenderer(this, 34, 17);
		Door.addBox(-5.5F, 2F, -7.7F, 12, 10, 1);
		Door.setRotationPoint(0F, 8.5F, 0F);
		Door.setTextureSize(64, 32);
		Door.mirror = true;
		setRotation(Door, 0F, 0F, 0F);
		HandleLeft = new ModelRenderer(this, 60, 17);
		HandleLeft.addBox(0F, 1.5F, -1F, 1, 9, 1);
		HandleLeft.setRotationPoint(5.3F, 9.5F, -6.8F);
		HandleLeft.setTextureSize(64, 32);
		HandleLeft.mirror = true;
		setRotation(HandleLeft, 0F, 0.4363323F, 0F);
		FootLeft = new ModelRenderer(this, 0, 61);
		FootLeft.addBox(7F, 15F, -8F, 1, 1, 15);
		FootLeft.setRotationPoint(0F, 8F, 0F);
		FootLeft.setTextureSize(64, 32);
		FootLeft.mirror = true;
		setRotation(FootLeft, 0F, 0F, 0F);
		ConnectedPanelRight = new ModelRenderer(this, 32, 61);
		ConnectedPanelRight.addBox(-8F, 0F, -7.5F, 1, 13, 15);
		ConnectedPanelRight.setRotationPoint(0F, 8.5F, 0.1F);
		ConnectedPanelRight.setTextureSize(64, 32);
		ConnectedPanelRight.mirror = true;
		setRotation(ConnectedPanelRight, 0F, 0F, 0F);
		HandleRight = new ModelRenderer(this, 60, 17);
		HandleRight.addBox(-1F, 1.5F, 0F, 1, 9, 1);
		HandleRight.setRotationPoint(-3.7F, 9.5F, -7.8F);
		HandleRight.setTextureSize(64, 32);
		HandleRight.mirror = true;
		setRotation(HandleRight, 0F, -0.4363323F, 0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Top.render(f5);
		Desk.render(f5);
		Back.render(f5);
		FootRight.render(f5);
		ConnectedPanelLeft.render(f5);
		Door.render(f5);
		HandleLeft.render(f5);
		FootLeft.render(f5);
		ConnectedPanelRight.render(f5);
		HandleRight.render(f5);
		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(float f5) {
		Top.render(f5);
		Desk.render(f5);
		Back.render(f5);
		FootRight.render(f5);
		FootLeft.render(f5);
		Door.render(f5);
		HandleLeft.render(f5);
	}

	@Override
	public void renderModel(float f5, int connection) {
		switch(connection){
		case 0:{
			Top.render(f5);
			Desk.render(f5);
			Back.render(f5);
			FootRight.render(f5);
			Door.render(f5);
			HandleLeft.render(f5);
			ConnectedPanelLeft.render(f5);
			break;
		}
		case 1:{
			Top.render(f5);
			Desk.render(f5);
			Back.render(f5);
			Door.render(f5);
			HandleLeft.render(f5);
			ConnectedPanelLeft.render(f5);
			ConnectedPanelRight.render(f5);
			break;
		}
		}

	}

}
