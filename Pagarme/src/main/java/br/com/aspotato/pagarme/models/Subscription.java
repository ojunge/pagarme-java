package br.com.aspotato.pagarme.models;

import java.sql.Timestamp;

public class Subscription extends Model {

	private Integer id;
	private String object;
	private Plan plan;
	//current_transaction
	//metadata
	private Phone phone;
	private String postback_url;
	private String payment_method;
	private String current_period_start;
	private String current_period_end;
	private Integer charges;
	private String status;
	private Timestamp date_created;
	private Address address;
	private Client customer;
	private Card card;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public String getPostback_url() {
		return postback_url;
	}
	public void setPostback_url(String postback_url) {
		this.postback_url = postback_url;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getCurrent_period_start() {
		return current_period_start;
	}
	public void setCurrent_period_start(String current_period_start) {
		this.current_period_start = current_period_start;
	}
	public String getCurrent_period_end() {
		return current_period_end;
	}
	public void setCurrent_period_end(String current_period_end) {
		this.current_period_end = current_period_end;
	}
	public Integer getCharges() {
		return charges;
	}
	public void setCharges(Integer charges) {
		this.charges = charges;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getDate_created() {
		return date_created;
	}
	public void setDate_created(Timestamp date_created) {
		this.date_created = date_created;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Client getCustomer() {
		return customer;
	}
	public void setCustomer(Client customer) {
		this.customer = customer;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Phone getPhone() {
	    return phone;
    }
	public void setPhone(Phone phone) {
	    this.phone = phone;
    }
}
