package ip.industrialProcessing.logic.transport;

import java.util.Random;

import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.rotation.ISidedRotation;

public abstract class blockLogic extends BlockMachineRendered{

	public blockLogic(int par1, Material par2Material, float hardness, StepSound stepSound, String name, CreativeTabs tab) {
		super(par1, par2Material, hardness, stepSound, name, tab);
	}
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return par5;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		ISidedRotation te = (ISidedRotation) par1World.getBlockTileEntity(par2, par3, par4);

		te.setOrientationSide(par1World.getBlockMetadata(par2, par3, par4));
		te.setOrientationRotation(par5EntityLivingBase.rotationYaw, par5EntityLivingBase.rotationPitch);

		if (par5EntityLivingBase.isSneaking()) {
			te.setOrientationRotation(te.getOrientationRotation().getOpposite());
		}

		ICommunicationNode com = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		com.createDiscoveryPacket();

		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		ICommunication com = (ICommunication) par1World.getBlockTileEntity(par2, par3, par4);
		com.Send();
		super.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float clickX, float clickY, float clickZ) {
		ICommunicationNode com = (ICommunicationNode) world.getBlockTileEntity(x, y, z);
		if(((UTVariable)com.getBuffer(ForgeDirection.NORTH).get(0)).value != null && ((Boolean)((UTVariable)com.getBuffer(ForgeDirection.NORTH).get(0)).value) == false)
			com.createDataPacket(ForgeDirection.NORTH, new UTVariable(0,0,true));
		else
			com.createDataPacket(ForgeDirection.NORTH, new UTVariable(0,0,false));
		return super.onBlockActivated(world, x, y, z, player, metadata, clickX, clickY, clickZ);
	}

	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationNode com = (ICommunicationNode) world.getBlockTileEntity(x, y, z);
		com.createDestructionPacket();
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		if (par1World.isRemote)
			par1World.markBlockForUpdate(par2, par3, par4);
		super.onBlockAdded(par1World, par2, par3, par4);
	}
	@Override
	public abstract int getRenderType();
}
