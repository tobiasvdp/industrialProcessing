package mod.industrialProcessing.power;

@Deprecated
public class GeneratorProgressHandler implements IProgressBarHandler {

	private IGeneratorProgress generator;

	public GeneratorProgressHandler(IGeneratorProgress generator) {
		this.generator = generator;
	}

	@Override
	public int getValueCount() {
		return 2;
	}

	@Override
	public int getValue(int i) {
		switch (i) {
		case 0:
			return (int) (this.generator.getVoltage() * 100f);
		case 1:
			return (int) (this.generator.getLastAmps() * 100f);
		}
		return 0;
	}

	public static GeneratorProgress getInfo(ProgressBarHandlerInfo info) {
		int[] values = info.getValueStorage();
		GeneratorProgress progress = new GeneratorProgress();
		progress.voltage = values[0] / 100f;
		progress.amps = values[1] / 100f;
		return progress;
	}
}
