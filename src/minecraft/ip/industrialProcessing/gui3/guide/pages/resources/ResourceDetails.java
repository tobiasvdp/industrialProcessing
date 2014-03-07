package ip.industrialProcessing.gui3.guide.pages.resources;

import ip.industrialProcessing.gui3.framework.controls.Button;
import ip.industrialProcessing.gui3.framework.controls.IButtonClickListener;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.MouseButton;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.ScrollPanel;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.guide.pages.techtree.ResourceChain;
import ip.industrialProcessing.gui3.guide.pages.techtree.TreeControl;
import net.minecraft.item.ItemStack;

public class ResourceDetails extends UserControl implements IButtonClickListener<ItemStack> {

    private TextBlock textBlock;
    private TreeControl tree;

    public ResourceDetails() {
        this.textBlock = TextBlock.createText("Some resource");
        StackPanel stack = new StackPanel();
        stack.orientation = Orientation.VERTICAL;
        stack.addChild(textBlock);
        tree = new TreeControl(this);
        tree.followParents = false;
        stack.addChild(tree);
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.allowHorizontalScroll = true;
        scrollPanel.allowVerticalScroll = true;
        scrollPanel.content = stack;
        this.child = scrollPanel;
    }

    @Override
    public void buttonClicked(Button<ItemStack> button, ItemStack tag, float mouseX, float mouseY, MouseButton mouseButton) {
        ResourceChain chain = new ResourceChain(tag);
        this.tree.setChain(chain.getRoot());
    }

}
