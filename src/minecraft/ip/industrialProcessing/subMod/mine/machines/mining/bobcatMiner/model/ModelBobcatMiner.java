package ip.industrialProcessing.subMod.mine.machines.mining.bobcatMiner.model;

import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import ip.industrialProcessing.client.render.ModelEntity;

public class ModelBobcatMiner extends ModelEntity {

	Drill drill = new Drill();
	Hull hull = new Hull();
	LeftWheel leftWheel = new LeftWheel();
	RightWheel rightWheel = new RightWheel();
	Box box = new Box();
	Inner inner = new Inner();

	@Override
	public boolean renderWorld(Entity entity, double d0, double d1, double d2, float f, float f1) {
		Icon icon = new Icon() {

			@Override
			public int getOriginY() {
				return 0;
			}

			@Override
			public int getOriginX() {
				return 0;
			}

			@Override
			public float getMinV() {
				return 0;
			}

			@Override
			public float getMinU() {
				return 0;
			}

			@Override
			public float getMaxV() {
				return (float) 0.5;
			}

			@Override
			public float getMaxU() {
				return (float) 0.5;
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
		};
		Icon icon2 = new Icon() {
			@Override
			public int getOriginY() {
				return 32;
			}

			@Override
			public int getOriginX() {
				return 32;
			}

			@Override
			public float getMinV() {
				return 0;
			}

			@Override
			public float getMinU() {
				return 0;
			}

			@Override
			public float getMaxV() {
				return (float) 0.5;
			}

			@Override
			public float getMaxU() {
				return (float) 0.5;
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
		};
		drill.renderMesh(icon2);
		hull.renderMesh(icon);
		leftWheel.renderMesh(icon2);
		rightWheel.renderMesh(icon2);
		box.renderMesh(icon2);
		inner.renderMesh(icon2);
		return true;
	}

}
