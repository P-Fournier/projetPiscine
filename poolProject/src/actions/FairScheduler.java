package actions;

import java.util.ListIterator;

public class FairScheduler extends Scheduler {

	ListIterator<Action> it;
	
	public FairScheduler (){
		super();
	}

	@Override
	public void removeFinishedAction() throws ActionNotFinishedException{
		if (it.next().isFinished()){
			it.previous();
			it.remove();
		}else{
			it.previous();
			throw new ActionNotFinishedException();
		}
	}

	@Override
	public Action getNextAction() throws ActionFinishedException {
		Action nextAction ;
		if (it.hasNext()){
			nextAction = it.next();
		}else{
			it = actions.listIterator();
			nextAction = getNextAction();
		}
		if(nextAction.isFinished()){
			throw new ActionFinishedException();
		}else{
			return nextAction;
		}
	}

}
