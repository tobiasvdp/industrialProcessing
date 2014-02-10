package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

public class ModelBoiler extends ModelAnimatedFluidMachine {

    // fields
    ModelRenderer BackPlate;
    ModelRenderer TopPlate;
    ModelRenderer BottomPlate;
    ModelRenderer LeftPlate;
    ModelRenderer Tube1;
    ModelRenderer Tube2;
    ModelRenderer Tube3;
    ModelRenderer Tube4;
    ModelRenderer Tube5;
    ModelRenderer Tube6;
    ModelRenderer Tube7;
    ModelRenderer FrontPlateLeft;
    ModelRenderer Tube8;
    ModelRenderer Tube9;
    ModelRenderer Tube10;
    ModelRenderer Tube11;
    ModelRenderer Tube12;
    ModelRenderer Tube13;
    ModelRenderer Tube14;
    ModelRenderer Tube15;
    ModelRenderer Tube16;
    ModelRenderer Tube17;
    ModelRenderer Tube18;
    ModelRenderer Tube19;
    ModelRenderer Tube20;
    ModelRenderer Tube21;
    ModelRenderer Tube22;
    ModelRenderer RightPlate;
    ModelRenderer FrontGaugeBottom;
    ModelRenderer FrontPlateRight;
    ModelRenderer FrontGaugeGlass;
    ModelRenderer FrontGaugeTop;
    ModelRenderer WaterIn;
    ModelRenderer SteamOut;

    public ModelBoiler() {
        textureWidth = 64;
        textureHeight = 32;
    }

    @Override
    public void renderLiquid(TileEntity tl, float f, int tankSlot, float fluidPercentage, Icon icon) {

        int bottom = 3;
        int top = tankSlot == 1 ? 3 : 8;

        int lightLevel = tl.blockType.getMixedBrightnessForBlock(tl.worldObj, tl.xCoord, tl.yCoord, tl.zCoord);
        float x = tankSlot == 1 ? -6.875f : -6.9375f;
        float z = tankSlot == 1 ? -6.875f : -6.9375f;
        float depth = (16 - bottom - top) * (1 - fluidPercentage);
        float y = 8 + top + depth;
        float w = tankSlot == 1 ? 13.75f : 13.875f;
        float h = tankSlot == 1 ? 13.75f : 13.875f;
        float yBot = 8 - bottom + 16;
        Tessellator tessellator = Tessellator.instance;

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

        float vOffset = (icon.getMaxV() - icon.getMinV()) * (1 - fluidPercentage);
        float uOffset = 4f / 16f * (icon.getMaxU() - icon.getMinU());
        tessellator.startDrawingQuads();
        tessellator.setNormal(0, 0, -1);
        tessellator.setBrightness(lightLevel);
        tessellator.addVertexWithUV((double) (x + 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
        tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
        tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMaxU() - uOffset, icon.getMaxV());
        tessellator.addVertexWithUV((double) (x + 4) * f, (double) (yBot) * f, (double) (z + h) * f, (double) icon.getMinU() + uOffset, icon.getMaxV());
        

        tessellator.setNormal(0, 0, 1);
        tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (y) * f, (double) (z + 0) * f, (double) icon.getMinU() + uOffset, (double) icon.getMinV() + vOffset);
        tessellator.addVertexWithUV((double) (x +  4) * f, (double) (y) * f, (double) (z + 0) * f, (double) icon.getMaxU() - uOffset, (double) icon.getMinV() + vOffset);
        tessellator.addVertexWithUV((double) (x +  4) * f, (double) (yBot) * f, (double) (z + 0 ) * f, (double) icon.getMaxU() - uOffset, icon.getMaxV());
        tessellator.addVertexWithUV((double) (x + w - 4) * f, (double) (yBot) * f, (double) (z + 0 ) * f, (double) icon.getMinU() + uOffset, icon.getMaxV());
        tessellator.draw();

    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {

    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
        renderModelAnimated(null, f, null);
    }

}
