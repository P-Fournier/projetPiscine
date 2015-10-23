package testsActions;

import actions.Action;

public class MockOneStepAction extends Action {

	protected boolean ready ;
	
	public MockOneStepAction (){
		this.ready = true;
	}
	
	@Override
	public boolean isReady() {
		return this.ready;
	}

	@Override
	public boolean isFinished() {
		return !this.ready;
	}

	@Override
	protected void reallyDoStep() {
		this.ready = false ;
	}

}
