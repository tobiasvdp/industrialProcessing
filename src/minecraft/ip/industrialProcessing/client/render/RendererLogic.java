package ip.industrialProcessing.client.render;

import ip.industrialProcessing.logic.transport.ICommunication;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RendererLogic extends RendererTileEntity {
	private ModelLogic model;
	private String name;

	public RendererLogic(Block block, String name, ModelLogic model) {
		super(block, name, model);
		this.model = model;
		this.name = name;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		if (world == null) {
			this.model.renderModel(f);
		} else {
			if (tl instanceof ICommunication) {
				ICommunication com = (ICommunication) tl;
				boolean[][] notificationLights = new boolean[6][3];
				boolean[] side = new boolean[6];
				boolean[][] connectedSide = new boolean[6][1];
				for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
					side[dir.ordinal()] = com.getPlacedSide(dir.ordinal());
					TileEntity te = world.getBlockTileEntity(i+dir.offsetX, j+dir.offsetY, k+dir.offsetZ);
					if(te instanceof ICommunication){
						connectedSide[dir.ordinal()] = ((ICommunication)te).getPlacedSides();
					}else{
						connectedSide[dir.ordinal()] = null;
					}
					notificationLights[dir.ordinal()][0] = com.isSideConnected(dir);
					notificationLights[dir.ordinal()][1] = com.isSideValid(dir);
					notificationLights[dir.ordinal()][2] = com.hasSideActivity(dir);
				}
				this.model.renderModel(f,side,connectedSide, notificationLights);
			}
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		return texture;
	}

}