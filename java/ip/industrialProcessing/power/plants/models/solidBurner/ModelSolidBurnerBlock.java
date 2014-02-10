package ip.industrialProcessing.power.plants.models.solidBurner;

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

public class ModelSolidBurnerBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new BurnerBody(), 0);
    BurnerTop top = new BurnerTop();
    ObjRotator features = new ObjRotator(new BurnerFeatures(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconFeatures = block.getIcon(0, 0);
        Icon iconHull = block.getIcon(1, 0);
        Icon iconTop = block.getIcon(2, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
        top.renderMesh(iconTop);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 4 - BlockMachine.getMetadataFromForward(forward);

        Icon iconFeatures = reference.getIcon(0);
        Icon iconHull = reference.getIcon(1);
        Icon iconTop = reference.getIcon(2);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        top.renderMesh(false, iconTop, reference);
        return true;
    }

}
