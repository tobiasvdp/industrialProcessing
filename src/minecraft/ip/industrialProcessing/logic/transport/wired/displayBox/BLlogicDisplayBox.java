package ip.industrialProcessing.logic.transport.wired.displayBox;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicDisplayBox extends BlockContainer {

	public BLlogicDisplayBox() {
		super(ConfigLogic.getBLlogicDisplayBox(), Material.iron);
		setHardness(5.0f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BLlogicDisplayBox");
		setCreativeTab(IPLogic.tabLogic);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicDisplayBox();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
		ICommunicationTransport comTrans = (ICommunicationTransport) par1World.getBlockTileEntity(par2, par3, par4);
		ICommunicationNode comNode = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		comTrans.isEnabled(true);
		//comTrans.requestRecheck();
	}
	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationTransport comTrans = (ICommunicationTransport) world.getBlockTileEntity(x, y, z);
		ICommunicationNode comNode = (ICommunicationNode) world.getBlockTileEntity(x, y, z);
		comTrans.isEnabled(false);
		//comTrans.requestRecheck();
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}

}
