package ip.industrialProcessing.power.storage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material; 
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.config.ISetupCreativeTabs;
import ip.industrialProcessing.power.BlockPowerGenerator;

public class BlockEnergyCell extends BlockPowerGenerator {

    public BlockEnergyCell() {
	super(ConfigMachineBlocks.getEnergyCellBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "Battery Box", ISetupCreativeTabs.tabPower);
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityEnergyCell();
    } 

    @Override
    public int getRenderType() {
	return ConfigRenderers.getRendererEnergyCellId();
    }
}
