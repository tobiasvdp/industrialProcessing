package mod.industrialProcessing.plants.machine.sinter.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelSinterBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new SinterHull(), 0);
    ObjRotator front = new ObjRotator(new SinterFront(), 0);
    ObjRotator features = new ObjRotator(new SinterFeatures(), 0);
    ObjRotator power = new ObjRotator(new SinterPowerConnector(), 0);
    
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;
 
        IIcon iconFeatures = block.getIcon(0, 0);
        IIcon iconHull = block.getIcon(1, 0);
        IIcon iconSinter = block.getIcon(2, 0);
        IIcon iconPower = block.getIcon(3, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
        power.getRotated(dir).renderMesh(iconPower);
        front.getRotated(dir).renderMesh(iconSinter);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = 5 - BlockContainerIP.getMetadataFromForward(forward);

        IIcon iconFeatures = reference.getIcon(0);
        IIcon iconHull = reference.getIcon(1);
        IIcon iconSinter = reference.getIcon(2);
        IIcon iconPower = reference.getIcon(3);
        
        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        power.getRotated(dir).renderMesh(false, iconPower, reference);
        front.getRotated(dir).renderMesh(false, iconSinter, reference);
	return true;
    }

}
