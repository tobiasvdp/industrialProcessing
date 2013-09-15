package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.utils.IPMath;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.util.vector.Vector2f;

public class SlopeRenderer extends ShapeRenderer {

	public SlopeRenderer(int segments, float startHeight, float midHeight, float endHeight, float startNormalAngle, float endNormalAngle, float marginStart, float marginEnd, boolean renderCapStart, boolean renderCapEnd) {
		this.segments = segments;
		this.startHeight = startHeight;
		this.endHeight = endHeight;

		this.midHeight = midHeight;

		this.startNormalAngle = startNormalAngle;
		this.endNormalAngle = endNormalAngle;
		this.marginStart = marginStart;
		this.marginEnd = marginEnd;

		this.renderCapStart = renderCapStart;
		this.renderCapEnd = renderCapEnd;
	}

	int segments;
	float startHeight;
	float midHeight;
	float endHeight;

	float startNormalAngle;
	float endNormalAngle;

	float marginStart;
	float marginEnd;

	boolean renderCapStart;
	boolean renderCapEnd;

	@Override
	protected void drawShape(float f) {

		Tessellator tessellator = Tessellator.instance;
		float uMin = 10 / 64f;
		float uMax = 18 / 64f;
		float vMin = 1 / 32f;
		float vMax = 17 / 32f;

		float vLen = (vMax - vMin) / segments;
		float vStart = vMin;

		float bottomUv = -9 / 64f;

		float sideUMin = 0;
		float sideUMax = 1 / 32f;

		float yStart = startHeight * 16f + 24;
		float yEnd = endHeight * 16f + 24;

		float yMid = midHeight + 24f;

		Vector2f start = new Vector2f(-8, yStart);
		Vector2f mid = new Vector2f(0, yMid);
		Vector2f end = new Vector2f(8, yEnd);

		Vector2f lastPos = start;

		float startNormalZ = (float) Math.sin(endNormalAngle)/2;
		float endNormalZ = (float) Math.sin(startNormalAngle)/2;

		float startNormalY = (float) Math.cos(endNormalAngle)/2;
		float endNormalY = (float) Math.cos(startNormalAngle)/2;

		float lastNormalZ = startNormalZ;
		float lastNormalY = startNormalY;
		float normalZ;
		float normalY;

		int maxSegments = segments;
		int startSegment = 1;

		float capZstart = start.x;
		float capZend = end.x;

		float capYstart = start.y;
		float capYend = end.y;

		float capNormalStartZ = startNormalZ;
		float capNormalStartY = startNormalY;
		float capNormalEndZ = endNormalZ;
		float capNormalEndY = endNormalY;

		float backCap = marginStart;
		float frontCap = 1 - marginEnd;

		startSegment = 1 + (int) (segments * backCap);

		vStart += vLen * segments * backCap;
		lastPos = IPMath.bezier(start, mid, end, backCap);

		capZstart = lastPos.x;
		capYstart = lastPos.y;

		capNormalStartZ = lastNormalZ = IPMath.lerp(endNormalZ, startNormalZ, backCap);
		capNormalStartY = lastNormalY = IPMath.lerp(endNormalY, startNormalY, backCap);

		maxSegments = (int) (segments * frontCap);

		Vector2f cap = IPMath.bezier(start, mid, end, frontCap);

		capNormalEndZ = IPMath.lerp(endNormalZ, startNormalZ, frontCap);
		capNormalEndY = IPMath.lerp(endNormalY, startNormalY, frontCap);
		capZend = cap.x;
		capYend = cap.y;

		// maxSegments = maxSegments - startSegment +1;
		for (int i = startSegment; i <= maxSegments; i++) {
			float vEnd = vStart + vLen;

			float progress = (float) i / segments;
			Vector2f pos = IPMath.bezier(start, mid, end, progress);

			normalZ = IPMath.lerp(endNormalZ, startNormalZ, progress);
			normalY = IPMath.lerp(endNormalY, startNormalY, progress);

			float x1 = -4;
			float x2 = 4;

			float x3 = -4;
			float x4 = 4;

			float z1 = lastPos.x;
			float z2 = lastPos.x;

			float z3 = pos.x;
			float z4 = pos.x;

			float y1 = lastPos.y - 0.5f - lastNormalY;
			float y2 = lastPos.y - 0.5f + lastNormalY;
			float y3 = pos.y - 0.5f - normalY;
			float y4 = pos.y - 0.5f + normalY;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 2, 0);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - lastNormalZ) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - lastNormalZ) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - normalZ) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - normalZ) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -2, 0);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + lastNormalZ) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + lastNormalZ) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + normalZ) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + normalZ) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - lastNormalZ) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + lastNormalZ) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + normalZ) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - normalZ) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + lastNormalZ) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - lastNormalZ) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - normalZ) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + normalZ) * f, sideUMin, vEnd);
			tessellator.draw();
			vStart = vEnd;
			lastPos = pos;
			lastNormalZ = normalZ;
			lastNormalY = normalY;
		}

		uMin = 1 / 64f;
		uMax = 9 / 64f;
		vMin = 0 / 32f;
		vMax = 1 / 32f;
		if (renderCapStart) {
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -capNormalStartY, capNormalStartZ);
			tessellator.addVertexWithUV((4) * f, (capYstart + capNormalStartY - 0.5f) * f, (capZstart + capNormalStartZ) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYstart - capNormalStartY - 0.5f) * f, (capZstart - capNormalStartZ) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart - capNormalStartY - 0.5f) * f, (capZstart - capNormalStartZ) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart + capNormalStartY - 0.5f) * f, (capZstart + capNormalStartZ) * f, uMin, vMin);
			tessellator.draw();
		}
		uMin += 8 / 64f;
		uMax += 8 / 64f;

		if (renderCapEnd) {
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -capNormalEndY, capNormalEndZ);
			tessellator.addVertexWithUV((4) * f, (capYend - capNormalEndY - 0.5f) * f, (capZend - capNormalEndZ) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYend + capNormalEndY - 0.5f) * f, (capZend + capNormalEndZ) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend + capNormalEndY - 0.5f) * f, (capZend + capNormalEndZ) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend - capNormalEndY - 0.5f) * f, (capZend - capNormalEndZ) * f, uMin, vMin);
			tessellator.draw();
		}
	}

}
