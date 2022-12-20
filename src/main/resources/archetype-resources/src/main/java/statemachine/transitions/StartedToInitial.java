package statemachine.transitions;

import java.util.Map;

import org.jallaby.beans.annotations.ActionGroup;
import org.jallaby.beans.annotations.Concurrency;
import org.jallaby.beans.annotations.Transition;
import org.jallaby.beans.annotations.TransitionAction;
import org.jallaby.beans.annotations.TransitionGuard;

import com.google.inject.Inject;

import statemachine.business.BusinessObject;

@Transition(fromState = "Started", toState="Initial",
actionGroups = {@ActionGroup(name = "first", concurrency = Concurrency.CONCURRENT),
		@ActionGroup(name = "second", concurrency = Concurrency.SEQUENTIAL)})
public class StartedToInitial {

	//optional
	@Inject
	private BusinessObject businessObject;

	//optional
	@TransitionGuard
	public boolean guard(final Map<String, Map<String, Object>> eventData) {
		//guard condition
		return false;
	}
	
	//optional
	@TransitionAction(group = "first")
	public void firstAction() {
		//perform first action
	}
	
	//optional
	@TransitionAction(group = "first")
	public void secondAction(final Map<String, Map<String, Object>> eventData) {
		businessObject.transitionAction();
	}

	//optional
	@TransitionAction(group = "second", order = 0)
	public void firstSequentialAction(final Map<String, Map<String, Object>> eventData) {
		businessObject.transitionAction();
	}

	//optional
	@TransitionAction(group = "second", order = 1)
	public void secondSequentialAction() {
		businessObject.transitionAction();
	}
}
