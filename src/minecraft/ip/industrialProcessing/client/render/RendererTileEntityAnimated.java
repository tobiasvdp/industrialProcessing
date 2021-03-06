package ip.industrialProcessing.client.render;

import ip.industrialProcessing.api.rendering.RendererTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RendererTileEntityAnimated extends RendererTileEntity {

	private ModelAnimatedMachine model;

	public RendererTileEntityAnimated(Block block, String name, ModelAnimatedMachine model) {
		super(block, name, model);
		this.model = model;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		float[] animation = null;

		if (tl instanceof IAnimationProgress) {
			IAnimationProgress machine = (IAnimationProgress) tl;
			animation = new float[machine.getAnimationCount()];
			for (int l = 0; l < animation.length; l++) {
				animation[l] = machine.getAnimationProgress(1f, l);
			}
		}
		/*
		 * Place your rendering code here.
		 */
		this.model.renderModelAnimated(tl, 0.0625F, animation);
	}
}
