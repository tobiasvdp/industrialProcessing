package ip.industrialProcessing.machines.plants.nonFerroProcessing.quenchTank;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.plants.metalProcessing.sandCaster.TileEntitySandCaster;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockQuenchTank extends BlockMachineRendered {

	public BlockQuenchTank() {
		super(ConfigMachineBlocks.getBlockQuenchTankID(), Material.iron, 1f, Block.soundMetalFootstep, "BlockQuenchTank", IndustrialProcessing.tabOreProcessing); 
	}

	@Override
	public TileEntity createNewTileEntity(World world) { 
		TileEntityQuenchTank te = new TileEntityQuenchTank();
		te.setName(getLocalizedName());
		return te;
	}

	
	@Override
	public int getRenderType() { 
		return ConfigRenderers.getRendererQuenchTankId();
	}

}
