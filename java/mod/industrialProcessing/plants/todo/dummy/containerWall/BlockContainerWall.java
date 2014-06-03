package mod.industrialProcessing.plants.todo.dummy.containerWall;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.utils.INamepace;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockContainerWall extends BlockMultiblockDummy{

    Icon[] icons = new Icon[1];
	public BlockContainerWall() {
		super(1.0f,1.0f,Material.iron,soundTypeMetal,"red");
	}

}
