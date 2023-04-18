package guru.springframework;

public class Franc extends Money {

	private int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc multiplyBy(int factor) {
		return new Franc(amount * factor);
	}

	@Override
	public boolean equals(Object obj) {
		if (Franc.class.isAssignableFrom(obj.getClass())) {

			Franc franc = (Franc) obj;
			return amount == franc.amount;
		}
		return false;
	}

}
