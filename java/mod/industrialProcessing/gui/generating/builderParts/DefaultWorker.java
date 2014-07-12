package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.binding.Binder;
import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.WorkHandler;
import mod.industrialProcessing.gui.framework.Alignment;
import mod.industrialProcessing.gui.framework.controls.ProgressBar;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import mod.industrialProcessing.work.worker.IWorkingEntity;
import net.minecraft.tileentity.TileEntity;

public class DefaultWorker {
	public static void setup(WorkerReference workerRef, LayoutContainer container, TileEntity entity) {
		if (workerRef != null) {
			IWorkingEntity workingEntity = getWorkingEntity(entity);
			container.addHandler(workerRef.workerHandler = new WorkHandler(workingEntity));
		}
	}

	private static IWorkingEntity getWorkingEntity(TileEntity tileEntity) {
		IWorkingEntity workingEntity = null;
		if (tileEntity instanceof IWorkingEntity)
			workingEntity = (IWorkingEntity) tileEntity;
		if (workingEntity == null)
			throw new NullPointerException("Work without IWorkingEntity?!");
		return workingEntity;
	}

	public static void setup(WorkerReference workerRef, GuiLayoutContainer guiContainer, GridPanel grid, Alignment center) {
		if (workerRef != null) {
			ProgressBar workBar = ProgressBar.createWorker(workerRef.workerTexture);
			Binder binder = new Binder<IProgressBinding>(workerRef.workerHandler, workBar);
			guiContainer.addBinding(binder);
			workBar.horizontalAlign = center;
			grid.children.add(new GridCell(0, grid.columns.size(), workBar));
			grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
		}
	}

	public static void setup(WorkerReference workerRef, IMachineRecipe recipe, GridPanel grid, Alignment center) {
		if (workerRef != null) {
			ProgressBar workBar = ProgressBar.createWorker(workerRef.workerTexture);
			workBar.value = recipe.getWorkRequired();
			workBar.maxValue = recipe.getWorkRequired();
			workBar.horizontalAlign = center;
			grid.children.add(new GridCell(0, grid.columns.size(), workBar));
			grid.columns.add(new GridSize(1, SizeMode.RELATIVE));
		}
	}
}
