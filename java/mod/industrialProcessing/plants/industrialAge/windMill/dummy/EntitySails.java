package mod.industrialProcessing.plants.industrialAge.windMill.dummy;

import mod.industrialProcessing.entity.EntityIP;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EntitySails extends EntityIP {

	public ForgeDirection forwards = ForgeDirection.NORTH;

	public EntitySails(World par1World) {
		super(par1World);
		if (!worldObj.isRemote) {
			this.setSize(4.0f, 4.0f);
		}
		this.myEntitySize = EnumEntitySize.SIZE_6;
		
	}

	public EntitySails(World par1World, double d, double e, double f, ForgeDirection dir) {
		super(par1World);
		this.setSize(4.0f, 4.0f);
		this.setLocationAndAngles(d, e - 1.5f, f, 0, 0);
		forwards = dir;
	}

}
