package ip.industrialProcessing.machines.wireMill;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.crusher.TileEntityCrusher;

public class BlockWireMill extends BlockMachineRendered {
	public BlockWireMill() {
		super(ConfigMachineBlocks.getWireMillBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Wire Mill", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		TileEntityWireMill te = new TileEntityWireMill();
		te.setName(getLocalizedName());
		return te;
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererWireMillId();
	}
}
