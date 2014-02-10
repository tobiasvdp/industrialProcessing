package ip.industrialProcessing.multiblock.container;

import java.util.ArrayList;

import net.minecraft.entity.player.InventoryPlayer;
import ip.industrialProcessing.gui.container.syncing.handlers.HandlerTank;
import ip.industrialProcessing.gui.container.syncing.handlers.IHandlerTank;
import ip.industrialProcessing.gui.container.syncing.info.InfoTank;
import ip.industrialProcessing.multiblock.core.extend.TileEntityMultiblockCoreTank;

public class ContainerMultiblockTank extends ContainerMultiblockInv {

	private TileEntityMultiblockCoreTank core;

	public ContainerMultiblockTank(InventoryPlayer inventory,TileEntityMultiblockCoreTank core) {
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
