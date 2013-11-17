package ip.industrialProcessing.logic.function.and;

import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.transport.blockLogic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BLlogicAnd  extends blockLogic {

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
