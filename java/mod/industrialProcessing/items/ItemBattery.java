package mod.industrialProcessing.items;

import java.util.List;

import mod.industrialProcessing.creativeTab.ISetupCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBattery extends ItemDamage {

    private final static float DEFAULT_VOLTAGE = 12f;
    private final static int DEFAULT_MAX_CHARGE = 100000; // IN j

    private float voltage;

    public ItemBattery() {
        super(DEFAULT_MAX_CHARGE);
        this.voltage = DEFAULT_VOLTAGE;
    }

    public ItemBattery(float voltage, int maxCharge) {
        super(maxCharge);
        this.voltage = voltage;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
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
