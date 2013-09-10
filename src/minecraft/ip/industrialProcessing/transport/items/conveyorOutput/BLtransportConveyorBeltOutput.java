package ip.industrialProcessing.transport.items.conveyorOutput;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLtransportConveyorBeltOutput extends BlockMachine{

	public BLtransportConveyorBeltOutput() {
		super(ConfigMachineBlocks.getBLtransportConveyorBeltOutput(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLtransportConveyorBeltOutput", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEtransportConveyorBeltOutput();
	}

}
