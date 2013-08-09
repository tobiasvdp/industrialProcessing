package ip.industrialProcessing.machines;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
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

public class BlockMachineRendered extends BlockMachine {

	public BlockMachineRendered(int par1, Material par2Material,
			float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	@Override
	public boolean isOpaqueCube()
	{
	   return false;
	}
	@Override
    public boolean renderAsNormalBlock(){                
		return false;        
	}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
    @Override
    public int getRenderBlockPass()
	{
	            return 1;
	}
    @Override
    public boolean canRenderInPass(int pass)
	{
    	// this looks weird??????
	    //Set the static var in the client proxy
	    ClientProxy.renderPass = pass;
	    //the block can render in both passes, so return true always
	    return true;
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack){
		int dir = MathHelper.floor_double((double)((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
        EntityPlayer player = (EntityPlayer) entityLivingBase;
	}
}
