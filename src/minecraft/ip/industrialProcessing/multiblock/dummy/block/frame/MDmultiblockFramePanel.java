package ip.industrialProcessing.multiblock.dummy.block.frame;

import ip.industrialProcessing.client.render.ModelingMultiblock;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class MDmultiblockFramePanel extends ModelingMultiblock {
	// fields
	ModelRenderer Shape1;
	private Entity entity;

	public MDmultiblockFramePanel() {
		textureWidth = 64;
	    textureHeight = 32;
	    
	      Shape1 = new ModelRenderer(this, 0, 0);
	      Shape1.addBox(0F, 0F, 0F, 16, 16, 16);
	      Shape1.setRotationPoint(-8F, 8F, -8F);
	      Shape1.setTextureSize(64, 32);
	      Shape1.mirror = true;
	      setRotation(Shape1, 0F, 0F, 0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Shape1.render(f5);
		
		this.entity = entity;
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f5) {
		Shape1.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void renderModel(float f5, int connected) {
		Shape1.render(f5);
	}
}