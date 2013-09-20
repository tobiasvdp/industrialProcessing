package ip.industrialProcessing.transport.items.conveyorBelt;

import java.util.List;
import java.util.Random;

import ic2.api.item.Items;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.machines.BlockMachineRendered;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockConveyorBelt extends BlockConveyorBase {

	public BlockConveyorBelt() {
		super(ConfigMachineBlocks.getBlockTransportConveyorBelt(), Material.iron, 5.0f, Block.soundMetalFootstep, "Conveyor", IndustrialProcessing.tabPower);

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityConveyorBelt();
	}

	@Override
	public int getRenderType() {
		return ConfigRenderers.getRendererConveyorBeltID();
	}

}
