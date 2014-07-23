package mod.industrialProcessing.utils.registry;

import java.util.Iterator;
import java.util.List;

import mod.industrialProcessing.plants.transport.items.ConveyorBeltPowerInput.TileEntityConveyorBeltPowerInput;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorConnectionsBase;
import mod.industrialProcessing.transport.items.conveyorBelt.tileEntity.TileEntityConveyorTransportBase;
import mod.industrialProcessing.utils.handlers.heat.IHeatHandler;
import mod.industrialProcessing.utils.handlers.line.ILineHandler;
import mod.industrialProcessing.utils.handlers.line.ILineTileEntity;
import mod.industrialProcessing.utils.handlers.line.IOldLineHandler;
import mod.industrialProcessing.utils.handlers.line.OldLineHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.google.common.collect.Lists;

public class HandlerRegistry {

	private static List<IHeatHandler> heatHandlers = Lists.newArrayList();
	private static List<IOldLineHandler> oldLineHandler = Lists.newArrayList();
	private static List<ILineHandler> lineHandlers = Lists.newArrayList();

	
	public static void registerLineHandler(ILineHandler handler) {
		lineHandlers.add(handler);
	}
	
	public static void registerToLineHandler(String lineHandler, ILineTileEntity te, ForgeDirection dir) {
		Iterator<ILineHandler> it = lineHandlers.iterator();
		while(it.hasNext()){
			ILineHandler handler = it.next();
			if(handler.getName().equals(lineHandler)){
				handler.registerToLine(te,dir);
			}
		}
	}
	
	public static void unregisterFromLineHandler(String lineHandler, ILineTileEntity te, ForgeDirection dir) {
		Iterator<ILineHandler> it = lineHandlers.iterator();
		while(it.hasNext()){
			ILineHandler handler = it.next();
			if(handler.getName().equals(lineHandler)){
				handler.unregisterFromLine(te,dir);
			}
		}
	}
	
	public static void registerHeatHandler(IHeatHandler handler) {
		heatHandlers.add(handler);
	}

	public static void registerConveyorLineHandler(IOldLineHandler handler) {
		oldLineHandler.add(handler);
	}


	public static void resetConveyorLineHandler() {
		for (int i = 0; i < oldLineHandler.size(); i++) {
			oldLineHandler.set(i, new OldLineHandler());
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
		if ((conveyorBelt.getWorldObj() != null && !conveyorBelt.getWorldObj().isRemote) || conveyorBelt.getWorldObj() == null) {
			Iterator<IOldLineHandler> it = oldLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IOldLineHandler handler = it.next();
				if (isNBT) {
					handler.registerLineFromNBT(conveyorBelt);
					return 0;
				} else {
					ID = handler.registerLine(conveyorBelt);
				}
			}
			return ID;
		}
		return -1;
	}

	public static void removeFromConveyorLine(TileEntityConveyorTransportBase cb) {
		if (cb.getWorldObj() != null && !cb.getWorldObj().isRemote) {
			Iterator<IOldLineHandler> it = oldLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IOldLineHandler handler = it.next();
				handler.unregisterLine(cb);
			}
		}
	}

	/*
	public static int addToLogicLine(ILinePart te, boolean isNBT) {
		if ((((TileEntity) te).getWorldObj() != null && !((TileEntity) te).getWorldObj().isRemote) || ((TileEntity) te).getWorldObj() == null) {
			Iterator<ILineHandler> it = logicLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				ILineHandler handler = it.next();
				if (te instanceof ILineTransport) {
					if (isNBT) {
						handler.registerTransportFromNBT((ILineTransport) te);
						return 0;
					} else {
						ID = handler.registerTransport((ILineTransport) te);
					}
				} else if (te instanceof ILineDevice) {
					for(int i = 0;i<6;i++){
						int id = ((ILineDevice)te).getLineID(i);
						if(id != -1){
							handler.registerDevice(id, (ILineDevice) te);
						}
					}
					return -1;
				}
			}
			return ID;
		}
		return -1;
	}
	*/

	/*
	public static void removeFromLogicLine(ILinePart te) {
		if (((TileEntity) te).getWorldObj() != null && !((TileEntity) te).getWorldObj().isRemote) {
			Iterator<ILineHandler> it = logicLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				ILineHandler handler = it.next();
				if(te instanceof ILineDevice){
					for(int i = 0;i<6;i++){
						int id = ((ILineDevice)te).getLineID(i);
						if(id != -1){
							handler.unregisterDevice(id, (ILineDevice) te);
						}
					}
				}
				if(te instanceof ILineTransport)
					handler.unregisterTransport((ILineTransport) te);
			}
		}
	}
	*/

	public static boolean addToConveyorLine(int line, TileEntityConveyorBeltPowerInput te) {
		if ((te.getWorldObj() != null && !te.getWorldObj().isRemote) || te.getWorldObj() == null) {
			Iterator<IOldLineHandler> it = oldLineHandler.iterator();
			boolean valid = true;
			while (it.hasNext()) {
				IOldLineHandler handler = it.next();
				if (!(handler.registerPowercontainer(line, te)))
					valid = false;
			}
			return valid;
		}
		return false;
	}

	public static void removeFromConveyorLine(int line, TileEntityConveyorBeltPowerInput te) {
		if ((te.getWorldObj() != null && !te.getWorldObj().isRemote) || te.getWorldObj() == null) {
			Iterator<IOldLineHandler> it = oldLineHandler.iterator();
			int ID = -1;
			while (it.hasNext()) {
				IOldLineHandler handler = it.next();
				handler.unregisterPowercontainer(line, te);
			}
		}
	}

	public static float getResistanceForConveyorLine(int line) {
		float resistance = 0;
		Iterator<IOldLineHandler> it = oldLineHandler.iterator();
		int ID = -1;
		while (it.hasNext()) {
			IOldLineHandler handler = it.next();
			resistance = Math.max(resistance, handler.getResistanceForLine(line));
		} 
		return resistance;
	}

	public static float getSpeedForConveyorLine(int line) {
		float speed = 0;
		Iterator<IOldLineHandler> it = oldLineHandler.iterator();
		int ID = -1;
		while (it.hasNext()) {
			IOldLineHandler handler = it.next();
			speed = Math.max(speed, handler.getSpeedForLine(line));
		}
		return speed;
	}

}
