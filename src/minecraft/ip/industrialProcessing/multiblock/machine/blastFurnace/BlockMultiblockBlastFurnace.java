package ip.industrialProcessing.multiblock.machine.blastFurnace;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockCore;

public class BlockMultiblockBlastFurnace extends BlockMultiblockCore{

	public BlockMultiblockBlastFurnace() {
		super(ConfigMachineBlocks.getBlockMultiblockBlastFurnaceID(), Material.iron, 1F, Block.soundMetalFootstep, "Large blast furnace", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockBlastFurnace();
	}

}
