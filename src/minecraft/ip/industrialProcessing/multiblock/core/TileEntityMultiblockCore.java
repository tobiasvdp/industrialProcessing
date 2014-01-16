package ip.industrialProcessing.multiblock.core;

import java.util.ArrayList;

import ip.industrialProcessing.machines.animation.AnimationHandler;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.utils.MultiblockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityMultiblockCore extends TileEntity implements ITileEntityMultiblockCore {

	private StructureMultiblock structure;
	private TierCollection tierRequirments;

	private ArrayList<TileEntityMultiblockDummy> dummy = new ArrayList<TileEntityMultiblockDummy>();
	private boolean loadedFromNBT;
	private int[][] dummyDataFromNBT;
	protected FacingDirection side = FacingDirection.North;
	protected MultiblockState state = MultiblockState.CONNECTED;
	private Tiers tier = Tiers.Invalid;
	private int modelID;
	private int modelConnection;
	protected AnimationHandler[] animation;
	protected boolean[] isAnimationEnabled;

	@Override
	public ForgeDirection getForwardDirection() {
		return FacingDirectionToForge(side);
	}

	private ForgeDirection FacingDirectionToForge(FacingDirection side2) {
		switch (side2) {
		case East:
			return ForgeDirection.WEST;
		case Invalid:
			return ForgeDirection.UNKNOWN;
		case North:
			return ForgeDirection.NORTH;
		case South:
			return ForgeDirection.SOUTH;
		case West:
			return ForgeDirection.EAST;
		default:
			return ForgeDirection.UNKNOWN;

		}
	}

	public float getAnimationProgress(float scale, int animationIndex) {
		return animation[animationIndex].getProgress();
	}

	public void updateAnimationProgress(int animationIndex) {
		animation[animationIndex].update();
	}

	public boolean isAnimationEnabled(int animationIndex) {
		return isAnimationEnabled[animationIndex];
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		writeCore(nbt);
	}

	public ArrayList<TileEntityMultiblockDummy> getDummies() {
		if (loadedFromNBT) {
			for (int[] coord : dummyDataFromNBT) {
				dummy.add((TileEntityMultiblockDummy) worldObj.getBlockTileEntity(coord[0], coord[1], coord[2]));
			}
			loadedFromNBT = false;
		}
		return dummy;
	}

	private void writeCore(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();

		NBTTagCompound nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelConnection", modelConnection);
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelID", modelID);
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("tier", tier.ordinal());
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("state", state.ordinal());
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("side", side.ordinal());
		nbttaglist.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		NBTTagList nbttaglistDummies = new NBTTagList();
		System.out.println("writing dummies");
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null) {
				NBTTagList nbttaglistDummie = new NBTTagList();
				nbttaglistDummie.setName("dummy" + te.getID());

				nbtComp = new NBTTagCompound();
				nbtComp.setInteger("x", te.xCoord);
				nbttaglistDummie.appendTag(nbtComp);

				nbtComp = new NBTTagCompound();
				nbtComp.setInteger("y", te.yCoord);
				nbttaglistDummie.appendTag(nbtComp);

				nbtComp = new NBTTagCompound();
				nbtComp.setInteger("z", te.zCoord);
				nbttaglistDummie.appendTag(nbtComp);

				nbttaglistDummies.appendTag(nbttaglistDummie);
			}
		}

		NBTTagList nbttaglistAnimation = new NBTTagList();
		if (animation != null) {
			for (int i = 0; i < animation.length; i++) {
				NBTTagList nbttaglistAni = new NBTTagList();
				nbttaglistAni.setName("Ani" + i);

				nbtComp = new NBTTagCompound();
				nbtComp.setBoolean("enabled", isAnimationEnabled[i]);
				nbttaglistAni.appendTag(nbtComp);

				nbttaglistAnimation.appendTag(nbttaglistAni);
			}
			nbt.setTag("Animation", nbttaglistAnimation);
		}

		nbt.setTag("Core", nbttaglist);
		nbt.setTag("Dummies", nbttaglistDummies);

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readCore(nbt);
	};

	private void readCore(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Core");

		NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(0);
		modelConnection = nbttagcompound1.getInteger("modelConnection");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(1);
		modelID = nbttagcompound1.getInteger("modelID");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(2);
		tier = Tiers.values()[nbttagcompound1.getInteger("tier")];
		setNbtLoadedRecipes(tier);

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(3);
		state = MultiblockState.values()[nbttagcompound1.getInteger("state")];

		nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(4);
		side = FacingDirection.values()[nbttagcompound1.getInteger("side")];

		getDummies().clear();
		nbttaglist = nbt.getTagList("Dummies");
		dummyDataFromNBT = new int[nbttaglist.tagCount()][3];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagList nbttaglistDummie = (NBTTagList) nbttaglist.tagAt(i);
			nbttagcompound1 = (NBTTagCompound) nbttaglistDummie.tagAt(0);
			int x = nbttagcompound1.getInteger("x");
			nbttagcompound1 = (NBTTagCompound) nbttaglistDummie.tagAt(1);
			int y = nbttagcompound1.getInteger("y");
			nbttagcompound1 = (NBTTagCompound) nbttaglistDummie.tagAt(2);
			int z = nbttagcompound1.getInteger("z");
			loadedFromNBT = true;
			dummyDataFromNBT[i] = new int[] { x, y, z };
		}

		nbttaglist = nbt.getTagList("Animation");
		if (nbttaglist != null) {
			for (int i = 0; i < nbttaglist.tagCount(); i++) {
				NBTTagList nbttaglistDummie = (NBTTagList) nbttaglist.tagAt(i);
				nbttagcompound1 = (NBTTagCompound) nbttaglistDummie.tagAt(0);
				isAnimationEnabled[i] = nbttagcompound1.getBoolean("enabled");
			}
		}

	}

	protected void setNbtLoadedRecipes(Tiers tier2) {

	}

	public TileEntityMultiblockCore(StructureMultiblock structure, TierCollection tierRequirments) {
		this.structure = structure;
		this.tierRequirments = tierRequirments;
	}

	public void registerDummy(TileEntityMultiblockDummy te) {
		getDummies().add(te);
	}

	public void unregisterDummy(TileEntityMultiblockDummy temultiblockDummy) {
		getDummies().remove(temultiblockDummy);
	}

	public boolean isDummyValidForStructure(TileEntityMultiblockDummy te) {
		/*
		 * check if the new placed block is valid, if not try other directions.
		 * If direction is changed, take necessary actions
		 */
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, false);
		if (dir == FacingDirection.Invalid) {
			return false;
		} else {
			if (dir != side) {
				side = dir;
				onSideChange();
			}
			return true;
		}
	}

	public void checkIfRegisteredDummiesAreValid() {
		// first determinate what to delete. If you delete while running trough
		// your loop, you will mess sh* up.
		ArrayList<TileEntityMultiblockDummy> dummiesToBeEreased = new ArrayList<TileEntityMultiblockDummy>();
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null) {
				FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
				if (dir == FacingDirection.Invalid)
					dummiesToBeEreased.add(te);
			}
		}
		for (TileEntityMultiblockDummy te : dummiesToBeEreased) {
			te.delCore();
		}
	}

	public void destroyMultiblock() {
		ArrayList<TileEntityMultiblockDummy> list = (ArrayList<TileEntityMultiblockDummy>) getDummies().clone();
		for (TileEntityMultiblockDummy te : list) {
			if (te != null)
				worldObj.destroyBlock(te.xCoord, te.yCoord, te.zCoord, true);
		}
	}

	public void onStateChange() {
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null)
				te.setState(state);
		}
	}

	public void onLayoutChange() {
		// determinate if the state has changed. if so do necessary actions
		MultiblockState state = structure.isLayoutValid(worldObj, xCoord, yCoord, zCoord, this.side);
		if (state != this.state) {
			this.state = state;
			onStateChange();
		}
		// if state is complete determinate the tier level, else reset the tier.
		if (state == MultiblockState.COMPLETED) {
			Tiers tier = determinateTier();
			if (this.tier != tier) {
				this.tier = tier;
				onTierChange();
			} else {
				this.tier = tier;
			}
		} else {
			this.tier = Tiers.Invalid;
		}
	}

	public void onTierChange() {
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		configMultiblock();
	}

	private void configMultiblock() {
		if (tier != Tiers.Invalid) {
			setDefaultModel();
			tierRequirments.getTier(tier).configMultiblock(this, getDummies());
		}
	}

	public void setDefaultModel() {
		setDummiesModelConnections();
		setDummiesModelIDs();
		setDummiesGroupIDs();
	}

	public void onSideChange() {
		checkIfRegisteredDummiesAreValid();
		setMultiblockRotation();
		setDefaultModel();
	}

	private void setMultiblockRotation() {
		if (side != FacingDirection.Invalid) {
			int metadata = 0;
			switch (side) {
			case North: {
				metadata = 2;
				break;
			}
			case East: {
				metadata = 3;
				break;
			}
			case South: {
				metadata = 0;
				break;
			}
			case West: {
				metadata = 1;
				break;
			}
			}
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 1);
			for (TileEntityMultiblockDummy te : getDummies()) {
				if (te != null)
					worldObj.setBlockMetadataWithNotify(te.xCoord, te.yCoord, te.zCoord, metadata, 1);
			}
		}
	}

	@Override
	public MultiblockState getState() {
		return state;
	}

	public void notifyNeighboursOfCorePlaced() {
		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			TileEntity neighbour = worldObj.getBlockTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
			if (neighbour instanceof TileEntityMultiblockDummy) {
				TileEntityMultiblockDummy te = (TileEntityMultiblockDummy) neighbour;
				if (te.getCore() == null)
					te.searchForCore();
			}
		}
	}

	public int getModelID() {
		return modelID;
	}

	public int getModelConnection() {
		return modelConnection;
	}

	public void setModelID() {
		modelID = structure.getModelIDforBlock(0, 0, 0, side);
	}

	public void setModelConnection() {
		modelConnection = structure.getModelConnectionforBlock(0, 0, 0, side);
	}

	public int setDummieModelID(TileEntityMultiblockDummy te) {
		return structure.getModelIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public int setDummieModelConnection(TileEntityMultiblockDummy te) {
		return structure.getModelConnectionforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public int setDummieGroupID(TileEntityMultiblockDummy te) {
		return structure.getGroupIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public void setDummiesModelIDs() {
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null)
				te.setModelID(structure.getModelIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side));
		}
	}

	public void setDummiesModelConnections() {
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null)
				te.setModelConnection(structure.getModelConnectionforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side));
		}
	}

	public void setDummiesGroupIDs() {
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null)
				te.setGroup(structure.getGroupIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side));
		}
	}

	public void setsideFromMetadata(int dir) {
		switch (dir) {
		case 1: {
			side = FacingDirection.West;
			break;
		}
		case 2: {
			side = FacingDirection.North;
			break;
		}
		case 3: {
			side = FacingDirection.East;
			break;
		}
		case 0: {
			side = FacingDirection.South;
			break;
		}
		default: {
			side = FacingDirection.North;
		}
		}
	}

	public Tiers determinateTier() {
		Tiers tier = Tiers.Tier0;
		for (Tiers tr : Tiers.values()) {
			if (tr.ordinal() > 0 && tr.ordinal() < tierRequirments.getAmountTiers() && tierRequirments.getTier(tr).isTierRequirementMet(this)) {
				tier = tr;
			}
		}
		System.out.println("Tier = " + tier);
		return tier;
	}

	public int setDummieID(TileEntityMultiblockDummy te) {
		return structure.getIDforBlock(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, side);
	}

	public TileEntityMultiblockDummy getDummyByID(int ID) {
		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null) {
				if (te.getID() == ID) {
					return te;
				}
			}
		}
		return null;
	}

	public boolean isDummyValidForStructure(TileEntityMultiblockDummy te, boolean b) {
		/*
		 * check if the new placed block is valid. This does not change
		 * directions.
		 */
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.worldObj.getBlockId(te.xCoord, te.yCoord, te.zCoord), side, true);
		if (dir == side)
			return true;
		return false;
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.customParam1);
	}

	@Override
	public int getX() {
		return this.xCoord;
	}

	@Override
	public int getY() {
		return this.yCoord;
	}

	@Override
	public int getZ() {
		return this.zCoord;
	}

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return (state == MultiblockState.COMPLETED);
	}

	@Override
	public void setForwardDirection(ForgeDirection forward) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}

	@Override
	public Tiers getTier() {
		return tier;
	}

}
