package mod.industrialProcessing.blockContainer.multiblock.coreAndDummy;

import mod.industrialProcessing.blockContainer.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.utils.registry.BlockSwitcherRegistry;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public abstract class TileEntityMultiblockSwitcherCore extends TileEntityMultiblockCoreTankWorkerPowered implements ITileEntityMultiblockSwitcher {

	private RecipesMultiblock recipes;
	boolean isCore = true;
	boolean visitedForTranslate = false;

	public TileEntityMultiblockSwitcherCore(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
		super(structure, tierRequirments, recipes, powerInput, powerCapacity, maxWorkSpeed);
		this.recipes = recipes;
	}

	@Override
	public boolean isCore() {
		return isCore;
	}

	@Override
	protected boolean isValidInput(int slot, Item itemID) {
		return recipes.isValidInput(slot, itemID, getTier());
	}

	public void notifyOnCreation() {
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		isCore = nbt.getBoolean("isCore");
		if (!isCore) {

		}
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("isCore", isCore);
		super.writeToNBT(nbt);
	}

	public void switchToDummy() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		String name = unlocalizedDummyName();
		this.writeToNBT(nbtTag);
		if (name != null) {
			nbtTag.setString("id", name.substring(5));
		}
		nbtTag.setBoolean("isCore", false);
		nbtTag.removeTag("Dummies");
		nbtTag.removeTag("Items");
		nbtTag.removeTag("Tanks");
		nbtTag.removeTag("IP.work.totalWork");
		nbtTag.removeTag("IP.work.workDone");
		nbtTag.removeTag("burnTimeCoal");
		nbtTag.removeTag("StoredPower");
		nbtTag.removeTag("Core");
		NBTTagList tag = new NBTTagList();

		NBTTagCompound nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelConnection", 0);
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("modelID", 0);
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("ID", 0);
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("state", state.ordinal());
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setBoolean("needRenderUpdate", false);
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("groupID", 0);
		tag.appendTag(nbtComp);

		nbtComp = new NBTTagCompound();
		nbtComp.setInteger("forward", side.ordinal());
		tag.appendTag(nbtComp);

		nbtTag.setTag("Data", tag);

		nbtTag.setTag("Core", null);
		TileEntity te = TileEntity.createAndLoadEntity(nbtTag);
		worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
		System.out.println("test");
		
		((TileEntityMultiblockSwitcherDummy) worldObj.getTileEntity(xCoord, yCoord, zCoord)).notifyOnCreation();
	}

	public void notifyOnCreation(String myUnlocalizedName) {

	}

	public String unlocalizedDummyName() {
		Block block = this.getBlockType();
		String name = block.getUnlocalizedName();
		return BlockSwitcherRegistry.getDummyName(name);
	}
}
