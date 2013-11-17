package ip.industrialProcessing.multiblock.dummy.block.destilationTray.model;

import org.lwjgl.util.vector.Vector3f;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

public class ModelDistillationElementBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new DestillationElementHull(), 0);
    ObjRotator features = new ObjRotator(new DestillationElementFeatures(), 0);
    DestillationConnectors connectors = new DestillationConnectors();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconFeatures = block.getIcon(0, 0);
        Icon iconHull = block.getIcon(1, 0);
        Icon iconTop = block.getIcon(2, 0);

        features.getRotated(0).renderMesh(iconFeatures);
        hull.getRotated(0).renderMesh(iconHull);
        connectors.renderMesh(iconTop);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);

        Icon iconFeatures = reference.getIcon(0);
        Icon iconHull = reference.getIcon(1);
        Icon iconTop = reference.getIcon(2);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        connectors.renderMesh(false, iconTop, reference);
        return true;
    }

}
