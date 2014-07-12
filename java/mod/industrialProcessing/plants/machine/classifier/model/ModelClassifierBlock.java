package mod.industrialProcessing.plants.machine.classifier.model;

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

import org.lwjgl.util.vector.Vector3f;

public class ModelClassifierBlock extends ModelBlock {

    ObjRotator features = new ObjRotator(new ClassifierFeatures(), 0);
    ObjRotator hull = new ObjRotator(new ClassifierHull(), 0);
    ObjRotator connectorSmall = new ObjRotator(new ClassifierSmallSideConnector(), 0);
    ObjRotator connectorBig = new ObjRotator(new ClassifierLargeSideConnector(), 0);
    ClassifierTopConnector connectorTop = new ClassifierTopConnector();

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	int dir = 0;

	Vector3f position = new Vector3f(0, 0, 0);
	IIcon iconFeatures = block.getIcon(0, 0);
	IIcon iconHull = block.getIcon(1, 0);

	features.getRotated(dir).renderMesh(iconFeatures);
	hull.getRotated(dir).renderMesh(iconHull);
	connectorTop.renderMesh(iconFeatures);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

	TileEntity entity = reference.getBlockTileEntity();
	ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
	int dir = 6 - BlockContainerIP.getMetadataFromForward(forward);

	IIcon iconFeatures = reference.getIcon(0);
	IIcon iconHull = reference.getIcon(1);
	IIcon iconPower = reference.getIcon(2);
	IIcon iconTank = reference.getIcon(3);

	features.getRotated(dir).renderMesh(false, iconTank, reference);
	connectorSmall.getRotated(dir).renderMesh(false, iconFeatures, reference);
	connectorSmall.getRotated(dir + 2).renderMesh(false, iconFeatures, reference);
	connectorBig.getRotated(dir ).renderMesh(false, iconPower, reference);
	connectorBig.getRotated(dir + 2).renderMesh(false, iconTank, reference);
	connectorTop.renderMesh(false, iconFeatures, reference);
	hull.getRotated(dir).renderMesh(false, iconHull, reference);

	return true;
    }

}
