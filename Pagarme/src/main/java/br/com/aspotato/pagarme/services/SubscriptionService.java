package br.com.aspotato.pagarme.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import br.com.aspotato.pagarme.models.Subscription;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import java.util.ArrayList;

public class SubscriptionService extends BasicService {

	private PagarMeProvider instance = PagarMeProvider.getInstance();
	
	public ArrayList<Subscription> findAll() throws Exception {

		ArrayList<Subscription> subscriptions = new ArrayList<Subscription>();
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/subscriptions")
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		for (int i = 0; i < jsonResponse.getBody().getArray().length(); i++) {
			JSONObject resultObject = jsonResponse.getBody().getArray().getJSONObject(i);
			subscriptions.add((Subscription) PagarMeUtil.convertJsonToObject(Subscription.class, resultObject));
		}

		return subscriptions;
	}
	
	public Subscription findbyId(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/subscriptions/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		
		Subscription subscription = (Subscription) PagarMeUtil.convertJsonToObject(Subscription.class, resultObject);
		
		return subscription;
	}
}
