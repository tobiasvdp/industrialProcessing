package ip.industrialProcessing.machines.containers.gui;

import ip.industrialProcessing.client.render.gui.ToolTip;
import ip.industrialProcessing.machines.containers.ProgressInfoPower;

import org.lwjgl.util.Rectangle;

public class PowerToolTip {
    public static ToolTip getToolTip(ProgressInfoPower power, Rectangle target, int mouseX, int mouseY) {

	if (target.contains(mouseX, mouseY)) {
	    float joules = power.storedPower;
	    String unit = "J";
	    int p = 0;
	    char[] siUnits = new char[] { ' ', 'K', 'M', 'G', 'T', 'P' };
	    while (joules > 1000) {
		p++;
		joules /= 1000f;
	    }
	    return new ToolTip("Power", "\u00a77" + (Math.round(joules * 100f) / 100f) + ' ' + siUnits[p] + "J");
	}
	return null;
    }
}
