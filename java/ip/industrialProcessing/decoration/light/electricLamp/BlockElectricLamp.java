package ip.industrialProcessing.decoration.light.electricLamp;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.machines.BlockMachine;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockElectricLamp extends BlockMachine {

    public BlockElectricLamp() {
	super(ConfigMachineBlocks.getBlockElectricLamp(), Material.glass, 1f, soundMetalFootstep, "Electric Lamp", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityElectricLamp();
    } 
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) { 
	TileEntity entity = world.getBlockTileEntity(x, y, z);
	if (entity instanceof TileEntityElectricLamp) {
	    TileEntityElectricLamp lamp = (TileEntityElectricLamp) entity;  
	    return lamp.getLightValue();
	}
	return super.getLightValue(world, x, y, z); 
    }
}
