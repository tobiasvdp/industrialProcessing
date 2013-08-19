package ip.industrialProcessing.client.render;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.multiblock.TileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.block.frame.BlockMachineFrame;
import ip.industrialProcessing.multiblock.block.frame.TileEntityMachineFrame;
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
		if (world == null){
			this.model[0].renderModelSides(0.0625F,((TileEntityMultiblockBlock) tl).getConnectedSides());
		}else{
			TileEntityMultiblockBlock tile = (TileEntityMultiblockBlock) world.getBlockTileEntity(i, j, k);
			int modelID = tile.modelID;
			this.model[modelID].renderModelSides(0.0625F,tile.getConnectedSides());
		}
	}

	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		ResourceLocation tex = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name[0] + ".png");
		return tex;
	}

}
