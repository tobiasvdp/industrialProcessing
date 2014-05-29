package mod.industrialProcessing.transport.fluids.models.block.meter;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjRotator;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelManometerBlock extends ModelBlock {
	ObjRotator center = new ObjRotator(new ManometerCenter(), 1);
	ObjRotator cover = new ObjRotator(new ManometerCover(), 1);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		
		Vector3f position = new Vector3f(0, 0, 0);
		IIcon icon = block.getIcon(0, 0);
		IIcon icon2 = block.getIcon(1, 0);
		center.getRotated(0).renderMesh(icon);
        cover.getRotated(0).renderMesh(icon2);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);


		IIcon icon = reference.getIcon(0);
		IIcon icon2 = reference.getIcon(1);

		ForgeDirection forward = BlockContainerIP.getForwardFromEntity(entity);
		int dir = BlockContainerIP.getMetadataFromForward(forward);

		center.getRotated(dir).renderMesh(false, icon, reference);
		cover.getRotated(dir).renderMesh(false, icon2, reference);
 
		return true;
	}
}
