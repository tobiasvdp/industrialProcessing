package ip.industrialProcessing.multiblock.dummy.block.screen.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelScreen extends ModelBlock {

    ObjRotator left = new ObjRotator(new ScreenLeft(), 0);
    ObjRotator right = new ObjRotator(new ScreenRight(), 0);
    ObjRotator screen = new ObjRotator(new Screen(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconIron = block.getIcon(0, 0);

        screen.getRotated(0).renderMesh(iconIron);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();

        Icon iconIron = reference.getIcon(0);

        if(renderConnection == 1)
        	left.getRotated(dir).renderMesh(false, iconIron, reference);
        else
        	right.getRotated(dir).renderMesh(false, iconIron, reference);
        return true;
    }
}
