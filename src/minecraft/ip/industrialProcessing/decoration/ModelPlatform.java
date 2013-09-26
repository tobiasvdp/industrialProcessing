package ip.industrialProcessing.decoration;

import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class ModelPlatform extends ModelBlock {

    public ModelPlatform() {
    }

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
	float f5 = 0.0625f;
	/*
	 * Railing3.render(f5); Railing4.render(f5); Railing8.render(f5);
	 * Railing10.render(f5); Railing2.render(f5); Railing9.render(f5);
	 * Railing1.render(f5); Railing6.render(f5); Railing7.render(f5);
	 * Railing5.render(f5); PlatformSideSingle.render(f5);
	 * PlatformSideDual.render(f5);
	 */
	renderWorldBlock(null, 0, 0, 0, block, modelID, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	Tessellator tessellator = Tessellator.instance;
	
	float y1,y2,y3,y4;
	float x1,x2,x3,x4;
	float z1,z2,z3,z4;
	float u1,u2,u3,u4;
	float v1,v2,v3,v4;
	
	y1=y2=y3=y4=y;
	x1 =x2=x3=x4= x;
	z1 =z2=z3=z4= z;
	
	x2++;
	x3++;
	
	z2++;
	z1++; 

	u1 =u2=u3=u4= 0;
	v1 =v2=v3=v4= 0;
	
	u2++;
	u3++;
	
	v1++;
	v2++;
	
	//tessellator.startDrawingQuads();
	
	tessellator.addVertexWithUV(x1, y1, z1, u1, v1);
	tessellator.addVertexWithUV(x2, y2, z2, u2, v2);
	tessellator.addVertexWithUV(x3, y3, z3, u3, v3);
	tessellator.addVertexWithUV(x4, y4, z4, u4, v4);
	

	tessellator.addVertexWithUV(x1, y1+1, z1, u1, v1);
	tessellator.addVertexWithUV(x2, y2+1, z2, u2, v2);
	tessellator.addVertexWithUV(x3, y3+1, z3, u3, v3);
	tessellator.addVertexWithUV(x4, y4+1, z4, u4, v4);
	
	//tessellator.draw();
	return true;
    }
}
