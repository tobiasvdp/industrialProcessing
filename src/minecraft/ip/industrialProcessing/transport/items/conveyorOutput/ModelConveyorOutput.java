package ip.industrialProcessing.transport.items.conveyorOutput;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.rendering.ModelConveyorBelt;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class ModelConveyorOutput extends ModelConveyorBelt {

	ModelRenderer SupportSide3;
	ModelRenderer SupportSide4;
	ModelRenderer InputConnectorSide12;
	ModelRenderer Side;
	ModelRenderer InputConnectorSide1;
	ModelRenderer SideStep1;
	ModelRenderer SideStep2;
	ModelRenderer SupportSide1;
	ModelRenderer SupportSide2;
	ModelRenderer SupportSide5;

	ModelRenderer CenterBlock2;
	ModelRenderer CenterBlock5;
	ModelRenderer CenterBlock4;
	ModelRenderer CenterBlock3;
	ModelRenderer CenterBlock1;

	ModelRenderer InputConnectorTop1;
	ModelRenderer InputConnectorTop2;

	ModelRenderer InputConnectorBottom1;
	ModelRenderer InputConnectorBottom2;
	ModelRenderer InputConnectorBottom3;
	ModelRenderer DownTube;

	public ModelConveyorOutput() {

		textureWidth = 64;
		textureHeight = 64;

		SupportSide3 = new ModelRenderer(this, 60, 18);
		SupportSide3.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportSide3.setRotationPoint(6F, 23F, -2F);
		SupportSide3.setTextureSize(64, 64);
		SupportSide3.mirror = true;
		setRotation(SupportSide3, 3.141593F, 0F, 0F);
		SupportSide4 = new ModelRenderer(this, 0, 52);
		SupportSide4.addBox(7F, 0F, 0F, 1, 3, 1);
		SupportSide4.setRotationPoint(6F, 23F, 5F);
		SupportSide4.setTextureSize(64, 64);
		SupportSide4.mirror = true;
		setRotation(SupportSide4, -1.570796F, 1.570796F, 0F);
		InputConnectorSide12 = new ModelRenderer(this, 0, 31);
		InputConnectorSide12.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorSide12.setRotationPoint(2.5F, 12.5F, 0F);
		InputConnectorSide12.setTextureSize(64, 64);
		InputConnectorSide12.mirror = true;
		setRotation(InputConnectorSide12, 0F, 1.570796F, 0F);
		Side = new ModelRenderer(this, 0, 50);
		Side.addBox(3F, 0F, -3F, 4, 8, 6);
		Side.setRotationPoint(0F, 12F, 0F);
		Side.setTextureSize(64, 64);
		Side.mirror = true;
		setRotation(Side, 0F, 0F, 0F);
		CenterBlock5 = new ModelRenderer(this, 4, 38);
		CenterBlock5.addBox(0F, 0F, 0F, 1, 5, 1);
		CenterBlock5.setRotationPoint(-4F, 10F, -3F);
		CenterBlock5.setTextureSize(64, 64);
		CenterBlock5.mirror = true;
		setRotation(CenterBlock5, 0F, 1.570796F, 0F);
		CenterBlock4 = new ModelRenderer(this, 4, 38);
		CenterBlock4.addBox(0F, 0F, 0F, 1, 5, 1);
		CenterBlock4.setRotationPoint(-4F, 10F, 4F);
		CenterBlock4.setTextureSize(64, 64);
		CenterBlock4.mirror = true;
		setRotation(CenterBlock4, 0F, 1.570796F, 0F);
		CenterBlock3 = new ModelRenderer(this, 4, 38);
		CenterBlock3.addBox(-7F, 0F, 0F, 1, 5, 1);
		CenterBlock3.setRotationPoint(3F, 10F, -3F);
		CenterBlock3.setTextureSize(64, 64);
		CenterBlock3.mirror = true;
		setRotation(CenterBlock3, 0F, 1.570796F, 0F);
		CenterBlock1 = new ModelRenderer(this, 14, 32);
		CenterBlock1.addBox(-4F, -4F, 0F, 8, 8, 1);
		CenterBlock1.setRotationPoint(0F, 10F, 0F);
		CenterBlock1.setTextureSize(64, 64);
		CenterBlock1.mirror = true;
		setRotation(CenterBlock1, 1.570796F, 0F, 0F);
		InputConnectorSide1 = new ModelRenderer(this, 0, 31);
		InputConnectorSide1.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorSide1.setRotationPoint(7F, 16F, 0F);
		InputConnectorSide1.setTextureSize(64, 64);
		InputConnectorSide1.mirror = true;
		setRotation(InputConnectorSide1, 0F, 1.570796F, 0F);
		InputConnectorTop1 = new ModelRenderer(this, 0, 31);
		InputConnectorTop1.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorTop1.setRotationPoint(0F, 9F, 0F);
		InputConnectorTop1.setTextureSize(64, 64);
		InputConnectorTop1.mirror = true;
		setRotation(InputConnectorTop1, 1.570796F, 1.570796F, 0F);
		InputConnectorTop2 = new ModelRenderer(this, 0, 31);
		InputConnectorTop2.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorTop2.setRotationPoint(0F, 10.5F, 0F);
		InputConnectorTop2.setTextureSize(64, 64);
		InputConnectorTop2.mirror = true;
		setRotation(InputConnectorTop2, 1.570796F, 1.570796F, 0F);
		SideStep1 = new ModelRenderer(this, 4, 43);
		SideStep1.addBox(1F, -3F, 0F, 1, 6, 1);
		SideStep1.setRotationPoint(4F, 12F, 0F);
		SideStep1.setTextureSize(64, 64);
		SideStep1.mirror = true;
		setRotation(SideStep1, 1.570796F, 0F, 0F);
		SideStep2 = new ModelRenderer(this, 13, 48);
		SideStep2.addBox(0F, -3F, 0F, 1, 6, 2);
		SideStep2.setRotationPoint(4F, 12F, 0F);
		SideStep2.setTextureSize(64, 64);
		SideStep2.mirror = true;
		setRotation(SideStep2, 1.570796F, 0F, 0F);
		SupportSide1 = new ModelRenderer(this, 0, 52);
		SupportSide1.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportSide1.setRotationPoint(6F, 23F, 3F);
		SupportSide1.setTextureSize(64, 64);
		SupportSide1.mirror = true;
		setRotation(SupportSide1, -1.570796F, 1.570796F, 0F);
		SupportSide2 = new ModelRenderer(this, 16, 41);
		SupportSide2.addBox(0F, 0F, 0F, 1, 6, 1);
		SupportSide2.setRotationPoint(6F, 23F, 3F);
		SupportSide2.setTextureSize(64, 64);
		SupportSide2.mirror = true;
		setRotation(SupportSide2, -1.570796F, 0F, 0F);
		SupportSide5 = new ModelRenderer(this, 60, 18);
		SupportSide5.addBox(0F, 0F, 0F, 1, 3, 1);
		SupportSide5.setRotationPoint(6F, 23F, 3F);
		SupportSide5.setTextureSize(64, 64);
		SupportSide5.mirror = true;
		setRotation(SupportSide5, 3.141593F, 0F, 0F);
		CenterBlock2 = new ModelRenderer(this, 4, 38);
		CenterBlock2.addBox(0F, 0F, 0F, 1, 5, 1);
		CenterBlock2.setRotationPoint(3F, 10F, -3F);
		CenterBlock2.setTextureSize(64, 64);
		CenterBlock2.mirror = true;
		setRotation(CenterBlock2, 0F, 1.570796F, 0F);
		InputConnectorBottom1 = new ModelRenderer(this, 0, 31);
		InputConnectorBottom1.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorBottom1.setRotationPoint(0F, 24F, 0F);
		InputConnectorBottom1.setTextureSize(64, 64);
		InputConnectorBottom1.mirror = true;
		setRotation(InputConnectorBottom1, 1.570796F, 1.570796F, 0F);
		InputConnectorBottom2 = new ModelRenderer(this, 0, 31);
		InputConnectorBottom2.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorBottom2.setRotationPoint(0F, 15.5F, 0F);
		InputConnectorBottom2.setTextureSize(64, 64);
		InputConnectorBottom2.mirror = true;
		setRotation(InputConnectorBottom2, 1.570796F, 1.570796F, 0F);
		InputConnectorBottom3 = new ModelRenderer(this, 0, 31);
		InputConnectorBottom3.addBox(-3F, -3F, 0F, 6, 6, 1);
		InputConnectorBottom3.setRotationPoint(0F, 19.5F, 0F);
		InputConnectorBottom3.setTextureSize(64, 64);
		InputConnectorBottom3.mirror = true;
		setRotation(InputConnectorBottom3, 1.570796F, 1.570796F, 0F);
		DownTube = new ModelRenderer(this, 34, 32);
		DownTube.addBox(-2F, 0F, -2F, 4, 4, 4);
		DownTube.setRotationPoint(0F, 19F, 0F);
		DownTube.setTextureSize(64, 64);
		DownTube.mirror = true;
		setRotation(DownTube, 0F, 0F, 0F);
	}

	@Override
	protected void renderUp(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		super.renderUp(tl, f, forward, front, right, back, left, up, down);
		if (up.isPlugged() || left.isPlugged() || right.isPlugged() || front.isPlugged() || back.isPlugged()) {
			CenterBlock5.render(f);
			CenterBlock4.render(f);
			CenterBlock3.render(f);
			CenterBlock3.render(f);
			CenterBlock2.render(f);
			CenterBlock1.render(f);
			if (up.isPlugged()) {
				InputConnectorTop1.render(f);
				InputConnectorTop2.render(f);
			}
		}
	}

	@Override
	protected void renderStraight(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		renderFront(tl, f5, forward, front, right, back, left, up, down);
		renderCenterPiece(tl, f5, forward, front, right, back, left, up, down);
		renderBack(tl, f5, forward, front, right, back, left, up, down);
	}

	@Override
	protected void renderCenterPiece(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		super.renderCenterPiece(tl, f5, forward, front, right, back, left, up, down);
	}

	@Override
	protected void renderDown(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {

		super.renderDown(tl, f, forward, front, right, back, left, up, down);
		InputConnectorBottom1.render(f);
		InputConnectorBottom2.render(f);
		InputConnectorBottom3.render(f);
		DownTube.render(f);
	}

	@Override
	protected void renderFront(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		if (!up.isConnected())
			renderUp(tl, f5, forward, front, right, back, left, up, down);
		if (front.isPlugged()) {
			GL11.glPushMatrix();
			GL11.glRotatef(-90, 0, 1, 0);
			SideStep1.render(f5);
			SideStep2.render(f5);
			SupportSide1.render(f5);
			SupportSide2.render(f5);
			SupportSide3.render(f5);
			SupportSide4.render(f5);
			SupportSide5.render(f5);
			Side.render(f5);
			InputConnectorSide12.render(f5);
			InputConnectorSide1.render(f5);
			GL11.glPopMatrix();
		} else
			super.renderFront(tl, f5, forward, front, right, back, left, up, down);
	}

	@Override
	protected void renderBack(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		if (!up.isConnected())
			renderUp(tl, f5, forward, front, right, back, left, up, down);
		if (back.isPlugged()) {
			GL11.glPushMatrix();
			GL11.glRotatef(90, 0, 1, 0);
			SideStep1.render(f5);
			SideStep2.render(f5);
			SupportSide1.render(f5);
			SupportSide2.render(f5);
			SupportSide3.render(f5);
			SupportSide4.render(f5);
			SupportSide5.render(f5);
			Side.render(f5);
			InputConnectorSide12.render(f5);
			InputConnectorSide1.render(f5);
			GL11.glPopMatrix();
		} else
			super.renderBack(tl, f5, forward, front, right, back, left, up, down);
	}

	@Override
	protected void renderLeft(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		if (!up.isConnected())
			renderUp(tl, f5, forward, front, right, back, left, up, down);
		if (left.isPlugged()) {
			GL11.glPushMatrix();
			GL11.glRotatef(180, 0, 1, 0);
			SideStep1.render(f5);
			SideStep2.render(f5);
			SupportSide1.render(f5);
			SupportSide2.render(f5);
			SupportSide3.render(f5);
			SupportSide4.render(f5);
			SupportSide5.render(f5);
			Side.render(f5);
			InputConnectorSide12.render(f5);
			InputConnectorSide1.render(f5);
			GL11.glPopMatrix();
		} else
			super.renderLeft(tl, f5, forward, front, right, back, left, up, down);
	}

	@Override
	protected void renderRight(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		if (!up.isConnected())
			renderUp(tl, f5, forward, front, right, back, left, up, down);
		if (right.isPlugged()) {
			SideStep1.render(f5);
			SideStep2.render(f5);
			SupportSide1.render(f5);
			SupportSide2.render(f5);
			SupportSide3.render(f5);
			SupportSide4.render(f5);
			SupportSide5.render(f5);
			Side.render(f5);
			InputConnectorSide12.render(f5);
			InputConnectorSide1.render(f5);
		} else
			super.renderRight(tl, f5, forward, front, right, back, left, up, down);
	}
}
