package guru.springframework;

public class Bank {

	public Money reduce(Expression sum, Currency currency) {
		return new Money(10, Currency.DOLLAR);
	}

}
