package br.com.aspotato.pagarme.models;

import br.com.aspotato.pagarme.anotations.FieldRequired;

public class Address extends Model {
	private Integer id;
	private String object;
	private String street;
	private String complementary;
	@FieldRequired
	private String street_number;
	@FieldRequired
	private String neighborhood;
	private String city;
	private String state;
	@FieldRequired
	private String zipcode;
	private String country;
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getComplementary() {
		return complementary;
	}
	public void setComplementary(String complementary) {
		this.complementary = complementary;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getId() {
	    return id;
    }
	public void setId(Integer id) {
	    this.id = id;
    } 
}
