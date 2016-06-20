package br.com.aspotato.pagarme.models;

import br.com.aspotato.pagarme.anotations.FieldRequired;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Client extends Model {
	
	private Integer id;
	private String document_number;
	@FieldRequired
	private String name;
	@FieldRequired
	private String email;
	private Date born_at;
	private String gender;
	@FieldRequired
	private String ddi;
	@FieldRequired
	private String ddd;
	@FieldRequired
	private Timestamp date_created;
	
	private ArrayList<Address> phones = new ArrayList<Address>();
	
	private ArrayList<Address> addresses = new ArrayList<Address>();
	
	
	public String getDocument_number() {
		return document_number;
	}
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBorn_at() {
		return born_at;
	}
	public void setBorn_at(Date born_at) {
		this.born_at = born_at;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public ArrayList<Address> getAddresses() {
	    return addresses;
    }
	public void setAddresses(ArrayList<Address> addresses) {
	    this.addresses = addresses;
    }
	public Integer getId() {
	    return id;
    }
	public void setId(Integer id) {
	    this.id = id;
    }
	public Timestamp getDate_created() {
	    return date_created;
    }
	public void setDate_created(Timestamp date_created) {
	    this.date_created = date_created;
    }
	public ArrayList<Address> getPhones() {
	    return phones;
    }
	public void setPhones(ArrayList<Address> phones) {
	    this.phones = phones;
    }

}
