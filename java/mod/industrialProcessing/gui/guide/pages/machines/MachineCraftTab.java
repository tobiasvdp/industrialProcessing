package mod.industrialProcessing.gui.guide.pages.machines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.ISetupBlockContainers;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.Button;
import mod.industrialProcessing.gui.framework.controls.IButtonClickListener;
import mod.industrialProcessing.gui.framework.controls.SlotItemControl;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.MouseButton;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.ScrollPanel;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.gui.framework.panels.WrapPanel;
import mod.industrialProcessing.gui.framework.panels.tabs.TabPage;
import mod.industrialProcessing.gui.guide.pages.machines.crafts.AnvilCraft;
import mod.industrialProcessing.gui.guide.pages.machines.crafts.FurnaceCraft;
import mod.industrialProcessing.gui.guide.pages.machines.crafts.ICraftBase;
import mod.industrialProcessing.gui.guide.pages.machines.crafts.MachineCraft;
import mod.industrialProcessing.gui.guide.pages.machines.crafts.WorkbenchCraft;
import mod.industrialProcessing.plants.middleAge.anvil.ContainerAnvil;
import mod.industrialProcessing.utils.registry.RecipeRegistry;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class MachineCraftTab extends TabPage implements IButtonClickListener<ICraftBase> {
    private WrapPanel wrapPanel;
    private UserControl recipeDock;
    private IButtonClickListener<ItemStack> stackClickListener;

    public MachineCraftTab(IButtonClickListener<ItemStack> stackClickListener) {
        this.stackClickListener = stackClickListener;
        this.header = TextBlock.createText("Craft");
        this.activeHeader = TextBlock.createText("Craft", 0xffffffff);
        this.header.margin = this.activeHeader.margin = new Thickness(0, 5, 0, 0);
        StackPanel stack = new StackPanel();
        stack.orientation = Orientation.VERTICAL;
        this.wrapPanel = new WrapPanel();
        ScrollPanel scroll = new ScrollPanel();
        scroll.allowHorizontalScroll = false;
        scroll.allowVerticalScroll = true;
        scroll.maxHeight = 18 * 2 + 2;
        scroll.minHeight = 18 * 2 + 2;
        scroll.content = wrapPanel;
        stack.addChild(scroll);
        this.recipeDock = new UserControl();
        this.recipeDock.width = this.recipeDock.height = Float.NaN;
        this.recipeDock.margin = new Thickness(7, 0, 0, 0);
        stack.addChild(recipeDock);
        this.content = stack;
    }

    public void setStack(ItemStack tag) {
        this.wrapPanel.clear();
        this.recipeDock.child = null;
        if (tag != null) {
            ICraftBase lastFurnace = addFurnaceRecipes(tag);
            ICraftBase lastWorkbench = addWorkbenchRecipes(tag);
            ICraftBase lastAnvil = addAnvilRecipes(tag);
            ICraftBase lastMachine = addMachineRecipes(tag);
            if (lastMachine != null)
                this.recipeDock.child = lastMachine.getGui(stackClickListener);
            if (lastAnvil != null)
                this.recipeDock.child = lastAnvil.getGui(stackClickListener);
            if (lastWorkbench != null)
                this.recipeDock.child = lastWorkbench.getGui(stackClickListener);
            if (lastFurnace != null)
                this.recipeDock.child = lastFurnace.getGui(stackClickListener);
        }
    }

    private ICraftBase addMachineRecipes(ItemStack tag) {
        ICraftBase lastCraft = null;
        ArrayList<IMachineRecipe> recipes = RecipeRegistry.FindRecipeForOutput(tag);
        for (IMachineRecipe recipe : recipes) {
            Block craftingBlock = RecipeRegistry.getBlockForRecipe(recipe);
            SlotItemControl slot = SlotItemControl.createItemstack(new ItemStack(craftingBlock));
            Button button = new Button<ICraftBase>(slot, lastCraft = new MachineCraft(craftingBlock, recipe));
            button.subscribeClick(this);
            this.wrapPanel.addChild(button);
        }
        return lastCraft;
    }

    private ICraftBase addAnvilRecipes(ItemStack tag) {
        ICraftBase lastCraft = null;

        List list = ContainerAnvil.getCraftingManager().getRecipeList();
        for (int j = 0; j < list.size(); j++) {
            Object listItem = list.get(j);
            if (listItem instanceof IRecipe) {
                IRecipe recipe = (IRecipe) listItem;
                ItemStack output = recipe.getRecipeOutput();
                if (output != null && output.getItem().equals(tag.getItem())) {
                    SlotItemControl slot = SlotItemControl.createItemstack(new ItemStack(IndustrialProcessing.blockAnvil));
                    Button button = new Button<ICraftBase>(slot, lastCraft = new AnvilCraft(recipe));
                    button.subscribeClick(this);
                    this.wrapPanel.addChild(button);
                }
            }
        }
        return lastCraft;
    }

    private ICraftBase addWorkbenchRecipes(ItemStack tag) {
        ICraftBase lastCraft = null;
        List list = CraftingManager.getInstance().getRecipeList();
        for (int j = 0; j < list.size(); j++) {
            Object listItem = list.get(j);
            if (listItem instanceof IRecipe) {
                IRecipe recipe = (IRecipe) listItem;
                ItemStack output = recipe.getRecipeOutput();
                if (output != null && output.getItem().equals(tag.getItem())) {
                    SlotItemControl slot = SlotItemControl.createItemstack(new ItemStack(Blocks.crafting_table));
                    Button button = new Button<ICraftBase>(slot, lastCraft = new WorkbenchCraft(recipe));
                    button.subscribeClick(this);
                    this.wrapPanel.addChild(button);
                }
            }
        }
        return lastCraft;
    }

    private ICraftBase addFurnaceRecipes(ItemStack tag) {
        ICraftBase lastCraft = null;
        Map map = FurnaceRecipes.smelting().getSmeltingList();
        Set set = map.entrySet();

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ItemStack> entry = (Entry<Integer, ItemStack>) it.next();
            ItemStack stack = entry.getValue();
            if (stack != null && stack.getItem().equals(tag.getItem())) {
                SlotItemControl slot = SlotItemControl.createItemstack(new ItemStack(Blocks.furnace));
                Button button = new Button<ICraftBase>(slot, lastCraft = new FurnaceCraft(entry.getKey(), entry.getValue()));
                button.subscribeClick(this);
                this.wrapPanel.addChild(button);
            }
        }
        return lastCraft;
    }

    @Override
    public void buttonClicked(Button button, ICraftBase tag, float mouseX, float mouseY, MouseButton mouseButton) {
        if (tag != null) {
            this.recipeDock.child = tag.getGui(stackClickListener);
        } else
            this.recipeDock.child = null;
    }
}
