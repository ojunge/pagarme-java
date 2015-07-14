package br.com.aspotato.pagarme.models;

public class Balance extends Model {

	private String object;
	private SubBalance waiting_funds;
	private SubBalance available;
	private SubBalance transferred;
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public SubBalance getWaiting_funds() {
		return waiting_funds;
	}
	public void setWaiting_funds(SubBalance waiting_funds) {
		this.waiting_funds = waiting_funds;
	}
	public SubBalance getAvailable() {
		return available;
	}
	public void setAvailable(SubBalance available) {
		this.available = available;
	}
	public SubBalance getTransferred() {
		return transferred;
	}
	public void setTransferred(SubBalance transferred) {
		this.transferred = transferred;
	}
	

}
