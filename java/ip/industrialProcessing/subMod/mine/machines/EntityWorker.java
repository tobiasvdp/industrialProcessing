package ip.industrialProcessing.subMod.mine.machines;

import ip.industrialProcessing.utils.BlockBreaker;

import java.util.ArrayList;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public abstract class EntityWorker extends EntityVehicle {
	
	protected boolean canWork = false;
	int cooldowntime;
	
	public EntityWorker(World par1World) {
		super(par1World);
		cooldowntime = getMaxCooldownTime();
	}
	
	@Override
	public float getCollisionBorderSize() {
		return 0.5f;
	}


	public EntityWorker(World par1World, float x, float y, float z) {
		super(par1World,x,y,z);
		cooldowntime = getMaxCooldownTime();
	}
	
	@Override
	public void otherUpdates() {
		super.otherUpdates();
		cycleCooldown();
		if(canWork){
			this.stepHeight = getStepHeightAction();
		}else{
			this.stepHeight = getStepHeightRiding();
		}
	}
	
	public void cycleCooldown(){
		cooldowntime--;
		if (cooldowntime < 0) {
			cooldowntime = getMaxCooldownTime();
		}
	}

	public boolean canWork(){
		return cooldowntime == 0 && canWork;
	}
	
	public void toggleMining(EntityClientPlayerMP thePlayer) {
		if (canWork) {
			canWork = false;
			thePlayer.sendChatToPlayer(new ChatMessageComponent().setColor(EnumChatFormatting.YELLOW).addText(getActivity() + " disabled."));
		} else {
			canWork = true;
			thePlayer.sendChatToPlayer(new ChatMessageComponent().setColor(EnumChatFormatting.YELLOW).addText(getActivity() + " enabled."));
		}
	}
	

	public abstract int getMaxCooldownTime();
	public abstract String getActivity();

}
