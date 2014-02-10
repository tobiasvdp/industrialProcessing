package ip.industrialProcessing.multiblock.tier;

public class TierCollection {

	private int size;
	private Tier[] tiers;
	
	public TierCollection(int size) {
		tiers = new Tier[size];
		this.size = size;
	}

	public int getAmountTiers() {
		return size;
	}
	
	public void addTier(Tier tier, Tiers level){
		tiers[level.ordinal()] = tier;
	}
	
	public Tier getTier(Tiers level){
		return tiers[level.ordinal()];
	}

	public boolean hasTier(Tiers nextTier) {
		if(nextTier.ordinal() < size){
			return true;
		}
		return false;
	}

}
