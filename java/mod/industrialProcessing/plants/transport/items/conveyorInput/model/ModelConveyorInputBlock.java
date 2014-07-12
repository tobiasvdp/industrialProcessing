package mod.industrialProcessing.plants.transport.items.conveyorInput.model;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelConveyorInputBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new ImporterHull(), 0);
    ObjRotator features = new ObjRotator(new ImporterFeatures(), 0);
    ObjRotator parts = new ObjRotator(new ImporterParts(), 0);
    

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	IIcon hullIcon = block.getIcon(0, 0);
	IIcon featuresIcon = block.getIcon(1, 0);
	IIcon partsIcon = block.getIcon(2, 0);

	hull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(featuresIcon);
	parts.getRotated(0).renderMesh(partsIcon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
	int dir = 5 - BlockContainerIP.getMetadataFromForward(forward);

	IIcon hullIcon = reference.getIcon(0);
	IIcon featuresIcon = reference.getIcon(1);
	IIcon partsIcon = reference.getIcon(2);

	hull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, featuresIcon, reference);
	parts.getRotated(dir).renderMesh(false, partsIcon, reference);

	return true;
    }

}
