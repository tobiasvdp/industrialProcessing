package mod.industrialProcessing.plants.todo.core.plants.oilRefinary.fluidCatalyticCracker;

import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.multiblock.core.BlockMultiblockCore;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFluidCatalyticCracker extends BlockMultiblockCore{
	public BlockFluidCatalyticCracker(){
		super(ConfigMachineBlocks.getBlockFluidCatalyticCrackerID(), "BlockFluidCatalyticCracker", ISetupCreativeTabs.tabMultiblocks);
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
