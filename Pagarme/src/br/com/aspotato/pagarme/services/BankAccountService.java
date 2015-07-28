package br.com.aspotato.pagarme.services;

import org.json.JSONObject;

import br.com.aspotato.pagarme.models.BankAccount;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class BankAccountService extends BasicService {

	private PagarMeProvider instance = PagarMeProvider.getInstance();

	public BankAccount findbyId(String id) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/bank_accounts/" + id)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		BankAccount result = (BankAccount) PagarMeUtil.convertJsonToObject(BankAccount.class, resultObject);
		return result;
	}

}
