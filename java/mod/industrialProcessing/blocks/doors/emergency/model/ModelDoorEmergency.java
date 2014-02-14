package mod.industrialProcessing.blocks.doors.emergency.model;

import javax.swing.Icon;

import mod.industrialProcessing.blocks.doors.BlockDoor;
import mod.industrialProcessing.client.rendering.ModelBlock;
import mod.industrialProcessing.client.rendering.obj.wavefront.ObjRotatedTranslator;
import mod.industrialProcessing.client.rendering.obj.wavefront.WorldReference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelDoorEmergency extends ModelBlock {

	ObjRotatedTranslator doorBottom = new ObjRotatedTranslator(new DoorBottom(), 0,3);
	ObjRotatedTranslator doorTop = new ObjRotatedTranslator(new DoorTop(), 0,3);
	ObjRotatedTranslator foot = new ObjRotatedTranslator(new Foot(), 0,3);
	ObjRotatedTranslator glass = new ObjRotatedTranslator(new Glass(), 0,3);
	ObjRotatedTranslator lock = new ObjRotatedTranslator(new Lock(), 0,3);
	ObjRotatedTranslator pushBar = new ObjRotatedTranslator(new PushBar(), 0,3);
	ObjRotatedTranslator rectracter = new ObjRotatedTranslator(new Rectracter(), 0,3);

	
	public ModelDoorEmergency() {
		doorBottom.setTranslated(1, 0.5f, 0f, -0.47f);
		doorTop.setTranslated(1, 0.5f, 0f, -0.47f);
		foot.setTranslated(1, 0.5f, 0f, -0.47f);
		glass.setTranslated(1, 0.5f, 0f, -0.47f);
		lock.setTranslated(1, 0.5f,0f, -0.47f);
		pushBar.setTranslated(1, 0.5f, 0f, -0.47f);
		rectracter.setTranslated(1, 0.5f, 0f, -0.47f);
		
		doorBottom.setTranslated(2, 0.5f, 0f, 0.47f);
		doorTop.setTranslated(2, 0.5f, 0f, 0.47f);
		foot.setTranslated(2, 0.5f, 0f, 0.47f);
		glass.setTranslated(2, 0.5f, 0f, 0.47f);
		lock.setTranslated(2, 0.5f,0f, 0.47f);
		pushBar.setTranslated(2, 0.5f, 0f, 0.47f);
		rectracter.setTranslated(2, 0.5f, 0f, 0.47f);
	}
	
	@Override
	public void renderInventory(Block block, int metadata, int modelID, RenderBlocks renderer) {
		Vector3f position = new Vector3f(0, 0, 0);
		IIcon iconDoor = block.getIcon(0, 0);
		IIcon iconIron = block.getIcon(1, 0);
		IIcon iconLight = block.getIcon(2, 0);
		IIcon iconGlass = block.getIcon(3, 0);

		GL11.glPushMatrix();
		GL11.glScalef(0.7f, 0.7f, 0.7f);
		GL11.glTranslatef(0.0f, -0.5f, 0.0f);
		doorBottom.getRotated(0).renderMesh(iconDoor);
		foot.getRotated(0).renderMesh(iconLight);
		lock.getRotated(0).renderMesh(iconIron);
		pushBar.getRotated(0).renderMesh(iconIron);

		GL11.glTranslatef(0.0f, 1.0f, 0.0f);
		doorTop.getRotated(0).renderMesh(iconDoor);
		glass.getRotated(0).renderMesh(iconGlass);
		rectracter.getRotated(0).renderMesh(iconIron);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(WorldReference reference, int modelId, RenderBlocks renderer) {
		int dir = getRenderDir(reference.getBlockMetadata() % 4);
		int flipSide = 1;

		IIcon iconDoor = reference.getIcon(0);
		IIcon iconIron = reference.getIcon(1);
		IIcon iconLight = reference.getIcon(2);
		IIcon iconGlass = reference.getIcon(3);
		
		GL11.glPushMatrix();
		

		if (BlockDoor.isDoorOpen(reference.world, reference.x, reference.y, reference.z, reference.block)) {
			if(BlockDoor.isSideDoor(reference.world, reference.x, reference.y, reference.z, reference.block)){
				flipSide = 2;
			}
			dir = getLeftSide(dir);
			if (BlockDoor.isTopDoor(reference.world, reference.x, reference.y, reference.z, reference.block)) {
				doorTop.getRotated(flipSide,dir).renderMesh(false, iconDoor, reference);
				glass.getRotated(flipSide,dir).renderMesh(false, iconGlass, reference);
				rectracter.getRotated(flipSide,dir).renderMesh(false, iconIron, reference);
			} else {
				doorBottom.getRotated(flipSide,dir).renderMesh(false, iconDoor, reference);
				foot.getRotated(flipSide,dir).renderMesh(false, iconLight, reference);
				lock.getRotated(flipSide,dir).renderMesh(false, iconIron, reference);
				pushBar.getRotated(flipSide,dir).renderMesh(false, iconIron, reference);
			}
		}else{
			if(BlockDoor.isSideDoor(reference.world, reference.x, reference.y, reference.z, reference.block)){
				dir = flipDirection(dir);
			}
			if (BlockDoor.isTopDoor(reference.world, reference.x, reference.y, reference.z, reference.block)) {
				doorTop.getRotated(dir).renderMesh(false, iconDoor, reference);
				glass.getRotated(dir).renderMesh(false, iconGlass, reference);
				rectracter.getRotated(dir).renderMesh(false, iconIron, reference);
			} else {
				doorBottom.getRotated(dir).renderMesh(false, iconDoor, reference);
				foot.getRotated(dir).renderMesh(false, iconLight, reference);
				lock.getRotated(dir).renderMesh(false, iconIron, reference);
				pushBar.getRotated(dir).renderMesh(false, iconIron, reference);
			}
		}
		GL11.glPopMatrix();

		return true;
	}

	private int getRenderDir(int i) {
		if(i == 0)
			return 2;
		if(i == 2)
			return 0;
		return i;
	}

	private int getLeftSide(int dir) {
		switch(dir){
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 3;
		case 3:
			return 0;
		}
		return 0;
	}
	
	private int flipDirection(int dir){
		switch(dir){
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		case 4:
			return 0;
		}
		return 0;
	}
}