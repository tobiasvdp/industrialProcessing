package mod.industrialProcessing.plants.transport.fluids.valve;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.blockContainer.transport.BlockTransport;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockValve extends BlockTransport {

	public BlockValve() {
		super(1.0f,1.0f, Material.glass, Block.soundTypeGlass, "valve");
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack par6ItemStack) {
		BlockContainerIP.setRotation(world, x, y, z, entityLivingBase);
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, par6ItemStack);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		TileEntityValve entity = (TileEntityValve) par1World.getTileEntity(par2, par3, par4);

		if (par5EntityPlayer.isSneaking()) {
			entity.openValveHit();
		} else {
			entity.closeValveHit();
		}
		return false;
	}
}
