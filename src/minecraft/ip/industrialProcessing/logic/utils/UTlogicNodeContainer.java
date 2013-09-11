package ip.industrialProcessing.logic.utils;

import ip.industrialProcessing.logic.transport.ICommunication;
import ip.industrialProcessing.logic.transport.ICommunicationNode;

import java.util.ArrayList;

public class UTlogicNodeContainer {
	private ArrayList<ICommunicationNode> nodes= new  ArrayList<ICommunicationNode>();
	
	public UTlogicNodeContainer(){}
	
	public void add(ICommunicationNode te){
		nodes.add(te);
	}
	
	public void remove(ICommunicationNode te){
		nodes.remove(te);
	}
	
	public void clear(){
		nodes.clear();
	}
	
	public void writeToNBT(){
		
	}
	
	public void readFromNBT(){
		
	}

	public boolean contains(ICommunicationNode node) {
		return nodes.contains(node);
	}

	public void notifyOfRemoval(ICommunicationNode removeNode) {
		for(ICommunicationNode node:nodes){
			node.removeNode(removeNode);
		}
	}
	
}
