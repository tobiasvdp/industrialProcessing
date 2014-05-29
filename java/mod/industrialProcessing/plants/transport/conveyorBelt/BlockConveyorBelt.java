package mod.industrialProcessing.plants.transport.conveyorBelt;

import mod.industrialProcessing.transport.items.conveyorBelt.block.BlockConveyorBase;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockConveyorBelt extends BlockConveyorBase {

	public BlockConveyorBelt() {
		super(5.0f,5.0f, Material.iron, Block.soundTypeMetal,"conveyor");

	}
}
