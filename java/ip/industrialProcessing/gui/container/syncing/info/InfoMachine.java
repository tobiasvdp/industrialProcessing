package ip.industrialProcessing.gui.container.syncing.info;

import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.InterfaceType;
import ip.industrialProcessing.subMod.logic.old.api.network.interfaces.StatusType;

import java.util.ArrayList;

public class InfoMachine implements IExpirable {
	public InfoPower power = new InfoPower();
	public InfoWorker worker = new InfoWorker();
	public ArrayList<InfoTank> tanks = new ArrayList<InfoTank>();
	public ArrayList<InfoSlot> slots = new ArrayList<InfoSlot>();
	public StatusType status = StatusType.idle;
	public InterfaceType[] interfaceTypes;
	public String name = "";
	public int x;
	public int y;
	public int z;

	public int ttl;

	public InfoMachine() {
		ttl = 20;
	}

	@Override
	public boolean tick() {
		boolean tick = false;
		if (ttl > 0) {
			this.ttl--;
			tick = true;
		}
		if (power.tick())
			tick = true;
		if (worker.tick())
			tick = true;
		for(int i = 0;i<tanks.size();i++){
		    if(tanks.get(i).tick())
			tick = true;
		}
		for(int i = 0;i<slots.size();i++){
		    if(slots.get(i).tick())
			tick = true;
		}
		return tick;
	}

	@Override
	public boolean isExpired() {
		if (this.ttl > 0)
			return false;
		return true;
	}

	public InfoTank getOrSetTank(int i) {
	    if(tanks.size() >i)
		return tanks.get(i);
	    while(tanks.size()<=i){
		tanks.add(new InfoTank());
	    }
	    return tanks.get(i);
		
	}
	
	public InfoSlot getOrSetSlot(int i) {
	    if(slots.size() >i)
		return slots.get(i);
	    while(slots.size()<=i){
		slots.add(new InfoSlot());
	    }
	    return slots.get(i);
		
	}

}
