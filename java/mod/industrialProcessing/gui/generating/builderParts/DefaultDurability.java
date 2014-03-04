package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.DurabilityHandler;
import mod.industrialProcessing.gui.framework.Thickness;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import net.minecraft.tileentity.TileEntity;

public class DefaultDurability {
	public static void setup(DurabilityReference durabilityRef, GuiLayoutContainer guiContainer, StackPanel stack) {
		if (durabilityRef != null) {
			ProgressBar durabilityProgress = ProgressBar.createHorizontal3();
			durabilityProgress.horizontalAlign = Alignment.MIN;
			durabilityProgress.invert = true;
			durabilityProgress.flip = true;
			durabilityProgress.margin = new Thickness(0, 0, 7, 0);
			stack.addChild(durabilityProgress);
			Binder binder = new Binder(durabilityRef.handler, durabilityProgress);
			guiContainer.addBinding(binder);
		}
	}

	public static void setup(DurabilityReference durabilityRef, LayoutContainer container, TileEntity tileEntity) {
		if (durabilityRef != null) {
			IDurability durableEntity = getDurableEntity(tileEntity);
			container.addHandler(durabilityRef.handler = new DurabilityHandler(durableEntity));
		}
	}

	private static IDurability getDurableEntity(TileEntity tileEntity) {
		IDurability durableEntity = null;
		if (tileEntity instanceof IDurability)
			durableEntity = (IDurability) tileEntity;
		if (durableEntity == null)
			throw new NullPointerException("Durability without IDurability?!");
		return durableEntity;
	}
}
