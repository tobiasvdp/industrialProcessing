package ip.industrialProcessing.multiblock.coreAndDummy;

import net.minecraft.nbt.NBTTagCompound;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTankWorkerPowered;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.TierCollection;

public abstract class  TileEntityMultiblockSwitcherCore extends TileEntityMultiblockCoreTankWorkerPowered implements ITileEntityMultiblockSwitcher {

	boolean isCore = true;
	
	public TileEntityMultiblockSwitcherCore(StructureMultiblock structure, TierCollection tierRequirments, RecipesMultiblock recipes, LocalDirection powerInput, int powerCapacity, int maxWorkSpeed) {
		super(structure, tierRequirments, recipes, powerInput, powerCapacity, maxWorkSpeed);
	}

	@Override
	public boolean isCore() {
		return isCore;
	}

	public void notifyOnCreation() {
		System.out.println("I'm a core, and there is nothing you can do about it!");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		isCore = nbt.getBoolean("isCore");
		if(!isCore){
		
		}
		super.readFromNBT(nbt);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("isCore", isCore);
		super.writeToNBT(nbt);
	}

}
