package ip.industrialProcessing.logic.functions.and;

import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.blockLogic;
import ip.industrialProcessing.logic.transport.wired.switchbox.TElogicSwitchBox;
import ip.industrialProcessing.logic.utils.UTBusType;
import ip.industrialProcessing.machines.BlockMachineRendered;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

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
