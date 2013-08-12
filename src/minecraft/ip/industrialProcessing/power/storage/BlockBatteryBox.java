package ip.industrialProcessing.power.storage;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material; 
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachineRendered;

public class BlockBatteryBox extends BlockMachineRendered {

    public BlockBatteryBox() {
	super(ConfigMachineBlocks.getBatteryBoxBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Battery Box", IndustrialProcessing.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityBatteryBox();
    }

}
