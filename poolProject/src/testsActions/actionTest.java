package testsActions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.Action;

public abstract class actionTest {

	protected abstract Action createAction() ;
	
	@Test
	protected void OneValidStateAtEachMoment(){
		Action test = createAction();
		
		assertTrue(test.isReady());
		assertFalse(test.isInProgress());
		assertFalse(test.isFinished());
		
		test.doStep();
		
		assertFalse(test.isReady());
		assertTrue(test.isInProgress());
		assertFalse(test.isFinished());
		
		while (!test.isFinished()){
			test.doStep();
		}
		
		assertFalse(test.isReady());
		assertFalse(test.isInProgress());
		assertTrue(test.isFinished());
		
		
	}
	

}
