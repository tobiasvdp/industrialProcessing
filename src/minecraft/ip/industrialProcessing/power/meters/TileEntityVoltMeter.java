package ip.industrialProcessing.power.meters;

import ic2.api.Direction;
import ip.industrialProcessing.DirectionUtils;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.IAnimationProgress;
import ip.industrialProcessing.machines.TileEntityMachine;
import ip.industrialProcessing.power.IPowerAcceptor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityVoltMeter extends TileEntityMachine implements IPowerAcceptor, IAnimationProgress {

    private LocalDirection inputSide = LocalDirection.RIGHT;
    private float volt;

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (!doAccept) { // sensing what's availabe on the wire in total
	    System.out.println("Max Amount of power on the network: " + maxAmount);
	    this.volt += (maxAmount / 100F - this.volt) / 10;
	}
	return 0;
    }

    @Override
    public boolean canAcceptPower(ForgeDirection side) {
	LocalDirection diretion = DirectionUtils.GetLocalDirection(side, getForwardDirection());
	return inputSide == diretion;
    }

    @Override
    protected boolean isValidInput(int slot, int itemID) {
	return false;
    }

    @Override
    public float getAnimationProgress(float scale) {
	return volt;
    }

}
