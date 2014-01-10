package ip.industrialProcessing.machines.diskFilter.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class ModelDiskFilterBlock extends ModelBlock {

    ConnectorBottom connectorBottom = new ConnectorBottom();
    ObjRotator connectorSide = new ObjRotator(new ConnectorSide(), 0);
    ConnectorTop connectorTop = new ConnectorTop();
    ObjRotator cylinder = new ObjRotator(new Cylinder(), 0);
    ObjRotator features = new ObjRotator(new Features(), 0);
    ObjRotator hull = new ObjRotator(new Hull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	Icon powerIcon = block.getIcon(0, 0);
	Icon hullIcon = block.getIcon(1, 0);
	Icon featuresIcon = block.getIcon(2, 0);
	Icon tankIcon = block.getIcon(3, 0);
	Icon cylinderIcon = block.getIcon(4, 0);

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
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 5 - BlockMachine.getMetadataFromForward(forward);

	Icon powerIcon = reference.getIcon(0);
	Icon hullIcon = reference.getIcon(1);
	Icon featuresIcon = reference.getIcon(2);
	Icon tankIcon = reference.getIcon(3);

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
