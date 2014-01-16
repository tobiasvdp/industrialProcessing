package ip.industrialProcessing.transport.fluids;

import ip.industrialProcessing.client.render.ModelAnimatedMachine;
import ip.industrialProcessing.transport.fluids.models.pump.PumpAxle;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelPump extends ModelAnimatedMachine {

    PumpAxle axle = new PumpAxle();

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
            public int getOriginY() {
                return 0;
            }

            @Override
            public int getOriginX() {
                return 0;
            }

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
        };
    }

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
        renderModelAnimated(null, f, new float[] { 0f });
    }

}
