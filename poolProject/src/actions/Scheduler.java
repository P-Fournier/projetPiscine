package actions;

import java.util.ArrayList;
import java.util.List;

public abstract class Scheduler extends Action {
	
	protected boolean isReady;
	protected boolean isInitialized;
	protected List<Action> actions ;
	
	public Scheduler (){
		this.isReady = true;
		this.isInitialized = false;
		this.actions = new ArrayList<Action>();
	}
	
	public boolean isInProgress(){
		return isInitialized && super.isInProgress();
	}
	
	public boolean isReady(){
		return (isReady&&isInitialized);
	}
	
	public boolean isFinished(){
		return actions.isEmpty()&&(!isReady)&&isInitialized;
	}
	
	public void doStep(){
		this.isReady=false;
		super.doStep();
	}
	
	public void reallyDoStep(){
		try {
			Action nextAction = getNextAction() ;
			nextAction.doStep();
			if (nextAction.isFinished()){
				removeFinishedAction();
			}
		}catch(ActionFinishedException aie){
			aie.printStackTrace();
		}
	}
	
	public abstract void addAction (Action action);
	
	protected abstract void removeFinishedAction();
	
	protected abstract Action getNextAction() throws ActionFinishedException;
	
}
