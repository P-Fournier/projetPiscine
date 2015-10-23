package testsActions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import actions.Action;
import actions.FairScheduler;
import actions.Scheduler;

public class fairSchedulerTest extends schedulerTest {

	@Override
	protected FairScheduler createAction (){
		return new FairScheduler();
	}

	@Override
	protected Scheduler createAction(Action action1, Action action2,
			Action action3) {
		FairScheduler test = new FairScheduler ();
		test.addAction(action1);
		test.addAction(action2);
		test.addAction(action3);
		return test;
	}
	
	@Test
	public void () {
		
	}

}
