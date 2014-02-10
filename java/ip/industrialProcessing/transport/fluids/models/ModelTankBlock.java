package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.fluids.TileEntityTank;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ModelTankBlock extends ModelBlock {

    ObjRotator bottom = new ObjRotator(new TankBottom(), 0);
    ObjRotator bottomFeatures = new ObjRotator(new TankBottomFeatures(), 0);

    ObjRotator top = new ObjRotator(new TankTop(), 0);
    ObjRotator topFeatures = new ObjRotator(new TankTopFeatures(), 0);

    ObjRotator center = new ObjRotator(new TankCenter(), 0);
    ObjRotator centerFeatures = new ObjRotator(new TankCenterFeatures(), 0);

    ObjRotator single = new ObjRotator(new TankSingle(), 0);
    ObjRotator singleFeatures = new ObjRotator(new TankSingleFeatures(), 0);

    TankConnector[] connector = new TankConnector[6];

    public ModelTankBlock() {

	Matrix4f rotation = Matrix4f.rotate((float) Math.PI / 2, new Vector3f(0, 1, 0), new Matrix4f(), null);

	connector[ForgeDirection.EAST.ordinal()] = new TankConnector();

	connector[ForgeDirection.NORTH.ordinal()] = (TankConnector) connector[ForgeDirection.EAST.ordinal()].cloneTransformed(rotation);
	connector[ForgeDirection.WEST.ordinal()] = (TankConnector) connector[ForgeDirection.NORTH.ordinal()].cloneTransformed(rotation);
	connector[ForgeDirection.SOUTH.ordinal()] = (TankConnector) connector[ForgeDirection.WEST.ordinal()].cloneTransformed(rotation);

	connector[ForgeDirection.UP.ordinal()] = new TankConnectorUp();
	connector[ForgeDirection.DOWN.ordinal()] = new TankConnectorDown();
    }

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

	Vector3f position = new Vector3f(0, 0, 0);
	Icon icon = block.getIcon(0, 0);
	single.getRotated(0).renderMesh(icon);
	icon = block.getIcon(1, 0);
	singleFeatures.getRotated(0).renderMesh(icon);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
	TileEntity entity = reference.getBlockTileEntity();
	Tessellator tessellator = Tessellator.instance;
	tessellator.setColorOpaque(255, 255, 255);

	ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
	int dir = 4 - BlockMachine.getMetadataFromForward(forward);

	if (entity instanceof TileEntityTank) {
	    TileEntityTank tank = (TileEntityTank) entity;
	    ConnectionState up = tank.getConnection(ForgeDirection.UP);
	    ConnectionState down = tank.getConnection(ForgeDirection.DOWN);

	    Icon tankIcon = reference.getIcon(0);
	    Icon tankFeaturesIcon = reference.getIcon(1);
	    System.out.println("ModelTankBlock.renderWorldBlock()+ " + reference.x + " " + reference.y + " " + reference.z+ " u:"+up+" d:"+down);
	    if (up == ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
		center.getRotated(dir).renderMesh(false, tankIcon, reference);
		centerFeatures.getRotated(dir).renderMesh(false, tankFeaturesIcon, reference);
	    } else if (up != ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
		single.getRotated(dir).renderMesh(false, tankIcon, reference);
		singleFeatures.getRotated(dir).renderMesh(false, tankFeaturesIcon, reference);
	    } else if (up != ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
		top.getRotated(dir).renderMesh(false, tankIcon, reference);
		topFeatures.getRotated(dir).renderMesh(false, tankFeaturesIcon, reference);
	    } else if (up == ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
		bottom.getRotated(dir).renderMesh(false, tankIcon, reference);
		bottomFeatures.getRotated(dir).renderMesh(false, tankFeaturesIcon, reference);
	    }

	    for (int i = 0; i < 6; i++) {
		ConnectionState con = tank.getConnection(ForgeDirection.getOrientation(i));
		if (con == ConnectionState.PLUGGED)
		    connector[i].renderMesh(false, tankFeaturesIcon, reference);
	    }
	}
	return true;
    }

}
