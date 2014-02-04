package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.power.plants.models.GeneratorAxle;
import ip.industrialProcessing.power.plants.models.GeneratorAxleRing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelGenerator extends ModelAnimatedMachine {

    GeneratorAxle axle = new GeneratorAxle();
    GeneratorAxleRing axleRing = new GeneratorAxleRing();

    @Override
    public void renderModelAnimated(TileEntity tileEntity, float f, float[] progress) {

        float angle = progress == null ? 0 : progress[0];
        Vector3f position = new Vector3f(0, 0, 0);
        GL11.glPushMatrix();
        GL11.glRotatef(-90, 0, 1, 0);
        GL11.glTranslatef(0, 1, 0);
        GL11.glRotatef(angle * 360, 1, 0, 0);
        Icon icon = getIcon(0);
        axle.renderMesh(icon);
        axleRing.renderMesh(icon);
        GL11.glPopMatrix();
    }

    private Icon getIcon(int j) {

        final int i = j;
        return new Icon() {

            @Override
            public float getMinV() {
                return 0 + i * 0.5f;
            }

            @Override
            public float getMinU() {
                return 0;
            }

            @Override
            public float getMaxV() {
                return 0.5f + i * 0.5f;
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
        renderModelAnimated(tileEntity, f, null);
    }

}
