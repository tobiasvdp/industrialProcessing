package ip.industrialProcessing.client.render;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.rendering.RendererTileEntity;
import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.displayPanel.TEmultiblockDisplayPanel;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderingMultiblock extends RendererTileEntity {

	private ModelingMultiblock[] model;

	public RenderingMultiblock(Block block, String name[], ModelingMultiblock model[]) {
		super(block, name[0], model[0]);
		this.model = model;
		this.name = name;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {

		if (world == null) {
			this.model[0].renderModel(null, 0.0625F);
		} else {

			if (tl instanceof TileEntityMultiblockDummy) {
				TileEntityMultiblockDummy tile = (TileEntityMultiblockDummy) tl;
				int modelID = tile.getModelID();
				int modelConnection = tile.getModelConnection();
				if (tl instanceof IAnimationProgress) {
					IAnimationProgress machine = (IAnimationProgress) tl;
					float[] animation = new float[machine.getAnimationCount()];
					for (int l = 0; l < animation.length; l++) {
						animation[l] = machine.getAnimationProgress(1f, l);
					}
					this.model[modelID].renderModel(0.0625F, modelConnection,animation);
				} else {
					this.model[modelID].renderModel(0.0625F, modelConnection);
				}
			} else if(tl instanceof TileEntityMultiblockCore){
				TileEntityMultiblockCore tile = (TileEntityMultiblockCore) tl;
				int modelID = tile.getModelID();
				int modelConnection = tile.getModelConnection();

				if (tl instanceof IAnimationProgress) {
					IAnimationProgress machine = (IAnimationProgress) tl;
					float[] animation = new float[machine.getAnimationCount()];
					for (int l = 0; l < animation.length; l++) {
						animation[l] = machine.getAnimationProgress(1f, l);
					}
					this.model[modelID].renderModel(0.0625F, modelConnection,animation);
				} else {
					this.model[modelID].renderModel(0.0625F, modelConnection);
				}
			}else{
				TEmultiblockDisplayPanel tile = (TEmultiblockDisplayPanel) tl;
				int modelID = tile.getModelID();
				int modelConnection = tile.getModelConnection();

				if (tl instanceof IAnimationProgress) {
					IAnimationProgress machine = (IAnimationProgress) tl;
					float[] animation = new float[machine.getAnimationCount()];
					for (int l = 0; l < animation.length; l++) {
						animation[l] = machine.getAnimationProgress(1f, l);
					}
					this.model[modelID].renderModel(0.0625F, modelConnection,animation);
				} else {
					this.model[modelID].renderModel(0.0625F, modelConnection);
				}
			}
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		ResourceLocation tex;
		if (tl instanceof TileEntityMultiblockDummy)
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TileEntityMultiblockDummy) tl).getModelID()] + ".png");
		else if(tl instanceof TileEntityMultiblockCore)
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TileEntityMultiblockCore) tl).getModelID()] + ".png");
		else
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TEmultiblockDisplayPanel) tl).getModelID()] + ".png");
		return tex;
	}

}
