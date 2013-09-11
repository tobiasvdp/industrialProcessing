package ip.industrialProcessing.logic.transport.wired.switchbox;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.wired.cable.TElogicCable;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BLlogicSwitchBox extends BlockMachineRendered {

	public BLlogicSwitchBox() {
		super(ConfigMachineBlocks.getBLlogicSwitchBox(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLlogicSwitchBox", IndustrialProcessing.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicSwitchBox();
	}
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) {
		ICommunicationNode com = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		com.createRandomName();
		com.sendDiscoveryPacket();
	}
	@Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		super.onBlockPlaced(par1World, par2, par3, par4, par5, par6, par7, par8, par9);
        return par5;
    }
	@Override
	public boolean removeBlockByPlayer(World world, EntityPlayer player, int x, int y, int z) {
		ICommunicationNode com = (ICommunicationNode) world.getBlockTileEntity(x, y, z);
		com.sendDestructionPacket();
		super.removeBlockByPlayer(world, player, x, y, z);
		return true;
	}
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		ICommunicationNode com = (ICommunicationNode) par1World.getBlockTileEntity(par2, par3, par4);
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			if (com.getBusType(dir) == UTBusType.bundle)
				com.send(dir, true,5);
			if (com.getBusType(dir) == UTBusType.cable)
				com.send(dir, true);
		}
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}	
	
	@Override
	public int getRenderType() {
		return ConfigRenderers.getBLlogicSwitchBox();
	}

}
