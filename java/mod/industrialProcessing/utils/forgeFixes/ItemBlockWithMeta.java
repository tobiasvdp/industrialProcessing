package mod.industrialProcessing.utils.forgeFixes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockWithMeta extends ItemBlock {
	private Block field_150950_b;
	private static final String __OBFID = "CL_00001769";

	public ItemBlockWithMeta(Block p_i45326_1_) {
		super(p_i45326_1_);
		this.field_150950_b = p_i45326_1_;
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return this.field_150950_b.getIcon(2, par1);
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	public int getMetadata(int par1) {
		return par1;
	}
}
