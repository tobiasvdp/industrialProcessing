package ip.industrialProcessing.logic.transport.wired.switchbox;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicSwitchBox extends BlockContainer {

	public BLlogicSwitchBox() {
		super(ConfigMachineBlocks.getBLlogicSwitchBox(), Material.iron);
		setHardness(5.0f);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("BLlogicSwitchBox");
		setCreativeTab(IndustrialProcessing.tabLogic);
		func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX + "inputTop");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicSwitchBox();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLivingBase, par6ItemStack);
		ICommunicationNode com = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		com.sendDiscoveryPacket();
	}
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
		ICommunicationNode com = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		com.sendDestructionPacket();
	}

}
