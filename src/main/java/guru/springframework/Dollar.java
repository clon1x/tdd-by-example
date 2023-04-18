package guru.springframework;

public class Dollar extends Money {

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar multiplyBy(int factor) {
		return new Dollar(amount * factor);
	}

	@Override
	public boolean equals(Object obj) {
		Money dollar = (Money) obj;
		return amount == dollar.amount;
	}

}
