package ip.industrialProcessing.recipes.recipeRegistry;

import ip.industrialProcessing.recipes.IRecipeWorkHandler;
import ip.industrialProcessing.recipes.Recipe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.tileentity.TileEntity;

import com.google.common.collect.Lists;

public class RecipeRegistry {
	private static HashMap<Recipe, TileEntity> recipes = new HashMap<Recipe, TileEntity>();
	
	public static void registerMachinesRecipes(TileEntity te){
		if(te instanceof IRecipeWorkHandler){
			IRecipeWorkHandler handler = (IRecipeWorkHandler) te;
			Iterator<Recipe> list = handler.iterateRecipes();
			while(list.hasNext()){
				recipes.put(list.next(), te);
			}
		}
		
		
	}
}
