package ip.industrialProcessing.subMod.power.plant.creative;

import ip.industrialProcessing.power.BlockPowerGenerator;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends BlockPowerGenerator {

    public BlockCreativeGenerator() {
	super(0, null, 0, null, null, null);
	// TODO Auto-generated constructor stub
    }

    @Override
    public TileEntity createNewTileEntity(World world) { 
	return new TileEntityCreativeGenerator();
    }

}
