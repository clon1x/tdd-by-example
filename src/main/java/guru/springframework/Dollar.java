package guru.springframework;

public class Dollar extends Money {

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar multiplyBy(int factor) {
		return new Dollar(amount * factor);
	}

	@Override
	public boolean equals(Object obj) {
		if (Dollar.class.isAssignableFrom(obj.getClass())) {

			Dollar dollar = (Dollar) obj;
			return amount == dollar.amount;
		}
		return false;
	}

}
