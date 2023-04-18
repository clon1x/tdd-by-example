package guru.springframework;

public class Dollar extends Money {

	public Dollar(int amount) {
		this.amount = amount;
		this.currency = "USD";
	}

	public Money multiplyBy(int factor) {
		return Money.dollar(amount * factor);
	}

	@Override
	public String getCurrency() {
		return currency;
	}

}
