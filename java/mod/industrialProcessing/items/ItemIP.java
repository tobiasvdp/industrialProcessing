package mod.industrialProcessing.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemIP extends Item {

	private String formula;

	public ItemIP() {
		super();
		setMaxStackSize(64);
	}

	public ItemIP(String formula) {
		this();
		this.formula = formula;
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (this.formula != null)
			par3List.add("\u00A7a" + formula);
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	}
}
