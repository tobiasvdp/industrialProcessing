package ip.industrialProcessing.transport.fluids;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import ip.industrialProcessing.api.rendering.ModelMachine;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.client.render.ModelConnectedFluid;
import ip.industrialProcessing.client.render.ModelStateMachine;

public class ModelTank extends ModelConnectedFluid {
 

	public ModelTank() {
 

	}

	@Override
	public void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {
 
	}
 

	@Override
	public void renderModelConnectedFluid(TileEntity tl, float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
		if (tankSlot == 0) {
			int bottom = down == ConnectionState.CONNECTED ? 0 : 1;
			int top = up == ConnectionState.CONNECTED ? 0 : 1;

			int lightLevel = tl.blockType.getMixedBrightnessForBlock(tl.worldObj, tl.xCoord, tl.yCoord, tl.zCoord);
			float x = -6f;
			float z = -6f;
			float depth = (16 - bottom - top) * (1 - fluidPercentage);
			float y = 8 + top + depth;
			float w = 12;
			float h = 12;
			float yBot = 8 - bottom + 16;
			Tessellator tessellator = Tessellator.instance;
			if (up == ConnectionState.CONNECTED || fluidPercentage < 1) {

				float w1 = w / 12f * 3f;
				float w2 = w / 12f * 9f;

				float u0 = icon.getMinU();
				float u3 = icon.getMaxU();

				float dU = u3 - u0;

				float u1 = u0 + dU / 12f * 3f;
				float u2 = u0 + dU / 12f * 9f;

				float h1 = h / 12f * 3f;
				float h2 = h / 12f * 9f;

				float v0 = icon.getMinV();
				float v3 = icon.getMaxV();

				float dV = v3 - v0;

				float v1 = v0 + dV / 12f * 3f;
				float v2 = v0 + dV / 12f * 9f;

				tessellator.startDrawingQuads();
				tessellator.setBrightness(lightLevel);
				tessellator.setNormal(0, -1, 0);
				tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h1) * f, (double) u0, (double) v1);
				tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + 0) * f, (double) u1, (double) v0);
				tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + h) * f, (double) u1, (double) v3);
				tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h2) * f, (double) u0, (double) v2);

				tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + 0) * f, (double) u1, (double) icon.getMinV());
				tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + 0) * f, (double) u2, (double) icon.getMinV());
				tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + h) * f, (double) u2, (double) icon.getMaxV());
				tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + h) * f, (double) u1, (double) icon.getMaxV());

				tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + 0) * f, (double) u2, (double) v0);
				tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h1) * f, (double) u3, (double) v1);
				tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h2) * f, (double) u3, (double) v2);
				tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + h) * f, (double) u2, (double) v3);
				tessellator.draw();

			}
			float vOffset = (icon.getMaxV() - icon.getMinV()) * (1 - fluidPercentage);
			float uOffset = 4f / 16f * (icon.getMaxU() - icon.getMinU());
			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 0, -1);
            tessellator.setBrightness(lightLevel);
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
			tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMaxV());
			tessellator.addVertexWithUV((double) (x + 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMaxV());
			tessellator.draw();
		}
	}

}
