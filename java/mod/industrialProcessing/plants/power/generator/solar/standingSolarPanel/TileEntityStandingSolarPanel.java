package mod.industrialProcessing.plants.power.generator.solar.standingSolarPanel;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCorePowerGenerator;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.utils.Sun;
import mod.industrialProcessing.utils.rotation.LocalDirection;
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
		layout.setCoreID(i++, 0, 1, IndustrialProcessing.blockStandingSolarPanel);

		for (int j = 1; j <= 3; j++)
			layout.setBlockID(0, -j, 0, i++, 0, 1, IndustrialProcessing.blockIronPole);
		layout.setBlockIDwithGroup(0, -4, 0, i++, 0, 1,2, IndustrialProcessing.blockIronPole);

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
