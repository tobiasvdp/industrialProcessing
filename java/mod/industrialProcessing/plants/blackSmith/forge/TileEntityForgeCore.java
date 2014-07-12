package mod.industrialProcessing.plants.blackSmith.forge;

import java.util.Random;

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
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import mod.industrialProcessing.utils.DropBlock;
import mod.industrialProcessing.utils.handlers.packet.IProgressSync;
import mod.industrialProcessing.utils.handlers.packet.PacketHandler;
import mod.industrialProcessing.utils.handlers.packet.packets.ConveyorPacket;
import mod.industrialProcessing.utils.handlers.packet.packets.SyncValuesPacket;
import mod.industrialProcessing.utils.registry.HandlerRegistry;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.RecipesMultiblock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityForgeCore extends TileEntityMultiblockSwitcherCore implements IProgressSync {
	static StructureMultiblock structure;
	static TierCollection tierRequirments;
	private TankHandler tankHandler;
	public int burnTime = 0;
	public int PrevburnTime = 0;
	public static RecipesMultiblock recipes = new RecipesForge();
	static {
		// set layout
		structure = new StructureMultiblock();

		LayoutMultiblock layout = new LayoutMultiblock(1, 1, 0, 1, 2, 0);

		int i = 0;
		layout.setCoreID(i++, 0, 0, IndustrialProcessing.blockForge);

		layout.setBlockID(-1, 0, 0, i++, 0, 0, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 0, 0, i++, 0, 0, IndustrialProcessing.blockForge);
		layout.setBlockID(-1, 1, 0, i++, 0, 1, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 1, 0, i++, 0, 2, IndustrialProcessing.blockForge);
		layout.setBlockID(0, 2, 0, i++, 0, 3, IndustrialProcessing.blockForge);
		layout.setBlockID(-1, 2, 0, i++, 0, 4, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 2, 0, i++, 0, 5, IndustrialProcessing.blockForge);

		layout.setBlockID(0, 0, -1, i++, 0, 0, IndustrialProcessing.blockForge);
		layout.setBlockID(-1, 0, -1, i++, 0, 0, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 0, -1, i++, 0, 0, IndustrialProcessing.blockForge);

		layout.setBlockID(0, 1, -1, i++, 0, 6, IndustrialProcessing.blockForge);
		layout.setBlockID(-1, 1, -1, i++, 0, 7, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 1, -1, i++, 0, 8, IndustrialProcessing.blockForge);

		layout.setBlockID(0, 2, -1, i++, 0, 0, IndustrialProcessing.blockForge);
		layout.setBlockID(-1, 2, -1, i++, 0, 9, IndustrialProcessing.blockForge);
		layout.setBlockID(1, 2, -1, i++, 0, 10, IndustrialProcessing.blockForge);

		structure.addLayout(layout, FacingDirection.North);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.East), FacingDirection.East);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.South), FacingDirection.South);
		structure.addLayout(LayoutTransformer.transform(layout, FacingDirection.West), FacingDirection.West);

		// set tiers
		tierRequirments = new TierCollection(1);
		Tier tier = new Tier();
		tierRequirments.addTier(tier, Tiers.Tier0);
	}

	public TileEntityForgeCore() {
		super(structure, tierRequirments, recipes, LocalDirection.UNKNOWN, 10000, 100);
		setInventoryGroupArray(1);
		addStack(null, 0, LocalDirection.LEFT, true, false);
		addStack(null, 0, LocalDirection.RIGHT, false, true);
	}

	public void burn() {
		if (burnTime > 10000) {
			Random random = new Random();
			for (int j = 0; j < 2; j++) {
				worldObj.spawnParticle("smoke", xCoord + Math.max(0.1, random.nextFloat()), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
				worldObj.spawnParticle("flame", xCoord + Math.max(0.1, random.nextFloat()), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
			}

			if (getForwardDirection() == ForgeDirection.NORTH || getForwardDirection() == ForgeDirection.SOUTH) {
				for (int j = 0; j < 2; j++) {
					worldObj.spawnParticle("smoke", xCoord + 1 + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
					worldObj.spawnParticle("flame", xCoord - 1 + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
				}
			} else {
				for (int j = 0; j < 2; j++) {

					worldObj.spawnParticle("smoke", xCoord + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord + 1 + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);
					worldObj.spawnParticle("flame", xCoord + Math.max(0.1, random.nextFloat() / 2), yCoord + 1.25, zCoord - 1 + Math.max(0.1, random.nextFloat()), 0.0D, 0.0D, 0.0D);

				}
			}
		}
	}

	public void canBurnBlock() {
		if (getState() == MultiblockState.COMPLETED) {
			Block block = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
			if (block != null) {
				int value = GameRegistry.getFuelValue(new ItemStack(block));
				if (value == 0 || burnTime > 40000) {
					DropBlock.doDispense(worldObj, new ItemStack(block), 1, getForwardDirection().getOpposite(), xCoord, yCoord + 1, zCoord);
				} else {
					burnTime += value;
					PrevburnTime = burnTime;
				}
				worldObj.func_147480_a(xCoord, yCoord + 1, zCoord, false);
			}
		}
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (burnTime > 0) {
				burnTime--;
			}
			sendUpdatesifChanged(getValues(), getPrevValues());
		}
		super.updateEntity();
	}

	@Override
	public void setValues(int[] val) {
		burnTime = val[0];
		if (val[1] != 0 && val[2] != 0) {
			if(Item.getItemById(val[1]) != null)
				getMachineStack(0).stack = new ItemStack(Item.getItemById(val[1]),val[2]);
			else
				getMachineStack(0).stack = new ItemStack(Block.getBlockById(val[1]),val[2]);
		}else{
			getMachineStack(0).stack = null;
		}
		if(val[3] != 0 && val[4] != 0){
			if(Item.getItemById(val[3]) != null)
				getMachineStack(1).stack = new ItemStack(Item.getItemById(val[3]),val[4]);
			else
				getMachineStack(1).stack = new ItemStack(Block.getBlockById(val[3]),val[4]);
		}else{
			getMachineStack(1).stack = null;
		}
	}

	@Override
	public int[] getValues() {
		int[] val = new int[5];
		val[0] = burnTime;

		if (getStackInSlot(0) != null) {
			val[1] = Item.getIdFromItem(getStackInSlot(0).getItem());
			val[2] = getStackInSlot(0).stackSize;
		}

		if (getStackInSlot(1) != null) {
			val[3] = Item.getIdFromItem(getStackInSlot(1).getItem());
			val[4] = getStackInSlot(1).stackSize;
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
			PrevburnTime = burnTime;
			SyncValuesPacket packet = new SyncValuesPacket(this.xCoord,this.yCoord,this.zCoord, getValues());
			PacketHandler.getInstance().sendToAllAround(packet, new TargetPoint(this.getWorldObj().provider.dimensionId, this.xCoord, this.yCoord, this.zCoord, 32));
		}
	}

	@Override
	public int[] getPrevValues() {
		int[] val = new int[5];
		val[0] = PrevburnTime;

		if (getStackInSlot(0) != null) {
			val[1] = Item.getIdFromItem(getStackInSlot(0).getItem());
			val[2] = getStackInSlot(0).stackSize;
		}

		if (getStackInSlot(1) != null) {
			val[3] = Item.getIdFromItem(getStackInSlot(1).getItem());
			val[4] = getStackInSlot(1).stackSize;
		}
		return val;
	}

	@Override
	public int offsetForSync() {
		return 1;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		burnTime = nbt.getInteger("burnTimeCoal");
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("burnTimeCoal", burnTime);
		super.writeToNBT(nbt);
	}

	public void handleRightClick(EntityPlayer player) {
		if (getState() == MultiblockState.COMPLETED) {
			if (isValidInput(0, player.getCurrentEquippedItem().getItem())) {
				if (addToSlot(0, player.getCurrentEquippedItem().getItem(), 1, 0)) {
					player.getCurrentEquippedItem().splitStack(1);
					player.inventory.markDirty();
				}
			}else if(GameRegistry.getFuelValue(player.getCurrentEquippedItem())!=0){
				int value =GameRegistry.getFuelValue(player.getCurrentEquippedItem());
				if (burnTime > 40000) {
					
				} else {
					burnTime += value;
					PrevburnTime = burnTime;
					player.getCurrentEquippedItem().splitStack(1);
					player.inventory.markDirty();
				}
			}
			if (player.getCurrentEquippedItem().getItem().equals(IndustrialProcessing.itemPliers)) {
				if (getStackInSlot(1) != null && getStackInSlot(1).stackSize > 0) {
					player.getCurrentEquippedItem().splitStack(1);
					ItemStack givenStack = decrStackSize(1, 1);
					player.inventory.markDirty();
					if (player.inventory.addItemStackToInventory(givenStack)) {
						DropBlock.doDispense(worldObj, givenStack, 1, getForwardDirection().getOpposite(), xCoord, yCoord + 1, zCoord);
					}
					player.inventory.markDirty();
					onInventoryChanged();
				}
			}
			player.inventory.markDirty();
		}
	}
}
