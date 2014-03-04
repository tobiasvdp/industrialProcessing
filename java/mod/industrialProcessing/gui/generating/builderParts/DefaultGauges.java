package mod.industrialProcessing.gui.generating.builderParts;

import java.util.ArrayList;

import mod.industrialProcessing.gui.binding.IProgressBinding;
import mod.industrialProcessing.gui.containers.GuiLayoutContainer;
import mod.industrialProcessing.gui.containers.LayoutContainer;
import mod.industrialProcessing.gui.containers.handlers.ProgressHandler;
import mod.industrialProcessing.gui.framework.controls.GaugeControl;
import mod.industrialProcessing.gui.framework.custom.LabeledGauge;
import mod.industrialProcessing.gui.framework.panels.GridCell;
import mod.industrialProcessing.gui.framework.panels.GridPanel;
import mod.industrialProcessing.gui.framework.panels.GridSize;
import mod.industrialProcessing.gui.framework.panels.SizeMode;
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
