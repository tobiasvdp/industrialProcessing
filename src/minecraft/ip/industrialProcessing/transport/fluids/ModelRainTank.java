package ip.industrialProcessing.transport.fluids;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnectedOrientedFluid;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class ModelRainTank extends ModelConnectedOrientedFluid {

    public ModelRainTank() {
    }

    @Override
    public void renderModelConnectedOrientedFluid(TileEntity tl, float f, ForgeDirection forward, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down, int tankSlot, float fluidPercentage, Icon icon) {
        if (tankSlot == 0) {

            int dir = BlockMachine.getMetadataFromForward(BlockMachine.getForwardFromEntity(tl));

            GL11.glPushMatrix();
            GL11.glRotatef(90 * dir, 0, -1, 0);
            float x = -8f;
            float z = -8f;

            float height = 3.5f * fluidPercentage;
            float y = 12.0f - height;
            int w = 16;
            int h = 16;
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0, -1, 0);
            tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + 0) * f, icon.getMinU(), icon.getMinV());
            tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + 0) * f, icon.getMaxU(), icon.getMinV());
            tessellator.addVertexWithUV((double) (x + w) * f, (double) y * f, (double) (z + h) * f, icon.getMaxU(), icon.getMaxV());
            tessellator.addVertexWithUV((double) (x + 0) * f, (double) y * f, (double) (z + h) * f, icon.getMinU(), icon.getMaxV());
            tessellator.draw();
            GL11.glPopMatrix();
        }
    }

    @Override
    public void renderModelConnectedOriented(TileEntity tl, float f5, ForgeDirection forward, ConnectionState south, ConnectionState west, ConnectionState north, ConnectionState east, ConnectionState up, ConnectionState down) {

    }

}
