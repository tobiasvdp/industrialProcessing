package ip.industrialProcessing.machines.multiblock;

public class MultiBlockStructure {
	private MultiBlockStructureBlockDescription[] descriptions;

	public MultiBlockStructure(MultiBlockStructureBlockDescription... blockDescriptions)
	{
		this.descriptions = blockDescriptions;
	}
	
	public MultiBlockStructureBlockDescription[] getDescriptions() {
		return descriptions;
	}
}
