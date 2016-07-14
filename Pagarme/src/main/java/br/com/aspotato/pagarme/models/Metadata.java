/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aspotato.pagarme.models;

/**
 *
 * @author jeffprestes
 */
public class Metadata extends Model {
    
    String obs;
    String transactionInfo;

    public Metadata() {
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(String transactionInfo) {
        this.transactionInfo = transactionInfo;
    }
    
    
    
}
