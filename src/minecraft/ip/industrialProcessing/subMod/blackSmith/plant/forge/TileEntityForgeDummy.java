package ip.industrialProcessing.subMod.blackSmith.plant.forge;

import ip.industrialProcessing.multiblock.coreAndDummy.TileEntityMultiblockSwitcherDummy;

public class TileEntityForgeDummy extends TileEntityMultiblockSwitcherDummy{

	@Override
	public boolean requirementToBecomeCore() {
		return true;
	}

	@Override
	public String unlocalizedCoreName() {
		return "IP.MBC.Forge";
	}

}
