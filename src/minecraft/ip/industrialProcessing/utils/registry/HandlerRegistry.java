package ip.industrialProcessing.utils.registry;

import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.plants.IMechanicalMotion;
import ip.industrialProcessing.transport.items.ConveyorLine;
import ip.industrialProcessing.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import ip.industrialProcessing.utils.handler.conveyors.line.ConveyorLineHandler;
import ip.industrialProcessing.utils.handler.conveyors.line.IConveyorLineHandler;
import ip.industrialProcessing.utils.handler.heat.IHeatHandler;

import java.util.Iterator;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;

public class HandlerRegistry {

	private static List<IHeatHandler> heatHandlers = Lists.newArrayList();
	private static List<IConveyorLineHandler> conveyorLineHandler = Lists.newArrayList();

	public static void registerHeatHandler(IHeatHandler handler) {
		heatHandlers.add(handler);
	}

	public static void registerConveyorLineHandler(IConveyorLineHandler handler) {
		conveyorLineHandler.add(handler);
	}

	public static void resetConveyorLineHandler() {
		for (int i = 0; i < conveyorLineHandler.size(); i++) {
			conveyorLineHandler.set(i, new ConveyorLineHandler());
		}
	}

	public static int getHeatValue(ItemStack stack) {
		Iterator<IHeatHandler> it = heatHandlers.iterator();
		int max = 0;
		while (it.hasNext()) {
			IHeatHandler handler = it.next();
			int val = handler.getHeatOfItem(stack);
			if (val > max)
				max = val;
		}
		return max;
	}

	public static int addToConveyorLine(TileEntityConveyorConnectionsBase conveyorBelt, boolean isNBT) {
		if ((conveyorBelt.worldObj != null && !conveyorBelt.worldObj.isRemote) || conveyorBelt.worldObj == null) {
			Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IConveyorLineHandler handler = it.next();
				if (isNBT) {
					handler.registerConveyorFromNBT(conveyorBelt);
					return 0;
				} else {
					ID = handler.registerConveyor(conveyorBelt);
				}
			}
			return ID;
		}
		return -1;
	}

	public static void removeFromConveyorLine(TileEntityConveyorTransportBase cb) {
		if (cb.worldObj != null && !cb.worldObj.isRemote) {
			Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IConveyorLineHandler handler = it.next();
				handler.unregisterConveyor(cb);
			}
		}
	}

	public static boolean addToConveyorLine(int line, TileEntityConveyorBeltPowerInput te) {
		if ((te.worldObj != null && !te.worldObj.isRemote) || te.worldObj == null) {
			Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
			boolean valid = true;
			while (it.hasNext()) {
				IConveyorLineHandler handler = it.next();
				if (!(handler.registerPowercontainer(line, te)))
					valid = false;
			}
			return valid;
		}
		return false;
	}

	public static void removeFromConveyorLine(int line, TileEntityConveyorBeltPowerInput te) {
		if ((te.worldObj != null && !te.worldObj.isRemote) || te.worldObj == null) {
			Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IConveyorLineHandler handler = it.next();
				handler.unregisterPowercontainer(line, te);
			}
		}
	}

	public static float getResistanceForConveyorLine(int line) {
			float resistance = 0;
			Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IConveyorLineHandler handler = it.next();
				resistance = Math.max(resistance, handler.getResistanceForConveyorLine(line));
			}
			return resistance;
	}
	public static float getSpeedForConveyorLine(int line) {
		float speed = 0;
		Iterator<IConveyorLineHandler> it = conveyorLineHandler.iterator();
		int ID = -1;
		while (it.hasNext()) {
			IConveyorLineHandler handler = it.next();
			speed = Math.max(speed, handler.getSpeedForConveyorLine(line));
		}
		return speed;
}

}
