package ip.industrialProcessing.recipes;

public class RecipeFluidPowerWorker extends RecipeFluidWorker implements IRecipePowerHandler{
	public int totalPower;
	public int powerUsed;
	public int powerDecr;
	public RecipeFluidPowerWorker(IRecipeFluidWorkHandler handler) {
		super(handler);
	}
	@Override
	protected void onPrepareWork() {
		super.onPrepareWork();
			if (recipe != null)
				this.totalPower = this.recipe.powerRequired;
			else
				this.totalPower = 0;
	}
	public int doWork(int amount, int powerLeft) {
		int workToDo = 0;
		int powerToUse =0;
		if (amount > 0) {
			if (this.workDone == 0) {
				onPrepareWork();
			}
			if (hasWork()) {
				if (canWork()) {
					if (workDone == 1)
						onBeginWork();
					workToDo = Math.min(amount, totalWork - workDone+1);
					powerToUse = totalPower*workToDo/totalWork;
					if(powerToUse <= powerLeft)
						onWorkProgressed(workToDo,powerToUse);
					if (this.workDone > this.totalWork) {
						powerDecr = totalPower - powerUsed;
						onEndWork();
					}
				}
			} else if (workDone > 1) {
				this.onWorkCancelled();
			} else
				this.workDone = 0; // prepare again next tick

		}
		return workToDo;
	}
	protected void onWorkProgressed(int amount,int power) {
	super.onWorkProgressed(amount);
	powerUsed += power;
	powerDecr = power;
	}
}
