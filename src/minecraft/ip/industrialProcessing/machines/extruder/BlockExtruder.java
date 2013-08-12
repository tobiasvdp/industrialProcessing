package ip.industrialProcessing.machines.extruder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;

public class BlockExtruder extends BlockMachine{

	public BlockExtruder() {
		super(ConfigMachineBlocks.getExtruderID(), Material.iron, 1F, Block.soundMetalFootstep, "Extruder", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityExtruder();
	}

}
