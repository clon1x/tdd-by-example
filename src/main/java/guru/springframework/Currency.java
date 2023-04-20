package guru.springframework;

public enum Currency {
	DOLLAR("USD"),
	FRANC("CHF");
	
	private String value;
	
	Currency(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
