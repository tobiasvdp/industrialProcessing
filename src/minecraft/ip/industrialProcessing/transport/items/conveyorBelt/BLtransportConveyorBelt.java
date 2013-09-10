package ip.industrialProcessing.transport.items.conveyorBelt;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.power.wire.TileEntityWire;

public class BLtransportConveyorBelt extends BlockMachineRendered{

	public BLtransportConveyorBelt() {
		super(ConfigMachineBlocks.getBLtransportConveyorBelt(), Material.iron, 5.0f, Block.soundMetalFootstep, "", IndustrialProcessing.tabPower);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1f, 1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEtransportConveyorBelt();
	}
	
    @Override
    public int getRenderType() {
    	return ConfigRenderers.getBLtransportConveyorBelt();
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
    	super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
		TEtransportConveyorBelt conveyorBelt = (TEtransportConveyorBelt) world.getBlockTileEntity(x, y, z);
		conveyorBelt.searchForConnections();
    }
    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
	super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
		TEtransportConveyorBelt conveyorBelt = (TEtransportConveyorBelt) par1World.getBlockTileEntity(par2, par3, par4);
		conveyorBelt.searchForConnections();
    }
}
