package ip.industrialProcessing.transport;

import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTransport extends BlockContainer {

	public BlockTransport(int par1, String name) {
		super(par1, Material.glass);
		setHardness(5F);
		setStepSound(Block.soundAnvilFootstep);
		setUnlocalizedName(name);
		setCreativeTab(IndustrialProcessing.tabMachines);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
	}
	
    @Override
    public TileEntity createNewTileEntity(World world) {
	return null;
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
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
	return false;
    }

    @Override
    public int getRenderBlockPass() {
	return 1;
    }

    @Override
    public boolean canRenderInPass(int pass) {
	// this looks weird??????
	// Set the static var in the client proxy
	ClientProxy.renderPass = pass;
	// the block can render in both passes, so return true always
	return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    	return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
    	super.breakBlock(world, x, y, z, par5, par6);
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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
	int dir = MathHelper.floor_double((double) ((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	world.setBlockMetadataWithNotify(x, y, z, dir, 0);
    }

}
