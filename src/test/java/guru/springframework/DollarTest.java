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
		Dollar money = Money.dollar(AMOUNT);

		// when
		Money product = money.multiplyBy(2);

		// then
		assertEquals(Money.dollar(AMOUNT * 2), product);

	}

	@Test
	void should_GiveCorrectDollarAmounts_when_CalledMultipleTimes() {

		// given
		final int DOLLARS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final Dollar EXPECTED_1 = Money.dollar(10);
		final int MULTIPLICATION_FACTOR_2 = 3;
		final Dollar EXPECTED_2 = Money.dollar(15);
		Dollar money = Money.dollar(DOLLARS_AMOUNT);

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
		final Dollar EXPECTED = Money.dollar(VALUE);
		
		// when
		Dollar actual = Money.dollar(VALUE);
		
		// then
		assertEquals(EXPECTED, actual);
	}

	@Test
	void should_ConsiderDollarsNotEqual_When_DifferentValues() {
		
		// given
		final int VALUE = 1;
		final Dollar dollar1 = Money.dollar(VALUE);
		
		// when
		Dollar dollar2 = Money.dollar(VALUE + 1);
		
		// then
		assertNotEquals(dollar1, dollar2);
	}
	
}
