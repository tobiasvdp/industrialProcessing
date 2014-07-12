package mod.industrialProcessing.plants.blackSmith.forge;

import mod.industrialProcessing.blockContainer.multiblock.core.ITileEntityMultiblockCore;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.TileEntityMultiblockSwitcherDummy;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityForgeDummy extends TileEntityMultiblockSwitcherDummy{

	@Override
	public boolean requirementToBecomeCore() {
		return true;
	}

	public void handleRightClick(EntityPlayer player) {
		if(getCore() != null  && getCore() instanceof ITileEntityMultiblockCore){
			((TileEntityForgeCore)getCore()).handleRightClick(player);
		}
	}

}
