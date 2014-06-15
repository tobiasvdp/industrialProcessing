package mod.industrialProcessing.plants.construction.frame.model;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.core.TileEntityMultiblockCore;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelFrame extends ModelBlock {
	
	ObjRotator[] meshes = new ObjRotator[]{new ObjRotator(new Box002(),0),new ObjRotator(new Box003(),0),new ObjRotator(new Box004(),0),new ObjRotator(new Box005(),0),new ObjRotator(new Box006(),0),new ObjRotator(new Box007(),0),new ObjRotator(new Box008(),0),new ObjRotator(new Box009(),0),new ObjRotator(new Box010(),0),new ObjRotator(new Box011(),0),new ObjRotator(new Box012(),0),new ObjRotator(new Box013(),0),new ObjRotator(new Box014(),0),new ObjRotator(new Box015(),0),new ObjRotator(new Box016(),0),new ObjRotator(new Box017(),0),new ObjRotator(new Box018(),0),new ObjRotator(new Box019(),0)};

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
        Vector3f position = new Vector3f(0, 0, 0);
        
        IIcon icon = block.getIcon(0, 0);
        for(ObjRotator box:meshes){
        	box.getRotated(0).renderMesh(icon);
        }
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
        ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
        int dir = BlockContainerIP.getMetadataFromForward(forward);
        
        IIcon icon = reference.getIcon(0);

        for(ObjRotator box:meshes){
        	 box.getRotated(dir).renderMesh(false, icon, reference);
        }

        return true;
	}

}
