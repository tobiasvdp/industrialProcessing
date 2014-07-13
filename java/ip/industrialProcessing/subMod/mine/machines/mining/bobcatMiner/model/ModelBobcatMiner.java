package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;

import ip.industrialProcessing.api.rendering.wavefront.ObjMesh;
import ip.industrialProcessing.api.rendering.wavefront.ObjRotatedTranslator;
import ip.industrialProcessing.client.render.ModelEntity;
import ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.EntityBobcatMiner;

import javax.swing.Icon;

import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelBobcatMiner extends ModelEntity {
	
	ObjMesh cabine = new Cabine();
	ObjMesh glass = new Glass();
	ObjMesh hull = new Hull();
	ObjMesh inner = new Inner();
	ObjMesh leftWheel = new LeftWheel();
	ObjMesh rightWheel = new RightWheel();
	ObjMesh connectorPlate = new ConnectorPlate();
	ObjRotatedTranslator miner = new ObjRotatedTranslator(new Miner(),0,1);
	ObjMesh rod = new Rod();

	Icon blackIcon = new Icon() {

		@Override
		public float getMinV() {
			return 0.75f;
		}

		@Override
		public float getMinU() {
			return 0.25f;
		}

		@Override
		public float getMaxV() {
			return 1;
		}

		@Override
		public float getMaxU() {
			return 0.5f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	Icon glassIcon = new Icon() {

		@Override
		public float getMinV() {
			return 0.75f;
		}

		@Override
		public float getMinU() {
			return 0;
		}

		@Override
		public float getMaxV() {
			return 1;
		}

		@Override
		public float getMaxU() {
			return 0.25f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	
	Icon orangeIcon = new Icon() {

		@Override
		public float getMinV() {
			return 0.75f;
		}

		@Override
		public float getMinU() {
			return 0.5f;
		}

		@Override
		public float getMaxV() {
			return 1;
		}

		@Override
		public float getMaxU() {
			return 0.75f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	
	Icon ironIcon = new Icon() {
		@Override
		public float getMinV() {
			return 0.75f;
		}

		@Override
		public float getMinU() {
			return 0.75f;
		}

		@Override
		public float getMaxV() {
			return 1;
		}

		@Override
		public float getMaxU() {
			return 1f;
		}

		@Override
		public float getInterpolatedV(double d0) {
			return (float) d0;
		}

		@Override
		public float getInterpolatedU(double d0) {
			return (float) d0;
		}

		@Override
		public String getIconName() {
			return "Booh";
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	public ModelBobcatMiner() {
		miner.setTranslated(0, 0, +0.1f, -1.15f);
	}
	
	@Override
	public boolean renderWorld(Entity entity, double d0, double d1, double d2, float f, float f1) {		
		cabine.renderMesh(ironIcon);
		glass.renderMesh(glassIcon);
		hull.renderMesh(orangeIcon);
		inner.renderMesh(ironIcon);
		leftWheel.renderMesh(blackIcon);
		rightWheel.renderMesh(blackIcon);
		connectorPlate.renderMesh(ironIcon);
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, -0.1f, +1.15f);
		GL11.glTranslatef(0f, ((EntityBobcatMiner)entity).rotationRod /(float)40, 0f);
		//GL11.glRotatef(((EntityBobcatMiner)entity).rotationAngle, 0.1f, 0, 0);
		miner.getRotated(0).renderMesh(ironIcon);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(((EntityBobcatMiner)entity).rotationRod, -1f, 0, 0);
		rod.renderMesh(ironIcon);
		GL11.glPopMatrix();
		return true;
	}

}
