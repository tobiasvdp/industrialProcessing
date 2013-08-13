package ip.industrialProcessing.transport.fluids;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;

public class ModelTransportFluids extends ModelConnected {

    // fields
    ModelRenderer Center;
    ModelRenderer Down;
    ModelRenderer Up;
    ModelRenderer South;
    ModelRenderer East;
    ModelRenderer West;
    ModelRenderer North;
    ModelRenderer DownConnector;
    ModelRenderer EastConnector;
    ModelRenderer WestConnector;
    ModelRenderer NorthConnector;
    ModelRenderer SouthConnector;
    ModelRenderer UpConnector;
    ModelRenderer EastWest;
    ModelRenderer NorthSouth;
    ModelRenderer UpDown;

    public ModelTransportFluids() {
	textureWidth = 32;
	textureHeight = 32;

	Center = new ModelRenderer(this, 0, 0);
	Center.addBox(-3F, -3F, -3F, 6, 6, 6);
	Center.setRotationPoint(0F, 16F, 0F);
	Center.setTextureSize(32, 32);
	Center.mirror = true;
	setRotation(Center, 0F, 0F, 0F);
	Down = new ModelRenderer(this, 0, 17);
	Down.addBox(-2F, -8F, -2F, 4, 5, 4);
	Down.setRotationPoint(0F, 16F, 0F);
	Down.setTextureSize(32, 32);
	Down.mirror = true;
	setRotation(Down, 3.141593F, 0F, 0F);
	Up = new ModelRenderer(this, 0, 17);
	Up.addBox(-2F, -8F, -2F, 4, 5, 4);
	Up.setRotationPoint(0F, 16F, 0F);
	Up.setTextureSize(32, 32);
	Up.mirror = true;
	setRotation(Up, 0F, 0F, 0F);
	South = new ModelRenderer(this, 0, 17);
	South.addBox(-2F, -8F, -2F, 4, 5, 4);
	South.setRotationPoint(0F, 16F, 0F);
	South.setTextureSize(32, 32);
	South.mirror = true;
	setRotation(South, -1.570796F, 0F, 0F);
	East = new ModelRenderer(this, 0, 17);
	East.addBox(-2F, -8F, -2F, 4, 5, 4);
	East.setRotationPoint(0F, 16F, 0F);
	East.setTextureSize(32, 32);
	East.mirror = true;
	setRotation(East, 0F, 0F, 1.570796F);
	West = new ModelRenderer(this, 0, 17);
	West.addBox(-2F, -8F, -2F, 4, 5, 4);
	West.setRotationPoint(0F, 16F, 0F);
	West.setTextureSize(32, 32);
	West.mirror = true;
	setRotation(West, 0F, 0F, -1.570796F);
	North = new ModelRenderer(this, 0, 17);
	North.addBox(-2F, -8F, -2F, 4, 5, 4);
	North.setRotationPoint(0F, 16F, 0F);
	North.setTextureSize(32, 32);
	North.mirror = true;
	setRotation(North, 1.570796F, 0F, 0F);
	DownConnector = new ModelRenderer(this, 0, 26);
	DownConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	DownConnector.setRotationPoint(0F, 16F, 0F);
	DownConnector.setTextureSize(32, 32);
	DownConnector.mirror = true;
	setRotation(DownConnector, 0F, 0F, 3.141593F);
	EastConnector = new ModelRenderer(this, 0, 26);
	EastConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	EastConnector.setRotationPoint(0F, 16F, 0F);
	EastConnector.setTextureSize(32, 32);
	EastConnector.mirror = true;
	setRotation(EastConnector, 0F, 0F, 1.570796F);
	WestConnector = new ModelRenderer(this, 0, 26);
	WestConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	WestConnector.setRotationPoint(0F, 16F, 0F);
	WestConnector.setTextureSize(32, 32);
	WestConnector.mirror = true;
	setRotation(WestConnector, 0F, 0F, -1.570796F);
	NorthConnector = new ModelRenderer(this, 0, 26);
	NorthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	NorthConnector.setRotationPoint(0F, 16F, 0F);
	NorthConnector.setTextureSize(32, 32);
	NorthConnector.mirror = true;
	setRotation(NorthConnector, 1.570796F, 0F, 0F);
	SouthConnector = new ModelRenderer(this, 0, 26);
	SouthConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	SouthConnector.setRotationPoint(0F, 16F, 0F);
	SouthConnector.setTextureSize(32, 32);
	SouthConnector.mirror = true;
	setRotation(SouthConnector, -1.570796F, 0F, 0F);
	UpConnector = new ModelRenderer(this, 0, 26);
	UpConnector.addBox(-2.5F, -8F, -2.5F, 5, 1, 5);
	UpConnector.setRotationPoint(0F, 16F, 0F);
	UpConnector.setTextureSize(32, 32);
	UpConnector.mirror = true;
	setRotation(UpConnector, 0F, 0F, 0F);
	EastWest = new ModelRenderer(this, 16, 12);
	EastWest.addBox(-2F, -8F, -2F, 4, 15, 4);
	EastWest.setRotationPoint(0F, 16F, 0F);
	EastWest.setTextureSize(32, 32);
	EastWest.mirror = true;
	setRotation(EastWest, 0F, 0F, 1.570796F);
	NorthSouth = new ModelRenderer(this, 16, 12);
	NorthSouth.addBox(-2F, -8F, -2F, 4, 15, 4);
	NorthSouth.setRotationPoint(0F, 16F, 0F);
	NorthSouth.setTextureSize(32, 32);
	NorthSouth.mirror = true;
	setRotation(NorthSouth, 1.570796F, 0F, 0F);
	UpDown = new ModelRenderer(this, 16, 12);
	UpDown.addBox(-2F, -8F, -2F, 4, 15, 4);
	UpDown.setRotationPoint(0F, 16F, 0F);
	UpDown.setTextureSize(32, 32);
	UpDown.mirror = true;
	setRotation(UpDown, 0F, 0F, 0F);
    }

    @Override
    public void renderModelConnected(float f, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {
	boolean hideCenter = false;
	hideCenter |= renderStraigh(f, NorthSouth, NorthConnector, SouthConnector, north, south, east, west, up, down);
	hideCenter |= renderStraigh(f, EastWest, EastConnector, WestConnector, east, west, north, south, up, down);
	hideCenter |= renderStraigh(f, UpDown, UpConnector, DownConnector, up, down, east, west, north, south);
	render(Up, UpConnector, up, f);
	render(Down, DownConnector, down, f);
	render(North, NorthConnector, north, f);
	render(West, WestConnector, west, f);
	render(South, SouthConnector, south, f);
	render(East, EastConnector, east, f);
	if (!hideCenter)
	    Center.render(f);
    }

    private boolean renderStraigh(float f, ModelRenderer northSouth2, ModelRenderer northConnector2, ModelRenderer southConnector2, ConnectionState north2, ConnectionState south2, ConnectionState east2, ConnectionState west2, ConnectionState up2, ConnectionState down2) {
	if (north2 == ConnectionState.DISCONNECTED)
	    return false;
	if (south2 == ConnectionState.DISCONNECTED)
	    return false;
	if (west2 != ConnectionState.DISCONNECTED)
	    return false;
	if (east2 != ConnectionState.DISCONNECTED)
	    return false;
	if (up2 != ConnectionState.DISCONNECTED)
	    return false;
	if (down2 != ConnectionState.DISCONNECTED)
	    return false;

	northSouth2.render(f);
	if (north2 == ConnectionState.PLUGGED)
	    northConnector2.render(f);
	if (south2 == ConnectionState.PLUGGED)
	    southConnector2.render(f);
	return true;
    }

}
