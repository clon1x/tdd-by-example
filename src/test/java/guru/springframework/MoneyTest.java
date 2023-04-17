package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MoneyTest {

	@Test
	void should_GiveCorrectAmount_when_MultipliedByFactor() {

		// given
		Dollar money = new Dollar(5);

		// when
		Dollar product = money.multiply(2);

		// then
		assertEquals(10, product.getAmount());

	}

	@Test
	void should_GiveCorrectAmounts_when_CalledMultipleTimes() {

		// given
		final int DOLLARS_AMOUNT = 5;
		final int MULTIPLICATION_FACTOR_1 = 2;
		final int EXPECTED_1 = 10;
		final int MULTIPLICATION_FACTOR_2 = 3;
		final int EXPECTED_2 = 15;
		Dollar money = new Dollar(DOLLARS_AMOUNT);

		// when
		Dollar product = money.multiply(MULTIPLICATION_FACTOR_1);
		int actual1 = product.getAmount();
		product = money.multiply(MULTIPLICATION_FACTOR_2);
		int actual2 = product.getAmount();

		// then
		assertAll(
				() -> assertEquals(EXPECTED_1, actual1), 
				() -> assertEquals(EXPECTED_2, actual2));

	}

}
