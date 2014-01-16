package ip.industrialProcessing.multiblock.core.block.plants.storage.container.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelContainer extends ModelBlock {

    ObjRotator hull = new ObjRotator(new hull(), 0);
    ObjRotator container = new ObjRotator(new ContainerFull(), 0);

    @Override
    public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        int dir = 0;

        Vector3f position = new Vector3f(0, 0, 0);
        Icon iconHull = block.getIcon(0, 0);
        
        hull.getRotated(dir).renderMesh(iconHull);
    }

    @Override
    public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

    	TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
        int dir = BlockMachine.getMetadataFromForward(forward);
        TileEntityMultiblockCore core = (TileEntityMultiblockCore) entity;
        
        Icon iconHull = reference.getIcon(0);
        
        if(core.getState() ==MultiblockState.COMPLETED){
        	container.getRotated(dir).renderMesh(false, iconHull, reference);
        }else{
        	hull.getRotated(dir).renderMesh(false, iconHull, reference);
        }
        return true;
    }
}
