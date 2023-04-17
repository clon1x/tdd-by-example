package guru.springframework;

public class Dollar {

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar multiplyBy(int factor) {
		return new Dollar(getAmount() * factor);
	}

	public int getAmount() {
		return amount;
	}

}
