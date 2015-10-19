package actions;

public class ForeseebleAction extends Action {
	
	protected int totalTime ;
	protected int currentTime;
	protected String actionName;
	
	public ForeseebleAction (int time , String actionName){
		
		totalTime = time;
		currentTime = 0;
		this.actionName = actionName ;
		
	}
	@Override
	public boolean isReady() {
		return currentTime==0;
	}
	@Override
	public boolean isFinished() {
		return currentTime == totalTime ;
	}
	@Override
	public void reallyDoStep() {
		// TODO Auto-generated method stub
		
	}
	
	
}
