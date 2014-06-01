package mod.industrialProcessing.blockContainer.multiblock.core.block.decoration.garageDoor;

import javax.swing.Icon;

import mod.industrialProcessing.blockContainer.multiblock.core.BlockMultiblockCore;
import mod.industrialProcessing.items.ISetupItems;
import mod.industrialProcessing.utils.INamepace;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.creativeTab.ISetupCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGarageDoor extends BlockMultiblockCore implements IDescriptionBlock{

	public BlockGarageDoor() {
		super(1.0f,1.0f,Material.iron,soundTypeMetal, "blockGarageFrame");
	}

	@Override
	public String getDescription() {
		return "Gearbox for the garage door.";
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float what, float these, float are) {
    	if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().equals(ISetupItems.itemRemote))
    		return false;
		return super.onBlockActivated(world, x, y, z, player, metadata, what, these, are);
	}
}
