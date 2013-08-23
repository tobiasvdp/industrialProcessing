package ip.industrialProcessing.multiblock.block.power;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.multiblock.BlockMultiblockBlock;
import ip.industrialProcessing.multiblock.utils.MultiblockState;

public class BlockMultiblockPowerInput extends BlockMultiblockBlock{

	public BlockMultiblockPowerInput() {
		super(ConfigMachineBlocks.getBlockMultiblockPowerID(), "BlockMultiblockPowerInput", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiblockPowerInput();
	}

	@Override
	protected Icon registerIcon(IconRegister iconRegister, MultiblockState state) {
		return null;
	}


}
