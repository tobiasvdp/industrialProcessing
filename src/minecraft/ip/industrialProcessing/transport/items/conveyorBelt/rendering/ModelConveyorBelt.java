package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import org.lwjgl.opengl.GL11;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.transport.items.conveyorBelt.CornerState;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorConnectionsBase;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorTransportBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class ModelConveyorBelt extends ModelConveyorItemsBase {

	// belt
	ModelRenderer InputLeftElev;
	ModelRenderer InputRight;
	ModelRenderer InputRightElev;
	ModelRenderer InputLeft;

	ModelRenderer ForwardBottom;
	ModelRenderer Forward;
	ModelRenderer ForwardBody;
	ModelRenderer Support6Front;
	ModelRenderer Support10Front;
	ModelRenderer Support5Front;
	ModelRenderer Support9Front;

	ModelRenderer Support11Back;
	ModelRenderer Support8Back;
	ModelRenderer Support7Back;
	ModelRenderer Support12Back;

	ModelRenderer Support15;
	ModelRenderer Support3;
	ModelRenderer Support2;
	ModelRenderer Support1;
	ModelRenderer Support4;
	ModelRenderer Support14;
	ModelRenderer Support13;
	ModelRenderer Support12;

	// corners

	ModelRenderer ForwardCornerCenterBottom;
	ModelRenderer ForwardCornerCenter;
	ModelRenderer ForwardCornerCenterBody;

	ModelRenderer ForwardCornerOutBody;
	ModelRenderer ForwardCornerOutBottom;
	ModelRenderer ForwardCornerOut;

	ModelRenderer ForwardCornerIn3;
	ModelRenderer ForwardCornerIn3Body;
	ModelRenderer ForwardCornerIn3Bottom;

	ModelRenderer ForwardCornerIn2;
	ModelRenderer ForwardCornerIn1;

	ModelRenderer Support16Left;
	ModelRenderer Support17Left;
	ModelRenderer Support20Left;
	ModelRenderer Support21Left;
	ModelRenderer Support23Right;
	ModelRenderer Support18Right;
	ModelRenderer Support22Right;
	ModelRenderer Support19Right;
	// bends

	BendRenderer bend1;
	BendRenderer bend2;
	SlopeCombiner slopeCombiner;

	public ModelConveyorBelt() {
		textureWidth = 64;
		textureHeight = 32;

		InputLeftElev = new ModelRenderer(this, 0, 24);
		InputLeftElev.addBox(-4F, -3F, 0F, 8, 3, 1);
		InputLeftElev.setRotationPoint(6F, 24F - 8F, 0F);
		InputLeftElev.setTextureSize(64, 32);
		InputLeftElev.mirror = true;
		setRotation(InputLeftElev, 1.047198F, 1.570796F, 0F);
		InputRight = new ModelRenderer(this, 0, 21);
		InputRight.addBox(-4F, -8F, 0F, 8, 2, 1);
		InputRight.setRotationPoint(0F, 24F - 8F, 0F);
		InputRight.setTextureSize(64, 32);
		InputRight.mirror = true;
		setRotation(InputRight, 1.570796F, 1.570796F, 0F);
		InputRightElev = new ModelRenderer(this, 0, 17);
		InputRightElev.addBox(-4F, -3F, 0F, 8, 3, 1);
		InputRightElev.setRotationPoint(-6F, 24F - 8F, 0F);
		InputRightElev.setTextureSize(64, 32);
		InputRightElev.mirror = true;
		setRotation(InputRightElev, 1.047198F, -1.570796F, 0F);
		InputLeft = new ModelRenderer(this, 0, 28);
		InputLeft.addBox(-4F, -8F, 0F, 8, 2, 1);
		InputLeft.setRotationPoint(0F, 24F - 8F, 0F);
		InputLeft.setTextureSize(64, 32);
		InputLeft.mirror = true;
		setRotation(InputLeft, 1.570796F, -1.570796F, 0F);

		ForwardBottom = new ModelRenderer(this, 0, 0);
		ForwardBottom.addBox(-4F, 0F, 0F, 8, 16, 1);
		ForwardBottom.setRotationPoint(0F, 19F - 0F, -8F);
		ForwardBottom.setTextureSize(64, 32);
		ForwardBottom.mirror = true;
		setRotation(ForwardBottom, 1.570796F, 0F, 0F);
		Support9Front = new ModelRenderer(this, 60, 26);
		Support9Front.addBox(0F, 0F, 0F, 1, 5, 1);
		Support9Front.setRotationPoint(2F, 24F + 0F, -8F);
		Support9Front.setTextureSize(64, 32);
		Support9Front.mirror = true;
		setRotation(Support9Front, 1.570796F, 0F, 0F);
		Forward = new ModelRenderer(this, 0, 0);
		Forward.addBox(-4F, 0F, 0F, 8, 16, 1);
		Forward.setRotationPoint(0F, 16F + 0F, -8F);
		Forward.setTextureSize(64, 32);
		Forward.mirror = true;
		setRotation(Forward, 1.570796F, 0F, 0F);
		ForwardBody = new ModelRenderer(this, 48, 14);
		ForwardBody.addBox(0F, 0F, 0F, 6, 16, 2);
		ForwardBody.setRotationPoint(-3F, 16F + 0F, 8F);
		ForwardBody.setTextureSize(64, 32);
		ForwardBody.mirror = true;
		setRotation(ForwardBody, -1.570796F, 0F, 0F);
		Support6Front = new ModelRenderer(this, 60, 18);
		Support6Front.addBox(0F, 0F, 0F, 1, 7, 1);
		Support6Front.setRotationPoint(3F, 23F + 0F, -8F);
		Support6Front.setTextureSize(64, 32);
		Support6Front.mirror = true;
		setRotation(Support6Front, -2.356194F, 3.141593F, 0F);
		Support10Front = new ModelRenderer(this, 60, 26);
		Support10Front.addBox(0F, 0F, 0F, 1, 5, 1);
		Support10Front.setRotationPoint(-3F, 24F + 0F, -8F);
		Support10Front.setTextureSize(64, 32);
		Support10Front.mirror = true;
		setRotation(Support10Front, 1.570796F, 0F, 0F);
		Support5Front = new ModelRenderer(this, 60, 18);
		Support5Front.addBox(0F, 0F, 0F, 1, 7, 1);
		Support5Front.setRotationPoint(-2F, 23F + 0F, -8F);
		Support5Front.setTextureSize(64, 32);
		Support5Front.mirror = true;
		setRotation(Support5Front, -2.356194F, 3.141593F, 0F);
		Support15 = new ModelRenderer(this, 60, 26);
		Support15.addBox(0F, 0F, 0F, 1, 4, 1);
		Support15.setRotationPoint(2F, 23F + 0F, 2F);
		Support15.setTextureSize(64, 32);
		Support15.mirror = true;
		setRotation(Support15, -1.570796F, 0F, 0F);
		Support11Back = new ModelRenderer(this, 60, 26);
		Support11Back.addBox(0F, 0F, 0F, 1, 5, 1);
		Support11Back.setRotationPoint(-3F, 23F + 0F, 8F);
		Support11Back.setTextureSize(64, 32);
		Support11Back.mirror = true;
		setRotation(Support11Back, -1.570796F, 0F, 0F);
		Support3 = new ModelRenderer(this, 60, 18);
		Support3.addBox(0F, 0F, 0F, 1, 5, 1);
		Support3.setRotationPoint(-3F, 24F + 0F, 3F);
		Support3.setTextureSize(64, 32);
		Support3.mirror = true;
		setRotation(Support3, 3.141593F, 0F, 0F);
		Support8Back = new ModelRenderer(this, 60, 18);
		Support8Back.addBox(0F, 0F, 0F, 1, 7, 1);
		Support8Back.setRotationPoint(-3F, 23F + 0F, 8F);
		Support8Back.setTextureSize(64, 32);
		Support8Back.mirror = true;
		setRotation(Support8Back, -2.356194F, 0F, 0F);
		Support7Back = new ModelRenderer(this, 60, 18);
		Support7Back.addBox(0F, 0F, 0F, 1, 7, 1);
		Support7Back.setRotationPoint(2F, 23F + 0F, 8F);
		Support7Back.setTextureSize(64, 32);
		Support7Back.mirror = true;
		setRotation(Support7Back, -2.356194F, 0F, 0F);
		Support2 = new ModelRenderer(this, 60, 18);
		Support2.addBox(0F, 0F, 0F, 1, 5, 1);
		Support2.setRotationPoint(2F, 24F + 0F, 3F);
		Support2.setTextureSize(64, 32);
		Support2.mirror = true;
		setRotation(Support2, 3.141593F, 0F, 0F);
		Support1 = new ModelRenderer(this, 60, 18);
		Support1.addBox(0F, 0F, 0F, 1, 5, 1);
		Support1.setRotationPoint(2F, 24F + 0F, -2F);
		Support1.setTextureSize(64, 32);
		Support1.mirror = true;
		setRotation(Support1, 3.141593F, 0F, 0F);
		Support4 = new ModelRenderer(this, 60, 18);
		Support4.addBox(0F, 0F, 0F, 1, 5, 1);
		Support4.setRotationPoint(-3F, 24F + 0F, -2F);
		Support4.setTextureSize(64, 32);
		Support4.mirror = true;
		setRotation(Support4, 3.141593F, 0F, 0F);
		Support12Back = new ModelRenderer(this, 60, 26);
		Support12Back.addBox(0F, 0F, 0F, 1, 5, 1);
		Support12Back.setRotationPoint(2F, 23F + 0F, 8F);
		Support12Back.setTextureSize(64, 32);
		Support12Back.mirror = true;
		setRotation(Support12Back, -1.570796F, 0F, 0F);
		Support14 = new ModelRenderer(this, 60, 26);
		Support14.addBox(0F, 0F, 0F, 1, 4, 1);
		Support14.setRotationPoint(2F, 23F + 0F, -2F);
		Support14.setTextureSize(64, 32);
		Support14.mirror = true;
		setRotation(Support14, -1.570796F, 1.570796F, 0F);
		Support13 = new ModelRenderer(this, 60, 26);
		Support13.addBox(0F, 0F, 0F, 1, 4, 1);
		Support13.setRotationPoint(2F, 23F + 0F, 3F);
		Support13.setTextureSize(64, 32);
		Support13.mirror = true;
		setRotation(Support13, -1.570796F, 1.570796F, 0F);
		Support12 = new ModelRenderer(this, 60, 26);
		Support12.addBox(0F, 0F, 0F, 1, 4, 1);
		Support12.setRotationPoint(-3F, 23F + 0F, 2F);
		Support12.setTextureSize(64, 32);
		Support12.mirror = true;
		setRotation(Support12, -1.570796F, 0F, 0F);

		ForwardCornerOutBody = new ModelRenderer(this, 48, 14);
		ForwardCornerOutBody.addBox(-3F, 3F, 0F, 6, 5, 2);
		ForwardCornerOutBody.setRotationPoint(0F, 18F + 0f, 0F);
		ForwardCornerOutBody.setTextureSize(64, 32);
		ForwardCornerOutBody.mirror = true;
		setRotation(ForwardCornerOutBody, 1.570796F, 0F, 0F);
		ForwardCornerOutBottom = new ModelRenderer(this, 46, 0);
		ForwardCornerOutBottom.addBox(-4F, 4F, 0F, 8, 4, 1);
		ForwardCornerOutBottom.setRotationPoint(0F, 19F + 0f, 0F);
		ForwardCornerOutBottom.setTextureSize(64, 32);
		ForwardCornerOutBottom.mirror = true;
		setRotation(ForwardCornerOutBottom, 1.570796F, 0F, 0F);
		ForwardCornerOut = new ModelRenderer(this, 46, 0);
		ForwardCornerOut.addBox(-4F, 4F, 0F, 8, 4, 1);
		ForwardCornerOut.setRotationPoint(0F, 16F + 0f, 0F);
		ForwardCornerOut.setTextureSize(64, 32);
		ForwardCornerOut.mirror = true;
		setRotation(ForwardCornerOut, 1.570796F, 0F, 0F);

		ForwardCornerCenterBottom = new ModelRenderer(this, 46, 5);
		ForwardCornerCenterBottom.addBox(-4F, -4F, 0F, 8, 8, 1);
		ForwardCornerCenterBottom.setRotationPoint(0F, 19F + 0F, 0F);
		ForwardCornerCenterBottom.setTextureSize(64, 32);
		ForwardCornerCenterBottom.mirror = true;
		setRotation(ForwardCornerCenterBottom, 1.570796F, 0F, 0F);
		ForwardCornerCenter = new ModelRenderer(this, 46, 5);
		ForwardCornerCenter.addBox(-4F, -4F, 0F, 8, 8, 1);
		ForwardCornerCenter.setRotationPoint(0F, 16F + 0F, 0F);
		ForwardCornerCenter.setTextureSize(64, 32);
		ForwardCornerCenter.mirror = true;
		setRotation(ForwardCornerCenter, 1.570796F, 0F, 0F);
		ForwardCornerCenterBody = new ModelRenderer(this, 48, 14);
		ForwardCornerCenterBody.addBox(0F, 5F, 0F, 6, 6, 2);
		ForwardCornerCenterBody.setRotationPoint(-3F, 16F + 0F, 8F);
		ForwardCornerCenterBody.setTextureSize(64, 32);
		ForwardCornerCenterBody.mirror = true;
		setRotation(ForwardCornerCenterBody, -1.570796F, 0F, 0F);
		ForwardCornerIn3 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn3.addBox(-4F, -8F, 0F, 8, 4, 1);
		ForwardCornerIn3.setRotationPoint(0F, 16F + 0F, 0F);
		ForwardCornerIn3.setTextureSize(64, 32);
		ForwardCornerIn3.mirror = true;
		setRotation(ForwardCornerIn3, 1.570796F, 0F, 0F);
		ForwardCornerIn3Bottom = new ModelRenderer(this, 0, 0);
		ForwardCornerIn3Bottom.addBox(-4F, -8F, 0F, 8, 4, 1);
		ForwardCornerIn3Bottom.setRotationPoint(0F, 19F + 0F, 0F);
		ForwardCornerIn3Bottom.setTextureSize(64, 32);
		ForwardCornerIn3Bottom.mirror = true;
		setRotation(ForwardCornerIn3Bottom, 1.570796F, 0F, 0F);
		ForwardCornerIn3Body = new ModelRenderer(this, 48, 14);
		ForwardCornerIn3Body.addBox(-3F, -8F, 0F, 6, 5, 2);
		ForwardCornerIn3Body.setRotationPoint(0F, 18F + 0F, 0F);
		ForwardCornerIn3Body.setTextureSize(64, 32);
		ForwardCornerIn3Body.mirror = true;
		setRotation(ForwardCornerIn3Body, 1.570796F, 0F, 0F);
		ForwardCornerIn2 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn2.addBox(-4F, 0F, 0F, 8, 4, 1);
		ForwardCornerIn2.setRotationPoint(8F, 24F - 8F, 0F);
		ForwardCornerIn2.setTextureSize(64, 32);
		ForwardCornerIn2.mirror = true;
		setRotation(ForwardCornerIn2, 1.570796F, -1.570796F, 0F);
		ForwardCornerIn1 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn1.addBox(-4F, 0F, 0F, 8, 4, 1);
		ForwardCornerIn1.setRotationPoint(-8F, 24F - 8F, 0F);
		ForwardCornerIn1.setTextureSize(64, 32);
		ForwardCornerIn1.mirror = true;
		setRotation(ForwardCornerIn1, 1.570796F, 1.570796F, 0F);

		Support16Left = new ModelRenderer(this, 60, 26);
		Support16Left.addBox(0F, 0F, 0F, 1, 5, 1);
		Support16Left.setRotationPoint(3F, 24F + 0F, -2F);
		Support16Left.setTextureSize(64, 32);
		Support16Left.mirror = true;
		setRotation(Support16Left, 1.570796F, 1.570796F, 0F);
		Support17Left = new ModelRenderer(this, 60, 26);
		Support17Left.addBox(0F, 0F, 0F, 1, 5, 1);
		Support17Left.setRotationPoint(3F, 24F + 0F, 3F);
		Support17Left.setTextureSize(64, 32);
		Support17Left.mirror = true;
		setRotation(Support17Left, 1.570796F, 1.570796F, 0F);
		Support20Left = new ModelRenderer(this, 60, 18);
		Support20Left.addBox(0F, 0F, 0F, 1, 7, 1);
		Support20Left.setRotationPoint(8F, 23F + 0F, -2F);
		Support20Left.setTextureSize(64, 32);
		Support20Left.mirror = true;
		setRotation(Support20Left, -2.356194F, 1.570796F, 0F);
		Support21Left = new ModelRenderer(this, 60, 18);
		Support21Left.addBox(0F, 0F, 0F, 1, 7, 1);
		Support21Left.setRotationPoint(8F, 23F + 0F, 3F);
		Support21Left.setTextureSize(64, 32);
		Support21Left.mirror = true;
		setRotation(Support21Left, -2.356194F, 1.570796F, 0F);
		Support23Right = new ModelRenderer(this, 60, 18);
		Support23Right.addBox(0F, 0F, 0F, 1, 7, 1);
		Support23Right.setRotationPoint(-8F, 23F + 0F, -3F);
		Support23Right.setTextureSize(64, 32);
		Support23Right.mirror = true;
		setRotation(Support23Right, -2.356194F, -1.570796F, 0F);
		Support18Right = new ModelRenderer(this, 60, 26);
		Support18Right.addBox(0F, 0F, 0F, 1, 5, 1);
		Support18Right.setRotationPoint(-3F, 24F + 0F, 2F);
		Support18Right.setTextureSize(64, 32);
		Support18Right.mirror = true;
		setRotation(Support18Right, 1.570796F, -1.570796F, 0F);
		Support22Right = new ModelRenderer(this, 60, 18);
		Support22Right.addBox(0F, 0F, 0F, 1, 7, 1);
		Support22Right.setRotationPoint(-8F, 23F + 0F, 2F);
		Support22Right.setTextureSize(64, 32);
		Support22Right.mirror = true;
		setRotation(Support22Right, -2.356194F, -1.570796F, 0F);
		Support19Right = new ModelRenderer(this, 60, 26);
		Support19Right.addBox(0F, 0F, 0F, 1, 5, 1);
		Support19Right.setRotationPoint(-3F, 24F + 0F, -3F);
		Support19Right.setTextureSize(64, 32);
		Support19Right.mirror = true;
		setRotation(Support19Right, 1.570796F, -1.570796F, 0F);

		bend1 = new BendRenderer(8, -8, (float) -Math.PI / 2, false);
		bend2 = new BendRenderer(-8, -8, (float) Math.PI, true);

		slopeCombiner = new SlopeCombiner();
	}

	@Override
	protected void renderLeft(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		//InputRight.render(f5);
		//InputRightElev.render(f5);

		GL11.glPushMatrix();
		GL11.glRotatef(90, 0, 1, 0);
		ForwardCornerIn3.render(f5);
		ForwardCornerIn3Body.render(f5);
		ForwardCornerIn3Bottom.render(f5);
		GL11.glPopMatrix();
		Support23Right.render(f5);
		Support18Right.render(f5);
		Support22Right.render(f5);
		Support19Right.render(f5);
	}

	@Override
	protected void renderRight(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		
		
		//InputLeft.render(f5);
		//InputLeftElev.render(f5);
		GL11.glPushMatrix();
		GL11.glRotatef(-90, 0, 1, 0);
		ForwardCornerIn3.render(f5);
		ForwardCornerIn3Body.render(f5);
		ForwardCornerIn3Bottom.render(f5);
		GL11.glPopMatrix();
		Support16Left.render(f5);
		Support17Left.render(f5);
		Support20Left.render(f5);
		Support21Left.render(f5);
	}

	@Override
	protected void renderFront(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		ForwardCornerOutBody.render(f5);
		ForwardCornerOutBottom.render(f5);
		ForwardCornerOut.render(f5);
		
		Support11Back.render(f5);
		Support8Back.render(f5);
		Support7Back.render(f5);
		Support12Back.render(f5);
	}

	@Override
	protected void renderBack(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		ForwardCornerIn3.render(f5);
		ForwardCornerIn3Body.render(f5);
		ForwardCornerIn3Bottom.render(f5);
		Support9Front.render(f5);
		Support6Front.render(f5);
		Support10Front.render(f5);
		Support5Front.render(f5);
	}

	@Override
	protected void renderCenterPiece(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		ForwardCornerCenter.render(f5);
		ForwardCornerCenterBody.render(f5);
		ForwardCornerCenterBottom.render(f5);
		Support15.render(f5);
		Support3.render(f5);
		Support2.render(f5);
		Support1.render(f5);
		Support4.render(f5);
		Support14.render(f5);
		Support13.render(f5);
		Support12.render(f5);
	}

	@Override
	protected void renderLeftToFrontBend(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		this.bend1.render(f);
	}

	@Override
	protected void renderRightToFrontBend(TileEntity tl, float f, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {
		this.bend2.render(f);
	}

	@Override
	protected void renderStraight(TileEntity tl, float f5, ForgeDirection forward, ConnectionState front, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState up, ConnectionState down) {

		if (tl instanceof TileEntityConveyorConnectionsBase) {
			TileEntityConveyorConnectionsBase belt = (TileEntityConveyorConnectionsBase) tl;
			SlopeState frontSlope = belt.getSlope(LocalDirection.BACK);
			SlopeState backSlope = belt.getSlope(LocalDirection.FRONT);
			if (frontSlope != backSlope) {
				SlopeRenderer renderer = slopeCombiner.getRenderer(frontSlope, front.isConnected(), backSlope, back.isConnected());
				renderer.render(f5);
				return;
			}
		}

		ForwardBottom.render(f5);
		Forward.render(f5);
		ForwardBody.render(f5);

		Support9Front.render(f5);
		Support6Front.render(f5);
		Support10Front.render(f5);
		Support5Front.render(f5);

		Support11Back.render(f5);
		Support8Back.render(f5);
		Support7Back.render(f5);
		Support12Back.render(f5);

		Support15.render(f5);
		Support3.render(f5);
		Support2.render(f5);
		Support1.render(f5);
		Support4.render(f5);
		Support14.render(f5);
		Support13.render(f5);
		Support12.render(f5);

	}
	/*
	 * @Override protected void drawUpPlug(float f5, ConnectionState north,
	 * ConnectionState west, ConnectionState south, ConnectionState east,
	 * ConnectionState up, ConnectionState down) { // TODO: plug }
	 * 
	 * @Override protected void drawDownPlug(float f5, ConnectionState north,
	 * ConnectionState west, ConnectionState south, ConnectionState east,
	 * ConnectionState up, ConnectionState down) { // TODO plug
	 * 
	 * }
	 * 
	 * @Override protected void drawSpline(TileEntity tl, SlopeState frontSlope,
	 * SlopeState backSlope, ConnectionState frontState, ConnectionState
	 * backState, float f) { SlopeRenderer renderer =
	 * slopeCombiner.getRenderer(frontSlope, frontState !=
	 * ConnectionState.DISCONNECTED, backSlope, backState !=
	 * ConnectionState.DISCONNECTED); renderer.render(f); }
	 * 
	 * 
	 * 
	 * @Override protected void drawStraightConnection(float f5) {
	 * ForwardBottom.render(f5); Forward.render(f5); ForwardBody.render(f5);
	 * 
	 * Support9Front.render(f5); Support6Front.render(f5);
	 * Support10Front.render(f5); Support5Front.render(f5);
	 * 
	 * Support11Back.render(f5); Support8Back.render(f5);
	 * Support7Back.render(f5); Support12Back.render(f5);
	 * 
	 * Support15.render(f5); Support3.render(f5); Support2.render(f5);
	 * Support1.render(f5); Support4.render(f5); Support14.render(f5);
	 * Support13.render(f5); Support12.render(f5); }
	 * 
	 * @Override protected void drawLeftConnection(float f5) {
	 * InputRight.render(f5); InputRightElev.render(f5);
	 * 
	 * Support16Left.render(f5); Support17Left.render(f5);
	 * Support20Left.render(f5); Support21Left.render(f5); }
	 * 
	 * @Override protected void drawRightConnection(float f5) { }
	 * 
	 * @Override protected void drawCornerLeft(float f5) {
	 * ForwardCornerOut.render(f5); ForwardCornerCenter.render(f5);
	 * ForwardCornerIn1.render(f5); Support23Right.render(f5);
	 * Support18Right.render(f5); Support22Right.render(f5);
	 * Support19Right.render(f5); Support11Back.render(f5);
	 * Support8Back.render(f5); Support7Back.render(f5);
	 * Support12Back.render(f5); }
	 * 
	 * @Override protected void drawCornerRight(float f5) {
	 * ForwardCornerOut.render(f5); ForwardCornerCenter.render(f5);
	 * ForwardCornerIn2.render(f5); // ForwardCornerIn1.render(f5);
	 * Support16Left.render(f5); Support17Left.render(f5);
	 * Support20Left.render(f5); Support21Left.render(f5);
	 * Support11Back.render(f5); Support8Back.render(f5);
	 * Support7Back.render(f5); Support12Back.render(f5); }
	 * 
	 * @Override protected void drawTurnLeft(float f5) { this.bend1.render(f5);
	 * }
	 * 
	 * @Override protected void drawTurnRight(float f5) { this.bend2.render(f5);
	 * }
	 * 
	 * 
	 * @Override protected void drawBackPlug(float f5) {}
	 * 
	 * @Override protected void drawFrontPlug(float f5) {}
	 * 
	 * @Override protected void drawLeftPlug(float f5) {}
	 * 
	 * @Override protected void drawRightPlug(float f5) {}
	 */
}
