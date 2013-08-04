package ip.industrialProcessing.machines.filter;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.utils.inventories.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFilter extends BlockMachine {

	public BlockFilter() {
		super(IndustrialProcessingConfig.getFilterBlockID(), Material.iron, 1F,
				Block.soundMetalFootstep, "Ore Filter",
				IndustrialProcessing.tabMachines);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFilter();
	}
}
