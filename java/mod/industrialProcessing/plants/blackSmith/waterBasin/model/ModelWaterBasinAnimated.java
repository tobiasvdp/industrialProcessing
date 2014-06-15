package mod.industrialProcessing.plants.blackSmith.waterBasin.model;

import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedFluidMachine;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

public class ModelWaterBasinAnimated extends ModelAnimatedFluidMachine {

	@Override
	public void renderLiquid(TileEntity tl, float f, int tankSlot, float percentageFilled, IIcon icon) {
		// Vec3 p1 = new Vec3(-6.5F, -0.4666667F, -6.5F);//, 13, 0, 13

		IRotateableEntity rot = (IRotateableEntity) tl;
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) tl;
		ForgeDirection dir = rot.getForwardDirection();
		if (switcher.getState() == MultiblockState.COMPLETED) {
			if (tankSlot == 0) {
				float par1 = 0f;
				float par2 = 0f;
				if (dir == ForgeDirection.NORTH || dir == ForgeDirection.SOUTH) {
					if (switcher.isCore()) {
						par1 = -6f;
						par2 = -7f;
					} else {
						par1 = -8f;
						par2 = -7f;
					}
				} else if (dir == ForgeDirection.WEST || dir == ForgeDirection.EAST) {
					if (switcher.isCore()) {
						par1 = -8f;
						par2 = -7f;
					} else {
						par1 = -6f;
						par2 = -7f;
					}
				}

				float par3 = 10f + 5.5f * (1 - percentageFilled);
				int par4 = 14;
				int par5 = 14;
				int lightLevel = tl.blockType.getMixedBrightnessForBlock(tl.getWorldObj(), tl.xCoord, tl.yCoord, tl.zCoord);
				Tessellator tessellator = Tessellator.instance;
				tessellator.setColorOpaque(255, 255, 255);
				// GL11.glEnable(GL11.GL_BLEND);
				// GL11.glBlendFunc(GL11.GL_SRC_ALPHA,
				// GL11.GL_ONE_MINUS_SRC_ALPHA);

				tessellator.startDrawingQuads();
				tessellator.setNormal(0, -1, 0);
				tessellator.setBrightness(lightLevel);
				tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMinU(), icon.getMinV());
				tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + 0) * f, icon.getMaxU(), icon.getMinV());
				tessellator.addVertexWithUV((double) (par1 + par4) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMaxU(), icon.getMaxV());
				tessellator.addVertexWithUV((double) (par1 + 0) * f, (double) par3 * f, (double) (par2 + par5) * f, icon.getMinU(), icon.getMaxV());
				tessellator.draw();

				// GL11.glDisable(GL11.GL_BLEND);
			}
		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {

	}

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f, float[] progress) {

	}

}
