package ip.industrialProcessing.logic.transport.wired.bundle;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicBundle extends BlockContainer{

	public BLlogicBundle() {
		super(ConfigMachineBlocks.getBLlogicBundle(), Material.circuits);
		setHardness(5.0f);
		setStepSound(Block.soundPowderFootstep);
		setUnlocalizedName("BLlogicBundle");
		setCreativeTab(IndustrialProcessing.tabLogic);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicBundle();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
		ICommunicationTransport com = (ICommunicationTransport) par1World.getBlockTileEntity(par2, par3, par4);
		com.isEnabled(true);
		//com.requestRecheck();
	}
	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationTransport com = (ICommunicationTransport) world.getBlockTileEntity(x, y, z);
		com.isEnabled(false);
		//com.requestRecheck();
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}

}
