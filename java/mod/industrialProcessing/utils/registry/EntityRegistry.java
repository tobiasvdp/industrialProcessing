package mod.industrialProcessing.utils.registry;
import java.util.ArrayList;

import mod.industrialProcessing.IndustrialProcessing;
import mod.industrialProcessing.client.rendering.entity.ModelEntity;
import mod.industrialProcessing.client.rendering.entity.RendererEntity;
import mod.industrialProcessing.entity.EntityIP;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class EntityRegistry {

	private static ArrayList<Class> array = new ArrayList<Class>();
	
	public static void register(Class entity,String name, boolean update, ModelEntity model, String texture){
		 cpw.mods.fml.common.registry.EntityRegistry.registerModEntity(entity, name, array.size(), IndustrialProcessing.instance, 80, 2, update);
		RenderingRegistry.registerEntityRenderingHandler(entity, new RendererEntity(model, texture));
		array.add(entity);
	}
}
