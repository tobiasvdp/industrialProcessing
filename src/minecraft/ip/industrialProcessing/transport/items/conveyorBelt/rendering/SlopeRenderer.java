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

		float uMins = 61 / 64f;
		float uMaxs = 62 / 64f;
		float vMins = 16 / 32f;
		float vMaxs = 32 / 32f;

		float vLen = (vMax - vMin) / segments;
		float vStart = vMin;

		float vLens = (vMaxs - vMins) / segments;
		float vStarts = vMins;

		float bottomUv = -9 / 64f;
		float bottomUvs = -1 / 64f;

		float sideUMin = 0;
		float sideUMax = 1 / 64f;

		float sideUMins = 60 / 64f;
		float sideUMaxs = 64 / 64f;

		float yStart = startHeight * 16f + 24;
		float yEnd = endHeight * 16f + 24;

		float yMid = midHeight + 24f;

		Vector2f start = new Vector2f(-8, yStart);
		Vector2f mid = new Vector2f(0, yMid);
		Vector2f end = new Vector2f(8, yEnd);

		Vector2f lastPos = start;

		float startNormalZ = (float) Math.sin(endNormalAngle) / 2;
		float endNormalZ = (float) Math.sin(startNormalAngle) / 2;

		float startNormalY = (float) Math.cos(endNormalAngle) / 2;
		float endNormalY = (float) Math.cos(startNormalAngle) / 2;

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
			float vEnds = vStarts + vLens;

			float progress = (float) i / segments;
			Vector2f pos = IPMath.bezier(start, mid, end, progress);

			normalZ = IPMath.lerp(endNormalZ, startNormalZ, progress);
			normalY = IPMath.lerp(endNormalY, startNormalY, progress);

			float x1 = -4;
			float x2 = 4;

			float x3 = -4;
			float x4 = 4;

			float x1s = -3;
			float x2s = 3;

			float x3s = -3;
			float x4s = 3;

			float x1d = -2;
			float x2d = 2;

			float x3d = -2;
			float x4d = 2;

			float z1 = lastPos.x;
			float z2 = lastPos.x;

			float z3 = pos.x;
			float z4 = pos.x;

			float dy = normalZ * normalZ / normalY + normalY;
			float lastDy = lastNormalZ * lastNormalZ / lastNormalY + lastNormalY;

			float y1 = lastPos.y - 0.5f - lastDy;
			float y2 = lastPos.y - 0.5f + lastDy;
			float y3 = pos.y - 0.5f - dy;
			float y4 = pos.y - 0.5f + dy;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - 0) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - 0) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - 0) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - 0) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + 0) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + 0) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + 0) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + 0) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - 0) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + 0) * f, sideUMin, vEnd);
			tessellator.draw();

			y1 += 2 * lastNormalY;
			y2 += 2 * lastNormalY;
			y3 += 2 * normalY;
			y4 += 2 * normalY;

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x2 - 1) * f, (y1) * f, (z2 - 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2 - 1) * f, (y2 + 2) * f, (z2 + 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4 - 1) * f, (y4 + 2) * f, (z4 + 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4 - 1) * f, (y3) * f, (z4 - 0) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x1 + 1) * f, (y2 + 2) * f, (z1 + 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1 + 1) * f, (y1) * f, (z1 - 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3 + 1) * f, (y3) * f, (z3 - 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3 + 1) * f, (y4 + 2) * f, (z3 + 0) * f, sideUMin, vEnd);
			tessellator.draw();

			y1 += 2;
			y2 += 2;
			y3 += 2;
			y4 += 2;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - 0) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - 0) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - 0) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - 0) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + 0) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + 0) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + 0) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + 0) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x2) * f, (y1) * f, (z2 - 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y2) * f, (z2 + 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y4) * f, (z4 + 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y3) * f, (z4 - 0) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x1) * f, (y2) * f, (z1 + 0) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y1) * f, (z1 - 0) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y3) * f, (z3 - 0) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y4) * f, (z3 + 0) * f, sideUMin, vEnd);
			tessellator.draw();

			y1 += 5;
			y2 += 5;
			y3 += 5;
			y4 += 5;

			// left
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x2d) * f, (y1) * f, (z1 - 0) * f, uMins, vStarts); // -
			tessellator.addVertexWithUV((x2s) * f, (y1) * f, (z2 - 0) * f, uMaxs, vStarts); // +
			tessellator.addVertexWithUV((x4s) * f, (y3) * f, (z4 - 0) * f, uMaxs, vEnds); // +
			tessellator.addVertexWithUV((x4d) * f, (y3) * f, (z3 - 0) * f, uMins, vEnds); // -
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2s) * f, (y2) * f, (z2 + 0) * f, uMins + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x2d) * f, (y2) * f, (z1 + 0) * f, uMaxs + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x4d) * f, (y4) * f, (z3 + 0) * f, uMaxs + bottomUvs, vEnds);
			tessellator.addVertexWithUV((x4s) * f, (y4) * f, (z4 + 0) * f, uMins + bottomUvs, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x2s) * f, (y1) * f, (z2 - 0) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x2s) * f, (y2) * f, (z2 + 0) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x4s) * f, (y4) * f, (z4 + 0) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x4s) * f, (y3) * f, (z4 - 0) * f, sideUMins, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x2d) * f, (y2) * f, (z1 + 0) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x2d) * f, (y1) * f, (z1 - 0) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x4d) * f, (y3) * f, (z3 - 0) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x4d) * f, (y4) * f, (z3 + 0) * f, sideUMins, vEnds);
			tessellator.draw();

			// right

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1s) * f, (y1) * f, (z1 - 0) * f, uMins, vStarts); // -
			tessellator.addVertexWithUV((x1d) * f, (y1) * f, (z2 - 0) * f, uMaxs, vStarts); // +
			tessellator.addVertexWithUV((x3d) * f, (y3) * f, (z4 - 0) * f, uMaxs, vEnds); // +
			tessellator.addVertexWithUV((x3s) * f, (y3) * f, (z3 - 0) * f, uMins, vEnds); // -
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x1d) * f, (y2) * f, (z2 + 0) * f, uMins + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x1s) * f, (y2) * f, (z1 + 0) * f, uMaxs + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x3s) * f, (y4) * f, (z3 + 0) * f, uMaxs + bottomUvs, vEnds);
			tessellator.addVertexWithUV((x3d) * f, (y4) * f, (z4 + 0) * f, uMins + bottomUvs, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(1, 0, 0);
			tessellator.addVertexWithUV((x1d) * f, (y1) * f, (z2 - 0) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x1d) * f, (y2) * f, (z2 + 0) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x3d) * f, (y4) * f, (z4 + 0) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x3d) * f, (y3) * f, (z4 - 0) * f, sideUMins, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(-1, 0, 0);
			tessellator.addVertexWithUV((x1s) * f, (y2) * f, (z1 + 0) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x1s) * f, (y1) * f, (z1 - 0) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x3s) * f, (y3) * f, (z3 - 0) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x3s) * f, (y4) * f, (z3 + 0) * f, sideUMins, vEnds);
			tessellator.draw();

			vStart = vEnd;
			vStarts = vEnds;
			lastPos = pos;
			lastNormalZ = normalZ;
			lastNormalY = normalY;
		}

		uMin = 1 / 64f;
		uMax = 9 / 64f;
		vMin = 0 / 32f;
		vMax = 1 / 32f;
		if (renderCapStart) {
			float cdy = capNormalStartZ * capNormalStartZ / capNormalStartY + capNormalStartY;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 0, -1);
			tessellator.addVertexWithUV((4) * f, (capYstart + cdy - 0.5f) * f, (capZstart + 0) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYstart - cdy - 0.5f) * f, (capZstart - 0) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart - cdy - 0.5f) * f, (capZstart - 0) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart + cdy - 0.5f) * f, (capZstart + 0) * f, uMin, vMin);
			tessellator.draw();
			capYstart += 2 * capNormalStartY + 2;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 0, -1);
			tessellator.addVertexWithUV((4) * f, (capYstart + cdy - 0.5f) * f, (capZstart + 0) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYstart - cdy - 0.5f) * f, (capZstart - 0) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart - cdy - 0.5f) * f, (capZstart - 0) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYstart + cdy - 0.5f) * f, (capZstart + 0) * f, uMin, vMin);
			tessellator.draw();
		}
		uMin += 8 / 64f;
		uMax += 8 / 64f;

		if (renderCapEnd) {
			float cdy = capNormalEndZ * capNormalEndZ / capNormalEndY + capNormalEndY;
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 0, 1);
			tessellator.addVertexWithUV((4) * f, (capYend - cdy - 0.5f) * f, (capZend - 0) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYend + cdy - 0.5f) * f, (capZend + 0) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend + cdy - 0.5f) * f, (capZend + 0) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend - cdy - 0.5f) * f, (capZend - 0) * f, uMin, vMin);
			tessellator.draw();

			capYend += 2 * capNormalEndY + 2;
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 0, 1);
			tessellator.addVertexWithUV((4) * f, (capYend - cdy - 0.5f) * f, (capZend - 0) * f, uMax, vMin);
			tessellator.addVertexWithUV((4) * f, (capYend + cdy - 0.5f) * f, (capZend + 0) * f, uMax, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend + cdy - 0.5f) * f, (capZend + 0) * f, uMin, vMax);
			tessellator.addVertexWithUV((-4) * f, (capYend - cdy - 0.5f) * f, (capZend - 0) * f, uMin, vMin);
			tessellator.draw();
		}
	}

}
