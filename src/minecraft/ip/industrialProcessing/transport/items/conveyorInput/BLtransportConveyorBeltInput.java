package ip.industrialProcessing.transport.items.conveyorInput;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLtransportConveyorBeltInput extends BlockMachine{

	public BLtransportConveyorBeltInput() {
		super(ConfigMachineBlocks.getBLtransportConveyorBeltInput(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLtransportConveyorBeltInput", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEtransportConveyorBeltInput();
	}

}
