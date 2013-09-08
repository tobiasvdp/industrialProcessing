package ip.industrialProcessing.power.plants;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;

public class BlockSolidBurner extends BlockMachine {

	public BlockSolidBurner() {
	super(ConfigMachineBlocks.getSolidBurnerBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Solid Burner", IndustrialProcessing.tabPower);
    }
	@Override
	public TileEntity createNewTileEntity(World world) { 
		return new TileEntitySolidBurner();
	}

}
