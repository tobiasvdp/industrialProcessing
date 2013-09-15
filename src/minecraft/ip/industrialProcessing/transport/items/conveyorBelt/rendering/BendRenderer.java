package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;

public class BendRenderer extends ShapeRenderer {

	public BendRenderer(int xCorner, int yCorner, float startAngle, boolean invert) {
		this.xCorner = xCorner;
		this.yCorner = yCorner;
		this.startAngle = startAngle;
		this.invert = invert;
	}

	// render parameters
	private int xCorner;
	private boolean invert;
	private int yCorner;
	private float startAngle;

	@Override
	protected void drawShape(float f) {

		Tessellator tessellator = Tessellator.instance;
		float uMin = 10 / 64f;
		float uMax = 18 / 64f;
		float vMin = 1 / 32f;
		float vMax = 17 / 32f;

		float y = 23;

		int segments = 16;

		float vLen = (invert ? (vMin - vMax) : (vMax - vMin)) / segments;
		float vStart = (invert ? vMax : vMin);
		float segmentAngle = (float) Math.PI / (2 * segments);

		float bottomUv = -9 / 64f;

		float sideUMin = 0;
		float sideUMax = 1 / 32f;
		for (int i = 0; i < segments; i++) {
			float endAngle = startAngle + segmentAngle;
			float vEnd = vStart + vLen;

			float cosStart = (float) Math.cos(startAngle);
			float sinStart = (float) Math.sin(startAngle);

			float cosEnd = (float) Math.cos(endAngle);
			float sinEnd = (float) Math.sin(endAngle);

			float x1 = cosStart * 4 - xCorner;
			float x2 = cosStart * 12 - xCorner;

			float x3 = cosEnd * 4 - xCorner;
			float x4 = cosEnd * 12 - xCorner;

			float y1 = sinStart * 4 - yCorner;
			float y2 = sinStart * 12 - yCorner;

			float y3 = sinEnd * 4 - yCorner;
			float y4 = sinEnd * 12 - yCorner; 

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 2, 0);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (y1) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (y2) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (y4) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (y3) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -2, 0);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (y2) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (y1) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (y3) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (y4) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (y2) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (y2) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (y4) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (y4) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (y1) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (y1) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (y3) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (y3) * f, sideUMin, vEnd);
			tessellator.draw();

			vStart = vEnd;
			startAngle = endAngle;
		}
		uMin = 9 / 64f;
		uMax = 17 / 64f;
		vMin = 0 / 32f;
		vMax = 1 / 32f;

		tessellator.startDrawingQuads();
		tessellator.setNormal(0, 0, 1);
		tessellator.addVertexWithUV((4) * f, (23) * f, (8) * f, uMax, vMin);
		tessellator.addVertexWithUV((4) * f, (24) * f, (8) * f, uMax, vMax);
		tessellator.addVertexWithUV((-4) * f, (24) * f, (8) * f, uMin, vMax);
		tessellator.addVertexWithUV((-4) * f, (23) * f, (8) * f, uMin, vMin);
		tessellator.draw();
	}

}
