package guru.springframework;

public class Bank {

	public Money reduce(Expression expression, Currency toCurrency) {
		if (expression instanceof Money) return (Money) expression;
		Sum sum = (Sum) expression;
		return sum.reduce(toCurrency);
	}

}
