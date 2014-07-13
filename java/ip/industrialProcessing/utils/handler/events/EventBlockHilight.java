package ip.industrialProcessing.utils.handler.events;

import ip.industrialProcessing.microBlock.IMicroBlock;
import ip.industrialProcessing.microBlock.core.BlockMicroBlock;
import ip.industrialProcessing.microBlock.extend.centerBlock.BlockMicroBlockwithCenter;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class EventBlockHilight {

	Minecraft mc;

	@ForgeSubscribe
	public void blockHilight(DrawBlockHighlightEvent event) {
		if (event.player.worldObj.isRemote) {
			if (mc == null) {
				mc = Minecraft.getMinecraft();
			}
			Block block = Block.blocksList[event.player.worldObj.getBlockId(event.target.blockX, event.target.blockY, event.target.blockZ)];
			if (block instanceof BlockMicroBlock) {
				MovingObjectPosition hit = ((BlockMicroBlock) block).rayTroughBlock(event.player.worldObj, event.target.blockX, event.target.blockY, event.target.blockZ, event.player);
				if (hit != null) {
					ForgeDirection offset = BlockMicroBlock.sideToForge(hit.sideHit);
					int x = hit.blockX + offset.offsetX;
					int y = hit.blockY + offset.offsetY;
					int z = hit.blockZ + offset.offsetZ;
					int blockID = event.player.worldObj.getBlockId(x, y, z);
					if (Block.blocksList[blockID] instanceof BlockMicroBlock) {
						int invertedSide = BlockMicroBlock.invertSide(hit.sideHit);
						handleHit(x, y, z, invertedSide, hit, event);
					} else {
						handleMiss(event, hit);
					}

				}
				if (block instanceof BlockMicroBlock && !(block instanceof BlockMicroBlockwithCenter))
					event.setCanceled(true);
			}
		}

	}

	private void handleHit(int x, int y, int z, int side, MovingObjectPosition hit, DrawBlockHighlightEvent event) {

		IMicroBlock te = (IMicroBlock) event.player.worldObj.getBlockTileEntity(x, y, z);
		AxisAlignedBB box = null;
		if (!te.isSideFree(side)) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 0.8F, 0.0F, 0.4F);
			GL11.glLineWidth(2.0F);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(false);
			float f1 = 0.002F;
			double d0 = event.player.lastTickPosX + (event.player.posX - event.player.lastTickPosX) * event.partialTicks;
			double d1 = event.player.lastTickPosY + (event.player.posY - event.player.lastTickPosY) * event.partialTicks;
			double d2 = event.player.lastTickPosZ + (event.player.posZ - event.player.lastTickPosZ) * event.partialTicks;

			switch (side) {
			case 0:
				box = AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 0.15, z + 1);
				break;
			case 1:
				box = AxisAlignedBB.getBoundingBox(x, y + 0.85, z, x + 1, y + 1, z + 1);
				break;
			case 2:
				box = AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 0.15);
				break;
			case 3:
				box = AxisAlignedBB.getBoundingBox(x, y, z + 0.85, x + 1, y + 1, z + 1);
				break;
			case 4:
				box = AxisAlignedBB.getBoundingBox(x, y, z, x + 0.15, y + 1, z + 1);
				break;
			case 5:
				box = AxisAlignedBB.getBoundingBox(x + 0.85, y, z, x + 1, y + 1, z + 1);
				break;
			default:
				box = AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1);
			}
			this.drawOutlinedBoundingBox(box.expand(f1, f1, f1).getOffsetBoundingBox(-d0, -d1, -d2));

			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);

		} else {
			handleMiss(event, hit);
		}
	}

	private void handleMiss(DrawBlockHighlightEvent event, MovingObjectPosition hit) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(false);
		float f1 = 0.002F;
		int j = event.player.worldObj.getBlockId(hit.blockX, hit.blockY, hit.blockZ);

		if (j > 0) {
			Block.blocksList[j].setBlockBoundsBasedOnState(event.player.worldObj, hit.blockX, hit.blockY, hit.blockZ);
			double d0 = event.player.lastTickPosX + (event.player.posX - event.player.lastTickPosX) * event.partialTicks;
			double d1 = event.player.lastTickPosY + (event.player.posY - event.player.lastTickPosY) * event.partialTicks;
			double d2 = event.player.lastTickPosZ + (event.player.posZ - event.player.lastTickPosZ) * event.partialTicks;
			this.drawOutlinedBoundingBox(Block.blocksList[j].getSelectedBoundingBoxFromPool(event.player.worldObj, hit.blockX, hit.blockY, hit.blockZ).expand((double) f1, (double) f1, (double) f1).getOffsetBoundingBox(-d0, -d1, -d2));
		}

		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void drawOutlinedBoundingBox(AxisAlignedBB par1AxisAlignedBB) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(3);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
		tessellator.draw();
		tessellator.startDrawing(1);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.minZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.maxX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.minY, par1AxisAlignedBB.maxZ);
		tessellator.addVertex(par1AxisAlignedBB.minX, par1AxisAlignedBB.maxY, par1AxisAlignedBB.maxZ);
		tessellator.draw();
	}

}
