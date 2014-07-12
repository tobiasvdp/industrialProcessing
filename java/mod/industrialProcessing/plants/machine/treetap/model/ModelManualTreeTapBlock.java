package mod.industrialProcessing.plants.machine.treetap.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.util.vector.Vector3f;

public class ModelManualTreeTapBlock extends ModelBlock {

    ObjRotator tap = new ObjRotator(new ManualTreeTap(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        IIcon icon = block.getIcon(0, 0);
        Vector3f position = new Vector3f(0, 0, 0);
        tap.getRotated(0).renderMesh(icon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        Tessellator tessellator = Tessellator.instance;
        tessellator.setColorOpaque(255, 255, 255);
        IIcon icon = reference.getIcon(0);
        TileEntity entity = reference.getBlockTileEntity();
        int dir = BlockContainerIP.getMetadataFromForward(BlockContainerIP.getForwardFromEntity(entity));

        tap.getRotated(2-dir).renderMesh(false, icon, reference);
        return true;
    }

}
