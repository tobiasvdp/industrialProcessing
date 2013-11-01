package ip.industrialProcessing.multiblock.core.block.plants.oilRefinary.fluidCatalyticCracker;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.multiblock.core.BLmultiblockCore;

public class BlockFluidCatalyticCracker extends BLmultiblockCore{
	public BlockFluidCatalyticCracker(){
		super(ConfigMachineBlocks.getBlockFluidCatalyticCrackerID(), "BlockFluidCatalyticCracker", IndustrialProcessing.tabMultiblocks);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFluidCatalyticCracker();
	}
	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererFluidCatalyticCracker();
	}
}
