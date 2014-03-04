package mod.industrialProcessing.gui.generating.builderParts;

import mod.industrialProcessing.gui.containers.handlers.TankHandler;
import net.minecraft.inventory.Slot;

public class TankReference {
	public TankReference(int slot) {
		this(slot, -1, -1);
	}

	public TankReference(int tankSlot, int inputSlot, int outputSlot) {
		this.tankSlot = tankSlot;
		this.inputSlot = inputSlot;
		this.outputSlot = outputSlot;
	}

	public int tankSlot;
	public int inputSlot;
	public int outputSlot;
	Slot outputContainerSlot;
	Slot inputContainerSlot;
	TankHandler handler;
}
