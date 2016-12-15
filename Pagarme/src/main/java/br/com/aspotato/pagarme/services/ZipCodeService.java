package br.com.aspotato.pagarme.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import br.com.aspotato.pagarme.models.ZipCode;
import br.com.aspotato.pagarme.utils.PagarMeProvider;
import br.com.aspotato.pagarme.utils.PagarMeUtil;

public class ZipCodeService {
	
	private PagarMeProvider instance = PagarMeProvider.getInstance();
	
	public ZipCode findbyCode(String code) throws Exception {
		HttpResponse<JsonNode> jsonResponse = Unirest.get(instance.getUrl() + "1/zipcodes/" + code)
				.header("accept", "application/json")
				.queryString("api_key", instance.getApi_key())
				.asJson();
		JSONObject resultObject = jsonResponse.getBody().getObject();
		ZipCode result = (ZipCode) PagarMeUtil.convertJsonToObject(ZipCode.class, resultObject);
		return result;
	}

}
