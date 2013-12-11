package ip.industrialProcessing.utils;

import ip.industrialProcessing.IndustrialProcessing;

import java.util.ArrayList;

public class SuspensionList {
	public ArrayList<Integer> list = new ArrayList<Integer>();
	public void add(int id){
		list.add(id);
	}
	public boolean isSuspension(int ID){
		return list.contains(ID);
	}
}
