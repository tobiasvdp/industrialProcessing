package ip.industrialProcessing.utils.fluids;

import ip.industrialProcessing.api.TileEntity.ITank;
import ip.industrialProcessing.client.render.IFluidInfo;
import ip.industrialProcessing.machines.IMachineTanks;
import ip.industrialProcessing.machines.RecipesMachine;
import ip.industrialProcessing.multiblock.utils.MultiblockTank;
import ip.industrialProcessing.transport.fluids.IPressuredTank;
import ip.industrialProcessing.utils.mapping.MappingIDtoSlot;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public interface ICoreTanks extends IFluidHandler,IMachineTanks, IFluidInfo, IPressuredTank, ITank {

}
