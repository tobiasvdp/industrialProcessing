package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.binding.Binder;
import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.HeatedHandler;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.utils.handlers.heat.IHeated;
import mod.industrialProcessing.work.recipe.IHeatRecipe;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
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
