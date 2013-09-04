package ip.industrialProcessing.multiblock.dummy.block.frame;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ENmultiblockFrame extends EntityAnimal{

	public ENmultiblockFrame(World world, double x,double y,double z) {
		super(world);
		this.setSize(1F, 1F);
		this.setPosition(x, y, z);
	}

	@Override
	public void onLivingUpdate(){
		this.setVelocity(0, 0.1, 0);
	}
	@Override 
    protected boolean isAIEnabled()
    {
        return false;
    }
	@Override
	protected void entityInit() {
        super.entityInit();                
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

}
