package ip.industrialProcessing.machines.containers;

public class ProgressBarHandlerInfo {

	private IProgressBarHandler handler;
	private int handlerIndex;
	private int progressBarsStartIndex;
	private int[] valueStorage;

	public ProgressBarHandlerInfo(IProgressBarHandler handler,
			int handlerIndex, int progressBarsStartIndex) {
		this.handler = handler;
		this.handlerIndex = handlerIndex;
		this.progressBarsStartIndex = progressBarsStartIndex;
		this.valueStorage = new int[handler.getValueCount()];

	}

	public IProgressBarHandler getHandler() {
		return handler;
	}
	public int getHandlerIndex() {
		return handlerIndex;
	}
	public int getProgressBarsStartIndex() {
		return progressBarsStartIndex;
	}
	public int[] getValueStorage() {
		return valueStorage;
	}
}
