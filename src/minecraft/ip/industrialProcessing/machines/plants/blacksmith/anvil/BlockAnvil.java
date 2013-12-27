package ip.industrialProcessing.machines.plants.blacksmith.anvil;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.client.ClientProxy;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;
import ip.industrialProcessing.machines.plants.blacksmith.grindingStone.TileEntityGrindingStone;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockAnvil extends Block {

	private Icon[] icons = new Icon[1];

	public BlockAnvil() {
		super(ConfigMachineBlocks.getBlockAnvilID(), Material.iron);
		setHardness(1F);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("Anvil");
		setCreativeTab(IndustrialProcessing.tabOreProcessing);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.8f, 1.0f);
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererAnvilId();
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		par1 %= icons.length;
		return icons[par1];
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		icons[0] = par1IconRegister.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX + "Anvil");
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
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		if (player.isSneaking()) {
			return false;
		} else {
			player.openGui(IndustrialProcessing.instance,2, world, x, y, z);
			return true;
		}
	}

}
