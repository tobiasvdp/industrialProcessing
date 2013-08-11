package ip.industrialProcessing.power.wire;

import net.minecraft.client.model.ModelRenderer;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;

public class ModelWire extends ModelConnected {
    ModelRenderer Center;
    ModelRenderer Down;
    ModelRenderer Up;
    ModelRenderer North;
    ModelRenderer South;
    ModelRenderer West;
    ModelRenderer East;
    ModelRenderer DownConnector;
    ModelRenderer WestConnector;
    ModelRenderer EastConnector;
    ModelRenderer NorthConnector;
    ModelRenderer SouthConnector;
    ModelRenderer UpConnector;

    public ModelWire() {
	textureWidth = 32;
	textureHeight = 32;

	Center = new ModelRenderer(this, 0, 0);
	Center.addBox(-2F, -2F, -2F, 4, 4, 4);
	Center.setRotationPoint(0F, 16F, 0F);
	Center.setTextureSize(32, 32);
	Center.mirror = true;
	setRotation(Center, 0F, 0F, 0F);
	Down = new ModelRenderer(this, 0, 8);
	Down.addBox(-2F, -8F, -2F, 4, 6, 4);
	Down.setRotationPoint(0F, 16F, 0F);
	Down.setTextureSize(32, 32);
	Down.mirror = true;
	setRotation(Down, 3.141593F, 0F, 0F);
	Up = new ModelRenderer(this, 0, 8);
	Up.addBox(-2F, -8F, -2F, 4, 6, 4);
	Up.setRotationPoint(0F, 16F, 0F);
	Up.setTextureSize(32, 32);
	Up.mirror = true;
	setRotation(Up, 0F, 0F, 0F);
	North = new ModelRenderer(this, 0, 8);
	North.addBox(-2F, -8F, -2F, 4, 6, 4);
	North.setRotationPoint(0F, 16F, 0F);
	North.setTextureSize(32, 32);
	North.mirror = true;
	setRotation(North, 1.570796F, 0F, 0F);
	South = new ModelRenderer(this, 0, 8);
	South.addBox(-2F, -8F, -2F, 4, 6, 4);
	South.setRotationPoint(0F, 16F, 0F);
	South.setTextureSize(32, 32);
	South.mirror = true;
	setRotation(South, -1.570796F, 0F, 0F);
	West = new ModelRenderer(this, 0, 8);
	West.addBox(-2F, -8F, -2F, 4, 6, 4);
	West.setRotationPoint(0F, 16F, 0F);
	West.setTextureSize(32, 32);
	West.mirror = true;
	setRotation(West, 0F, 0F, 1.570796F);
	East = new ModelRenderer(this, 0, 8);
	East.addBox(-2F, -8F, -2F, 4, 6, 4);
	East.setRotationPoint(0F, 16F, 0F);
	East.setTextureSize(32, 32);
	East.mirror = true;
	setRotation(East, 0F, 0F, -1.570796F);
	DownConnector = new ModelRenderer(this, 0, 18);
	DownConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	DownConnector.setRotationPoint(0F, 16F, 0F);
	DownConnector.setTextureSize(32, 32);
	DownConnector.mirror = true;
	setRotation(DownConnector, 0F, 0F, 3.141593F);
	WestConnector = new ModelRenderer(this, 0, 18);
	WestConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	WestConnector.setRotationPoint(0F, 16F, 0F);
	WestConnector.setTextureSize(32, 32);
	WestConnector.mirror = true;
	setRotation(WestConnector, 0F, 0F, 1.570796F);
	EastConnector = new ModelRenderer(this, 0, 18);
	EastConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	EastConnector.setRotationPoint(0F, 16F, 0F);
	EastConnector.setTextureSize(32, 32);
	EastConnector.mirror = true;
	setRotation(EastConnector, 0F, 0F, -1.570796F);
	NorthConnector = new ModelRenderer(this, 0, 18);
	NorthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	NorthConnector.setRotationPoint(0F, 16F, 0F);
	NorthConnector.setTextureSize(32, 32);
	NorthConnector.mirror = true;
	setRotation(NorthConnector, 1.570796F, 0F, 0F);
	SouthConnector = new ModelRenderer(this, 0, 18);
	SouthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	SouthConnector.setRotationPoint(0F, 16F, 0F);
	SouthConnector.setTextureSize(32, 32);
	SouthConnector.mirror = true;
	setRotation(SouthConnector, -1.570796F, 0F, 0F);
	UpConnector = new ModelRenderer(this, 0, 18);
	UpConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	UpConnector.setRotationPoint(0F, 16F, 0F);
	UpConnector.setTextureSize(32, 32);
	UpConnector.mirror = true;
	setRotation(UpConnector, 0F, 0F, 0F);
    }

    @Override
    public void renderModelConnected(float f, ConnectionState north, ConnectionState east, ConnectionState south, ConnectionState west, ConnectionState up, ConnectionState down) {
	render(Up, UpConnector, up, f);
	render(Down, DownConnector, down, f);
	render(North, NorthConnector, north, f);
	render(West, WestConnector, west, f);
	render(South, SouthConnector, south, f);
	render(East, EastConnector, east, f);
	Center.render(f);
    }

    private void render(ModelRenderer wire, ModelRenderer connector, ConnectionState state, float f) {
	switch (state) {
	case PLUGGED:
	    connector.render(f);
	case CONNECTED:
	    wire.render(f);
	    break;
	}
    }

}
