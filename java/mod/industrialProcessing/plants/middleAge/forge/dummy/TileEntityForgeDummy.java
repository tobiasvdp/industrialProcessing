package mod.industrialProcessing.plants.middleAge.forge.dummy;

import mod.industrialProcessing.blockContainer.multiblock.core.ITileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.TileEntityMultiblockSwitcherDummy;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.plants.middleAge.forge.TileEntityForgeCore;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityForgeDummy extends TileEntityMultiblockDummy{

	public void handleRightClick(EntityPlayer player) {
		if(getCore() != null  && getCore() instanceof ITileEntityMultiblockCore){
			((TileEntityForgeCore)getCore()).handleRightClick(player);
		}
	}

}
