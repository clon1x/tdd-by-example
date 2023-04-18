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
		Money money = new Money(AMOUNT, "CHF");
		Money expected = new Money(AMOUNT * 2, "CHF");

		// when
		Money actual = money.multiplyBy(2);

		// then
		assertEquals(expected, actual);

	}

	@Test
	void should_GiveCorrectFrancAmounts_when_CalledMultipleTimes() {

		// given
		final int FRANCS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final Money EXPECTED_1 = new Money(10, "CHF");
		final int MULTIPLICATION_FACTOR_2 = 3;
		final Money EXPECTED_2 = new Money(15, "CHF");
		Money money = new Money(FRANCS_AMOUNT, "CHF");

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
		final Money EXPECTED = new Money(VALUE, "CHF");
		
		// when
		Money actual = new Money(VALUE, "CHF");
		
		// then
		assertEquals(EXPECTED, actual);
	}

	@Test
	void should_ConsiderFrancsNotEqual_When_DifferentValues() {
		
		// given
		final int VALUE = 1;
		final Money franc1 = new Money(VALUE, "CHF");
		
		// when
		Money franc2 = new Money(VALUE + 1, "CHF");
		
		// then
		assertNotEquals(franc1, franc2);
	}
	
}
