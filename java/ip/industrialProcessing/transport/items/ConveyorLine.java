package ip.industrialProcessing.transport.items;

import ip.industrialProcessing.power.plants.IMechanicalMotion;
import ip.industrialProcessing.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;

import java.util.ArrayList;
import java.util.Iterator;

public class ConveyorLine {
	public int ID = -1;

	private ArrayList<TileEntityConveyorBeltPowerInput> powercontainers;
	private ArrayList<TileEntityConveyorConnectionsBase> blocks;
	private float resistancePerBlock = 0.2f;
	private float baseResistance = 1f;

	public ConveyorLine(int id) {
		this.ID = id;
		this.blocks = new ArrayList<TileEntityConveyorConnectionsBase>();
		this.powercontainers = new ArrayList<TileEntityConveyorBeltPowerInput>();
	}

	public void registerPowercontainer(TileEntityConveyorBeltPowerInput te) {
		if (!powercontainers.contains(te)) {
			powercontainers.add(te);
		}
	}

	public void unregisterPowercontainer(TileEntityConveyorBeltPowerInput te) {
		int index = powercontainers.indexOf(te);
		powercontainers.remove(index);
	}

	public void registerConveyor(TileEntityConveyorConnectionsBase te) {
		if (!blocks.contains(te))
			blocks.add(te);
	}

	public void registerConveyor(ConveyorLine conveyorLine) {
		if (conveyorLine != null) {
			blocks.addAll(conveyorLine.blocks);
			Iterator<TileEntityConveyorConnectionsBase> it = blocks.iterator();
			while (it.hasNext()) {
				it.next().setConveyorLineID(ID);
			}
		}
	}

	public boolean unregisterConveyor(TileEntityConveyorConnectionsBase te) {
		blocks.remove(te);
		if (blocks.size() == 0) {
			return true;
		}
		return false;
	}

	public float getResistance() {
		return (baseResistance + (resistancePerBlock * blocks.size())) / powercontainers.size();
	}

	public float getSpeed() {
		float speed = 0.0f;
		if(this.powercontainers.size() == 0)
			return speed;
		for (int i = 0; i < this.powercontainers.size(); i++) {
			speed += this.powercontainers.get(i).getSpeed();
		}
		return speed / this.powercontainers.size();
	}

	public int getPowerID(IMechanicalMotion te) {
		return powercontainers.indexOf(te);
	}
}
