package ip.industrialProcessing.machines.thickener.model;

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
import ip.industrialProcessing.machines.flotationCell.model.FlotationCellFeatures;
import ip.industrialProcessing.machines.flotationCell.model.FlotationCellHull;

public class ModelThickenerBlock  extends ModelBlock {

    ObjRotator features = new ObjRotator(new ThickenerFeatures(), 0);
    ObjRotator hull = new ObjRotator(new ThickenerHull(), 0);
    ObjRotator connector = new ObjRotator(new ThickenerSideConnector(), 0);
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconFeatures = block.getIcon(0, 0);
        Icon iconHull = block.getIcon(1, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 6 - BlockMachine.getMetadataFromForward(forward);

        Icon iconFeatures = reference.getIcon(0);
        Icon iconHull = reference.getIcon(1);
        Icon iconPower = reference.getIcon(2);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        connector.getRotated(dir+2).renderMesh(false, iconFeatures, reference);
        connector.getRotated(dir).renderMesh(false, iconPower, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference); 

        return true;
    }

}
