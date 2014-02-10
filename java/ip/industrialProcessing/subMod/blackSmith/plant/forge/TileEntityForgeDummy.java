package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import ip.industrialProcessing.multiblock.core.ITileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherDummy;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityForgeDummy extends TileEntityMultiblockSwitcherDummy{

	@Override
	public boolean requirementToBecomeCore() {
		return true;
	}

	@Override
	public String unlocalizedCoreName() {
		return "IP.MBC.Forge";
	}

	public void handleRightClick(EntityPlayer player) {
		if(getCore() != null  && getCore() instanceof ITileEntityMultiblockCore){
			((TileEntityForgeCore)getCore()).handleRightClick(player);
		}
	}

}
