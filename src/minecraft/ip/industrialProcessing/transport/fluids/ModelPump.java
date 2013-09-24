package ip.industrialProcessing.transport.fluids;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class ModelPump extends ModelAnimatedFluidMachine {

	// fields
	ModelRenderer Support1;
	ModelRenderer Support2;
	ModelRenderer Piston1;
	ModelRenderer Side1;
	ModelRenderer Side2;
	ModelRenderer PowerInput;
	ModelRenderer Input;
	ModelRenderer Motor;
	ModelRenderer Tube1;
	ModelRenderer Tube2;
	ModelRenderer Glider2;
	ModelRenderer Output;
	ModelRenderer Piston3;
	ModelRenderer Piston2;
	ModelRenderer Glider1;

	public ModelPump() {
		textureWidth = 64;
		textureHeight = 32;

		Support1 = new ModelRenderer(this, 0, 0);
		Support1.addBox(0F, 0F, 0F, 16, 2, 2);
		Support1.setRotationPoint(-8F, 22F, -8F);
		Support1.setTextureSize(64, 32);
		Support1.mirror = true;
		setRotation(Support1, 0F, 0F, 0F);
		Support2 = new ModelRenderer(this, 0, 0);
		Support2.addBox(0F, 0F, 0F, 16, 2, 2);
		Support2.setRotationPoint(-8F, 22F, 6F);
		Support2.setTextureSize(64, 32);
		Support2.mirror = true;
		setRotation(Support2, 0F, 0F, 0F);
		Piston1 = new ModelRenderer(this, 0, 25);
		Piston1.addBox(-3F, -3F, 0F, 6, 6, 1);
		Piston1.setRotationPoint(4F, 16F, 0F);
		Piston1.setTextureSize(64, 32);
		Piston1.mirror = true;
		setRotation(Piston1, 0F, 1.570796F, 0F);
		Side1 = new ModelRenderer(this, 14, 4);
		Side1.addBox(-7F, -7F, -7F, 14, 14, 2);
		Side1.setRotationPoint(0F, 16F, 0F);
		Side1.setTextureSize(64, 32);
		Side1.mirror = true;
		setRotation(Side1, 0F, 1.570796F, 0F);
		Side2 = new ModelRenderer(this, 14, 4);
		Side2.addBox(-7F, -7F, -7F, 14, 14, 2);
		Side2.setRotationPoint(0F, 16F, 0F);
		Side2.setTextureSize(64, 32);
		Side2.mirror = true;
		setRotation(Side2, 0F, -1.570796F, 0F);
		PowerInput = new ModelRenderer(this, 0, 18);
		PowerInput.addBox(-3F, -3F, 0F, 6, 6, 1);
		PowerInput.setRotationPoint(0F, 16F, 7F);
		PowerInput.setTextureSize(64, 32);
		PowerInput.mirror = true;
		setRotation(PowerInput, 0F, 0F, 0F);
		Input = new ModelRenderer(this, 0, 11);
		Input.addBox(-3F, -3F, 0F, 6, 6, 1);
		Input.setRotationPoint(-7F, 16F, 0F);
		Input.setTextureSize(64, 32);
		Input.mirror = true;
		setRotation(Input, 0F, -1.570796F, 0F);
		Motor = new ModelRenderer(this, 14, 20);
		Motor.addBox(0F, 0F, 0F, 10, 8, 4);
		Motor.setRotationPoint(-5F, 12F, 3F);
		Motor.setTextureSize(64, 32);
		Motor.mirror = true;
		setRotation(Motor, 0F, 0F, 0F);
		Tube1 = new ModelRenderer(this, 46, 4);
		Tube1.addBox(-2F, -2F, -2F, 5, 4, 4);
		Tube1.setRotationPoint(-3F, 16F, 0F);
		Tube1.setTextureSize(64, 32);
		Tube1.mirror = true;
		setRotation(Tube1, 0F, 0F, 0F);
		Tube2 = new ModelRenderer(this, 46, 4);
		Tube2.addBox(-2F, -2F, -2F, 5, 4, 4);
		Tube2.setRotationPoint(2F, 16F, 0F);
		Tube2.setTextureSize(64, 32);
		Tube2.mirror = true;
		setRotation(Tube2, 0F, 0F, 0F);
		Glider2 = new ModelRenderer(this, 34, 0);
		Glider2.addBox(-2F, -2F, -0.5F, 10, 1, 1);
		Glider2.setRotationPoint(-3F, 21F, 0F);
		Glider2.setTextureSize(64, 32);
		Glider2.mirror = true;
		setRotation(Glider2, 0F, 0F, 0F);
		Output = new ModelRenderer(this, 0, 4);
		Output.addBox(-3F, -1F, 0F, 6, 6, 1);
		Output.setRotationPoint(7F, 14F, 0F);
		Output.setTextureSize(64, 32);
		Output.mirror = true;
		setRotation(Output, 0F, 1.570796F, 0F);
		Piston3 = new ModelRenderer(this, 56, 0);
		Piston3.addBox(-1.5F, 0F, 0F, 3, 2, 1);
		Piston3.setRotationPoint(4F, 19F, 0F);
		Piston3.setTextureSize(64, 32);
		Piston3.mirror = true;
		setRotation(Piston3, 0F, 1.570796F, 0F);
		Piston2 = new ModelRenderer(this, 56, 0);
		Piston2.addBox(-1.5F, 0F, 0F, 3, 2, 1);
		Piston2.setRotationPoint(4F, 11F, 0F);
		Piston2.setTextureSize(64, 32);
		Piston2.mirror = true;
		setRotation(Piston2, 0F, 1.570796F, 0F);
		Glider1 = new ModelRenderer(this, 34, 0);
		Glider1.addBox(-2F, -2F, -0.5F, 10, 1, 1);
		Glider1.setRotationPoint(-3F, 14F, 0F);
		Glider1.setTextureSize(64, 32);
		Glider1.mirror = true;
		setRotation(Glider1, 0F, 0F, 0F);
	}

	@Override
	public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {
		if (progress == null)
			return;
		Support1.render(f5);
		Support2.render(f5);
		GL11.glPushMatrix();
		GL11.glTranslatef(progress[0] * -9 / 16, 0, 0);
		Piston1.render(f5);
		Piston2.render(f5);
		Piston3.render(f5);
		GL11.glPopMatrix();
		Side1.render(f5);
		Side2.render(f5);
		PowerInput.render(f5);
		Input.render(f5);
		Motor.render(f5);
		Tube1.render(f5);
		Tube2.render(f5);
		Glider2.render(f5);
		Output.render(f5);
		Glider1.render(f5);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(null, f, new float[] { 0 });
	}

}
