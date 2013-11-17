package ip.industrialProcessing.machines.pelletExtruder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockPelletExtruder extends BlockMachine{

	public BlockPelletExtruder() {
		super(ConfigMachineBlocks.getPelletExtruderID(), Material.iron, 1F, Block.soundMetalFootstep, "Pellet Extruder", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityPelletExtruder te = new TileEntityPelletExtruder();
		te.setName(getLocalizedName());
		return te;
	}

}
