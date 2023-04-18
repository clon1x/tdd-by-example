package guru.springframework;

public abstract class Money {

	protected int amount;
	protected String currency;

	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public abstract Money multiplyBy(int factor);
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount && getClass().equals(obj.getClass());
	}

	public abstract String getCurrency();
	
}
