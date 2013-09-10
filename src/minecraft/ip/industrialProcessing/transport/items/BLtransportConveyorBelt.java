package ip.industrialProcessing.transport.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BLtransportConveyorBelt extends BlockMachineRendered{

	public BLtransportConveyorBelt() {
		super(ConfigMachineBlocks.getBLtransportConveyorBelt(), Material.iron, 5.0f, Block.soundMetalFootstep, "", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEtransportConveyorBelt();
	}
	
    @Override
    public int getRenderType() {
    	return ConfigRenderers.getBLtransportConveyorBelt();
    }

}
