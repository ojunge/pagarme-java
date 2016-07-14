package br.com.aspotato.pagarme.models;

import java.sql.Timestamp;
import java.util.List;

public class Transaction extends Model {

    private String object;
    private String status;
    private String status_reason;
    private String acquirer_response_code;
    private String authorization_code;
    private String soft_descriptor;
    private Integer tid;
    private Integer nsu;
    private Timestamp date_created;
    private Timestamp date_updated;
    private Integer  amount;
    private Integer  id;
    private Integer  cost;
    private String  postback_url;
    private String  payment_method;
    private String  boleto_url;
    private String  boleto_barcode;
    private Timestamp  boleto_expiration_date;
    private String referer;
    private String ip;
    private Integer subscription_id;
    private Phone phone;
    private Address address;
    private Client customer;
    private Card card;
    private Metadata metadata;
    private List<SplitRule> splitRules;


    public String getObject() {
            return object;
    }
    public void setObject(String object) {
            this.object = object;
    }
    public String getStatus() {
            return status;
    }
    public void setStatus(String status) {
            this.status = status;
    }
    public String getStatus_reason() {
            return status_reason;
    }
    public void setStatus_reason(String status_reason) {
            this.status_reason = status_reason;
    }
    public String getAcquirer_response_code() {
            return acquirer_response_code;
    }
    public void setAcquirer_response_code(String acquirer_response_code) {
            this.acquirer_response_code = acquirer_response_code;
    }
    public String getAuthorization_code() {
            return authorization_code;
    }
    public void setAuthorization_code(String authorization_code) {
            this.authorization_code = authorization_code;
    }
    public String getSoft_descriptor() {
            return soft_descriptor;
    }
    public void setSoft_descriptor(String soft_descriptor) {
            this.soft_descriptor = soft_descriptor;
    }

    public Integer getNsu() {
            return nsu;
    }
    public void setNsu(Integer nsu) {
            this.nsu = nsu;
    }
    public Timestamp getDate_created() {
            return date_created;
    }
    public void setDate_created(Timestamp date_created) {
            this.date_created = date_created;
    }
    public Timestamp getDate_updated() {
            return date_updated;
    }
    public void setDate_updated(Timestamp date_updated) {
            this.date_updated = date_updated;
    }
    public Integer getAmount() {
            return amount;
    }
    public void setAmount(Integer amount) {
            this.amount = amount;
    }
    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }
    public Integer getCost() {
            return cost;
    }
    public void setCost(Integer cost) {
            this.cost = cost;
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
    public String getBoleto_url() {
            return boleto_url;
    }
    public void setBoleto_url(String boleto_url) {
            this.boleto_url = boleto_url;
    }
    public String getBoleto_barcode() {
            return boleto_barcode;
    }
    public void setBoleto_barcode(String boleto_barcode) {
            this.boleto_barcode = boleto_barcode;
    }
    public Timestamp getBoleto_expiration_date() {
            return boleto_expiration_date;
    }
    public void setBoleto_expiration_date(Timestamp boleto_expiration_date) {
            this.boleto_expiration_date = boleto_expiration_date;
    }
    public String getReferer() {
            return referer;
    }
    public void setReferer(String referer) {
            this.referer = referer;
    }
    public String getIp() {
            return ip;
    }
    public void setIp(String ip) {
            this.ip = ip;
    }
    public Integer getSubscription_id() {
            return subscription_id;
    }
    public void setSubscription_id(Integer subscription_id) {
            this.subscription_id = subscription_id;
    }
    public Phone getPhone() {
            return phone;
    }
    public void setPhone(Phone phone) {
            this.phone = phone;
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
    public Integer getTid() {
        return tid;
    }
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<SplitRule> getSplitRules() {
        return splitRules;
    }

    public void setSplitRules(List<SplitRule> splitRules) {
        this.splitRules = splitRules;
    }
    
    
}
