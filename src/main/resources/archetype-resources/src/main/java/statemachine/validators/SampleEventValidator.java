package statemachine.validators;

import org.jallaby.event.Event;
import org.jallaby.event.EventValidator;

public class SampleEventValidator implements EventValidator {
	
	@Override
	public boolean isValidEvent(Event event) {
		return true;
	}
}