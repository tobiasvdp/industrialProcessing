package ip.industrialProcessing.machines.treetap;

import ip.industrialProcessing.machines.containers.IProgressBarHandler;

public class AutomaticTreetapHandler implements IProgressBarHandler {

    private TileEntityAutomaticTreeTap tileEntity;

    public AutomaticTreetapHandler(TileEntityAutomaticTreeTap tileEntity)
    {
        this.tileEntity = tileEntity;
    }
    
    @Override
    public int getValueCount() {
        return 2;
    }

    @Override
    public int getValue(int i) {
        if (i == 0)
            return tileEntity.getProgress();
        if (i == 1)
            return tileEntity.getMaxProgress();
        return 0;
    }

}
