/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aspotato.pagarme.models;

/**
 * Defines the a split rule of transaction
 * @author jeffprestes
 */
public class SplitRule {
    
    String recipient_id;
    boolean liable;
    int percentage;
    boolean charge_processing_fee;

    public SplitRule() {
    }

    public String getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
    }

    public boolean isLiable() {
        return liable;
    }

    public void setLiable(boolean liable) {
        this.liable = liable;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public boolean isCharge_processing_fee() {
        return charge_processing_fee;
    }

    public void setCharge_processing_fee(boolean charge_processing_fee) {
        this.charge_processing_fee = charge_processing_fee;
    }

    
    
}
