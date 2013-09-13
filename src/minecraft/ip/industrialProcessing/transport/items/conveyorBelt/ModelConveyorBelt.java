package ip.industrialProcessing.transport.items.conveyorBelt;

import ip.industrialProcessing.LocalDirection;
import ip.industrialProcessing.client.render.ConnectionState;
import ip.industrialProcessing.client.render.ModelConnected;
import ip.industrialProcessing.machines.BlockMachine;

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

public class ModelConveyorBelt extends ModelConnected {

	// belt
	ModelRenderer InputLeftElev;
	ModelRenderer InputRight;
	ModelRenderer InputRightElev;
	ModelRenderer InputLeft;
	ModelRenderer Forward;

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
	ModelRenderer ForwardCornerOut;
	ModelRenderer ForwardCornerCenter;
	ModelRenderer ForwardCornerIn2;
	ModelRenderer ForwardCornerIn1;

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
		Forward = new ModelRenderer(this, 0, 0);
		Forward.addBox(-4F, 0F, 0F, 8, 16, 1);
		Forward.setRotationPoint(0F, 24F, -8F);
		Forward.setTextureSize(64, 32);
		Forward.mirror = true;
		setRotation(Forward, 1.570796F, 0F, 0F);

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

		ForwardCornerOut = new ModelRenderer(this, 46, 0);
		ForwardCornerOut.addBox(-4F, 0F, 0F, 8, 4, 1);
		ForwardCornerOut.setRotationPoint(0F, 24F, 4F);
		ForwardCornerOut.setTextureSize(64, 32);
		ForwardCornerOut.mirror = true;
		setRotation(ForwardCornerOut, 1.570796F, 0F, 0F);
		ForwardCornerCenter = new ModelRenderer(this, 46, 5);
		ForwardCornerCenter.addBox(-4F, 0F, 0F, 8, 8, 1);
		ForwardCornerCenter.setRotationPoint(0F, 24F, -4F);
		ForwardCornerCenter.setTextureSize(64, 32);
		ForwardCornerCenter.mirror = true;
		setRotation(ForwardCornerCenter, 1.570796F, 0F, 0F);
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
	}

	@Override
	public void renderModelConnected(TileEntity tl, float f5, ConnectionState north, ConnectionState west, ConnectionState south, ConnectionState east, ConnectionState up, ConnectionState down) {

		if (tl != null) {
			ForgeDirection forward = BlockMachine.getForwardFromEntity(tl);
			CornerState cornerState = null;
			if (forward != null) {
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
			} else
				Forward.render(f5);

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
			if (tl instanceof TileEntityConveyorBelt) {
				RenderItem itemrenderer = (RenderItem) RenderManager.instance.getEntityClassRenderObject(EntityItem.class);
				TileEntityConveyorBelt belt = (TileEntityConveyorBelt) tl;

				for (Iterator<MovingItemStack> iterator = belt.iterateStacks(); iterator.hasNext();) {
					MovingItemStack stack = iterator.next();
					renderStack(stack, tl, itemrenderer, f5, cornerState);
				}
			}
		}
	}

	private void renderStack(MovingItemStack stack, TileEntity tl, RenderItem itemrenderer, float scale, CornerState state) {
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

		float worldAngle = 90;
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y + 1.4f, z);
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glRotatef(worldAngle - angle, 0, 1, 0);
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
			if (back == ConnectionState.DISCONNECTED) {
				ForwardCornerOut.render(f5);
				ForwardCornerCenter.render(f5);
			} else {
				Forward.render(f5);
			}
			if (left != ConnectionState.DISCONNECTED) {
				InputRight.render(f5);
				InputRightElev.render(f5);
			}
			if (right != ConnectionState.DISCONNECTED) {
				InputLeft.render(f5);
				InputLeftElev.render(f5);
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

	private void drawAngle(TileEntity tl, int xCorner, int yCorner, float f, float startAngle, boolean invert) {

		Tessellator tessellator = Tessellator.instance;
		float uMin = 10 / 64f;
		float uMax = 18 / 64f;
		float vMin = 1 / 32f;
		float vMax = 17 / 32f;

		float y = 23;

		int segments = 16;

		float vLen = (invert ? (vMin - vMax) : (vMax - vMin)) / segments;
		float vStart = (invert ? vMax : vMin);
		float segmentAngle = (float) Math.PI / (2 * segments);

		float bottomUv = -9 / 64f;

		float sideUMin = 0;
		float sideUMax = 1 / 32f;
		for (int i = 0; i < segments; i++) {
			float endAngle = startAngle + segmentAngle;
			float vEnd = vStart + vLen;

			float cosStart = (float) Math.cos(startAngle);
			float sinStart = (float) Math.sin(startAngle);

			float cosEnd = (float) Math.cos(endAngle);
			float sinEnd = (float) Math.sin(endAngle);

			float x1 = cosStart * 4 - xCorner;
			float x2 = cosStart * 12 - xCorner;

			float x3 = cosEnd * 4 - xCorner;
			float x4 = cosEnd * 12 - xCorner;

			float y1 = sinStart * 4 - yCorner;
			float y2 = sinStart * 12 - yCorner;

			float y3 = sinEnd * 4 - yCorner;
			float y4 = sinEnd * 12 - yCorner;
			/*
			 * x1 = x3 = -4 + i; x2 = x4 = 4 + i;
			 * 
			 * y1 = y3 = (float) i * 16f / segments -8 ; y2 = y4 = (float) (i +
			 * 1) * 16f / segments -8;
			 */

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, 2, 0);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (y1) * f, uMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (y2) * f, uMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (y4) * f, uMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (y3) * f, uMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal(0, -2, 0);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (y2) * f, uMin + bottomUv, vStart);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (y1) * f, uMax + bottomUv, vStart);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (y3) * f, uMax + bottomUv, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (y4) * f, uMin + bottomUv, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x2) * f, (y) * f, (y2) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x2) * f, (y + 1) * f, (y2) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x4) * f, (y + 1) * f, (y4) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x4) * f, (y) * f, (y4) * f, sideUMin, vEnd);
			tessellator.draw();

			tessellator.startDrawingQuads();
			tessellator.setNormal((cosStart + cosEnd) / 2, 0, (sinStart + sinEnd) / 2);
			tessellator.addVertexWithUV((x1) * f, (y + 1) * f, (y1) * f, sideUMin, vStart);
			tessellator.addVertexWithUV((x1) * f, (y) * f, (y1) * f, sideUMax, vStart);
			tessellator.addVertexWithUV((x3) * f, (y) * f, (y3) * f, sideUMax, vEnd);
			tessellator.addVertexWithUV((x3) * f, (y + 1) * f, (y3) * f, sideUMin, vEnd);
			tessellator.draw();

			vStart = vEnd;
			startAngle = endAngle;
		}
	}

	private void drawCornerLeft(TileEntity tl, float f5) {
		ForwardCornerOut.render(f5);
		ForwardCornerCenter.render(f5);
		// ForwardCornerIn2.render(f5);
		ForwardCornerIn1.render(f5);
	}

	private void drawCornerRight(TileEntity tl, float f5) {
		ForwardCornerOut.render(f5);
		ForwardCornerCenter.render(f5);
		ForwardCornerIn2.render(f5);
		// ForwardCornerIn1.render(f5);
	}

	private void drawTurnLeft(TileEntity tl, float f) {
		drawAngle(tl, 8, -8, f, (float) -Math.PI / 2, false);
	}

	private void drawTurnRight(TileEntity tl, float f) {
		drawAngle(tl, -8, -8, f, (float) Math.PI, true);
	}
}
