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

	@Override
	public boolean equals(Object obj) {
		if (Dollar.class.isAssignableFrom(obj.getClass())) {

			Dollar dollar = (Dollar) obj;
			return amount == dollar.getAmount();
		}
		return false;
	}

}
