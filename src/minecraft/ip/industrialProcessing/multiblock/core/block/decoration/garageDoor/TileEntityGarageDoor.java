package ip.industrialProcessing.multiblock.core.block.decoration.garageDoor;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.bouncycastle.util.Arrays;

import ip.industrialProcessing.config.ISetupMachineBlocks;
import ip.industrialProcessing.multiblock.core.TileEntityMultiblockCore;
import ip.industrialProcessing.multiblock.core.block.weldingStation.RecipesWeldingStation;
import ip.industrialProcessing.multiblock.dummy.TileEntityMultiblockDummy;
import ip.industrialProcessing.multiblock.dummy.block.decoration.garageDoor.TileEntityGarageDoorFrame;
import ip.industrialProcessing.multiblock.layout.FacingDirection;
import ip.industrialProcessing.multiblock.layout.LayoutMultiblock;
import ip.industrialProcessing.multiblock.layout.LayoutTransformer;
import ip.industrialProcessing.multiblock.layout.StructureMultiblock;
import ip.industrialProcessing.multiblock.recipes.RecipesMultiblock;
import ip.industrialProcessing.multiblock.tier.Tier;
import ip.industrialProcessing.multiblock.tier.TierCollection;
import ip.industrialProcessing.multiblock.tier.Tiers;
import ip.industrialProcessing.utils.IRemote;
import ip.industrialProcessing.utils.ISender;

public class TileEntityGarageDoor extends TileEntityMultiblockCore implements ISender {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(0, 5,0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 1, ISetupMachineBlocks.blockGarageDoor.blockID);

		for (int j = 1; j <= 5; j++)
			layout.setBlockID(j, 0, 0, i++, 0, 1, ISetupMachineBlocks.blockGarageDoorFrame.blockID, -1);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);

		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	int height = 0;
	int[] heights = new int[6];

	public TileEntityGarageDoor() {
		super(structure, tierRequirments);
		Arrays.fill(heights, -1);
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height, int id, boolean generate) {
		heights[id] = height;
		if (generate) {
			int newHeight = 7;
			for (int i = 0; i < heights.length; i++) {
				if (heights[i] != -1) {
					newHeight = Math.min(newHeight, heights[i]);
				}
			}
			if (newHeight != this.height) {
				this.height = newHeight;
				onHeightChange();
			}
		}
	}

	private void onHeightChange() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).generateGarageDoor();
			}
		}
	}

	private boolean open = false;
	private boolean isWorking = false;

	public void openOrClose() {
		if (!isWorking) {
			if (open) {
				open = false;
				isWorking = true;
				orderDummiesToFall();
			} else {
				open = true;
				isWorking = true;
				orderDummiesToRise();
			}
		}
	}

	private void orderDummiesToRise() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).rise();
			}
		}
	}

	private void orderDummiesToFall() {
		ArrayList<TileEntityMultiblockDummy> dummies = getDummies();
		for (int i = 0; i < dummies.size(); i++) {
			if (dummies.get(i) instanceof TileEntityGarageDoorFrame) {
				((TileEntityGarageDoorFrame) dummies.get(i)).fall();
			}
		}
	}
	
	public void doneWorking(){
		isWorking = false;
		System.out.println("Done");
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		open = nbt.getBoolean("open");
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setBoolean("open", open);
		super.writeToNBT(nbt);
	}
	
	public boolean isOpen(){
		return open;
	}

	@Override
	public boolean sendTileEntity(IRemote remote,ItemStack itemStack) {
		remote.setTileEntity(this, itemStack, this.xCoord, this.yCoord, this.zCoord);
		return true;
	}

}
