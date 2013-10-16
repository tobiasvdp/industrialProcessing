package ip.industrialProcessing.decoration.light;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.config.ConfigBlocks;
import ip.industrialProcessing.config.ConfigMachineBlocks;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPetrolLamp extends BlockMachine {

    public BlockPetrolLamp() {
	super(ConfigMachineBlocks.getBlockPetrolLamp(), Material.glass, 1f, soundMetalFootstep, "Petrol Lamp", IndustrialProcessing.tabFluid);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
	return new TileEntityPetrolLamp();
    }

}
