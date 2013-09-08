package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockBoiler extends BlockMachine {

	public BlockBoiler() {
		super(ConfigMachineBlocks.getBoilerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Steam Boiler", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityBoiler();
	}
}
