package actions;



public class SequentialScheduler extends Scheduler {
	
	public SequentialScheduler (){
		super ();
	}

	@Override
	public void removeFinishedAction() throws ActionNotFinishedException  {
		if (actions.get(0).isFinished()){	
			actions.remove(0);
		}else{
			throw new ActionNotFinishedException();
		}
	}

	@Override
	public Action getNextAction() throws ActionFinishedException {
		if (actions.get(0).isFinished()){
			throw new ActionFinishedException();
		}else{
			return actions.get(0);
		}
	}

}
