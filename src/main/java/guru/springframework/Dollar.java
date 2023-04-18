package guru.springframework;

public class Dollar extends Money {

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Money multiplyBy(int factor) {
		return new Dollar(amount * factor);
	}

}
