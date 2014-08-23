package mod.industrialProcessing.plants.blackSmith.waterBasin;

import java.util.Iterator;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.blockContainer.multiblock.coreAndDummy.TileEntityMultiblockSwitcherCore;
import mod.industrialProcessing.blockContainer.multiblock.layout.FacingDirection;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.layout.LayoutTransformer;
import mod.industrialProcessing.blockContainer.multiblock.layout.StructureMultiblock;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tier;
import mod.industrialProcessing.blockContainer.multiblock.tier.TierCollection;
import mod.industrialProcessing.blockContainer.multiblock.tier.Tiers;
import mod.industrialProcessing.blockContainer.multiblock.utils.MultiblockState;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TileTankSyncHandler;
import mod.industrialProcessing.utils.DropBlock;
import mod.industrialProcessing.utils.handlers.packet.IProgressSync;
import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.SyncValuesPacket;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipeMultiblock;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityWaterBasinCore extends TileEntityMultiblockSwitcherCore implements ITankSyncable, IProgressSync {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	private TankHandler tankHandler;
	public static RecipesMultiblock recipes = new RecipesWaterBasin();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 0, 0, 0, 0, 0);

		int i = 0;
		layout.setCoreID(0, 0, 1, IndustrialProcessing.blockWaterBasin);

		layout.setBlockID(-1, 0, 0, 0, 0, 0, IndustrialProcessing.blockWaterBasin);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityWaterBasinCore() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 5, 0, new ForgeDirection[] { ForgeDirection.UP, ForgeDirection.UNKNOWN }, true, true);
		this.tankHandler = new TankHandler(this, new int[] { 0 });
	}

	@Override
	public TankHandler getTankHandler() {
		return this.tankHandler;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && this.tankHandler.readDataFromTanks())
			TileTankSyncHandler.sendTankData(this, this.tankHandler);
		if (!worldObj.isRemote && worldObj.isRaining()) {
			fill(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, (int) (worldObj.rainingStrength * 10)), true);
		}
		super.updateEntity();
	};

	@Override
	public int getTankCount() {
		return 1;
	}

	public void handleRightClick(EntityPlayer player) {
		if (getState() == MultiblockState.COMPLETED) {
			if (!handleBucket(player))
				handleItem(player);
		}
		onInventoryChanged();
	}

	private boolean handleItem(EntityPlayer player) {
		if (drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), false) != null && drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), false).amount == 1000) {
			if (player.getCurrentEquippedItem() != null) {
				Iterator<RecipeMultiblock> it = recipes.getRecipes();
				while (it.hasNext()) {
					RecipeMultiblock recipe = it.next();

					Item playerEquippedItem = player.getCurrentEquippedItem().getItem();

					if (recipe.inputs[0].isItemValid(playerEquippedItem)) {
						player.setCurrentItemOrArmor(0, recipe.outputs[0].createStack(1));
						for (int j = 1; j < recipe.outputs.length; j++) {
							ItemStack outputStack = recipe.outputs[j].createStack(1);
							if (!player.inventory.addItemStackToInventory(outputStack))
								DropBlock.doDispense(worldObj, outputStack, 1, ForgeDirection.UP, xCoord, yCoord, zCoord);
						}
						drain(ForgeDirection.UNKNOWN, new FluidStack(FluidRegistry.WATER, 1000), true);
						spawnSmoke();
					}
					
					return true;
				}
			}
		}
		return false;
	}

	private void spawnSmoke() {
		for (double j = 0; j < 1; j += 0.1) {
			for (double i = 0; i < 1; i += 0.1) {
				worldObj.spawnParticle("smoke", xCoord + i, yCoord + 1, zCoord + j, 0.0D, 0.0D, 0.0D);
			}
		}
		for (int i = 0; i < this.getDummies().size(); i++) {
			((TileEntityWaterBasinDummy) this.getDummies().get(i)).spawnSmoke();
		}
	}

	public boolean handleBucket(EntityPlayer player) {
		// liquid input
		FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(player.getCurrentEquippedItem());
		if (fluid != null) {
			if (fluid.fluidID == new FluidStack(FluidRegistry.WATER, 1).fluidID) {
				ItemStack emptyContainer = getEmptyContainerFromContainer(player.getCurrentEquippedItem());
				if (emptyContainer != null) {
					if (this.tankHasRoomFor(0, fluid)) {
						emptyContainer.stackSize = 1;
						player.setCurrentItemOrArmor(0, emptyContainer);
						this.getTankInSlot(0).fill(fluid, true);
						return true;
					}
				}
			}
		}
		return false;
	}

	private ItemStack getEmptyContainerFromContainer(ItemStack stack) {
		FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();
		for (int i = 0; i < data.length; i++) {
			FluidContainerData containerData = data[i];
			if (containerData.filledContainer.isItemEqual(stack))
				return containerData.emptyContainer.copy();
		}
		return null;
	}

	@Override
	public void setValues(int[] val) {
		if (val[0] != 0 && val[1] != 0) {
			if (Item.getItemById(val[1]) != null)
				getMachineStack(0).stack = new ItemStack(Item.getItemById(val[0]), val[1]);
			else
				getMachineStack(0).stack = new ItemStack(Block.getBlockById(val[0]), val[1]);
		} else {
			getMachineStack(0).stack = null;
		}
		if (val[2] != 0 && val[3] != 0) {
			if (Item.getItemById(val[3]) != null)
				getMachineStack(1).stack = new ItemStack(Item.getItemById(val[2]), val[3]);
			else
				getMachineStack(1).stack = new ItemStack(Block.getBlockById(val[2]), val[3]);
		} else {
			getMachineStack(1).stack = null;
		}
	}

	@Override
	public int[] getValues() {
		int[] val = new int[4];

		if (getStackInSlot(0) != null) {
			val[0] = Item.getIdFromItem(getStackInSlot(0).getItem());
			val[1] = getStackInSlot(0).stackSize;
		}

		if (getStackInSlot(1) != null) {
			val[2] = Item.getIdFromItem(getStackInSlot(1).getItem());
			val[3] = getStackInSlot(1).stackSize;
		}
		return val;
	}

	@Override
	public void sendUpdatesifChanged(int[] val, int[] prev) {
		boolean requireUpdate = false;
		for (int i = 0; i < val.length; i++) {
			if (Math.abs(val[i] - prev[i]) > offsetForSync()) {
				requireUpdate = true;
			}
		}
		if (requireUpdate) {
			SyncValuesPacket packet = new SyncValuesPacket(this.xCoord, this.yCoord, this.zCoord, getValues());
			PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(this.getWorldObj().provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, 32));
		}
	}

	@Override
	public int[] getPrevValues() {
		int[] val = new int[4];

		if (getStackInSlot(0) != null) {
			val[0] = Item.getIdFromItem(getStackInSlot(0).getItem());
			val[1] = getStackInSlot(0).stackSize;
		}

		if (getStackInSlot(1) != null) {
			val[2] = Item.getIdFromItem(getStackInSlot(1).getItem());
			val[3] = getStackInSlot(1).stackSize;
		}
		return val;
	}

	@Override
	public int offsetForSync() {
		return 1;
	}

}
