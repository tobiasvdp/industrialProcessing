package ip.industrialProcessing.multiblock.core.block.blastFurnace.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

public class ModelBlastFurnaceTopBlock extends ModelBlock {

    ObjRotator fluidConnector = new ObjRotator(new FluidConnector(), 0);
    ObjRotator itemConnector = new ObjRotator(new ItemConnector(), 0);
    IntakeTop inputUp = new IntakeTop();
    ObjRotator grill = new ObjRotator(new Grill(), 0); 
    ObjRotator topHull = new ObjRotator(new TopHull(), 0);
    ConnectorFillerBottom filler = new ConnectorFillerBottom();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
	// TODO Auto-generated method stub

	Icon fillerIcon = block.getIcon(0, 0);
	Icon hullIcon = block.getIcon(1, 0);
	Icon featuresIcon = block.getIcon(2, 0);
	Icon tankFeatures = block.getIcon(3, 0); 

	filler.renderMesh(fillerIcon);
	inputUp.renderMesh(featuresIcon);
	topHull.getRotated(0).renderMesh(hullIcon);  
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = BlockMachine.getMetadataFromForward(forward);

	Icon fillerIcon = reference.getIcon(0);
	Icon hullIcon = reference.getIcon(1);
	Icon featuresIcon = reference.getIcon(2);
	Icon tankFeaturesIcon = reference.getIcon(3); 

	filler.renderMesh(false, fillerIcon, reference);
	inputUp.renderMesh(false, tankFeaturesIcon, reference);
	topHull.getRotated(dir).renderMesh(false, hullIcon, reference);  
	itemConnector.getRotated(dir+1).renderMesh(false, featuresIcon, reference);
	itemConnector.getRotated(dir+3).renderMesh(false, featuresIcon, reference);
	return true;
    }

}
