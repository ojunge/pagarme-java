package br.com.aspotato.pagarme.services;

import java.util.ArrayList;

import org.json.JSONObject;

import br.com.aspotato.pagarme.models.Transaction;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class TransactionService extends BasicService {
	
	private PagarMeProvider instance = PagarMeProvider.getInstance();
	
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

}
