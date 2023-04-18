package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
	
	@Test
	void should_ReturnCorrectCurrency_When_ClassIsDollar() {
		
		// given
		Money dollar = Money.dollar(1);
		Money franc = Money.franc(1);
		String expectedDollar = "USD";
		String expectedFranc = "CHF";
		
		// when
		String actualDollar = dollar.getCurrency();
		String actualFranc = franc.getCurrency();
		
		// then
		assertAll(
				() -> assertEquals(expectedDollar, actualDollar),
				() -> assertEquals(expectedFranc, actualFranc));
		
		
	}

}
