package statemachine.transitions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.ActionGroup;
import org.jallaby.beans.annotations.Concurrency;
import org.jallaby.beans.annotations.Transition;
import org.jallaby.beans.annotations.TransitionAction;
import org.jallaby.beans.annotations.TransitionGuard;

import com.google.inject.Inject;

import statemachine.business.BusinessObject;

@Transition(fromState = "Initial", toState="Started",
actionGroups = @ActionGroup(name = "first", concurrency = Concurrency.SEQUENTIAL))
public class InitialToStarted {

	//optional
	@Inject
	private BusinessObject businessObject;
	
	//optional
	@PostConstruct
	public void postConstruct() {
		//post construct operations
	}

	//optional
	@TransitionGuard
	public boolean guard() {
		return businessObject.guardInitialToStarted();
	}
	
	//optional
	@TransitionAction(group = "first", order = 0)
	public void firstAction() {
		//perform first action
	}
	
	//optional
	@TransitionAction(group = "first", order = 1)
	public void secondAction() {
		//perform second action
	}
	
	//optional
	@PreDestroy
	public void preDestroy() {
		//pre destroy operations
	}
}
