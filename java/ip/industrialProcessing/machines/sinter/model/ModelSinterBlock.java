package ip.industrialProcessing.machines.sinter.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelSinterBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new SinterHull(), 0);
    ObjRotator front = new ObjRotator(new SinterFront(), 0);
    ObjRotator features = new ObjRotator(new SinterFeatures(), 0);
    ObjRotator power = new ObjRotator(new SinterPowerConnector(), 0);
    
    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

        int dir = 0;
 
        Icon iconFeatures = block.getIcon(0, 0);
        Icon iconHull = block.getIcon(1, 0);
        Icon iconSinter = block.getIcon(2, 0);
        Icon iconPower = block.getIcon(3, 0);

        features.getRotated(dir).renderMesh(iconFeatures);
        hull.getRotated(dir).renderMesh(iconHull);
        power.getRotated(dir).renderMesh(iconPower);
        front.getRotated(dir).renderMesh(iconSinter);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = 5 - BlockMachine.getMetadataFromForward(forward);

        Icon iconFeatures = reference.getIcon(0);
        Icon iconHull = reference.getIcon(1);
        Icon iconSinter = reference.getIcon(2);
        Icon iconPower = reference.getIcon(3);
        
        features.getRotated(dir).renderMesh(false, iconFeatures, reference);
        hull.getRotated(dir).renderMesh(false, iconHull, reference);
        power.getRotated(dir).renderMesh(false, iconPower, reference);
        front.getRotated(dir).renderMesh(false, iconSinter, reference);
	return true;
    }

}
