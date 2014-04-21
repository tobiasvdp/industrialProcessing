package mod.industrialProcessing.plants.machine.diskFilter.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelDiskFilterBlock extends ModelBlock {

    ConnectorBottom connectorBottom = new ConnectorBottom();
    ObjRotator connectorSide = new ObjRotator(new ConnectorSide(), 0);
    ConnectorTop connectorTop = new ConnectorTop();
    ObjRotator cylinder = new ObjRotator(new Cylinder(), 0);
    ObjRotator features = new ObjRotator(new Features(), 0);
    ObjRotator hull = new ObjRotator(new Hull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	IIcon powerIcon = block.getIcon(0, 0);
	IIcon hullIcon = block.getIcon(1, 0);
	IIcon featuresIcon = block.getIcon(2, 0);
	IIcon tankIcon = block.getIcon(3, 0);
	IIcon cylinderIcon = block.getIcon(4, 0);

	connectorBottom.renderMesh(featuresIcon);
	connectorTop.renderMesh(featuresIcon);
	hull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(featuresIcon);
	connectorSide.getRotated(0).renderMesh(powerIcon);
	cylinder.getRotated(0).renderMesh(cylinderIcon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
	int dir = 5 - BlockContainerIP.getMetadataFromForward(forward);
	
	IIcon powerIcon = reference.getIcon(0);
	IIcon hullIcon = reference.getIcon(1);
	IIcon featuresIcon = reference.getIcon(2);
	IIcon tankIcon = reference.getIcon(3);

	connectorBottom.renderMesh(false, tankIcon, reference);
	connectorTop.renderMesh(false, tankIcon, reference);
	hull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, featuresIcon, reference);
	connectorSide.getRotated(dir).renderMesh(false, powerIcon, reference);
	connectorSide.getRotated(dir + 1).renderMesh(false, tankIcon, reference);
	connectorSide.getRotated(dir + 2).renderMesh(false, featuresIcon, reference); 
	connectorSide.getRotated(dir + 3).renderMesh(false, tankIcon, reference);
	return true;
    }

}
