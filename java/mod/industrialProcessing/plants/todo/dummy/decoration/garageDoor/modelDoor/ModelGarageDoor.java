package mod.industrialProcessing.plants.todo.dummy.decoration.garageDoor.modelDoor;

import ip.industrialProcessing.api.rendering.wavefront.ObjRotator;
import ip.industrialProcessing.api.rendering.wavefront.WorldReference;
import ip.industrialProcessing.client.render.ModelBlock;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorDoor;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.util.vector.Vector3f;

public class ModelGarageDoor extends ModelBlock {

	ObjRotator box = new ObjRotator(new Box001(), 0);
	ObjRotator front = new ObjRotator(new Object001(), 0);
	ObjRotator back = new ObjRotator(new Object002(), 0);
	ObjRotator left = new ObjRotator(new LeftBar(), 0);
	ObjRotator right = new ObjRotator(new RightBar(), 0);

	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		Icon iconGarage = block.getIcon(0, 0);

		box.getRotated(0).renderMesh(iconGarage);
		front.getRotated(0).renderMesh(iconGarage);
		back.getRotated(0).renderMesh(iconGarage);
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {

		TileEntity entity = reference.getBlockTileEntity();
		ForgeDirection forward = BlockMachine.getForwardFromEntity(entity);
		int dir = BlockMachine.getMetadataFromForward(forward);

		Icon iconGarage = reference.getIcon(0);
		Icon iconIron = reference.getIcon(1);
		
		if (forward != null) {
			forward = TileEntityMultiblockCore.ForgeToFacingDirectionForge(forward);
			
			ForgeDirection dirLeft = forward.getRotation(ForgeDirection.UP);
			if (reference.world.getBlockId(reference.x + dirLeft.offsetX, reference.y + dirLeft.offsetY, reference.z + dirLeft.offsetZ) == 0 || reference.world.isBlockSolidOnSide(reference.x + dirLeft.offsetX, reference.y + dirLeft.offsetY, reference.z + dirLeft.offsetZ, dirLeft.getOpposite(), true)) {
				right.getRotated(dir).renderMesh(false, iconIron, reference);
			}

			ForgeDirection dirRight = forward.getRotation(ForgeDirection.DOWN);
			if (reference.world.getBlockId(reference.x + dirRight.offsetX, reference.y + dirRight.offsetY, reference.z + dirRight.offsetZ) == 0 || reference.world.isBlockSolidOnSide(reference.x + dirRight.offsetX, reference.y + dirRight.offsetY, reference.z + dirRight.offsetZ, dirRight.getOpposite(), true)) {
				left.getRotated(dir).renderMesh(false, iconIron, reference);
			}
		}
		if (!((TileEntityGarageDoorDoor) entity).hide) {
			box.getRotated(dir).renderMesh(false, iconGarage, reference);
			front.getRotated(dir).renderMesh(false, iconGarage, reference);
			back.getRotated(dir).renderMesh(false, iconGarage, reference);
		}
		return true;
	}
}
