package guru.springframework;

public class Bank {

	public Money reduce(Expression source, Currency toCurrency) {
		return source.reduce(toCurrency);
	}

}
