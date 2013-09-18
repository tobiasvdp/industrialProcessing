package ip.industrialProcessing.logic.functions.or;

import java.util.Random;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.ISidedRotation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BLlogicOr extends BlockMachineRendered {

	public BLlogicOr() {
		super(ConfigMachineBlocks.getBLlogicOr(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLlogicOr", IndustrialProcessing.tabLogic);
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
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationNode com = (ICommunicationNode) world.getBlockTileEntity(x, y, z);
		com.createDestructionPacket();
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLlogicOr();
	}
}
