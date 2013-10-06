package ip.industrialProcessing.transport.fluids.models;

import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.transport.fluids.TileEntityTank;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class ModelTankBlock extends ModelBlock {

	TankBottom bottom = new TankBottom();
	TankBottomFeatures bottomFeatures = new TankBottomFeatures();

	TankTop top = new TankTop();
	TankTopFeatures topFeatures = new TankTopFeatures();

	TankCenter center = new TankCenter();
	TankCenterFeatures centerFeatures = new TankCenterFeatures();

	TankSingle single = new TankSingle();
	TankSingleFeatures singleFeatures = new TankSingleFeatures();

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
		single.renderMesh(true, icon, position);
		icon = block.getIcon(1, 0);
		singleFeatures.renderMesh(true, icon, position);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);

		if (entity instanceof TileEntityTank) {
			TileEntityTank tank = (TileEntityTank) entity;
			ConnectionState up = tank.getConnection(ForgeDirection.UP);
			ConnectionState down = tank.getConnection(ForgeDirection.DOWN);

			Icon tankIcon = reference.getIcon(0);
			Icon tankFeaturesIcon = reference.getIcon(1);

			if (up == ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
				center.renderMesh(false, tankIcon, reference);
				centerFeatures.renderMesh(false, tankFeaturesIcon, reference);
			} else if (up != ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
				single.renderMesh(false, tankIcon, reference);
				singleFeatures.renderMesh(false, tankFeaturesIcon, reference);
			} else if (up != ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
				top.renderMesh(false, tankIcon, reference);
				topFeatures.renderMesh(false, tankFeaturesIcon, reference);
			} else if (up == ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
				bottom.renderMesh(false, tankIcon, reference);
				bottomFeatures.renderMesh(false, tankFeaturesIcon, reference);
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
