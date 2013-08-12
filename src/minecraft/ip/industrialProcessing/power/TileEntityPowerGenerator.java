package ip.industrialProcessing.power;

import ip.industrialProcessing.machines.TileEntityMachine;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityPowerGenerator extends TileEntityMachine implements IPowerProducer{
     
    private PowerDistributorManager powerManager;
    private boolean searched = false;
    private int maxOutput = 100; 

    public TileEntityPowerGenerator(int maxOutput)
    { 
	this.maxOutput = maxOutput;
	
	this.powerManager = new PowerDistributorManager(this, this);
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
	super.updateEntity(); 
	if(!searched )
	    searchForPowerAcceptors();
	int production = this.producePower(maxOutput , false);
	int demand = this.powerManager.distributePower(production, maxOutput, false);
	int actualProduction = this.producePower(demand, true);
	int distributed = this.powerManager.distributePower(actualProduction, maxOutput, true);
    }
   
    public void searchForPowerAcceptors()
    {
	this.searched = true;
	this.powerManager.searchPowerAcceptors(); 
    }
}
