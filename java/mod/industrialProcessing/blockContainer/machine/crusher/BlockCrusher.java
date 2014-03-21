package mod.industrialProcessing.blockContainer.machine.crusher;

import java.util.Random;

import mod.industrialProcessing.blockContainer.BlockContainerIPRendered;
import mod.industrialProcessing.gui.framework.rendering.TextureReference;
import mod.industrialProcessing.gui.generating.GuiBuilderDefault;
import mod.industrialProcessing.gui.generating.IGuiBuilder;
import mod.industrialProcessing.utils.block.IDescriptionBlock;
import mod.industrialProcessing.utils.block.IGuiBlock;
import mod.industrialProcessing.utils.block.IRecipeBlock;
import mod.industrialProcessing.work.recipe.RecipesMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCrusher extends BlockContainerIPRendered implements IRecipeBlock, IDescriptionBlock, IGuiBlock {

	private static final TextureReference WORKER_TEXTURE = TextureReference.createDefault("Ore Crusher", 24, 32);
	public static IGuiBuilder guiBuilder = new GuiBuilderDefault("Ore Crusher").addInputSlot(0).addOutputSlot(1).enableWorker().enablePower();

	public BlockCrusher() {
		super(1F, 1F, Material.iron, Block.soundTypeMetal);
	}

	@Override
	public RecipesMachine getRecipes() {
		return TileEntityCrusher.recipes;
	}

	@Override
	public String getDescription() {
		return "The crusher can grind ores into finer pieces.";
	}

	@Override
	public IGuiBuilder getGui() {
		return guiBuilder;
	}

	Random rnd = new Random();

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
		TileEntityCrusher crusher = (TileEntityCrusher) par1World.getTileEntity(par2, par3, par4);
		if (crusher.getWorker().isWorking()) {
			for (int i = 0; i < 5; i++) {
				int x = 0;
				int z = 0;
				float offsetX = (2 * rnd.nextFloat() - 1f) * 0.25f;
				float offsetZ = (2 * rnd.nextFloat() - 1f) * 0.25f;
				par1World.spawnParticle("smoke", par2 + 0.5f + offsetX, par3 + 0.5f + offsetZ, par4 + 0.5f, x, -0.001f, z);
			}
		}
	}
}
