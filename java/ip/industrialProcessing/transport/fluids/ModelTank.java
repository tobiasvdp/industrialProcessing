package ip.industrialProcessing.transport.fluids;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedFluid;

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

            tessellator.setColorOpaque(255, 255, 255);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            if (fluidPercentage < 1) {

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
                tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h1) * f, u0, v1);
                tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + 0) * f, u1, v0);
                tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + h) * f, u1, v3);
                tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h2) * f, u0, v2);

                tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + 0) * f, u1, icon.getMinV());
                tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + 0) * f, u2, icon.getMinV());
                tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + h) * f, u2, icon.getMaxV());
                tessellator.addVertexWithUV((double) (x + w1) * f, (double) y * f, (double) (z + h) * f, u1, icon.getMaxV());

                tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + 0) * f, u2, v0);
                tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h1) * f, u3, v1);
                tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h2) * f, u3, v2);
                tessellator.addVertexWithUV((double) (x + w2) * f, (double) y * f, (double) (z + h) * f, u2, v3);
                tessellator.draw();

            }
            float vOffset = (icon.getMaxV() - icon.getMinV()) * (1 - fluidPercentage);
            float uOffset = 4f / 16f * (icon.getMaxU() - icon.getMinU());
            tessellator.startDrawingQuads();
            tessellator.setNormal(0, 0, -1);
            tessellator.setBrightness(lightLevel);
            tessellator.addVertexWithUV((double) (x + 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
            tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
            tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, icon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, icon.getMaxV());
            tessellator.draw();
            GL11.glDisable(GL11.GL_BLEND);
        }
    }

}
