package mod.industrialProcessing.plants.machine.hydroCyclone.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelHydroCycloneBlock  extends ModelBlock {

    ObjRotator features = new ObjRotator(new HydroFeatures(), 0);
    ObjRotator hull = new ObjRotator(new HydroCone(), 0);
    ObjRotator connector = new ObjRotator(new FluidConnector(), 0);
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconFeatures = block.getIcon(0, 0);
        IIcon iconHull = block.getIcon(1, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = 6 - BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconFeatures = reference.getIcon(0);
        IIcon iconHull = reference.getIcon(1);
        IIcon iconPower = reference.getIcon(2);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        connector.getRotated(dir).renderMesh(false, iconFeatures, reference);
        connector.getRotated(dir+2).renderMesh(false, iconPower, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference); 

        return true;
    }

}
