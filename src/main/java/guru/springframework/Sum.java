package guru.springframework;

public class Sum implements Expression {

	public Money augmend;
	public Money addend;

	public Sum(Money augmend, Money addend) {
		this.augmend = augmend;
		this.addend = addend;
	}
	
	public Money reduce(Currency toCurrency) {
		int amount = augmend.amount + addend.amount;
		return new Money(amount, toCurrency);
	}
	
}
