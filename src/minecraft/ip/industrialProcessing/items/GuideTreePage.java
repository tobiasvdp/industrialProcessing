package ip.industrialProcessing.items;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.machines.blastFurnace.TileEntityBlastFurnace;
import ip.industrialProcessing.machines.classifier.RecipesClassifier;
import ip.industrialProcessing.machines.classifier.TileEntityClassifier;
import ip.industrialProcessing.machines.crusher.RecipesCrusher;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.diskFilter.RecipesDiskFilter;
import ip.industrialProcessing.machines.diskFilter.TileEntityDiskFilter;
import ip.industrialProcessing.machines.dryer.RecipesDryer;
import ip.industrialProcessing.machines.dryer.TileEntityDryer;
import ip.industrialProcessing.machines.filter.RecipesFilter;
import ip.industrialProcessing.machines.filter.TileEntityFilter;
import ip.industrialProcessing.machines.mixer.RecipesMixer;
import ip.industrialProcessing.machines.mixer.TileEntityMixer;
import ip.industrialProcessing.machines.oxygenFurnace.TileEntityOxygenFurnace;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;
import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeSlotType;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;

public class GuideTreePage extends GuidePanoramaPage {

	RecipesMachine[] handlers = new RecipesMachine[] { TileEntityCrusher.recipes, TileEntityFilter.recipes, TileEntityMixer.recipes, TileEntityDryer.recipes, TileEntityClassifier.recipes, TileEntityDiskFilter.recipes, TileEntityPelletExtruder.recipes, TileEntityOxygenFurnace.recipes, TileEntityBlastFurnace.recipes };
	int[] blocks = new int[] { ConfigMachineBlocks.getCrusherBlockID(), ConfigMachineBlocks.getFilterBlockID(), ConfigMachineBlocks.getMixerBlockID(), ConfigMachineBlocks.getDryerBlockID(), ConfigMachineBlocks.getClassifierBlockID(), ConfigMachineBlocks.getDiskFilterBlockID(), ConfigMachineBlocks.getPelletExtruderID(), ConfigMachineBlocks.getBlastFurnaceID() };

	public GuideTreePage() {
		super(new Rectangle(0, 0, 246, 172), new Point(5, 25));
	}

	private HashSet<Integer> items = new HashSet<Integer>();

	@Override
	public String getTitle() {
		return "Ore Processing";
	}

	@Override
	protected void drawPane(int mouseX, int mouseY) {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		items.clear();
		GL11.glPushMatrix();
		GL11.glTranslatef(1, 1, 11);
		drawTree(new ItemStack(IndustrialProcessing.blockCopperOre), 16, 16, RecipeSlotType.INVENTORY, mouseX, mouseY);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
		GL11.glColor4d(1, 1, 1, 1);

	}

	private void drawStack(ItemStack stack, int x, int y, int mouseX, int mouseY) {
		if(stack == null) return;
		Minecraft mc = Minecraft.getMinecraft();
		GL11.glPushMatrix();
		GL11.glTranslatef(-1, -1, 11);
		drawRect(x - 1, y - 1, x + 17, y + 17, 0xff555555);
		drawRect(x, y , x + 17, y + 17, 0xffffffff);
		drawRect(x, y, x + 16, y + 16, 0xffc6c6c6);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.enableGUIStandardItemLighting();
		GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);

		Rectangle rect = new Rectangle(x,y,16,16);
		if(rect.contains(mouseX,mouseY))
		{
			ToolTip tip = new ToolTip(stack.getDisplayName());
			ToolTip.renderToolTip(tip, mouseX+16, mouseY, 10, mc.fontRenderer);
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
		GL11.glPopMatrix();
 
	}

	private int drawTree(ItemStack stack, int x, int y, RecipeSlotType type, int mouseX, int mouseY) {
		drawStack(stack, x, y, mouseX, mouseY);
		int dy = 0;
		int lineColor = 0xff555555;//0xffc6c6c6;
		int lineShadow = 0xffffffff;
		if (!items.contains(stack.itemID)) {
			items.add(stack.itemID);

			for (int i = 0; i < handlers.length; i++) { // handlers.length
				RecipesMachine handler = handlers[i];
				boolean hasRecipe = false;
				for (Iterator<Recipe> iterator = handler.iterator(); iterator.hasNext();) {
					Recipe recipe = iterator.next();
					for (int j = 0; j < recipe.inputs.length; j++) {
						int id = 0;
						if (type == RecipeSlotType.INVENTORY) {
							id = recipe.inputs[j].itemId;
						} else if (type == RecipeSlotType.TANK) {
							int fluidId = recipe.inputs[j].itemId;
							Fluid fluid = FluidRegistry.getFluid(fluidId);
							if (fluid == null)
								continue;
							id = fluid.getBlockID();
						}
						if (id == stack.itemID) {
							hasRecipe = true;
							for (int j2 = 0; j2 < recipe.outputs.length; j2++) {

								GL11.glPushMatrix();
								GL11.glTranslatef(-1, -1, -11);
								drawRect(x + 48 + 8, y + 8 + dy, x + 64, y + 9 + dy, lineColor);
								drawRect(x + 48 + 7, y + 8, x + 48 + 8, y + 9 + dy, lineColor);
								GL11.glPopMatrix();
								drawRect(x + 48 + 8, y + 8 + dy, x + 64, y + 9 + dy, lineShadow);
								drawRect(x + 48 + 7, y + 8, x + 48 + 8, y + 9 + dy, lineShadow);

								if (recipe.outputs[j2].type == RecipeSlotType.INVENTORY) {
									dy += drawTree(new ItemStack(recipe.outputs[j2].itemId, 0, 0), x + 64, y + dy + 0, RecipeSlotType.INVENTORY, mouseX, mouseY);
								} else if (recipe.outputs[j2].type == RecipeSlotType.TANK) {
									int fid = FluidRegistry.getFluid(recipe.outputs[j2].itemId).getBlockID();
									dy += drawTree(new ItemStack(fid, 0, 0), x + 64, y + dy + 0, RecipeSlotType.TANK, mouseX, mouseY);
								}
							}
						}
					}
				}
				if (hasRecipe) {
					drawStack(new ItemStack(blocks[i], 1, 0), x + 32, y + 16, mouseX, mouseY);
					GL11.glPushMatrix();
					GL11.glTranslatef(-1, -1, -11);
					drawRect(x + 40, y + 40, x + 48 + 8, y + 41, lineColor);
					drawRect(x + 40, y + 32, x + 41, y + 40, lineColor);
					drawRect(x + 39 + 16, y + 8, x + 40 + 16, y + 40, lineColor);

					drawRect(x + 16, y + 8, x + 32 + 8, y + 9, lineColor);
					drawRect(x + 40, y + 8, x + 41, y + 16, lineColor);
					GL11.glPopMatrix();
					drawRect(x + 40, y + 40, x + 48 + 8, y + 41, lineShadow);
					drawRect(x + 40, y + 32, x + 41, y + 40, lineShadow);
					drawRect(x + 39 + 16, y + 8, x + 40 + 16, y + 40, lineShadow);

					drawRect(x + 16, y + 8, x + 32 + 8, y + 9, lineShadow);
					drawRect(x + 40, y + 8, x + 41, y + 16, lineShadow);
				}
			}
		}
		return 64 + Math.min(dy, 0);
	}

	@Override
	public Point getIconLocation() {
		return null;
	}

	@Override
	public ItemStack getIconStack() {
		return new ItemStack(IndustrialProcessing.itemSmallMachineCasing);
	}

}
