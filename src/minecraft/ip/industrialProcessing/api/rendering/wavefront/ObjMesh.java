package ip.industrialProcessing.api.rendering.wavefront;

import org.lwjgl.util.vector.Matrix4f;

import net.minecraft.client.renderer.Tessellator;

public abstract class ObjMesh {

    protected ObjQuad[] quads;
    
    public abstract ObjMesh cloneTransformed(Matrix4f transform);
    
    
    
    public void renderMesh(boolean startDraw)
    {
	renderQuads(this.quads, startDraw);
    }
    
    protected void renderQuads(ObjQuad[] quads, boolean startDraw)
    {
	for (int i = 0; i < quads.length; i++) {
	    renderQuad(quads[i], startDraw);
	}
    }
    
    protected void renderQuad(ObjQuad quad, boolean startDraw) {
	Tessellator tessellator = Tessellator.instance;
	if (startDraw)
	    tessellator.startDrawingQuads();
	tessellator.setNormal(quad.normal.x, quad.normal.y, quad.normal.z);
	tessellator.addVertexWithUV(quad.position1.x, quad.position1.y, quad.position1.z, quad.uv1.x, quad.uv1.y);
	tessellator.addVertexWithUV(quad.position2.x, quad.position2.y, quad.position2.z, quad.uv2.x, quad.uv2.y);
	tessellator.addVertexWithUV(quad.position3.x, quad.position3.y, quad.position3.z, quad.uv3.x, quad.uv3.y);
	tessellator.addVertexWithUV(quad.position4.x, quad.position4.y, quad.position4.z, quad.uv4.x, quad.uv4.y);
	if (startDraw)
	    tessellator.draw();
    }
}
