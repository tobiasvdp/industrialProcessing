package ip.industrialProcessing.subMod.logic.function.or;

import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.transport.blockLogic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicOr extends blockLogic {

	public BLlogicOr() {
		super(ConfigLogic.getBLlogicOr(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLlogicOr", IPLogic.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicOr();
	}
	@Override
	public int getRenderType() {
		return ConfigLogic.getRDlogicOr();
	}

}
