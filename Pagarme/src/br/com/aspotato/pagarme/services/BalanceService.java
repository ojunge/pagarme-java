package br.com.aspotato.pagarme.services;

import org.json.JSONObject;

import br.com.aspotato.pagarme.models.Balance;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class BalanceService extends BasicService {

	private PagarMeProvider instance = PagarMeProvider.getInstance();
	
	public Balance get() throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/balance/")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		
	Balance balance = (Balance) PagarMeUtil.convertJsonToObject(Balance.class, resultObject);
		
		return balance;
	}
}
