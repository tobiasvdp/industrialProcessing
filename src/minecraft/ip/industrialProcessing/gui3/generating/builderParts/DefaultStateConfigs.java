package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IValueBinding;
import ip.industrialProcessing.gui3.binding.reply.StateConfigSetter;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.StateHandler;
import ip.industrialProcessing.gui3.framework.UIElement;
import ip.industrialProcessing.gui3.framework.custom.NumericSpinner;
import ip.industrialProcessing.gui3.framework.custom.StateButton;
import ip.industrialProcessing.gui3.framework.panels.StackPanel;
import ip.industrialProcessing.gui3.framework.rendering.TextureReference;
import ip.industrialProcessing.utils.handler.numbers.IStateConfig;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

public class DefaultStateConfigs {
    public static void setupSpinners(ArrayList<SpinnerReference> spinnerRefs, LayoutContainer container, TileEntity tileEntity) {
        if (!spinnerRefs.isEmpty()) {
            IStateConfig stateEntity = getStateConfigs(tileEntity);
            for (SpinnerReference spinnerReference : spinnerRefs) {
                setupSpinner(spinnerReference, container, stateEntity);
            }
        }
    }

    public static void setupSpinner(SpinnerReference spinnerReference, LayoutContainer container, IStateConfig stateEntity) {
        container.addHandler(spinnerReference.handler = new StateHandler(spinnerReference.index, stateEntity));
    }

    public static void setupButtons(ArrayList<StateButtonReference> stateButtonsRefs, LayoutContainer container, TileEntity tileEntity) {
        if (!stateButtonsRefs.isEmpty()) {
            IStateConfig stateEntity = getStateConfigs(tileEntity);
            for (StateButtonReference stateButtonReference : stateButtonsRefs) {
                setupButton(stateButtonReference, container, stateEntity);
            }
        }
    }

    public static void setupButton(StateButtonReference stateButtonReference, LayoutContainer container, IStateConfig stateEntity) {
        container.addHandler(stateButtonReference.handler = new StateHandler(stateButtonReference.index, stateEntity));
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
            NumericSpinner spinner = setupSpinner(spinnerRef, guiContainer, entity);
            stateStack.addChild(spinner);
        }
    }

    public static NumericSpinner setupSpinner(SpinnerReference spinnerRef, GuiLayoutContainer guiContainer, TileEntity entity) {
        NumericSpinner spinner = NumericSpinner.createSpinner(spinnerRef.format, spinnerRef.scale, spinnerRef.width);
        Binder binder = new Binder<IValueBinding>(spinnerRef.handler, spinner);
        guiContainer.addBinding(binder);
        StateConfigSetter.bind(entity, spinner, spinnerRef.index);
        return spinner;
    }

    public static void setupButtons(ArrayList<StateButtonReference> stateButtons, GuiLayoutContainer guiContainer, StackPanel stateStack, TileEntity entity) {
        for (StateButtonReference stateRef : stateButtons) {
            StateButton button = setupButton(stateRef, guiContainer, entity);
            stateStack.addChild(button);
        }
    }

    public static StateButton setupButton(StateButtonReference stateRef, GuiLayoutContainer guiContainer, TileEntity entity) {
        StateButton button = new StateButton(stateRef.texture, stateRef.rows, stateRef.columns, stateRef.names);
        Binder binder = new Binder<IValueBinding>(stateRef.handler, button);
        guiContainer.addBinding(binder);
        StateConfigSetter.bind(entity, button, stateRef.index);
        return button;
    }
}
