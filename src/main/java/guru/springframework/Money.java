package guru.springframework;

public class Money implements Expression {

	protected int amount;
	protected Currency currency;
	
	public Money(int amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && currency == money.currency ;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	public Money multiplyBy(int factor) {
		return new Money(amount * factor, currency);
	}

	public Expression add(Money addend) {
		return new Money(amount + addend.amount, currency) ;
	}
	
}
