package mod.industrialProcessing.plants.construction.machineBlock.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelMachineBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Hull(), 0);
    ObjRotator works = new ObjRotator(new Works(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        // TODO Auto-generated method stub
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconHull = block.getIcon(0, 0);
        IIcon iconWorks = block.getIcon(1, 0);

        hull.getRotated(dir).renderMesh(iconHull);
        works.getRotated(dir).renderMesh(iconWorks);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
    	 ForgeDirection forward = BlockContainerIP.getForwardFromEntity(reference.getBlockTileEntity());
         int dir = BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconHull = reference.getIcon(0);
        IIcon iconWorks = reference.getIcon(1);

        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        works.getRotated(dir).renderMesh(false, iconWorks, reference);
        return true;
    }

}
