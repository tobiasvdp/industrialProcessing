package ip.industrialProcessing.machines.treetap.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.util.vector.Vector3f;

public class ModelAutomaticTreeTapBlock extends ModelBlock {

    ObjRotator tap = new ObjRotator(new AutomaticTreeTap(), 0);
    ObjRotator tank = new ObjRotator(new AutomaticTreeTapTank(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        Icon icon = block.getIcon(0, 0);
        Icon icon2 = block.getIcon(1, 0);
        Vector3f position = new Vector3f(0, 0, 0);
        tap.getRotated(0).renderMesh(icon);
        tank.getRotated(0).renderMesh(icon2);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);
        Icon icon = reference.getIcon(0);
        Icon icon2 = reference.getIcon(1);
        TileEntity entity = reference.getBlockTileEntity();
        int dir = BlockMachine.getMetadataFromForward(BlockMachine.getForwardFromEntity(entity));

        tap.getRotated(2 - dir).renderMesh(false, icon, reference);
        tank.getRotated(2 - dir).renderMesh(false, icon2, reference);
        return true;
    }
}
