package ip.industrialProcessing.machines.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.pelletExtruder.TileEntityPelletExtruder;

public class BlockBlastFurnace extends BlockMachine{

	public BlockBlastFurnace() {
		super(ConfigMachineBlocks.getBlastFurnaceID(), Material.iron, 1F, Block.soundMetalFootstep, "Blast Furnace", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBlastFurnace(world);
	}

}
