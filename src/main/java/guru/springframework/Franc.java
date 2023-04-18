package guru.springframework;

public class Franc extends Money {

	public Franc(int amount, String currency) {
		super(amount, currency);
	}

	public Money multiplyBy(int factor) {
		return new Franc(amount * factor, currency);
	}

}
