package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.DurabilityHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.Thickness;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.utils.IDurability;
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
