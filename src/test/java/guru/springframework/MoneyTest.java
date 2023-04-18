package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void should_ReturnFalse_When_ConcreteClassIsDifferent() {
		
		// given 
		final int AMOUNT = 6;
		Money money1 = Money.dollar(AMOUNT);
		Money money2 = Money.franc(AMOUNT);
		
		// when
		boolean actual = money1.equals(money2);
		
		// then
		assertFalse(actual);
		
	}

}
