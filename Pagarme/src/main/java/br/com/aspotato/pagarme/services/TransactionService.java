package br.com.aspotato.pagarme.services;

import br.com.aspotato.pagarme.exceptions.InvalidFormatException;
import br.com.aspotato.pagarme.exceptions.SubmitException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import br.com.aspotato.pagarme.models.Key;
import br.com.aspotato.pagarme.models.Transaction;
import br.com.aspotato.pagarme.utils.PagarMeUtil;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONException;

public class TransactionService extends BasicService {
	
    private final String RESOURCE = "transactions"; 

    public ArrayList<Transaction> findAll() throws Exception {

            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getBaseUrl() + RESOURCE)
                            .header("accept", "application/json")
                            .queryString("api_key", instance.getApi_key())
                            .asJson();
            for (int i = 0; i < jsonResponse.getBody().getArray().length(); i++) {
                    JSONObject resultObject = jsonResponse.getBody().getArray().getJSONObject(i);
                    transactions.add((Transaction) PagarMeUtil.convertJsonToObject(Transaction.class, resultObject));
            }

            return transactions;
    }
    
    /**
     * Execute a transaction
     * @param request Transaction data to be performed
     * @return Transaction object returned from Pagar.me
     */
    public Transaction executeTransaction(Transaction request) throws   IllegalAccessException
                                                                        , UnirestException
                                                                        , InvalidFormatException
                                                                        , SubmitException
                                                                        , InstantiationException
                                                                        , JSONException
                                                                        , ParseException      {
        
        JSONObject obj = this.postToRemoteResource(RESOURCE, request);
        return (Transaction) PagarMeUtil.convertJsonToObject(Transaction.class, obj);
        
    }

    /**
     * Find a transaction
     * @param id Transaction ID
     * @return Transaction Data
     * @throws UnirestException
     * @throws IllegalAccessException
     * @throws InvalidFormatException
     * @throws SubmitException
     * @throws InstantiationException
     * @throws JSONException
     * @throws ParseException 
     */
    public Transaction findbyId(String id) throws   UnirestException
                                                    , IllegalAccessException
                                                    , InvalidFormatException
                                                    , SubmitException
                                                    , InstantiationException
                                                    , JSONException
                                                    , ParseException  {

        Transaction transaction = (Transaction) this.getDataFromRemoteResouceWithId(Transaction.class, RESOURCE, id);

        return transaction;
    }

    /**
     * Estornar a transaction
     * @param idTransaction identificação da transação
     * @return
     * @throws IllegalAccessException
     * @throws UnirestException
     * @throws InvalidFormatException
     * @throws SubmitException
     * @throws InstantiationException
     * @throws JSONException
     * @throws ParseException
     */
    public Transaction refundTransaction(int idTransaction) throws IllegalAccessException
                                                                    , UnirestException
                                                                    , InvalidFormatException
                                                                    , SubmitException
                                                                    , InstantiationException
                                                                    , JSONException
                                                                    , ParseException      {
        String refundEndpoint = RESOURCE + String.format("/%d/refund", idTransaction);
        HttpResponse<JsonNode> jsonResponse = Unirest.post(instance.getBaseUrl() + refundEndpoint)
                .header("accept", "application/json")
                .queryString("encryption_key", instance.getEncryptionKey())
                .field("api_key", instance.getApi_key())
                .asJson();
        JSONObject resultObject = jsonResponse.getBody().getObject();

        this.checkErrors(resultObject);
        return (Transaction) PagarMeUtil.convertJsonToObject(Transaction.class, resultObject);
    }

}
