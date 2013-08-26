package ip.industrialProcessing.multiblock.dummy;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.multiblock.core.TEmultiblockCore;
import ip.industrialProcessing.multiblock.interfaces.ITileEntityMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BLmultiblockDummy extends BlockContainer {

	public BLmultiblockDummy(int blockID, String name, CreativeTabs tab) {
		super(blockID, Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName(name);
		setCreativeTab(tab);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
		super.onNeighborBlockChange(world, x, y, z, par5);

	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		return true;
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int x, int y, int z) {
		boolean canPlace = true;
		int l = par1World.getBlockId(x, y, z);
		Block block = Block.blocksList[l];
		if (block != null) {
			if (!block.isBlockReplaceable(par1World, x, y, z))
				canPlace = false;
		}
		return canPlace;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEmultiblockDummy();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		((TEmultiblockDummy)world.getBlockTileEntity(x, y, z)).searchForCore();
	}
	
	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		TEmultiblockCore core = ((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).getCore();
		((TEmultiblockDummy) world.getBlockTileEntity(x, y, z)).delCore();
		world.setBlockToAir(x, y, z);
		if(core!=null)
		core.onLayoutChange();
		return true;
	}
}
