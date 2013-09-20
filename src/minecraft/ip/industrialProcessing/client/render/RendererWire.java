package ip.industrialProcessing.client.render;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RendererWire extends RendererTileEntity {
	private ModelWire model;
	private String name;

	public RendererWire(Block block, String name, ModelWire model) {
		super(block, name, model);
		this.model = model;
		this.name = name;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		if (world == null) {
			this.model.renderModel(f);
		} else {
			if (tl instanceof ICommunicationTransport) {
				ICommunicationTransport com = (ICommunicationTransport) tl;
				int side = 0;
				int[] connectedSide = new int[6];
				for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
					/*side[dir.ordinal()] = com.getPlacedSide(dir.ordinal());
					TileEntity te = world.getBlockTileEntity(i + dir.offsetX, j + dir.offsetY, k + dir.offsetZ);
					if (te instanceof ICommunication) {
						connectedSide[dir.ordinal()] = ((ICommunication) te).getPlacedSides();

					} else {
						connectedSide[dir.ordinal()] = null;

					}*/
				}
				this.model.renderModel(f, side, connectedSide);
			}
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		return texture;
	}

}
