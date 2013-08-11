package ip.industrialProcessing.power.utils;

import java.util.Arrays;

import ip.industrialProcessing.power.IPowerAcceptor;

public class PowerDistributor {

    private int totalUsage = 0;
    private int[] usages;
    private PowerAcceptorConnection[] outputs = new PowerAcceptorConnection[0];

    public PowerAcceptorConnection[] getOutputs() {
	return outputs;
    }

    public void setOutputs(PowerAcceptorConnection[] outputs) {
	if (outputs == null)
	    outputs = new PowerAcceptorConnection[0];
	this.outputs = outputs;
	this.usages = new int[outputs.length];
	Arrays.fill(this.usages, 0);
	this.totalUsage = 0;
    }

    public int distributePower(int availablePower, int maxPerSide, boolean doDistribute) {
	int currentTotalUsage = 0;
	for (int i = 0; i < outputs.length; i++) {
	    PowerAcceptorConnection connection = outputs[i];
	    if (connection != null && connection.acceptor != null && connection.connectedFrom != null) {
		int availableOutput = availablePower;
		if (doDistribute) {
		    // divide proportional to demand:
		    availableOutput = availablePower * this.usages[i] / Math.max(this.totalUsage, 1);
		}// else: give it all we've got!
		availableOutput = Math.min(availableOutput, maxPerSide);
		int usage = connection.acceptor.acceptPower(availableOutput, connection.connectedFrom, doDistribute);
		this.usages[i] = usage; 
		currentTotalUsage += usage;
	    } else
		usages[i] = 0;
	}
	totalUsage = currentTotalUsage;
	return currentTotalUsage;
    }
}
