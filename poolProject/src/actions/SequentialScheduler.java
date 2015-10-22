package actions;



public class SequentialScheduler extends Scheduler {
	
	public SequentialScheduler (){
		super ();
	}

	@Override
	protected void removeFinishedAction() {
			actions.remove(0);
	}

	@Override
	protected Action getNextAction() throws ActionFinishedException {
		if (actions.get(0).isFinished()){
			throw new ActionFinishedException();
		}else{
			return actions.get(0);
		}
	}

}
