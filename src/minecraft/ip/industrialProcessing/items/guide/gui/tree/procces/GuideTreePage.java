package ip.industrialProcessing.items.guide.gui.tree.procces;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.render.gui.GuiTools;
import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.config.ISetupBlocks;
import ip.industrialProcessing.config.ISetupItems;
import ip.industrialProcessing.items.guide.gui.GuiGuide;
import ip.industrialProcessing.items.guide.gui.GuidePanoramaPage;
import ip.industrialProcessing.items.guide.gui.machines.old.GuideBlockRecipes;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.recipes.IRecipeBlock;
import ip.industrialProcessing.recipes.Recipe;
import ip.industrialProcessing.recipes.RecipeSlotType;
import ip.industrialProcessing.utils.registry.BlockRegistry;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

import org.lwjgl.opengl.GL11;

public class GuideTreePage extends GuidePanoramaPage {
 

    private static ItemStack[] baseStacks = new ItemStack[] { new ItemStack(IndustrialProcessing.blockRutile), new ItemStack(IndustrialProcessing.blockCinnebar), new ItemStack(IndustrialProcessing.blockChromiteOre), new ItemStack(IndustrialProcessing.blockCopperOre), new ItemStack(IndustrialProcessing.blockGalenaOre), new ItemStack(IndustrialProcessing.blockTinOre), new ItemStack(IndustrialProcessing.blockTaliaOre), new ItemStack(Block.oreGold), new ItemStack(Block.oreIron), new ItemStack(ItemCoal.coal) };

    ArrayList<GuideBlockRecipes> blockRecipes = new ArrayList<GuideBlockRecipes>();

    private ItemStack selectedStack;
    private ItemStack hoverStack;
    private boolean mouseInside;

    public GuideTreePage() {
	super(new Rectangle(0, 0, 246 - 32, 178), new Point(5 + 32, 18));
	this.selectedStack = new ItemStack(ISetupBlocks.blockCopperOre);

	Block[] machines = BlockRegistry.getMachinesArray();
	for (int i = 0; i < machines.length; i++) {

	    Block machine = machines[i];
	    if (machine instanceof IRecipeBlock) {
		IRecipeBlock recipeBlock = (IRecipeBlock) machine;
		GuideBlockRecipes recipe = new GuideBlockRecipes();
		recipe.block = machine;
		recipe.recipes = recipeBlock.getRecipes();

		this.blockRecipes.add(recipe);
	    }
	}
    }

    @Override
    public String getTitle() {
	return "Ore Processing";
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, int x, int y) {

	this.hoverStack = null;
	super.drawScreen(mouseX, mouseY, x, y);
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	for (int i = 0; i < baseStacks.length; i++) {
	    int ix = i % 2;
	    int iy = i / 2;
	    drawStack(baseStacks[i], x + 8 + ix * 16, y + 32 + iy * 16, mouseX, mouseY, true, true);
	}
	GL11.glDisable(GL11.GL_DEPTH_TEST);
    }

    @Override
    protected void drawPane(int mouseX, int mouseY, boolean mouseInside) {
	this.mouseInside = mouseInside;
	GL11.glEnable(GL11.GL_DEPTH_TEST);
	GL11.glPushMatrix();
	GL11.glTranslatef(1, 1, 11);
	HashSet<Integer> items = new HashSet<Integer>();
	if (this.selectedStack != null)
	    drawTree(this.selectedStack, 16, 16, getType(this.selectedStack), mouseX, mouseY, items);
	GL11.glDisable(GL11.GL_DEPTH_TEST);
	GL11.glPopMatrix();
	GL11.glColor4d(1, 1, 1, 1);
    }

    private RecipeSlotType getType(ItemStack stack) {
	if (stack == null)
	    return RecipeSlotType.INVENTORY;
	if (Block.blocksList.length > stack.itemID) {
	    Block block = Block.blocksList[stack.itemID];
	    if (block instanceof IFluidBlock)
		return RecipeSlotType.TANK;
	    return RecipeSlotType.INVENTORY;
	} else {
	    return RecipeSlotType.INVENTORY;
	}
    }

    @Override
    public void mouseClicked(int x, int y, int par3) {
	super.mouseClicked(x, y, par3);
	if (this.hoverStack != null) {
	    this.selectedStack = this.hoverStack;
	    this.offsetX = 0;
	    this.offsetY = 0;
	}
    }

    private void drawStack(ItemStack stack, int x, int y, int mouseX, int mouseY, boolean clickAble, boolean tooltip) {
	if (stack == null)
	    return;
	try {
	    Minecraft mc = Minecraft.getMinecraft();
	    GL11.glPushMatrix();
	    GL11.glTranslatef(-1, -1, 11);
	    // drawRect(x - 1, y - 1, x + 17, y + 17, HIGHLIGT_COLOR);
	    GL11.glPushMatrix();
	    drawRect(x, y, x + 16, y + 16, FILL_COLOR);
	    GL11.glTranslatef(1, 1, -20);
	    drawRect(x, y, x + 16, y + 16, SHADOW_COLOR);
	    GL11.glPopMatrix();

	    GL11.glEnable(GL11.GL_LIGHTING);
	    RenderHelper.enableGUIStandardItemLighting();
	    GuiTools.drawItemStack(stack, x, y, null, GuiGuide.itemRenderer, mc.fontRenderer, mc.renderEngine);

	    Rectangle rect = new Rectangle(x, y, 16, 16);
	    if (tooltip && rect.contains(mouseX, mouseY)) {
		ToolTip tip = new ToolTip(stack.getDisplayName() + ":" + stack.itemID);
		ToolTip.renderToolTip(tip, mouseX + 16, mouseY, 10, mc.fontRenderer);
		if (clickAble)
		    this.hoverStack = stack;
	    }
	    GL11.glDisable(GL11.GL_LIGHTING);
	    RenderHelper.disableStandardItemLighting();
	    GL11.glPopMatrix();
	} catch (NullPointerException e) {
	    ToolTip tip = new ToolTip("ERROR: " + stack.itemID);
	    ToolTip.renderToolTip(tip, x, y, 10, mc.fontRenderer);
	}
    }

    private int drawTree(ItemStack stack, int x, int y, RecipeSlotType type, int mouseX, int mouseY, HashSet<Integer> items) {
	drawStack(stack, x, y, mouseX, mouseY, true, this.mouseInside);
	int dy = 0;
	if (!items.contains(stack.itemID)) {
	    items.add(stack.itemID);

	    for (int machineIndex = 0; machineIndex < blockRecipes.size(); machineIndex++) { // handlers.length

		int ddy = drawMachine(x + 32, y + dy, stack, type, mouseX, mouseY, machineIndex, items);
		if (ddy > 0) {
		    drawVerticalLineShadowed(x + 22, y + 6, y + dy + 8);
		}
		dy += ddy;
	    }

	    int ddy = drawCrafting(x + 32, y + dy, stack, type, mouseX, mouseY, items);
	    if (ddy > 0) {
		drawVerticalLineShadowed(x + 22, y + 6, y + dy + 8);
	    }
	    dy += ddy;

	    ddy = drawFurnace(x + 32, y + dy, stack, type, mouseX, mouseY, items);
	    if (ddy > 0) {
		drawVerticalLineShadowed(x + 22, y + 6, y + dy + 8);
	    }
	    dy += ddy;
	    if (dy > 0) {
		drawHorizontalLineShadowed(x + 15, y + 7, x + 22);
	    }
	} else {
	    drawHorizontalLineShadowed(x + 15, y + 7, x + 17);
	    drawHorizontalLineShadowed(x + 19, y + 7, x + 21);
	    drawHorizontalLineShadowed(x + 23, y + 7, x + 25);
	}
	return Math.max(dy, 32);
    }

    private int drawFurnace(int x, int y, ItemStack stack, RecipeSlotType type, int mouseX, int mouseY, HashSet<Integer> items) {
	if (type != RecipeSlotType.INVENTORY) // TODO: dump liquids in
	    // containers for crafting?
	    return 0;

	int dy = 0;
	ItemStack output = FurnaceRecipes.smelting().getSmeltingResult(stack);
	if (output != null) {
	    drawVerticalLineShadowed(x + 24, y + 6, y + dy + 8);
	    drawHorizontalLineShadowed(x + 24, y + 7 + dy, x + 32);
	    dy += drawTree(output, x + 32, y + dy, RecipeSlotType.INVENTORY, mouseX, mouseY, items);
	    drawStack(new ItemStack(Block.furnaceBurning), x, y, mouseX, mouseY, false, this.mouseInside);
	    drawHorizontalLineShadowed(x - 9, y + 7, x);
	    drawHorizontalLineShadowed(x + 15, y + 7, x + 23);
	    return Math.max(dy, 32);
	}
	return dy;
    }

    private int drawCrafting(int x, int y, ItemStack stack, RecipeSlotType type, int mouseX, int mouseY, HashSet<Integer> items) {
	if (type != RecipeSlotType.INVENTORY) // TODO: dump liquids in
					      // containers for crafting?
	    return 0;

	boolean hasCrafting = false;
	int dy = 0;

	List recipes = CraftingManager.getInstance().getRecipeList();
	for (int i = 0; i < recipes.size(); i++) {
	    IRecipe recipe = (IRecipe) recipes.get(i);
	    if (hasInput(recipe, stack)) {
		hasCrafting = true;
		ItemStack output = recipe.getRecipeOutput();
		drawVerticalLineShadowed(x + 24, y + 6, y + dy + 8);
		drawHorizontalLineShadowed(x + 24, y + 7 + dy, x + 32);
		dy += drawTree(output, x + 32, y + dy, RecipeSlotType.INVENTORY, mouseX, mouseY, items);
	    }
	}

	if (hasCrafting) {
	    drawStack(new ItemStack(Block.workbench), x, y, mouseX, mouseY, false, this.mouseInside);
	    drawHorizontalLineShadowed(x - 9, y + 7, x);
	    drawHorizontalLineShadowed(x + 15, y + 7, x + 23);
	    return Math.max(dy, 32);
	}
	return dy;
    }

    private boolean hasInput(IRecipe recipe, ItemStack stack) {

	if (recipe instanceof ShapedRecipes) {
	    ShapedRecipes recipeShaped = (ShapedRecipes) recipe;
	    for (int j = 0; j < recipeShaped.recipeItems.length; j++) {
		ItemStack stackRecipe = recipeShaped.recipeItems[j];
		if (stackRecipe != null) {
		    if (stackRecipe.isItemEqual(stack)) {
			return true;
		    }
		}
	    }
	}
	return false;
    }

    private void drawHorizontalLineShadowed(int x1, int y, int x2) {
	this.zLevel = 0;
	GL11.glPushMatrix();
	this.drawHorizontalLine(x1, x2, y, HIGHLIGT_COLOR);
	GL11.glTranslatef(1, 1, -10);
	this.drawHorizontalLine(x1, x2, y, SHADOW_COLOR);
	GL11.glPopMatrix();
    }

    private void drawVerticalLineShadowed(int x, int y1, int y2) {
	this.zLevel = 0;
	GL11.glPushMatrix();
	this.drawVerticalLine(x, y1, y2, HIGHLIGT_COLOR);
	GL11.glTranslatef(1, 1, -10);
	this.drawVerticalLine(x, y1, y2, SHADOW_COLOR);
	GL11.glPopMatrix();
    }

    private int drawMachine(int x, int y, ItemStack stack, RecipeSlotType type, int mouseX, int mouseY, int machineIndex, HashSet<Integer> items) {

	GuideBlockRecipes recipeBlock = blockRecipes.get(machineIndex);
	RecipesMachine handler = recipeBlock.recipes;
	int dy = 0;
	boolean hasRecipe = false;
	int lastDy = 0;
	for (Iterator<Recipe> iterator = handler.iterator(); iterator.hasNext();) {
	    Recipe recipe = iterator.next();
	    if (hasInput(recipe, stack, type)) {
		hasRecipe = true;
		drawVerticalLineShadowed(x + 24, y + 6 + lastDy, y + dy + 8);
		lastDy = dy;
		dy += drawRecipe(x + 32, y + dy, stack, type, mouseX, mouseY, recipe, items);
	    }
	}
	if (hasRecipe) {
	    drawHorizontalLineShadowed(x - 9, y + 7, x);
	    drawHorizontalLineShadowed(x + 15, y + 7, x + 23);
	    drawStack(new ItemStack(recipeBlock.block, 1, 0), x, y, mouseX, mouseY, false, this.mouseInside);
	    dy = Math.max(dy, 16);
	}
	return dy;
    }

    private boolean hasInput(Recipe recipe, ItemStack stack, RecipeSlotType type) {
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
	    if (id == stack.itemID && type == recipe.inputs[j].type)
		return true;
	}
	return false;
    }

    private int drawRecipe(int x, int y, ItemStack stack, RecipeSlotType type, int mouseX, int mouseY, Recipe recipe, HashSet<Integer> items) {
	int dy = 0;
	for (int j2 = 0; j2 < recipe.outputs.length; j2++) {

	    drawVerticalLineShadowed(x - 8, y + 6, y + dy + 8);
	    drawHorizontalLineShadowed(x - 8, y + 7 + dy, x);
	    if (recipe.outputs[j2].type == RecipeSlotType.INVENTORY) {
		dy += drawTree(new ItemStack(recipe.outputs[j2].itemId, 0, 0), x, y + dy, RecipeSlotType.INVENTORY, mouseX, mouseY, items);
	    } else if (recipe.outputs[j2].type == RecipeSlotType.TANK) {
		int fid = FluidRegistry.getFluid(recipe.outputs[j2].itemId).getBlockID();
		dy += drawTree(new ItemStack(fid, 0, 0), x, y + dy, RecipeSlotType.TANK, mouseX, mouseY, items);
	    }
	}

	return dy;
    }

    @Override
    public Point getIconLocation() {
	return null;
    }

    @Override
    public ItemStack getIconStack() {
	return new ItemStack(ISetupItems.itemSmallMachineCasing);
    }

}