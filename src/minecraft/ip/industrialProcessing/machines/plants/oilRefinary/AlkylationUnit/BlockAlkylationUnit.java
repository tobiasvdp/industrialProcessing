package ip.industrialProcessing.machines.plants.oilRefinary.AlkylationUnit;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.config.ConfigRenderers;
import ip.industrialProcessing.machines.BlockMachineRendered;
import ip.industrialProcessing.machines.plants.oilRefinary.sourWaterStripper.TileEntitySourWaterStripper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAlkylationUnit  extends BlockMachineRendered {

	public BlockAlkylationUnit() {
		super(ConfigMachineBlocks.getAlkylationUnitBlockID(), Material.iron, 1F, Block.soundMetalFootstep, "AlkylationUnit", IndustrialProcessing.tabOreProcessing);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAlkylationUnit();
	}
	
    @Override
    public int getRenderType()
    {
        return ConfigRenderers.getRendererAlkylationUnitId();
    }

}
