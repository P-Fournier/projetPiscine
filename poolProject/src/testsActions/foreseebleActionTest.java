package testsActions;



import org.junit.Test;

import actions.ForeseebleAction;

public class foreseebleActionTest extends actionTest {

	protected int timeToEnd ;
	
	protected ForeseebleAction createAction() {
		return new ForeseebleAction(timeToEnd, null);
	}
	
	@Test
	public void allTest(){
		
		OneValidStateAtEachMoment();
		
	}

}
