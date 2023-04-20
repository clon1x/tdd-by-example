package guru.springframework;

public class Bank {

	public Money reduce(Expression expression, Currency currency) {
		Sum sum = (Sum) expression;
		int amount = sum.augmend.amount + sum.addend.amount;
		return new Money(amount, currency);
	}

}
