package guru.springframework;

public class Franc extends Money {

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc multiplyBy(int factor) {
		return new Franc(amount * factor);
	}

	@Override
	public boolean equals(Object obj) {
		Franc franc = (Franc) obj;
		return amount == franc.amount;
	}

}
