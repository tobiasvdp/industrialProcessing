package ip.industrialProcessing.transport.fluids.models.pipe;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.IConnectedTile;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.transport.fluids.BlockTransportFluidsStone;
import ip.industrialProcessing.transport.fluids.BlockTransportFluidsWood;
import ip.industrialProcessing.transport.fluids.TileEntityTank;

public class ModelPipeBlock extends ModelBlock {

    ObjRotator side = new ObjRotator(new EndSide(), 0);
    EndUp up = new EndUp();
    EndDown down = new EndDown();
    ObjRotator straightHorizontal = new ObjRotator(new StraightHorizontal(), 0);
    StraightVertical straightVertical = new StraightVertical();
    Center center = new Center();
    ConnectorTop capUp = new ConnectorTop();
    ConnectorBottom capDown = new ConnectorBottom();
    ObjRotator cap = new ObjRotator(new ConnectorSide(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        Vector3f position = new Vector3f(0, 0, 0);
        Icon icon = block.getIcon(0, 0);
        capUp.renderMesh(true, icon, position);
        capDown.renderMesh(true, icon, position);
        if (block instanceof BlockTransportFluidsWood || block instanceof BlockTransportFluidsStone) {
            Icon caseIcon = getIcon(block, metadata);
            if (caseIcon != null) {
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                Tessellator tes = Tessellator.instance;

                tes.startDrawingQuads();
                tes.setNormal(-1, 0, 0);
                renderer.renderFaceXNeg(block, 0, 0, 0, caseIcon);
                tes.draw();

                tes.startDrawingQuads();
                tes.setNormal(1, 0, 0);
                renderer.renderFaceXPos(block, 0, 0, 0, caseIcon);
                tes.draw();

                tes.startDrawingQuads();
                tes.setNormal(0, 1, 0);
                renderer.renderFaceYPos(block, 0, 0, 0, caseIcon);
                tes.draw();

                tes.startDrawingQuads();
                tes.setNormal(0, -1, 0);
                renderer.renderFaceYNeg(block, 0, 0, 0, caseIcon);
                tes.draw();

                tes.startDrawingQuads();
                tes.setNormal(0, 0, 1);
                renderer.renderFaceZPos(block, 0, 0, 0, caseIcon);
                tes.draw();

                tes.startDrawingQuads();
                tes.setNormal(0, 0, -1);
                renderer.renderFaceZNeg(block, 0, 0, 0, caseIcon);
                tes.draw();
                GL11.glPopMatrix();
            }
        } else {
            straightVertical.renderMesh(true, icon, position);
        }
    }

    private Icon getIcon(Block block, int meta) {
        if (block instanceof BlockTransportFluidsWood)
            return Block.planks.getIcon(0, meta);
        else if (block instanceof BlockTransportFluidsStone) {
            switch (meta) {
            case 0:
                return Block.stone.getIcon(0, 0);
            case 1:
                return Block.cobblestone.getIcon(0, 0);
            case 2:
                return Block.cobblestoneMossy.getIcon(0, 0);
            case 3:
                return Block.stoneBrick.getIcon(0, 0);
            case 4:
                return Block.stoneBrick.getIcon(0, 1);
            case 5:
                return Block.stoneBrick.getIcon(0, 2);
            case 6:
                return Block.stoneBrick.getIcon(0, 3);
            case 7:
                return Block.brick.getIcon(0, 0);
            default:
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
        TileEntity entity = reference.getBlockTileEntity();
        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);

        if (reference.block instanceof BlockTransportFluidsWood || reference.block instanceof BlockTransportFluidsStone) {
            renderer.renderAllFaces = true;
            Icon icon = reference.getIcon(0);
            renderer.overrideBlockTexture = getIcon(reference.block, reference.getBlockMetadata());
            renderer.renderStandardBlock(reference.block, reference.x, reference.y, reference.z);

            if (entity instanceof IConnectedTile) {
                IConnectedTile tile = (IConnectedTile) entity;
                ConnectionState up = tile.getConnection(ForgeDirection.UP);
                ConnectionState down = tile.getConnection(ForgeDirection.DOWN);
                ConnectionState north = tile.getConnection(ForgeDirection.NORTH);
                ConnectionState east = tile.getConnection(ForgeDirection.EAST);
                ConnectionState south = tile.getConnection(ForgeDirection.SOUTH);
                ConnectionState west = tile.getConnection(ForgeDirection.WEST);
                if (up.isConnected())
                    this.capUp.renderMesh(false, icon, reference);
                if (down.isConnected())
                    this.capDown.renderMesh(false, icon, reference);
                if (north.isConnected())
                    this.cap.getRotated(0).renderMesh(false, icon, reference);
                if (west.isConnected())
                    this.cap.getRotated(1).renderMesh(false, icon, reference);
                if (south.isConnected())
                    this.cap.getRotated(2).renderMesh(false, icon, reference);
                if (east.isConnected())
                    this.cap.getRotated(3).renderMesh(false, icon, reference);
            }
        } else {

            Icon icon = reference.getIcon(0);
            if (entity instanceof IConnectedTile) {
                IConnectedTile tile = (IConnectedTile) entity;
                ConnectionState up = tile.getConnection(ForgeDirection.UP);
                ConnectionState down = tile.getConnection(ForgeDirection.DOWN);
                ConnectionState north = tile.getConnection(ForgeDirection.NORTH);
                ConnectionState east = tile.getConnection(ForgeDirection.EAST);
                ConnectionState south = tile.getConnection(ForgeDirection.SOUTH);
                ConnectionState west = tile.getConnection(ForgeDirection.WEST);
                if (up.isConnected() && down.isConnected() && !north.isConnected() && !south.isConnected() && !east.isConnected() && !west.isConnected()) {
                    straightVertical.renderMesh(false, icon, reference);
                } else if (!up.isConnected() && !down.isConnected() && north.isConnected() && south.isConnected() && !east.isConnected() && !west.isConnected()) {
                    straightHorizontal.getRotated(0).renderMesh(false, icon, reference);
                } else if (!up.isConnected() && !down.isConnected() && !north.isConnected() && !south.isConnected() && east.isConnected() && west.isConnected()) {
                    straightHorizontal.getRotated(1).renderMesh(false, icon, reference);
                } else {
                    if (up.isConnected())
                        this.up.renderMesh(false, icon, reference);
                    if (down.isConnected())
                        this.down.renderMesh(false, icon, reference);
                    if (north.isConnected())
                        this.side.getRotated(0).renderMesh(false, icon, reference);
                    if (west.isConnected())
                        this.side.getRotated(1).renderMesh(false, icon, reference);
                    if (south.isConnected())
                        this.side.getRotated(2).renderMesh(false, icon, reference);
                    if (east.isConnected())
                        this.side.getRotated(3).renderMesh(false, icon, reference);
                    center.renderMesh(false, icon, reference);
                }

                if (up.isPlugged())
                    this.capUp.renderMesh(false, icon, reference);
                if (down.isPlugged())
                    this.capDown.renderMesh(false, icon, reference);
                if (north.isPlugged())
                    this.cap.getRotated(0).renderMesh(false, icon, reference);
                if (west.isPlugged())
                    this.cap.getRotated(1).renderMesh(false, icon, reference);
                if (south.isPlugged())
                    this.cap.getRotated(2).renderMesh(false, icon, reference);
                if (east.isPlugged())
                    this.cap.getRotated(3).renderMesh(false, icon, reference);
            }
        }
        return true;
    }

}
