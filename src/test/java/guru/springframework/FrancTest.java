package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class FrancTest {

	@Test
	void should_GiveCorrectFrancAmount_when_MultipliedByFactor() {

		// given
		final int AMOUNT = 5;
		Franc money = Money.franc(AMOUNT);

		// when
		Money product = money.multiplyBy(2);

		// then
		assertEquals(Money.franc(AMOUNT * 2), product);

	}

	@Test
	void should_GiveCorrectFrancAmounts_when_CalledMultipleTimes() {

		// given
		final int FRANCS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final Franc EXPECTED_1 = Money.franc(10);
		final int MULTIPLICATION_FACTOR_2 = 3;
		final Franc EXPECTED_2 = Money.franc(15);
		Franc money = Money.franc(FRANCS_AMOUNT);

		// when
		Money product1 = money.multiplyBy(MULTIPLICATION_FACTOR_1);
		Money product2 = money.multiplyBy(MULTIPLICATION_FACTOR_2);

		// then
		assertAll(
				() -> assertEquals(EXPECTED_1, product1), 
				() -> assertEquals(EXPECTED_2, product2));

	}
	
	@Test
	void should_ConsiderFrancsAreEqual_When_ValuesAreEqual() {
		
		// given
		final int VALUE = 1;
		final Franc EXPECTED = Money.franc(VALUE);
		
		// when
		Franc actual = Money.franc(VALUE);
		
		// then
		assertEquals(EXPECTED, actual);
	}

	@Test
	void should_ConsiderFrancsNotEqual_When_DifferentValues() {
		
		// given
		final int VALUE = 1;
		final Franc franc1 = Money.franc(VALUE);
		
		// when
		Franc franc2 = Money.franc(VALUE + 1);
		
		// then
		assertNotEquals(franc1, franc2);
	}
	
}
