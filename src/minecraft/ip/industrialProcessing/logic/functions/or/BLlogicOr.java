package ip.industrialProcessing.logic.functions.or;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BLlogicOr extends BlockContainer {

	public BLlogicOr() {
		super(ConfigMachineBlocks.getBLlogicOr(), Material.iron);
		setHardness(5.0f);
		setUnlocalizedName("BLlogicOr");
		setCreativeTab(IndustrialProcessing.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicOr();
	}
	@Override
	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5, ItemStack par6ItemStack) {
System.out.println("BLlogicOr.canPlaceBlockOnSide()");
		return super.canPlaceBlockOnSide(par1World, par2, par3, par4, par5, par6ItemStack);
	}
	@Override
	public boolean rotateBlock(World worldObj, int x, int y, int z, ForgeDirection axis) {
System.out.println("BLlogicOr.rotateBlock()");
return true;
	}
	

}
