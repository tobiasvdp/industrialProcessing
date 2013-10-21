package ip.industrialProcessing.transport.fluids.models.pump;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelPumpBlock extends ModelBlock {

    ObjRotator features = new ObjRotator(new PumpFeatures(), 0);
    ObjRotator hull = new ObjRotator(new PumpHull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconFeatures = block.getIcon(0, 0);
        Icon iconHull = block.getIcon(1, 0);

        features.getRotated(dir).renderMesh(true, iconFeatures, position);
        hull.getRotated(dir).renderMesh(true, iconHull, position);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 7 - BlockMachine.getMetadataFromForward(forward);

        Icon iconFeatures = reference.getIcon(0);
        Icon iconHull = reference.getIcon(1);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);

        return true;
    }

}
