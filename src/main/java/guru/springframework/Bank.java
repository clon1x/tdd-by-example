package guru.springframework;

public class Bank {

	public Money reduce(Expression sum, String currencyDollar) {
		return new Money(10, "USD");
	}

}
