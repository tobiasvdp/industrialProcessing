package mod.industrialProcessing.blockContainer.machine.crusher;

import java.util.Iterator;

import net.minecraft.item.Item;
import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.blockContainer.machine.TileEntityMachineInv;
import mod.industrialProcessing.utils.rotation.LocalDirection;

public class TileEntityCrusher extends TileEntityMachineInv {

	//public static RecipesMachine recipes = new RecipesCrusher();

	public TileEntityCrusher() {
		//super(LocalDirection.LEFT, 10000, 100, true); // does 100 work per tick, lasts
												// 100 ticks
		this.addStack(null, LocalDirection.UP, true, false);
		this.addStack(null, LocalDirection.DOWN, false, true);
		//setupPowerSlot();
	}

	@Override
	protected boolean isValidInput(int slot, Item item) {
		return true;
	}
}
