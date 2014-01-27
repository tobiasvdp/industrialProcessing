package ip.industrialProcessing.subMod.logic.network.interfaces.machine;

import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.transport.blockLogic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineInterface extends blockLogic {

	public BlockMachineInterface() {
		super(ConfigLogic.getBlockMachineInterface(), Material.iron, 1.0f, Block.soundMetalFootstep, "BlockMachineInterface", IPLogic.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMachineInterface();
	}

	@Override
	public int getRenderType() {
		return 0;
	}

}
