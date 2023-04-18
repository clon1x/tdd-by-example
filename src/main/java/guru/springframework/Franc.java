package guru.springframework;

public class Franc extends Money {

	public Franc(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money multiplyBy(int factor) {
		return Money.franc(amount * factor);
	}

	@Override
	public String getCurrency() {
		return currency;
	}

}
