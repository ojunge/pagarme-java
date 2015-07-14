package br.com.aspotato.pagarme.utils;

public class PagarMeProvider {

	private static PagarMeProvider instance;

	private PagarMeProvider() {

	}


	private String url = "https://api.pagar.me/"; 
	private String api_key = "";

	public static PagarMeProvider getInstance() {
		if (instance == null)
			instance = new PagarMeProvider();
		return instance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}
}
