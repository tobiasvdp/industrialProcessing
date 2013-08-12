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

    private LocalDirection inputSide = LocalDirection.BACK;
    private float volt;
    private int voltAvailable;

    @Override
    public int acceptPower(int maxAmount, ForgeDirection side, boolean doAccept) {
	if (!doAccept) { // sensing what's availabe on the wire in total
	    this.voltAvailable += maxAmount;
	}
	return 0;
    }

    
    @Override
    public void updateEntity() { 
        super.updateEntity();
        this.volt = voltAvailable / 500f;
        this.voltAvailable = 0;
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
