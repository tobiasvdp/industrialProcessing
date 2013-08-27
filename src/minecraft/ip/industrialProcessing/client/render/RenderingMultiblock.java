package ip.industrialProcessing.client.render;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.dummy.TEmultiblockDummy;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderingMultiblock extends RendererTileEntity{

	private ModelingMultiblock[] model;

	public RenderingMultiblock(Block block, String name[], ModelingMultiblock model[]) {
		super(block, name[0], model[0]);
		this.model = model;
		this.name = name;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {

		if (world == null) {
			this.model[0].renderModel(0.0625F);
		} else {
			
			if(tl instanceof TEmultiblockDummy){
				TEmultiblockDummy tile = (TEmultiblockDummy) tl;
				int modelID = tile.getModelID();
				int modelConnection = tile.getModelConnection();
				this.model[modelID].renderModel(0.0625F, modelConnection);
			}else{
				TEmultiblockCore tile = (TEmultiblockCore) tl;
				int modelID = tile.getModelID();
				int modelConnection = tile.getModelConnection();
				this.model[modelID].renderModel(0.0625F, modelConnection);
			}
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		ResourceLocation tex;
		if (tl instanceof TEmultiblockDummy)
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TEmultiblockDummy) tl).getModelID()] + ".png");
		else
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TEmultiblockCore) tl).getModelID()] + ".png");
		return tex;
	}

}
