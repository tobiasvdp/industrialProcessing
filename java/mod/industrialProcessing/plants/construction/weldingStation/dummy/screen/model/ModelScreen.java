package mod.industrialProcessing.plants.construction.weldingStation.dummy.screen.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelScreen extends ModelBlock {

    ObjRotator left = new ObjRotator(new ScreenLeft(), 0);
    ObjRotator right = new ObjRotator(new ScreenRight(), 0);
    ObjRotator screen = new ObjRotator(new Screen(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) { 
        Vector3f position = new Vector3f(0, 0, 0);
        IIcon iconIron = block.getIcon(0, 0);

        screen.getRotated(0).renderMesh(iconIron);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

        TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);
        int renderConnection = ((TileEntityMultiblockDummy) entity).getModelConnection();

        IIcon iconIron = reference.getIcon(0);

        if(renderConnection == 1)
        	left.getRotated(dir).renderMesh(false, iconIron, reference);
        else
        	right.getRotated(dir).renderMesh(false, iconIron, reference);
        return true;
    }
}
