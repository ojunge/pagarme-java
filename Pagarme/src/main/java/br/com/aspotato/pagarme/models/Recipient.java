/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aspotato.pagarme.models;

import java.sql.Date;

/**
 *
 * @author jeffprestes
 */
public class Recipient extends Model {
    
    private String object;
    private String id;
    private BankAccount bank_account;
    private int bank_account_id;
    private Boolean transfer_enabled;
    private String transfer_interval;
    private int transfer_day;
    private Date date_created;
    private Date date_updated;
    private Date last_transfer;

    public Recipient(String transfer_interval)  {
        this.transfer_interval = transfer_interval;
    }
    
    public Recipient()  {
        
    }
    
    /**
     * @return the object type
     */
    public String getObject() {
        return this.object;
    }

    /**
     * @param Object type that defines this Class
     */
    public void setObject(String object) {
        this.object = object;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the bank_account
     */
    public BankAccount getBankAccount() {
        return bank_account;
    }

    /**
     * @param bank_account the bank_account to set
     */
    public void setBank_account(BankAccount bank_account) {
        this.bank_account = bank_account;
    }

    /**
     * @return the bank account id
     */
    public int getBank_account_id() {
        return bank_account_id;
    }

    /**
     * @param bank_account_id
     */
    public void setBank_account_id(int bank_account_id) {
        this.bank_account_id = bank_account_id;
    }

    /**
     * @return the transfer_enabled
     */
    public Boolean getTransferEnabled() {
        return transfer_enabled;
    }

    /**
     * @param transfer_enabled the transfer_enabled to set
     */
    public void setTransfer_enabled(Boolean transfer_enabled) {
        this.transfer_enabled = transfer_enabled;
    }

    /**
     * @return the transfer_interval
     */
    public String getTransferInterval() {
        return transfer_interval;
    }

    /**
     * @param transfer_interval the transfer_interval to set
     */
    public void setTransfer_interval(String transfer_interval) {
        this.transfer_interval = transfer_interval;
    }

    /**
     * @return the transfer_day
     */
    public int getTransferDay() {
        return transfer_day;
    }

    /**
     * @param transfer_day the transfer_day to set
     */
    public void setTransfer_day(int transfer_day) {
        this.transfer_day = transfer_day;
    }

    /**
     * @return the date_created
     */
    public Date getDateCreated() {
        return date_created;
    }

    /**
     * @param date_created the date_created to set
     */
    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    /**
     * @return the date_updated
     */
    public Date getDateUpdated() {
        return date_updated;
    }

    /**
     * @param date_updated the date_updated to set
     */
    public void setDate_updated(Date date_updated) {
        this.date_updated = date_updated;
    }
    
    /**
     * @return the date of the last transfer to the Bank Account
     */
    public Date getLastTransfer() {
        return last_transfer;
    }

    /**
     * @param date of the last transfer to the Bank Account
     */
    public void setLast_transfer(Date datelt) {
        this.last_transfer = datelt;
    }
    
    
    public String toString()    {
        return  "{" +
                "\n\"object\":\"" + this.getObject() + "\"," + 
                "\n\"id\":\"" + this.getId() + "\", " +
                "\n\"bank_account\"" + this.getBankAccount().toString() + ", " +
                "\n\"transfer_enabled\":" + this.getTransferEnabled() + ", " +
                "\n\"last_transfer\":\"" + this.getLastTransfer() + "\", " +
                "\n\"transfer_interval\":\"" + this.getTransferInterval() + "\", " +
                "\n\"transfer_day\":" + this.getTransferDay() + ", " +
                "\n\"date_created\":" + this.getDateCreated() + "\", " +
                "\n\"date_updated\":" + this.getDateUpdated()+ "\" " +
                "}";
    }
    
}
