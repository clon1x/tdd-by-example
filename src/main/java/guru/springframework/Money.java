package guru.springframework;

public class Money {

	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && currency == money.currency ;
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}

	public Money multiplyBy(int factor) {
		return new Money(amount * factor, currency);
	}
	
}
