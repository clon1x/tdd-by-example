package guru.springframework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankTest {

	
	@Test
	void should_ReturnRightMoney_When_ReducingSumSameCurrency() {
		
		// given
		Expression sum = new Sum(
				new Money(3, Currency.DOLLAR), 
				new Money(4, Currency.DOLLAR));
		Bank bank = new Bank();
		
		// when
		Money result = bank.reduce(sum, Currency.DOLLAR);
		
		// then
		assertEquals(new Money(7, Currency.DOLLAR), result);
	}
	
	@Test
	void should_ReturnRightMoney_When_ReducingSumDifferentCurrency() {
		
		// given
		Expression sum = new Sum(
				new Money(3, Currency.DOLLAR), 
				new Money(4, Currency.FRANC));
		Bank bank = new Bank();
		bank.addRate(Currency.FRANC, Currency.DOLLAR, 2);
		Money expected = new Money(10, Currency.DOLLAR);	// 3 * 2 + 4
		
		// when
		Money result = bank.reduce(sum, Currency.DOLLAR);
		
		// then
		assertEquals(expected, result);
	}

	
	@Test
	void should_ReturnSame_When_ReducingMoney() {
		
		// given
		Bank bank = new Bank();
		Money money = new Money(1, Currency.DOLLAR);
		
		// when
		Money result = bank.reduce(money, Currency.DOLLAR);
		
		// then
		assertEquals(money, result);
	}

}
