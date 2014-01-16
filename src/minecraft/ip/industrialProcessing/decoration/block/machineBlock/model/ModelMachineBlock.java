package ip.industrialProcessing.decoration.block.machineBlock.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import org.lwjgl.util.vector.Vector3f;

public class ModelMachineBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Hull(), 0);
    ObjRotator works = new ObjRotator(new Works(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconHull = block.getIcon(0, 0);
        Icon iconWorks = block.getIcon(1, 0);

        hull.getRotated(dir).renderMesh(iconHull);
        works.getRotated(dir).renderMesh(iconWorks);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
        int dir = reference.getBlockMetadata();

        Icon iconHull = reference.getIcon(0);
        Icon iconWorks = reference.getIcon(1);

        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        works.getRotated(dir).renderMesh(false, iconWorks, reference);
        return true;
    }

}
