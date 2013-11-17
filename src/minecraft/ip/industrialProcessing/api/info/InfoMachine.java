package ip.industrialProcessing.api.info;

import ip.industrialProcessing.logic.api.network.interfaces.StatusType;

public class InfoMachine {
	public InfoPower power =  new InfoPower();
	public InfoWorker worker =  new InfoWorker();
	public StatusType status = StatusType.idle;
	
	public InfoMachine(){}
}
