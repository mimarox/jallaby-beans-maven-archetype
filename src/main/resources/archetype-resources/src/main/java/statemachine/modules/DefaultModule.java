package statemachine.modules;

import statemachine.business.BusinessObject;

import com.google.inject.Binder;
import com.google.inject.Module;

public class DefaultModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(BusinessObject.class).asEagerSingleton();
	}
}
