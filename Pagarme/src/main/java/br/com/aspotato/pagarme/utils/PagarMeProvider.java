package br.com.aspotato.pagarme.utils;

public class PagarMeProvider {

    private static PagarMeProvider instance;

    private PagarMeProvider() {
    }

    private String url = "https://api.pagar.me/";
    private String api_key = "";
    private String api_version = "1/";
    private String encryption_key = "";

    public static PagarMeProvider getInstance() {
            if (instance == null)
                    instance = new PagarMeProvider();
            return instance;
    }

    public String getUrl() {
            return url;
    }

    public void setUrl(String url) {
            this.url = url;
    }

    public String getApi_key() {
            return api_key;
    }

    public void setApi_key(String api_key) {
            this.api_key = api_key;
    }

    /**
     * @return the api_version
     */
    public String getApiVersion() {
        return api_version;
    }

    /**
     * @param api_version the api_version to set
     */
    public void setApiVersion(String api_version) {
        this.api_version = api_version;
    }
    
    public String getBaseUrl()  {
        return this.getUrl() + this.getApiVersion();
    }

    public String getEncryptionKey() {
        return encryption_key;
    }

    public void setEncryption_key(String encryption_key) {
        this.encryption_key = encryption_key;
    }
    
    
}
