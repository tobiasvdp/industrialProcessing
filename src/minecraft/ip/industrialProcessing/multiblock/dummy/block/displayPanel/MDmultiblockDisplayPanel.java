package ip.industrialProcessing.multiblock.dummy.block.displayPanel;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockDisplayPanel extends ModelingMultiblock {
	// fields
	ModelRenderer base;
	ModelRenderer panel;
	ModelRenderer base1;
	ModelRenderer baseplate;
	ModelRenderer cable;
	ModelRenderer rightbar;
	ModelRenderer leftbar;
	ModelRenderer visual;
	ModelRenderer lightOn;
	ModelRenderer lightWarning;
	ModelRenderer lightOff;
	ModelRenderer bar1;
	ModelRenderer bar2;
	ModelRenderer bar3;
	ModelRenderer ToggleButton1;
	ModelRenderer ToggleButton2;
	ModelRenderer ToggleButton3;
	ModelRenderer ToggleButton4;
	ModelRenderer ViewPanel;
	private Entity entity;

	public MDmultiblockDisplayPanel() {
		textureWidth = 64;
		textureHeight = 64;

		base = new ModelRenderer(this, 55, 48);
		base.addBox(-1F, 0F, -1F, 2, 11, 2);
		base.setRotationPoint(0F, 13F, 0F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		panel = new ModelRenderer(this, 0, 53);
		panel.addBox(-7F, 0F, -7F, 14, 1, 10);
		panel.setRotationPoint(0F, 12F, 0F);
		panel.setTextureSize(64, 64);
		panel.mirror = true;
		setRotation(panel, 0.6981317F, 0F, 0F);
		base1 = new ModelRenderer(this, 0, 60);
		base1.addBox(-1F, -1F, 0F, 2, 1, 1);
		base1.setRotationPoint(0F, 13F, 0F);
		base1.setTextureSize(64, 64);
		base1.mirror = true;
		setRotation(base1, 0F, 0F, 0F);
		baseplate = new ModelRenderer(this, 0, 45);
		baseplate.addBox(-5F, 11F, -4F, 10, 1, 7);
		baseplate.setRotationPoint(0F, 12F, 0F);
		baseplate.setTextureSize(64, 64);
		baseplate.mirror = true;
		setRotation(baseplate, 0F, 0F, 0F);
		cable = new ModelRenderer(this, 0, 39);
		cable.addBox(-1F, 11F, 3F, 2, 1, 5);
		cable.setRotationPoint(0F, 12F, 0F);
		cable.setTextureSize(64, 64);
		cable.mirror = true;
		setRotation(cable, 0F, 0F, 0F);
		rightbar = new ModelRenderer(this, 42, 52);
		rightbar.addBox(-7F, -0.3F, -7F, 1, 1, 10);
		rightbar.setRotationPoint(0F, 12F, 0F);
		rightbar.setTextureSize(64, 64);
		rightbar.mirror = true;
		setRotation(rightbar, 0.6981317F, 0F, 0F);
		leftbar = new ModelRenderer(this, 42, 52);
		leftbar.addBox(6F, -0.3F, -7F, 1, 1, 10);
		leftbar.setRotationPoint(0F, 12F, 0F);
		leftbar.setTextureSize(64, 64);
		leftbar.mirror = true;
		setRotation(leftbar, 0.6981317F, 0F, 0F);
		visual = new ModelRenderer(this, 0, 32);
		visual.addBox(-5.5F, -0.2F, -3F, 5, 1, 5);
		visual.setRotationPoint(0F, 12F, 0F);
		visual.setTextureSize(64, 64);
		visual.mirror = true;
		setRotation(visual, 0.6981317F, 0F, 0F);
		lightOn = new ModelRenderer(this, 0, 30);
		lightOn.addBox(4.5F, -0.2F, 1F, 1, 1, 1);
		lightOn.setRotationPoint(0F, 12F, 0F);
		lightOn.setTextureSize(64, 64);
		lightOn.mirror = true;
		setRotation(lightOn, 0.6981317F, 0F, 0F);
		lightWarning = new ModelRenderer(this, 0, 27);
		lightWarning.addBox(4.5F, -0.2F, -0.5F, 1, 1, 1);
		lightWarning.setRotationPoint(0F, 12F, 0F);
		lightWarning.setTextureSize(64, 64);
		lightWarning.mirror = true;
		setRotation(lightWarning, 0.6981317F, 0F, 0F);
		lightOff = new ModelRenderer(this, 0, 24);
		lightOff.addBox(4.5F, -0.2F, -2F, 1, 1, 1);
		lightOff.setRotationPoint(0F, 12F, 0F);
		lightOff.setTextureSize(64, 64);
		lightOff.mirror = true;
		setRotation(lightOff, 0.6981317F, 0F, 0F);
		bar1 = new ModelRenderer(this, 5, 25);
		bar1.addBox(0F, -0.2F, -3F, 1, 1, 5);
		bar1.setRotationPoint(0F, 12F, 0F);
		bar1.setTextureSize(64, 64);
		bar1.mirror = true;
		setRotation(bar1, 0.6981317F, 0F, 0F);
		bar2 = new ModelRenderer(this, 5, 18);
		bar2.addBox(1.5F, -0.2F, -3F, 1, 1, 5);
		bar2.setRotationPoint(0F, 12F, 0F);
		bar2.setTextureSize(64, 64);
		bar2.mirror = true;
		setRotation(bar2, 0.6981317F, 0F, 0F);
		bar3 = new ModelRenderer(this, 5, 11);
		bar3.addBox(3F, -0.2F, -3F, 1, 1, 5);
		bar3.setRotationPoint(0F, 12F, 0F);
		bar3.setTextureSize(64, 64);
		bar3.mirror = true;
		setRotation(bar3, 0.6981317F, 0F, 0F);
		ToggleButton1 = new ModelRenderer(this, 15, 42);
		ToggleButton1.addBox(-5.5F, -0.2F, -4.5F, 2, 1, 1);
		ToggleButton1.setRotationPoint(0F, 12F, 0F);
		ToggleButton1.setTextureSize(64, 64);
		ToggleButton1.mirror = true;
		setRotation(ToggleButton1, 0.6981317F, 0F, 0F);
		ToggleButton2 = new ModelRenderer(this, 15, 39);
		ToggleButton2.addBox(-5.5F, -0.2F, -6F, 2, 1, 1);
		ToggleButton2.setRotationPoint(0F, 12F, 0F);
		ToggleButton2.setTextureSize(64, 64);
		ToggleButton2.mirror = true;
		setRotation(ToggleButton2, 0.6981317F, 0F, 0F);
		ToggleButton3 = new ModelRenderer(this, 22, 39);
		ToggleButton3.addBox(-3F, -0.2F, -4.5F, 2, 1, 1);
		ToggleButton3.setRotationPoint(0F, 12F, 0F);
		ToggleButton3.setTextureSize(64, 64);
		ToggleButton3.mirror = true;
		setRotation(ToggleButton3, 0.6981317F, 0F, 0F);
		ToggleButton4 = new ModelRenderer(this, 22, 42);
		ToggleButton4.addBox(-3F, -0.2F, -6F, 2, 1, 1);
		ToggleButton4.setRotationPoint(0F, 12F, 0F);
		ToggleButton4.setTextureSize(64, 64);
		ToggleButton4.mirror = true;
		setRotation(ToggleButton4, 0.6981317F, 0F, 0F);
		ViewPanel = new ModelRenderer(this, 35, 48);
		ViewPanel.addBox(-0.5F, -0.2F, -6F, 6, 1, 2);
		ViewPanel.setRotationPoint(0F, 12F, 0F);
		ViewPanel.setTextureSize(64, 64);
		ViewPanel.mirror = true;
		setRotation(ViewPanel, 0.6981317F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		base.render(f5);
		panel.render(f5);
		base1.render(f5);
		baseplate.render(f5);
		cable.render(f5);
		rightbar.render(f5);
		leftbar.render(f5);
		visual.render(f5);
		lightOn.render(f5);
		lightWarning.render(f5);
		lightOff.render(f5);
		bar1.render(f5);
		bar2.render(f5);
		bar3.render(f5);
		ToggleButton1.render(f5);
		ToggleButton2.render(f5);
		ToggleButton3.render(f5);
		ToggleButton4.render(f5);
		ViewPanel.render(f5);

		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		base.render(f5);
		panel.render(f5);
		base1.render(f5);
		baseplate.render(f5);
		cable.render(f5);
		rightbar.render(f5);
		leftbar.render(f5);
		visual.render(f5);
		lightOn.render(f5);
		lightWarning.render(f5);
		lightOff.render(f5);
		bar1.render(f5);
		bar2.render(f5);
		bar3.render(f5);
		ToggleButton1.render(f5);
		ToggleButton2.render(f5);
		ToggleButton3.render(f5);
		ToggleButton4.render(f5);
		ViewPanel.render(f5);
	}

	@Override
	public void renderModel(float f5, int connection) {
		GL11.glPushMatrix();
		base.render(f5);
		panel.render(f5);
		base1.render(f5);
		baseplate.render(f5);
		cable.render(f5);
		rightbar.render(f5);
		leftbar.render(f5);
		GL11.glColor3f(0.0f, 0.0f, 0.0f);
		visual.render(f5);
		bar1.render(f5);
		bar2.render(f5);
		bar3.render(f5);
		ToggleButton1.render(f5);
		ToggleButton2.render(f5);
		ToggleButton3.render(f5);
		ToggleButton4.render(f5);
		ViewPanel.render(f5);
		
		if(connection == 0){
			GL11.glColor3f(5.0f, 0.0f, 0.0f);
			lightOn.render(f5);
		}else{
			GL11.glColor3f(0.0f, 5.0f, 0.0f);
			lightOn.render(f5);
		}
		
		if(connection == 2){
			GL11.glColor3f(0.0f, 5.0f, 0.0f);
			lightWarning.render(f5);
		}else{
			GL11.glColor3f(5.0f, 0.0f, 0.0f);
			lightWarning.render(f5);
		}
		GL11.glColor3f(5.0f, 0.0f, 0.0f);
		lightOff.render(f5);
		
		GL11.glPopMatrix();
	}

	@Override
	public void renderModel(float f5, int modelConnection, float[] animation) {
		base.render(f5);
		panel.render(f5);
		base1.render(f5);
		baseplate.render(f5);
		cable.render(f5);
		rightbar.render(f5);
		leftbar.render(f5);
		visual.render(f5);
		lightOn.render(f5);
		lightWarning.render(f5);
		lightOff.render(f5);
		bar1.render(f5);
		bar2.render(f5);
		bar3.render(f5);
		ToggleButton1.render(f5);
		ToggleButton2.render(f5);
		ToggleButton3.render(f5);
		ToggleButton4.render(f5);
		ViewPanel.render(f5);
	}
}
