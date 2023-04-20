package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void should_GiveCorrectAmount_when_MultipliedByFactor() {

		// given
		int amount = 5;
		Money money = new Money(amount, Currency.FRANC);
		Money expected = new Money(amount * 2, Currency.FRANC);

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
		Money expected1 = new Money(10, Currency.FRANC);
		Money expected2 = new Money(15, Currency.FRANC);
		Money money = new Money(amount, Currency.FRANC);

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
		Currency currency = Currency.FRANC;
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
		Currency currency = Currency.FRANC;
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
		Money money1 = new Money(amount, Currency.DOLLAR);
		Money money2 = new Money(amount, Currency.FRANC);
		
		// when
		boolean actual = money1.equals(money2);
		
		// then
		assertFalse(actual);
		
	}
	
	@Test
	void should_ReturnCorrectCurrency() {
		
		// given
		int amount = 1;
		Money dollar = new Money(amount, Currency.DOLLAR);
		Money franc = new Money(amount, Currency.FRANC);
		Currency expectedDollarCurrency = Currency.DOLLAR;
		Currency expectedFrancCurrency = Currency.FRANC;
		
		// when
		Currency actualDollarCurrency = dollar.getCurrency();
		Currency actualFrancCurrency = franc.getCurrency();
		
		// then
		assertAll(
				() -> assertEquals(expectedDollarCurrency, actualDollarCurrency),
				() -> assertEquals(expectedFrancCurrency, actualFrancCurrency));
		
		
	}
	
	@Test
	void should_ReturnRightAmount_When_AddingSameCurrency() throws ConvertionRateNotFoundException {
		
		// given
		Bank bank = new Bank();
		Money first = new Money(3, Currency.DOLLAR);
		Money second = new Money(7, Currency.DOLLAR);
		Money expected = new Money(10, Currency.DOLLAR);
		
		// when
		Expression sum = first.add(second);
		Money actual = bank.reduce(sum, Currency.DOLLAR);
		
		// then
		assertEquals(expected, actual);
		
	}

	@Test
	void should_ReturnSum_When_AddingMoney() {
		
		// given		
		Money five = new Money(5, Currency.DOLLAR);
		
		// when
		Expression result = five.add(five);
		
		// then
		Sum sum = (Sum) result;
		
		assertAll(
				() -> assertEquals(five, sum.augmend), 
				() -> assertEquals(five, sum.addend));
	}
	
}
