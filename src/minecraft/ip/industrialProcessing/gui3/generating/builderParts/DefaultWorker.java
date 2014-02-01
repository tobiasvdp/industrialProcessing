package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.WorkHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.ProgressBar;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.recipes.IMachineRecipe;
import ip.industrialProcessing.utils.working.IWorkingEntity;
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
