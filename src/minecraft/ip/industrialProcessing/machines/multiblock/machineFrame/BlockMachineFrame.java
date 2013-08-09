package ip.industrialProcessing.machines.multiblock.machineFrame;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.multiblock.BlockMultiMachineFrame;
import ip.industrialProcessing.machines.multiblock.IMultiblockTileEntityFrame;
import ip.industrialProcessing.machines.multiblock.MachineFrameState;

public class BlockMachineFrame extends BlockMultiMachineFrame {

	public BlockMachineFrame() {

		super(ConfigMachineBlocks.getMachineFrameBlockID(),"BlockMachineFrame",
				IndustrialProcessing.tabMachines);

	} 

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineFrame();
	}

	@Override
	protected Icon registerIcon(IconRegister par1IconRegister,
			MachineFrameState state) { 
		switch (state) {
		case COMPLETED:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_full");
		case CONNECTED:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_empty");
		case DISCONNECTED:
		default:
			return par1IconRegister
					.registerIcon(IndustrialProcessing.TEXTURE_NAME_PREFIX
							+ "frame_disconnected");
		}
	}

}
