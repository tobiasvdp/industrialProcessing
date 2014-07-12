package mod.industrialProcessing.client.rendering.tileEntity;

import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.ITankSyncable;
import mod.industrialProcessing.client.rendering.tileEntity.animation.tanks.TankHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RendererTileEntityFluidWorker extends RendererTileEntityAnimated {

	private ModelAnimatedFluidMachine model;

	public RendererTileEntityFluidWorker(Block block, String name, ModelAnimatedFluidMachine model) {
		super(block, name, model);
		this.model = model;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		super.renderBlock(tl, world, i, j, k, block2, f);
		if (tl instanceof ITankSyncable) {
			ITankSyncable tankSync = (ITankSyncable) tl;

			TankHandler handler = tankSync.getTankHandler();

			this.bindTexture(TextureMap.locationBlocksTexture);
			if (handler != null) {
				int tankCount = handler.getTankCount();
				for (int l = 0; l < tankCount; l++) {

					int amount = handler.getAmount(l);
					int fluidId = handler.getFluidID(l);
					int capacity = handler.getCapacity(l);
					if (fluidId > 0) {
						Fluid fluid = FluidRegistry.getFluid(fluidId);
						if (fluid != null) {
							IIcon icon = fluid.getStillIcon();
							this.model.renderLiquid(tl, 0.0625f, l, amount / (float) capacity, icon);
						}
					}
				}
			}
		}
	}
}
