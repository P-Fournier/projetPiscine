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
	
	public  boolean isReady(){
		return (isReady&&isInitialized);
	}
	
	public boolean isFinished(){
		return actions.isEmpty()&&(!isReady)&&isInitialized;
	}
	
	public void doStep(){
		this.isReady=false;
		super.doStep();
	}
	
	@Override
    protected void reallyDoStep() {
          try {
                Action nextAction = getNextAction();
                nextAction.doStep();
                if (nextAction.isFinished()) {
                      removeFinishedAction();
                }
          } catch (ActionFinishedException afe) {
                throw new RuntimeException(
                            "nextAction() should have made sure that the returned action is not finished");
          } 
    }
	
	public void addAction (Action action){
			isInitialized = true;
			actions.add(action);
	}
	
	protected abstract void removeFinishedAction() ;
	
	protected abstract Action getNextAction() throws ActionFinishedException;
	
}
