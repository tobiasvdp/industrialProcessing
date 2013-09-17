package ip.industrialProcessing.transport.items.conveyorBelt.rendering;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.machines.BlockMachine;
import ip.industrialProcessing.transport.items.conveyorBelt.CornerState;
import ip.industrialProcessing.transport.items.conveyorBelt.MovingItemStack;
import ip.industrialProcessing.transport.items.conveyorBelt.SlopeState;
import ip.industrialProcessing.transport.items.conveyorBelt.TileEntityConveyorBelt;
import ip.industrialProcessing.utils.IPMath;

import java.util.Iterator;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.omg.PortableInterceptor.DISCARDING;

public class ModelConveyorBelt extends ModelConnected {

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

	// back connector
	ModelRenderer ConnectorSupport3;
	ModelRenderer ConnectorSupport4;
	ModelRenderer ConnectorSupport2;
	ModelRenderer ConnectorSupport1;
	ModelRenderer Connector;
	ModelRenderer ConnectorSide2;
	ModelRenderer ConnectorSide3;
	ModelRenderer ConnectorSide1;

	// top connector
	ModelRenderer ConnectorTopTube2;
	ModelRenderer ConnectorTop;
	ModelRenderer ConnectorTopSide2;
	ModelRenderer ConnectorTopSide4;
	ModelRenderer ConnectorTopSide1;
	ModelRenderer ConnectorTopSide3;

	// front connector
	ModelRenderer ConnectorFront;
	ModelRenderer ConnectorFrontSide1;
	ModelRenderer ConnectorFrontSide3;
	ModelRenderer ConnectorFrontSide2;
	ModelRenderer ConnectorFrontSide5;
	ModelRenderer ConnectorFrontSide6;
	ModelRenderer ConnectorFrontSide4;

	// bottom connector
	ModelRenderer ConnectorBottomCenter;
	ModelRenderer ConnectorBottom;
	ModelRenderer ConnectorBotomEdge1;
	ModelRenderer ConnectorBotomEdge4;
	ModelRenderer ConnectorBotomEdge2;
	ModelRenderer ConnectorBotomEdge3;
	ModelRenderer ConnectorBotomSupport3;
	ModelRenderer ConnectorBotomSupport4;
	ModelRenderer ConnectorBotomSupport2;
	ModelRenderer ConnectorBotomSupport1;

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
	private SlopeCombiner slopeCombiner;

	public ModelConveyorBelt() {
		textureWidth = 64;
		textureHeight = 32;

		InputLeftElev = new ModelRenderer(this, 0, 24);
		InputLeftElev.addBox(-4F, -3F, 0F, 8, 3, 1);
		InputLeftElev.setRotationPoint(6F, 24F, 0F);
		InputLeftElev.setTextureSize(64, 32);
		InputLeftElev.mirror = true;
		setRotation(InputLeftElev, 1.047198F, 1.570796F, 0F);
		InputRight = new ModelRenderer(this, 0, 21);
		InputRight.addBox(-4F, -8F, 0F, 8, 2, 1);
		InputRight.setRotationPoint(0F, 24F, 0F);
		InputRight.setTextureSize(64, 32);
		InputRight.mirror = true;
		setRotation(InputRight, 1.570796F, 1.570796F, 0F);
		InputRightElev = new ModelRenderer(this, 0, 17);
		InputRightElev.addBox(-4F, -3F, 0F, 8, 3, 1);
		InputRightElev.setRotationPoint(-6F, 24F, 0F);
		InputRightElev.setTextureSize(64, 32);
		InputRightElev.mirror = true;
		setRotation(InputRightElev, 1.047198F, -1.570796F, 0F);
		InputLeft = new ModelRenderer(this, 0, 28);
		InputLeft.addBox(-4F, -8F, 0F, 8, 2, 1);
		InputLeft.setRotationPoint(0F, 24F, 0F);
		InputLeft.setTextureSize(64, 32);
		InputLeft.mirror = true;
		setRotation(InputLeft, 1.570796F, -1.570796F, 0F);

		ForwardBottom = new ModelRenderer(this, 0, 0);
		ForwardBottom.addBox(-4F, 0F, 0F, 8, 16, 1);
		ForwardBottom.setRotationPoint(0F, 19F + 8F, -8F);
		ForwardBottom.setTextureSize(64, 32);
		ForwardBottom.mirror = true;
		setRotation(ForwardBottom, 1.570796F, 0F, 0F);
		Support9Front = new ModelRenderer(this, 60, 26);
		Support9Front.addBox(0F, 0F, 0F, 1, 5, 1);
		Support9Front.setRotationPoint(2F, 24F + 8F, -8F);
		Support9Front.setTextureSize(64, 32);
		Support9Front.mirror = true;
		setRotation(Support9Front, 1.570796F, 0F, 0F);
		Forward = new ModelRenderer(this, 0, 0);
		Forward.addBox(-4F, 0F, 0F, 8, 16, 1);
		Forward.setRotationPoint(0F, 16F + 8F, -8F);
		Forward.setTextureSize(64, 32);
		Forward.mirror = true;
		setRotation(Forward, 1.570796F, 0F, 0F);
		ForwardBody = new ModelRenderer(this, 48, 14);
		ForwardBody.addBox(0F, 0F, 0F, 6, 16, 2);
		ForwardBody.setRotationPoint(-3F, 16F + 8F, 8F);
		ForwardBody.setTextureSize(64, 32);
		ForwardBody.mirror = true;
		setRotation(ForwardBody, -1.570796F, 0F, 0F);
		Support6Front = new ModelRenderer(this, 60, 18);
		Support6Front.addBox(0F, 0F, 0F, 1, 7, 1);
		Support6Front.setRotationPoint(3F, 23F + 8F, -8F);
		Support6Front.setTextureSize(64, 32);
		Support6Front.mirror = true;
		setRotation(Support6Front, -2.356194F, 3.141593F, 0F);
		Support10Front = new ModelRenderer(this, 60, 26);
		Support10Front.addBox(0F, 0F, 0F, 1, 5, 1);
		Support10Front.setRotationPoint(-3F, 24F + 8F, -8F);
		Support10Front.setTextureSize(64, 32);
		Support10Front.mirror = true;
		setRotation(Support10Front, 1.570796F, 0F, 0F);
		Support5Front = new ModelRenderer(this, 60, 18);
		Support5Front.addBox(0F, 0F, 0F, 1, 7, 1);
		Support5Front.setRotationPoint(-2F, 23F + 8F, -8F);
		Support5Front.setTextureSize(64, 32);
		Support5Front.mirror = true;
		setRotation(Support5Front, -2.356194F, 3.141593F, 0F);
		Support15 = new ModelRenderer(this, 60, 26);
		Support15.addBox(0F, 0F, 0F, 1, 4, 1);
		Support15.setRotationPoint(2F, 23F + 8F, 2F);
		Support15.setTextureSize(64, 32);
		Support15.mirror = true;
		setRotation(Support15, -1.570796F, 0F, 0F);
		Support11Back = new ModelRenderer(this, 60, 26);
		Support11Back.addBox(0F, 0F, 0F, 1, 5, 1);
		Support11Back.setRotationPoint(-3F, 23F + 8F, 8F);
		Support11Back.setTextureSize(64, 32);
		Support11Back.mirror = true;
		setRotation(Support11Back, -1.570796F, 0F, 0F);
		Support3 = new ModelRenderer(this, 60, 18);
		Support3.addBox(0F, 0F, 0F, 1, 5, 1);
		Support3.setRotationPoint(-3F, 24F + 8F, 3F);
		Support3.setTextureSize(64, 32);
		Support3.mirror = true;
		setRotation(Support3, 3.141593F, 0F, 0F);
		Support8Back = new ModelRenderer(this, 60, 18);
		Support8Back.addBox(0F, 0F, 0F, 1, 7, 1);
		Support8Back.setRotationPoint(-3F, 23F + 8F, 8F);
		Support8Back.setTextureSize(64, 32);
		Support8Back.mirror = true;
		setRotation(Support8Back, -2.356194F, 0F, 0F);
		Support7Back = new ModelRenderer(this, 60, 18);
		Support7Back.addBox(0F, 0F, 0F, 1, 7, 1);
		Support7Back.setRotationPoint(2F, 23F + 8F, 8F);
		Support7Back.setTextureSize(64, 32);
		Support7Back.mirror = true;
		setRotation(Support7Back, -2.356194F, 0F, 0F);
		Support2 = new ModelRenderer(this, 60, 18);
		Support2.addBox(0F, 0F, 0F, 1, 5, 1);
		Support2.setRotationPoint(2F, 24F + 8F, 3F);
		Support2.setTextureSize(64, 32);
		Support2.mirror = true;
		setRotation(Support2, 3.141593F, 0F, 0F);
		Support1 = new ModelRenderer(this, 60, 18);
		Support1.addBox(0F, 0F, 0F, 1, 5, 1);
		Support1.setRotationPoint(2F, 24F + 8F, -2F);
		Support1.setTextureSize(64, 32);
		Support1.mirror = true;
		setRotation(Support1, 3.141593F, 0F, 0F);
		Support4 = new ModelRenderer(this, 60, 18);
		Support4.addBox(0F, 0F, 0F, 1, 5, 1);
		Support4.setRotationPoint(-3F, 24F + 8F, -2F);
		Support4.setTextureSize(64, 32);
		Support4.mirror = true;
		setRotation(Support4, 3.141593F, 0F, 0F);
		Support12Back = new ModelRenderer(this, 60, 26);
		Support12Back.addBox(0F, 0F, 0F, 1, 5, 1);
		Support12Back.setRotationPoint(2F, 23F + 8F, 8F);
		Support12Back.setTextureSize(64, 32);
		Support12Back.mirror = true;
		setRotation(Support12Back, -1.570796F, 0F, 0F);
		Support14 = new ModelRenderer(this, 60, 26);
		Support14.addBox(0F, 0F, 0F, 1, 4, 1);
		Support14.setRotationPoint(2F, 23F + 8F, -2F);
		Support14.setTextureSize(64, 32);
		Support14.mirror = true;
		setRotation(Support14, -1.570796F, 1.570796F, 0F);
		Support13 = new ModelRenderer(this, 60, 26);
		Support13.addBox(0F, 0F, 0F, 1, 4, 1);
		Support13.setRotationPoint(2F, 23F + 8F, 3F);
		Support13.setTextureSize(64, 32);
		Support13.mirror = true;
		setRotation(Support13, -1.570796F, 1.570796F, 0F);
		Support12 = new ModelRenderer(this, 60, 26);
		Support12.addBox(0F, 0F, 0F, 1, 4, 1);
		Support12.setRotationPoint(-3F, 23F + 8F, 2F);
		Support12.setTextureSize(64, 32);
		Support12.mirror = true;
		setRotation(Support12, -1.570796F, 0F, 0F);

		ConnectorSupport3 = new ModelRenderer(this, 18, 0);
		ConnectorSupport3.addBox(-5F, 0F, -5F, 1, 8, 1);
		ConnectorSupport3.setRotationPoint(0F, 16F, 0F);
		ConnectorSupport3.setTextureSize(64, 32);
		ConnectorSupport3.mirror = true;
		setRotation(ConnectorSupport3, 0F, 0F, 0F);
		ConnectorSupport4 = new ModelRenderer(this, 18, 0);
		ConnectorSupport4.addBox(4F, 0F, -5F, 1, 8, 1);
		ConnectorSupport4.setRotationPoint(0F, 16F, 0F);
		ConnectorSupport4.setTextureSize(64, 32);
		ConnectorSupport4.mirror = true;
		setRotation(ConnectorSupport4, 0F, 0F, 0F);
		ConnectorSupport2 = new ModelRenderer(this, 18, 0);
		ConnectorSupport2.addBox(-5F, 0F, -8F, 1, 8, 1);
		ConnectorSupport2.setRotationPoint(0F, 16F, 0F);
		ConnectorSupport2.setTextureSize(64, 32);
		ConnectorSupport2.mirror = true;
		setRotation(ConnectorSupport2, 0F, 0F, 0F);
		ConnectorSupport1 = new ModelRenderer(this, 18, 0);
		ConnectorSupport1.addBox(4F, 0F, -8F, 1, 8, 1);
		ConnectorSupport1.setRotationPoint(0F, 16F, 0F);
		ConnectorSupport1.setTextureSize(64, 32);
		ConnectorSupport1.mirror = true;
		setRotation(ConnectorSupport1, 0F, 0F, 0F);
		Connector = new ModelRenderer(this, 18, 3);
		Connector.addBox(-3F, -3F, 0F, 6, 6, 6);
		Connector.setRotationPoint(0F, 16F, -8F);
		Connector.setTextureSize(64, 32);
		Connector.mirror = true;
		setRotation(Connector, 0F, 0F, 0F);
		ConnectorSide2 = new ModelRenderer(this, 18, 15);
		ConnectorSide2.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorSide2.setRotationPoint(-4F, 14F, -2F);
		ConnectorSide2.setTextureSize(64, 32);
		ConnectorSide2.mirror = true;
		setRotation(ConnectorSide2, 0F, 1.570796F, 0F);
		ConnectorSide3 = new ModelRenderer(this, 18, 20);
		ConnectorSide3.addBox(0F, 0F, 0F, 8, 4, 1);
		ConnectorSide3.setRotationPoint(-4F, 14F, -2F);
		ConnectorSide3.setTextureSize(64, 32);
		ConnectorSide3.mirror = true;
		setRotation(ConnectorSide3, 0F, 0F, 0F);
		ConnectorSide1 = new ModelRenderer(this, 18, 15);
		ConnectorSide1.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorSide1.setRotationPoint(3F, 14F, -2F);
		ConnectorSide1.setTextureSize(64, 32);
		ConnectorSide1.mirror = true;
		setRotation(ConnectorSide1, 0F, 1.570796F, 0F);

		ConnectorTopTube2 = new ModelRenderer(this, 18, 25);
		ConnectorTopTube2.addBox(-2F, 0F, -2F, 4, 3, 4);
		ConnectorTopTube2.setRotationPoint(0F, 8F, 0F);
		ConnectorTopTube2.setTextureSize(64, 32);
		ConnectorTopTube2.mirror = true;
		setRotation(ConnectorTopTube2, 0F, 0F, 0F);
		ConnectorTop = new ModelRenderer(this, 18, 3);
		ConnectorTop.addBox(-3F, -3F, -3F, 6, 6, 6);
		ConnectorTop.setRotationPoint(0F, 14F, 0F);
		ConnectorTop.setTextureSize(64, 32);
		ConnectorTop.mirror = true;
		setRotation(ConnectorTop, 0F, 0F, 0F);
		ConnectorTopSide2 = new ModelRenderer(this, 18, 15);
		ConnectorTopSide2.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorTopSide2.setRotationPoint(-4F, 12F, 3F);
		ConnectorTopSide2.setTextureSize(64, 32);
		ConnectorTopSide2.mirror = true;
		setRotation(ConnectorTopSide2, 0F, 1.570796F, 0F);
		ConnectorTopSide4 = new ModelRenderer(this, 18, 20);
		ConnectorTopSide4.addBox(0F, 0F, 0F, 8, 4, 1);
		ConnectorTopSide4.setRotationPoint(-4F, 12F, -4F);
		ConnectorTopSide4.setTextureSize(64, 32);
		ConnectorTopSide4.mirror = true;
		setRotation(ConnectorTopSide4, 0F, 0F, 0F);
		ConnectorTopSide1 = new ModelRenderer(this, 18, 15);
		ConnectorTopSide1.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorTopSide1.setRotationPoint(3F, 12F, 3F);
		ConnectorTopSide1.setTextureSize(64, 32);
		ConnectorTopSide1.mirror = true;
		setRotation(ConnectorTopSide1, 0F, 1.570796F, 0F);
		ConnectorTopSide3 = new ModelRenderer(this, 18, 20);
		ConnectorTopSide3.addBox(0F, 0F, 0F, 8, 4, 1);
		ConnectorTopSide3.setRotationPoint(-4F, 12F, 3F);
		ConnectorTopSide3.setTextureSize(64, 32);
		ConnectorTopSide3.mirror = true;
		setRotation(ConnectorTopSide3, 0F, 0F, 0F);

		ConnectorFront = new ModelRenderer(this, 18, 3);
		ConnectorFront.addBox(-3F, -3F, -3F, 6, 6, 6);
		ConnectorFront.setRotationPoint(0F, 16F, 5F);
		ConnectorFront.setTextureSize(64, 32);
		ConnectorFront.mirror = true;
		setRotation(ConnectorFront, 0F, 0F, 0F);
		ConnectorFrontSide1 = new ModelRenderer(this, 18, 15);
		ConnectorFrontSide1.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorFrontSide1.setRotationPoint(-4F, 14F, 8F);
		ConnectorFrontSide1.setTextureSize(64, 32);
		ConnectorFrontSide1.mirror = true;
		setRotation(ConnectorFrontSide1, 0F, 1.570796F, 0F);
		ConnectorFrontSide3 = new ModelRenderer(this, 18, 20);
		ConnectorFrontSide3.addBox(0F, 0F, 0F, 8, 4, 1);
		ConnectorFrontSide3.setRotationPoint(-4F, 14F, 1F);
		ConnectorFrontSide3.setTextureSize(64, 32);
		ConnectorFrontSide3.mirror = true;
		setRotation(ConnectorFrontSide3, 0F, 0F, 0F);
		ConnectorFrontSide2 = new ModelRenderer(this, 18, 15);
		ConnectorFrontSide2.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorFrontSide2.setRotationPoint(3F, 14F, 8F);
		ConnectorFrontSide2.setTextureSize(64, 32);
		ConnectorFrontSide2.mirror = true;
		setRotation(ConnectorFrontSide2, 0F, 1.570796F, 0F);
		ConnectorFrontSide5 = new ModelRenderer(this, 36, 3);
		ConnectorFrontSide5.addBox(0F, 0F, 0F, 4, 5, 1);
		ConnectorFrontSide5.setRotationPoint(-4F, 18F, 8F);
		ConnectorFrontSide5.setTextureSize(64, 32);
		ConnectorFrontSide5.mirror = true;
		setRotation(ConnectorFrontSide5, 0F, 1.570796F, 0F);
		ConnectorFrontSide6 = new ModelRenderer(this, 34, 27);
		ConnectorFrontSide6.addBox(0F, 0F, 0F, 6, 4, 1);
		ConnectorFrontSide6.setRotationPoint(3F, 19F, 8F);
		ConnectorFrontSide6.setTextureSize(64, 32);
		ConnectorFrontSide6.mirror = true;
		setRotation(ConnectorFrontSide6, 0F, 3.141593F, 0F);
		ConnectorFrontSide4 = new ModelRenderer(this, 36, 3);
		ConnectorFrontSide4.addBox(0F, 0F, 0F, 4, 5, 1);
		ConnectorFrontSide4.setRotationPoint(3F, 18F, 8F);
		ConnectorFrontSide4.setTextureSize(64, 32);
		ConnectorFrontSide4.mirror = true;
		setRotation(ConnectorFrontSide4, 0F, 1.570796F, 0F);

		ConnectorBottomCenter = new ModelRenderer(this, 18, 3);
		ConnectorBottomCenter.addBox(-3F, -6F, -3F, 6, 3, 6);
		ConnectorBottomCenter.setRotationPoint(0F, 21F, 0F);
		ConnectorBottomCenter.setTextureSize(64, 32);
		ConnectorBottomCenter.mirror = true;
		setRotation(ConnectorBottomCenter, 0F, 0F, 0F);
		ConnectorBottom = new ModelRenderer(this, 18, 3);
		ConnectorBottom.addBox(-3F, -3F, -3F, 6, 1, 6);
		ConnectorBottom.setRotationPoint(0F, 20.8F, 0F);
		ConnectorBottom.setTextureSize(64, 32);
		ConnectorBottom.mirror = true;
		setRotation(ConnectorBottom, 0F, 0F, 3.141593F);
		ConnectorBotomEdge1 = new ModelRenderer(this, 18, 20);
		ConnectorBotomEdge1.addBox(-4F, 0F, 0F, 8, 1, 1);
		ConnectorBotomEdge1.setRotationPoint(-3F, 16F, 0F);
		ConnectorBotomEdge1.setTextureSize(64, 32);
		ConnectorBotomEdge1.mirror = true;
		setRotation(ConnectorBotomEdge1, 0F, -1.570796F, 0F);
		ConnectorBotomEdge4 = new ModelRenderer(this, 18, 15);
		ConnectorBotomEdge4.addBox(-3F, 0F, 0F, 6, 1, 1);
		ConnectorBotomEdge4.setRotationPoint(0F, 16F, 3F);
		ConnectorBotomEdge4.setTextureSize(64, 32);
		ConnectorBotomEdge4.mirror = true;
		setRotation(ConnectorBotomEdge4, 0F, 0F, 0F);
		ConnectorBotomEdge2 = new ModelRenderer(this, 18, 15);
		ConnectorBotomEdge2.addBox(-3F, 0F, 0F, 6, 1, 1);
		ConnectorBotomEdge2.setRotationPoint(0F, 16F, -4F);
		ConnectorBotomEdge2.setTextureSize(64, 32);
		ConnectorBotomEdge2.mirror = true;
		setRotation(ConnectorBotomEdge2, 0F, 0F, 0F);
		ConnectorBotomEdge3 = new ModelRenderer(this, 18, 20);
		ConnectorBotomEdge3.addBox(-4F, 0F, 0F, 8, 1, 1);
		ConnectorBotomEdge3.setRotationPoint(3F, 16F, 0F);
		ConnectorBotomEdge3.setTextureSize(64, 32);
		ConnectorBotomEdge3.mirror = true;
		setRotation(ConnectorBotomEdge3, 0F, 1.570796F, 0F);
		ConnectorBotomSupport3 = new ModelRenderer(this, 40, 15);
		ConnectorBotomSupport3.addBox(-0.5F, 0.5F, -0.5F, 1, 7, 1);
		ConnectorBotomSupport3.setRotationPoint(-4F, 16F, -4F);
		ConnectorBotomSupport3.setTextureSize(64, 32);
		ConnectorBotomSupport3.mirror = true;
		setRotation(ConnectorBotomSupport3, 0F, 0F, 0F);
		ConnectorBotomSupport4 = new ModelRenderer(this, 40, 15);
		ConnectorBotomSupport4.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
		ConnectorBotomSupport4.setRotationPoint(4F, 16.5F, -4F);
		ConnectorBotomSupport4.setTextureSize(64, 32);
		ConnectorBotomSupport4.mirror = true;
		setRotation(ConnectorBotomSupport4, 0F, 0F, 0F);
		ConnectorBotomSupport2 = new ModelRenderer(this, 40, 15);
		ConnectorBotomSupport2.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
		ConnectorBotomSupport2.setRotationPoint(-4F, 16.5F, 4F);
		ConnectorBotomSupport2.setTextureSize(64, 32);
		ConnectorBotomSupport2.mirror = true;
		setRotation(ConnectorBotomSupport2, 0F, 0F, 0F);
		ConnectorBotomSupport1 = new ModelRenderer(this, 40, 15);
		ConnectorBotomSupport1.addBox(-0.5F, 0F, -0.5F, 1, 7, 1);
		ConnectorBotomSupport1.setRotationPoint(4F, 16.5F, 4F);
		ConnectorBotomSupport1.setTextureSize(64, 32);
		ConnectorBotomSupport1.mirror = true;
		setRotation(ConnectorBotomSupport1, 0F, 0F, 0F);

		ForwardCornerOutBody = new ModelRenderer(this, 48, 14);
		ForwardCornerOutBody.addBox(-3F, 3F, 0F, 6, 5, 2);
		ForwardCornerOutBody.setRotationPoint(0F, 18F + 8f, 0F);
		ForwardCornerOutBody.setTextureSize(64, 32);
		ForwardCornerOutBody.mirror = true;
		setRotation(ForwardCornerOutBody, 1.570796F, 0F, 0F);
		ForwardCornerOutBottom = new ModelRenderer(this, 46, 0);
		ForwardCornerOutBottom.addBox(-4F, 4F, 0F, 8, 4, 1);
		ForwardCornerOutBottom.setRotationPoint(0F, 19F + 8f, 0F);
		ForwardCornerOutBottom.setTextureSize(64, 32);
		ForwardCornerOutBottom.mirror = true;
		setRotation(ForwardCornerOutBottom, 1.570796F, 0F, 0F);
		ForwardCornerOut = new ModelRenderer(this, 46, 0);
		ForwardCornerOut.addBox(-4F, 4F, 0F, 8, 4, 1);
		ForwardCornerOut.setRotationPoint(0F, 16F + 8f, 0F);
		ForwardCornerOut.setTextureSize(64, 32);
		ForwardCornerOut.mirror = true;
		setRotation(ForwardCornerOut, 1.570796F, 0F, 0F);

		ForwardCornerCenterBottom = new ModelRenderer(this, 46, 5);
		ForwardCornerCenterBottom.addBox(-4F, -4F, 0F, 8, 8, 1);
		ForwardCornerCenterBottom.setRotationPoint(0F, 19F + 8F, 0F);
		ForwardCornerCenterBottom.setTextureSize(64, 32);
		ForwardCornerCenterBottom.mirror = true;
		setRotation(ForwardCornerCenterBottom, 1.570796F, 0F, 0F);
		ForwardCornerCenter = new ModelRenderer(this, 46, 5);
		ForwardCornerCenter.addBox(-4F, -4F, 0F, 8, 8, 1);
		ForwardCornerCenter.setRotationPoint(0F, 16F + 8F, 0F);
		ForwardCornerCenter.setTextureSize(64, 32);
		ForwardCornerCenter.mirror = true;
		setRotation(ForwardCornerCenter, 1.570796F, 0F, 0F);
		ForwardCornerCenterBody = new ModelRenderer(this, 48, 14);
		ForwardCornerCenterBody.addBox(0F, 5F, 0F, 6, 6, 2);
		ForwardCornerCenterBody.setRotationPoint(-3F, 16F + 8F, 8F);
		ForwardCornerCenterBody.setTextureSize(64, 32);
		ForwardCornerCenterBody.mirror = true;
		setRotation(ForwardCornerCenterBody, -1.570796F, 0F, 0F);
		ForwardCornerIn3 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn3.addBox(-4F, -8F, 0F, 8, 4, 1);
		ForwardCornerIn3.setRotationPoint(0F, 16F + 8F, 0F);
		ForwardCornerIn3.setTextureSize(64, 32);
		ForwardCornerIn3.mirror = true;
		setRotation(ForwardCornerIn3, 1.570796F, 0F, 0F);
		ForwardCornerIn3Bottom = new ModelRenderer(this, 0, 0);
		ForwardCornerIn3Bottom.addBox(-4F, -8F, 0F, 8, 4, 1);
		ForwardCornerIn3Bottom.setRotationPoint(0F, 19F + 8F, 0F);
		ForwardCornerIn3Bottom.setTextureSize(64, 32);
		ForwardCornerIn3Bottom.mirror = true;
		setRotation(ForwardCornerIn3Bottom, 1.570796F, 0F, 0F);
		ForwardCornerIn3Body = new ModelRenderer(this, 48, 14);
		ForwardCornerIn3Body.addBox(-3F, -8F, 0F, 6, 5, 2);
		ForwardCornerIn3Body.setRotationPoint(0F, 18F + 8F, 0F);
		ForwardCornerIn3Body.setTextureSize(64, 32);
		ForwardCornerIn3Body.mirror = true;
		setRotation(ForwardCornerIn3Body, 1.570796F, 0F, 0F);
		ForwardCornerIn2 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn2.addBox(-4F, 0F, 0F, 8, 4, 1);
		ForwardCornerIn2.setRotationPoint(8F, 24F, 0F);
		ForwardCornerIn2.setTextureSize(64, 32);
		ForwardCornerIn2.mirror = true;
		setRotation(ForwardCornerIn2, 1.570796F, -1.570796F, 0F);
		ForwardCornerIn1 = new ModelRenderer(this, 0, 0);
		ForwardCornerIn1.addBox(-4F, 0F, 0F, 8, 4, 1);
		ForwardCornerIn1.setRotationPoint(-8F, 24F, 0F);
		ForwardCornerIn1.setTextureSize(64, 32);
		ForwardCornerIn1.mirror = true;
		setRotation(ForwardCornerIn1, 1.570796F, 1.570796F, 0F);

		Support16Left = new ModelRenderer(this, 60, 26);
		Support16Left.addBox(0F, 0F, 0F, 1, 5, 1);
		Support16Left.setRotationPoint(3F, 24F + 8F, -2F);
		Support16Left.setTextureSize(64, 32);
		Support16Left.mirror = true;
		setRotation(Support16Left, 1.570796F, 1.570796F, 0F);
		Support17Left = new ModelRenderer(this, 60, 26);
		Support17Left.addBox(0F, 0F, 0F, 1, 5, 1);
		Support17Left.setRotationPoint(3F, 24F + 8F, 3F);
		Support17Left.setTextureSize(64, 32);
		Support17Left.mirror = true;
		setRotation(Support17Left, 1.570796F, 1.570796F, 0F);
		Support20Left = new ModelRenderer(this, 60, 18);
		Support20Left.addBox(0F, 0F, 0F, 1, 7, 1);
		Support20Left.setRotationPoint(8F, 23F + 8F, -2F);
		Support20Left.setTextureSize(64, 32);
		Support20Left.mirror = true;
		setRotation(Support20Left, -2.356194F, 1.570796F, 0F);
		Support21Left = new ModelRenderer(this, 60, 18);
		Support21Left.addBox(0F, 0F, 0F, 1, 7, 1);
		Support21Left.setRotationPoint(8F, 23F + 8F, 3F);
		Support21Left.setTextureSize(64, 32);
		Support21Left.mirror = true;
		setRotation(Support21Left, -2.356194F, 1.570796F, 0F);
		Support23Right = new ModelRenderer(this, 60, 18);
		Support23Right.addBox(0F, 0F, 0F, 1, 7, 1);
		Support23Right.setRotationPoint(-8F, 23F + 8F, -3F);
		Support23Right.setTextureSize(64, 32);
		Support23Right.mirror = true;
		setRotation(Support23Right, -2.356194F, -1.570796F, 0F);
		Support18Right = new ModelRenderer(this, 60, 26);
		Support18Right.addBox(0F, 0F, 0F, 1, 5, 1);
		Support18Right.setRotationPoint(-3F, 24F + 8F, 2F);
		Support18Right.setTextureSize(64, 32);
		Support18Right.mirror = true;
		setRotation(Support18Right, 1.570796F, -1.570796F, 0F);
		Support22Right = new ModelRenderer(this, 60, 18);
		Support22Right.addBox(0F, 0F, 0F, 1, 7, 1);
		Support22Right.setRotationPoint(-8F, 23F + 8F, 2F);
		Support22Right.setTextureSize(64, 32);
		Support22Right.mirror = true;
		setRotation(Support22Right, -2.356194F, -1.570796F, 0F);
		Support19Right = new ModelRenderer(this, 60, 26);
		Support19Right.addBox(0F, 0F, 0F, 1, 5, 1);
		Support19Right.setRotationPoint(-3F, 24F + 8F, -3F);
		Support19Right.setTextureSize(64, 32);
		Support19Right.mirror = true;
		setRotation(Support19Right, 1.570796F, -1.570796F, 0F);

		bend1 = new BendRenderer(8, -8, (float) -Math.PI / 2, false);
		bend2 = new BendRenderer(-8, -8, (float) Math.PI, true);

		slopeCombiner = new SlopeCombiner();
	}

	@Override
	public void renderModelConnected(TileEntity tl, float f5, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {

		GL11.glPushMatrix();
		GL11.glTranslatef(0, -0.5f, 0);
		if (tl != null) {

			if (tl instanceof TileEntityConveyorBelt) {

				TileEntityConveyorBelt belt = (TileEntityConveyorBelt) tl;

				SlopeState back = belt.getSlope(LocalDirection.FRONT);
				SlopeState front = belt.getSlope(LocalDirection.BACK);
				CornerState cornerState = null;

				ForgeDirection forward = BlockMachine.getForwardFromEntity(tl);
				if (forward != null) {
					if (back == SlopeState.FLAT && front == SlopeState.FLAT) {
						switch (forward) {
						case NORTH:
							cornerState = drawConnections(tl, east, north, west, south, up, down, f5);
							break;
						case EAST:
							cornerState = drawConnections(tl, north, west, south, east, up, down, f5);
							break;
						case SOUTH:
							cornerState = drawConnections(tl, west, south, east, north, up, down, f5);
							break;
						case WEST:
							cornerState = drawConnections(tl, south, east, north, west, up, down, f5);
							break;
						default:
							cornerState = new CornerState();
							break;
						}

						GL11.glTranslatef(0, 0.5f, 0);
						if (up == ConnectionState.PLUGGED) {
							ConnectorTopTube2.render(f5);
							ConnectorTop.render(f5);
							ConnectorTopSide2.render(f5);
							ConnectorTopSide4.render(f5);
							ConnectorTopSide1.render(f5);
							ConnectorTopSide3.render(f5);
						}
						if (down == ConnectionState.PLUGGED) {
							ConnectorBottomCenter.render(f5);
							ConnectorBottom.render(f5);
							ConnectorBotomEdge1.render(f5);
							ConnectorBotomEdge4.render(f5);
							ConnectorBotomEdge2.render(f5);
							ConnectorBotomEdge3.render(f5);
							ConnectorBotomSupport3.render(f5);
							ConnectorBotomSupport4.render(f5);
							ConnectorBotomSupport2.render(f5);
							ConnectorBotomSupport1.render(f5);
						}
						GL11.glTranslatef(0, -0.5f, 0);
					} else {
						switch (forward) {
						case NORTH:
							drawSpline(tl, front, back, south, north, f5);
							break;
						case EAST:
							drawSpline(tl, front, back, east, west, f5);
							break;
						case SOUTH:
							drawSpline(tl, front, back, north, south, f5);
							break;
						case WEST:
							drawSpline(tl, front, back, west, east, f5);
							break;
						default:
							break;
						}
					}
				}
				RenderItem itemrenderer = (RenderItem) RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
				for (Iterator<MovingItemStack> iterator = belt.iterateStacks(); iterator.hasNext();) {
					MovingItemStack stack = iterator.next();
					renderStack(stack, tl, itemrenderer, f5, cornerState, front, back);
				}
			}
		}
		GL11.glPopMatrix();
	}

	private void drawSpline(TileEntity tl, SlopeState frontSlope, SlopeState backSlope, ConnectionState frontState, ConnectionState backState, float f) {
		SlopeRenderer renderer = slopeCombiner.getRenderer(frontSlope, frontState != ConnectionState.DISCONNECTED, backSlope, backState != ConnectionState.DISCONNECTED);
		renderer.render(f);
	}

	private void renderStack(MovingItemStack stack, TileEntity tl, RenderItem itemrenderer, float scale, CornerState state, SlopeState frontSlope, SlopeState backSlope) {
		ItemStack items = stack.stack;
		if (state == null)
			state = new CornerState();

		EntityItem entity = new EntityItem(tl.worldObj, tl.xCoord, tl.yCoord, tl.zCoord, items);
		entity.hoverStart = 0;// 1 + (float) Math.cos(stack.progress * Math.PI *
								// 2);

		float x = 0;
		float y = 0;
		float z = 0;
		float travelProgress = -(stack.progress - 0.5f);
		float angle = 0;
		float diveAngle = 0;
		if (frontSlope != SlopeState.FLAT || backSlope != SlopeState.FLAT) {
			x = 0;

			float frontLevel = (frontSlope.ordinal() - 1) / 2f;
			float backLevel = (backSlope.ordinal() - 1) / 2f;

			float yStart = -backLevel;
			float yEnd = -frontLevel;

			float angleStart = backLevel * 90;
			float angleEnd = -frontLevel * 90;

			float yMid = (yStart + yEnd) / 2f;
			if (frontSlope == backSlope || frontSlope == SlopeState.FLAT || backSlope == SlopeState.FLAT)
				yMid = 0;

			Vector2f start = new Vector2f(-0.5f, yStart);
			Vector2f mid = new Vector2f(0, yMid);
			Vector2f end = new Vector2f(0.5f, yEnd);

			diveAngle = (((angleEnd - angleStart) * stack.progress + angleStart));
			Vector2f yz = IPMath.bezier(start, mid, end, stack.progress);
			y = yz.y;
			z = yz.x;
		} else {
			if (stack.progress < 0.5f) {
				if (stack.source != null) {
					switch (stack.source) {
					case LEFT:
						if (state.rightBend) {
							float angleProgress = (float) (stack.progress * Math.PI / 2);
							x = 0.5f - (float) Math.sin(angleProgress) * 0.5f;
							z = 0.5f - (float) Math.cos(angleProgress) * 0.5f;

							angle = -90 + angleProgress / (float) Math.PI * 180;
						} else {
							x = travelProgress;
							y = 0;
							z = 0;
							angle = -90;
						}
						break;

					case RIGHT:
						if (state.leftBend) {
							float angleProgress = (float) (stack.progress * Math.PI / 2);
							x = -0.5f + (float) Math.sin(angleProgress) * 0.5f;
							z = 0.5f - (float) Math.cos(angleProgress) * 0.5f;

							angle = 90 - angleProgress / (float) Math.PI * 180;
						} else {
							x = -travelProgress;
							y = 0;
							z = 0;
							angle = 90;
						}
						break;
					case FRONT:
						x = 0;
						y = 0;
						z = -travelProgress;
						break;
					case UP:
						x = 0;
						y = -travelProgress;
						z = 0;
						break;
					case DOWN:
						x = 0;
						y = travelProgress;
						z = 0;
						break;
					default:
						break;
					}
				}
			} else {
				switch (stack.destination) {
				case UP:
					x = 0;
					y = travelProgress;
					z = 0;
					break;
				case DOWN:
					x = 0;
					y = -travelProgress;
					z = 0;
					break;
				case BACK:
					if (stack.source == LocalDirection.LEFT && state.rightBend) {
						float angleProgress = (float) (stack.progress * Math.PI / 2);
						x = 0.5f - (float) Math.sin(angleProgress) * 0.5f;
						z = 0.5f - (float) Math.cos(angleProgress) * 0.5f;
						angle = -90 + angleProgress / (float) Math.PI * 180;

					} else if (stack.source == LocalDirection.RIGHT && state.leftBend) {
						float angleProgress = (float) (stack.progress * Math.PI / 2);
						x = -0.5f + (float) Math.sin(angleProgress) * 0.5f;
						z = 0.5f - (float) Math.cos(angleProgress) * 0.5f;

						angle = 90 - angleProgress / (float) Math.PI * 180;
					} else {
						x = 0;
						y = 0;
						z = -travelProgress;
						angle = 0;
					}
					break;
				default:
					break;
				}
			}
		}

		float worldAngle = 90;
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y + 1.4f, z);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(worldAngle, 0, 1, 0);
		GL11.glRotatef(-angle, 0, 1, 0);
		GL11.glRotatef(diveAngle, 0, 0, -1);
		itemrenderer.doRenderItem(entity, 0, 0, 0, 0, scale);
		GL11.glPopMatrix();

	}

	private CornerState drawConnections(TileEntity tl, ConnectionState right, ConnectionState back, ConnectionState left, ConnectionState front, ConnectionState top, ConnectionState bottom, float f5) {
		boolean turn = false;
		CornerState state = new CornerState();
		if (right != ConnectionState.DISCONNECTED && left == ConnectionState.DISCONNECTED && back == ConnectionState.DISCONNECTED) {
			if (top != ConnectionState.DISCONNECTED || bottom != ConnectionState.DISCONNECTED)
				drawCornerRight(tl, f5);
			else {
				drawTurnRight(tl, f5);
				state.rightBend = true;
			}
			turn = true;
		} else if (right == ConnectionState.DISCONNECTED && left != ConnectionState.DISCONNECTED && back == ConnectionState.DISCONNECTED) {
			if (top != ConnectionState.DISCONNECTED || bottom != ConnectionState.DISCONNECTED)
				drawCornerLeft(tl, f5);
			else {
				drawTurnLeft(tl, f5);
				state.leftBend = true;
			}
			turn = true;
		} else {

			if (back != ConnectionState.DISCONNECTED && front != ConnectionState.DISCONNECTED) {
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
			} else {
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
				if (back != ConnectionState.DISCONNECTED) {
					ForwardCornerIn3.render(f5);
					ForwardCornerIn3Body.render(f5);
					ForwardCornerIn3Bottom.render(f5);
					Support9Front.render(f5);
					Support6Front.render(f5);
					Support10Front.render(f5);
					Support5Front.render(f5);
				} else if (front != ConnectionState.DISCONNECTED) {
					ForwardCornerOutBody.render(f5);
					ForwardCornerOutBottom.render(f5);
					ForwardCornerOut.render(f5);
					Support11Back.render(f5);
					Support8Back.render(f5);
					Support7Back.render(f5);
					Support12Back.render(f5);
				}
			}

			if (left != ConnectionState.DISCONNECTED) {
				InputRight.render(f5);
				InputRightElev.render(f5);

				Support16Left.render(f5);
				Support17Left.render(f5);
				Support20Left.render(f5);
				Support21Left.render(f5); 
			}
			if (right != ConnectionState.DISCONNECTED) {
				InputLeft.render(f5);
				InputLeftElev.render(f5);
				
				Support23Right.render(f5);
				Support18Right.render(f5);
				Support22Right.render(f5);
				Support19Right.render(f5); 
			}
		}

		if (back == ConnectionState.PLUGGED) {
			ConnectorSupport3.render(f5);
			ConnectorSupport4.render(f5);
			ConnectorSupport2.render(f5);
			ConnectorSupport1.render(f5);
			Connector.render(f5);
			ConnectorSide2.render(f5);
			ConnectorSide3.render(f5);
			ConnectorSide1.render(f5);
		}

		if (left == ConnectionState.PLUGGED) {
			GL11.glPushMatrix();
			GL11.glRotatef(90, 0, 1, 0);
			// ConnectorSupport3.render(f5);
			// ConnectorSupport4.render(f5);
			ConnectorSupport2.render(f5);
			ConnectorSupport1.render(f5);
			Connector.render(f5);
			ConnectorSide2.render(f5);
			ConnectorSide3.render(f5);
			ConnectorSide1.render(f5);
			GL11.glPopMatrix();
		}

		if (right == ConnectionState.PLUGGED) {
			GL11.glPushMatrix();
			GL11.glRotatef(-90, 0, 1, 0);
			// ConnectorSupport3.render(f5);
			// ConnectorSupport4.render(f5);
			ConnectorSupport2.render(f5);
			ConnectorSupport1.render(f5);
			Connector.render(f5);
			ConnectorSide2.render(f5);
			ConnectorSide3.render(f5);
			ConnectorSide1.render(f5);
			GL11.glPopMatrix();
		}

		if (front == ConnectionState.PLUGGED) {
			ConnectorFront.render(f5);
			ConnectorFrontSide1.render(f5);
			ConnectorFrontSide3.render(f5);
			ConnectorFrontSide2.render(f5);
			if (!turn) {
				ConnectorFrontSide4.render(f5);
				ConnectorFrontSide5.render(f5);
			}
			ConnectorFrontSide6.render(f5);
		}

		return state;
	}

	private void drawCornerLeft(TileEntity tl, float f5) {
		ForwardCornerOut.render(f5);
		ForwardCornerCenter.render(f5);
		// ForwardCornerIn2.render(f5);
		ForwardCornerIn1.render(f5);
		Support23Right.render(f5);
		Support18Right.render(f5);
		Support22Right.render(f5);
		Support19Right.render(f5); 
		Support11Back.render(f5);
		Support8Back.render(f5);
		Support7Back.render(f5);
		Support12Back.render(f5);
	}

	private void drawCornerRight(TileEntity tl, float f5) {
		ForwardCornerOut.render(f5);
		ForwardCornerCenter.render(f5);
		ForwardCornerIn2.render(f5);
		// ForwardCornerIn1.render(f5);
		Support16Left.render(f5);
		Support17Left.render(f5);
		Support20Left.render(f5);
		Support21Left.render(f5); 
		Support11Back.render(f5);
		Support8Back.render(f5);
		Support7Back.render(f5);
		Support12Back.render(f5);
	}

	private void drawTurnLeft(TileEntity tl, float f) {
		this.bend1.render(f);
	}

	private void drawTurnRight(TileEntity tl, float f) {
		this.bend2.render(f);
	}
}
