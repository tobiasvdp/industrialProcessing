package mod.industrialProcessing.transport.fluids.models.block.raintank;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import mod.industrialProcessing.plants.transport.fluids.rainTank.TileEntityRainTank;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelRainTankBlock extends ModelBlock {

    ObjRotator corners = new ObjRotator(new RainTankCorner(), 0);
    ObjRotator sides = new ObjRotator(new RainTankSide(), 0);
    ObjRotator pipeSide = new ObjRotator(new RainTankPipeSide(), 0);
    RainTankPipeDown pipeDown = new RainTankPipeDown();
    RainTankPipeCenter pipeCenter = new RainTankPipeCenter();
    RaintankFrame frame = new RaintankFrame();
    RainTankBottom bottom = new RainTankBottom();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon icon = block.getIcon(0, 0);
        IIcon icon1 = block.getIcon(1, 0);
        IIcon icon2 = block.getIcon(2, 0);
        frame.renderMesh(icon);
        bottom.renderMesh(icon1);
        for (int i = 0; i < 4; i++) {
            corners.getRotated(i).renderMesh(icon1);
            sides.getRotated(i).renderMesh(icon1);
        }
        pipeCenter.renderMesh(icon2);
        pipeDown.renderMesh(icon2);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
        TileEntity entity = reference.getBlockTileEntity();
        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);

        Block id = reference.block;
        IIcon icon = reference.getIcon(0);
        IIcon icon1 = reference.getIcon(1);
        IIcon icon2 = reference.getIcon(2);

        if (entity instanceof TileEntityRainTank) {
            TileEntityRainTank tank = (TileEntityRainTank) entity;
            ConnectionState down = tank.getConnection(ForgeDirection.DOWN);

            boolean pipe = false;
            if (down == ConnectionState.PLUGGED) {
                pipe = true;
                pipeDown.renderMesh(false, icon2, reference);
            }
            ConnectionState[] states = new ConnectionState[4];
            for (int i = 2; i < 6; i++) {
                ForgeDirection direction = ForgeDirection.getOrientation(i);
                ConnectionState side = tank.getConnection(direction);
                int dir = 6 - BlockContainerIP.getMetadataFromForward(direction);
                states[dir % 4] = side;
                if (side == ConnectionState.PLUGGED) {
                    pipeSide.getRotated(dir).renderMesh(false, icon2, reference);
                    pipe = true;
                }
                if (side != ConnectionState.CONNECTED) {
                    sides.getRotated(dir).renderMesh(false, icon1, reference);
                    corners.getRotated(dir).renderMesh(false, icon1, reference);
                    corners.getRotated(dir - 1).renderMesh(false, icon1, reference);
                }
            }

            for (int i = 0; i < states.length; i++) {
                int i2 = (i + 1) % 4;
                if (states[i] == ConnectionState.CONNECTED && states[i2] == ConnectionState.CONNECTED) {
                    if (checkDiagonal(i, reference, id))
                        corners.getRotated(i).renderMesh(false, icon1, reference);
                }
            }

            if (pipe)
                pipeCenter.renderMesh(false, icon2, reference);

            frame.renderMesh(false, icon, reference);

            bottom.renderMesh(false, icon1, reference);
        }
        return true;
    }

    final int[][] diagonals = new int[][] { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

    private boolean checkDiagonal(int i, WorldReference reference, Block blockId) {

        int[] diagonal = diagonals[i % 4];
        Block other = reference.world.getBlock(reference.x + diagonal[0], reference.y, reference.z + diagonal[1]);
        return other != blockId;
    }

}
