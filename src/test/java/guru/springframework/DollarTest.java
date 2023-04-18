package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class DollarTest {

	@Test
	void should_GiveCorrectDollarAmount_when_MultipliedByFactor() {

		// given
		final int AMOUNT = 5;
		Money money = new Money(AMOUNT, "USD");
		Money expected = new Money(AMOUNT * 2, "USD");

		// when
		Money actual = money.multiplyBy(2);

		// then
		assertEquals(expected, actual);

	}

	@Test
	void should_GiveCorrectDollarAmounts_when_CalledMultipleTimes() {

		// given
		final int DOLLARS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final Money EXPECTED_1 = new Money(10, "USD");
		final int MULTIPLICATION_FACTOR_2 = 3;
		final Money EXPECTED_2 = new Money(15, "USD");
		Money money = new Money(DOLLARS_AMOUNT, "USD");

		// when
		Money product1 = money.multiplyBy(MULTIPLICATION_FACTOR_1);
		Money product2 = money.multiplyBy(MULTIPLICATION_FACTOR_2);

		// then
		assertAll(
				() -> assertEquals(EXPECTED_1, product1), 
				() -> assertEquals(EXPECTED_2, product2));

	}
	
	@Test
	void should_ConsiderDollarsAreEqual_When_ValuesAreEqual() {
		
		// given
		final int VALUE = 1;
		final Money EXPECTED = new Money(VALUE, "USD");
		
		// when
		Money actual = new Money(VALUE, "USD");
		
		// then
		assertEquals(EXPECTED, actual);
	}

	@Test
	void should_ConsiderDollarsNotEqual_When_DifferentValues() {
		
		// given
		final int VALUE = 1;
		final Money dollar1 = new Money(VALUE, "USD");
		
		// when
		Money dollar2 = new Money(VALUE + 1, "USD");
		
		// then
		assertNotEquals(dollar1, dollar2);
	}
	
}
