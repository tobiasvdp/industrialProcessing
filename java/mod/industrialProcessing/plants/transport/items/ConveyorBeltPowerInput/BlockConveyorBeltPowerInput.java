package mod.industrialProcessing.plants.transport.items.ConveyorBeltPowerInput;

import java.util.Random;

import mod.industrialProcessing.blockContainer.BlockContainerIP;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorBeltPowerInput extends BlockContainerIP implements IDescriptionBlock {

	public BlockConveyorBeltPowerInput() {
		super(1.0f,1.0f, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public String getDescription() {
		return "Power connector for the conveyor belt.";
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6) {
		TileEntityConveyorBeltPowerInput me = (TileEntityConveyorBeltPowerInput) world.getTileEntity(x, y, z);
		me.unregister();
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block par5) {
		world.scheduleBlockUpdate(x, y, z, this, 5);
		super.onNeighborBlockChange(world, x, y, z, par5);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random par5Random) {
		TileEntityConveyorBeltPowerInput me = (TileEntityConveyorBeltPowerInput) world.getTileEntity(x, y, z);
		TileEntity te = world.getTileEntity(x, y + 1, z);
		if (me.hasLine()) {
			int id = me.conveyorLine;
			if (te instanceof TileEntityConveyorConnectionsBase) {
				if(id == ((TileEntityConveyorConnectionsBase) te).getLineID()){
					//all is well in the world
				}else{
					me.unregister();
					me.register();
				}
			}
			else{
				me.unregister();
			}
		} else {
			me.register();
		}
		super.updateTick(world, x, y, z, par5Random);
	}

}
