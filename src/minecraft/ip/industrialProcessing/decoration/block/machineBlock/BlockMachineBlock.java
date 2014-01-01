package ip.industrialProcessing.decoration.block.machineBlock;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.INamepace;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMachineBlock extends Block{
	private Icon[] icons = new Icon[2];
    public BlockMachineBlock() {
    	super(ConfigBlocks.blockMachineBlock(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BlockMachineBlock");
		setCreativeTab(IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererMachineBlockId();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Orange");
		icons[1] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Iron");
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
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;//super.canPlaceTorchOnTop(world, x, y, z);
	}
	
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		int dir = MathHelper.floor_double((par5EntityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, dir, 2);
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
	}
}
