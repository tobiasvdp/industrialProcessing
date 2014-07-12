package mod.industrialProcessing.gui.guide.pages;

import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.UIElement;
import mod.industrialProcessing.gui.framework.controls.TextBlock;
import mod.industrialProcessing.gui.framework.controls.UserControl;
import mod.industrialProcessing.gui.framework.panels.Orientation;
import mod.industrialProcessing.gui.framework.panels.StackPanel;

public class RecipeFrame extends UserControl {

    private TextBlock title;
    private UIElement contents;

    public RecipeFrame(UIElement contents, String name) {
        StackPanel stackPanel = new StackPanel();
        stackPanel.orientation = Orientation.VERTICAL;
        title = TextBlock.createText(name);
        title.margin = new Thickness(0, 0, 7, 0);
        stackPanel.addChild(title);
        this.contents = contents;
        stackPanel.addChild(contents);
        this.width = Float.NaN;
        this.height = Float.NaN;
        this.child = stackPanel;
    }
}
