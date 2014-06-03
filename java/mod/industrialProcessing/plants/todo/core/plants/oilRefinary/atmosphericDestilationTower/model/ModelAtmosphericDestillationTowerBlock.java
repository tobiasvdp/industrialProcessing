package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.atmosphericDestilationTower.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelAtmosphericDestillationTowerBlock extends ModelBlock {

    
    ObjRotator features = new ObjRotator(new DestillationCore(), 0);
    ObjRotator hull = new ObjRotator(new DestillationCoreHull(), 0);
    DestillationCoreConnectors connectors = new DestillationCoreConnectors();
    
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
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
