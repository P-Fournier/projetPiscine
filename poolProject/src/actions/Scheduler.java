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
          }catch (ActionNotFinishedException anfe) {
        	    throw new RuntimeException (
        	    		"the action you tried to remove is not a finished action");
          }
    }
	
	public void addAction (Action action){
			isInitialized = true;
			actions.add(action);
	}
	
	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public abstract void removeFinishedAction() throws ActionNotFinishedException;
	
	public abstract Action getNextAction() throws ActionFinishedException;
	
}
