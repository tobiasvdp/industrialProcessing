package mod.industrialProcessing.plants.construction.weldingStation.dummy.screen;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.dummy.BlockMultiblockDummy;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockScreen extends BlockMultiblockDummy{

	private Icon[] icons = new Icon[1];

	public BlockScreen() {
		super(1.0f,1.0f,Material.iron,Block.soundTypeMetal,"iron_block");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.6f, 1.0f);
	}

	
}
