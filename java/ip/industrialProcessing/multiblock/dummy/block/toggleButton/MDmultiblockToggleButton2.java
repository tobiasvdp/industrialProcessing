package ip.industrialProcessing.multiblock.dummy.block.toggleButton;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import ip.industrialProcessing.client.render.ModelingMultiblock;

public class MDmultiblockToggleButton2 extends ModelingMultiblock {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape11;
	ModelRenderer Shape15;

	private Entity entity;

	public MDmultiblockToggleButton2() {
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-8F, -8F, -8F, 16, 16, 16);
		Shape1.setRotationPoint(0F, 16F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 32);
		Shape2.addBox(0F, 0F, 0F, 6, 10, 1);
		Shape2.setRotationPoint(-3F, 11F, -8.3F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 43);
		Shape3.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape3.setRotationPoint(-1F, 13F, -8.5F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 7, 43);
		Shape4.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape4.setRotationPoint(-1F, 17F, -8.5F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 46);
		Shape5.addBox(0F, 0F, 0F, 1, 7, 5);
		Shape5.setRotationPoint(7.2F, 12.5F, -2.5F);
		Shape5.setTextureSize(64, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 58);
		Shape6.addBox(0F, 0F, 0F, 1, 1, 5);
		Shape6.setRotationPoint(7.5F, 11.5F, -2.5F);
		Shape6.setTextureSize(64, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 58);
		Shape7.addBox(0F, 0F, 0F, 1, 1, 5);
		Shape7.setRotationPoint(7.5F, 19.5F, -2.5F);
		Shape7.setTextureSize(64, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 58);
		Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape8.setRotationPoint(7.5F, 13F, -2.2F);
		Shape8.setTextureSize(64, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 7, 58);
		Shape9.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape9.setRotationPoint(7.5F, 13F, -0.7F);
		Shape9.setTextureSize(64, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 58);
		Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape10.setRotationPoint(7.5F, 14.5F, -2.2F);
		Shape10.setTextureSize(64, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 58);
		Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape12.setRotationPoint(7.5F, 16F, -2.2F);
		Shape12.setTextureSize(64, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 7, 58);
		Shape13.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape13.setRotationPoint(7.5F, 16F, -0.7F);
		Shape13.setTextureSize(64, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 58);
		Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
		Shape14.setRotationPoint(7.5F, 17.5F, -2.2F);
		Shape14.setTextureSize(64, 64);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 7, 58);
		Shape11.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape11.setRotationPoint(7.5F, 14.5F, -0.7F);
		Shape11.setTextureSize(64, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 7, 58);
		Shape15.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape15.setRotationPoint(7.5F, 17.5F, -0.7F);
		Shape15.setTextureSize(64, 64);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape11.render(f5);
	    Shape15.render(f5);

		this.entity = entity;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape11.render(f5);
	    Shape15.render(f5);

	}

	@Override
	public void renderModel(float f5, int connection) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
	    Shape6.render(f5);
	    Shape7.render(f5);
	    Shape8.render(f5);
	    Shape9.render(f5);
	    Shape10.render(f5);
	    Shape12.render(f5);
	    Shape13.render(f5);
	    Shape14.render(f5);
	    Shape11.render(f5);
	    Shape15.render(f5);

	}
}
