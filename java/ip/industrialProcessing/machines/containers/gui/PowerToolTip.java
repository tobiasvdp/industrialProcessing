package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.gui.container.syncing.info.InfoPower;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;

import org.lwjgl.util.Rectangle;

public class PowerToolTip {
    public static ToolTip getToolTip(ProgressInfoPower power, Rectangle target, int mouseX, int mouseY) {

        if (target.contains(mouseX, mouseY)) {
            float joules = power.storedPower;
            float cap = power.powerCapacity;
            String unit = "J";
            int p = 0;
            char[] siUnits = new char[] { ' ', 'K', 'M', 'G', 'T', 'P' };
            while (joules > 1000 || cap > 1000) {
                p++;
                joules /= 1000f;
                cap /= 1000f;
            }
            
            String tooltip = String.format("\u00a77%.2f/%.2f%sJ", joules, cap, siUnits[p]);
            return new ToolTip("Power", tooltip);
        }
        return null;
    }

    public static ToolTip getToolTip(InfoPower power, Rectangle target, int mouseX, int mouseY) {

        if (target.contains(mouseX, mouseY)) {
            float joules = power.storedPower;
            float cap = power.powerCapacity;
            String unit = "J";
            int p = 0;
            char[] siUnits = new char[] { ' ', 'K', 'M', 'G', 'T', 'P' };
            while (joules > 1000 || cap > 1000) {
                p++;
                joules /= 1000f;
                cap /= 1000f;
            }
            
            String tooltip = String.format("\u00a77%.2f/%.2f%sJ", joules, cap, siUnits[p]);
            return new ToolTip("Power", tooltip);
        }
        return null;
    }
}
