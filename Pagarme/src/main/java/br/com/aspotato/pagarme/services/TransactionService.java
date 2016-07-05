package br.com.aspotato.pagarme.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import br.com.aspotato.pagarme.models.Key;
import br.com.aspotato.pagarme.models.Transaction;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import java.util.ArrayList;

public class TransactionService extends BasicService {
	
        private final String RESOURCE = "transactions"; 
	
	public ArrayList<Transaction> findAll() throws Exception {

		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/transactions")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		for (int i = 0; i < jsonResponse.getBody().getArray().length(); i++) {
			JSONObject resultObject = jsonResponse.getBody().getArray().getJSONObject(i);
			transactions.add((Transaction) PagarMeUtil.convertJsonToObject(Transaction.class, resultObject));
		}

		return transactions;
	}
	
	public Transaction findbyId(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/transactions/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		
		Transaction transaction = (Transaction) PagarMeUtil.convertJsonToObject(Transaction.class, resultObject);
		
		return transaction;
	}

	public Key generateCardHash() throws Exception {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/transactions/card_hash_key")
                            .header("accept", "application/json")
                            .queryString("encryption_key", instance.getEncryptionKey())
                            .asJson();
            JSONObject resultObject = jsonResponse.getBody().getObject();
            
            this.checkErrors(resultObject);
            return (Key) PagarMeUtil.convertJsonToObject(Key.class, resultObject);
            
        }
}
