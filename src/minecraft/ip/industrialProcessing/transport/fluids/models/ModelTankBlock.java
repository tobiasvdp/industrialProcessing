package ip.industrialProcessing.transport.fluids.models;

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

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		Vector3f position = new Vector3f(0, 0, 0);
		Icon icon = block.getIcon(0, 0);
		single.renderMesh(true, icon, position);
		icon = block.getIcon(1, 0);
		singleFeatures.renderMesh(true, icon, position);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque(255, 255, 255);

		if (entity instanceof TileEntityTank) {
			TileEntityTank tank = (TileEntityTank) entity;
			ConnectionState up = tank.getConnection(ForgeDirection.UP);
			ConnectionState down = tank.getConnection(ForgeDirection.DOWN);
			Vector3f position = new Vector3f(x, y, z);

			Icon tankIcon = block.getIcon(0, 0);
			Icon tankFeaturesIcon = block.getIcon(1, 0);

			if (up == ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
				center.renderMesh(false, tankIcon, position);
				centerFeatures.renderMesh(false, tankFeaturesIcon, position);
			} else if (up != ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
				single.renderMesh(false, tankIcon, position);
				singleFeatures.renderMesh(false, tankFeaturesIcon, position);
			} else if (up != ConnectionState.CONNECTED && down == ConnectionState.CONNECTED) {
				top.renderMesh(false, tankIcon, position);
				topFeatures.renderMesh(false, tankFeaturesIcon, position);
			} else if (up == ConnectionState.CONNECTED && down != ConnectionState.CONNECTED) {
				bottom.renderMesh(false, tankIcon, position);
				bottomFeatures.renderMesh(false, tankFeaturesIcon, position);
			}
		}
		return false;
	}

}
