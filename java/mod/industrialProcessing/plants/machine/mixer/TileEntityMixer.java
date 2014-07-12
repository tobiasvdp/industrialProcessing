package mod.industrialProcessing.plants.machine.mixer;

import java.util.Iterator;

import mod.industrialProcessing.blockContainer.machine.TileEntityMachineTankWorkPower;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TileTankSyncHandler;
import mod.industrialProcessing.utils.rotation.LocalDirection;
import mod.industrialProcessing.work.recipe.IMachineRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class TileEntityMixer extends TileEntityMachineTankWorkPower{

	public static RecipesMixer recipes = new RecipesMixer();

	public TileEntityMixer() {
		super(recipes,LocalDirection.RIGHT, 10000, 100);
		addStack(null, LocalDirection.UP, true, false); // Mixing ingredient

		LocalDirection[] nodirections = new LocalDirection[0];
		// buckets!
		addStack(null, nodirections, true, false); // Liquid Input Full
		// Input
		addStack(null, nodirections, false, true); // Liquid Input Empty
		// Output
		addStack(null, nodirections, true, false); // Liquid Output Empty
		// Input
		addStack(null, nodirections, false, true); // Liquid Output Full
		// Output

		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.LEFT, true, false,1,2);
		addTank(FluidContainerRegistry.BUCKET_VOLUME * 10, LocalDirection.DOWN, false, true,3,4);
		
		setupTankSync(0);
	}
}
