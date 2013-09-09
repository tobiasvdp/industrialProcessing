package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockTurbine extends BlockMachine {

	public BlockTurbine() {
		super(ConfigMachineBlocks.getSteamTurbineBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Steam Turbine", IndustrialProcessing.tabPower);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityTurbine();
	}

}
