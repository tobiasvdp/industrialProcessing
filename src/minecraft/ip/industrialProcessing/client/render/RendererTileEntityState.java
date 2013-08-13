package ip.industrialProcessing.client.render;

import ip.industrialProcessing.machines.TileEntityMachine;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class RendererTileEntityState extends RendererTileEntity {

    private ModelStateMachine[] model;

    public RendererTileEntityState(Block block, String name, ModelStateMachine[] model) {
	super(block, name, model[0]);
	this.model = model;
    }

    @Override
    protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
	int m = 0;
	if (world != null){
		if (((TileEntityMachine)tl).isDummyBlock)
			m = 1;
	}
	this.model[m].renderModel(0.0625F); 
    }

}
