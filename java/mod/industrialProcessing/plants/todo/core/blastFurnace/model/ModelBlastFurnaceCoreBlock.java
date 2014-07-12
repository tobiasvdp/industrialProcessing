package mod.industrialProcessing.plants.todo.core.blastFurnace.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelBlastFurnaceCoreBlock extends ModelBlock {

    ObjRotator fluidConnector = new ObjRotator(new FluidConnector(), 0);
    ObjRotator itemConnector = new ObjRotator(new ItemConnector(), 0);
    FluidOutputDown outputDown = new FluidOutputDown();
    ObjRotator grill = new ObjRotator(new Grill(), 0);
    ObjRotator features = new ObjRotator(new Features(), 0);
    ObjRotator bottomHull = new ObjRotator(new BottomHull(), 0);
    ConnectorFillerTop filler = new ConnectorFillerTop();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
	// TODO Auto-generated method stub

	Icon fillerIcon = block.getIcon(0, 0);
	Icon hullIcon = block.getIcon(1, 0);
	Icon featuresIcon = block.getIcon(2, 0);
	Icon grillIcon = block.getIcon(4, 0);
	Icon powerIcon = block.getIcon(5,0);

	filler.renderMesh(fillerIcon);
	outputDown.renderMesh(featuresIcon);
	bottomHull.getRotated(0).renderMesh(hullIcon);
	features.getRotated(0).renderMesh(featuresIcon);
	grill.getRotated(0).renderMesh(grillIcon);
	itemConnector.getRotated(0).renderMesh(featuresIcon);
	itemConnector.getRotated(2).renderMesh(featuresIcon);
	
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 1 + BlockMachine.getMetadataFromForward(forward);

	Icon fillerIcon = reference.getIcon(0);
	Icon hullIcon = reference.getIcon(1);
	Icon featuresIcon = reference.getIcon(2);
	Icon fluidIcon = reference.getIcon(3);
	Icon grillIcon = reference.getIcon(4);
	Icon powerIcon = reference.getIcon(5);

	filler.renderMesh(false, fillerIcon, reference);
	outputDown.renderMesh(false, fluidIcon, reference);
	bottomHull.getRotated(dir).renderMesh(false, hullIcon, reference);
	features.getRotated(dir).renderMesh(false, featuresIcon, reference);
	grill.getRotated(dir).renderMesh(false, grillIcon, reference);
	itemConnector.getRotated(dir+3).renderMesh(false, fluidIcon, reference); 
	return true;
    }

}
