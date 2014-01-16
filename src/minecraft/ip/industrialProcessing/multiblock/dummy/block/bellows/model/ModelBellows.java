package ip.industrialProcessing.multiblock.dummy.block.bellows.model;

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

public class ModelBellows extends ModelBlock {

    ObjRotator frame = new ObjRotator(new Frame(), 0);
    ObjRotator bellow = new ObjRotator(new Bellows(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconFrame = block.getIcon(0, 0);
        Icon iconBellow = block.getIcon(1, 0);

        frame.getRotated(0).renderMesh(iconFrame);
        bellow.getRotated(0).renderMesh(iconBellow);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);

        Icon iconFrame = reference.getIcon(0);
        Icon iconBellow = reference.getIcon(1);

        frame.getRotated(dir).renderMesh(false, iconFrame, reference);
        bellow.getRotated(dir).renderMesh(false, iconBellow, reference);
        return true;
    }
}
