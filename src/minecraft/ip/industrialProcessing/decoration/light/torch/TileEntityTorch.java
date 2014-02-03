package ip.industrialProcessing.decoration.light.torch;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import ip.industrialProcessing.decoration.light.TileEntityLamp;

public class TileEntityTorch extends TileEntityLamp {

    public TileEntityTorch() {
	this.burnTime = GameRegistry.getFuelValue(new ItemStack(Item.coal)) * 10;
    }

    @Override
    public float yOffset() {
	return 0.65F;
    }

    @Override
    public float xzOffset() {
	return 0.28F;
    }

    @Override
    public void addTo(EntityPlayer player) {

    }

    @Override
    protected void OnFuelUsed() {
	this.worldObj.destroyBlock(xCoord, yCoord, zCoord, true);
    }
}
