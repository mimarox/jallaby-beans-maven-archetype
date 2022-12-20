package statemachine.states;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.jallaby.beans.annotations.EntryAction;
import org.jallaby.beans.annotations.ExitAction;
import org.jallaby.beans.annotations.State;

import statemachine.business.BusinessObject;

import com.google.inject.Inject;

@State(name = "Initial")
public class Initial {
	
	//optional
	@Inject
	private BusinessObject businessObject;
	
	//optional
	@PostConstruct
	public void postConstruct() {
		//post construct operations
	}
	
	//optional
	@EntryAction
	public void entryAction(final Map<String, Map<String, Object>> eventData) {
		businessObject.doAction();
	}
	
	//optional
	@ExitAction
	public void exitAction(final Map<String, Map<String, Object>> eventData) {
		businessObject.doAnotherAction();
	}
	
	//optional
	@PreDestroy
	public void preDestroy() {
		//pre destroy operations
	}
}