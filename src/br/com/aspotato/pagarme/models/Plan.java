package br.com.aspotato.pagarme.models;

import br.com.aspotato.pagarme.anotations.FieldRequired;

public class Plan extends Model {
	
	@FieldRequired
	private String name;
	@FieldRequired
	private Double amount;
	@FieldRequired
	private int days;
	private int trial_days;

	public String getName() {
	    return name;
    }
	public void setName(String name) {
	    this.name = name;
    }
	public Double getAmount() {
	    return amount;
    }
	public void setAmount(Double amount) {
	    this.amount = amount;
    }
	public int getDays() {
	    return days;
    }
	public void setDays(int days) {
	    this.days = days;
    }
	public int getTrial_days() {
	    return trial_days;
    }
	public void setTrial_days(int trial_days) {
	    this.trial_days = trial_days;
    }

}
