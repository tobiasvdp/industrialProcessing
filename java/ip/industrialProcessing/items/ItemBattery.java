package ip.industrialProcessing.items;

import ip.industrialProcessing.config.ConfigItems;
import ip.industrialProcessing.config.ISetupCreativeTabs;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBattery extends ItemDamage {

    private final static float DEFAULT_VOLTAGE = 12f;
    private final static int DEFAULT_MAX_CHARGE = 100000; // IN j

    private float voltage;

    public ItemBattery() {
        super(ConfigItems.getItemBatteryID(), "itemBattery", ISetupCreativeTabs.tabPower, DEFAULT_MAX_CHARGE);
        this.voltage = DEFAULT_VOLTAGE;
    }

    // constructor to create custom batteries.
    public ItemBattery(int id, String name, float voltage, int maxCharge) {
        super(id, "itemBattery", ISetupCreativeTabs.tabPower, maxCharge);
        this.voltage = voltage;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        //super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        if (par1ItemStack != null) {
            int max = par1ItemStack.getMaxDamage(); // in j
            int charge = max - par1ItemStack.getItemDamage(); // in j

            float convertion = (voltage * 3.600f);
            float ah = charge / convertion;
            float maxAh = max / convertion;
            par3List.add(String.format("%.2fV  %.2f/%.2fmAh", voltage, ah, maxAh));
        }
    }
}
