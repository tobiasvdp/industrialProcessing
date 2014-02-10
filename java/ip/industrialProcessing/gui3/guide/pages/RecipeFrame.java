package ip.industrialProcessing.gui3.guide.pages;

import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.controls.TextBlock;
import ip.industrialProcessing.gui3.framework.controls.UserControl;
import ip.industrialProcessing.gui3.framework.panels.Orientation;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;

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
