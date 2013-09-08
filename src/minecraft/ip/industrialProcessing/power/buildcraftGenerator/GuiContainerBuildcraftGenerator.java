package ip.industrialProcessing.power.buildcraftGenerator;

import ip.industrialProcessing.machines.containers.gui.GuiContainerMachine;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerBuildcraftGenerator extends GuiContainerMachine {

	private TileEntityBuildcraftGenerator generator;

	public GuiContainerBuildcraftGenerator(InventoryPlayer inventory, TileEntityBuildcraftGenerator entity) {
		super(inventory, entity, new ContainerBuildcraftGenerator(inventory, entity), "Buildcraft Generator", "textures/gui/Generator.png");
		this.generator = entity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		super.drawGuiContainerBackgroundLayer(par1, par2, par3);

		int volt = (int) this.generator.getVoltage();
		int amps = (int) this.generator.getLastAmps();
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

		float volt = Math.round(this.generator.getVoltage() * 10) / 10f;
		float amps = Math.round(this.generator.getLastAmps() * 10) / 10f;
		float power = Math.round(volt * amps * 10) / 10f;
		fontRenderer.drawString(amps + "A", 120, 28, 4210752);
		fontRenderer.drawString(volt + "V", 120, 40, 4210752);
		fontRenderer.drawString(power + "W", 120, 52, 4210752);
	}
}
