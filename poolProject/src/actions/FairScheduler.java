package actions;

import java.util.Iterator;

public class FairScheduler extends Scheduler {

	Iterator<Action> it;
	
	public FairScheduler (){
		super();
	}
	
	@Override
	public void addAction(Action action) {
		actions.add(action);
		if (!this.isInitialized){
			this.isInitialized = true;
			it = actions.iterator();
		}
	}

	@Override
	protected void removeFinishedAction() {
		Iterator<Action> parcourt = actions.iterator();
		while (parcourt.hasNext()){
			Action a = parcourt.next();
			if (a.isFinished()){
				it.remove();
			}
		}
	}

	@Override
	protected Action getNextAction() throws ActionFinishedException {
		if (it.hasNext()){
			return it.next();
		}else{
			removeFinishedAction();
			if (actions.isEmpty()){
				throw new ActionFinishedException();
			}else{
				it = actions.iterator();
				return it.next();
			}
		}
		
	}

}
