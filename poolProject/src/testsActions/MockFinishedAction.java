package testsActions;

import actions.Action;

public class MockFinishedAction extends Action {

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	protected void reallyDoStep() {
		
	}

}
