package mod.industrialProcessing.power.models.solidBurner;

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

public class ModelSolidBurnerBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new BurnerBody(), 0);
    BurnerTop top = new BurnerTop();
    ObjRotator features = new ObjRotator(new BurnerFeatures(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconFeatures = block.getIcon(0, 0);
        IIcon iconHull = block.getIcon(1, 0);
        IIcon iconTop = block.getIcon(2, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
        top.renderMesh(iconTop);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = 4 - BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconFeatures = reference.getIcon(0);
        IIcon iconHull = reference.getIcon(1);
        IIcon iconTop = reference.getIcon(2);

        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        top.renderMesh(false, iconTop, reference);
        return true;
    }

}
