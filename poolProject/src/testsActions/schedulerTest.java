package testsActions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;
import actions.ActionFinishedException;
import actions.ActionNotFinishedException;
import actions.Scheduler;

public abstract class schedulerTest extends actionTest {

	protected abstract Scheduler createAction();
	
	protected abstract Scheduler createAction(Action action1,Action action2,Action action3);
	
	@Test
	protected void testAddAction(){
		
		MockOneStepAction actionTest = new MockOneStepAction();
		
		Scheduler test = createAction();
		
		assertFalse(test.isInitialized());
		
		test.addAction(actionTest);
		
		assertTrue(test.isInitialized());
		
		assertTrue(test.getActions().contains(actionTest));
		
	}
	
	@Test
	protected void removeFinishedActionSuccessTest() throws ActionNotFinishedException{
		
		MockFinishedAction actionTest = new MockFinishedAction();
		
		Scheduler test = createAction();
		
		test.addAction(actionTest);
		
		assertTrue(test.getActions().contains(actionTest));
		
		test.removeFinishedAction();
		
		assertFalse(test.getActions().contains(actionTest));
		
	}
	
	@Test(expected=ActionNotFinishedException.class)
	protected void removeFinishedActionFailTest() throws ActionNotFinishedException{
		
		MockOneStepAction actionTest = new MockOneStepAction();
		
		Scheduler test = createAction();
		
		test.addAction(actionTest);
		
		assertTrue(test.getActions().contains(actionTest));
		
		test.removeFinishedAction();
		
	}
	
	@Test
	protected void getNextActionSuccessTest()throws ActionFinishedException , ActionNotFinishedException{
		
		MockOneStepAction actionTest1 = new MockOneStepAction();
		MockOneStepAction actionTest2 = new MockOneStepAction();
		MockOneStepAction actionTest3 = new MockOneStepAction();
		
		Scheduler test = createAction(actionTest1,actionTest2,actionTest3);
		
		Action step1 = test.getNextAction();
		
		assertEquals(actionTest1,step1);
		
		// effect one do step on the first action to finish it
		actionTest1.doStep();
		
		//delete now the finish action from the scheduler
		test.removeFinishedAction();
		
		Action step2 = test.getNextAction();
		
		assertEquals(actionTest2,step2);
		
		// effect one do step on the first action to finish it
		actionTest2.doStep();
				
		//delete now the finish action from the scheduler
		test.removeFinishedAction();
		
		Action step3 = test.getNextAction();
		
		assertEquals(actionTest3,step3);
	
	}
	
	@Test(expected=ActionFinishedException.class)
	protected void getNextActionFailTest()throws ActionFinishedException {
		
		MockFinishedAction actionTest = new MockFinishedAction();
		
		Scheduler test = createAction();
		
		test.addAction(actionTest);
		
		assertTrue(test.getActions().contains(actionTest));
		
		// action finished you had to raise an exception
		@SuppressWarnings("unused")
		Action next = test.getNextAction();
	
	}
	
}
