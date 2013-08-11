package ip.industrialProcessing.config;

public class ConfigTransportBlocks {
		private int BlockTransportFluidsID = 3500;
		
		public static int BlockTransportFluidsID(){return getInstance().BlockTransportFluidsID;}
		
		private ConfigTransportBlocks(){
		
		}
		
		private static ConfigTransportBlocks instance = new ConfigTransportBlocks();
		
		public static ConfigTransportBlocks getInstance(){
			return instance;
		}
	}
