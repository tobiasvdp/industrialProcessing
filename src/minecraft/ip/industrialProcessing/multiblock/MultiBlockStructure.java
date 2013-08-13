package ip.industrialProcessing.multiblock;

import java.util.ArrayList;

public class MultiBlockStructure {
	private ArrayList<MultiBlockStructureBlockDescription> descriptions = new ArrayList<MultiBlockStructureBlockDescription>();
	//private MultiBlockStructureBlockDescription[] descriptions;

	public MultiBlockStructure(MultiBlockStructureBlockDescription... blockDescriptions)
	{
		for (int i = 0;i<blockDescriptions.length;i++){
			this.descriptions.add(blockDescriptions[i]);
		}
		
	}
	public MultiBlockStructure(){}
	public void addStructure(MultiBlockStructureBlockDescription block){
		this.descriptions.add(block);
	}
	
	public MultiBlockStructureBlockDescription[] getDescriptions() {
		return descriptions.toArray(new MultiBlockStructureBlockDescription[descriptions.size()]);
	}
}
