package ip.industrialProcessing.machines;

import net.minecraft.item.ItemStack;

public class MachineItemStack {
	public MachineItemStack(ItemStack stack, int[] sides, boolean input,
			boolean output) {
		this.stack = stack;
		this.sides = sides;
		this.input = input;
		this.output = output;
	}
	public ItemStack stack;
	public int[] sides;
	public boolean input;
	public boolean output;
}
