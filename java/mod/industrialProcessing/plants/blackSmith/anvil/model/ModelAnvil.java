package mod.industrialProcessing.plants.blackSmith.anvil.model;

import javax.swing.Icon;

import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;

import org.lwjgl.util.vector.Vector3f;

public class ModelAnvil extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Box002(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconHull = block.getIcon(0, 0);

        hull.getRotated(dir).renderMesh(iconHull);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        int dir = reference.getBlockMetadata();

        IIcon iconHull = reference.getIcon(0);

        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        return true;
    }
}
