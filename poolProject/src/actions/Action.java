package actions;

public abstract class Action {
	
	abstract boolean isReady();

	abstract boolean isFinished();
	
	abstract void reallyDoStep();
	
	protected boolean isInProgress(){
		return !isReady() && !isFinished();
	}
	
	protected void doStep(){
		if(!isFinished()){
			reallyDoStep();
		}
	}
	
}
