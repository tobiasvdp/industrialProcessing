package ip.industrialProcessing.machines.multiblock.inventory;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.multiblock.BlockMultiMachineFrame;
import ip.industrialProcessing.machines.multiblock.MachineFrameState;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMultiMachineInput extends BlockMultiMachineFrame {

	private Icon completedIcon;
	private Icon connectedIcon;
	private Icon disconnectedIcon;
	
	public BlockMultiMachineInput() {
		super(ConfigMachineBlocks.getMultiMachineInputBlockID(),"BlockMultiMachineInventory",
				IndustrialProcessing.tabMachines);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiMachineInput();
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
