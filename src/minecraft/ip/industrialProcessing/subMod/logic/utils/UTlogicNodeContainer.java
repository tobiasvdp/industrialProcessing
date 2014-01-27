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

	public void add(ICommunicationNode te) {
		this.nodes.add(te);
	}

	public void addSide(ForgeDirection originSide) {
		this.sides.add(originSide);
	}

	public void clear() {
		this.nodes.clear();
		this.sides.clear();
	}

	public boolean contains(ICommunicationNode node) {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.nodes.contains(node);
	}

	public int getIndex(ICommunicationNode node) {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.nodes.indexOf(node);
	}

	public ICommunicationNode getNode(int i) {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.nodes.get(i);
	}

	public ForgeDirection getSide(int i) {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.sides.get(i);
	}

	public int getSize() {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.nodes.size();
	}

	public ArrayList<ICommunicationNode> iterate() {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		return this.nodes;
	}

	private void loadList() {
		if (this.listLocation != null) {
			this.nodes = new ArrayList<ICommunicationNode>();
			this.sides = new ArrayList<ForgeDirection>();
			World world = this.te.worldObj;
			for (int i = 0; i < this.listLocation.length; i++) {
				TileEntity te = world.getBlockTileEntity(this.listLocation[i][0], this.listLocation[i][1], this.listLocation[i][2]);
				if (te instanceof ICommunicationNode) {
					this.add((ICommunicationNode) te);
				}
				ForgeDirection dir = ForgeDirection.values()[this.listSides[i]];
				this.addSide(dir);
			}
			this.listLocation = null;
			this.listSides = null;
			this.isListLoaded = true;
		}
	}

	public void notifyOfRemoval(ICommunicationNode removeNode) {
		if (this.isListLoaded == false) {
			this.loadList();
		}
		for (ICommunicationNode node : this.nodes) {
			node.removeNode(removeNode);
		}
	}

	public void readFromNBT(NBTTagList nbtTagList) {
		this.listLocation = new int[nbtTagList.tagCount()][3];
		this.listSides = new int[nbtTagList.tagCount()];
		for (int i = 0; i < nbtTagList.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound) nbtTagList.tagAt(i);
			this.listLocation[i] = compound.getIntArray("loc" + i);
			this.listSides[i] = compound.getInteger("side" + i);
		}
		this.isListLoaded = false;
	}

	public void remove(ICommunicationNode te) {
		for (int i = 0; i < this.nodes.size(); i++) {
			if (this.nodes.get(i) == te) {
				this.nodes.remove(i);
				this.sides.remove(i);
			}
		}
	}

	public NBTTagList writeToNBT() {
		if (this.nodes.size() == 0) {
			return null;
		}
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.nodes.size(); i++) {
			TileEntity te = (TileEntity) this.nodes.get(i);
			NBTTagCompound compound = new NBTTagCompound();
			compound.setIntArray("loc" + i, new int[] { te.xCoord, te.yCoord, te.zCoord });
			ForgeDirection dir = this.sides.get(i);
			compound.setInteger("side" + i, dir.ordinal());
			list.appendTag(compound);

		}
		return list;
	}

}
