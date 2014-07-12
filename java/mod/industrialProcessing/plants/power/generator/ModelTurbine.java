package mod.industrialProcessing.plants.power.generator;

import ip.industrialProcessing.client.render.ModelAnimatedFluidMachine;
import ip.industrialProcessing.power.plants.models.TurbineAxle;

import javax.swing.Icon;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelTurbine extends ModelAnimatedFluidMachine {

    TurbineAxle axle = new TurbineAxle();
    public ModelTurbine() {
    }

    @Override
    public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, Icon icon) {

        float par1 = -7f;
        float par2 = -7f;

        int lightLevel = tl.blockType.getMixedBrightnessForBlock(tl.worldObj, tl.xCoord, tl.yCoord, tl.zCoord);
        float height = 6.5f * percentageFilled;
        // float par3 = tankSlot == 0 ? 23 - 13/2 + height : 10f + height;

        float par3 = 23 - height;

        int par4 = 14;
        int par5 = 14;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setBrightness(lightLevel);
        tessellator.setNormal(0, -1, 0);
        tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMinU(), icon.getMinV());
        tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMaxU(), icon.getMinV());
        tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMaxU(), icon.getMaxV());
        tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMinU(), icon.getMaxV());
        tessellator.draw();
    }

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f5, float[] progress) {

        float angle = progress == null ? 0 : progress[0];
        Vector3f position = new Vector3f(0, 0, 0);
        GL11.glPushMatrix();
        GL11.glRotatef(-90, 0, 1, 0);
        GL11.glTranslatef(0, 1, 0);
        GL11.glRotatef(angle * 360, 1, 0, 0);
        Icon icon = getIcon();
        axle.renderMesh(icon); 
        GL11.glPopMatrix();
    }

    private Icon getIcon() {

        return new Icon() {

            @Override
            public float getMinV() {
                return 0;
            }

            @Override
            public float getMinU() {
                return 0;
            }

            @Override
            public float getMaxV() {
                return 1;
            }

            @Override
            public float getMaxU() {
                return 1;
            }

            @Override
            public float getInterpolatedV(double d0) {
                return (getMinV() + getMaxV()) * (float) d0 + getMinV();
            }

            @Override
            public float getInterpolatedU(double d0) {
                return (getMinU() + getMaxU()) * (float) d0 + getMinU();
            }

            @Override
            public String getIconName() {
                return "icon";
            }

			@Override
			public int getIconWidth() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getIconHeight() {
				// TODO Auto-generated method stub
				return 0;
			}
        };
    }
    @Override
    public void renderModel(TileEntity tileEntity, float f) {
        renderModelAnimated(null, f, new float[] { 0f });
    }

}
