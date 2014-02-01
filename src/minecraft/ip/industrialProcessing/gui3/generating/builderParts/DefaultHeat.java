package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.HeatedHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.recipes.IHeatRecipe;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.handler.heat.IHeated;
import net.minecraft.tileentity.TileEntity;

public class DefaultHeat {

    public static void setup(HeatedReference heatRef, GuiLayoutContainer guiContainer, GridPanel grid, Alignment min) {
	if (heatRef != null) {
	    ProgressBar thermometer = ProgressBar.createTemperature();
	    Binder binder = new Binder<IProgressBinding>(heatRef.heatHandler, thermometer);
	    guiContainer.addBinding(binder);
	    thermometer.horizontalAlign = min;
	    grid.children.add(new GridCell(0, grid.columns.size(), thermometer));
	    grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
    }

    public static void setup(HeatedReference heatRef, LayoutContainer container, TileEntity tileEntity) {
	if (heatRef != null) {
	    IHeated heated = getHeated(tileEntity);
	    container.addHandler(heatRef.heatHandler = new HeatedHandler(heated));
	}
    }

    private static IHeated getHeated(TileEntity tileEntity) {
	IHeated heated = null;
	if (tileEntity instanceof IHeated)
	    heated = (IHeated) tileEntity;
	if (heated == null)
	    throw new NullPointerException("Heat without IHeated?!");
	return heated;
    }

    public static void setup(HeatedReference heatRef, IMachineRecipe recipe, GridPanel grid, Alignment min) {
	if (heatRef != null) {
	    IHeatRecipe heatRecipe = getHeatRecipe(recipe);
	    float minTemperature = 0;
	    if (heatRecipe != null)
		minTemperature = heatRecipe.getHeatRequired();
	    ProgressBar thermometer = ProgressBar.createTemperature();
	    thermometer.maxValue = thermometer.value = (int) Math.ceil(minTemperature);

	    thermometer.horizontalAlign = min;
	    grid.children.add(new GridCell(0, grid.columns.size(), thermometer));
	    grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
	}
    }

    private static IHeatRecipe getHeatRecipe(IMachineRecipe recipe) {
	IHeatRecipe heatRecipe = null;
	if (recipe instanceof IHeatRecipe)
	    heatRecipe = (IHeatRecipe) recipe;
	return heatRecipe;
    }
}
