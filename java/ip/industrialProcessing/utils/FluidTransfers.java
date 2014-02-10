package ip.industrialProcessing.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class FluidTransfers {
    public static int transfer(int maxAmount, IFluidHandler fromHandler, ForgeDirection fromSide, IFluidHandler toHandler, ForgeDirection toSide) {
        FluidStack availableStack = fromHandler.drain(fromSide, maxAmount, false);
        int maxFill = toHandler.fill(toSide, availableStack, false);
        FluidStack drainedStack = fromHandler.drain(fromSide, maxFill, true);
        return toHandler.fill(toSide, drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidHandler fromHandler, ForgeDirection fromSide, IFluidTank toTank) {
        FluidStack availableStack = fromHandler.drain(fromSide, maxAmount, false);
        int maxFill = toTank.fill(availableStack, false);
        FluidStack drainedStack = fromHandler.drain(fromSide, maxFill, true);
        return toTank.fill(drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidTank fromTank, IFluidHandler toHandler, ForgeDirection toSide) {
        FluidStack availableStack = fromTank.drain(maxAmount, false);
        int maxFill = toHandler.fill(toSide, availableStack, false);
        FluidStack drainedStack = fromTank.drain(maxFill, true);
        return toHandler.fill(toSide, drainedStack, true);
    }

    public static int transfer(int maxAmount, IFluidTank fromTank, IFluidTank toTank) {
        FluidStack availableStack = fromTank.drain(maxAmount, false);
        int maxFill = toTank.fill(availableStack, false);
        FluidStack drainedStack = fromTank.drain(maxFill, true);
        return toTank.fill(drainedStack, true);
    }

    public static int transfer(ItemStack stack, IFluidHandler handler, ForgeDirection side) {
        if (stack == null)
            return 0;

        Item item = stack.getItem();
        if (item == null)
            return 0;

        if (item instanceof IFluidContainerItem)
            return transfer(stack, (IFluidContainerItem) item, handler, side);

        FluidStack fluidStack = FluidContainerRegistry.getFluidForFilledItem(stack);
        if (fluidStack == null)
            return 0;

        int fill = handler.fill(side, fluidStack, false);
        if (fill < fluidStack.amount)
            return 0;
        return handler.fill(side, fluidStack, true);
    }

    private static int transfer(ItemStack stack, IFluidContainerItem container, IFluidHandler handler, ForgeDirection side) {

        FluidStack fluidStack = container.drain(stack, FluidContainerRegistry.BUCKET_VOLUME, false);
        if (stack != null) {
            int amount = handler.fill(side, fluidStack, false);
            fluidStack = container.drain(stack, amount, true);
            if (stack != null)
                return handler.fill(side, fluidStack, true);
        }
        return 0;
    }

    public static boolean handleRightClick(EntityPlayer player, IFluidHandler entity, float x, float y, float z) {
        ForgeDirection side = getClickSide(x, y, z);
        ItemStack currentItem = player.inventory.getStackInSlot(player.inventory.currentItem);
        if (currentItem == null)
            return false;

        int amount = transfer(currentItem, entity, side);
        if (amount > 0) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemTransfers.consumeContainer(currentItem));
            return true;
        } else {
            ItemStack stack = transfer(entity, side, currentItem);
            if (stack != null) {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
                return true;
            }
        }

        return false;
    }

    public static ItemStack transfer(IFluidHandler handler, ForgeDirection side, ItemStack stack) {

        if (stack == null)
            return null;

        Item item = stack.getItem();
        if (item == null)
            return null;

        if (item instanceof IFluidContainerItem)
            return transfer((IFluidContainerItem) item, handler, side, stack);

        FluidStack fluidStack = handler.drain(side, FluidContainerRegistry.BUCKET_VOLUME, false);
        
        ItemStack result = FluidContainerRegistry.fillFluidContainer(fluidStack, stack);
        if(result != null)
        {
            fluidStack = FluidContainerRegistry.getFluidForFilledItem(result);
            fluidStack = handler.drain(side, fluidStack.amount, true);
            return FluidContainerRegistry.fillFluidContainer(fluidStack, stack);
        }
        return null;
    }

    private static ItemStack transfer(IFluidContainerItem container, IFluidHandler handler, ForgeDirection side, ItemStack stack) {

        FluidStack fluidStack = handler.drain(side, FluidContainerRegistry.BUCKET_VOLUME, false);
        if (stack != null) {
            int amount = container.fill(stack, fluidStack, false);
            fluidStack = handler.drain(side, amount, true);
            if (stack != null) {
                container.fill(stack, fluidStack, true);
                return stack;
            }
        }
        return null;
    }

    private static ForgeDirection getClickSide(float x, float y, float z) {
        x -= 0.5;
        y -= 0.5;
        z -= 0.5;
        ForgeDirection bestMatch = ForgeDirection.UP;
        float value = 0;
        for (int i = 0; i < 6; i++) {
            ForgeDirection direction = ForgeDirection.getOrientation(i);
            float dot = direction.offsetX * x + direction.offsetY * y + direction.offsetZ * z;
            if (dot > value) {
                value = dot;
                bestMatch = direction;
            }
        }
        return bestMatch;
    }
}
