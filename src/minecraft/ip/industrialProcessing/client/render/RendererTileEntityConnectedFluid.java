package ip.industrialProcessing.client.render;

import ip.industrialProcessing.IndustrialProcessing;
import ip.industrialProcessing.api.rendering.RendererTileEntity;
import ip.industrialProcessing.machines.animation.tanks.ITankSyncable;
import ip.industrialProcessing.machines.animation.tanks.TankHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class RendererTileEntityConnectedFluid extends RendererTileEntity {

	private ModelConnectedFluid model;

	public RendererTileEntityConnectedFluid(Block block, String name, ModelConnectedFluid model) {
		super(block, name, model);
		this.model = model;
		this.rotateModel = false;
	}

	@Override
	protected void renderBlock(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {

		ConnectionState north = ConnectionState.DISCONNECTED;
		ConnectionState east = ConnectionState.DISCONNECTED;
		ConnectionState south = ConnectionState.DISCONNECTED;
		ConnectionState west = ConnectionState.DISCONNECTED;
		ConnectionState up = ConnectionState.DISCONNECTED;
		ConnectionState down = ConnectionState.DISCONNECTED;

		if (tl instanceof IConnectedTile) {
			IConnectedTile tile = (IConnectedTile) tl;
			if (tile != null) {
				north = tile.getConnection(ForgeDirection.NORTH);
				east = tile.getConnection(ForgeDirection.EAST);
				south = tile.getConnection(ForgeDirection.SOUTH);
				west = tile.getConnection(ForgeDirection.WEST);
				up = tile.getConnection(ForgeDirection.UP);
				down = tile.getConnection(ForgeDirection.DOWN);
			}
		}
		if (world == null) {
			north = ConnectionState.PLUGGED;
			south = ConnectionState.CONNECTED;
		}
		this.model.renderModelConnected(tl, f, north, east, south, west, up, down);

		if (tl instanceof ITankSyncable) {
			ITankSyncable tankSync = (ITankSyncable) tl;

			TankHandler handler = tankSync.getTankHandler();

			this.func_110628_a(TextureMap.field_110575_b);
			int tankCount = handler.getTankCount();
			for (int l = 0; l < tankCount; l++) {

				int amount = handler.getAmount(l);
				int fluidId = handler.getFluidID(l);
				int capacity = handler.getCapacity(l);
				if (fluidId > 0) {
					Fluid fluid = FluidRegistry.getFluid(fluidId);
					if (fluid != null) {
						Icon icon = fluid.getStillIcon();
						this.model.renderModelConnectedFluid(tl, f, north, east, south, west, up, down, l, amount / (float) capacity, icon);
					}
				}
			}
		}
	}
	@Override
	protected ResourceLocation getTexture(TileEntity tl, World world, int i, int j, int k, Block block2, float f) {
		return texture = new ResourceLocation(IndustrialProcessing.TEXTURE_DOMAIN, "textures/render/" + name + ".png");
	}
}
