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
		
		
	}
	
	private Map<CurrencyPair, Integer> conversionRates = new HashMap<>();

	public Money reduce(Expression source, Currency toCurrency) {
		return source.reduce(toCurrency);
	}

	public void addRate(Currency fromCurrency, Currency toCurrency, Integer conversionFactor) {
		CurrencyPair currencyPair = new CurrencyPair(fromCurrency, toCurrency);
		conversionRates.put(currencyPair, conversionFactor);
	}
	
	public Integer getRate(Currency fromCurrency, Currency toCurrency) {
		return null;
	}

}
