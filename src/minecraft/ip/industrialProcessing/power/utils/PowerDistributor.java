package ip.industrialProcessing.power.utils;

import java.util.Arrays;

import ip.industrialProcessing.power.IPowerAcceptor;

public class PowerDistributor {

    private float totalSiemens = 0;
    private float[] siemens;
    private PowerAcceptorConnection[] outputs = new PowerAcceptorConnection[0];

    public PowerAcceptorConnection[] getOutputs() {
	return outputs;
    }

    public void setOutputs(PowerAcceptorConnection[] outputs) {
	if (outputs == null)
	    outputs = new PowerAcceptorConnection[0];
	this.outputs = outputs;
	this.siemens = new float[outputs.length];
	Arrays.fill(this.siemens, 0f);
	this.totalSiemens = 0;
    }

    public float getResistance() {
	this.totalSiemens = 0;
	for (int i = 0; i < outputs.length; i++) {
	    PowerAcceptorConnection connection = outputs[i];
	    if (connection != null && connection.acceptor != null && connection.connectedFrom != null) {
		totalSiemens += siemens[i] = 1/connection.acceptor.getResistance(connection.connectedFrom);
	    }
	}
	if(totalSiemens == 0) return Float.POSITIVE_INFINITY;
	return 1/totalSiemens;
    }

    public void distributePower(float voltage, float coulombs) {
	for (int i = 0; i < siemens.length; i++) {
	    PowerAcceptorConnection connection = outputs[i];
	    if (connection != null && connection.acceptor != null && connection.connectedFrom != null) {
		float distribution = coulombs * this.siemens[i] / this.totalSiemens;
		if (distribution > 0) {
		    connection.acceptor.applyPower(connection.connectedFrom, distribution, voltage);
		}
	    }
	}
    }
}
