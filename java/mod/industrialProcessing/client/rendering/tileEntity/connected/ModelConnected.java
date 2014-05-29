package mod.industrialProcessing.client.rendering.tileEntity.connected;

import mod.industrialProcessing.blockContainer.transport.ConnectionState;
import mod.industrialProcessing.client.rendering.block.ModelBlock;
import mod.industrialProcessing.client.rendering.tileEntity.ModelTileEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;

public abstract class ModelConnected extends ModelTileEntity {

    @Override
    public void renderModel(TileEntity tileEntity, float f) {
	renderModelConnected(null, f, ConnectionState.PLUGGED, ConnectionState.DISCONNECTED, ConnectionState.CONNECTED, ConnectionState.DISCONNECTED, ConnectionState.DISCONNECTED, ConnectionState.DISCONNECTED);
    }

    public abstract void renderModelConnected(TileEntity tl, float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down);

    protected void render(ModelRenderer wire, ModelRenderer connector, ConnectionState state, float f) {
	switch (state) {
	case PLUGGED:
	    connector.render(f);
	case CONNECTED:
	    wire.render(f);
	    break;
	default:
	    break;
	}
    }
}
