package ip.industrialProcessing.power.plants;

import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import ip.industrialProcessing.power.GeneratorProgress;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerGenerator extends GuiContainerMachine {

	private TileEntityGenerator generator;
	private ContainerGenerator container;

	public GuiContainerGenerator(InventoryPlayer inventory, TileEntityGenerator entity) {
		this(inventory, entity, new ContainerGenerator(inventory, entity));
	}

	private GuiContainerGenerator(InventoryPlayer inventory, TileEntityGenerator entity, ContainerGenerator container) {
		super(inventory, entity, container, "Buildcraft Generator", "textures/gui/Generator.png");
		this.container = container;
		this.generator = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		GeneratorProgress progress = this.container.getProgress();

		int volt = (int) progress.voltage;
		int amps = (int) progress.amps;
		int power = volt * amps;

		int maxAmps = 50;
		int maxVolt = 150;
		int maxPower = maxVolt * maxAmps;

		drawHorizontalProgressBar(62, 29, 176, 0, 52, 7, amps, maxAmps, false);
		drawHorizontalProgressBar(62, 41, 176, 0, 52, 7, volt, maxVolt, false);
		drawHorizontalProgressBar(62, 53, 176, 0, 52, 7, power, maxPower, false);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		super.drawGuiContainerForegroundLayer(param1, param2);
		fontRenderer.drawString("      Amps:", 8, 28, 4210752);
		fontRenderer.drawString("   Voltage:", 8, 40, 4210752);
		fontRenderer.drawString("     Power:", 8, 52, 4210752);

		GeneratorProgress progress = this.container.getProgress();

		float volt = Math.round(progress.voltage * 10f) / 10f;
		float amps = Math.round(progress.amps * 10f) / 10f;
		float power = Math.round(progress.voltage * progress.amps * 10) / 10f;
		fontRenderer.drawString(amps + "A", 120, 28, 4210752);
		fontRenderer.drawString(volt + "V", 120, 40, 4210752);
		fontRenderer.drawString(power + "W", 120, 52, 4210752);
	}
}
