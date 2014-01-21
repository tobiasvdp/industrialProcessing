package ip.industrialProcessing.transport.items.conveyorBelt;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import ic2.api.Direction;
import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.machines.IPowerStorage;
import ip.industrialProcessing.machines.SimplePowerStorage;
import ip.industrialProcessing.power.IPoweredMachine;
import ip.industrialProcessing.power.PowerHelper;
import ip.industrialProcessing.utils.DirectionUtils;
import ip.industrialProcessing.utils.registry.HandlerRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public abstract class TileEntityConveyorPowerTranslation extends TileEntityConveyorInteractionBase {

	public TileEntityConveyorPowerTranslation() {
		super();
		this.speed = 0.01f;
	}

	@Override
	public void updateEntity() {
		if(!worldObj.isRemote && this.conveyorLine != -1){
			setSpeed(Math.max(0.01f,HandlerRegistry.getSpeedForConveyorLine(this.conveyorLine)));
		}
		super.updateEntity();
	}

}
