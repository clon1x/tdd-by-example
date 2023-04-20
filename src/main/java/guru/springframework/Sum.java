package guru.springframework;

public class Sum implements Expression {

	public Money augmend;
	public Money addend;

	public Sum(Money augmend, Money addend) {
		this.augmend = augmend;
		this.addend = addend;
	}
	
	@Override
	public Money reduce(Currency toCurrency, Bank bank) throws ConvertionRateNotFoundException {
		Money reducedAugmend = augmend.reduce(toCurrency, bank);
		Money reducedAddend = addend.reduce(toCurrency, bank);

		int amount = reducedAugmend.amount + reducedAddend.amount;

		return new Money(amount, toCurrency);
	}
	
}
