package ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.sinter.model.SinterFeatures;
import ip.industrialProcessing.machines.sinter.model.SinterFront;
import ip.industrialProcessing.machines.sinter.model.SinterHull;
import ip.industrialProcessing.machines.sinter.model.SinterPowerConnector;

public class ModelSandCasterBlock extends ModelBlock {

    ObjRotator hull = new ObjRotator(new ExtruderHull(), 0);
    ObjRotator features = new ObjRotator(new ExtruderFeatures(), 0);
    ObjRotator power = new ObjRotator(new ExtruderPowerConnector(), 0);
    ExtruderConnectorBottom bottomConnector = new ExtruderConnectorBottom();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	int dir = 0;

	Icon iconFeatures = block.getIcon(2, 0);
	Icon iconHull = block.getIcon(1, 0);
	Icon iconTankFeatures = block.getIcon(0, 0);
	Icon iconPower = block.getIcon(3, 0);

	features.getRotated(dir).renderMesh(iconTankFeatures);
	hull.getRotated(dir).renderMesh(iconHull);
	power.getRotated(dir).renderMesh(iconPower);
	bottomConnector.renderMesh(iconFeatures);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 5 - BlockMachine.getMetadataFromForward(forward);

	Icon iconFeatures = reference.getIcon(2);
	Icon iconHull = reference.getIcon(1);
	Icon iconTankFeatures = reference.getIcon(0);
	Icon iconPower = reference.getIcon(3);

	features.getRotated(dir).renderMesh(false, iconTankFeatures, reference);
	hull.getRotated(dir).renderMesh(false, iconHull, reference);
	power.getRotated(dir).renderMesh(false, iconPower, reference);
	bottomConnector.renderMesh(false, iconFeatures, reference);
	return true;
    }
}
