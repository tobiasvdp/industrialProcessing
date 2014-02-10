package ip.industrialProcessing.subMod.power.plant.solar.standingSolarPanel;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCorePowerGenerator;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.subMod.power.config.ISetupPower;
import ip.industrialProcessing.utils.Sun;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityStandingSolarPanel extends TileEntityMultiblockCorePowerGenerator {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static Sun sun;
	private float lastCharge;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 0, 0, 0, 0, 4);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupPower.blockStandingSolarPanel.blockID);

		for (int j = 1; j <= 3; j++)
			layout.setBlockID(0, -j, 0, i++, 0, 1, ISetupMachineBlocks.blockIronPole.blockID);
		layout.setBlockIDwithGroup(0, -4, 0, i++, 0, 1,2, ISetupMachineBlocks.blockIronPole.blockID);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityStandingSolarPanel() {
		super(structure, tierRequirments);
		LocalDirection[] nodirections = new LocalDirection[0];
		sun = new Sun();
	}

	@Override
	public float getCharge(float q) {
		this.lastCharge = q;
		return q;
	}

	@Override
	public float getVoltage() {
		if (!worldObj.isRemote) {
			return sun.getSunLight(getWorldObj());
		}
		return 0;
	}

	@Override
	public boolean canOutputPower(ForgeDirection opposite) {
		return canOutputPower(0,opposite);
	}

	@Override
	public void updateEntity() {
		sun.getSunLight(this.worldObj);
		super.updateEntity();
	}

	@Override
	public boolean canOutputPower(int group, ForgeDirection opposite) {
		if(group == 2 && ForgeDirection.getOrientation(transformSideToLayoutSide(opposite.ordinal())) == ForgeDirection.NORTH){
			return true;
		}
		return false;
	}
}
