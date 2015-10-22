package actions;

public abstract class Action {
	
	public abstract boolean isReady();

	public abstract boolean isFinished();
	
	protected abstract void reallyDoStep();
	
	public boolean isInProgress(){
		return !isReady() && !isFinished();
	}
	
	public void doStep(){
		if(!isFinished()){
			reallyDoStep();
		}
	}
	
}
