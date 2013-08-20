package ip.industrialProcessing.client.render;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.block.frame.BlockMachineFrame;
import ip.industrialProcessing.multiblock.block.frame.TileEntityMachineFrame;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RendererMultiblock extends RendererTileEntity {

	private ModelMultiblock[] model;

	public RendererMultiblock(Block block, String name[], ModelMultiblock model[]) {
		super(block, name[0], model[0]);
		this.model = model;
		this.name = name;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {

		if (world == null) {
			this.model[0].render(0.0625F);
		} else {
			
			if(tl instanceof TileEntityMultiblockBlock){
				TileEntityMultiblockBlock tile = (TileEntityMultiblockBlock) tl;
				int modelID = tile.modelID;
				if (tile.getState() == MultiblockState.CONNECTED) {
					modelID = 0;
				}
				if (modelID != 3) {
					this.model[modelID].renderModelSides(0.0625F, tile.getConnectedSides());
				}
			}else{
				TileEntityMultiblockCore tile = (TileEntityMultiblockCore) tl;
				int modelID = tile.modelID;
				if (tile.getState() == MultiblockState.CONNECTED) {
					modelID = 0;
				}
				if (modelID != 3) {
					this.model[modelID].renderModelSides(0.0625F, tile.getConnectedSides());
				}
			}
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		ResourceLocation tex;
		if (tl instanceof TileEntityMultiblockBlock)
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TileEntityMultiblockBlock) tl).modelID] + ".png");
		else
			tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[((TileEntityMultiblockCore) tl).modelID] + ".png");
		return tex;
	}

}
