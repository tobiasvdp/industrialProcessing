package ip.industrialProcessing.logic.utils;

import ip.industrialProcessing.logic.transport.ICommunicationNode;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class UTlogicNodeContainer {
	private ArrayList<ICommunicationNode> nodes = new ArrayList<ICommunicationNode>();
	private int[][] temp;
	boolean isListLoaded = false;
	private ArrayList<ForgeDirection> sides = new ArrayList<ForgeDirection>();
	private TileEntity te;

	public UTlogicNodeContainer(TileEntity te) {
		this.te = te;
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
		int i = 0;
		for (ICommunicationNode node : nodes) {
			TileEntity te = ((TileEntity) node);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setIntArray("node" + i++, new int[] { te.xCoord, te.yCoord, te.zCoord });
			list.appendTag(compound);
		}
		return list;
	}

	public void readFromNBT(NBTTagList nbtTagList) {
		temp = new int[nbtTagList.tagCount()][3];
		for (int i = 0; i < nbtTagList.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) nbtTagList.tagAt(i);
			temp[i] = compound.getIntArray("node" + i);
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
		if (temp != null) {
			this.nodes = new ArrayList<ICommunicationNode>();
			World world = te.worldObj;
			for (int[] data : temp) {
				TileEntity te = world.getBlockTileEntity(data[0], data[1], data[2]);
				if (te instanceof ICommunicationNode)
					this.add((ICommunicationNode) te);
			}
			temp = new int[1][3];
			isListLoaded = true;
		}
	}

	public ForgeDirection getSide(int i) {
		if (isListLoaded == false)
			loadList();
		return sides.get(i);
	}

}
