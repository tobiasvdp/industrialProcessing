package mod.industrialProcessing.blockContainer.multiblock.core;

import java.util.ArrayList;

import mod.industrialProcessing.blockContainer.TileEntityBlockContainerIP;
import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.tileEntity.animation.AnimationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMultiblockCore extends TileEntityBlockContainerIP implements ITileEntityMultiblockCore {

	protected StructureMultiblock structure;
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

	public TileEntityMultiblockCore() {
		canRotate = false;
	}

	@Override
	public ForgeDirection getForwardDirection() {
		return FacingDirectionToForge(side);
	}

	public static ForgeDirection FacingDirectionToForge(FacingDirection side2) {
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

	public static ForgeDirection ForgeToFacingDirectionForge(ForgeDirection side2) {
		switch (side2) {
		case EAST:
			return ForgeDirection.WEST;
		case UNKNOWN:
			return ForgeDirection.UNKNOWN;
		case NORTH:
			return ForgeDirection.NORTH;
		case SOUTH:
			return ForgeDirection.SOUTH;
		case WEST:
			return ForgeDirection.EAST;
		default:
			return ForgeDirection.UNKNOWN;

		}
	}

	public static FacingDirection ForgeToFacingDirection(ForgeDirection side2) {
		switch (side2) {
		case EAST:
			return FacingDirection.West;
		case UNKNOWN:
			return FacingDirection.Invalid;
		case NORTH:
			return FacingDirection.North;
		case SOUTH:
			return FacingDirection.South;
		case WEST:
			return FacingDirection.East;
		default:
			return FacingDirection.Invalid;

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
				if (worldObj.getTileEntity(coord[0], coord[1], coord[2]) instanceof TileEntityMultiblockDummy)
					dummy.add((TileEntityMultiblockDummy) worldObj.getTileEntity(coord[0], coord[1], coord[2]));
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

		for (TileEntityMultiblockDummy te : getDummies()) {
			if (te != null) {
				NBTTagCompound nbttaglistDummie = new NBTTagCompound();
				nbttaglistDummie.setInteger("x", te.xCoord);
				nbttaglistDummie.setInteger("y", te.yCoord);
				nbttaglistDummie.setInteger("z", te.zCoord);
				nbttaglistDummies.appendTag(nbttaglistDummie);
			}
		}

		NBTTagList nbttaglistAnimation = new NBTTagList();
		if (animation != null) {
			for (int i = 0; i < animation.length; i++) {
				NBTTagCompound nbttaglistAni = new NBTTagCompound();
				nbttaglistAni.setBoolean("enabled", isAnimationEnabled[i]);
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
		NBTTagList nbttaglist = nbt.getTagList("Core", 10);

		NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(0);
		modelConnection = nbttagcompound1.getInteger("modelConnection");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(1);
		modelID = nbttagcompound1.getInteger("modelID");

		nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(2);
		tier = Tiers.values()[nbttagcompound1.getInteger("tier")];
		setNbtLoadedRecipes(tier);

		nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(3);
		state = MultiblockState.values()[nbttagcompound1.getInteger("state")];

		nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(4);
		side = FacingDirection.values()[nbttagcompound1.getInteger("side")];

		getDummies().clear();
		nbttaglist = nbt.getTagList("Dummies", 10);
		dummyDataFromNBT = new int[nbttaglist.tagCount()][3];
		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttaglistDummie = nbttaglist.getCompoundTagAt(i);
			NBTTagInt base = (NBTTagInt) nbttaglistDummie.getTag("x");
			int x = base.func_150287_d();
			base = (NBTTagInt) nbttaglistDummie.getTag("y");
			int y = base.func_150287_d();
			base = (NBTTagInt) nbttaglistDummie.getTag("z");
			int z = base.func_150287_d();
			loadedFromNBT = true;
			dummyDataFromNBT[i] = new int[] { x, y, z };
		}

		nbttaglist = nbt.getTagList("Animation", 10);
		if (nbttaglist != null) {
			for (int i = 0; i < nbttaglist.tagCount(); i++) {
				NBTTagCompound nbttaglistDummie = nbttaglist.getCompoundTagAt(i);
				NBTBase base = nbttaglistDummie.getTag("Animation");
				nbttagcompound1 = (NBTTagCompound) nbttaglistDummie.getCompoundTag("Animation");
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
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord), side, false);
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
				FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord), side, true);
				if (dir == FacingDirection.Invalid)
					dummiesToBeEreased.add(te);
			}
		}
		for (TileEntityMultiblockDummy te : dummiesToBeEreased) {
			te.delCore();
		}
	}

	public void destroyMultiblock() {
		structure.breakStructure(this.worldObj,xCoord,yCoord,zCoord,side);
	}

	private void reloadDumies() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		this.readFromNBT(nbt);
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
			default:
				break;
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
			TileEntity neighbour = worldObj.getTileEntity(xCoord + dir.offsetX, yCoord + dir.offsetY, zCoord + dir.offsetZ);
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
		FacingDirection dir = structure.isBlockValid(te.xCoord - xCoord, te.yCoord - yCoord, te.zCoord - zCoord, te.getWorldObj().getBlock(te.xCoord, te.yCoord, te.zCoord), side, true);
		if (dir == side)
			return true;
		return false;
	}

	public StructureMultiblock getStructure() {
		return structure;
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
		side = ForgeToFacingDirection(forward);
	}

	@Override
	public boolean canWrenchRotate() {
		return false;
	}

	@Override
	public Tiers getTier() {
		return tier;
	}

	public void onDestroy() {

	}

	public int transformSideToLayoutSide(int side) {
		switch (this.side) {

		case North:
			break;
		case East:
			switch (side) {
			case 2:
				side = 4;
				break;
			case 3:
				side = 5;
				break;
			case 4:
				side = 3;
				break;
			case 5:
				side = 2;
				break;
			}
			break;
		case South:
			switch (side) {
			case 2:
				side = 3;
				break;
			case 3:
				side = 2;
				break;
			case 4:
				side = 5;
				break;
			case 5:
				side = 4;
				break;
			}
			break;
		case West:
			switch (side) {
			case 2:
				side = 5;
				break;
			case 3:
				side = 4;
				break;
			case 4:
				side = 2;
				break;
			case 5:
				side = 3;
				break;
			}
			break;
		case Invalid:
			break;
		default:
			break;

		}
		return side;
	}

}
