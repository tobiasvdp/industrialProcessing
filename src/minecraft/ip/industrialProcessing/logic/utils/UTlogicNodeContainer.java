package ip.industrialProcessing.logic.utils;

import ip.industrialProcessing.logic.transport.ICommunicationNode;

import java.util.ArrayList;

import net.minecraftforge.common.ForgeDirection;

public class UTlogicNodeContainer {
	private ArrayList<ICommunicationNode> nodes= new  ArrayList<ICommunicationNode>();
	private ArrayList<ForgeDirection> sides= new  ArrayList<ForgeDirection>();
	
	public UTlogicNodeContainer(){}
	
	public void add(ICommunicationNode te){
		nodes.add(te);
	}
	
	public void remove(ICommunicationNode te){
		for(int i =0;i<nodes.size();i++){
			if(nodes.get(i) == te){
				nodes.remove(i);
				sides.remove(i);
			}
		}
	}
	
	public void clear(){
		nodes.clear();
		sides.clear();
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

	public ArrayList<ICommunicationNode> iterate() {
		return nodes;
	}

	public void addSide(ForgeDirection originSide) {
		sides.add(originSide);
	}

	public int getSize() {
		return nodes.size();
	}

	public ICommunicationNode getNode(int i) {
		return nodes.get(i);
	}
	public ForgeDirection getSide(int i) {
		return sides.get(i);
	}
	
}
