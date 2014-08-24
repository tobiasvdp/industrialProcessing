package mod.industrialProcessing.plants.industrialAge.windMill.dummy;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

import mod.industrialProcessing.blockContainer.multiblock.dummy.TileEntityMultiblockDummy;

public class TileEntitySails extends TileEntityMultiblockDummy {

	EntitySails en = null;
	public int rot = 0;
	
	@Override
	public void updateEntity() {
		/*if(!worldObj.isRemote && en == null){
			en = new EntitySails(worldObj, xCoord+0.5, yCoord+0.5, zCoord+0.5, getForwardDirection());
			worldObj.spawnEntityInWorld(en);
		}*/
		rot+=2;
		if(rot >= 360){
			rot = 0;
		}
		super.updateEntity();
	}

	public void destroyEntity() {
		//en.setDead();
	}
}
