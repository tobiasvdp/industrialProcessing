package mod.industrialProcessing.plants.blackSmith.bloomery.dummy.bellows.model;

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

public class ModelBellows extends ModelBlock {

    ObjRotator frame = new ObjRotator(new Frame(), 0);
    ObjRotator bellow = new ObjRotator(new Bellows(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconFrame = block.getIcon(0, 0);
        IIcon iconBellow = block.getIcon(1, 0);

        frame.getRotated(0).renderMesh(iconFrame);
        bellow.getRotated(0).renderMesh(iconBellow);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconFrame = reference.getIcon(0);
        IIcon iconBellow = reference.getIcon(1);

        frame.getRotated(dir).renderMesh(false, iconFrame, reference);
        bellow.getRotated(dir).renderMesh(false, iconBellow, reference);
        return true;
    }
}
