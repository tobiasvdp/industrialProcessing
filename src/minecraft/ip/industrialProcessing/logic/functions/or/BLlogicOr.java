package ip.industrialProcessing.logic.functions.or;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.utils.ISidedRotation;
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
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return par5;
	}

	@Override
	public void onPostBlockPlaced(World par1World, int par2, int par3, int par4, int par5) {
		ISidedRotation te = (ISidedRotation) par1World.getBlockTileEntity(par2, par3, par4);
		System.out.println(par5);
		super.onPostBlockPlaced(par1World, par2, par3, par4, par5);
	}

}
