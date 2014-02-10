package ip.industrialProcessing.gui3.generating.builderParts;

import ip.industrialProcessing.gui3.binding.Binder;
import ip.industrialProcessing.gui3.binding.IProgressBinding;
import ip.industrialProcessing.gui3.containers.GuiLayoutContainer;
import ip.industrialProcessing.gui3.containers.LayoutContainer;
import ip.industrialProcessing.gui3.containers.handlers.ProgressHandler;
import ip.industrialProcessing.gui3.framework.Alignment;
import ip.industrialProcessing.gui3.framework.controls.GaugeControl;
import ip.industrialProcessing.gui3.framework.custom.LabeledGauge;
import ip.industrialProcessing.gui3.framework.panels.GridCell;
import ip.industrialProcessing.gui3.framework.panels.GridPanel;
import ip.industrialProcessing.gui3.framework.panels.GridSize;
import ip.industrialProcessing.gui3.framework.panels.SizeMode;
import ip.industrialProcessing.utils.handler.numbers.IProgressable;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

public final class DefaultGauges {
    public static void setup(ArrayList<GaugeReference> gauges, GuiLayoutContainer guiContainer, LayoutContainer container, GridPanel grid, Alignment min) {

	LabeledGauge labeledGauge;
	GaugeControl gauge;
	Binder binder;
	for (GaugeReference gaugeRef : gauges) {
	    if (gaugeRef.showName) {
		labeledGauge = LabeledGauge.createLabeledGauge(gaugeRef.name, gaugeRef.format);
		labeledGauge.horizontalAlign = min;
		labeledGauge.verticalAlign = Alignment.CENTER;
		binder = new Binder<IProgressBinding>(gaugeRef.handler, labeledGauge);
		grid.children.add(new GridCell(0, grid.columns.size(), labeledGauge));
		guiContainer.addBinding(binder);
	    } else {
		gauge = GaugeControl.createGauge(gaugeRef.name, gaugeRef.format);
		gauge.horizontalAlign = min;
		gauge.verticalAlign = Alignment.CENTER;
		binder = new Binder<IProgressBinding>(gaugeRef.handler, gauge);
		grid.children.add(new GridCell(0, grid.columns.size(), gauge));
		guiContainer.addBinding(binder);
	    }
	    grid.columns.add(new GridSize(3, SizeMode.RELATIVE));
	}
    }

    public static void setup(ArrayList<GaugeReference> gauges, LayoutContainer container, TileEntity entity) {
	if (!gauges.isEmpty()) {
	    IProgressable progressableEntity = getProgressable(entity);
	    for (GaugeReference gaugeRef : gauges) {
		container.addHandler(gaugeRef.handler = new ProgressHandler(gaugeRef.slotIndex, progressableEntity));
	    }
	}
    }

    private static IProgressable getProgressable(TileEntity tileEntity) {
	IProgressable progressable = null;
	if (tileEntity instanceof IProgressable)
	    progressable = (IProgressable) tileEntity;
	if (progressable == null)
	    throw new NullPointerException("Gauges without IProgressable?!");
	return progressable;
    }
}
