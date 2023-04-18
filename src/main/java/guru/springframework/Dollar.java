package guru.springframework;

public class Dollar extends Money {

	public Dollar(int amount, String currency) {
		super(amount, currency);
	}

	public Money multiplyBy(int factor) {
		return new Dollar(amount * factor, currency);
	}

}
