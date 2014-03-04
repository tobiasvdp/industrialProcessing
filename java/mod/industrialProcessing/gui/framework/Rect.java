package mod.industrialProcessing.gui.framework;

import javax.swing.Icon;

import net.minecraft.util.IIcon;

public class Rect {
    public float x;
    public float y;
    public float width;
    public float height;

    public Size getSize() {
        return new Size(width, height);
    }

    public Rect(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rect(float x, float y, Size size) {
        this.x = x;
        this.y = y;
        this.width = size.width;
        this.height = size.height;
    }

    public Rect(IIcon icon) {
        this(icon.getMinU(), icon.getMinV(), icon.getMaxU() - icon.getMinU(), icon.getMaxV() - icon.getMinV());
    }

    public boolean contains(float x2, float y2) {
        x2 -= x;
        y2 -= y;

        return x2 >= 0 && x2 < width && y2 >= 0 && y2 < height;
    }

    public Rect inflate(int i) {
        return new Rect(x + i, y + i, width - 2 * i, height - 2 * i);
    }
}
