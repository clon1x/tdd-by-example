package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

	private Bank bank;


	@BeforeEach
	void setup() {
		bank = new Bank();
		bank.addRate(Currency.FRANC, Currency.DOLLAR, 2);
	}
	
	@Test
	void should_ReturnRightMoney_When_ReducingSumSameCurrency() throws ConvertionRateNotFoundException {
		
		// given
		Expression sum = new Sum(
				new Money(3, Currency.DOLLAR), 
				new Money(4, Currency.DOLLAR));
		
		// when
		Money result = bank.reduce(sum, Currency.DOLLAR);
		
		// then
		assertEquals(new Money(7, Currency.DOLLAR), result);
	}
	
	@Test
	void should_ReturnRightMoney_When_ReducingSumDifferentCurrency() throws ConvertionRateNotFoundException {
		
		// given
		Expression sum = new Sum(
				new Money(3, Currency.DOLLAR), 
				new Money(4, Currency.FRANC));
		Money expected = new Money(11, Currency.DOLLAR);	// 3 + 4 * 2
		
		// when
		Money result = bank.reduce(sum, Currency.DOLLAR);
		
		// then
		assertEquals(expected, result);
	}

	
	@Test
	void should_ReturnSame_When_ReducingMoney() throws ConvertionRateNotFoundException {
		
		// given
		Money money = new Money(1, Currency.DOLLAR);
		
		// when
		Money result = bank.reduce(money, Currency.DOLLAR);
		
		// then
		assertEquals(money, result);
	}

}
