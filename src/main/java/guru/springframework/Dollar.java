package guru.springframework;

public class Dollar {

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar multiply(int factor) {
		return new Dollar(getAmount() * factor);
	}

	public int getAmount() {
		return amount;
	}

}
