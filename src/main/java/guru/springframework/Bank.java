package guru.springframework;

public class Bank {

	public Money reduce(Expression source, Currency toCurrency) {
		return source.reduce(toCurrency);
	}

	public void addRate(Currency franc, Currency dollar, int i) {
		// TODO Auto-generated method stub
		
	}

}
