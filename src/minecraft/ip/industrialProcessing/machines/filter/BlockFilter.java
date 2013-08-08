package ip.industrialProcessing.machines.filter;

import java.util.List;

import javax.jws.Oneway;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachine {

	private Icon[] textures;
	
	public BlockFilter() {
		super(ConfigMachineBlocks.getFilterBlockID(), Material.iron, 1F,
		Block.soundMetalFootstep, "Ore Filter",
		IndustrialProcessing.tabMachines);
	}			
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		textures = new Icon[1];
		textures[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX+ "crusher_side");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		   return this.textures[0];
	}

    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererFilterId();
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
    public int getRenderBlockPass()
	{
	            return 1;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFilter();
	}
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
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
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int metadata, float what, float these,
			float are) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (tileEntity == null || player.isSneaking()) {
			return false;
		}
		player.openGui(IndustrialProcessing.instance, 0, world, x, y, z);
		return true;
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack){
		int dir = MathHelper.floor_double((double)((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, dir, 0);
        EntityPlayer player = (EntityPlayer) entityLivingBase;
        player.addStat(IndustrialProcessing.achPlacedFilter, 1);
	}
}
