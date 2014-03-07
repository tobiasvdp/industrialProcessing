package mod.industrialProcessing.blockContainer.multiblock.tier;

public enum Tiers {
	Tier0, Tier1, Tier2, Tier3, Tier4, Invalid,all;

	public Tiers getPrevTier() {
		for (Tiers tier : Tiers.values()) {
			if(tier.ordinal() == this.ordinal()-1)
				return tier;
		}
		return Invalid;
	}

	public Tiers getNextTier() {
		for (Tiers tier : Tiers.values()) {
			if(tier.ordinal() == this.ordinal()+1)
				return tier;
		}
		return Invalid;
	}
}
