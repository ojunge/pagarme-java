package br.com.aspotato.pagarme.models;

import java.sql.Date;

public class Card extends Model {

	private String id;
	private Date date_created;
	private Date date_updated;
	private String brand;
	private String holder_name;
	private String first_digits;
	private String last_digits;
	private String fingerprint;
	private Client customer;
	private Boolean valid;
	private String card_number;
	private Date card_expiration_date ;
	private String expiration_date;
	private String customer_id;
	private String card_hash;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Date getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getHolder_name() {
		return holder_name;
	}
	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}
	public String getFirst_digits() {
		return first_digits;
	}
	public void setFirst_digits(String first_digits) {
		this.first_digits = first_digits;
	}
	public String getLast_digits() {
		return last_digits;
	}
	public void setLast_digits(String last_digits) {
		this.last_digits = last_digits;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public Client getCustomer() {
		return customer;
	}
	public void setCustomer(Client customer) {
		this.customer = customer;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public Date getCard_expiration_date() {
		return card_expiration_date;
	}
	public void setCard_expiration_date(Date card_expiration_date) {
		this.card_expiration_date = card_expiration_date;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCard_hash() {
		return card_hash;
	}
	public void setCard_hash(String card_hash) {
		this.card_hash = card_hash;
	}
}
