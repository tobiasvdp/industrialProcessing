package ip.industrialProcessing.machines.crusher;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.IndustrialProcessingConfig;
import ip.industrialProcessing.machines.BlockMachine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCrusher extends BlockMachine {

	public BlockCrusher() {
		super(IndustrialProcessingConfig.getCrusherBlockID(), Material.iron,
				1F, Block.soundMetalFootstep, "Ore Crusher",
				IndustrialProcessing.tabMachines);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCrusher();
	}

}
