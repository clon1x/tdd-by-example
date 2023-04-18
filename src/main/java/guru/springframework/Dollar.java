package guru.springframework;

public class Dollar extends Money {

	public Dollar(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money multiplyBy(int factor) {
		return Money.dollar(amount * factor);
	}

	@Override
	public String getCurrency() {
		return currency;
	}

}
