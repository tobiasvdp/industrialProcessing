package ip.industrialProcessing.utils.working;

public interface IWorker {

	int doWork(int amount);
	
	 int getTotalWork() ;

	 int getWorkDone() ;

	 void setTotalWork(int totalWork) ;

	 void setWorkDone(int workDone) ;

	int getScaledProgress(int progressBarWidth);

	boolean isWorking();
 

}
