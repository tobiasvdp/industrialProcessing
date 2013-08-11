package ip.industrialProcessing.power;

import ip.industrialProcessing.machines.TileEntityMachine;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPowerGenerator extends TileEntityMachine implements IPowerProducer{

    private PowerProducerManager powerManager; 

    public TileEntityPowerGenerator(int capacity, int maxOutput)
    { 
	this.powerManager = new PowerProducerManager(this, this, capacity, maxOutput);
    }
      
    @Override
    public void readFromNBT(NBTTagCompound nbt) { 
        super.readFromNBT(nbt);
        this.powerManager.readFromNBT(nbt);
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt) { 
        super.writeToNBT(nbt);
        this.powerManager.writeToNBT(nbt);
    }
    
    @Override
    public boolean canUpdate() {
	return true;
    }

    @Override
    public void updateEntity() {
	this.powerManager.update();
	super.updateEntity();
    }
  
    public PowerProducerManager getProducer() { 
	return this.powerManager;
    }
}
