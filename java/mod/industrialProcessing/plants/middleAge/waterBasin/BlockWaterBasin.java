package mod.industrialProcessing.plants.middleAge.waterBasin;

import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.BlockMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.ITileEntityMultiblockSwitcher;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionMultiblock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWaterBasin extends BlockMultiblockSwitcher implements IDescriptionMultiblock{


	public BlockWaterBasin() {
		super(1.0f,1.0f,Material.rock,Block.soundTypeStone,"Cobble");
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
		ITileEntityMultiblockSwitcher switcher = (ITileEntityMultiblockSwitcher) world.getTileEntity(x, y, z);
		if (switcher.isCore()) {
			TileEntityWaterBasinCore te = (TileEntityWaterBasinCore) world.getTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		} else {
			TileEntityWaterBasinDummy te = (TileEntityWaterBasinDummy) world.getTileEntity(x, y, z);
			if (player.getCurrentEquippedItem() != null) {
				te.handleRightClick(player);
			}
		}
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}

	@Override
	public String getDescription() {
		return "For a nice little swim. Also good to cool down your hot iron.";
	}

	@Override
	public StructureMultiblock getStructure() {
		return TileEntityWaterBasinCore.structure;
	}
}
