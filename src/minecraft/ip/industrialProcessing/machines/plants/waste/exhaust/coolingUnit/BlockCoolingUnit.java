package ip.industrialProcessing.machines.plants.waste.exhaust.coolingUnit;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.plants.metalProcessing.vacuumCaster.TileEntityVacuumCaster;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCoolingUnit   extends BlockMachineRendered {

	public BlockCoolingUnit() {
		super(ConfigMachineBlocks.getBlockCoolingUnitID(), Material.iron, 1f, Block.soundMetalFootstep, "BlockCoolingUnit", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityCoolingUnit te = new TileEntityCoolingUnit();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererCoolingUnitId();
	}

}
