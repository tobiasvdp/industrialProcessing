package ip.industrialProcessing.machines.multiblock.machineFrame;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.multiblock.BlockMultiMachineFrame;
import ip.industrialProcessing.machines.multiblock.MachineFrameState;

public class BlockMachineFrame extends BlockMultiMachineFrame {

	public BlockMachineFrame(MachineFrameState state) {

		super(getID(state), IndustrialProcessing.tabMachines);
		switch (state) {
		case COMPLETED:
			this.func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX
					+ "frame_full");
			break;
		case CONNECTED:
			this.func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX
					+ "frame_empty");
			break;
		case DISCONNECTED:
		default:
			this.func_111022_d(IndustrialProcessing.TEXTURE_NAME_PREFIX
					+ "frame_disconnected");
			break;
		}
	}

	static int getID(MachineFrameState state) {
		switch (state) {
		case COMPLETED:
			return IndustrialProcessingConfig.getMachineFrameCompletedBlockID();
		case CONNECTED:
			return IndustrialProcessingConfig.getMachineFrameConnectedBlockID();
		case DISCONNECTED:
		default:
			return IndustrialProcessingConfig.getMachineFrameBlockID();
		}
	}

	@Override
	protected int getIdForState(MachineFrameState state) {
		return getID(state);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineFrame();
	}

}
