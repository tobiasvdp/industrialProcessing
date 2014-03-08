package mod.industrialProcessing.gui.generating.builderParts;

import java.util.ArrayList;

import mod.industrialProcessing.gui.binding.Binder;
import mod.industrialProcessing.gui.binding.IValueBinding;
import mod.industrialProcessing.gui.binding.reply.StateConfigSetter;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.StateHandler;
import mod.industrialProcessing.gui.framework.custom.NumericSpinner;
import mod.industrialProcessing.gui.framework.custom.StateButton;
import mod.industrialProcessing.gui.framework.panels.StackPanel;
import mod.industrialProcessing.utils.handlers.numbers.IStateConfig;
import net.minecraft.tileentity.TileEntity;

public class DefaultStateConfigs {
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

	public static void setupSpinners(ArrayList<SpinnerReference> spinners, GuiLayoutContainer guiContainer, StackPanel stateStack, TileEntity entity) {
		for (SpinnerReference spinnerRef : spinners) {
			NumericSpinner spinner = NumericSpinner.createSpinner(spinnerRef.format, spinnerRef.scale, spinnerRef.width);
			Binder binder = new Binder<IValueBinding>(spinnerRef.handler, spinner);
			guiContainer.addBinding(binder);
			StateConfigSetter.bind(entity, spinner, spinnerRef.index);
			stateStack.addChild(spinner);
		}
	}

	public static void setupButtons(ArrayList<StateButtonReference> stateButtons, GuiLayoutContainer guiContainer, StackPanel stateStack, TileEntity entity) {
		for (StateButtonReference stateRef : stateButtons) {
			StateButton button = new StateButton(stateRef.texture, stateRef.rows, stateRef.columns, stateRef.names);
			Binder binder = new Binder<IValueBinding>(stateRef.handler, button);
			guiContainer.addBinding(binder);
			StateConfigSetter.bind(entity, button, stateRef.index);
			stateStack.addChild(button);
		}
	}
}
