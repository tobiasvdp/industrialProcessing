package ip.industrialProcessing.machines.pelletExtruder.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine; 
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class ModelPelletExtruderBlock extends ModelBlock {
    ObjRotator hull = new ObjRotator(new ExtruderHull(), 0);
    ObjRotator features = new ObjRotator(new ExtruderFeatures(), 0);
    ObjRotator power = new ObjRotator(new ExtruderPowerConnector(), 0); 

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	int dir = 0;

	Icon iconFeatures = block.getIcon(0, 0);
	Icon iconHull = block.getIcon(1, 0); 
	Icon iconPower = block.getIcon(3, 0);

	features.getRotated(dir).renderMesh(iconFeatures);
	hull.getRotated(dir).renderMesh(iconHull);
	power.getRotated(dir).renderMesh(iconPower); 
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 5 - BlockMachine.getMetadataFromForward(forward);

	Icon iconFeatures = reference.getIcon(0);
	Icon iconHull = reference.getIcon(1); 
	Icon iconPower = reference.getIcon(3);

	features.getRotated(dir).renderMesh(false, iconFeatures, reference);
	hull.getRotated(dir).renderMesh(false, iconHull, reference);
	power.getRotated(dir).renderMesh(false, iconPower, reference); 
	return true;
    }

}
