package ip.industrialProcessing.transport.items.conveyorPacker.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelConveyorPackerBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new Hull(), 0);
    ObjRotator features = new ObjRotator(new PackerFeatures(), 0);
    ObjRotator parts = new ObjRotator(new PackerParts(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	Icon hullIcon = block.getIcon(0, 0);
	Icon featuresIcon = block.getIcon(1, 0);
	Icon partsIcon = block.getIcon(2, 0);

	hull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(featuresIcon);
	parts.getRotated(0).renderMesh(partsIcon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 5 - BlockMachine.getMetadataFromForward(forward);

	Icon hullIcon = reference.getIcon(0);
	Icon featuresIcon = reference.getIcon(1);
	Icon partsIcon = reference.getIcon(2);

	hull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, featuresIcon, reference);
	parts.getRotated(dir).renderMesh(false, partsIcon, reference);

	return true;
    }

}
