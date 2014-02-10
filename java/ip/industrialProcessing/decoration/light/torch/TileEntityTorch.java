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
	return 0.68F;
    }

    @Override
    public float xzOffset() {
	return 0.25F;
    }

    @Override
    public void addTo(EntityPlayer player) {

    }

    @Override
    protected void OnFuelUsed() {
	this.worldObj.destroyBlock(xCoord, yCoord, zCoord, true);
    }
    
    @Override
	public int getLightLevel() {
		if (burnTime > 100) {
			if (burnTime == 5500)
				lightChanged = true;
			if (burnTime < 6000) {
				if (this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) < 6) {
					//this.worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) + 6, 2);
				}
				return 8;
			}
			return 15;
		}
		if (burnTime == 50)
			lightChanged = true;
		return 0;
	}
}
