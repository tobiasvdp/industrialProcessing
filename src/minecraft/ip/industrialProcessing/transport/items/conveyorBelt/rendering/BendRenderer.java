package ip.industrialProcessing.transport.items.conveyorBelt.rendering;
 

import net.minecraft.client.renderer.Tessellator;

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
		float vMin = 1 / 64f;
		float vMax = 17 / 64f;
		
		float startAngle = this.startAngle;

		float uMins = 60 / 64f;
		float uMaxs = 61 / 64f;
		float vMins = 16 / 64f;
		float vMaxs = 32 / 64f;

		int segments = 16;

		float vLen = (invert ? (vMin - vMax) : (vMax - vMin)) / segments;
		float vLens = (invert ? (vMins - vMaxs) : (vMaxs - vMins)) / segments;
		float vStart = (invert ? vMax : vMin);
		float vStarts = (invert ? vMaxs : vMins);
		float segmentAngle = (float) Math.PI / (2 * segments);

		float bottomUv = -9 / 64f;
		
		float bottomUvs = 1 / 64f;

		float sideUMin = 0;
		float sideUMax = 1 / 64f;

		float sideUMins = 60/64f;
		float sideUMaxs = 64 / 64f;
		
		for (int i = 0; i < segments; i++) {

			float y = 23-8F;

			float endAngle = startAngle + segmentAngle;
			float vEnd = vStart + vLen;
			float vEnds = vStarts + vLens;

			float cosStart = (float) Math.cos(startAngle);
			float sinStart = (float) Math.sin(startAngle);

			float cosEnd = (float) Math.cos(endAngle);
			float sinEnd = (float) Math.sin(endAngle);

			float x1 = cosStart * 4 - xCorner;
			float x2 = cosStart * 12 - xCorner;

			float x3 = cosEnd * 4 - xCorner;
			float x4 = cosEnd * 12 - xCorner;
			
			float x1d = cosStart * 6 - xCorner;
			float x2d = cosStart * 10 - xCorner;

			float x3d = cosEnd * 6 - xCorner;
			float x4d = cosEnd * 10 - xCorner;

			float x1s = cosStart * 5 - xCorner;
			float x2s = cosStart * 11 - xCorner;

			float x3s = cosEnd * 5 - xCorner;
			float x4s = cosEnd * 11 - xCorner;

			float z1 = sinStart * 4 - yCorner;
			float z2 = sinStart * 12 - yCorner;

			float z3 = sinEnd * 4 - yCorner;
			float z4 = sinEnd * 12 - yCorner;

			float z1s = sinStart * 5 - yCorner;
			float z2s = sinStart * 11 - yCorner;

			float z3s = sinEnd * 5 - yCorner;
			float z4s = sinEnd * 11 - yCorner;
			

			float z1d = sinStart * 6 - yCorner;
			float z2d = sinStart * 10 - yCorner;

			float z3d = sinEnd * 6 - yCorner;
			float z4d = sinEnd * 10 - yCorner;

			// TOP
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (z1) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (z2) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (z4) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (z3) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (z2) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (z1) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (z3) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (z4) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (z2) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (z2) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (z4) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (z4) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (z1) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (z1) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (z3) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (z3) * f, sideUMin, vEnd);
			tessellator.draw();

			y+=1;
			// SIDES

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2s) * f, (y) * f, (z2s) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2s) * f, (y + 2) * f, (z2s) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4s) * f, (y + 2) * f, (z4s) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4s) * f, (y) * f, (z4s) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1s) * f, (y + 2) * f, (z1s) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1s) * f, (y) * f, (z1s) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3s) * f, (y) * f, (z3s) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3s) * f, (y + 2) * f, (z3s) * f, sideUMin, vEnd);
			tessellator.draw();
			
			
			// BOTTOM
			y += 2;

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (z1) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (z2) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (z4) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (z3) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (z2) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (z1) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (z3) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (z4) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (z2) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (z2) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (z4) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (z4) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (z1) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (z1) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (z3) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (z3) * f, sideUMin, vEnd);
			tessellator.draw();

			y+=5;

			// inside support bottom
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x1s) * f, (y) * f, (z1s) * f, uMins, vStarts);
			tessellator.addVertexWithUV((x1d) * f, (y) * f, (z1d) * f, uMaxs, vStarts);
			tessellator.addVertexWithUV((x3d) * f, (y) * f, (z3d) * f, uMaxs, vEnds);
			tessellator.addVertexWithUV((x3s) * f, (y) * f, (z3s) * f, uMins, vEnds);
			tessellator.draw();
			
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x1d) * f, (y + 1) * f, (z1d) * f, uMins + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x1s) * f, (y + 1) * f, (z1s) * f, uMaxs + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x3s) * f, (y + 1) * f, (z3s) * f, uMaxs + bottomUvs, vEnds);
			tessellator.addVertexWithUV((x3d) * f, (y + 1) * f, (z3d) * f, uMins + bottomUvs, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1d) * f, (y) * f, (z1d) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x1d) * f, (y + 1) * f, (z1d) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x3d) * f, (y + 1) * f, (z3d) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x3d) * f, (y) * f, (z3d) * f, sideUMins, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1s) * f, (y + 1) * f, (z1s) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x1s) * f, (y) * f, (z1s) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x3s) * f, (y) * f, (z3s) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x3s) * f, (y + 1) * f, (z3s) * f, sideUMins, vEnds);
			tessellator.draw();

			// outside support bottom
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -1, 0);
			tessellator.addVertexWithUV((x2d) * f, (y) * f, (z2d) * f, uMins, vStarts);
			tessellator.addVertexWithUV((x2s) * f, (y) * f, (z2s) * f, uMaxs, vStarts);
			tessellator.addVertexWithUV((x4s) * f, (y) * f, (z4s) * f, uMaxs, vEnds);
			tessellator.addVertexWithUV((x4d) * f, (y) * f, (z4d) * f, uMins, vEnds);
			tessellator.draw();
 			
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 1, 0);
			tessellator.addVertexWithUV((x2s) * f, (y + 1) * f, (z2s) * f, uMins + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x2d) * f, (y + 1) * f, (z2d) * f, uMaxs + bottomUvs, vStarts);
			tessellator.addVertexWithUV((x4d) * f, (y + 1) * f, (z4d) * f, uMaxs + bottomUvs, vEnds);
			tessellator.addVertexWithUV((x4s) * f, (y + 1) * f, (z4s) * f, uMins + bottomUvs, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2s) * f, (y) * f, (z2s) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x2s) * f, (y + 1) * f, (z2s) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x4s) * f, (y + 1) * f, (z4s) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x4s) * f, (y) * f, (z4s) * f, sideUMins, vEnds);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2d) * f, (y + 1) * f, (z2d) * f, sideUMins, vStarts);
			tessellator.addVertexWithUV((x2d) * f, (y) * f, (z2d) * f, sideUMaxs, vStarts);
			tessellator.addVertexWithUV((x4d) * f, (y) * f, (z4d) * f, sideUMaxs, vEnds);
			tessellator.addVertexWithUV((x4d) * f, (y + 1) * f, (z4d) * f, sideUMins, vEnds);
			tessellator.draw();
			vStart = vEnd;
			vStarts = vEnds;
			startAngle = endAngle;
		}
		uMin = 9 / 64f;
		uMax = 17 / 64f;
		vMin = 0 / 64f;
		vMax = 1 / 64f;

		float y = 23-8F;

		tessellator.startDrawingQuads();
		tessellator.setNormal(0, 0, 1);
		tessellator.addVertexWithUV((4) * f, (y) * f, (8) * f, uMax, vMin);
		tessellator.addVertexWithUV((4) * f, (y + 1) * f, (8) * f, uMax, vMax);
		tessellator.addVertexWithUV((-4) * f, (y + 1) * f, (8) * f, uMin, vMax);
		tessellator.addVertexWithUV((-4) * f, (y) * f, (8) * f, uMin, vMin);
		tessellator.draw();
		
		y += 3;
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0, 0, 1);
		tessellator.addVertexWithUV((4) * f, (y) * f, (8) * f, uMax, vMin);
		tessellator.addVertexWithUV((4) * f, (y + 1) * f, (8) * f, uMax, vMax);
		tessellator.addVertexWithUV((-4) * f, (y + 1) * f, (8) * f, uMin, vMax);
		tessellator.addVertexWithUV((-4) * f, (y) * f, (8) * f, uMin, vMin);
		tessellator.draw();
		
		y+= 5;

		tessellator.startDrawingQuads();
		tessellator.setNormal(0, 0, 1);
		tessellator.addVertexWithUV((3) * f, (y) * f, (8) * f, uMaxs, vMins);
		tessellator.addVertexWithUV((3) * f, (y + 1) * f, (8) * f, uMaxs, vMins+1/64f);
		tessellator.addVertexWithUV((2) * f, (y + 1) * f, (8) * f, uMins, vMins+1/64f);
		tessellator.addVertexWithUV((2) * f, (y) * f, (8) * f, uMins, vMins);
		tessellator.draw();
		
		tessellator.startDrawingQuads();
		tessellator.setNormal(0, 0, 1);
		tessellator.addVertexWithUV((-2) * f, (y) * f, (8) * f, uMaxs, vMins);
		tessellator.addVertexWithUV((-2) * f, (y + 1) * f, (8) * f, uMaxs, vMins+1/64f);
		tessellator.addVertexWithUV((-3) * f, (y + 1) * f, (8) * f, uMins, vMins+1/64f);
		tessellator.addVertexWithUV((-3) * f, (y) * f, (8) * f, uMins, vMins);
		tessellator.draw();
	}

}
