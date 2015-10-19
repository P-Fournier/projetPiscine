package actions;



public class SequentialScheduler extends Scheduler {
	
	public SequentialScheduler (){
		super ();
	}
	@Override
	public  void addAction(Action action) {
		actions.add(action);
		if (!this.isInitialized){
			this.isInitialized = true ;
		}
	}

	@Override
	protected void removeFinishedAction() {
		if (actions.get(0).isFinished()){
			actions.remove(0);
		}
	}

	@Override
	protected Action getNextAction() throws ActionFinishedException {
		if (this.isInitialized&&!this.isFinished()){
			removeFinishedAction();
		}
		if (actions.isEmpty()){
			throw new ActionFinishedException ();
		}else{
			return actions.get(0);
		}
	}

}
