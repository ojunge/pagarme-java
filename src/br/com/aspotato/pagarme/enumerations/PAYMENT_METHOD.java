package br.com.aspotato.pagarme.enumerations;

public enum PAYMENT_METHOD {

	CREDIT_CARD("credit_car"),
	BOLETO("boleto");

	private String value;    

	private PAYMENT_METHOD(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
