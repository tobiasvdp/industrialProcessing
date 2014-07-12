package mod.industrialProcessing.items;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.utils.rotation.IRotateableEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemWrench extends ItemIP {

    public ItemWrench() {
        super();
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (side >= 2 && entity instanceof IRotateableEntity) {
            return false;
        }
        return super.onItemUseFirst(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
        TileEntity entity = world.getTileEntity(x, y, z);
        if (entity instanceof IRotateableEntity) {
            IRotateableEntity item = (IRotateableEntity) entity;
            if (item.canWrenchRotate()) {
                BlockContainerIP.setRotation(item, par2EntityPlayer);
                return true;
            }
        }
        return super.onItemUse(par1ItemStack, par2EntityPlayer, world, x, y, z, side, par8, par9, par10);
    }
}
