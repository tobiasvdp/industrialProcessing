package mod.industrialProcessing.client.rendering.block.obj.wavefront;

import javax.swing.Icon;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public abstract class ObjMesh {

    private boolean compiled = false;
    private int displayList;

    private void compileDisplayList(IIcon icon) {
	this.displayList = GLAllocation.generateDisplayLists(1);
	GL11.glNewList(this.displayList, GL11.GL_COMPILE);
	Tessellator tessellator = Tessellator.instance;

	tessellator.startDrawingQuads();
	doRenderMesh(icon);
	tessellator.draw();

	GL11.glEndList();
	this.compiled = true;
    }

    public void rerenderMesh(IIcon icon) {
	Tessellator tessellator = Tessellator.instance;
	tessellator.startDrawingQuads();
	doRenderMesh(icon);
	tessellator.draw();
    }

    public void renderMesh(IIcon icon) {

	if (!compiled) {
	    compileDisplayList(icon);
	}

	GL11.glCallList(this.displayList);
    }

    protected ObjQuad[] quads;

    public abstract ObjMesh cloneTransformed(Matrix4f transform);

    public void renderMesh(boolean startDraw, IIcon icon, WorldReference position) {
	Tessellator tessellator = Tessellator.instance;
	tessellator.setColorOpaque(255, 255, 255);
	renderQuads(this.quads, startDraw, icon, position);
    }

    public void doRenderMesh(IIcon icon) {
	renderQuads(this.quads, false, icon, new Vector3f(0, 0, 0));
    }

    protected void renderQuads(ObjQuad[] quads, boolean startDraw, IIcon icon, WorldReference position) {
	for (int i = 0; i < quads.length; i++) {
	    renderQuad(quads[i], startDraw, icon, position);
	}
    }

    protected void renderQuads(ObjQuad[] quads, boolean startDraw, IIcon icon, Vector3f position) {
	for (int i = 0; i < quads.length; i++) {
	    renderQuad(quads[i], startDraw, icon, position);
	}
    }

    protected void renderQuad(ObjQuad quad, boolean startDraw, IIcon icon, WorldReference position) {
	Tessellator tessellator = Tessellator.instance;
	if (startDraw) {
	    tessellator.startDrawingQuads();
	}
	tessellator.setBrightness(983055);

	float minU = icon == null ? 0 : icon.getMinU();
	float maxU = icon == null ? 1 : icon.getMaxU();

	float minV = icon == null ? 0 : icon.getMinV();
	float maxV = icon == null ? 1 : icon.getMaxV();

	float du = maxU - minU;
	float dv = maxV - minV;

	dv *= -1;
	minV = maxV;

	float dx = 0.5f + position.x;
	float dy = 0.0f + position.y;
	float dz = 0.5f + position.z;

	Vector3f normal = quad.normal;
	normal.normalise();

	// tessellator.setColorOpaque_F(normal.x, normal.y, normal.z);
	// tessellator.setNormal(normal.x, normal.y, normal.z);

	Vector3f up = new Vector3f(1, 1, 0);
	up.normalise();

	float darken = (Vector3f.dot(up, normal) + 1) / 2f;
	int normalBrightness = (int) (255 * (darken + 1) / 2f);

	tessellator.setColorOpaque(normalBrightness, normalBrightness, normalBrightness);
	tessellator.setBrightness(position.calculateBrightness(quad.position1, normal));
	tessellator.addVertexWithUV(quad.position1.x + dx, quad.position1.y + dy, quad.position1.z + dz, quad.uv1.x * du + minU, quad.uv1.y * dv + minV);

	tessellator.setBrightness(position.calculateBrightness(quad.position2, normal));
	tessellator.addVertexWithUV(quad.position2.x + dx, quad.position2.y + dy, quad.position2.z + dz, quad.uv2.x * du + minU, quad.uv2.y * dv + minV);

	tessellator.setBrightness(position.calculateBrightness(quad.position3, normal));
	tessellator.addVertexWithUV(quad.position3.x + dx, quad.position3.y + dy, quad.position3.z + dz, quad.uv3.x * du + minU, quad.uv3.y * dv + minV);

	tessellator.setBrightness(position.calculateBrightness(quad.position4, normal));
	tessellator.addVertexWithUV(quad.position4.x + dx, quad.position4.y + dy, quad.position4.z + dz, quad.uv4.x * du + minU, quad.uv4.y * dv + minV);

	if (startDraw)
	    tessellator.draw();
    }

    protected void renderQuad(ObjQuad quad, boolean startDraw, IIcon icon, Vector3f position) {
	Tessellator tessellator = Tessellator.instance;
	if (startDraw) {
	    tessellator.startDrawingQuads();
	}

	float minU = icon == null ? 0 : icon.getMinU();
	float maxU = icon == null ? 1 : icon.getMaxU();

	float minV = icon == null ? 0 : icon.getMinV();
	float maxV = icon == null ? 1 : icon.getMaxV();

	float du = maxU - minU;
	float dv = maxV - minV;

	dv *= -1;
	minV = maxV;

	float dx = 0.0f + position.x;
	float dy = -0.5f + position.y;
	float dz = 0.0f + position.z;

	Vector3f normal = quad.normal;
	normal.normalise();

	tessellator.setNormal(normal.x, normal.y, normal.z);

	tessellator.addVertexWithUV(quad.position1.x + dx, quad.position1.y + dy, quad.position1.z + dz, quad.uv1.x * du + minU, quad.uv1.y * dv + minV);

	tessellator.addVertexWithUV(quad.position2.x + dx, quad.position2.y + dy, quad.position2.z + dz, quad.uv2.x * du + minU, quad.uv2.y * dv + minV);

	tessellator.addVertexWithUV(quad.position3.x + dx, quad.position3.y + dy, quad.position3.z + dz, quad.uv3.x * du + minU, quad.uv3.y * dv + minV);

	tessellator.addVertexWithUV(quad.position4.x + dx, quad.position4.y + dy, quad.position4.z + dz, quad.uv4.x * du + minU, quad.uv4.y * dv + minV);
	if (startDraw)
	    tessellator.draw();
    }

    protected ObjQuad[] cloneQuads(ObjQuad[] quads, Matrix4f transform) {
	ObjQuad[] newQuads = new ObjQuad[quads.length];
	for (int i = 0; i < newQuads.length; i++) {
	    newQuads[i] = quads[i].cloneTransformed(transform);
	}
	return newQuads;
    }
}
