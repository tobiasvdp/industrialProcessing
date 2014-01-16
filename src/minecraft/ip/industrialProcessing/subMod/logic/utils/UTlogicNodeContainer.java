package ip.industrialProcessing.subMod.logic.utils;

import ip.industrialProcessing.subMod.logic.transport.ICommunicationNode;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class UTlogicNodeContainer {
	private ArrayList<ICommunicationNode> nodes = new ArrayList<ICommunicationNode>();
	private int[][] listLocation;
	private int[] listSides;
	boolean isListLoaded = false;
	private ArrayList<ForgeDirection> sides = new ArrayList<ForgeDirection>();
	private TileEntity te;

	public UTlogicNodeContainer(TileEntity te) {
		this.te = te;
	}
	
	public int getIndex(ICommunicationNode node){
		if (isListLoaded == false)
			loadList();
		return nodes.indexOf(node);
	}

	public void add(ICommunicationNode te) {
		nodes.add(te);
	}

	public void remove(ICommunicationNode te) {
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i) == te) {
				nodes.remove(i);
				sides.remove(i);
			}
		}
	}

	public void clear() {
		nodes.clear();
		sides.clear();
	}

	public NBTTagList writeToNBT() {
		if (nodes.size() == 0)
			return null;
		NBTTagList list = new NBTTagList();
		for (int i =0;i< nodes.size();i++) {
			TileEntity te = ((TileEntity) nodes.get(i));
			NBTTagCompound compound = new NBTTagCompound();
			compound.setIntArray("loc" + i, new int[] { te.xCoord, te.yCoord, te.zCoord });
			ForgeDirection dir = sides.get(i);
			compound.setInteger("side"+i, dir.ordinal());
			list.appendTag(compound);
			
		}
		return list;
	}

	public void readFromNBT(NBTTagList nbtTagList) {
		listLocation = new int[nbtTagList.tagCount()][3];
		listSides = new int[nbtTagList.tagCount()];
		for (int i = 0; i < nbtTagList.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) nbtTagList.tagAt(i);
			listLocation[i] = compound.getIntArray("loc" + i);
			listSides[i] = compound.getInteger("side"+i);
		}
		isListLoaded = false;
	}

	public boolean contains(ICommunicationNode node) {
		if (isListLoaded == false)
			loadList();
		return nodes.contains(node);
	}

	public void notifyOfRemoval(ICommunicationNode removeNode) {
		if (isListLoaded == false)
			loadList();
		for (ICommunicationNode node : nodes) {
			node.removeNode(removeNode);
		}
	}

	public ArrayList<ICommunicationNode> iterate() {
		if (isListLoaded == false)
			loadList();
		return nodes;
	}

	public void addSide(ForgeDirection originSide) {
		sides.add(originSide);
	}

	public int getSize() {
		if (isListLoaded == false)
			loadList();
		return nodes.size();
	}

	public ICommunicationNode getNode(int i) {
		if (isListLoaded == false)
			loadList();
		return nodes.get(i);
	}

	private void loadList() {
		if (listLocation != null) {
			this.nodes = new ArrayList<ICommunicationNode>();
			this.sides = new ArrayList<ForgeDirection>();
			World world = te.worldObj;
			for (int i =0;i<listLocation.length;i++) {
				TileEntity te = world.getBlockTileEntity(listLocation[i][0], listLocation[i][1], listLocation[i][2]);
				if (te instanceof ICommunicationNode)
					this.add((ICommunicationNode) te);
				ForgeDirection dir = ForgeDirection.values()[listSides[i]];
				addSide(dir);
			}
			listLocation = null;
			listSides = null;
			isListLoaded = true;
		}
	}

	public ForgeDirection getSide(int i) {
		if (isListLoaded == false)
			loadList();
		return sides.get(i);
	}

}
