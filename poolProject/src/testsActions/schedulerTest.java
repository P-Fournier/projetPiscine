package testsActions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import actions.Action;
import actions.Scheduler;

public abstract class schedulerTest extends actionTest {

	protected abstract Scheduler createAction();
	
	protected abstract Scheduler createAction(Action action1,Action action2,Action action3);
	
	
}
