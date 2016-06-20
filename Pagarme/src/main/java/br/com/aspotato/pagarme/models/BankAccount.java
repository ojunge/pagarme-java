package br.com.aspotato.pagarme.models;

import java.sql.Timestamp;

public class BankAccount extends Model {
	
    private String object;
    private Integer id;
    private String bank_code;
    private String agencia;
    private String agencia_dv;
    private String conta;
    private String conta_dv;
    private String document_type;
    private String document_number;
    private String legal_name;
    private Timestamp date_created;
    private Timestamp date_updated;

    public String getObject() {
            return object;
    }
    public void setObject(String object) {
            this.object = object;
    }
    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }
    public String getBank_code() {
            return bank_code;
    }
    public void setBank_code(String bank_code) {
            this.bank_code = bank_code;
    }
    public String getAgencia() {
            return agencia;
    }
    public void setAgencia(String agencia) {
            this.agencia = agencia;
    }
    public String getAgencia_dv() {
            return agencia_dv;
    }
    public void setAgencia_dv(String agencia_dv) {
            this.agencia_dv = agencia_dv;
    }
    public String getConta() {
            return conta;
    }
    public void setConta(String conta) {
            this.conta = conta;
    }
    public String getConta_dv() {
            return conta_dv;
    }
    public void setConta_dv(String conta_dv) {
            this.conta_dv = conta_dv;
    }
    public String getDocument_type() {
            return document_type;
    }
    public void setDocument_type(String document_type) {
            this.document_type = document_type;
    }
    public String getDocument_number() {
            return document_number;
    }
    public void setDocument_number(String document_number) {
            this.document_number = document_number;
    }
    public String getLegal_name() {
            return legal_name;
    }
    public void setLegal_name(String legal_name) {
            this.legal_name = legal_name;
    }
    public Timestamp getDate_created() {
            return date_created;
    }
    public void setDate_created(Timestamp date_created) {
            this.date_created = date_created;
    }
    public Timestamp getDateUpdated() {
            return date_created;
    }
    public void setDate_updated(Timestamp dateUpdated) {
            this.date_updated = dateUpdated;
    }

    public String toString()    {
        return  "{" +
                "\n\"object\":\"" + this.getObject() + "\"," + 
                "\n\"id\":" + this.getId() + ", " +
                "\n\"bank_code\":\"" + this.getBank_code() + "\", " +
                "\n\"agencia\":\"" + this.getAgencia() + "\", " + 
                "\n\"agencia_dv\":\"" + this.getAgencia_dv() + "\", " +
                "\n\"conta\":\"" + this.getConta() + "\", " +
                "\n\"conta_dv\":" + this.getConta_dv() + ", " +
                "\n\"document_type\":\"" + this.getDocument_type() + "\", " +
                "\n\"document_number\":\"" + this.getDocument_number() + "\", " +
                "\n\"legal_name\":" + this.getLegal_name() + "\", " +
                "\n\"date_created\":" + this.getDate_created() + "\", " +
                "\n\"date_updated\":" + this.getDateUpdated()+ "\" " +
                "}";
    }
        
}
