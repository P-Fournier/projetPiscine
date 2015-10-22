package actions;

import java.util.Iterator;

public class FairScheduler extends Scheduler {

	Iterator<Action> it;
	
	public FairScheduler (){
		super();
	}

	@Override
	protected void removeFinishedAction() {
		it.remove();
	}

	@Override
	protected Action getNextAction() throws ActionFinishedException {
		Action nextAction ;
		if (it.hasNext()){
			nextAction = it.next();
		}else{
			it = actions.iterator();
			nextAction = getNextAction();
		}
		if(nextAction.isFinished()){
			throw new ActionFinishedException();
		}else{
			return nextAction;
		}
	}

}
