package guru.springframework;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private class CurrencyPair {

		private Currency fromCurrency;
		private Currency toCurrency;

		public CurrencyPair(Currency fromCurrency, Currency toCurrency) {
			this.fromCurrency = fromCurrency;
			this.toCurrency = toCurrency;
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof CurrencyPair) {
				CurrencyPair other = (CurrencyPair) obj;
				return fromCurrency == other.fromCurrency &&  toCurrency == other.toCurrency;
			}
			return super.equals(obj);
		}
		
	}
	
	private Map<CurrencyPair, Integer> conversionRates = new HashMap<>();

	public Money reduce(Expression source, Currency toCurrency) throws ConvertionRateNotFoundException {
		return source.reduce(toCurrency, this);
	}

	public void addRate(Currency fromCurrency, Currency toCurrency, Integer conversionFactor) {
		CurrencyPair currencyPair = new CurrencyPair(fromCurrency, toCurrency);
		conversionRates.put(currencyPair, conversionFactor);
	}
	
	public Integer getRate(Currency fromCurrency, Currency toCurrency) throws ConvertionRateNotFoundException {
		CurrencyPair key = new CurrencyPair(fromCurrency, toCurrency);
		if (conversionRates.containsKey(key)) {
			return conversionRates.get(key);
		}
		throw new ConvertionRateNotFoundException(fromCurrency, toCurrency);
	}

}
