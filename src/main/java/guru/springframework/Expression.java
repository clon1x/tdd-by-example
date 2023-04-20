package guru.springframework;

public interface Expression {
	Money reduce(Currency toCurrency, Bank bank) throws ConvertionRateNotFoundException;
}
