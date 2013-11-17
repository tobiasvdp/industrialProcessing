package ip.industrialProcessing.transport.fluids.models.meter;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelManometerBlock extends ModelBlock {
	ObjRotator center = new ObjRotator(new ManometerCenter(), 1);
	ObjRotator cover = new ObjRotator(new ManometerCover(), 1);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {

		
		Vector3f position = new Vector3f(0, 0, 0);
		Icon icon = block.getIcon(0, 0);
        Icon icon2 = block.getIcon(1, 0);
		center.getRotated(0).renderMesh(icon);
        cover.getRotated(0).renderMesh(icon2);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		TileEntity entity = reference.getBlockTileEntity();
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);


		Icon icon = reference.getIcon(0);
		Icon icon2 = reference.getIcon(1);

		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);

		center.getRotated(dir).renderMesh(false, icon, reference);
		cover.getRotated(dir).renderMesh(false, icon2, reference);
 
		return true;
	}
}
