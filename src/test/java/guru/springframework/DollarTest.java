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
		Dollar money = new Dollar(AMOUNT);

		// when
		Dollar product = money.multiplyBy(2);

		// then
		assertEquals(new Dollar(AMOUNT * 2), product);

	}

	@Test
	void should_GiveCorrectDollarAmounts_when_CalledMultipleTimes() {

		// given
		final int DOLLARS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final Dollar EXPECTED_1 = new Dollar(10);
		final int MULTIPLICATION_FACTOR_2 = 3;
		final Dollar EXPECTED_2 = new Dollar(15);
		Dollar money = new Dollar(DOLLARS_AMOUNT);

		// when
		Dollar product1 = money.multiplyBy(MULTIPLICATION_FACTOR_1);
		Dollar product2 = money.multiplyBy(MULTIPLICATION_FACTOR_2);

		// then
		assertAll(
				() -> assertEquals(EXPECTED_1, product1), 
				() -> assertEquals(EXPECTED_2, product2));

	}
	
	@Test
	void should_ConsiderDollarsAreEqual_When_ValuesAreEqual() {
		
		// given
		final int VALUE = 1;
		final Dollar EXPECTED = new Dollar(VALUE);
		
		// when
		Dollar actual = new Dollar(VALUE);
		
		// then
		assertEquals(EXPECTED, actual);
	}

	@Test
	void should_ConsiderDollarsNotEqual_When_DifferentValues() {
		
		// given
		final int VALUE = 1;
		final Dollar dollar1 = new Dollar(VALUE);
		
		// when
		Dollar dollar2 = new Dollar(VALUE + 1);
		
		// then
		assertNotEquals(dollar1, dollar2);
	}
	
}
