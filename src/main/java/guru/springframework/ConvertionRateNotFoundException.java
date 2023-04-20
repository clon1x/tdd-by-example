package guru.springframework;

public class ConvertionRateNotFoundException extends Exception {

	private static final long serialVersionUID = -919038307408775036L;

	public ConvertionRateNotFoundException(Currency fromCurrency, Currency toCurrency) {
		super(String.format("Cannot find conversion rate from %s to %s", fromCurrency, toCurrency ));
	}

}
