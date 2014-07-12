package mod.industrialProcessing.utils.handlers.event;

import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;

public class EventHandler {

	static FMLEventChannel test;
	
	private static EventHandler instance = new EventHandler();
	public static EventHandler getInstance() {
		return instance;
	}

	public void register(){
		test = (NetworkRegistry.INSTANCE.newEventDrivenChannel("IP.event.test"));
		//test.register(TileAnimationSyncHandler.getInstance());
	}
}
