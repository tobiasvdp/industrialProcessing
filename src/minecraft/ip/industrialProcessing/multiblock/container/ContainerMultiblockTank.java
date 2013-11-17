package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.fluids.FluidTankInfo;
import ip.industrialProcessing.api.handlers.HandlerTank;
import ip.industrialProcessing.api.handlers.IHandlerTank;
import ip.industrialProcessing.api.info.InfoTank;
import ip.industrialProcessing.api.tanks.IPfluidTank;
import ip.industrialProcessing.machines.containers.ProgressBarHandlerInfo;
import ip.industrialProcessing.machines.containers.ProgressBarTankHandler;
import ip.industrialProcessing.machines.containers.ProgressInfoTank;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreInv;
import ip.industrialProcessing.multiblock.core.extend.TEmultiblockCoreTank;

public class ContainerMultiblockTank extends ContainerMultiblockInv {

	private TEmultiblockCoreTank core;

	public ContainerMultiblockTank(InventoryPlayer inventory,TEmultiblockCoreTank core) {
		super(inventory,core);
		this.core = core;
	}
	
	private ArrayList<IHandlerTank> tankHandlers = new ArrayList<IHandlerTank>();
	
	protected void addTankToContainer(int tankSlot)
	{
		IHandlerTank handler = new HandlerTank((this.core).fluidTanks.get(tankSlot));
		this.addHandler(handler);
		this.tankHandlers.add(handler);
	}
	
	public InfoTank getLevelInfoTank(int containerTankSlot)
	{
		IHandlerTank handler = this.tankHandlers.get(containerTankSlot);
		return HandlerTank.getInfo(handler);
	}
}
