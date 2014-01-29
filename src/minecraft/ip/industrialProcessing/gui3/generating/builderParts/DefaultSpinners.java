package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.StateHandler;
import ip.industrialProcessing.gui3.framework.custom.NumericSpinner;
import ip.industrialProcessing.gui3.framework.custom.StateButton;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

public class DefaultSpinners {
    public static void setupSpinners(ArrayList<SpinnerReference> spinnerRefs, LayoutContainer container, TileEntity tileEntity) {
	if (!spinnerRefs.isEmpty()) {
	    IStateConfig stateEntity = getStateConfigs(tileEntity);
	    for (SpinnerReference spinnerReference : spinnerRefs) {
		container.addHandler(spinnerReference.handler = new StateHandler(spinnerReference.index, stateEntity));
	    }
	}
    }

    public static void setupButtons(ArrayList<StateButtonReference> stateButtonsRefs, LayoutContainer container, TileEntity tileEntity) {
	if (!stateButtonsRefs.isEmpty()) {
	    IStateConfig stateEntity = getStateConfigs(tileEntity);
	    for (StateButtonReference stateButtonReference : stateButtonsRefs) {
		container.addHandler(stateButtonReference.handler = new StateHandler(stateButtonReference.index, stateEntity));
	    }
	}
    }

    private static IStateConfig getStateConfigs(TileEntity tileEntity) {

	IStateConfig stateEntity = null;
	if (tileEntity instanceof IStateConfig)
	    stateEntity = (IStateConfig) tileEntity;
	if (stateEntity == null)
	    throw new NullPointerException("States without IStateConfig?!");
	return stateEntity;
    }

    public static void setupSpinners(ArrayList<SpinnerReference> spinners, GuiLayoutContainer guiContainer, StackPanel stateStack) {
	for (SpinnerReference spinnerRef : spinners) {
	    NumericSpinner spinner = NumericSpinner.createSpinner(spinnerRef.format, spinnerRef.scale, spinnerRef.width);
	    stateStack.addChild(spinner);
	}
    }

    public static void setupButtons(ArrayList<StateButtonReference> stateButtons, GuiLayoutContainer guiContainer, StackPanel stateStack) {
	for (StateButtonReference stateRef : stateButtons) {
	    StateButton button = new StateButton(stateRef.texture, stateRef.rows, stateRef.columns, stateRef.names);
	    stateStack.addChild(button);
	}
    }
}
