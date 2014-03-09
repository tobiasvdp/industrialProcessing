package mod.industrialProcessing.utils.registry;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityRegistry {
	private static HashMap<Block, Class> array = new HashMap<Block, Class>();
	public static void registerTileEntity(Block block, Class tileEntity, String uniqueId){
		GameRegistry.registerTileEntity(tileEntity, uniqueId);
		array.put(block, tileEntity);
	}
	public static TileEntity createNewTileEntity(Block block) {
		Class teClass = array.get(block);
		if(teClass != null)
			try {
				return (TileEntity) teClass.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				return null;
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
				
			}
		return null;
	}
	
	public static Class getTileEntityClassForBlock(Block block){
		return array.get(block);
	}
}
