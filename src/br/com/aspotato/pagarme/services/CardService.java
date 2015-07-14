package br.com.aspotato.pagarme.services;

import br.com.aspotato.pagarme.models.Card;
import br.com.aspotato.pagarme.utils.PagarMeProvider;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class CardService extends BasicService {


	private PagarMeProvider instance = PagarMeProvider.getInstance();

	public HttpResponse<JsonNode> save(Card card) throws Exception {
		HttpResponse<JsonNode> jsonResponse = null;
		if(validateFiels(card)){
			
			HttpRequestWithBody request =  Unirest.post(instance.getUrl() + "1/cards")
					.header("accept", "application/json")
					.queryString("api_key", instance.getApi_key());	

			jsonResponse = request.asJson();
		}

		return jsonResponse;
	}

}
