package ip.industrialProcessing.logic.functions.or;

import java.util.Random;

import ip.industrialProcessing.logic.IPLogic;
import ip.industrialProcessing.logic.config.ConfigLogic;
import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;
import ip.industrialProcessing.logic.transport.ICommunicationTransport;
import ip.industrialProcessing.logic.transport.blockLogic;
import ip.industrialProcessing.logic.utils.UTVariable;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.utils.rotation.ISidedRotation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

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
