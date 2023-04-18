package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

	private static final String CURRENCY_DOLLAR = "USD";
	private static final String CURRENCY_FRANC = "CHF";

	@Test
	void should_GiveCorrectAmount_when_MultipliedByFactor() {

		// given
		int amount = 5;
		Money money = new Money(amount, CURRENCY_FRANC);
		Money expected = new Money(amount * 2, CURRENCY_FRANC);

		// when
		Money actual = money.multiplyBy(2);

		// then
		assertEquals(expected, actual);

	}

	@Test
	void should_GiveCorrectAmounts_when_CalledMultipleTimes() {

		// given
		int amount = 5;
		int factor1 = 2;
		int factor2 = 3;
		Money expected1 = new Money(10, CURRENCY_FRANC);
		Money expected2 = new Money(15, CURRENCY_FRANC);
		Money money = new Money(amount, CURRENCY_FRANC);

		// when
		Money product1 = money.multiplyBy(factor1);
		Money product2 = money.multiplyBy(factor2);

		// then
		assertAll(
				() -> assertEquals(expected1, product1), 
				() -> assertEquals(expected2, product2));

	}
	
	@Test
	void should_ConsiderEqual_When_ValueAndCurrencyAreEqual() {
		
		// given
		int value = 1;
		String currency = CURRENCY_FRANC;
		Money expected = new Money(value, currency);
		
		// when
		Money actual = new Money(value, currency);
		
		// then
		assertEquals(expected, actual);
	}

	@Test
	void should_ConsiderFrancsNotEqual_When_DifferentValues() {
		
		// given
		int amount = 1;
		String currency = CURRENCY_FRANC;
		Money franc1 = new Money(amount, currency);
		
		// when
		Money franc2 = new Money(amount + 1, currency);
		
		// then
		assertNotEquals(franc1, franc2);
	}	
	
	@Test
	void should_ReturnFalse_When_CurrencyIsDifferent() {
		
		// given 
		int amount = 6;
		Money money1 = new Money(amount, CURRENCY_DOLLAR);
		Money money2 = new Money(amount, CURRENCY_FRANC);
		
		// when
		boolean actual = money1.equals(money2);
		
		// then
		assertFalse(actual);
		
	}
	
	@Test
	void should_ReturnCorrectCurrency() {
		
		// given
		int amount = 1;
		Money dollar = new Money(amount, CURRENCY_DOLLAR);
		Money franc = new Money(amount, CURRENCY_FRANC);
		String expectedDollarCurrency = CURRENCY_DOLLAR;
		String expectedFrancCurrency = CURRENCY_FRANC;
		
		// when
		String actualDollarCurrency = dollar.getCurrency();
		String actualFrancCurrency = franc.getCurrency();
		
		// then
		assertAll(
				() -> assertEquals(expectedDollarCurrency, actualDollarCurrency),
				() -> assertEquals(expectedFrancCurrency, actualFrancCurrency));
		
		
	}

}
