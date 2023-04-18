package guru.springframework;

public abstract class Money {

	protected int amount;

	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}
	
	public abstract Money multiplyBy(int factor);
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && getClass().equals(obj.getClass());
	}

}
