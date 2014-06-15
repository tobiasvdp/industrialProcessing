package mod.industrialProcessing.plants.blackSmith.forge.model;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.block.obj.wavefront.ObjMesh;
import mod.industrialProcessing.client.rendering.tileEntity.ModelAnimatedMachine;
import mod.industrialProcessing.plants.blackSmith.forge.TileEntityForgeCore;
import mod.industrialProcessing.plants.blackSmith.tripHammer.dummy.woodenHammer.model.BloomIron;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class ModelForgeAnimated extends ModelAnimatedMachine {

	ObjMesh coal = new Coal();
	ObjMesh iron = new BloomIron();
	ObjMesh iron2 = new BloomIron();
	ObjMesh copper = new BloomIron();
	ObjMesh copper2 = new BloomIron();

	IIcon icon = new IIcon() {

		@Override
		public float getMinV() {
			return 0;
		}

		@Override
		public float getMinU() {
			return 0;
		}

		@Override
		public float getMaxV() {
			return 0.25f;
		}

		@Override
		public float getMaxU() {
			return 0.25f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}
	};

	IIcon iconIron = new IIcon() {

		@Override
		public float getMinV() {
			return 0;
		}

		@Override
		public float getMinU() {
			return 0.25f;
		}

		@Override
		public float getMaxV() {
			return 0.25f;
		}

		@Override
		public float getMaxU() {
			return 0.5f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}
	};

	IIcon iconIronHot = new IIcon() {

		@Override
		public float getMinV() {
			return 0f;
		}

		@Override
		public float getMinU() {
			return 0.5f;
		}

		@Override
		public float getMaxV() {
			return 0.25f;
		}

		@Override
		public float getMaxU() {
			return 0.75f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}
	};

	IIcon iconCopper = new IIcon() {

		@Override
		public float getMinV() {
			return 0.25f;
		}

		@Override
		public float getMinU() {
			return 0.25f;
		}

		@Override
		public float getMaxV() {
			return 0.5f;
		}

		@Override
		public float getMaxU() {
			return 0.5f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}
	};

	IIcon iconCopperHot = new IIcon() {

		@Override
		public float getMinV() {
			return 0.25f;
		}

		@Override
		public float getMinU() {
			return 0.5f;
		}

		@Override
		public float getMaxV() {
			return 0.5f;
		}

		@Override
		public float getMaxU() {
			return 0.75f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			return 0;
		}

		@Override
		public int getIconHeight() {
			return 0;
		}
	};

	@Override
	public void renderModelAnimated(TileEntity tileEntity, float f, float[] progressAr) {
		float progress = 0;
		if (progressAr != null && progressAr.length > 0)
			progress = progressAr[0];
		if (tileEntity instanceof TileEntityForgeCore) {
			TileEntityForgeCore core = (TileEntityForgeCore) tileEntity;
			if (core.getState() == MultiblockState.COMPLETED) {

				Vector3f position = new Vector3f(0, 0, 0);
				GL11.glPushMatrix();
				GL11.glRotatef(-180, 0, 0, 1);
				GL11.glTranslatef(0f, 0, -0.1f);
				if (core.getForwardDirection() == ForgeDirection.WEST || core.getForwardDirection() == ForgeDirection.EAST) {
					GL11.glRotatef(-180, 0, 1, 0);
					GL11.glTranslatef(0f, 0, -0.2f);
				}
				GL11.glTranslatef(0, (float) Math.min(Math.max(-0.3, (core.burnTime - 20000) / (float) 20000 * 0.3f), 0f), 0);
				coal.renderMesh(icon);

				ItemStack stack = core.getStackInSlot(1);
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0f, -0.3f, 0.0f);
				GL11.glTranslatef(0.0f, 0.5f, 0.0f);
				if (stack != null && stack.stackSize > 0) {
					if (stack.getItem().equals(IndustrialProcessing.itemPliersBloomIron))
						iron2.renderMesh(iconIronHot);
					if (stack.getItem().equals(IndustrialProcessing.itemPliersHeatedCopper))
						copper2.renderMesh(iconCopperHot);

				} else {
					stack = core.getStackInSlot(0);
					if (stack != null && stack.stackSize > 0) {
						if (stack.getItem().equals(IndustrialProcessing.itemWroughtIron))
							iron.renderMesh(iconIron);
						if (stack.getItem().equals(IndustrialProcessing.itemHeatedCopper))
							copper.renderMesh(iconCopper);
					}
				}
				GL11.glPopMatrix();

				GL11.glPopMatrix();
			}
		}
	}

	@Override
	public void renderModel(TileEntity tileEntity, float f) {
		renderModelAnimated(tileEntity, f, null);
	}

}
