package ip.industrialProcessing.subMod.logic.old.function.and;

import ip.industrialProcessing.subMod.logic.IPLogic;
import ip.industrialProcessing.subMod.logic.config.ConfigLogic;
import ip.industrialProcessing.subMod.logic.old.transport.blockLogic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicAnd extends blockLogic {

	public BLlogicAnd() {
		super(ConfigLogic.getBLlogicAnd(), Material.iron, 5.0f, Block.soundMetalFootstep, "BLlogicAnd", IPLogic.tabLogic);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TElogicAnd();
	}

	@Override
	public int getRenderType() {
		return ConfigLogic.getRDlogicAnd();
	}

}
