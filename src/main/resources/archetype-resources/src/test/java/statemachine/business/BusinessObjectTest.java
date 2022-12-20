package statemachine.business;

import org.testng.annotations.Test;

public class BusinessObjectTest {
	
	@Test
	public void testDoAction() {
		new BusinessObject().doAction();
	}
}