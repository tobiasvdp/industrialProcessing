package mod.industrialProcessing.gui.framework.slots;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotArmor  extends SlotBase
{
    /**
     * The armor type that can be placed on that slot, it uses the same values of armorType field on ItemArmor.
     */
    public final int armorType;

    /**
     * The parent class of this clot, ContainerPlayer, SlotArmor is a Anon inner class.
     */
    final Entity parent;

    public SlotArmor(Entity par1ContainerPlayer, IInventory par2IInventory, int par3, int par4, int par5, int par6)
    {
        super(par2IInventory, par3, par4, par5);
        this.parent = par1ContainerPlayer;
        this.armorType = par6;
    }

    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */
    @Override
	public int getSlotStackLimit()
    {
        return 1;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
	public boolean isItemValid(ItemStack par1ItemStack)
    {
        Item item = (par1ItemStack == null ? null : par1ItemStack.getItem());
        return item != null && item.isValidArmor(par1ItemStack, armorType, parent);
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * Returns the icon index on items.png that is used as background image of the slot.
     */
    public IIcon getBackgroundIconIndex()
    {
        return ItemArmor.func_94602_b(this.armorType);
    }
}
