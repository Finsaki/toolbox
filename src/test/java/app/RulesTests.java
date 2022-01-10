package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RulesTests {
	
	@Test
	@DisplayName("Poolsize < Amount of Numbers on constructor - Throws IllegalArgumentException exception")
	void noIllegalRulesAllowedOnConstructor() {
		int poolSize = 5;
		int amountOfNum = 6;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Rules rules = new Rules(poolSize, amountOfNum);
		});
		assertEquals("Parameters are not valid!", exception.getMessage());
	}
	
	@Test
	@DisplayName("Amount of Numbers is set greater than Poolsize - Throws IllegalArgumentException exception")
	void noIllegalRulesAllowedOnSizeSetter() {
		Rules rules = new Rules(50, 7);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			rules.setAmount(51);
		});
		assertEquals("Parameters are not valid!", exception.getMessage());
	}
	
	@Test
	@DisplayName("Poolsize is set < 1 - Throws IllegalArgumentException exceptio")
	void noIllegalRulesAllowedOnAmountSetter() {
		Rules rules = new Rules(50, 7);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			rules.setSize(0);
		});
		assertEquals("Parameters are not valid!", exception.getMessage());
	}

}
