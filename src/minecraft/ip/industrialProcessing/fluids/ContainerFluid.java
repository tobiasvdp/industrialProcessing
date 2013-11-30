package ip.industrialProcessing.fluids;

import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import ip.industrialProcessing.config.INamepace;
import ip.industrialProcessing.config.ISetupCreativeTabs;

public class ContainerFluid extends ItemBucket implements IFluidContainerItem {
	private int capacity;
	private int isFull;

	public ContainerFluid(int itemId, Fluid fluid, BlockFluid block, String texture, int capacity) {
		super(itemId, block.blockID);
		setUnlocalizedName("Container" + fluid.getName());
		setMaxStackSize(1);
		setCreativeTab(ISetupCreativeTabs.tabFluid);
		this.capacity = capacity;
		ContainerHandler.containers.put(block, this);
		func_111206_d(INamepace.TEXTURE_NAME_PREFIX + texture);
	}

	@Override
	public FluidStack getFluid(ItemStack container) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid")) {
			return null;
		}
		return FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));
	}

	@Override
	public int getCapacity(ItemStack container) {
		return capacity;
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) {
		if (resource == null) {
			return 0;
		}

		if (!doFill) {
			if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid")) {
				return Math.min(capacity, resource.amount);
			}

			FluidStack stack = FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));

			if (stack == null) {
				return Math.min(capacity, resource.amount);
			}

			if (!stack.isFluidEqual(resource)) {
				return 0;
			}

			return Math.min(capacity - stack.amount, resource.amount);
		}

		if (container.stackTagCompound == null) {
			container.stackTagCompound = new NBTTagCompound();
		}

		if (!container.stackTagCompound.hasKey("Fluid")) {
			NBTTagCompound fluidTag = resource.writeToNBT(new NBTTagCompound());

			if (capacity < resource.amount) {
				fluidTag.setInteger("Amount", capacity);
				container.stackTagCompound.setTag("Fluid", fluidTag);
				return capacity;
			}

			container.stackTagCompound.setTag("Fluid", fluidTag);
			return resource.amount;
		}

		NBTTagCompound fluidTag = container.stackTagCompound.getCompoundTag("Fluid");
		FluidStack stack = FluidStack.loadFluidStackFromNBT(fluidTag);

		if (!stack.isFluidEqual(resource)) {
			return 0;
		}

		int filled = capacity - resource.amount;
		if (resource.amount < filled) {
			stack.amount += resource.amount;
			filled = resource.amount;
		} else {
			stack.amount = capacity;
		}

		container.stackTagCompound.setTag("Fluid", stack.writeToNBT(fluidTag));
		return filled;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) {
		if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Fluid")) {
			return null;
		}

		FluidStack stack = FluidStack.loadFluidStackFromNBT(container.stackTagCompound.getCompoundTag("Fluid"));
		if (stack == null) {
			return null;
		}

		stack.amount = Math.min(stack.amount, maxDrain);
		if (doDrain) {
			if (maxDrain >= capacity) {
				container.stackTagCompound.removeTag("Fluid");

				if (container.stackTagCompound.hasNoTags()) {
					container.stackTagCompound = null;
				}
				return stack;
			}

			NBTTagCompound fluidTag = container.stackTagCompound.getCompoundTag("Fluid");
			fluidTag.setInteger("Amount", fluidTag.getInteger("Amount") - maxDrain);
			container.stackTagCompound.setTag("Fluid", fluidTag);
		}
		return stack;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
		return false;

	}

	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack) {
		return itemStack;

	}

}
